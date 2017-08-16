package tools.descartes.librede.rrde;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.Parameter;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.util.Util;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;

/**
 * This class handles the online scenario of librede.
 * It schedules the different calculations that have to be done
 * cyclic.
 * 
 * @author Torsten KrauÃŸ
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
	 * The semaphores to lock the variables
	 */
	private Semaphore semaphoreEstimation;
	private Semaphore semaphoreRecommendation;
	private Semaphore semaphoreEstimations;
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
	//the folder for the experiment output
	//always has to be named "info"
	public static String folderInfo;
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
	 * The timestamps to be consistent
	 */
	private Quantity<Time> starttimestamp;
	private Quantity<Time> endtimestamp;
	
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
		this.folderInfo = datafolder+"/info";
		this.datafolder = datafolder;
		this.triggerIntervallMs = triggerIntervalMs;
		this.offsettimeMs = offsettimeMs;
		//load the config files
		loadData(this.folderWithConfigFiles);
		this.starttimestamp = EcoreUtil.copy(libredeConfigurationEstimation.getEstimation().getStartTimestamp());
		this.endtimestamp = EcoreUtil.copy(libredeConfigurationEstimation.getEstimation().getEndTimestamp());
		this.lifeCycleConfiguration.setEstimationLoopTime(estimationLoopMs);
		this.lifeCycleConfiguration.setRecommendationLoopTime(recommendationLoopMs);
		this.lifeCycleConfiguration.setOptimizationLoopTime(optimizationLoopMs);
		this.lifeCycleConfiguration.setSelectionLoopTime(selectionLoopMs);
		this.semaphoreEstimation = new Semaphore(1);
		this.semaphoreRecommendation = new Semaphore(1);
		this.semaphoreEstimations = new Semaphore(1);
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
			//initialize the threads
			IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
					.loadFeatureExtractor(recommendationTrainingConfiguration.getFeatureAlgorithm());
			this.estimationThread = new EstimationThread(this,libredeConfigurationEstimation, extractor, offsettimeMs, lifeCycleConfiguration.getEstimationLoopTime(), lifeCycleConfiguration.getSelectionLoopTime(), 2000, 5000, folderEstimationOutput);
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
		int counteropt = 0;
		//run until stopped
		while(!stop){
			long timestamp = System.currentTimeMillis();
			//start the desired thread, if the next execution
			//timestamp is reached and, if the thread is
			//not still working

			//check the recommendation thread
			if(nextExecutionTimeStampRecommendation<=timestamp && !stop){
				//if the thread is actually not calculating results
				if((recommendationThread==null || !recommendationThread.isRunning())
						 && minimumTowTracesAvailable(recommendationTrainingConfiguration.getTrainingData().get(0).getRootFolder())){
					//start a new Calcualtion
					this.recommendationThread = new RecommendationThread(this, recommendationTrainingConfiguration);
					recommendationThread.start();
					log.error("STARTED RECOMMENDATION");
				}
				nextExecutionTimeStampRecommendation = nextExecutionTimeStampRecommendation + (lifeCycleConfiguration.getRecommendationLoopTime());
			}
			
			//check the optimization thread
			if(nextExecutionTimeStampOptimization<=timestamp && !stop){
				//if the thread is actually not calculating results
				if((optimizationThread==null || !optimizationThread.isRunning()) 
						&& minimumTowTracesAvailable(optimizationConfiguration.getContainsOf().get(0).getTrainingData().get(0).getRootFolder())){
					//start a new Calcualtion
					//if(counteropt==0){
					this.optimizationConfiguration = null;
					this.optimizationConfiguration = Util.loadOptimizationConfiguration(new File(this.folderWithConfigFiles+"/conf.optimization").toPath());;
					this.optimizationThread = new OptimizationThread(this,libredeConfigurationOptimization,
							optimizationConfiguration,folderOptimizationOutput);
					optimizationThread.start();
					log.error("STARTED OPTIMIZATION");
					
					//counteropt++;
					//}
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
		if(optimizationThread!=null){
			optimizationThread.terminate();
		}
		if(recommendationThread!=null){
			recommendationThread.terminate();
		}
		if(estimationThread!=null){
			estimationThread.terminate();
		}

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

	private boolean minimumTowTracesAvailable(String rootFolder) {
		boolean rc = false;
		File file = new File(rootFolder);
		if(file.exists() && file.isDirectory()){
			File[] files = file.listFiles(new FileFilter() {
			    @Override
			    public boolean accept(File f) {
			        return f.isDirectory();
			    }
			});
			rc = files.length>=2;
		}
		return rc;
	}
	private void loadData(String folder){
		log.info("ThreadHandler starts loading configuration files...");
		lifeCycleConfiguration = Util.loadLifecycleConfiguration(new File(folder+"/conf.lifecycle").toPath());
		libredeConfigurationEstimation = Librede.loadConfiguration(new File(folder+"/estimation_amqp.librede").toPath());
		//libredeConfigurationSelection = Librede.loadConfiguration(new File(folder+"/estimation_sel.librede").toPath());
	    libredeConfigurationOptimization = Librede.loadConfiguration(new File(folder+"/estimation_opt.librede").toPath());
	    optimizationConfiguration = Util.loadOptimizationConfiguration(new File(folder+"/conf.optimization").toPath());
	    recommendationTrainingConfiguration = Util.loadRecommendationConfiguration(new File(folder+"/conf.recommendation").toPath());
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
		try {
			semaphoreEstimations.acquire();
			if(newData!=null&&newData.size()!=0){
				log.error("OPTIMIZATION RESULT AVAILABLE");
			}else{
				log.error("NO OPTIMIZATION RESULT AVAILABLE");
			}
			this.newEstimationSpecifications = newData;
			log.info("New Estimation Specification stored!");
			semaphoreEstimations.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("ERROR: Threads not synchronized anymore. (Estimations)");
		}
	}
	/**
	 * Returns the actual newest List of EstimationSpecifications from the Optimization
	 * Thread. This method is intended to deliver the data to the Recommendation Thread.
	 * @return
	 */
	public Collection<EstimationSpecification> getActualEstimationSpecifications() {
		try {
			log.error("TRY TO PULL THE OPTIMIZATION RESULT BY RECOMMENDATION");
			semaphoreEstimations.acquire();
			if(this.newEstimationSpecifications!=null){
				log.error("PULLED THE OPTIMIZATION RESULT BY RECOMMENDATION");
				this.actualEstimationSpecifications = this.newEstimationSpecifications;
				this.newEstimationSpecifications = null;
				log.info("Actual Estimation Specification updated!");
			}
			log.info("Actual Estimation Specification returned.");
			semaphoreEstimations.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("ERROR: Threads not synchronized anymore. (Estimations)");
		}
		return actualEstimationSpecifications;
		
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
		try {
			semaphoreRecommendation.acquire();
			if(newRecommendationAlgorithm!=null){
				log.error("RECOMMENDATION RESULT ALGORITHM AVAILABLE");
			}else{
				log.error("NO RECOMMENDATION RESULT ALGORITHM AVAILABLE");
			}
			this.newRecommendationAlgorithm = newRecommendationAlgorithm;
			log.info("New Recommendation Algorithm stored!");
			semaphoreRecommendation.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("ERROR: Threads not synchronized anymore. (Recommendation)");
		}
	}
	/**
	 * This method returns the actual newest Algorithm generated by the Recommendation
	 * Thread. It is intended to deliver the Algorithm to the Selector Thread.
	 * 
	 * @return
	 */
	public IRecomendationAlgorithm getActualRecommendationAlgorithm() {
		try {
			semaphoreRecommendation.acquire();
			if(this.newRecommendationAlgorithm!=null){
				log.error("PULLED RECOMMENDATION RESULT BY SELECTION");
				this.actualRecommendationAlgorithm = this. newRecommendationAlgorithm;
				this.newRecommendationAlgorithm = null;
				log.info("Actual Recommendation Algorithm updated!");
			}
			log.info("Actual Recommendation Algorithm returned.");
			semaphoreRecommendation.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("ERROR: Threads not synchronized anymore. (Recommendation)");
		}

		return this.actualRecommendationAlgorithm;
		
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
		try {
			semaphoreEstimation.acquire();
			this.newEstimationSpecification = null;
			this.newEstimationSpecification = newEstimationSpecification;
			log.error("NEW ALGORITHM SET");
			log.info("New Estimation Specification stored!");
			semaphoreEstimation.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("ERROR: Threads not synchronized anymore. (Estimation)");
		}
	}
	/**
	 * This method returns the actual newest Estimation Specification generated by the
	 * Selection Thread. It is intended to deliver the Specification to the Estimation Thread.
	 * 
	 * @return
	 */
	public EstimationSpecification getActualEstimationSpecification() {
		try {
			semaphoreEstimation.acquire();
			if(this.newEstimationSpecification!=null){
				log.error("NEW ALGORITHM PULLED");
				this.actualEstimationSpecification = this.newEstimationSpecification;
				this.newEstimationSpecification = null;
				log.info("Actual Estimation Specification updated!");
			}
			log.info("Actual Estimation Specification returned.");
			semaphoreEstimation.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("ERROR: Threads not synchronized anymore. (Estimation)");
		}
		return actualEstimationSpecification;
	}
	/**
	 * -----------------------------------------------------------------------------
	 */
	public Quantity<Time> getStarttimestamp() {
		return starttimestamp;
	}
	public Quantity<Time> getEndtimestamp() {
		return endtimestamp;
	}
}
