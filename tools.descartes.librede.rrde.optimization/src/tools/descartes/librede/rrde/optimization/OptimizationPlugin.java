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
package tools.descartes.librede.rrde.optimization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import tools.descartes.librede.Librede;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.approach.LiuOptimizationApproach;
import tools.descartes.librede.approach.MenasceOptimizationApproach;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.exceptions.EstimationException;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.algorithm.IConfigurationOptimizer;
import tools.descartes.librede.rrde.util.Discovery;
import tools.descartes.librede.rrde.util.Util;
import tools.descartes.librede.rrde.util.Wrapper;

/**
 * The main class of this Plug-In. Here, the configuration files are read, and
 * the {@link RunCall}s scheduled and executed.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class OptimizationPlugin implements IApplication {

	/**
	 * The logging level for all classes of this package
	 */
	private static final Level loglevel = Level.WARN;

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(OptimizationPlugin.class);

	/**
	 * The path to the default {@link LibredeConfiguration}
	 */
	public final static String LIB_PATH = ".." + File.separator + "tools.descartes.librede.rrde" + File.separator
			+ "resources" + File.separator + "estimation.librede";

	/**
	 * The path to the default {@link OptimizationConfiguration}
	 */
	public final static String CONF_PATH = ".." + File.separator + "tools.descartes.librede.rrde" + File.separator
			+ "resources" + File.separator + "test" + File.separator + "src" + File.separator + "conf.optimization";

	/**
	 * The output path, where all output files are stored.
	 */
	public final static String OUTPUT = ".." + File.separator + "tools.descartes.librede.rrde" + File.separator
			+ "output";

	@Override
	public Object start(IApplicationContext context) throws Exception {
		initLogging();
		Wrapper.init();
		try {
			// load config files
			LibredeConfiguration librede = Librede.loadConfiguration(new File(LIB_PATH).toPath());
			OptimizationConfiguration conf = Util.loadOptimizationConfiguration(new File(CONF_PATH).toPath());

			// run optimization
			runConfigurationOptimization(librede, conf, OUTPUT);

		} catch (Exception e) {
			log.error("Error occurred", e);
		}
		log.info("Finished optimization.");
		return 0;
	}

	@Override
	public void stop() {
		// do nothing
	}

	/**
	 * Has the same effect as
	 * <code>runConfigurationOptimization(null, conf, null)</code>. It runs the
	 * optimizations without storing the results as a file.
	 * 
	 * @see Plugin#runConfigurationOptimization(LibredeConfiguration,
	 *      OptimizationConfiguration, String).
	 * 
	 * @param conf
	 *            The {@link OptimizationConfiguration}, specifying the desired
	 *            optimizations
	 * @return The collection of the optimized {@link EstimationSpecification}s
	 *         as read in the configurations file like they are stored in the
	 *         output folder. Note that the timestamps for start and ending are
	 *         not yet fixed so a call of
	 *         {@link Discovery#fixTimeStamps(LibredeConfiguration)} is usually
	 *         required.
	 */
	public Collection<EstimationSpecification> runConfigurationOptimization(OptimizationConfiguration conf) {
		return runConfigurationOptimization(null, conf, null);
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
	 * @return The collection of the optimized {@link EstimationSpecification}s
	 *         as read in the configurations file like they are stored in the
	 *         output folder. Note that the timestamps for start and ending are
	 *         not yet fixed so a call of
	 *         {@link Discovery#fixTimeStamps(LibredeConfiguration)} is usually
	 *         required.
	 * 
	 */
	public Collection<EstimationSpecification> runConfigurationOptimization(LibredeConfiguration librede,
			OptimizationConfiguration conf, String outputDir) {

		Objects.requireNonNull(conf.getContainsOf());
		if (conf.getContainsOf().isEmpty()) {
			log.warn("The were no RunCalls specified. Returning null.");
			return null;
		}
		if (outputDir != null) {
			Objects.requireNonNull(librede,
					"The skeleton configuration must not be null, if output configurations are desired.");
		}

		// split one RunCall with several approaches into multiple RunCalls with
		// just one approach each, since the framework can not handle multiple
		// right now, since e.g. StepSize applies for all approaches at once
		ArrayList<RunCall> newRunCalls = Util.splitRunCalls(conf);
		conf.getContainsOf().addAll(newRunCalls);

		// execute Calls
		HashMap<RunCall, EstimationSpecification> results = collectResults(conf.getContainsOf());

		// store each specification in a different file
		if (outputDir != null) {
			int i = 0;
			for (EstimationSpecification spec : results.values()) {
				String name = outputDir + File.separator + "Optimized_RunCall" + i++ + "_"
						+ spec.getApproaches().get(0).getType().replace("tools.descartes.librede.approach.", "")
						+ ".librede";
				store(spec, librede, name);
			}
		}
		return results.values();
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
	private void store(EstimationSpecification result, LibredeConfiguration conf, String file) {
		// create configuration
		LibredeConfiguration output = EcoreUtil.copy(conf);
		output.setEstimation(EcoreUtil.copy(result));
		// fix timestamps for valid output
		Discovery.fixTimeStamps(output);

		// write to file
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(file);
		Resource resource = rs.createResource(uri);

		resource.getContents().add(output);
		Map<Object, Object> saveOptions = ((XMLResource) resource).getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE, new ArrayList<Object>());
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Concurrently executes the given {@link RunCall}s and returns a map with
	 * the corresponding results.
	 * 
	 * @param calls
	 *            A Collection of {@link RunCall}s to execute
	 * @return A Map, assigning each {@link RunCall} its result as an
	 *         {@link EstimationSpecification}
	 */
	public HashMap<RunCall, EstimationSpecification> collectResults(Collection<RunCall> calls) {
		// Run each RunCall separately and concurrently
		ExecutorService pool = Executors.newCachedThreadPool();
		ExecutorService fixedpool = Executors.newFixedThreadPool(1);
		HashMap<RunCall, Future<EstimationSpecification>> results = new HashMap<RunCall, Future<EstimationSpecification>>();
		for (RunCall call : calls) {

			// do sanity check
			if (call.getAlgorithm() == null || call.getEstimation() == null || call.getSettings() == null
					|| call.getTrainingData() == null) {
				log.warn("The RunCall " + call + " was not properly configured. Skipping over this run.");
				continue;
			}

			// catch optimization as they do not run concurrently and execute
			// them
			// sequentially
			if (call.getEstimation().getApproaches().get(0).getType().equals(LiuOptimizationApproach.class.getName())
					|| call.getEstimation().getApproaches().get(0).getType()
							.equals(MenasceOptimizationApproach.class.getName())) {
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
				if (res.get(call) == null) {
					log.warn(
							"The optimization of the specification failed and returned null. Therefore the unmodified specification is returned.");
					res.put(call, call.getEstimation());
				}
			} catch (CancellationException e) {
				log.error("RunCall got cancelled.", e);
			} catch (InterruptedException e) {
				log.error("Waiting for an unfinished RunCall failed and was interrupted", e);
			} catch (ExecutionException e) {
				log.error("Executing a RunCall threw the following exception", e);
			}
		}

		return res;
	}

	/**
	 * Initializes the logging for better readability.
	 */
	public void initLogging() {
		Librede.initLogging();
		LogManager.getRootLogger().setLevel(loglevel);
		Logger.getLogger(tools.descartes.librede.Librede.class.getPackage().getName()).setLevel(Level.WARN);
		Logger.getLogger(this.getClass().getPackage().getName()).setLevel(loglevel);
		Logger.getLogger(tools.descartes.librede.rrde.rinterface.RBridge.class.getPackage().getName())
				.setLevel(loglevel);
	}

	/**
	 * Internal class, that executes a {@link RunCall} and implements the
	 * {@link Callable} interface.
	 * 
	 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
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
			Objects.requireNonNull(call, "The RunCall must not be null.");
			Objects.requireNonNull(call.getAlgorithm(), "The specified algorithm must not be null.");
			Objects.requireNonNull(call.getAlgorithm().getAlgorithmName(),
					"The specified algorithm description must not be null.");
			Objects.requireNonNull(call.getEstimation(), "The specified estimation must not be null.");
			Objects.requireNonNull(call.getSettings(), "The specified settings must not be null.");
			Objects.requireNonNull(call.getTrainingData(), "The specified training data must not be null.");
			if (call.getAlgorithm().getAlgorithmName().isEmpty()) {
				log.error("No algorithm was defined. Terminated.");
				return null;
			}
			IConfigurationOptimizer algo = (IConfigurationOptimizer) Class
					.forName(call.getAlgorithm().getAlgorithmName()).newInstance();
			algo.optimizeConfiguration(call.getEstimation(), call.getTrainingData(), call.getSettings(),
					call.getAlgorithm());
			return algo.getResult();
		}

	}

}
