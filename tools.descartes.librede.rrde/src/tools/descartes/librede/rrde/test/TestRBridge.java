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
package tools.descartes.librede.rrde.test;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.rinterface.ICallbackEvaluator;
import tools.descartes.librede.rrde.rinterface.RBridge;

/**
 * 
 * @author Johannes
 *
 */
public class TestRBridge extends AbstractTest {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestOptimization.class);

	@Test(timeout = 5000)
	public void test() {
		RBridge bridge = RBridge.getInstance();
		try {
			bridge.runOptimization(null, null, 0, 0, 0);
		} catch (NullPointerException e) {
			// supposed to happen
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			fail("RBridge did not respont to null values.");
		}
		bridge.runOptimization(Collections.emptyList(), new ICallbackEvaluator() {

			@Override
			public double evaluate(Map<IOptimizableParameter, Double> params) {
				return 0;
			}
		}, 1, 1, 1);

	}

}
