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
package tools.descartes.librede.rrde.eval;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Assert;
import org.junit.Test;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.Plugin;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.Discovery;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.optimization.algorithm.impl.ExportAlgorithm;
import tools.descartes.librede.rrde.optimization.algorithm.impl.ExportAlgorithm.FileExporter;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;
import tools.descartes.librede.rrde.recommendation.impl.DecisionTreeAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.NeuralNetworkAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.SVMAlgorithmSpecifierImpl;

/**
 * @author JS
 *
 */
@SuppressWarnings("unused")
public class Evaluate {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(Evaluate.class);

	/**
	 * A link to the desktop.
	 */
	public static final String DESKTOP = "C:" + File.separator + "Users" + File.separator + "Johannes Grohmann"
			+ File.separator + "Desktop";

	/**
	 * The path linking to the test folder.
	 */
	public static final String TESTPATH = "resources" + File.separator + "test" + File.separator + "validation";

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
	public static final String validationfolder = DESKTOP + File.separator + "validation";

	/**
	 * The path for training
	 */
	public static final String trainingfolder = DESKTOP + File.separator + "training";

	/**
	 * The output path, where all output files are stored.
	 */
	// NO IDEA WHY THIS ISNT WORKING WITH DESKTOP
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

	@Test
	public void test() {
		main = new Plugin();
		main.init();
		log.info("Starting initialization");
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

		// adapt configurations to be similar
		for (InputData data : recommendation.getTrainingData()) {
			data.setRootFolder(trainingfolder);
		}
		recommendation.setValidator(EcoreUtil.copy(librede.getValidation()));

		// adapt optimization
		for (RunCall call : optimization.getContainsOf()) {
			for (InputData data : call.getTrainingData()) {
				data.setRootFolder(trainingfolder);
			}
			call.getSettings().setValidator(EcoreUtil.copy(librede.getValidation()));
			if (call.getAlgorithm() instanceof DataExportSpecifier) {
				((DataExportSpecifier) call.getAlgorithm()).setOutputDirectory(OUTPUT);
			}

		}

		// validateOptimizers(EcoreUtil.copy(librede),
		// EcoreUtil.copy(optimization), OUTPUT);

		// validateNothing();

		// validateRecommenders(librede, recommendation, OUTPUT);

		validateOptimizationAndRecommendation(librede, optimization, recommendation, OUTPUT);

	}

	private void validateNothing() {
		librede = Librede.loadConfiguration(new File(TESTPATH + File.separator + "WKF_merged.librede").toPath());
		vali = new TestSetValidator(configs);
		for (LibredeConfiguration c : configs) {
			c.setEstimation(EcoreUtil.copy(librede.getEstimation()));
			Discovery.fixTimeStamps(c);
		}
		Assert.assertNotEquals(vali.getTestset().size(), 0);
		vali.calculateInitialErrors();
		HashSet<EstimationSpecification> set = new HashSet<EstimationSpecification>();
		set.add(librede.getEstimation());
		vali.compareOptimized(set, false);
		vali.printResults(null, null, 0, 0, false);
	}

	/**
	 * @param librede2
	 * @param optimization2
	 * @param recommendation2
	 * @param output2
	 */
	private void validateOptimizationAndRecommendation(LibredeConfiguration librede2,
			OptimizationConfiguration optimization2, RecommendationTrainingConfiguration recommendation2,
			String output2) {
		// load special recommendation with optimized parameters
		RecommendationTrainingConfiguration postreco = Util.loadRecommendationConfiguration(
				new File(TESTPATH + File.separator + "IPOoptimized.recommendation").toPath());
		for (InputData data : postreco.getTrainingData()) {
			data.setRootFolder(trainingfolder);
		}

		Collection<EstimationApproachConfiguration> estimators = new HashSet<>();
		for (EstimationApproachConfiguration app : librede.getEstimation().getApproaches()) {
			estimators.add(EcoreUtil.copy(app));
		}

		// run estimation of comparison
		vali = new TestSetValidator(configs);
		for (LibredeConfiguration c : configs) {
			Discovery.fixTimeStamps(c);
		}
		Assert.assertNotEquals(vali.getTestset().size(), 0);
		vali.calculateInitialErrorsRecommendation(estimators, true);
		// delete the read estimators and replace them with the optimized
		// ones

		// recommendation2.getEstimators().clear();
		// recommendation2.getEstimators().addAll(estimators);

		// train algorithm
		long start = System.currentTimeMillis();
		IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
				.loadAndTrainAlgorithm(postreco);
		IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
				.loadFeatureExtractor(postreco.getFeatureAlgorithm());
		// wrap into Executor
		OptimizedLibredeExecutor exec = new OptimizedLibredeExecutor(extractor, algorithm);
		long reco = System.currentTimeMillis() - start;
		log.info("Finished training! Validating...");

		// print results
		vali.compareOptimized(exec);
		vali.printResults(null, null, 0, reco, true);

	}

	/**
	 * @param the
	 *            file is stored here
	 */
	private void validateRecommenders(LibredeConfiguration libconf, RecommendationTrainingConfiguration conf,
			String output) {
		// leave other parameters default
		DecisionTreeAlgorithmSpecifierImpl tree = new DecisionTreeAlgorithmSpecifierImpl();
		tree.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.SmileTree");
		NeuralNetworkAlgorithmSpecifierImpl nn = new NeuralNetworkAlgorithmSpecifierImpl();
		nn.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.SmileNN");
		SVMAlgorithmSpecifierImpl svm = new SVMAlgorithmSpecifierImpl();
		svm.setGaussianSigma(4);
		svm.setSoftMarginPenalty(1);
		svm.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.SmileSVM");
		RecommendationAlgorithmSpecifier[] algos = { tree, nn, svm };

		IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
				.loadFeatureExtractor(conf.getFeatureAlgorithm());

		FileExporter file = new ExportAlgorithm().new FileExporter(OUTPUT, "recommendationresults.csv");

		// get available estimation approaches
		Collection<EstimationApproachConfiguration> estimators = new HashSet<>();
		for (EstimationApproachConfiguration app : librede.getEstimation().getApproaches()) {
			estimators.add(EcoreUtil.copy(app));
		}

		for (RecommendationAlgorithmSpecifier alg : algos) {
			log.info("Starting " + alg.getAlgorithmName());

			file.writeString("Estimator");
			file.writeString("Aposteriori: Avg. execution time(ms)");
			file.writeString("Aposteriori: Std. deviation time(ms) ");
			file.writeString(alg.getAlgorithmName() + ": Avg. execution time(ms) ");
			file.writeString(alg.getAlgorithmName() + ": Std. deviation time(ms) ");

			file.writeString("Aposteriori: Avg. estimation error");
			file.writeString("Aposteriori: Std. deviation error");
			file.writeString(alg.getAlgorithmName() + ": Avg. estimation error");
			file.writeString(alg.getAlgorithmName() + ": Std. deviation error");

			file.writeString(alg.getAlgorithmName() + ": Training");
			file.writeString(alg.getAlgorithmName() + ": Hitrate");
			file.newLine();
			file.writeString("");

			// run estimation of comparison
			vali = new TestSetValidator(configs);
			for (LibredeConfiguration c : configs) {
				Discovery.fixTimeStamps(c);
			}
			Assert.assertNotEquals(vali.getTestset().size(), 0);
			vali.calculateInitialErrorsRecommendation(estimators, true);

			// set different training algos
			log.info("Training " + alg.getAlgorithmName());
			conf.setLearningAlgorithm(alg);
			long start = System.currentTimeMillis();
			// train algorithm
			IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
					.loadAndTrainAlgorithm(conf);
			OptimizedLibredeExecutor exec = new OptimizedLibredeExecutor(extractor, algorithm);
			long reco = System.currentTimeMillis() - start;

			// print results
			log.info("Validating " + alg.getAlgorithmName());
			vali.compareOptimized(exec);
			vali.printResults(file, null, 0, reco, true);
			file.newLine();

		}
	}

	/**
	 * @param the
	 *            file is stored here
	 */
	private void validateOptimizers(LibredeConfiguration libconf, OptimizationConfiguration conf, String output) {
		ArrayList<RunCall> newRunCalls = new ArrayList<RunCall>();
		String[] algorithmsplit = conf.getContainsOf().get(0).getAlgorithm().getAlgorithmName().split("\\.");
		String algorithmname = algorithmsplit[algorithmsplit.length - 1];
		for (RunCall call : conf.getContainsOf()) {
			if (call.getEstimation().getApproaches().size() > 1) {
				// split up
				for (EstimationApproachConfiguration approach : call.getEstimation().getApproaches()) {
					// deep copy
					RunCall newCall = EcoreUtil.copy(call);

					newCall.setEstimation(EcoreUtil.copy(call.getEstimation()));

					newCall.getEstimation().getApproaches().clear();
					newCall.getEstimation().getApproaches().add(EcoreUtil.copy(approach));

					newRunCalls.add(newCall);
				}
			} else {
				newRunCalls.add(call);
			}
		}
		conf.getContainsOf().clear();

		FileExporter file = new ExportAlgorithm().new FileExporter(OUTPUT, "optimizationresults.csv");

		file.writeString("Estimator");
		file.writeString("Default: Avg. execution time(ms)");
		file.writeString("Default: Std. deviation time(ms) ");
		file.writeString(algorithmname + ": Avg. execution time(ms) ");
		file.writeString(algorithmname + ": Std. deviation time(ms) ");

		file.writeString("Default: Avg. estimation error");
		file.writeString("Default: Std. deviation error");
		file.writeString(algorithmname + ": Avg. estimation error");
		file.writeString(algorithmname + ": Std. deviation error");

		file.writeString(algorithmname + ": Runtime");
		file.newLine();

		for (RunCall run : newRunCalls) {
			conf.getContainsOf().add(run);
			file.writeString(run.getEstimation().getApproaches().get(0).getType());

			// run estimation and comparison
			vali = new TestSetValidator(configs);
			for (LibredeConfiguration c : configs) {
				c.setEstimation(EcoreUtil.copy(run.getEstimation()));
				Discovery.fixTimeStamps(c);
			}
			Assert.assertNotEquals(vali.getTestset().size(), 0);
			vali.calculateInitialErrors();

			log.info("Initialized! Starting optimization...");
			long start = System.currentTimeMillis();
			// run optimization
			Collection<EstimationSpecification> estimations = new tools.descartes.librede.rrde.optimization.Plugin()
					.runConfigurationOptimization(libconf, conf, OUTPUT);
			long opti = System.currentTimeMillis() - start;
			log.info("Finished optimization! Validating...");

			// print results
			vali.compareOptimized(estimations, true);
			vali.printResults(file, null, opti, 0, false);
			file.newLine();
			conf.getContainsOf().remove(run);
		}
		file.close();
		conf.getContainsOf().addAll(newRunCalls);
	}
}
