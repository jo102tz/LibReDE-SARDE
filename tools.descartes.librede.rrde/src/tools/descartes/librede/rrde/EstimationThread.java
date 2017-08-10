package tools.descartes.librede.rrde;

import org.apache.log4j.Logger;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.optimization.util.Wrapper;
import tools.descartes.librede.rrde.recommendation.FeatureVector;

/**
 * This class runs the estimations of librede.
 * 
 * @author Torsten Krauß
 *
 */
public class EstimationThread extends Thread {
	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(EstimationThread.class);
	/**
	 * The ThreadHandler, that expects the results of the calculation
	 */
	private ThreadHandler threadHandler;
	private LibredeConfiguration libredeConfiguration;
	/**
	 * Life cycle helpers of this thread.
	 */
	private boolean isInitialized;
	
	public EstimationThread(ThreadHandler threadHandler, LibredeConfiguration libredeConfiguration) {
		log.info("Create SelectionThread instance...");
		this.threadHandler = threadHandler;
		this.libredeConfiguration = libredeConfiguration;
		this.isInitialized = false;
		log.info("SelectionThread instance created!");
	}
	
	@Override
	public void run() {
		if(!isInitialized){
			//initialize the thread here
			log.info("Initializing EstimationThread...");
			
			log.info("EstimationThread initialized!");
		}
		log.info("Starting calculations in EstimationThread...");
		Wrapper.executeLibrede(libredeConfiguration);
		log.info("Calculations in EstimationThread finished!");
	}
}
