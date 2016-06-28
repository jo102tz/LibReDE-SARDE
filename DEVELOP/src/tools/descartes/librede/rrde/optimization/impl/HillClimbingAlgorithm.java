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
package tools.descartes.librede.rrde.optimization.impl;

import org.apache.log4j.Logger;

import tools.descartes.librede.rrde.optimization.AbstractConfigurationOptimizer;
import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.LocalSearchSpecifier;

/**
 * A general implementation of a Hill-climbing routine supporting a tolerance
 * radius for negative results.
 * 
 * @author JS
 *
 */
public class HillClimbingAlgorithm extends AbstractConfigurationOptimizer {

	private static final Logger log = Logger.getLogger(HillClimbingAlgorithm.class);

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
	public boolean isSpecifierSupported(IConfigurationOptimizationAlgorithmSpecifier specifier) {
		if (specifier == null)
			return false;
		if(specifier instanceof LocalSearchSpecifier){
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
		// TODO
		runIteration();
		System.out.println("Executing.....");
	}

	// /**
	// * Starts the routine.
	// *
	// * @return
	// */
	// protected void hillclimbing() {
	//
	// double value = settings().getInitialValue();
	// setTargetValue(value);
	// // run first iteration
	// double before = errorFunction();
	// getLog().info("Initial step size: " + value);
	// // run up and down at the same time with stepsize
	// double[] resultup = oneWayAscend(value, before, +settings()
	// .getStepSize());
	// double[] resultdown = oneWayAscend(value, before, -settings()
	// .getStepSize());
	// // if running up has better results than down
	// if (resultup[0] < resultdown[0]) {
	// // apply value of going up
	// setTargetValue(resultup[1]);
	// }
	// }
	//
	// private double[] oneWayAscend(double start, double startvalue,
	// double operation) {
	// double[] currbest = { startvalue, start };
	// setTargetValue(start);
	// double before = startvalue;
	// double newerr = before;
	// while (repeat(before, newerr, currbest[0]) && !outOfBounds(operation)) {
	// before = newerr;
	// setTargetValue(getTargetValue() + operation);
	// newerr = errorFunction();
	// getLog().trace(
	// "New target function with target value " + getTargetValue()
	// + " :" + newerr);
	//
	// // update currbest
	// if (newerr < currbest[0]) {
	// currbest[0] = newerr;
	// currbest[1] = getTargetValue();
	// }
	// }
	// return currbest;
	// }
	//
	// private boolean outOfBounds(double operation) {
	// if (getTargetValue() + operation < settings().getMinimum()
	// || getTargetValue() + operation > settings().getMaximum())
	// return true;
	// else
	// return false;
	// }
	//
	// protected boolean repeat(double before, double after, double currbest) {
	// double gain = before - after;
	// if (gain >= settings().getMinGain()) {
	// // if we have a gain
	// return true;
	// } else if (after <= currbest + (currbest * settings().getTolerance())) {
	// // if we have no gain, but are still in our tolerance radius
	// return true;
	// } else {
	// // outside of tolerance radius
	// return false;
	// }
	// }
	//
	// /**
	// * The objective function to be optimized. The function is assumed to be
	// an
	// * error function, i.e. the smaller the value, the better.
	// *
	// * @return The target value for the current configuration
	// */
	// protected abstract double errorFunction();
	//
	// /**
	// * Sets the target value accordingly.
	// *
	// * @param value
	// * The target value of the optimizing function
	// */
	// protected abstract void setTargetValue(double value);
	//
	// /**
	// * Returns the target value accordingly.
	// *
	// * @returns value The current value of the optimizing function
	// */
	// protected abstract double getTargetValue();

}
