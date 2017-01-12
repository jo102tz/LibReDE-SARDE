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

import java.io.File;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Assert;
import org.junit.BeforeClass;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.Plugin;
import tools.descartes.librede.rrde.eval.StatisticsSummary;
import tools.descartes.librede.rrde.eval.TestSetValidator;
import tools.descartes.librede.rrde.optimization.Discovery;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.optimization.Wrapper;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;

/**
 * @author JS
 *
 */
public class AbstractTest {

	/**
	 * The path linking to the test folder.
	 */
	public static final String TESTPATH = "resources" + File.separator + "test" + File.separator + "junit";

	/**
	 * The path to the default {@link LibredeConfiguration}
	 */
	public final static String LIB_PATH = TESTPATH + File.separator + "estimation.librede";

	/**
	 * The path to the default {@link OptimizationConfiguration}
	 */
	public final static String OPT_PATH = TESTPATH + File.separator + "conf.optimization";

	/**
	 * The path to the default {@link RecommendationTrainingConfiguration}
	 */
	public final static String REC_PATH = TESTPATH + File.separator + "conf.recommendation";
	/**
	 * The path for validation
	 */
	public static final String validationfolder = TESTPATH + File.separator + "validation";

	/**
	 * The path for training
	 */
	public static final String trainingfolder = TESTPATH + File.separator + "training";

	/**
	 * The output path, where all output files are stored.
	 */
	public final static String OUTPUT = TESTPATH + File.separator + "output";

	/**
	 * The testset used for validation.
	 */
	static Set<LibredeConfiguration> configs;

	/**
	 * The configuration read.
	 */
	static LibredeConfiguration librede;

	/**
	 * The optimization configuration read.
	 */
	static OptimizationConfiguration optimization;

	/**
	 * The recommendation configuration read.
	 */
	static RecommendationTrainingConfiguration recommendation;

	/**
	 * The validator used.
	 */
	static TestSetValidator vali;

	/**
	 * A PLugin instance.
	 */
	static Plugin main;

	@BeforeClass
	public static void init() {
		main = new Plugin();
		main.init();
		// load config files
		librede = Librede.loadConfiguration(new File(LIB_PATH).toPath());
		optimization = Util.loadOptimizationConfiguration(new File(OPT_PATH).toPath());
		recommendation = Util.loadRecommendationConfiguration(new File(REC_PATH).toPath());

		// discover validation configurations
		for (InputData data : recommendation.getTrainingData()) {
			data.setRootFolder(validationfolder);
		}

		configs = Discovery.createConfigurations(recommendation.getTrainingData(), librede.getEstimation(),
				librede.getValidation());
		// check if size is correct
		Assert.assertEquals(new File(validationfolder).list().length, configs.size());

		// adapt configurations to be similar
		for (InputData data : recommendation.getTrainingData()) {
			data.setRootFolder(trainingfolder);
		}
		recommendation.setValidator(EcoreUtil.copy(librede.getValidation()));

		// adapt configurations to be similar
		for (RunCall call : optimization.getContainsOf()) {
			for (InputData data : call.getTrainingData()) {
				data.setRootFolder(trainingfolder);
			}
			call.getSettings().setValidator(EcoreUtil.copy(librede.getValidation()));
		}

		vali = new TestSetValidator(configs);
		Assert.assertNotEquals(vali.getTestset().size(), 0);
		vali.calculateInitialErrors();

	}

	/**
	 * Tests if the given values are met and fails the test if not.
	 * 
	 * @param stat
	 *            The {@link StatisticsSummary} to test.
	 * @param avgBefore
	 *            The average error before.
	 * @param avgAfter
	 *            The average error after.
	 * @param beforeignored
	 *            The number of data sets that were ignored before.
	 * @param afterignored
	 *            The number of data sets that were ignored after.
	 * @param hitrate
	 *            The hitrate of the recommendation algorithm or -1 if not
	 *            applicable.
	 * @param optimizationtime
	 *            If true, the time spent on optimization must not be zero. If
	 *            false, it must be zero.
	 * @param recommendationtime
	 *            If true, the time spent on recommendation must not be zero. If
	 *            false, it must be zero.
	 */
	public void testStatValues(StatisticsSummary stat, double avgBefore, double avgAfter, int beforeignored,
			int afterignored, double hitrate, boolean optimizationtime, boolean recommendationtime) {
		// ignore runtime, since different on different machines
		Assert.assertEquals(avgBefore, stat.getAvgErrorBefore(), 0.01);
		Assert.assertEquals(avgAfter, stat.getAvgErrorAfter(), 0.01);
		Assert.assertEquals(beforeignored, stat.getBeforeignored());
		Assert.assertEquals(afterignored, stat.getAfterignored());
		if (hitrate >= 0)
			Assert.assertEquals(hitrate, stat.getHitrate(), 0.01);
		if (recommendationtime)
			Assert.assertNotEquals(0, stat.getRecommendationtime());
		else
			Assert.assertEquals(0, stat.getRecommendationtime());
		if (optimizationtime)
			Assert.assertNotEquals(0, stat.getOptimizationtime());
		else
			Assert.assertEquals(0, stat.getOptimizationtime());
	}
	

	/**
	 * Tests if the given values are met and fails the test if not.
	 * 
	 * @param est
	 *            {@link EstimationSpecification} to use.
	 * @param libredeConfiguration
	 *            The {@link LibredeConfiguration} to use.
	 * @param expected
	 *            The expected Value
	 */
	public void testStatValue(EstimationSpecification est, LibredeConfiguration libredeConfiguration,
			Double expected) {
		libredeConfiguration.setEstimation(EcoreUtil.copy(est));
		Discovery.fixTimeStamps(libredeConfiguration);
		LibredeResults res = Wrapper.executeLibrede(libredeConfiguration);
		Assert.assertEquals(expected, Util.getMeanValidationError(res), 0.01);
	}

}
