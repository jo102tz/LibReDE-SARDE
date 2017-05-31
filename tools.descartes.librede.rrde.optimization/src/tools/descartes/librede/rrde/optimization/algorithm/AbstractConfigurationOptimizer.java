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
package tools.descartes.librede.rrde.optimization.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.util.Discovery;
import tools.descartes.librede.rrde.util.Util;
import tools.descartes.librede.rrde.util.Wrapper;

/**
 * This class contains an abstract implementation of an
 * {@link IConfigurationOptimizer}. Basic functionality is implemented as a
 * framework in order to support different subclass implementations.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public abstract class AbstractConfigurationOptimizer implements IConfigurationOptimizer {

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
	private ConfigurationOptimizationAlgorithmSpecifier algorithm;

	/**
	 * A counter storing the number of executed iterations for debugging
	 */
	private int iterationcounter;

	/**
	 * A counter storing the total number of executed LibReDE configurations
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
	 * A storage of the individual results of the last run for further analyzes.
	 */
	private Map<LibredeConfiguration, LibredeResults> lastResults;

	/**
	 * The time elapsed for the first iteration.
	 */
	private long firstiterationtime;

	/**
	 * The value of the last error.
	 */
	private double lastError;

	/**
	 * The value of the error before the optimization process.
	 */
	private double firstError;

	/**
	 * A statistics object for storing and analyzing.
	 */
	private DescriptiveStatistics stat;

	/**
	 * Constructor preparing and initializing execution
	 */
	public AbstractConfigurationOptimizer() {
		super();
		iterationcounter = 0;
		totalruns = 0;
		lastResults = new HashMap<LibredeConfiguration, LibredeResults>();
		stat = new DescriptiveStatistics();
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
	public ConfigurationOptimizationAlgorithmSpecifier getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param algorithm
	 *            the algorithm to set
	 */
	public void setAlgorithm(ConfigurationOptimizationAlgorithmSpecifier algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * @return the finished
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * @return the confs
	 */
	public Set<LibredeConfiguration> getConfs() {
		return confs;
	}

	/**
	 * @return the firstiterationtime
	 */
	public long getFirstiterationtime() {
		return firstiterationtime;
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
	public boolean optimizeConfiguration(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier)
			throws IllegalArgumentException {
		if (!isSpecifierSupported(specifier)) {
			throw new IllegalArgumentException("The given specifier does not apply for this algorithm.");
		}
		if (estimation == null || input == null || specifier == null || settings == null
				|| settings.getValidator() == null) {
			throw new NullPointerException("None of the given parameters can be null.");
		}
		setSettings(settings);
		setInput(input);
		setSpecification(estimation);
		setAlgorithm(specifier);
		finished = false;
		getLog().info("Starting reconfiguration of configuration " + getSpecification().toString());
		time = System.currentTimeMillis();
		init();
		if (confs.size() == 0) {
			getLog().error("Execution stopped due to lack of training data.");
			finished = true;
			return false;
		}
		executeAlgorithm();
		double newError = runIteration();
		finished = true;
		getLog().info("Successfully ran optimization of configuration file " + getSpecification().toString());
		getLog().info("Number of iterations:" + iterationcounter);
		getLog().info("Number of total executions:" + totalruns);
		getLog().info("Elapsed Time: "
				+ DurationFormatUtils.formatDurationWords((System.currentTimeMillis() - time), false, false) + ".");
		double improvementPercent = ((firstError - newError) * 100) / (firstError);
		getLog().info("The optimized configurations have an error of " + newError
				+ ". This is an improvement of around " + improvementPercent + "%.");
		for (IOptimizableParameter param : settings.getParametersToOptimize())
			getLog().info("Found optimal value for " + getSpecification().getApproaches().get(0).toString()
					+ " for parameter " + param.toString() + " at "
					+ Util.getValue(getConfs().iterator().next().getEstimation(), param) + "!");
		return true;
	}

	/**
	 * Initializes all resources required for execution.
	 */
	private void init() {
		confs = Discovery.createConfigurations(getInput(), getSpecification(), getSettings().getValidator());
		getLog().info("Finished initialization. Available Training-Configurations: " + confs.size());
		long thistime = System.currentTimeMillis();
		firstError = runIteration();
		firstiterationtime = System.currentTimeMillis() - thistime;
		String timestamp = DurationFormatUtils.formatDuration(firstiterationtime, "ss.SSS", false);
		getLog().info("The starting configurations have an error of " + firstError
				+ ". Time elapsed for the first iteration: " + timestamp + "s.");
	}

	/**
	 * Runs one iteration of the current configurations and returns the
	 * equal-weighted mean of the mean validation error of all approaches.
	 * 
	 * @return The error value of this iteration.
	 */
	protected double runIteration() {
		stat.clear();
		lastResults.clear();
		for (LibredeConfiguration single : confs) {
			totalruns++;
			getLog().trace("Starting execution of " + single.toString());
			LibredeResults results = Wrapper.executeLibrede(single);
			lastResults.put(single, results);
			if (results == null || results.getApproaches() == null) {
				getLog().error("The execution resulted an non-trackable error.");
				lastError = Double.MAX_VALUE;
				return getLastError();
			}
			if (results.getApproaches().size() > 1) {
				getLog().error("There must not be more than one approach per optimization run.");
			}
			if (results.getApproaches().isEmpty()) {
				getLog().warn("Result table is empty.");
			}
			stat.addValue(Util.getValidationError(results, single.getValidation()));
		}
		iterationcounter++;
		lastError = stat.getMean();
		return getLastError();
	}

	@Override
	public EstimationSpecification getResult() throws IllegalStateException {
		if (!finished) {
			throw new IllegalStateException("The optimization is still ongoing.");
		}
		return getSpecification();
	}

	/**
	 * Returns a map of the last results assigned to their configuration which
	 * can be used for deeper analysis.
	 * 
	 * @return The results of the last call of {@link #runIteration()} or and
	 *         empty map if the results are not available yet or right now.
	 */
	public Map<LibredeConfiguration, LibredeResults> getLastResults() {
		return lastResults;
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
		getLog().trace("Set value of " + Util.getParameterString(param) + " for Approach " + getSimpleApproachName()
				+ " to " + value);
		for (LibredeConfiguration conf : confs) {
			Util.setValue(conf.getEstimation(), value, param);
		}
		// set actual output
		Util.setValue(getSpecification(), value, param);
	}

	/**
	 * Returns the target value accordingly.
	 *
	 * @returns value The current value of the optimizing function
	 */
	protected double getTargetValue(IOptimizableParameter param) {
		return Util.getValue(confs.iterator().next().getEstimation(), param);
	}

	/**
	 * Return a simple name of the approach this algorithm is optimizing. Useful
	 * for logging
	 * 
	 * @return A simple descriptor of the approach
	 */
	public String getSimpleApproachName() {
		return getSpecification().getApproaches().get(0).getType().replace("tools.descartes.librede.approach.", "");
	}

	/**
	 * Executes the essential algorithm.
	 */
	public abstract void executeAlgorithm();

	@Override
	public String getSimpleName() {
		return this.getClass().getSimpleName();
	}
}
