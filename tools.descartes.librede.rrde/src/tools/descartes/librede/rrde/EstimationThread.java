package tools.descartes.librede.rrde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.datasource.DataSourceSelector;
import tools.descartes.librede.datasource.IDataSource;
import tools.descartes.librede.rrde.optimization.util.Wrapper;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;

/**
 * This class runs the estimations of librede.
 * This is the same functinality as in the ContinuousKiekerReadingTest.java
 * The KiekerAmqpDataSource needs to have the right directory to save the kieker files.
 * 
 * @author Torsten KrauÃŸ
 *
 */
public class EstimationThread extends Thread {
	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(EstimationThread.class);
	/**
	 * The folder for the results
	 */
	private String folderEstimationOutput;
	/**
	 * The ThreadHandler, that expects the results of the calculation
	 */
	private ThreadHandler threadHandler;
	private LibredeConfiguration libredeConfiguration;
	/**
	 * Life cycle helpers of this thread.
	 */
	private boolean isInitialized;
	private boolean isRunning;
	private boolean stop;
	private boolean isWaiting;
	long offsettimeMs; //5mins = 300000
	long calculationintervalMs;//60000
	long pollinginteralMs; //20000
	long maxupdaterepotimeMs; //5000
	long selectionintervalMs;
	/**
	 * Members
	 */
	private Map<String, IDataSource> existingDatasources;
	private DataSourceSelector dataSourceListener;
	LibredeVariables var;
	private IFeatureExtractor featureExtractor;
	
	public EstimationThread(ThreadHandler threadHandler, LibredeConfiguration libredeConfiguration, IFeatureExtractor featureExtractor, long offsettimeMs, long calculationintervalMs, long selectionintervalMs, long pollingintervalMs, long maxupdaterepotimeMs, String folderEstimationOutput) {
		log.info("Create EstimationThread instance...");
		this.threadHandler = threadHandler;
		this.libredeConfiguration = libredeConfiguration;
		this.isInitialized = false;
		this.isRunning = false;
		this.stop = false;
		this.isWaiting = false;
		this.offsettimeMs = offsettimeMs;
		this.calculationintervalMs = calculationintervalMs;
		this.pollinginteralMs = pollingintervalMs;
		this.maxupdaterepotimeMs = maxupdaterepotimeMs;
		this.selectionintervalMs = selectionintervalMs;
		this.var = null;
		this.folderEstimationOutput = folderEstimationOutput;
		this.featureExtractor = featureExtractor;
		log.info("EstimationThread instance created!");
	}
	
	@Override
	public void run() {
		this.isRunning = true;
		if(!isInitialized){
			//initialize the thread here
			log.info("Initializing EstimationThread...");
			existingDatasources = new HashMap<>();
			dataSourceListener = new DataSourceSelector();
			log.info("Loading Librede Variables...");
			var = new LibredeVariables(libredeConfiguration);
			log.info("Initialize DataSources...");
			Librede.initDataSources(var, existingDatasources, dataSourceListener);
			log.info("EstimationThread initialized!");
			isInitialized = true;
		}
		log.info("Starting calculations in EstimationThread...");
		//the next time stamp when librede should calculate resource demands
		long actualtime = System.currentTimeMillis();
		long nextexecutiontimestamp = actualtime+offsettimeMs;
		long nextselectiontimestamp = actualtime+selectionintervalMs;
		while(!stop){
			log.info("Wait until the next calcualtion...");
			//sleep some time to give the repo time to initialize
			//more precise: give the watchthread time to push the initial data to the dataSourceListener
			
			//the time between two update repository iterations
			try {
				isWaiting = true;
				Thread.sleep(pollinginteralMs);
			} catch (InterruptedException e1) {
				if(!stop){
					e1.printStackTrace();
				}
			}
			isWaiting = false;
			if(!stop){
				log.info("Updating repository for some time...");
				Librede.updateRepositoryOnline(maxupdaterepotimeMs, var, existingDatasources, dataSourceListener);
				log.info("Stopped updating repository.");
			}
			if(!stop && System.currentTimeMillis() >= nextselectiontimestamp){
				nextselectiontimestamp = nextselectiontimestamp+selectionintervalMs;
				log.info("Start the next selection...");
				IRecomendationAlgorithm recomendationAlgorithm = threadHandler.getActualRecommendationAlgorithm();
				if(recomendationAlgorithm!=null){
					FeatureVector features = featureExtractor.extractFeatures(var);
				    EstimationSpecification est = recomendationAlgorithm.recommendEstimation(features);
				    if(est!=null){
					    //set the right timestamps in case they are not set yet.
					    if (est.getStartTimestamp() == null || !est.getStartTimestamp().equals(threadHandler.getStarttimestamp())) {
							est.setStartTimestamp(threadHandler.getStarttimestamp());
						}
					    if(est.getEndTimestamp() == null || !est.getEndTimestamp().equals(threadHandler.getEndtimestamp())){
					    	est.setEndTimestamp(threadHandler.getEndtimestamp());
					    }
						log.info("Selection finished!");
						log.info("Reporting results from the selection!");
						this.threadHandler.setNewEstimationSpecification(est);
				    }else{
				    	log.error("The estimation specification given from the recommendation algorithm by selection was null!");
				    }
				}else{
					log.info("Selection does not habe data yet from RecommendationThread!");
				}
				log.info("Start finished!");
			}
			if(!stop && System.currentTimeMillis() >= nextexecutiontimestamp){
				nextexecutiontimestamp = nextexecutiontimestamp+calculationintervalMs;
				log.info("Start the next calcualtion...");
				//get the actual estimation approach
		        EstimationSpecification actualapproach = EcoreUtil.copy(threadHandler.getActualEstimationSpecification());
		        if(actualapproach!=null){
					log.info("Updated to new approach!");
					var.getConf().setEstimation(actualapproach);
		        	
		        }
				//update the repo and calcualte the results
				LibredeResults results = Librede.executeOnline(var, existingDatasources, dataSourceListener);
				//LOG LIBREDE RESULTS
				try {
					log.info("Writing results...");
					File outputfile = new File(folderEstimationOutput+"/results.txt");
					PrintStream outputStream = new PrintStream(new FileOutputStream(outputfile, true));
					Librede.printSummary(results, outputStream);
					outputStream.flush();
					outputStream.close();
					log.info("Results written!");
				} catch (FileNotFoundException e) {
					log.error("WARN: Cannot write output!");
				}
				log.info("Calcualtion done!");
				//clear out the results of this execution
				var.getResults().clear();
			}
		}
		log.info("Librede Process stopped!");
		log.info("Start closing datasources...");
		//close the databases
		for (Entry<String, IDataSource> entry : existingDatasources.entrySet()) {
			try {
				log.info("Closing datasource: "+entry.getKey());
				entry.getValue().close();
			} catch (IOException e) {
				log.error("Error closing data source.", e);
			}
		}
		log.info("Finished closing datasources!");
		log.info("Finish!");
		log.info("Calculations in EstimationThread finished!");
		this.isRunning = false;
	}
	
	public boolean isRunning() {
		return this.isRunning;
		
	}

	public void terminate(){
		this.stop = true;
		if(isRunning){
			if(isWaiting){
				this.interrupt();
			}
		}
	}
}
