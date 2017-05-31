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
package tools.descartes.librede.rrde.rinterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;

/**
 * This class wraps call-backs from R in order to call the evaluation function
 * of the {@link ICallbackEvaluator}.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class CallbackWrapper {

	private ICallbackEvaluator eval;

	private List<IOptimizableParameter> paramlist;

	/**
	 * Creates a new object specifying the referencing
	 * {@link ICallbackEvaluator} and the list of {@link IOptimizableParameter}s
	 * to map.
	 * 
	 * @param params
	 *            An ordered(!) list of {@link IOptimizableParameter}
	 * @param evaluator
	 *            The {@link ICallbackEvaluator} that this instance wraps
	 *            around.
	 */
	public CallbackWrapper(List<IOptimizableParameter> params, ICallbackEvaluator evaluator) {
		this.eval = evaluator;
		this.paramlist = params;
	}

	/**
	 * Maps the given parameters to the according parameters of this object
	 * specified at instantiation. This method calls
	 * {@link #mapToParameters(double[])}, therefore its specifications also
	 * apply here.
	 * 
	 * @param params
	 *            The ordered parameter values to set.
	 * @return The return value of the specified {@link ICallbackEvaluator} of
	 *         "-1" if the call failed.
	 */
	public double evaluate(double[] params) {
		if (eval == null) {
			RBridge.getLog().error("Evaluator not properly set.");
			return -1;
		} else {
			Map<IOptimizableParameter, Double> map = mapToParameters(params);
			if (map == null)
				return -1;
			return eval.evaluate(mapToParameters(params));
		}
	}

	/**
	 * Maps the given parameters to the according parameters of this object
	 * specified at instantiation. This method calls
	 * {@link #mapToParameters(double[])}, therefore its specifications also
	 * apply here. Method for a single double parameter
	 * 
	 * @param param
	 *            The ordered parameter values to set.
	 * @return The return value of the specified {@link ICallbackEvaluator} of
	 *         "-1" if the call failed.
	 */
	public double evaluate(double param) {
		double[] params = new double[1];
		params[0] = param;
		return evaluate(params);
	}

	/**
	 * Maps the double array of parameter values to their corresponding
	 * {@link IOptimizableParameter}s and returns the map.<br>
	 * The length of the array MUST match the length of the list of
	 * {@link IOptimizableParameter}s handed over in the
	 * {@link #CallbackWrapper(List, ICallbackEvaluator)} constructor. Moreover,
	 * the ordering of the parameters must be exactly the same in both (ordered)
	 * lists. If not, the wrong parameters are matched against each other.
	 * 
	 * 
	 * @param params
	 *            The ordered parameter values.
	 * @return A map assigning the values or null if the mapping failed.
	 */
	public Map<IOptimizableParameter, Double> mapToParameters(double[] params) {
		// parse Objects
		if (params.length != paramlist.size()) {
			RBridge.getLog().error("The List of parameters and their mapping of values does not match.");
			return null;
		}
		// the list interface ensures, that the parameters are always in the
		// same order. Since R treats the parameters internally also as a
		// list, the order really should not change,so this should be safe
		Map<IOptimizableParameter, Double> map = new HashMap<IOptimizableParameter, Double>();
		for (int i = 0; i < params.length; i++) {
			map.put(paramlist.get(i), params[i]);
		}
		return map;
	}
}
