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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.rinterface.ICallbackEvaluator;

/**
 * This algorithm is an all-Java implementation of the
 * {@link IterativeParameterOptimizationAlgorithmLegacy} algorithm in order to avoid
 * compatibility problems with the R bridge.
 * 
 * The algorithm is described in: Qais Noorshams, Dominik Bruhn, Samuel Kounev,
 * and Ralf Reussner. Predictive Performance Modeling of Virtualized Storage
 * Systems using Optimized Statistical Regression Techniques. In Proceedings of
 * the ACM/SPEC International Conference on Performance Engineering (ICPE 2013),
 * Prague, Czech Republic, 2013, ICPE'13, pages 283--294. ACM, New York, NY,
 * USA. 2013.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class StepwiseSamplingSearch {

	/**
	 * Executes the actual S3 algorithm.
	 * 
	 * @param parametersToOptimize The list of parameters to optimize.
	 * @param evaluator            The evaluator in order to perform parameter
	 *                             changes on the data.
	 * @param numberOfSplits       The number of splits (S3 parameter).
	 * @param numberOfExplorations The number of exploration points (S3 parameter).
	 * @param numberOfIterations   The number of iterations to perform (S3
	 *                             parameter).
	 * @return A Map containing the best found parameter configuration.
	 */
	public Map<IOptimizableParameter, Double> runOptimization(EList<IOptimizableParameter> parametersToOptimize,
			ICallbackEvaluator evaluator, int numberOfSplits, int numberOfExplorations, int numberOfIterations) {

		// initializing
		SortedSet<EvaluationPoint> results = new TreeSet<EvaluationPoint>();
		SortedSet<EvaluationPoint> bestSet = new TreeSet<EvaluationPoint>();
		// evaluate first border parameters
		Map<IOptimizableParameter, Double> parameterset = new HashMap<IOptimizableParameter, Double>();
		for (IOptimizableParameter param : parametersToOptimize) {
			parameterset.put(param, param.getLowerBound());
		}
		ParameterCombination start = new ParameterCombination(parameterset);
		Double eval = evaluator.evaluate(start.getParams());
		results.add(new EvaluationPoint(start, eval));
		bestSet.add(new EvaluationPoint(start, eval));

		// while stopping criterion is not fullfilled
		for (int iteration = 0; iteration < numberOfIterations; iteration++) {
			for (EvaluationPoint evaluationPoint : bestSet) {
				Map<IOptimizableParameter, List<Double>> parameterPoints = new HashMap<IOptimizableParameter, List<Double>>();
				for (IOptimizableParameter param : parametersToOptimize) {
					double minval = findClosestMinVal(param, evaluationPoint, results);
					double maxval = findClosestMaxVal(param, evaluationPoint, results);
					double stepSize = (maxval - minval) / (numberOfSplits + 1);
					List<Double> parampoints = new ArrayList<Double>(numberOfSplits + 1);
					for (int j = 0; j < numberOfSplits + 2; j++) {
						parampoints.add(minval + j * stepSize);
					}
					parameterPoints.put(param, parampoints);
				}
				Set<ParameterCombination> crossProduct = buildCartesianProduct(parameterPoints);
				addEvaluationPoints(evaluator, results, crossProduct);
				// TODO Rounding
			}
			// find new best set
			bestSet.clear();
			Iterator<EvaluationPoint> bestIterator = results.iterator();
			for (int i = 0; i < numberOfExplorations; i++) {
				bestSet.add(bestIterator.next());
			}
		}
		return results.first().getParam().getParams();
	}

	private void addEvaluationPoints(ICallbackEvaluator evaluator, SortedSet<EvaluationPoint> results,
			Set<ParameterCombination> crossProduct) {
		for (ParameterCombination parameterCombination : crossProduct) {
			if (!alreadyEvaluated(results, parameterCombination)) {
				double error = evaluator.evaluate(parameterCombination.getParams());
				results.add(new EvaluationPoint(parameterCombination, error));
			}
		}
	}

	private boolean alreadyEvaluated(SortedSet<EvaluationPoint> results, ParameterCombination parameterCombination) {
		for (EvaluationPoint evaluationPoint : results) {
			if (evaluationPoint.getParam().equals(parameterCombination))
				return true;
		}
		return false;
	}

	private Set<ParameterCombination> buildCartesianProduct(Map<IOptimizableParameter, List<Double>> parameterPoints) {
		Set<Map<IOptimizableParameter, Double>> product = cartesianProduct(copy(parameterPoints));
		Set<ParameterCombination> combination = new HashSet<ParameterCombination>();
		for (Map<IOptimizableParameter, Double> set : product) {
			combination.add(new ParameterCombination(set));
		}
		return combination;
	}

	private Set<Map<IOptimizableParameter, Double>> cartesianProduct(Map<IOptimizableParameter, List<Double>> listmap) {
		Set<Map<IOptimizableParameter, Double>> ret = new HashSet<Map<IOptimizableParameter, Double>>();
		if (listmap.isEmpty()) {
			ret.add(new HashMap<IOptimizableParameter, Double>());
		} else {
			// get next param;
			IOptimizableParameter para = listmap.keySet().iterator().next();
			List<Double> values = listmap.remove(para);
			for (Double val : values) {
				for (Map<IOptimizableParameter, Double> map : cartesianProduct(copy(listmap))) {
					map.put(para, val);
					ret.add(map);
				}
			}
		}
		return ret;
	}

	private Map<IOptimizableParameter, List<Double>> copy(Map<IOptimizableParameter, List<Double>> listmap) {
		Map<IOptimizableParameter, List<Double>> c = new HashMap<IOptimizableParameter, List<Double>>();
		c.putAll(listmap);
		return c;
	}

	private double findClosestMaxVal(IOptimizableParameter param, EvaluationPoint evaluationPoint,
			SortedSet<EvaluationPoint> results) {
		// get evaluation point val
		double currVal = evaluationPoint.getParam().getParams().get(param);
		// search for closest value that is bigger of the evaluation set
		// if no bigger value can be found -> choose maximum value
		double smallestMax = param.getUpperBound();
		for (EvaluationPoint point : results) {
			double val = point.getParam().getParams().get(param);
			// if value is actually bigger than currVal, but also smaller than the current
			// smallest max -> new smallest max
			if ((val > currVal) && (val < smallestMax)) {
				smallestMax = val;
			}
		}
		return smallestMax;
	}

	private double findClosestMinVal(IOptimizableParameter param, EvaluationPoint evaluationPoint,
			SortedSet<EvaluationPoint> results) {
		// get evaluation point val
		double currVal = evaluationPoint.getParam().getParams().get(param);
		// search for closest value that is smaller of the evaluation set
		// if no smaller value can be found -> choose minimum value
		double highestMin = param.getLowerBound();
		for (EvaluationPoint point : results) {
			double val = point.getParam().getParams().get(param);
			// if value is actually smaller than currVal, but also higher than the current
			// highest min -> new highest min
			if ((val < currVal) && (val > highestMin)) {
				highestMin = val;
			}
		}
		return highestMin;
	}

	private class ParameterCombination {
		Map<IOptimizableParameter, Double> params;

		/**
		 * @return the params
		 */
		public Map<IOptimizableParameter, Double> getParams() {
			return params;
		}

		/**
		 * @param params
		 */
		public ParameterCombination(Map<IOptimizableParameter, Double> params) {
			super();
			this.params = params;
		}
	}

	private class EvaluationPoint implements Comparable<EvaluationPoint> {
		ParameterCombination param;
		Double value;

		/**
		 * @param param
		 * @param value
		 */
		public EvaluationPoint(ParameterCombination param, Double value) {
			super();
			this.param = param;
			this.value = value;
		}

		/**
		 * @return the param
		 */
		public ParameterCombination getParam() {
			return param;
		}

		/**
		 * @return the value
		 */
		public Double getValue() {
			return value;
		}

		@Override
		public int compareTo(EvaluationPoint o) {
			// a value is better, if it is smaller, therefore reverse the comparison
			return o.getValue().compareTo(this.getValue());
		}
	}

}
