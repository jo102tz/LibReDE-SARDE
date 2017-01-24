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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
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
import tools.descartes.librede.rrde.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.Discovery;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.optimization.algorithm.impl.ExportAlgorithm;
import tools.descartes.librede.rrde.optimization.algorithm.impl.ExportAlgorithm.FileExporter;
import tools.descartes.librede.rrde.optimization.impl.ConfigurationOptimizationAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.optimization.impl.IterativeParameterOptimizerSpecifierImpl;
import tools.descartes.librede.rrde.optimization.impl.LocalSearchSpecifierImpl;
import tools.descartes.librede.rrde.optimization.impl.StepSizeImpl;
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
	public static final String DESKTOP = "C:" + File.separator + "Users" + File.separator + "Johannes" + File.separator
			+ "Desktop";

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
	 * Contains all available testsets to be used for this run
	 */
	public static final String testsetfolder = DESKTOP + File.separator + "testset";

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

	/**
	 * The share of the testset to be used for validation.
	 */
	static double factor = 0.2;

	@Test
	public void reshuffeling() {
		main = new Plugin();
		main.init();
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you really want to reshuffle the testcases? (Y/N)");
		String ans = sc.nextLine();
		sc.close();
		if (ans.equals("Y") || ans.equals("y")) {
			log.info("Reshuffeling testcases of folder " + testsetfolder + " into " + trainingfolder
					+ " for training and " + validationfolder + " for validation. The validation-share is " + factor
					+ ".");
			try {
				TestSetCreator.shuffle(testsetfolder, trainingfolder, validationfolder, factor, DESKTOP.length());
			} catch (IOException e) {
				log.error("Reshuffling failed.");
				e.printStackTrace();
				Assert.fail("Reshuffling error.");
				return;
			}
			log.info("Reshuffeling Done! Exit.");
		} else {
			log.info("Not reshuffeling. Exit.");
		}
	}

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
		// EcoreUtil.copy(optimization));

		// validateNothing();

		// validateRecommenders(librede, recommendation);

		// validateOptimizationAndRecommendation(librede, optimization,
		// recommendation);
		validateAllOptimizersAutomatically(librede, optimization);

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
		vali.printResults(null, null, 0, 0, false, null);
	}

	private void validateOptimizationAndRecommendation(LibredeConfiguration librede,
			OptimizationConfiguration optimization, RecommendationTrainingConfiguration recommendation) {
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
		vali.printResults(null, null, 0, reco, true, null);

	}

	private void validateRecommenders(LibredeConfiguration libconf, RecommendationTrainingConfiguration conf) {
		// leave other parameters default
		DecisionTreeAlgorithmSpecifierImpl tree = new DecisionTreeAlgorithmSpecifierImpl();
		tree.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.SmileTree");
		NeuralNetworkAlgorithmSpecifierImpl nn = new NeuralNetworkAlgorithmSpecifierImpl();
		nn.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.SmileNN");
		SVMAlgorithmSpecifierImpl svm = new SVMAlgorithmSpecifierImpl();
		svm.setGaussianSigma(4);
		svm.setSoftMarginPenalty(1);
		svm.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.SmileSVM");
		SVMAlgorithmSpecifierImpl warmup = EcoreUtil.copy(svm);
		// first one for warmup
		RecommendationAlgorithmSpecifier[] algos = { warmup, tree, nn, svm };

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
			vali.printResults(file, null, 0, reco, true,null);
			file.newLine();

		}
	}

	private void validateOptimizers(LibredeConfiguration libconf, OptimizationConfiguration conf) {
		String[] algorithmsplit = conf.getContainsOf().get(0).getAlgorithm().getAlgorithmName().split("\\.");
		String algorithmname = algorithmsplit[algorithmsplit.length - 1];

		ArrayList<RunCall> newRunCalls = Util.splitRunCalls(conf);

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
			vali.printResults(file, null, opti, 0, false, null);
			file.newLine();
			conf.getContainsOf().remove(run);
		}
		file.close();
		conf.getContainsOf().addAll(newRunCalls);
	}

	private void validateAllOptimizersAutomatically(LibredeConfiguration libconf, OptimizationConfiguration conf) {
		// put approaches into sorted set
		ArrayList<EstimationApproachConfiguration> estimationList = new ArrayList<>(
				EcoreUtil.copyAll(conf.getContainsOf().get(0).getEstimation().getApproaches()));

		// file heading
		FileExporter file = new ExportAlgorithm().new FileExporter(OUTPUT, "aggregatedoptimizationresults.csv");

		file.writeString("Approach");
		// empty cell
		file.writeString("");
		for (EstimationApproachConfiguration approach : estimationList) {
			file.writeString(Util.shortenApproachName(Util.getSimpleApproachName(approach)));
		}
		file.newLine();

		ArrayList<RunCall> newRunCalls = Util.splitRunCalls(conf);

		// Default
		file.writeString("Default:");
		// empty
		ConfigurationOptimizationAlgorithmSpecifierImpl algorithm = new ConfigurationOptimizationAlgorithmSpecifierImpl();
		algorithm.setAlgorithmName("");
		HashMap<EstimationApproachConfiguration, StatisticsSummary> map = evaluateApproachesWithConfiguration(
				newRunCalls, algorithm, conf, libconf, estimationList);
		printSolutions(file, estimationList, map);

		file.writeString("BruteForce:");
		LocalSearchSpecifier spec = new LocalSearchSpecifierImpl();
		spec.setAlgorithmName("tools.descartes.librede.rrde.optimization.algorithm.impl.BruteForceAlgorithm");
		spec.setStepSize(1);
		spec.setTolerance(0);
		map = evaluateApproachesWithConfiguration(newRunCalls, spec, conf, libconf, estimationList);
		printSolutions(file, estimationList, map);

		file.writeString("LocalSearch:");
		spec = new LocalSearchSpecifierImpl();
		spec.setAlgorithmName("tools.descartes.librede.rrde.optimization.algorithm.impl.HillClimbingAlgorithm");
		spec.setStepSize(1);
		spec.setTolerance(0);
		map = evaluateApproachesWithConfiguration(newRunCalls, spec, conf, libconf, estimationList);
		printSolutions(file, estimationList, map);

		file.writeString("IPO:");
		IterativeParameterOptimizerSpecifier ipo = new IterativeParameterOptimizerSpecifierImpl();
		ipo.setAlgorithmName(
				"tools.descartes.librede.rrde.optimization.algorithm.impl.IterativeParameterOptimizationAlgorithm");
		ipo.setNumberOfSplits(3);
		ipo.setNumberOfExplorations(3);
		ipo.setNumberOfIterations(3);
		map = evaluateApproachesWithConfiguration(newRunCalls, ipo, conf, libconf, estimationList);
		printSolutions(file, estimationList, map);

		// TODO add step size output

		// close up
		file.close();
		conf.getContainsOf().addAll(newRunCalls);
	}

	private HashMap<EstimationApproachConfiguration, StatisticsSummary> evaluateApproachesWithConfiguration(
			ArrayList<RunCall> newRunCalls, ConfigurationOptimizationAlgorithmSpecifier algorithm,
			OptimizationConfiguration conf, LibredeConfiguration libconf,
			ArrayList<EstimationApproachConfiguration> estimationList) {

		HashMap<EstimationApproachConfiguration, StatisticsSummary> map = new HashMap<>();
		for (RunCall run : newRunCalls) {
			conf.getContainsOf().add(run);
			run.setAlgorithm(EcoreUtil.copy(algorithm));

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
			ArrayList<IOptimizableParameter> list = new ArrayList<>();
			list.add(new StepSizeImpl());
			StatisticsSummary stat = vali.printResults(null, null, opti, 0, false, list);
			conf.getContainsOf().remove(run);
			stat.getParameters();

			// TODO install EMF and LIBREDE
			// TODO add parameters (step size)
			map.put(getMatchingEstimation(run.getEstimation().getApproaches().get(0), estimationList), stat);
		}
		return map;
	}

	private EstimationApproachConfiguration getMatchingEstimation(
			EstimationApproachConfiguration estimationApproachConfiguration,
			ArrayList<EstimationApproachConfiguration> estimationList) {
		for (EstimationApproachConfiguration est : estimationList) {
			if (est.getType().equals(estimationApproachConfiguration.getType()))
				return est;
		}
		return null;
	}

	private void printSolutions(FileExporter file, ArrayList<EstimationApproachConfiguration> estimations,
			Map<EstimationApproachConfiguration, StatisticsSummary> map) {

		file.writeString("Optimization time:");
		// iterate through all estimation approaches in order
		for (EstimationApproachConfiguration est : estimations) {
			file.writeDouble(map.get(est).getOptimizationtime());
		}
		file.newLine();

		file.writeString("");
		file.writeString("Avg. execution time (ms):");
		// iterate through all estimation approaches in order
		for (EstimationApproachConfiguration est : estimations) {
			file.writeDouble(map.get(est).getAvgTimeAfter());
		}
		file.newLine();

		file.writeString("");
		file.writeString("Std. deviation time (ms):");
		// iterate through all estimation approaches in order
		for (EstimationApproachConfiguration est : estimations) {
			file.writeDouble(map.get(est).getStdDevTimeAfter());
		}
		file.newLine();

		file.writeString("");
		file.writeString("Avg. estimation error:");
		// iterate through all estimation approaches in order
		for (EstimationApproachConfiguration est : estimations) {
			file.writeDouble(map.get(est).getAvgErrorAfter());
		}
		file.newLine();

		file.writeString("");
		file.writeString("Std. deviation error:");
		// iterate through all estimation approaches in order
		for (EstimationApproachConfiguration est : estimations) {
			file.writeDouble(map.get(est).getStdDevErrorAfter());
		}
		file.newLine();

		file.writeString("");
		file.writeString("Step size value:");
		// iterate through all estimation approaches in order
		for (EstimationApproachConfiguration est : estimations) {
			Double stepsize = -1.0;
			Map<IOptimizableParameter, Double> params = map.get(est).getParameters();
			if (params != null && !params.isEmpty())
				for (IOptimizableParameter p : params.keySet()) {
					if (p instanceof tools.descartes.librede.rrde.optimization.StepSize)
						stepsize = params.get(p);
				}
			file.writeDouble(stepsize);
		}
		file.newLine();
	}

}
