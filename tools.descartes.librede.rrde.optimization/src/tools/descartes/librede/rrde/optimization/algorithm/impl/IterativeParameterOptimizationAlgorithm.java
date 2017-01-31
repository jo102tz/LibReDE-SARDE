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

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.log4j.Logger;

import tools.descartes.librede.rrde.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.optimization.algorithm.AbstractConfigurationOptimizer;
import tools.descartes.librede.rrde.optimization.impl.IterativeParameterOptimizerSpecifierImpl;
import tools.descartes.librede.rrde.rinterface.ICallbackEvaluator;
import tools.descartes.librede.rrde.rinterface.RBridge;

/**
 * This algorithm utilizes the R script for the Iterative Parameter Optimization
 * Algorithm.
 * 
 * @author JS
 *
 */
public class IterativeParameterOptimizationAlgorithm extends AbstractConfigurationOptimizer {

	/**
	 * The log used for logging.
	 */
	private static final Logger log = Logger.getLogger(IterativeParameterOptimizerSpecifierImpl.class);

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
	public boolean isSpecifierSupported(ConfigurationOptimizationAlgorithmSpecifier specifier) {
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
		RBridge r = RBridge.getInstance();
		IterativeParameterOptimizerSpecifierImpl alg = (IterativeParameterOptimizerSpecifierImpl) getAlgorithm();
		getLog().info("Starting execution of IPA script...");

		// calculate expected runtime
		long complexity = (long) (alg.getNumberOfIterations() * alg.getNumberOfExplorations()
				* Math.pow(alg.getNumberOfSplits() + 2, getSettings().getParametersToOptimize().size()));
		String timestamp = DurationFormatUtils.formatDurationHMS(complexity * getFirstiterationtime());
		getLog().info("Expected runtime (pessimistic): " + timestamp);

		// call RBridge
		Map<IOptimizableParameter, Double> best = r.runOptimization(getSettings().getParametersToOptimize(),
				new ICallbackEvaluator() {
					@Override
					public double evaluate(Map<IOptimizableParameter, Double> params) {
						for (Entry<IOptimizableParameter, Double> en : params.entrySet()) {
							setTargetValue(en.getKey(), en.getValue());
						}
						return runIteration();
					}
				}, alg.getNumberOfSplits(), alg.getNumberOfExplorations(), alg.getNumberOfIterations());
		for (Entry<IOptimizableParameter, Double> en : best.entrySet()) {
			log.info("Found parameter value of " + en.getValue() + " for parameter "
					+ Util.getParameterString(en.getKey()));
			setTargetValue(en.getKey(), en.getValue());
		}
		getLog().info("Finished execution of IPA script!");
	}

}
