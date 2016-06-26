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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationSettings;

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
	 * 
	 */
	private void init() {
		Discovery.createConfigurations(getSpecification(), getInput(),
				getSettings().getValidator());
	}

	/**
	 * Runs one iteration of the current configurations.
	 */
	protected void runIteration() {
		// TODO
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
	 * Executes the essential algorithm.
	 */
	public abstract void executeAlgorithm();
}
