package tools.descartes.librede.rrde.test;

import java.io.File;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import tools.descartes.librede.Librede;
import tools.descartes.librede.bayesplusplus.BayesLibrary;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.ipopt.java.IpoptLibrary;
import tools.descartes.librede.nnls.NNLSLibrary;
import tools.descartes.librede.rrde.ThreadHandler;
import tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;

public class TestOnline{

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestCombination.class);
	/**
	 * The used variables in this test.
	 */
	private String datafolder = "";
	
	
	@BeforeClass
	public static void register() {
		log.info("Initialize Librede...");
		Librede.initLogging();
		Librede.init();
		//Librede.init();
		IpoptLibrary.init();
		NNLSLibrary.init();
		BayesLibrary.init();
		log.info("Librede initialized!");
	}
	
	
	@Test
	public void test() {
		log.info("Starting the test...");
		//create the runner class
		ThreadHandler threadHandler = new ThreadHandler(datafolder, 2, 60);
		//start it
		threadHandler.start();
		System.out.println("Type something to stop");
		Scanner scanner = new Scanner(System.in);
		scanner.next();
		log.info("Terminating the calculation...");
		threadHandler.terminate();
		try {
			log.info("Wait for the calculations to terminate...");
			threadHandler.join();
			log.info("Terminated!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("Test finished!");
	}
}
