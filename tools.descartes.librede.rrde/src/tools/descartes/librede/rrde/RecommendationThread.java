package tools.descartes.librede.rrde;

import java.util.Collection;

import org.apache.log4j.Logger;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;

/**
 * This class runs the recommendation of librede and returns
 * the results to the Thread Handler.
 * 
 * @author Torsten Krauß
 *
 */
public class RecommendationThread extends Thread {
	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(RecommendationThread.class);
	/**
	 * The ThreadHandler, that expects the results of the calculation
	 */
	private ThreadHandler threadHandler;
	/**
	 * The configurations used in this thread
	 */
	private RecommendationTrainingConfiguration recommendationTrainingConfiguration;
	/**
	 * Life cycle helpers of this thread.
	 */
	private boolean isInitialized;
	private boolean isRunning;
	
	
	public RecommendationThread(ThreadHandler threadHandler, RecommendationTrainingConfiguration recommendationTrainingConfiguration) {
		log.info("Create RecommendationThread instance...");
		this.threadHandler = threadHandler;
		this.recommendationTrainingConfiguration = recommendationTrainingConfiguration;
		this.isInitialized = false;
		this.isRunning = false;
		log.info("RecommendationThread instance created!");
	}
	
	@Override
	public void run() {
		this.isRunning = true;
		if(!isInitialized){
			//initialize the thread here
			log.info("Initializing RecommendationThread...");
			
			log.info("RecommendationThread initialized!");
			isInitialized = true;
		}
		log.info("Starting calculations in RecommendationThread...");
		Collection<EstimationSpecification> actualestimationspecifications = threadHandler.getActualEstimationSpecifications();
		if(actualestimationspecifications!=null){
			recommendationTrainingConfiguration.getEstimators().clear();
			recommendationTrainingConfiguration.getEstimators().addAll(actualestimationspecifications);
			
		}else{
			log.info("RecommendationThread has not yet input data from the OptimizationThread!");
		}
		IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
				.loadAndTrainAlgorithm(recommendationTrainingConfiguration);
		log.info("Calculations in RecommendationThread finished!");
		log.info("Reporting results from RecommendationThread!");
		this.threadHandler.setNewRecommendationAlgorithm(algorithm);
		log.info("RecommendationThread terminates normally!");
		this.isRunning = false;
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	

	public void terminate(){
		if(isRunning){
			//this.interrupt();
		}
	}
}
