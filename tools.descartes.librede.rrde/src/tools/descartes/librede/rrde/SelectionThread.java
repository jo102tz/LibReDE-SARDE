package tools.descartes.librede.rrde;

import org.apache.log4j.Logger;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;

/**
 * This class runs the selection of librede and returns
 * the results to the Thread Handler.
 * 
 * @author Torsten Krauß
 *
 */
public class SelectionThread extends Thread {
	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(SelectionThread.class);
	/**
	 * The ThreadHandler, that expects the results of the calculation
	 */
	private ThreadHandler threadHandler;
	/**
	 * The configurations used in this thread
	 */
	private LibredeConfiguration libredeConfiguration;	
	private IFeatureExtractor featureExtractor;
	private IRecomendationAlgorithm recomendationAlgorithm;
	/**
	 * Life cycle helpers of this thread.
	 */
	private boolean isInitialized;
	private boolean isRunning;
	
	public SelectionThread(ThreadHandler threadHandler, IRecomendationAlgorithm recomendationAlgorithm, LibredeConfiguration libredeConfiguration, IFeatureExtractor featureExtractor) {
		log.info("Create SelectionThread instance...");
		this.threadHandler = threadHandler;
		this.libredeConfiguration = libredeConfiguration;
		this.featureExtractor = featureExtractor;
		this.recomendationAlgorithm = recomendationAlgorithm;
		this.isInitialized = false;
		this.isRunning = false;
		log.info("SelectionThread instance created!");
	}
	
	@Override
	public void run() {
		this.isRunning = true;
		if(!isInitialized){
			//initialize the thread here
			log.info("Initializing SelectionThread...");
			
			log.info("SelectionThread initialized!");
		}
		log.info("Starting calculations in SelectionThread...");
		FeatureVector features = featureExtractor.extractFeatures(libredeConfiguration);
	      EstimationSpecification est = recomendationAlgorithm.recommendEstimation(features);
		log.info("Calculations in SelectionThread finished!");
		log.info("Reporting results from SelectionThread!");
		this.threadHandler.setNewEstimationSpecification(est);
		log.info("SelectionThread terminates normally!");
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
