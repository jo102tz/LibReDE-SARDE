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

import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.rinterface.CallbackEvaluator;
import tools.descartes.librede.rrde.rinterface.RBridge;

/**
 * This algorithm utilizes the R script for the Iterative Parameter Optimization
 * Algorithm.
 * 
 * @author JS
 *
 */
public class IterativeParameterOptimizationAlgorithm
		extends
		tools.descartes.librede.rrde.optimization.AbstractConfigurationOptimizer {

	/**
	 * The log used for logging.
	 */
	private static final Logger log = Logger
			.getLogger(IterativeParameterOptimizerSpecifierImpl.class);

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
			IConfigurationOptimizationAlgorithmSpecifier specifier) {
		if (specifier instanceof IterativeParameterOptimizerSpecifierImpl) {
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
		RBridge r = new RBridge();
		Map<IOptimizableParameter, Double> best = r.runOptimization(
				getSettings().getParametersToOptimize(),
				new CallbackEvaluator() {
					@Override
					public double evaluate(
							Map<IOptimizableParameter, Double> params) {
						for (Entry<IOptimizableParameter, Double> en : params
								.entrySet()) {
							setTargetValue(en.getKey(), en.getValue());
						}
						return runIteration();
					}
				});
		for (Entry<IOptimizableParameter, Double> en : best.entrySet()) {
			log.trace("Found parameter value of " + en.getValue()
					+ " for parameter " + en.getKey());
			setTargetValue(en.getKey(), en.getValue());
		}
	}

}
