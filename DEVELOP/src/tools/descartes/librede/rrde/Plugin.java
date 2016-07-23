/**
 * ==============================================
 *  LibReDE : Library for Resource Demand Estimation
 * ==============================================
 *
 * (c) Copyright 2013-2014, by Simon Spinner and Contributors.
 *
 * Project Info:   http://www.descartes-research.net/
 *
 * All rights reserved. This software is made available under the terms of the
 * Eclipse Public License (EPL) v1.0 as published by the Eclipse Foundation
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * This software is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License (EPL)
 * for more details.
 *
 * You should have received a copy of the Eclipse Public License (EPL)
 * along with this software; if not visit http://www.eclipse.org or write to
 * Eclipse Foundation, Inc., 308 SW First Avenue, Suite 110, Portland, 97204 USA
 * Email: license (at) eclipse.org
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 */
package tools.descartes.librede.rrde;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import tools.descartes.librede.Librede;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.exceptions.EstimationException;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.optimization.IConfigurationOptimizer;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.RunCall;

/**
 * The main class of this Plug-In. Here, the configuration files are read, and
 * the {@link RunCall}s scheduled and executed.
 * 
 * @author JS
 *
 */
public class Plugin implements IApplication {

	/**
	 * The logging level for all classes of this package
	 */
	private static final Level loglevel = Level.TRACE;

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(Plugin.class);

	/**
	 * The path to the default {@link LibredeConfiguration}
	 */
	public final static String LIB_PATH = "resources" + File.separator
			+ "estimation.librede";

	/**
	 * The path to the default {@link OptimizationConfiguration}
	 */
	public final static String CONF_PATH = "resources" + File.separator
			+ "test" + File.separator + "src" + File.separator
			+ "conf.optimization";

	/**
	 * The output path, where all output files are stored.
	 */
	public final static String OUTPUT = "output";

	@Override
	public Object start(IApplicationContext context) throws Exception {
		initLogging();
		Wrapper.init();
		try {
			// load config files
			LibredeConfiguration librede = Librede.loadConfiguration(new File(
					LIB_PATH).toPath());
			OptimizationConfiguration conf = loadConfiguration(new File(
					CONF_PATH).toPath());

			// This is a fixup to replace the data sources with ones from
			// librede.
			for (RunCall call : conf.getContainsOf()) {
				for (InputData spec : call.getTrainingData()) {
					spec.getInputSpecification()
							.getDataSources()
							.get(0)
							.getParameters()
							.addAll(librede.getInput().getDataSources().get(0)
									.getParameters());
				}
			}

			// run optimization
			runConfigurationOptimization(librede, conf, OUTPUT);

		} catch (Exception e) {
			log.error("Error occurred", e);
		}
		log.info("Finished optimization.");
		return null;
	}

	@Override
	public void stop() {
		// do nothing
	}

	/**
	 * Runs an optimization of the {@link EstimationSpecification} of the given
	 * {@link OptimizationConfiguration} and sets is as a result in one or many
	 * {@link LibredeConfiguration}. For this purpose, the given configuration
	 * is copied and altered. As a result, the initial
	 * {@link EstimationSpecification} is only dependent on the
	 * {@link OptimizationConfiguration}, not on the
	 * {@link LibredeConfiguration}. <br>
	 * <br>
	 * As of now, multiple {@link RunCall}s are executed independently and are
	 * all producing different output files. Additionally, for multiple
	 * {@link IEstimationApproach}es defined in one {@link RunCall}, this call
	 * is split up into several identical {@link RunCall}s, each containing only
	 * one {@link IEstimationApproach} to optimize at a time.<br>
	 * <br>
	 * The (multiple) resulting {@link LibredeConfiguration}s are stored as
	 * separate files with corresponding suffixes.<br>
	 * <br>
	 * This method tries to use parallel execution for different independent
	 * {@link RunCall}s as far as possible.
	 * 
	 * @param librede
	 *            The LibReDE configuration to use as skeleton for the outputs
	 * @param conf
	 *            The {@link OptimizationConfiguration}, specifying the desired
	 *            optimizations
	 * @param outputDir
	 *            The String of the output directory used for modified
	 *            {@link LibredeConfiguration} files.
	 */
	public void runConfigurationOptimization(LibredeConfiguration librede,
			OptimizationConfiguration conf, String outputDir) {

		// split one RunCall with several approaches into multiple RunCalls with
		// just one approach each, since the framework can not handle multiple
		// right now, since e.g. StepSize applies for all approaches at once
		ArrayList<RunCall> newRunCalls = new ArrayList<RunCall>();
		for (RunCall call : conf.getContainsOf()) {
			if (call.getEstimationSpecification().getApproaches().size() > 1) {
				// split up
				for (EstimationApproachConfiguration approach : call
						.getEstimationSpecification().getApproaches()) {
					// deep copy
					RunCall newCall = EcoreUtil.copy(call);

					newCall.setEstimationSpecification(EcoreUtil.copy(call
							.getEstimationSpecification()));

					newCall.getEstimationSpecification().getApproaches()
							.clear();
					newCall.getEstimationSpecification().getApproaches()
							.add(EcoreUtil.copy(approach));

					newRunCalls.add(newCall);
				}
			} else {
				newRunCalls.add(call);
			}
		}
		conf.getContainsOf().clear();
		conf.getContainsOf().addAll(newRunCalls);

		// execute Calls
		HashMap<RunCall, EstimationSpecification> results = collectResults(conf
				.getContainsOf());

		// merge the obtained results into one EstimationSpecification
		// no merging, storing as different files instead
		// try {
		// mergeNumericParameter(librede, results, StepSize.class.getName());
		// mergeNumericParameter(librede, results, WindowSize.class.getName());
		// } catch (InstantiationException | IllegalAccessException e) {
		// log.error("Merging optimization results encountered an error.", e);
		// }

		// store each specification in a different file
		int i = 0;
		for (EstimationSpecification spec : results.values()) {
			String name = outputDir
					+ File.separator
					+ "Optimized_RunCall"
					+ i++
					+ "_"
					+ spec.getApproaches().get(0).getType()
							.replace("tools.descartes.librede.approach.", "")
					+ ".librede";
			store(spec, librede, name);
		}

	}

	/**
	 * Stores the given {@link LibredeConfiguration}, but removes its
	 * {@link EstimationSpecification} with the given one.
	 * 
	 * @param result
	 *            The {@link EstimationException} to use
	 * @param conf
	 *            The {@link LibredeConfiguration} as skeleton
	 * @param file
	 *            The path to be used as output
	 * @throws RuntimeException
	 *             If the storing fails for some reason
	 */
	private void store(EstimationSpecification result,
			LibredeConfiguration conf, String file) {
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(file);
		Resource resource = rs.createResource(uri);
		LibredeConfiguration output = EcoreUtil.copy(conf);
		output.setEstimation(result);
		resource.getContents().add(output);
		Map<Object, Object> saveOptions = ((XMLResource) resource)
				.getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE,
				new ArrayList<Object>());
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// private void mergeNumericParameter(LibredeConfiguration librede,
	// HashMap<RunCall, EstimationSpecification> results, String eClass)
	// throws InstantiationException, IllegalAccessException {
	// HashMap<RunCall, EstimationSpecification> tmp = new HashMap<RunCall,
	// EstimationSpecification>();
	// for (RunCall result : results.keySet()) {
	// // look through all results with given parameter
	// for (IOptimizableParameter para : result.getSettings()
	// .getParametersToOptimize()) {
	// if (para.getClass().getInterfaces()[0].getName().equals(eClass)) {
	// tmp.put(result, results.get(result));
	// }
	// }
	// }
	// // retrieve results
	// HashSet<Double> nums = retrieveNumerics(tmp, eClass);
	// if (nums.isEmpty()) {
	// log.warn("No numeric results for merging " + eClass + ".");
	// return;
	// } else if (nums.size() > 1) {
	// // multiple values
	// DescriptiveStatistics stat = new DescriptiveStatistics();
	// for (Double d : nums)
	// stat.addValue(d);
	// log.warn("There were multiple results for the single parameter "
	// + eClass + ". Using the average of " + stat.getMean()
	// + " as final result.");
	// Util.setValue(librede, stat.getMean(), eClass);
	// } else {
	// // there is exactly one value
	// Util.setValue(librede, nums.iterator().next(), eClass);
	// }
	// }
	//
	// private HashSet<Double> retrieveNumerics(
	// HashMap<RunCall, EstimationSpecification> results, String eClass)
	// throws InstantiationException, IllegalAccessException {
	// HashSet<Double> nums = new HashSet<Double>();
	//
	// for (EstimationSpecification result : results.values()) {
	// // switch all known types of optimization
	// if (eClass.equals(StepSize.class.getName())) {
	// nums.add(result.getStepSize().getValue());
	// } else if (eClass.equals(WindowSize.class.getName())) {
	// nums.add(new Double(result.getWindow()));
	// } else if (eClass.equals(GenericParameter.class.getName())) {
	// log.warn("The merging of GenericParameter is not supported and will be ignored.");
	// } else {
	// log.error("No handling adapter of merging OptimizableParameter "
	// + eClass);
	// }
	// }
	//
	// return nums;
	// }

	/**
	 * Concurrently executes the given {@link RunCall}s and returns a map with
	 * the corresponding results.
	 * 
	 * @param calls
	 *            A Collection of {@link RunCall}s to execute
	 * @return A Map, assigning each {@link RunCall} its result as an
	 *         {@link EstimationSpecification}
	 */
	public HashMap<RunCall, EstimationSpecification> collectResults(
			Collection<RunCall> calls) {
		// Run each RunCall separately and concurrently
		ExecutorService pool = Executors.newCachedThreadPool();
		ExecutorService fixedpool = Executors.newFixedThreadPool(1);
		HashMap<RunCall, Future<EstimationSpecification>> results = new HashMap<RunCall, Future<EstimationSpecification>>();
		for (RunCall call : calls) {
			// catch optimization as they do not run concurrently and execute
			// them
			// sequentially
			if (call.getEstimationSpecification()
					.getApproaches()
					.get(0)
					.getType()
					.equals("tools.descartes.librede.approach.LiuOptimizationApproach")
					|| call.getEstimationSpecification()
							.getApproaches()
							.get(0)
							.getType()
							.equals("tools.descartes.librede.approach.MenasceOptimizationApproach")) {
				// shutdown and restart
				results.put(call, fixedpool.submit(new RunCallExecutor(call)));
				fixedpool.shutdown();
				while (!fixedpool.isTerminated()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						log.error("Execution was interrupted.", e);
					}
				}
				fixedpool = Executors.newFixedThreadPool(1);
			} else {
				results.put(call, pool.submit(new RunCallExecutor(call)));
			}
		}
		pool.shutdown();

		HashMap<RunCall, EstimationSpecification> res = new HashMap<RunCall, EstimationSpecification>();

		for (RunCall call : results.keySet()) {
			try {
				// wait for the first call, the others should work concurrently
				// and already been done by then
				res.put(call, results.get(call).get());
			} catch (CancellationException e) {
				log.error("RunCall got cancelled.", e);
			} catch (InterruptedException e) {
				log.error(
						"Waiting for an unfinished RunCall failed and was interrupted",
						e);
			} catch (ExecutionException e) {
				log.error("Executing a RunCall threw the following exception",
						e);
			}
		}

		return res;
	}

	/**
	 * Loads the given path as a {@link OptimizationConfiguration}
	 * configuration, if one is found.
	 * 
	 * @param path
	 *            The Path to the configuration file
	 * @return The specified {@link OptimizationConfiguration}
	 * @throws Exception
	 *             If something in the loading process fails
	 */
	public static OptimizationConfiguration loadConfiguration(Path path) {
		ResourceSet resourceSet = Registry.INSTANCE.createResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("optimization", new XMIResourceFactoryImpl());
		File configFile = new File(path.toString());
		URI fileURI = URI.createFileURI(configFile.getAbsolutePath());
		org.eclipse.emf.ecore.resource.Resource resource = resourceSet
				.getResource(fileURI, true);
		EcoreUtil.resolveAll(resource);
		return (OptimizationConfiguration) resource.getContents().get(0);
	}

	/**
	 * Initializes the logging for better readability.
	 */
	public void initLogging() {
		Librede.initLogging();
		LogManager.getRootLogger().setLevel(loglevel);
		Logger.getLogger(
				tools.descartes.librede.Librede.class.getPackage().getName())
				.setLevel(Level.WARN);
		Logger.getLogger(
				tools.descartes.librede.rrde.Plugin.class.getPackage()
						.getName()).setLevel(loglevel);

	}

	/**
	 * Internal class, that executes a {@link RunCall} and implements the
	 * {@link Callable} interface.
	 * 
	 * @author JS
	 *
	 */
	private class RunCallExecutor implements Callable<EstimationSpecification> {

		private RunCall call;

		/**
		 * @param call
		 */
		public RunCallExecutor(RunCall call) {
			super();
			this.call = call;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.concurrent.Callable#call()
		 */
		@Override
		public EstimationSpecification call() throws Exception {
			log.trace("Executing Call: " + call.toString());
			IConfigurationOptimizer algo = (IConfigurationOptimizer) Class
					.forName(call.getAlgorithm().getAlgorithmName())
					.newInstance();
			algo.optimizeConfiguration(call.getEstimationSpecification(),
					call.getTrainingData(), call.getSettings(),
					call.getAlgorithm());
			return algo.getResult();
		}

	}

}
