package tools.descartes.librede.rrde.test;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import tools.descartes.librede.Librede;
import tools.descartes.librede.bayesplusplus.BayesLibrary;
import tools.descartes.librede.ipopt.java.IpoptLibrary;
import tools.descartes.librede.nnls.NNLSLibrary;
import tools.descartes.librede.rrde.ThreadHandler;

public class TestOnline{


	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestCombination.class);
	
	
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
		ThreadHandler threadHandler = new ThreadHandler(null);
		//start it
		threadHandler.start();
		System.out.println("Type something to stop");
		Scanner scanner = new Scanner(System.in);
		scanner.next();
		System.out.println("Terminating the calculation...");
		threadHandler.terminate();
		try {
			System.out.println("Wait for the calculations to terminate...");
			threadHandler.join();
			System.out.println("Terminated!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("Test finished!");
	}
}
