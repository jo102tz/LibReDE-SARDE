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

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.datasource.DataSourceSelector;
import tools.descartes.librede.datasource.IDataSource;
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
	private boolean isRunning;
	private boolean stop;
	private boolean isWaiting;
	long offsettime; //5mins = 300000
	long calculationinterval;//60000
	long pollinginteral; //20000
	long maxupdaterepotime; //5000
	/**
	 * Members
	 */
	private Map<String, IDataSource> existingDatasources;
	private DataSourceSelector dataSourceListener;
	LibredeVariables var;
	
	public EstimationThread(ThreadHandler threadHandler, LibredeConfiguration libredeConfiguration, long offsettime, long calculationinterval, long pollinginterval, long maxupdaterepotime) {
		log.info("Create SelectionThread instance...");
		this.threadHandler = threadHandler;
		this.libredeConfiguration = libredeConfiguration;
		this.isInitialized = false;
		this.isRunning = false;
		this.stop = false;
		this.isWaiting = false;
		this.offsettime = offsettime;
		this.calculationinterval = calculationinterval;
		this.pollinginteral = pollinginterval;
		this.maxupdaterepotime = maxupdaterepotime;
		this.var = null;
		log.info("SelectionThread instance created!");
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
		long nextexecutiontimestamp = actualtime+offsettime;
		while(!stop){
			log.info("Wait until the next calcualtion...");
			//sleep some time to give the repo time to initialize
			//more precise: give the watchthread time to push the initial data to the dataSourceListener
			
			//the time between two update repository iterations
			try {
				isWaiting = true;
				Thread.sleep(pollinginteral);
			} catch (InterruptedException e1) {
				if(!stop){
					e1.printStackTrace();
				}
			}
			isWaiting = false;
			if(!stop){
				log.info("Updating repository for some time...");
				Librede.updateRepositoryOnline(maxupdaterepotime, var, existingDatasources, dataSourceListener);
				log.info("Stopped updating repository.");
			}
			if(!stop && System.currentTimeMillis() >= nextexecutiontimestamp){
				log.info("Start the next calcualtion...");
				//update the repo and calcualte the results
				LibredeResults results = Librede.executeOnline(var, existingDatasources, dataSourceListener);
				try {
					log.info("Writing results...");
					File outputfile = new File("/home/torsten/Schreibtisch/jettytests/local/1l_600s_500t_ubuntu_visits/info/results.txt");
					PrintStream outputStream = new PrintStream(new FileOutputStream(outputfile, true));
					Librede.printSummary(results, outputStream);
					outputStream.flush();
					outputStream.close();
					log.info("Results written!");
				} catch (FileNotFoundException e) {
					log.error("WARN: Cannot write output!");
				}
				log.info("Calcualtion done!");
				nextexecutiontimestamp = nextexecutiontimestamp+calculationinterval;
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
