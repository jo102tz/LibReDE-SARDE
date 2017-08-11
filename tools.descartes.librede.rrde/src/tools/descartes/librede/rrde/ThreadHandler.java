package tools.descartes.librede.rrde;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.util.Util;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;

/**
 * This class handles the online scenario of librede.
 * It schedules the different calculations that have to be done
 * cyclic.
 * 
 * @author Torsten Krauß
 *
 */
public class ThreadHandler extends Thread {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(ThreadHandler.class);

	/**
	 * The thread instances of the online scenario.
	 */
	private OptimizationThread optimizationThread;
	private RecommendationThread recommendationThread;
	private SelectionThread selectionThread;
	private EstimationThread estimationThread;
	/**
	 * The different configurations.
	 */
	private LifeCycleConfiguration lifeCycleConfiguration;
	private OptimizationConfiguration optimizationConfiguration;
	private RecommendationTrainingConfiguration recommendationTrainingConfiguration;
	private LibredeConfiguration libredeConfigurationEstimation;
	//this is only a skeleton for the output
	private LibredeConfiguration libredeConfigurationOptimization;
	/**
	 * The results of the different calculations
	 */
	private Collection<EstimationSpecification> newEstimationSpecifications;
	private Collection<EstimationSpecification> actualEstimationSpecifications;
	private IRecomendationAlgorithm newRecommendationAlgorithm;
	private IRecomendationAlgorithm actualRecommendationAlgorithm;
	private EstimationSpecification newEstimationSpecification;
	private EstimationSpecification actualEstimationSpecification;
	/**
	 * The timestamps and flags for the next executions of the other Threads
	 */
	private long nextExecutionTimeStampOptimization;
	private long nextExecutionTimeStampRecommendation;
	private long nextExecutionTimeStampSelection;
	private long nextExecutionTimeStampEstimation;
	private boolean isExecutionDesiredOptimization;
	private boolean isExecutionDesiredRecommendaton;
	private boolean isExecutionDesiredSelection;
	private boolean isExecutionDesiredEstimation;
	/**
	 * Life cycle helpers of this thread.
	 */
	private boolean isInitialized;
	private volatile boolean stop;
	private volatile boolean isWaiting;
	/**
	 * Filelocations
	 */
	private String folderWithConfigFiles;
	private String folderWithKiekerFiles;
	private String datafolder;
	/**
	 * Lifecycle variables
	 */
	private long triggerIntervallSec;
	private long estimationIntervallSec;
	/**
	 * The constructor of this class.
	 * @param lifeCycleConfiguration
	 * @param folderwithconfigfiles 
	 */
	public ThreadHandler(String datafolder, long triggerIntervalSec, long estimationIntervalSec) {
		log.info("Create ThreadHandler instance...");
		this.isInitialized = false;
		this.stop = false;
		this.folderWithConfigFiles = datafolder+"/config";
		this.folderWithKiekerFiles = datafolder+"/kieker";
		this.datafolder = datafolder;
		this.triggerIntervallSec = triggerIntervalSec;
		this.estimationIntervallSec = estimationIntervalSec;
		log.info("ThreadHandler instance created!");
	}
	
	public void terminate() {
		log.info("Initialize termination of ThreadHandler instance!");
		this.stop = true;
		if(isWaiting){
			this.interrupt();
		}
	}
	
	/**
	 * OPTIMIZATION THREAD RESULTS--------------------------------------------------
	 */
	
	/**
	 * Sets the new EstimationSpecifications calculated from the Optimization
	 * Thread the next data for the Recommendation Thread
	 * @param newData
	 */
	public void setNewEstimationSpecifications(
			Collection<EstimationSpecification> newData) {
		synchronized (this.newEstimationSpecifications) {
			this.newEstimationSpecifications = newData;
			log.info("New Estimation Specification stored!");
		}
	}
	/**
	 * Returns the actual newest List of EstimationSpecifications from the Optimization
	 * Thread. This method is intended to deliver the data to the Recommendation Thread.
	 * @return
	 */
	public Collection<EstimationSpecification> getActualEstimationSpecifications() {
		synchronized (this.newEstimationSpecifications) {
			if(this.newEstimationSpecifications!=null){
				this.actualEstimationSpecifications = this.newEstimationSpecifications;
				this.optimizationConfiguration = null;
				log.info("Actual Estimation Specification updated!");
			}
			log.info("Actual Estimation Specification returned.");
			return actualEstimationSpecifications;
		}
	}
	/**
	 * -----------------------------------------------------------------------------
	 */
	
	/**
	 * RECOMMENDATION THREAD RESULTS--------------------------------------------------
	 */
	/**
	 * This method sets the new results of the Recommendation Thread.
	 * 
	 * @param newRecommendationAlgorithm
	 */
	public void setNewRecommendationAlgorithm(IRecomendationAlgorithm newRecommendationAlgorithm) {
		synchronized (this.newRecommendationAlgorithm) {
			this.newRecommendationAlgorithm = newRecommendationAlgorithm;
			log.info("New Recommendation Algorithm stored!");
		}
	}
	/**
	 * This method returns the actual newest Algorithm generated by the Recommendation
	 * Thread. It is intended to deliver the Algorithm to the Selector Thread.
	 * 
	 * @return
	 */
	public IRecomendationAlgorithm getActualRecommendationAlgorithm() {
		synchronized (this.newRecommendationAlgorithm) {
			if(this.newRecommendationAlgorithm!=null){
				this.actualRecommendationAlgorithm = this. newRecommendationAlgorithm;
				this.newRecommendationAlgorithm = null;
				log.info("Actual Recommendation Algorithm updated!");
			}
			log.info("Actual Recommendation Algorithm returned.");
			return this.actualRecommendationAlgorithm;
		}
	}
	/**
	 * -----------------------------------------------------------------------------
	 */
	/**
	 * SELECTION THREAD RESULTS-----------------------------------------------------
	 */
	/**
	 * This method sets the new results of the Selection Thread.
	 * 
	 * @param newRecommendationAlgorithm
	 */
	public void setNewEstimationSpecification(EstimationSpecification newEstimationSpecification) {
		synchronized (this.newEstimationSpecification) {
			this.newEstimationSpecification = newEstimationSpecification;
			log.info("New Estimation Specification stored!");
		}
	}
	/**
	 * This method returns the actual newest Estimation Specification generated by the
	 * Selection Thread. It is intended to deliver the Specification to the Estimation Thread.
	 * 
	 * @return
	 */
	public EstimationSpecification getActualEstimationSpecification() {
		synchronized (this.newEstimationSpecification) {
			if(this.newEstimationSpecification!=null){
				this.actualEstimationSpecification = this.newEstimationSpecification;
				this.newEstimationSpecification = null;
				log.info("Actual Estimation Specification updated!");
			}
			log.info("Actual Estimation Specification returned.");
			return actualEstimationSpecification;
			
		}
	}
	/**
	 * -----------------------------------------------------------------------------
	 */
	@Override
	public void run() {
		if(!isInitialized){
			//initialize the thread here
			log.info("Initializing ThreadHandler...");
			loadData(this.folderWithConfigFiles);
			this.optimizationThread = new OptimizationThread(this,libredeConfigurationOptimization,
					optimizationConfiguration,datafolder+"/optimizationoutput");
			this.recommendationThread = new RecommendationThread(this, recommendationTrainingConfiguration);
			this.selectionThread = new SelectionThread(this, getActualRecommendationAlgorithm(), 
					null, null);
			this.estimationThread = new EstimationThread(this,libredeConfigurationEstimation);
			log.info("ThreadHandler initialized!");
		}
		log.info("ThreadHandler starts looping...");
		//run until stopped
		while(!stop){
			long timestamp = System.currentTimeMillis();
			//start the desired thread, if the next execution
			//timestamp is reached and, if the thread is
			//not still working
			
			//check the estimation thread
			//if the the next execution timestamp is passed
			if(nextExecutionTimeStampEstimation<=timestamp && !stop){
				//tell the system that a new calculation is desired
				this.isExecutionDesiredEstimation = true;
				//increase the timestamp
				nextExecutionTimeStampEstimation = nextExecutionTimeStampEstimation + (estimationIntervallSec*(long)1000);
			}
			//if a new calculation is desired
			if(this.isExecutionDesiredEstimation && !stop){
				//if the thread is actually not calculating results
				if(!estimationThread.isRunning()){
					//start a new Calcualtion
					estimationThread.start();
					//reset the desire of the system
					this.isExecutionDesiredEstimation = false;
				}
			}
			//check the selection thread
			if(nextExecutionTimeStampSelection<=timestamp && !stop){
				this.isExecutionDesiredSelection = true;
				nextExecutionTimeStampSelection = nextExecutionTimeStampSelection + (lifeCycleConfiguration.getSelectionLoopTime());
			}
			if(this.isExecutionDesiredSelection && !stop){
				//if the thread is actually not calculating results
				if(!selectionThread.isRunning()){
					//start a new Calcualtion
					selectionThread.start();
					this.isExecutionDesiredSelection = false;
				}
			}

			//check the recommendation thread
			if(nextExecutionTimeStampEstimation<=timestamp && !stop){
				this.isExecutionDesiredRecommendaton = true;
				nextExecutionTimeStampRecommendation = nextExecutionTimeStampRecommendation + (lifeCycleConfiguration.getRecommendationLoopTime());
			}
			if(isExecutionDesiredRecommendaton && !stop){
				//if the thread is actually not calculating results
				if(!recommendationThread.isRunning()){
					//start a new Calcualtion
					recommendationThread.start();
					this.isExecutionDesiredRecommendaton = false;
				}
			}
			
			//check the optimization thread
			if(nextExecutionTimeStampOptimization<=timestamp && !stop){
				this.isExecutionDesiredOptimization = true;
				nextExecutionTimeStampOptimization = nextExecutionTimeStampOptimization + (lifeCycleConfiguration.getOptimizationLoopTime());
				
			}
			if(isExecutionDesiredOptimization && !stop){
				//if the thread is actually not calculating results
				if(!optimizationThread.isRunning()){
					//start a new Calcualtion
					optimizationThread.start();
					this.isExecutionDesiredOptimization = false;
				}
			}
			try {
				this.isWaiting = true;
				Thread.sleep(triggerIntervallSec*(long)1000);
			} catch (InterruptedException e) {
				//interrpution
				if(!stop){
					e.printStackTrace();
				}
			}
			this.isWaiting = false;
		}
		log.info("ThreadHandler looping stopped!");
		log.info("Deinitialize ThreadHandler...");
		//these method normally do nothing, because all the threads only have one
		//iteration and end by themselfs.
		optimizationThread.terminate();
		recommendationThread.terminate();
		selectionThread.terminate();
		estimationThread.terminate();
		try {
			log.info("Waiting for EstimationThread instance...");
			estimationThread.join();
			log.info("EstimationThread instance finished!");
			log.info("Waiting for SelectionThread instance...");
			selectionThread.join();
			log.info("SelectionThread instance finished!");
			log.info("Waiting for RecommendationThread instance...");
			recommendationThread.join();
			log.info("RecommendationThread instance finished!");
			log.info("Waiting for OptimizationThread instance...");
			optimizationThread.join();
			log.info("OptimizationThread instance finished!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ThreadHandler deinitialized!");
	}

	private void loadData(String folder){
		log.info("ThreadHandler starts loading configuration files...");
	    libredeConfigurationEstimation = Librede.loadConfiguration(new File(folder+"estimation_amqp.librede").toPath());
	    libredeConfigurationOptimization = Librede.loadConfiguration(new File(folder+"estimation_opt.librede").toPath());
	    optimizationConfiguration = Util.loadOptimizationConfiguration(new File(folder+"optimization.librede").toPath());
	    recommendationTrainingConfiguration = Util.loadRecommendationConfiguration(new File(folder+"recommendation.librede").toPath());
		if(libredeConfigurationEstimation==null||libredeConfigurationOptimization==null||recommendationTrainingConfiguration==null||optimizationConfiguration==null){
			log.error("ThreadHandler could not load the configuration files!!!");
		}
	    log.info("ThreadHandler finished loading configuration files!");
	}
}
