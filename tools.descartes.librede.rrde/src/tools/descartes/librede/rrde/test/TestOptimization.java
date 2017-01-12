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

import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.eval.StatisticsSummary;
import tools.descartes.librede.rrde.eval.TestResult;
import tools.descartes.librede.rrde.rinterface.RBridge;

/**
 * @author JS
 *
 */
public class TestOptimization extends AbstractTest {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestOptimization.class);

	@Test
	public void test() {

		// check if RBridge is available and running
		try {
			RBridge bridge = RBridge.getInstance();
			bridge.runOptimization(null, null, 0, 0, 0);
		} catch (NullPointerException e) {
			// supposed to happen
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			fail("RBridge was not available");
		}

		log.info("Initialized! Starting optimization...");
		long start = System.currentTimeMillis();
		// run optimization
		Collection<EstimationSpecification> estimations = new tools.descartes.librede.rrde.optimization.Plugin()
				.runConfigurationOptimization(librede, optimization, OUTPUT);
		LinkedList<EstimationSpecification> orderedEstimations = new LinkedList<>(estimations);
		long opti = System.currentTimeMillis() - start;
		log.info("Finished optimization! Done...");

		// print results
		Map<LibredeConfiguration, TestResult> aftermap = vali.compareOptimized(orderedEstimations, true);
		StatisticsSummary stat = vali.printResults(null, null, opti, 0, false);

		// here only the best estimator is tested
		testStatValues(stat, 2.076, 0.121, 0, 0, -1, true, false);

		// define test values for individual tests
		HashMap<String, Double> map = new HashMap<>();
		map.put("tools.descartes.librede.approach.KumarKalmanFilterApproach", 0.15913631153458851);

		map.put("tools.descartes.librede.approach.UtilizationRegressionApproach", 0.2087590642133215);

		map.put("tools.descartes.librede.approach.MenasceOptimizationApproach", 0.12206704666806811);

		map.put("tools.descartes.librede.approach.ServiceDemandLawApproach", 0.16472361000470914);

		map.put("tools.descartes.librede.approach.ResponseTimeApproximationApproach", 13.154786927218074);

		map.put("tools.descartes.librede.approach.ResponseTimeRegressionApproach", 0.15913631153458851);

		map.put("tools.descartes.librede.approach.LiuOptimizationApproach", 0.1232117464725842);

		map.put("tools.descartes.librede.approach.WangKalmanFilterApproach", 0.18727236209474354);

		// test individual optimization results
		for (EstimationSpecification est : estimations)
			testStatValue(est, aftermap.keySet().iterator().next(), map.get(est.getApproaches().get(0).getType()));

	}

}
