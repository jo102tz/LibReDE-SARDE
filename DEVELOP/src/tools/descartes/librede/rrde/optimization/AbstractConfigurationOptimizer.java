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

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.Util;
import tools.descartes.librede.rrde.Wrapper;
import tools.descartes.librede.rrde.optimization.impl.OptimizationSettingsImpl;

/**
 * This class contains an abstract implementation of an
 * {@link IConfigurationOptimizer}. Basic functionality is implemented as a
 * framework in order to support different subclass implementations.
 * 
 * @author JS
 *
 */
public abstract class AbstractConfigurationOptimizer implements
		IConfigurationOptimizer {

	/**
	 * The specification of LibReDE to modify
	 */
	private EstimationSpecification specification;

	/**
	 * The input data to evaluate on
	 */
	private EList<InputData> input;

	/**
	 * The settings specifying the tasks of the Algorithm
	 */
	private OptimizationSettings settings;

	/**
	 * Parameters modifying the behavior of the algorithm
	 */
	private IConfigurationOptimizationAlgorithmSpecifier algorithm;

	/**
	 * A counter storing the number of executed iterations for debugging
	 */
	private int iterationcounter;

	/**
	 * A counter storing the total number of executed librede configurations
	 */
	private int totalruns;

	/**
	 * The time when starting the run
	 */
	private long time;

	/**
	 * Flag signaling, if the calculation is still ongoing.
	 */
	private boolean finished = false;

	/**
	 * The set of LibredeConfigurations to run for every iteration.
	 */
	private Set<LibredeConfiguration> confs;

	/**
	 * The value of the last error.
	 */
	private double lastError;

	/**
	 * Constructor preparing and initializing execution
	 */
	public AbstractConfigurationOptimizer() {
		super();
		iterationcounter = 0;
		totalruns = 0;
	}

	/**
	 * @return the specification
	 */
	public EstimationSpecification getSpecification() {
		return specification;
	}

	/**
	 * @param specification
	 *            the specification to set
	 */
	public void setSpecification(EstimationSpecification specification) {
		this.specification = specification;
	}

	/**
	 * @return the input
	 */
	public EList<InputData> getInput() {
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(EList<InputData> input) {
		this.input = input;
	}

	/**
	 * @return the settings
	 */
	public OptimizationSettings getSettings() {
		return settings;
	}

	/**
	 * @param settings
	 *            the settings to set
	 */
	public void setSettings(OptimizationSettings settings) {
		this.settings = settings;
	}

	/**
	 * @return the algorithm
	 */
	public IConfigurationOptimizationAlgorithmSpecifier getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param algorithm
	 *            the algorithm to set
	 */
	public void setAlgorithm(
			IConfigurationOptimizationAlgorithmSpecifier algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * Returns the log instance, to provide proper visible logging.
	 * 
	 * @return the logger of the implementing class
	 */
	protected abstract Logger getLog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.configuration.IConfigurationOptimizer#
	 * optimizeConfiguration
	 * (tools.descartes.librede.configuration.EstimationSpecification,
	 * tools.descartes.librede.rrde.optimization.InputData,
	 * tools.descartes.librede.rrde.optimization.OptimizationSettings,
	 * tools.descartes
	 * .librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier)
	 */
	@Override
	public boolean optimizeConfiguration(EstimationSpecification estimation,
			EList<InputData> input, OptimizationSettings settings,
			IConfigurationOptimizationAlgorithmSpecifier specifier)
			throws IllegalArgumentException {
		if (!isSpecifierSupported(specifier)) {
			throw new IllegalArgumentException(
					"The given specifier does not apply for this algorithm.");
		}
		if (estimation == null || input == null || specifier == null
				|| settings == null) {
			throw new NullPointerException(
					"None of the given parameters can be null.");
		}
		setSettings(settings);
		setInput(input);
		setSpecification(estimation);
		setAlgorithm(specifier);
		finished = false;
		getLog().info(
				"Starting reconfiguration of configuration "
						+ getSpecification().toString());
		time = System.currentTimeMillis();
		init();
		executeAlgorithm();
		finished = true;
		getLog().info(
				"Successfully ran optimization of configuration file "
						+ getSpecification().toString());
		getLog().info("Number of iterations:" + iterationcounter);
		getLog().info("Number of total executions:" + totalruns);
		getLog().info("Time: " + (System.currentTimeMillis() - time) + " ms");
		return true;
	}

	/**
	 * Initializes all resources required for execution.
	 */
	private void init() {
		Wrapper.init();
		confs = Discovery.createConfigurations(getSpecification(), getInput(),
				getSettings().getValidator());
		validateConfs();
		getLog().info(
				"Finished initialization. Available Training-Configurations: "
						+ confs.size());
	}

	/**
	 * Validate all configurations and deletes the ones that do not suffice.
	 */
	private void validateConfs() {
		HashSet<LibredeConfiguration> remove = new HashSet<LibredeConfiguration>();
		for (LibredeConfiguration single : confs) {
			if (single.getWorkloadDescription() == null
					|| single.getEstimation() == null
					|| single.getInput() == null || single.getOutput() == null
					|| single.getValidation() == null) {
				getLog().warn(
						"Malformed Configuration. (Null-values) Ignoring "
								+ single.toString() + ".");

			} else if (single.getWorkloadDescription().getResources().isEmpty()
					|| single.getWorkloadDescription().getServices().isEmpty()) {
				getLog().warn(
						"Malformed Configuration. Resources or Services are empty. Ignoring "
								+ single.toString() + ".");
				remove.add(single);
			}
		}
		confs.removeAll(remove);
		if (confs.isEmpty()) {
			getLog().error(
					"There are no valid configurations as training data.");
		}
	}

	/**
	 * Runs one iteration of the current configurations and returns the
	 * equal-weighted mean of the mean validation error of all approaches.
	 * 
	 * @return The error value of this iteration.
	 */
	protected double runIteration() {
		DescriptiveStatistics stat = new DescriptiveStatistics();
		for (LibredeConfiguration single : confs) {
			totalruns++;
			getLog().trace("Starting execution of " + single.toString());
			LibredeResults results = Wrapper.executeLibrede(single);
			if (results == null || results.getApproaches() == null) {
				getLog().error("The execution resulted an non-trackable error.");
				lastError = Double.MAX_VALUE;
				return getLastError();
			}
			if (results.getApproaches().size() > 1) {
				getLog().error(
						"There must not be more than one approach per optimization run.");
			}
			for (Class<? extends IEstimationApproach> approach : results
					.getApproaches()) {
				stat.addValue(results.getApproachResults(approach)
						.getMeanError());
			}
			if (results.getApproaches().isEmpty()) {
				getLog().warn("Result table is empty.");
			}

		}
		iterationcounter++;
		lastError = stat.getMean();
		return getLastError();
	}

	@Override
	public EstimationSpecification getResult() throws IllegalStateException {
		if (!finished) {
			throw new IllegalStateException(
					"The optimization is still ongoing.");
		}
		return getSpecification();
	}

	/**
	 * The objective function to be optimized. The function is assumed to be an
	 * error function, i.e. the smaller the value, the better.
	 *
	 * @return The target value for the current configuration
	 */
	protected double getLastError() {
		return lastError;
	}

	/**
	 * Sets the target value accordingly.
	 *
	 * @param value
	 *            The target value of the optimizing function
	 */
	protected void setTargetValue(IOptimizableParameter param, double value) {
		getLog().info(
				"Set value of " + param.toString() + " for Approach "
						+ getSpecification().getApproaches().get(0) + " to "
						+ value);
		for (LibredeConfiguration conf : confs) {
			Util.setValue(conf.getEstimation(), value,
					param.getClass().getInterfaces()[0].getName());
		}
		//set actual output
		Util.setValue(getSpecification(), value, param.getClass().getInterfaces()[0].getName());
	}

	/**
	 * Returns the target value accordingly.
	 *
	 * @returns value The current value of the optimizing function
	 */
	protected double getTargetValue(IOptimizableParameter param) {
		return Util.getValue(confs.iterator().next(), param.getClass()
				.getInterfaces()[0].getName());
	}

	/**
	 * Executes the essential algorithm.
	 */
	public abstract void executeAlgorithm();
}
