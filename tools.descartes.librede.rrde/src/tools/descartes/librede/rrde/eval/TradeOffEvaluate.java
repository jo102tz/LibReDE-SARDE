package tools.descartes.librede.rrde.eval;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Assert;
import org.junit.Test;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.ValidationSpecification;
import tools.descartes.librede.rrde.Plugin;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.algorithm.impl.ExportAlgorithm;
import tools.descartes.librede.rrde.optimization.algorithm.impl.ExportAlgorithm.FileExporter;
import tools.descartes.librede.rrde.optimization.util.Discovery;
import tools.descartes.librede.rrde.optimization.util.Util;
import tools.descartes.librede.rrde.recommendation.OLSTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.TradeOffLibredeExecutor;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.algorithm.TimeImportance;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;
import tools.descartes.librede.rrde.recommendation.impl.DecisionTreeAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.GaussianProcessRegressionTradeOffAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.GradientTreeBoostTradeOffAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.LASSOTradeOffAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.NeuralNetworkAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.OLSTradeOffAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.RandomForestTradeOffAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.RegressionTreeTradeOffAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.impl.SVMAlgorithmSpecifierImpl;



/**
 * @author Torsten Krauß (torsten.krauss@stud-mail.uni-wuerzburg.de)
 *
 */
@SuppressWarnings("unused")
public class TradeOffEvaluate {
	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(Evaluate.class);

	/**
	 * A link to the desktop.
	 */
	public static final String DESKTOP = File.separator + "home" + File.separator + "torsten"
	    + File.separator + "Schreibtisch";

	/**
	 * The path linking to the test folder.
	 */
	public static final String TESTPATH = "resources" + File.separator + "test" + File.separator
	    + "validation";

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
	public final static String REC_PATH = TESTPATH + File.separator + "confTradeOff.recommendation";
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

	/**
	 * The {@link ValidationSpecification} to be used for calculating the error values.
	 */
	static ValidationSpecification validator;
	
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
	          + " for training and " + validationfolder + " for validation. The validation-share is "
	          + factor + ".");
	      try {
	        TestSetCreator.shuffle(testsetfolder, trainingfolder, validationfolder, factor,
	            DESKTOP.length());
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
	    validator = librede.getValidation();

	    // discover validation configurations
	    for (InputData data : recommendation.getTrainingData()) {
	      data.setRootFolder(validationfolder);
	    }

	    configs = Discovery.createConfigurations(recommendation.getTrainingData(),
	        librede.getEstimation(), validator);

	    // adapt configurations to be similar
	    for (InputData data : recommendation.getTrainingData()) {
	      data.setRootFolder(trainingfolder);
	    }
	    recommendation.setValidator(EcoreUtil.copy(validator));

	    // adapt optimization
	    for (RunCall call : optimization.getContainsOf()) {
	      for (InputData data : call.getTrainingData()) {
	        data.setRootFolder(trainingfolder);
	      }
	      call.getSettings().setValidator(EcoreUtil.copy(validator));
	      if (call.getAlgorithm() instanceof DataExportSpecifier) {
	        ((DataExportSpecifier) call.getAlgorithm()).setOutputDirectory(OUTPUT);
	      }

	    }

	    // calculateOptimalSolutions(EcoreUtil.copy(optimization));

	    //validateOptimizers(EcoreUtil.copy(librede), EcoreUtil.copy(optimization));

	    // validateNothing();

	    // validateRecommenders(librede, recommendation);
	    validateTradeOffRecommender(librede, recommendation);
	    // validateOptimizationAndRecommendation(librede, optimization,
	    // recommendation);
	    // validateAllOptimizersAutomatically(librede, optimization);

	  }
	  
	  private void validateTradeOffRecommender(LibredeConfiguration libconf,
		      RecommendationTrainingConfiguration conf) {
		    // Load the algorithm specifier and specify the algorithm itself
		  //RecommendationAlgorithmSpecifier algorithmSpecifier = conf.getLearningAlgorithm();
		  RecommendationTradeOffAlgorithmSpecifier algorithmSpecifier = new RandomForestTradeOffAlgorithmSpecifierImpl();
		  algorithmSpecifier.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.TradeOffSmileRandomForest");
		  algorithmSpecifier.setTradeOffAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.WeightedRankingTradeOffAlgorithm");
		    //OLSTradeOffAlgorithmSpecifier algorithmSpecifier = new OLSTradeOffAlgorithmSpecifierImpl();
		    //algorithmSpecifier.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.TradeOffSmileOLS");
		    // Load the feature extractor from xml 
		    IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
		        .loadFeatureExtractor(conf.getFeatureAlgorithm());

		    // Create a file for the output
		    FileExporter file = new ExportAlgorithm().new FileExporter(OUTPUT, "recommendationresults.csv");

		    // get available estimation approaches
		    Collection<EstimationApproachConfiguration> estimators = new HashSet<>();
		    for (EstimationApproachConfiguration app : librede.getEstimation().getApproaches()) {
		      estimators.add(EcoreUtil.copy(app));
		    }
		     
		    log.info("Starting " + algorithmSpecifier.getAlgorithmName());

		    file.writeString("Estimator");
		    file.writeString("Aposteriori: Avg. execution time(ms)");
		    file.writeString("Aposteriori: Std. deviation time(ms) ");
		    file.writeString(algorithmSpecifier.getAlgorithmName() + ": Avg. execution time(ms) ");
		    file.writeString(algorithmSpecifier.getAlgorithmName() + ": Std. deviation time(ms) ");

		    file.writeString("Aposteriori: Avg. estimation error");
		    file.writeString("Aposteriori: Std. deviation error");
		    file.writeString(algorithmSpecifier.getAlgorithmName() + ": Avg. estimation error");
		    file.writeString(algorithmSpecifier.getAlgorithmName() + ": Std. deviation error");

		    file.writeString(algorithmSpecifier.getAlgorithmName() + ": Training");
		    file.writeString(algorithmSpecifier.getAlgorithmName() + ": Hitrate");
		    file.newLine();
		    file.writeString("");

		    // run estimation of comparison
		    vali = new TestSetValidator(configs, validator);
		    for (LibredeConfiguration c : configs) {
		      Discovery.fixTimeStamps(c);
		    }
		    Assert.assertNotEquals(vali.getTestset().size(), 0);
		    vali.calculateInitialErrorsRecommendation(estimators, true);

		    //set the learning algorithm
		    log.info("Training " + algorithmSpecifier.getAlgorithmName());
		    conf.setLearningAlgorithm(algorithmSpecifier);
		    long start = System.currentTimeMillis();
		    
		    // train algorithm
		    IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
		          .loadAndTrainAlgorithm(conf);
		    TradeOffLibredeExecutor exec = new TradeOffLibredeExecutor(extractor, algorithm, 0.1, TimeImportance.HIGH);
		    long reco = System.currentTimeMillis() - start;

		    // print results
		    log.info("Validating " + algorithmSpecifier.getAlgorithmName());
		    vali.compareTradeOff(exec);
		    vali.printResults(file, null, 0, reco, true, null);
		    file.newLine();

		  }
}
