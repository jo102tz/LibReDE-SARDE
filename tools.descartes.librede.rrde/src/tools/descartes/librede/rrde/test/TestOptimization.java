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

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Ignore;
import org.junit.Test;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.eval.TestResult;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.model.optimization.impl.LocalSearchSpecifierImpl;
import tools.descartes.librede.rrde.optimization.OptimizationPlugin;
import tools.descartes.librede.rrde.rinterface.RBridge;
import tools.descartes.librede.rrde.util.Util;
import tools.descartes.librede.rrde.util.wrapper.Wrapper;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class TestOptimization extends AbstractTest {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestOptimization.class);

	@Test
	// WARNING! THIS TEST USUALLY TAKES QUITE A WHILE
	public void testS3() {

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

		vali.calculateInitialErrors();
		log.info("Initialized! Starting optimization...");
		long start = System.currentTimeMillis();
		// run optimization
		Collection<EstimationSpecification> estimations = new OptimizationPlugin().runConfigurationOptimization(librede,
				optimization, new Wrapper(), OUTPUT);
		long opti = System.currentTimeMillis() - start;
		log.info("Finished optimization! Done...");
		log.info("Took: " + opti + "ms");

		// should work with normal optimzation, if not, replace with EcorUtil
		// copies

		// print results
		Map<LibredeConfiguration, TestResult> aftermap = vali.compareOptimized(estimations, true);
		Map<LibredeConfiguration, TestResult> beforemap = vali.getBefore();

		if (aftermap.values().size() != 1 || beforemap.values().size() != 1) {
			fail("Size of validation sample didnt match.");
		}

		// define test values for individual tests
		HashMap<String, Double> map = new HashMap<>();
		map.put("tools.descartes.librede.approach.KumarKalmanFilterApproach", 0.12101901025993064);

		map.put("tools.descartes.librede.approach.UtilizationRegressionApproach", 0.2966855761760091);

		map.put("tools.descartes.librede.approach.MenasceOptimizationApproach", 0.1110554480107873);

		map.put("tools.descartes.librede.approach.ServiceDemandLawApproach", 0.1288983656977063);

		map.put("tools.descartes.librede.approach.ResponseTimeApproximationApproach", 10.383485472077957);

		map.put("tools.descartes.librede.approach.ResponseTimeRegressionApproach", 0.14982718034705866);

		map.put("tools.descartes.librede.approach.LiuOptimizationApproach", 0.10513127812915761);

		map.put("tools.descartes.librede.approach.WangKalmanFilterApproach", 0.2174499197465632);

		// test individual optimization results
		for (EstimationSpecification est : estimations)
			testSingleEstimator(est, aftermap.keySet().iterator().next(),
					map.get(est.getApproaches().get(0).getType()));

	}

	@Test
	public void testLocalSearch() {
		// restore default and set new algorithm
		optimization = Util.loadOptimizationConfiguration(new File(OPT_PATH).toPath());
		for (RunCall call : optimization.getContainsOf()) {
			for (InputData data : call.getTrainingData()) {
				data.setRootFolder(trainingfolder);
			}
			call.getSettings().setValidator(EcoreUtil.copy(librede.getValidation()));
		}
		LocalSearchSpecifier spec = new LocalSearchSpecifierImpl();
		spec.setAlgorithmName("tools.descartes.librede.rrde.optimization.algorithm.impl.HillClimbingAlgorithm");
		spec.setStepSize(1);
		spec.setTolerance(0);
		for (RunCall call : optimization.getContainsOf()) {
			call.setAlgorithm(EcoreUtil.copy(spec));
		}

		// repeat
		Collection<EstimationSpecification> estimations = new OptimizationPlugin().runConfigurationOptimization(librede,
				optimization, new Wrapper(), OUTPUT);
		log.info("Finished optimization! Done...");

		// print results
		Map<LibredeConfiguration, TestResult> aftermap = vali.compareOptimized(estimations, true);

		HashMap<String, Double> map = new HashMap<>();
		map.put("tools.descartes.librede.approach.KumarKalmanFilterApproach", 0.11392650410342983);

		map.put("tools.descartes.librede.approach.UtilizationRegressionApproach", 0.5655154888467464);

		map.put("tools.descartes.librede.approach.MenasceOptimizationApproach", 0.10830419820089768);

		map.put("tools.descartes.librede.approach.ServiceDemandLawApproach", 0.12198099155153273);

		map.put("tools.descartes.librede.approach.ResponseTimeApproximationApproach", 10.952402239389489);

		map.put("tools.descartes.librede.approach.ResponseTimeRegressionApproach", 0.15802188951381646);

		map.put("tools.descartes.librede.approach.LiuOptimizationApproach", 0.10818503299960118);

		map.put("tools.descartes.librede.approach.WangKalmanFilterApproach", 0.13669433210379583);

		// test individual optimization results
		for (EstimationSpecification est : estimations)
			testSingleEstimator(est, aftermap.keySet().iterator().next(),
					map.get(est.getApproaches().get(0).getType()));
	}

	// THIS SHOULD WORK, HOWEVER TESTS TAKE WAY TOO LONG, SO IT WAS EXCLUDED FOR
	// AUTOMATED TESTING
	@Test
	@Ignore
	public void testBruteForce() {
		// set new algorithm
		optimization = Util.loadOptimizationConfiguration(new File(OPT_PATH).toPath());
		for (RunCall call : optimization.getContainsOf()) {
			for (InputData data : call.getTrainingData()) {
				data.setRootFolder(trainingfolder);
			}
			call.getSettings().setValidator(EcoreUtil.copy(librede.getValidation()));
		}
		LocalSearchSpecifier spec = new LocalSearchSpecifierImpl();
		spec.setAlgorithmName("tools.descartes.librede.rrde.optimization.algorithm.impl.BruteForceAlgorithm");
		spec.setStepSize(1);
		spec.setTolerance(0);
		for (RunCall call : optimization.getContainsOf()) {
			call.setAlgorithm(EcoreUtil.copy(spec));
		}

		// repeat
		Collection<EstimationSpecification> estimations = new OptimizationPlugin().runConfigurationOptimization(librede,
				optimization, new Wrapper(), OUTPUT);
		log.info("Finished optimization! Done...");

		// print results
		Map<LibredeConfiguration, TestResult> aftermap = vali.compareOptimized(estimations, true);

		HashMap<String, Double> map = new HashMap<>();
		map.put("tools.descartes.librede.approach.KumarKalmanFilterApproach", 0.11890723189927888);

		map.put("tools.descartes.librede.approach.UtilizationRegressionApproach", 0.6150293802231154);

		map.put("tools.descartes.librede.approach.MenasceOptimizationApproach", 0.1070624239826064);

		map.put("tools.descartes.librede.approach.ServiceDemandLawApproach", 0.12940281358431296);

		map.put("tools.descartes.librede.approach.ResponseTimeApproximationApproach", 9.715012995380654);

		map.put("tools.descartes.librede.approach.ResponseTimeRegressionApproach", 0.14978792875864688);

		map.put("tools.descartes.librede.approach.LiuOptimizationApproach", 0.10514545177991287);

		map.put("tools.descartes.librede.approach.WangKalmanFilterApproach", 0.09720415438110785);

		// test individual optimization results
		for (EstimationSpecification est : estimations)
			testSingleEstimator(est, aftermap.keySet().iterator().next(),
					map.get(est.getApproaches().get(0).getType()));
	}

}
