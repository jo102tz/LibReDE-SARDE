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

/**
 * TODO comment
 * 
 * @author JS
 *
 */
public class CallbackHolder {

	/**
	 * The current Evaluator for Call backs
	 */
	private static CallbackEvaluator eval = null;

	/**
	 * TODO comment
	 * 
	 * @param args
	 * @return
	 */
	public static double evaluate(Object... args) {
		if (eval == null) {
//			RBridge.getLog().error("Evaluator not properly set.");
			return 0;
		} else {
			// parse Objects
			// TODO
			return eval.evaluate(null);
		}

	}

	/**
	 * @return the eval
	 */
	public static CallbackEvaluator getEvaluator() {
		return eval;
	}

	/**
	 * @param eval
	 *            the eval to set
	 */
	public static void setEvaluator(CallbackEvaluator eval) {
		CallbackHolder.eval = eval;
	}

}
