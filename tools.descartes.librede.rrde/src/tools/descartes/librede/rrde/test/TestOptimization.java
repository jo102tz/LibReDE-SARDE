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
import org.junit.Test;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.eval.StatisticsSummary;
import tools.descartes.librede.rrde.eval.TestResult;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.optimization.impl.LocalSearchSpecifierImpl;
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
	// WARNING! THIS TEST USUALLY TAKES QUITE A WHILE (up to 30 minutes)
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
		long opti = System.currentTimeMillis() - start;
		log.info("Finished optimization! Done...");
		
		// should work with normal optimzation, if not, replace with EcorUtil copies

		// print results
		Map<LibredeConfiguration, TestResult> aftermap = vali.compareOptimized(estimations, true);
		StatisticsSummary stat = vali.printResults(null, null, opti, 0, false, null);

		// here only the best estimator is tested
		testStatValues(stat, 2.076, 0.121, 0, 0, -1, true, false);

		// define test values for individual tests
		HashMap<String, Double> map = new HashMap<>();
		map.put("tools.descartes.librede.approach.KumarKalmanFilterApproach", 0.16239038001301997);

		map.put("tools.descartes.librede.approach.UtilizationRegressionApproach", 0.5072564301634406);

		map.put("tools.descartes.librede.approach.MenasceOptimizationApproach", 0.12162169602939857);

		map.put("tools.descartes.librede.approach.ServiceDemandLawApproach", 0.16389576046097135);

		map.put("tools.descartes.librede.approach.ResponseTimeApproximationApproach", 14.81082321157683);

		map.put("tools.descartes.librede.approach.ResponseTimeRegressionApproach", 0.15788520893140656);

		map.put("tools.descartes.librede.approach.LiuOptimizationApproach", 0.12319083075443728);

		map.put("tools.descartes.librede.approach.WangKalmanFilterApproach", 0.19190897972410062);

		// test individual optimization results
		for (EstimationSpecification est : estimations)
			testSingleEstimator(est, aftermap.keySet().iterator().next(), map.get(est.getApproaches().get(0).getType()));
		
		
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
		for(RunCall call : optimization.getContainsOf()){
			call.setAlgorithm(EcoreUtil.copy(spec));
		}
		
		// repeat
		estimations = new tools.descartes.librede.rrde.optimization.Plugin()
				.runConfigurationOptimization(librede, optimization, OUTPUT);
		log.info("Finished optimization! Done...");

		// print results
		aftermap = vali.compareOptimized(estimations, true);
		stat = vali.printResults(null, null, 1000, 0, false, null);

		// here only the best estimator is tested
		testStatValues(stat, 2.076, 0.121, 0, 0, -1, true, false);
		
		map = new HashMap<>();
		map.put("tools.descartes.librede.approach.KumarKalmanFilterApproach", 0.15584718859352667);

		map.put("tools.descartes.librede.approach.UtilizationRegressionApproach", 0.4440329598946429);

		map.put("tools.descartes.librede.approach.MenasceOptimizationApproach", 0.12163977149660513);

		map.put("tools.descartes.librede.approach.ServiceDemandLawApproach", 0.16184994778564174);

		map.put("tools.descartes.librede.approach.ResponseTimeApproximationApproach", 15.555436667414847);

		map.put("tools.descartes.librede.approach.ResponseTimeRegressionApproach", 0.1583949214134712);

		map.put("tools.descartes.librede.approach.LiuOptimizationApproach", 0.1214197492980892);

		map.put("tools.descartes.librede.approach.WangKalmanFilterApproach", 0.1643574655740587);

		// test individual optimization results
		for (EstimationSpecification est : estimations)
			testSingleEstimator(est, aftermap.keySet().iterator().next(), map.get(est.getApproaches().get(0).getType()));
		
		// set new algorithm
		optimization = Util.loadOptimizationConfiguration(new File(OPT_PATH).toPath());
		for (RunCall call : optimization.getContainsOf()) {
			for (InputData data : call.getTrainingData()) {
				data.setRootFolder(trainingfolder);
			}
			call.getSettings().setValidator(EcoreUtil.copy(librede.getValidation()));
		}
		spec = new LocalSearchSpecifierImpl();
		spec.setAlgorithmName("tools.descartes.librede.rrde.optimization.algorithm.impl.BruteForceAlgorithm");
		spec.setStepSize(1);
		spec.setTolerance(0);
		for(RunCall call : optimization.getContainsOf()){
			call.setAlgorithm(EcoreUtil.copy(spec));
		}
		
		// repeat
		estimations = new tools.descartes.librede.rrde.optimization.Plugin()
				.runConfigurationOptimization(librede, optimization, OUTPUT);
		log.info("Finished optimization! Done...");

		// print results
		aftermap = vali.compareOptimized(estimations, true);
		stat = vali.printResults(null, null, 1000, 0, false, null);

		// here only the best estimator is tested
		testStatValues(stat, 2.076, 0.121, 0, 0, -1, true, false);
		
		map = new HashMap<>();
		map.put("tools.descartes.librede.approach.KumarKalmanFilterApproach", 0.15831290392293898);

		map.put("tools.descartes.librede.approach.UtilizationRegressionApproach", 0.4440329598946429);

		map.put("tools.descartes.librede.approach.MenasceOptimizationApproach", 0.12206043339354765);

		map.put("tools.descartes.librede.approach.ServiceDemandLawApproach", 0.1679372865456179);

		map.put("tools.descartes.librede.approach.ResponseTimeApproximationApproach", 13.877731748883567);

		map.put("tools.descartes.librede.approach.ResponseTimeRegressionApproach", 0.15130280253745343);

		map.put("tools.descartes.librede.approach.LiuOptimizationApproach", 0.12312799702259825);

		map.put("tools.descartes.librede.approach.WangKalmanFilterApproach", 0.42893360138698344);

		// test individual optimization results
		for (EstimationSpecification est : estimations)
			testSingleEstimator(est, aftermap.keySet().iterator().next(), map.get(est.getApproaches().get(0).getType()));

	}

}
