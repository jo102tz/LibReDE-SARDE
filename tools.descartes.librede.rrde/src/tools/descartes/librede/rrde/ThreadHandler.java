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
	/**
	 * Life cycle helpers of this thread.
	 */
	private boolean isInitialized;
	private volatile boolean stop;
	private volatile boolean isWaiting;
	/**
	 * Filelocations
	 */
	//folder with the files to read: .librede, .recommendaton, .optimization
	//always has to be named "config"
	private String folderWithConfigFiles;
	//the folder, where the datasources save the kieker files and read them again
	//this directory has to be set to the KiekerAmqpDataSource to be written to
	//always has to be named "kieker"
	private String folderWithKiekerFiles;
	//the folder for the optimization output
	//always has to be named "optimizationoutput"
	private String folderOptimizationOutput;
	//the folder for the estimation output
	//always has to be named "estimationoutput"
	private String folderEstimationOutput;
	//the parent folder of all data for one run
	private String datafolder;
	/**
	 * Lifecycle variables
	 */
	//The intervall in which the loop times are checked
	private long triggerIntervallMs;
	//the offset set to all calcualtions
	private long offsettimeMs;
	/**
	 * The constructor of this class.
	 * @param datafolder - the root folder of the data
	 * @param triggerIntervalMs - the intervall we use to check the loop times
	 * @param offsettimeMs - the offset of all the calculations
	 * @param estimationLoopMs
	 * @param selectionLoopMs
	 * @param recommendationLoopMs
	 * @param optimizationLoopMs
	 */
	public ThreadHandler(String datafolder, long triggerIntervalMs, long offsettimeMs, long estimationLoopMs, long selectionLoopMs, long recommendationLoopMs, long optimizationLoopMs) {
		log.info("Create ThreadHandler instance...");
		this.isInitialized = false;
		this.stop = false;
		this.folderWithConfigFiles = datafolder+"/config";
		this.folderWithKiekerFiles = datafolder+"/kieker";
		this.folderOptimizationOutput = datafolder+"/optimizationoutput";
		this.folderEstimationOutput = datafolder+"/estimationoutput";
		this.datafolder = datafolder;
		this.triggerIntervallMs = triggerIntervalMs;
		this.offsettimeMs = offsettimeMs;
		this.lifeCycleConfiguration = ...;
		this.lifeCycleConfiguration.setEstimationLoopTime(estimationLoopMs);
		this.lifeCycleConfiguration.setRecommendationLoopTime(recommendationLoopMs);
		this.lifeCycleConfiguration.setOptimizationLoopTime(optimizationLoopMs);
		this.lifeCycleConfiguration.setSelectionLoopTime(selectionLoopMs);
		log.info("ThreadHandler instance created!");
	}
	/**
	 * Terminates the Thread.
	 */
	public void terminate() {
		log.info("Initialize termination of ThreadHandler instance!");
		this.stop = true;
		if(isWaiting){
			this.interrupt();
		}
	}
	
	/**
	 * The runnable of this thread.
	 */
	@Override
	public void run() {
		if(!isInitialized){
			//initialize the thread here
			log.info("Initializing ThreadHandler...");
			//load the config files
			loadData(this.folderWithConfigFiles);
			//initialize the threads
			this.optimizationThread = new OptimizationThread(this,libredeConfigurationOptimization,
					optimizationConfiguration,folderOptimizationOutput);
			this.recommendationThread = new RecommendationThread(this, recommendationTrainingConfiguration);
			this.selectionThread = new SelectionThread(this, getActualRecommendationAlgorithm(), 
					null, null);
			this.estimationThread = new EstimationThread(this,libredeConfigurationEstimation, offsettimeMs, lifeCycleConfiguration.getEstimationLoopTime(), 2000, 5000, folderEstimationOutput);
			//start the estimation thread, and therefore the data collecting
			this.estimationThread.start();
			//set the firsst execution timestamps
			long timestamp = System.currentTimeMillis();
			nextExecutionTimeStampOptimization = timestamp+lifeCycleConfiguration.getOptimizationLoopTime();
			nextExecutionTimeStampRecommendation = timestamp+lifeCycleConfiguration.getRecommendationLoopTime();
			nextExecutionTimeStampSelection = timestamp+lifeCycleConfiguration.getSelectionLoopTime();
			log.info("ThreadHandler initialized!");
			isInitialized = true;
		}
		log.info("ThreadHandler starts looping...");
		//run until stopped
		while(!stop){
			long timestamp = System.currentTimeMillis();
			//start the desired thread, if the next execution
			//timestamp is reached and, if the thread is
			//not still working
			
			//check the selection thread
			if(nextExecutionTimeStampSelection<=timestamp && !stop){
				//if the thread is actually not calculating results
				if(!selectionThread.isRunning()){
					//start a new Calcualtion
					selectionThread.start();
				}
				nextExecutionTimeStampSelection = nextExecutionTimeStampSelection + (lifeCycleConfiguration.getSelectionLoopTime());
			}

			//check the recommendation thread
			if(nextExecutionTimeStampRecommendation<=timestamp && !stop){
				//if the thread is actually not calculating results
				if(!recommendationThread.isRunning()){
					//start a new Calcualtion
					recommendationThread.start();
				}
				nextExecutionTimeStampRecommendation = nextExecutionTimeStampRecommendation + (lifeCycleConfiguration.getRecommendationLoopTime());
			}
			
			//check the optimization thread
			if(nextExecutionTimeStampOptimization<=timestamp && !stop){
				//if the thread is actually not calculating results
				if(!optimizationThread.isRunning()){
					//start a new Calcualtion
					optimizationThread.start();
				}
				nextExecutionTimeStampOptimization = nextExecutionTimeStampOptimization + (lifeCycleConfiguration.getOptimizationLoopTime());
			}
			try {
				this.isWaiting = true;
				Thread.sleep(triggerIntervallMs);
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
			/*log.info("Waiting for SelectionThread instance...");
			selectionThread.join();
			log.info("SelectionThread instance finished!");
			log.info("Waiting for RecommendationThread instance...");
			recommendationThread.join();
			log.info("RecommendationThread instance finished!");
			log.info("Waiting for OptimizationThread instance...");
			optimizationThread.join();
			log.info("OptimizationThread instance finished!");*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ThreadHandler deinitialized!");
	}

	private void loadData(String folder){
		log.info("ThreadHandler starts loading configuration files...");
		lifeCycleConfiguration = Librede.loadConfiguration(new File(folder+"estimation_amqp.librede").toPath());
	    libredeConfigurationEstimation = Librede.loadConfiguration(new File(folder+"estimation_amqp.librede").toPath());
	    libredeConfigurationOptimization = Librede.loadConfiguration(new File(folder+"estimation_opt.librede").toPath());
	    optimizationConfiguration = Util.loadOptimizationConfiguration(new File(folder+"optimization.librede").toPath());
	    recommendationTrainingConfiguration = Util.loadRecommendationConfiguration(new File(folder+"recommendation.librede").toPath());
		if(libredeConfigurationEstimation==null||libredeConfigurationOptimization==null||recommendationTrainingConfiguration==null||optimizationConfiguration==null){
			log.error("ThreadHandler could not load the configuration files!!!");
		}
	    log.info("ThreadHandler finished loading configuration files!");
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
	
}
