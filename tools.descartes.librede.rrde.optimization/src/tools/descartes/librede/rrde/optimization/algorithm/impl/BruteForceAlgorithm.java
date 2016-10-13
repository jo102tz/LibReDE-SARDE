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

import tools.descartes.librede.rrde.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.optimization.algorithm.AbstractConfigurationOptimizer;

/**
 * @author JS
 *
 */
public class BruteForceAlgorithm extends AbstractConfigurationOptimizer {

	/**
	 * The log used for logging.
	 */
	private static final Logger log = Logger.getLogger(BruteForceAlgorithm.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.optimization.algorithm.
	 * IConfigurationOptimizer
	 * #isSpecifierSupported(tools.descartes.librede.rrde.optimization.
	 * ConfigurationOptimizationAlgorithmSpecifier)
	 */
	@Override
	public boolean isSpecifierSupported(ConfigurationOptimizationAlgorithmSpecifier specifier) {
		if (specifier instanceof LocalSearchSpecifier) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.optimization.algorithm.
	 * AbstractConfigurationOptimizer#getLog()
	 */
	@Override
	protected Logger getLog() {
		return log;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.optimization.algorithm.
	 * AbstractConfigurationOptimizer#executeAlgorithm()
	 */
	@Override
	public void executeAlgorithm() {
		getLog().info("Starting brute forcing...");
		for (IOptimizableParameter param : getSettings().getParametersToOptimize()) {
			double minError = Double.MAX_VALUE;
			double value = param.getStartValue();
			getLog().info("Now brute forcing " + param.toString());
			for (double i = param.getLowerBound(); i <= param
					.getUpperBound(); i += ((LocalSearchSpecifier) getAlgorithm()).getStepSize()) {
				getLog().info("Tried value of " + i + " for parameter " + param.toString());
				setTargetValue(param, i);
				double err = runIteration();
				if (err < minError) {
					value = i;
					minError = err;
				}
			}
			// set optimal found value
			setTargetValue(param, value);
			getLog().error("Found optimal value for " + getSpecification().getApproaches().get(0).toString()
					+ " for parameter " + param.toString() + " at " + value + "!");
		}
	}
}
