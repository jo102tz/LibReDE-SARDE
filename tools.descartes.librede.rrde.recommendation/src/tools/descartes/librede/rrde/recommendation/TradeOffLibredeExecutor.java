package tools.descartes.librede.rrde.recommendation;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.optimization.util.Discovery;
import tools.descartes.librede.rrde.optimization.util.wrapper.Wrapper;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.algorithm.ITradeOffRecommendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.algorithm.TimeImportance;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;

/**
 * This class accepts an {@link IRecomendationAlgorithm}, as well
 * as a time threshold and the importance of the time with respect to errors
 * and wraps all calls to be optimized.
 * 
 * @author Torsten Krauß (torsten.krauss@stud-mail.uni-wuerzburg.de)
 *
 */
public class TradeOffLibredeExecutor {

	/**
	   * The logger used for logging
	   */
	  private static final Logger log = Logger.getLogger(TradeOffLibredeExecutor.class);

	  private IFeatureExtractor extractor;

	  private IRecomendationAlgorithm algo;
	  
	  private Double timeThreshold;
	  
	  private TimeImportance timeImportance;

	  /**
	   * Constructor specifying the {@link IFeatureExtractor} to use with a trained
	   * {@link IRecomendationAlgorithm}.
	   * 
	   * @param extractor
	   *          {@link IFeatureExtractor} that was used to train the algorithm
	   * @param algo
	   *          {@link IRecomendationAlgorithm} to use for predictions.
	   * @throws IllegalArgumentException
	   *           If {@link IRecomendationAlgorithm#isInTrainingPhase()} returns true
	   */
	  public TradeOffLibredeExecutor(IFeatureExtractor extractor, IRecomendationAlgorithm algo,
			  Double timeThreshold, TimeImportance importance) {
	    super();
	    this.extractor = extractor;
	    this.algo = algo;
	    if (algo.isInTrainingPhase()) {
	      throw new IllegalArgumentException("The recommendation algorithm is not yet fully trained.");
	    }
	    this.timeThreshold = timeThreshold;
	    this.timeImportance = importance;
	  }

	  /**
	   * @return the algo
	   */
	  public IRecomendationAlgorithm getAlgo() {
	    return algo;
	  }

	  /**
	   * @param algo
	   *          the algo to set
	   */
	  public void setAlgo(IRecomendationAlgorithm algo) {
	    this.algo = algo;
	  }

	  /**
	   * @return the extractor
	   */
	  public IFeatureExtractor getExtractor() {
	    return extractor;
	  }

	  /**
	   * @param extractor
	   *          the extractor to set
	   */
	  public void setExtractor(IFeatureExtractor extractor) {
	    this.extractor = extractor;
	  }

	  public TimeImportance getTimeImportance() {
		return timeImportance;
	}
	  public Double getTimeThreshold() {
		return timeThreshold;
	}
	  public void setTimeImportance(TimeImportance timeImportance) {
		this.timeImportance = timeImportance;
	}
	  public void setTimeThreshold(Double timeThreshold) {
		this.timeThreshold = timeThreshold;
	}
	  
	  /**
	   * Tries to analyze the given {@link LibredeConfiguration} and uses its configured
	   * {@link IRecomendationAlgorithm} to search for the best {@link EstimationSpecification}. If that
	   * fails, the unmodified configuration is executed.
	   * 
	   * @param conf
	   *          The {@link LibredeConfiguration} to be run.
	   * @return The {@link LibredeResults} as returned by the standard {@link Librede}.
	   */
	  public LibredeResults executeLibrede(LibredeConfiguration conf) {
	    try {
	      FeatureVector features = extractor.extractFeatures(conf);
	      EstimationSpecification est = null;
	      if(algo instanceof ITradeOffRecommendationAlgorithm){
	    	  est = ((ITradeOffRecommendationAlgorithm)algo).recommendEstimation(features,timeThreshold,timeImportance);
	      }else{
	    	  //est = algo.recommendEstimation(features);
	    	  log.error("Algorithm is not from type ITradeOffRecommendationAlgorithm");
	      }
	      if (est != null) {
	        conf.setEstimation(EcoreUtil.copy(est));
	      } else {
	        log.warn("Recommendation failed. Returning standard result.");
	      }
	    } catch (Exception e) {
	      log.error("There was an unexpected Exception with recommending.",
	          e);
	      throw new RuntimeException(e);
	    }
	    Discovery.fixTimeStamps(conf);
	    return new Wrapper().executeLibrede(conf);
	  }
	
}
