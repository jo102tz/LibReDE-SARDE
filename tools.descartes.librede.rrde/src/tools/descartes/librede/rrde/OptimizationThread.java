package tools.descartes.librede.rrde;

import java.util.Collection;

import org.apache.log4j.Logger;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;

/**
 * This class runs the optimization of librede and returns
 * the results to the Thread Handler.
 * 
 * @author Torsten Krauß
 *
 */
public class OptimizationThread extends Thread {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(OptimizationThread.class);
	/**
	 * The ThreadHandler, that expects the results of the calculation
	 */
	private ThreadHandler threadHandler;
	
	/**
	 * The configurations used in this thread
	 */
	private LibredeConfiguration libredeConfiguration;
	private OptimizationConfiguration optimizationConfiguration;
	private String outputdirectory;
	
	/**
	 * Life cycle helpers of this thread.
	 */
	private boolean isInitialized;
	
	/**
	 * This is the constructor of this thread.
	 * 
	 * @param threadHandler - The calling instance.
	 * @param libredeConfiguration - The skeleton for output (must not be null to get an output).
	 * @param optimizationConfiguration - The input for the calculations.
	 * @param outputdirecotry - The directory to store the different librede configurations (null for no output).
	 */
	public OptimizationThread(ThreadHandler threadHandler, LibredeConfiguration libredeConfiguration, OptimizationConfiguration optimizationConfiguration, String outputdirectory) {
		log.info("Create OptimizationThread instance...");
		this.threadHandler = threadHandler;
		this.libredeConfiguration = libredeConfiguration;
		this.optimizationConfiguration = optimizationConfiguration;
		this.outputdirectory = outputdirectory;
		this.isInitialized = false;
		log.info("OptimizationThread instance created!");
	}

	@Override
	public void run() {
		if(!isInitialized){
			//initialize the thread here
			log.info("Initializing OptimizationThread...");
			
			log.info("OptimizationThread initialized!");
		}
		log.info("Starting calculations in OptimizationThread...");
		Collection<EstimationSpecification> estimations = new tools.descartes.librede.rrde.optimization.Plugin()
				.runConfigurationOptimization(libredeConfiguration, optimizationConfiguration, outputdirectory);
		log.info("Calculations in OptimizationThread finished!");
		log.info("Reporting results from OptimizationThread!");
		this.threadHandler.setNewEstimationSpecifications(estimations);
		log.info("OptimizationThread terminates normally!");
	}
	
	
}
