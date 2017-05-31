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
package tools.descartes.librede.rrde.optimization.algorithm.impl;

import org.apache.log4j.Logger;

import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.optimization.algorithm.AbstractConfigurationOptimizer;

/**
 * A general implementation of a Hill-climbing routine supporting a tolerance
 * radius for negative results.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class HillClimbingAlgorithm extends AbstractConfigurationOptimizer {

	private static final Logger log = Logger
			.getLogger(HillClimbingAlgorithm.class);

	private LocalSearchSpecifier settings;

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizer#
	 * getSimpleName()
	 */
	@Override
	public String getSimpleName() {
		return this.getClass().getSimpleName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizer#
	 * isSpecifierSupported(tools.descartes.librede.rrde.optimization.
	 * IConfigurationOptimizationAlgorithmSpecifier)
	 */
	@Override
	public boolean isSpecifierSupported(
			ConfigurationOptimizationAlgorithmSpecifier specifier) {
		if (specifier == null)
			return false;
		if (specifier instanceof LocalSearchSpecifier) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.optimization.AbstractConfigurationOptimizer
	 * #getLog()
	 */
	@Override
	protected Logger getLog() {
		return log;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.optimization.AbstractConfigurationOptimizer
	 * #executeAlgorithm()
	 */
	@Override
	public void executeAlgorithm() {
		// should be safe, since exception is otherwise thrown
		settings = (LocalSearchSpecifier) getAlgorithm();
		// initial iteration to evaluate first error
		runIteration();
		for (IOptimizableParameter param : getSettings()
				.getParametersToOptimize()) {
			getLog().info(
					"Now optimizing " + param.toString() + " of approach "
							+ getSpecification().getApproaches().get(0));
			hillclimbing(param);
			getLog().info(
					"Found value of " + getTargetValue(param)
							+ " for Parameter " + param.toString());
		}

	}

	/**
	 * Starts a hillclimbing routine
	 * 
	 * @param param
	 *            The parameter to modify the search
	 */
	protected void hillclimbing(IOptimizableParameter param) {

		double value = param.getStartValue();
		setTargetValue(param, value);
		double before = getLastError();
		getLog().info("Initial parameter value:" + value);
		// run up and down at the same time with stepsize
		double[] resultup = oneWayAscend(param, value, before, +settings()
				.getStepSize());
		double[] resultdown = oneWayAscend(param, value, before, -settings()
				.getStepSize());
		// if running up has better results than down
		if (resultup[0] < resultdown[0]) {
			// apply value of going up
			setTargetValue(param, resultup[1]);
		}
	}

	private double[] oneWayAscend(IOptimizableParameter param, double start,
			double startvalue, double operation) {
		double[] currbest = { startvalue, start };
		setTargetValue(param, start);
		double newerr = startvalue;
		while (repeat(newerr, currbest[0]) && !outOfBounds(param, operation)) {
			setTargetValue(param, getTargetValue(param) + operation);
			// run with changed settings
			runIteration();
			newerr = getLastError();
			getLog().trace(
					"New target function with target value "
							+ getTargetValue(param) + " :" + newerr);

			// update currbest
			if (newerr < currbest[0]) {
				currbest[0] = newerr;
				currbest[1] = getTargetValue(param);
			}
		}
		return currbest;
	}

	private boolean outOfBounds(IOptimizableParameter param, double operation) {
		if (getTargetValue(param) + operation < param.getLowerBound()
				|| getTargetValue(param) + operation > param.getUpperBound())
			return true;
		else
			return false;
	}

	protected boolean repeat(double after, double currbest) {
		if (after <= currbest + (currbest * settings().getTolerance())) {
			// if we have no gain, but are still in our tolerance radius
			return true;
		} else {
			// outside of tolerance radius
			return false;
		}
	}

	private LocalSearchSpecifier settings() {
		return settings;
	}

}
