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
package tools.descartes.librede.rrde.configuration.settings;

import tools.descartes.librede.rrde.configuration.implementations.HillClimbingAlgorithm;

/**
 * Contains settings for {@link HillClimbingAlgorithm} and subclasses.
 * 
 * @author JS
 *
 */
public class HillClimbingSettings {

	/**
	 * The lower bound for the target value.
	 */
	private double minimum = 1;

	/**
	 * The upper bound for the target value
	 */
	private double maximum = 200;

	/**
	 * The lower bound for a gain in order to proceed.
	 */
	private double minGain = 0;

	/**
	 * The step-size used by the hill-climbing algorithm
	 */
	private double stepSize = 1;

	/**
	 * The initial value used on the start.
	 */
	private double initialValue = 60;

	/**
	 * The tolerance radius of how much the found solution (for negative
	 * epsilon) can deviate from the current best. Given as a relative number
	 * between, zero meaning no tolerance radius, 0.1 meaning the value can be
	 * up to 10 percent higher, and 1 meaning it can be up to double the error
	 * of the currently best solution.
	 */
	private double tolerance = 0.05;

	/**
	 * @return the minimum
	 */
	public double getMinimum() {
		return minimum;
	}

	/**
	 * @param minimum
	 *            the minimum to set
	 */
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	/**
	 * @return the maximum
	 */
	public double getMaximum() {
		return maximum;
	}

	/**
	 * @param maximum
	 *            the maximum to set
	 */
	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}

	/**
	 * @return the minGain
	 */
	public double getMinGain() {
		return minGain;
	}

	/**
	 * @param minGain
	 *            the minGain to set
	 */
	public void setMinGain(double minGain) {
		this.minGain = minGain;
	}

	/**
	 * @return the stepSize
	 */
	public double getStepSize() {
		return stepSize;
	}

	/**
	 * @param stepSize
	 *            the stepSize to set
	 */
	public void setStepSize(double stepSize) {
		this.stepSize = stepSize;
	}

	/**
	 * @return the initialValue
	 */
	public double getInitialValue() {
		return initialValue;
	}

	/**
	 * @param initialValue
	 *            the initialValue to set
	 */
	public void setInitialValue(double initialValue) {
		this.initialValue = initialValue;
	}

	/**
	 * @return the tolerance
	 */
	public double getTolerance() {
		return tolerance;
	}

	/**
	 * @param tolerance
	 *            the tolerance to set
	 */
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}

	/**
	 * Constructor using default values
	 */
	public HillClimbingSettings() {
		// using default values
	}

}
