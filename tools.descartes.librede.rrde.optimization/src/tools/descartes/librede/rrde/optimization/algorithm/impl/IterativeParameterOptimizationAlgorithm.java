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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.log4j.Logger;

import tools.descartes.librede.rrde.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.algorithm.AbstractConfigurationOptimizer;
import tools.descartes.librede.rrde.optimization.impl.IterativeParameterOptimizerSpecifierImpl;
import tools.descartes.librede.rrde.optimization.util.Util;
import tools.descartes.librede.rrde.rinterface.ICallbackEvaluator;
import tools.descartes.librede.rrde.rinterface.RBridge;

/**
 * This algorithm utilizes the R script for the Iterative Parameter Optimization
 * Algorithm.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
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
		ICallbackEvaluator evaluator = new ICallbackEvaluator() {
			@Override
			public double evaluate(Map<IOptimizableParameter, Double> params) {
				for (Entry<IOptimizableParameter, Double> en : params.entrySet()) {
					setTargetValue(en.getKey(), en.getValue());
				}
				return runIteration();
			}
		};
		Map<IOptimizableParameter, Double> best = r.runOptimization(getSettings().getParametersToOptimize(), evaluator,
				alg.getNumberOfSplits(), alg.getNumberOfExplorations(), alg.getNumberOfIterations());
		// do sanity check first
		doSanityCheck(best, evaluator);
		// set target values
		for (Entry<IOptimizableParameter, Double> en : best.entrySet()) {
			log.info("Found parameter value of " + en.getValue() + " for parameter "
					+ Util.getParameterString(en.getKey()));
			setTargetValue(en.getKey(), en.getValue());
		}
		getLog().info("Finished execution of IPA script!");
	}

	/**
	 * Performs the sanity check, i.e. checks, if the results would be better if
	 * any of the parameters would go back to default values.
	 * 
	 * @param best
	 *            The currently best parameter configuration.
	 * @param evaluator
	 *            The evaluator to evaluate the parameter changes.
	 */
	private void doSanityCheck(Map<IOptimizableParameter, Double> best, ICallbackEvaluator evaluator) {
		getLog().trace("Performing sanity check.");
		for (Entry<IOptimizableParameter, Double> en : best.entrySet()) {
			getLog().trace("Parameter " + Util.getParameterString(en.getKey()) + " has value " + en.getValue() + ".");
		}
		int iteration = 0;
		// repeat until no improvement can be found
		boolean changed = false;
		do {
			getLog().trace("Iteration no. " + iteration++);
			Map<IOptimizableParameter, Double> map = getBetterMap(best, evaluator, evaluator.evaluate(best));
			if (map == null) {
				// if map is null, no improvements could be found
				break;
			} else {
				best = map;
				getLog().trace("Found improvement by using the default value.");
				changed = true;
			}
		} while (changed);

		getLog().trace("No (more) improvements to be found. Existing sanity check.");
	}

	/**
	 * Checks, if the results would be better if any of the parameters would go
	 * back to default values.
	 * 
	 * @param best
	 *            The currently best parameter configuration.
	 * @param evaluator
	 *            The evaluator to evaluate the parameter changes.
	 * @param target
	 *            The error value to beat.
	 * @return A map that has a better error value than <b>target</b>, or
	 *         <code>null</code> if none could be found.
	 */
	private Map<IOptimizableParameter, Double> getBetterMap(Map<IOptimizableParameter, Double> best,
			ICallbackEvaluator evaluator, double target) {
		Map<IOptimizableParameter, Double> returnmap = null;
		for (Entry<IOptimizableParameter, Double> en : best.entrySet()) {
			getLog().trace("Parameter " + Util.getParameterString(en.getKey()) + " has value " + en.getValue() + ".");
			Double valTmp = en.getValue();
			// insert given default value
			best.put(en.getKey(), en.getKey().getStartValue());
			double compare = evaluator.evaluate(best);
			if (compare < target) {
				returnmap = new HashMap<IOptimizableParameter, Double>(best);
				// update target
				target = compare;
			}
			// restore default
			best.put(en.getKey(), valTmp);
		}
		return returnmap;
	}

}
