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
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.optimization.GenericParameter;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.StepSize;
import tools.descartes.librede.rrde.optimization.WindowSize;
import tools.descartes.librede.rrde.optimization.impl.HillClimbingAlgorithm;
import tools.descartes.librede.rrde.optimization.impl.StepSizeImpl;
import tools.descartes.librede.rrde.optimization.impl.WindowSizeImpl;

/**
 * The main class of this Plug-In. TODO comment
 * 
 * @author JS
 *
 */
public class Plugin implements IApplication {

	private static final Logger log = Logger.getLogger(Plugin.class);

	public final static String LIB_PATH = "resources/estimation.librede";

	public final static String CONF_PATH = "resources/test/src/conf.optimization";

	@Override
	public Object start(IApplicationContext context) throws Exception {
		initLogging();
		Wrapper.init();
		try {
			// load config files
			LibredeConfiguration configuration = Librede
					.loadConfiguration(new File(LIB_PATH).toPath());
			OptimizationConfiguration conf = loadConfiguration(new File(
					CONF_PATH).toPath());

			// run optimization
			runConfigurationOptimization(configuration, conf);

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
	 * TODO
	 * 
	 * @param librede
	 * @param conf
	 */
	public void runConfigurationOptimization(LibredeConfiguration librede,
			OptimizationConfiguration conf) {
		if (conf.getContainsOf().size() > 1) {
			log.error("As of now, only one RunCall is supported to avoid merge conflicts. Therefore, only the first one will be executed.");
			conf.getContainsOf().retainAll(conf.getContainsOf().subList(0, 1));
		}

		// split one RunCall with several approaches into multiple RunCalls with
		// just one approach each, since the framework can not handle multiple
		// right now, since e.g. StepSize applies for all approaches at once
		ArrayList<RunCall> newRunCalls = new ArrayList<RunCall>();
		for (RunCall call : conf.getContainsOf()) {
			if (call.getEstimationSpecification().getApproaches().size() > 1) {
				// split up
				for (EstimationApproachConfiguration approach : call
						.getEstimationSpecification().getApproaches()) {
					RunCall newCall = EcoreUtil.copy(call);
					ArrayList<EstimationApproachConfiguration> doNotRemove = new ArrayList<EstimationApproachConfiguration>();
					doNotRemove.add(approach);
					newCall.getEstimationSpecification().getApproaches()
							.retainAll(doNotRemove);
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
		try {
			mergeNumericParameter(librede, results, StepSize.class.getName());
			mergeNumericParameter(librede, results, WindowSize.class.getName());
		} catch (InstantiationException | IllegalAccessException e) {
			log.error("Merging optimization results encountered an error.", e);
		}

		// TODO merge runCalls
	}

	private void mergeNumericParameter(LibredeConfiguration librede,
			HashMap<RunCall, EstimationSpecification> results, String eClass)
			throws InstantiationException, IllegalAccessException {
		HashMap<RunCall, EstimationSpecification> tmp = new HashMap<RunCall, EstimationSpecification>();
		for (RunCall result : results.keySet()) {
			// look through all results with given parameter
			for (IOptimizableParameter para : result.getSettings()
					.getParametersToOptimize()) {
				if (para.getClass().getInterfaces()[0].getName().equals(eClass)) {
					tmp.put(result, results.get(result));
				}
			}
		}
		// retrieve results
		HashSet<Double> nums = retrieveNumerics(tmp, eClass);
		if (nums.isEmpty()) {
			log.warn("No numeric results for merging " + eClass + ".");
			return;
		} else if (nums.size() > 1) {
			// multiple values
			DescriptiveStatistics stat = new DescriptiveStatistics();
			for (Double d : nums)
				stat.addValue(d);
			log.warn("There were multiple results for the single parameter "
					+ eClass + ". Using the average of " + stat.getMean()
					+ " as final result.");
			setValue(librede, stat.getMean(), eClass);
		} else {
			// there is exactly one value
			setValue(librede, nums.iterator().next(), eClass);
		}
	}

	private HashSet<Double> retrieveNumerics(
			HashMap<RunCall, EstimationSpecification> results, String eClass)
			throws InstantiationException, IllegalAccessException {
		HashSet<Double> nums = new HashSet<Double>();

		for (EstimationSpecification result : results.values()) {
			// switch all known types of optimization
			if (eClass.equals(StepSize.class.getName())) {
				nums.add(result.getStepSize().getValue());
			} else if (eClass.equals(WindowSize.class.getName())) {
				nums.add(new Double(result.getWindow()));
			} else if (eClass.equals(GenericParameter.class.getName())) {
				log.warn("The merging of GenericParameter is not supported and will be ignored.");
			} else {
				log.error("No handling adapter of merging OptimizableParameter "
						+ eClass);
			}
		}

		return nums;
	}

	private void setValue(LibredeConfiguration librede, double value,
			String eClass) {
		if (eClass.equals(StepSize.class.getName())) {
			librede.getEstimation().getStepSize().setValue(value);
			log.info("Set Stepsize to " + value);
		} else if (eClass.equals(WindowSize.class.getName())) {
			int integer = (int) Math.round(value);
			if (integer != value) {
				log.warn("The value "
						+ value
						+ " is not an Integer and had to be rounded to fit as window size.");
			}
			librede.getEstimation().setWindow(integer);
			log.info("Set Windowsize to " + integer);
		} else if (eClass.equals(GenericParameter.class.getName())) {
			log.warn("The setting of GenericParameter is not supported and will be ignored.");
		} else {
			log.error("No handling adapter of setting Optimizable Parameter "
					+ eClass);
		}
	}

	public HashMap<RunCall, EstimationSpecification> collectResults(
			Collection<RunCall> calls) {
		// Run each RunCall separately and concurrently
		ExecutorService pool = Executors.newCachedThreadPool();
		HashMap<RunCall, Future<EstimationSpecification>> results = new HashMap<RunCall, Future<EstimationSpecification>>();
		for (RunCall call : calls) {
			results.put(call, pool.submit(new RunCallExecutor(call)));
		}

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

	public void initLogging() {
		Librede.initLogging();
		// LogManager.getRootLogger().setLevel(Level.WARN);
	}

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
			// TODO Auto-generated method stub
			log.trace("Executing Call: " + call.toString());
			HillClimbingAlgorithm algo = new HillClimbingAlgorithm();
			algo.optimizeConfiguration(call.getEstimationSpecification(),
					call.getTrainingData(), call.getSettings(),
					call.getAlgorithm());
			return algo.getSpecification();
		}

	}

}
