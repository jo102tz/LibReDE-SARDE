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
package tools.descartes.librede.rrde.configuration.implementations;

import tools.descartes.librede.rrde.configuration.AbstractConfigurationOptimizer;
import tools.descartes.librede.rrde.configuration.settings.HillClimbingSettings;

/**
 * A general implementation of a Hill-climbing routine supporting a tolerance
 * radius for negative results.
 * 
 * @author JS
 *
 */
public abstract class HillClimbingAlgorithm extends
		AbstractConfigurationOptimizer {

	/**
	 * Starts the routine.
	 * 
	 * @return
	 */
	protected void hillclimbing() {
		double value = 0;
		if (settings().getInitialValue() == 0)
			value = getConfiguration().getEstimation().getStepSize().getValue();
		else {
			value = settings().getInitialValue();
			setTargetValue(value);
		}
		// run first iteration
		double before = errorFunction();
		getLog().info("Initial step size: " + value);
		// run up and down at the same time with stepsize
		double[] resultup = oneWayAscend(value, before, +settings()
				.getStepSize());
		double[] resultdown = oneWayAscend(value, before, -settings()
				.getStepSize());
		// if running up has better results than down
		if (resultup[0] < resultdown[0]) {
			// apply value of going up
			setTargetValue(resultup[1]);
		}
	}

	private double[] oneWayAscend(double start, double startvalue,
			double operation) {
		double[] result = new double[2];
		setTargetValue(start);
		double before = startvalue;
		double newerr = before;
		double gain = settings().getMinGain() + 1;
		while (gain >= settings().getMinGain()) {
			before = newerr;
			setTargetValue(getConfiguration().getEstimation().getStepSize()
					.getValue()
					+ operation);
			newerr = errorFunction();
			getLog().trace(
					"New target function with target value "
							+ getConfiguration().getEstimation().getStepSize()
									.getValue() + " :" + newerr);
			gain = before - newerr;
		}
		// best value was obtained before last iteration
		result[0] = before;
		result[1] = getConfiguration().getEstimation().getStepSize().getValue()
				- operation;
		return result;
	}

	private HillClimbingSettings settings() {
		return getSettings().getHillClimbingSettings();
	}

	/**
	 * The objective function to be optimized. The function is assumed to be an
	 * error function, i.e. the smaller the value, the better.
	 * 
	 * @return The target value for the current configuration
	 */
	protected abstract double errorFunction();

	/**
	 * Sets the target value accordingly.
	 * 
	 * @param value
	 *            The target value of the optimizing function
	 */
	protected abstract void setTargetValue(double value);

}
