/**
 * ==============================================
 *  LibReDE : Library for Resource Demand Estimation
 * ==============================================
 *
 * (c) Copyright 2013-2018, by Simon Spinner, Johannes Grohmann
 * and Contributors.
 *
 * Project Info:   http://www.descartes-research.net/
 *
 * All rights reserved. This software is made available under the terms of the
 * Eclipse Public License (EPL) v1.0 as published by the Eclipse Foundation
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * This software is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License (EPL)
 * for more details.
 *
 * You should have received a copy of the Eclipse Public License (EPL)
 * along with this software; if not visit http://www.eclipse.org or write to
 * Eclipse Foundation, Inc., 308 SW First Avenue, Suite 110, Portland, 97204 USA
 * Email: license (at) eclipse.org
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 */
package tools.descartes.librede.rrde.lifecycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.experimental.theories.Theories;

import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.lifecycle.logs.EstimationEntry;
import tools.descartes.librede.rrde.lifecycle.logs.LogBook;
import tools.descartes.librede.rrde.lifecycle.logs.LogEntry;
import tools.descartes.librede.rrde.lifecycle.logs.OperationType;
import tools.descartes.librede.rrde.lifecycle.logs.RecommendationEntry;
import tools.descartes.librede.rrde.lifecycle.logs.SkippedEntry;
import tools.descartes.librede.rrde.lifecycle.semaphors.OptimizationResult;
import tools.descartes.librede.rrde.lifecycle.semaphors.RecommendationResult;
import tools.descartes.librede.rrde.lifecycle.semaphors.TrainingResult;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.util.Util;
import tools.descartes.librede.rrde.util.extract.IFeatureExtractor;
import tools.descartes.librede.rrde.util.wrapper.CachedWrapper;
import tools.descartes.librede.rrde.util.wrapper.IWrapper;
import tools.descartes.librede.rrde.util.wrapper.Wrapper;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;

/**
 * Handler for executing, logging and storing all execution runs.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class ExecutionHandler {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(ExecutionHandler.class);

	private LogBook logbook;

	private Map<String, IWrapper> estimationMap;

	private IWrapper optimizationWrapper;

	private IWrapper trainingWrapper;

	private OptimizationResult optResult;

	private TrainingResult trainResult;

	private RecommendationResult recoResult;

	private boolean optRunning = false;

	private boolean estRunning = false;

	private boolean recoRunning = false;

	private boolean trainRunning = false;

	private String outputfolder;

	private ExecutorService executor;

	/**
	 * Constructor.
	 * 
	 * @param outputfolder
	 *            The folder to store all results to.
	 */
	public ExecutionHandler(String outputfolder) {
		logbook = new LogBook();
		optimizationWrapper = new CachedWrapper();
		trainingWrapper = new Wrapper();
		executor = Executors.newCachedThreadPool();
		this.outputfolder = outputfolder;
	}

	/**
	 * Initializes all semaphors and caches.
	 * 
	 * @param allConf
	 *            LibredeConfiguration containing all approaches to be cached
	 *            for later use.
	 * @param warumup
	 *            If the cached should be warmed-up. (Takes time, but probably
	 *            speeds up later uses.)
	 * 
	 * @return True, if initializing successful, false otherwise.
	 */
	public boolean init(LibredeConfiguration allConf, boolean warmup) {
		estimationMap = new HashMap<>();
		for (EstimationApproachConfiguration est : allConf.getEstimation().getApproaches()) {
			estimationMap.put(est.getType(), new CachedWrapper());
		}
		if (warmup) {
			// warm cache
			for (IWrapper wrap : estimationMap.values()) {
				wrap.executeLibrede(allConf);
			}
		}
		return true;
	}

	/**
	 * Schedules one estimation run.
	 * 
	 * @param The
	 *            Librede configuration to execute.
	 */
	public void executeEstimation(LibredeConfiguration defaultConfig) {
		if (!estRunning) {
			// This synchronized is probably unnecessary, but technically, there
			// might still occur double entry here, so thats why this is here.
			synchronized (this) {
				executor.execute(new EstimationRunner(defaultConfig));
			}
		} else {
			logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.ESTIMATION));
			log.warn("There is currently one estimation run still running. Therefore we skip the "
					+ logbook.getLength(OperationType.ESTIMATION) + "th operation.");
		}
	}

	/**
	 * Runs an optimization run for the given variables.
	 * 
	 * @param optimizationConfig
	 *            The optimization configuration to execute.
	 * @param defaultConfig
	 *            The librede configuration to use as skeleton for outputs.
	 */
	public void executeOptimization(OptimizationConfiguration optimizationConfig, LibredeConfiguration defaultConfig) {
		if (!optRunning) {
			// This synchronized is probably unnecessary, but technically, there
			// might still occur double entry here, so thats why this is here.
			synchronized (this) {
				executor.execute(new OptimizationRunner(defaultConfig, optimizationConfig));
			}
		} else {
			logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.OPTIMIZATION));
			log.warn("There is currently one optimization run still running. Therefore we skip the "
					+ logbook.getLength(OperationType.OPTIMIZATION) + "th operation.");
		}
	}

	/**
	 * Schedules one recommendation run.
	 * 
	 * @param conf
	 *            The librede configuration to recommend for.
	 */
	public void executeRecommendation(LibredeConfiguration conf) {
		if (!recoRunning) {
			// This synchronized is probably unnecessary, but technically, there
			// might still occur double entry here, so thats why this is here.
			synchronized (this) {
				executor.execute(new RecommendationRunner(conf));
			}
		} else {
			logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.RECOMMENDATION));
			log.warn("There is currently one recommendation run still running. Therefore we skip the "
					+ logbook.getLength(OperationType.RECOMMENDATION) + "th operation.");
		}
	}

	/**
	 * Schedules one training run.
	 * 
	 * @param recommendationConfig
	 *            The training configuration to execute.
	 */
	public void executeTraining(RecommendationTrainingConfiguration recommendationConfig) {
		if (!trainRunning) {
			// This synchronized is probably unnecessary, but technically, there
			// might still occur double entry here, so thats why this is here.
			synchronized (this) {
				executor.execute(new TrainingRunner(recommendationConfig));
			}
		} else {
			logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.TRAINING));
			log.warn("There is currently one training run still running. Therefore we skip the "
					+ logbook.getLength(OperationType.TRAINING) + "th operation.");
		}
	}

	/**
	 * Flushes all logs, and closes all remaining threads.
	 */
	public void finish() {
		log.info("Shutting down. Waiting for all tasks to finish...");
		executor.shutdown();
		boolean orderly = false;
		try {
			orderly = executor.awaitTermination(500, TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
			log.error("The waiting for termination was interrupted.");
		}
		if (orderly) {
			log.info("All task finished. Shut down.");
		} else {
			log.warn("Not all tasks could finish succesfully, before shutdown.");
		}
		try {
			String output = outputfolder + File.separator + "logbook.csv";
			logbook.exportToCsv(output);
			log.info("Exported logs to " + output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("Error with logging the estimation log.");
		}
	}

	/**
	 * Runnable for the estimation.
	 * 
	 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
	 *
	 */
	private class EstimationRunner implements Runnable {

		/**
		 * The logger used for logging
		 */
		private final Logger log = Logger.getLogger(EstimationRunner.class);

		private LibredeConfiguration libredeConfiguration;

		/**
		 * Constructor.
		 * 
		 * @param The
		 *            config to execute.
		 */
		public EstimationRunner(LibredeConfiguration config) {
			this.libredeConfiguration = EcoreUtil.copy(config);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			estRunning = true;
			log.info("Executing estimation run.");
			LibredeResults res = null;
			long tic = System.currentTimeMillis();
			try {
				if (recoResult != null) {
					// use recommended configuration, but reuse new end-time
					// configuration
					Quantity<Time> startTime = libredeConfiguration.getEstimation().getStartTimestamp();
					Quantity<Time> endTime = libredeConfiguration.getEstimation().getEndTimestamp();
					libredeConfiguration.setEstimation(EcoreUtil.copy(recoResult.getRecommendedSpecification()));
					libredeConfiguration.getEstimation().setStartTimestamp(startTime);
					libredeConfiguration.getEstimation().setEndTimestamp(endTime);
				} else {
					log.info("Executed default configuration, as no approach is selected yet.");
				}
				if (libredeConfiguration.getEstimation().getApproaches().size() != 1) {
					throw new IllegalArgumentException("Exactly one defined approach expected.");
				}
				IWrapper wrapper = estimationMap
						.get(libredeConfiguration.getEstimation().getApproaches().get(0).getType());
				if (wrapper == null) {
					throw new IllegalStateException(
							"The estimation aprpoach " + libredeConfiguration.getEstimation().getApproaches().get(0)
									+ " has no valid wrapper type assigned.");
				}
				res = wrapper.executeLibrede(libredeConfiguration);
			} catch (Exception e) {
				log.warn("Executing the estimation threw an error.", e);
				e.printStackTrace();
			} finally {
				long toc = System.currentTimeMillis();
				EstimationEntry entry = new EstimationEntry(tic, toc, "Error when running estimation.",
						"Error when running estimation.");
				if (res != null) {
					try {
						entry.setError(new Double(Util.getValidationError(res, libredeConfiguration.getValidation()))
								.toString());
						entry.setEstimate(res.getAllEstimates().values().toString());
					} catch (Exception e) {
						// do nothing, continue
						log.warn("Error when estimating the estimation error.", e);
						e.printStackTrace();
					}
				}
				logbook.insert(entry);
			}
			log.info("Executed " + logbook.getLength(OperationType.ESTIMATION) + "th estimation run. End-timestamp: "
					+ libredeConfiguration.getEstimation().getEndTimestamp().toString() + ".");
			estRunning = false;
		}

	}

	/**
	 * Runnable for the optimization.
	 * 
	 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
	 *
	 */
	private class OptimizationRunner implements Runnable {

		/**
		 * The logger used for logging
		 */
		private final Logger log = Logger.getLogger(OptimizationRunner.class);

		private LibredeConfiguration defaultConfig;

		private OptimizationConfiguration optimizationConfig;

		/**
		 * Constructor.
		 * 
		 * @param defaultConfig
		 *            The librede configuration to use as skeleton for outputs.
		 * @param optimizationConfig
		 *            The optimization configuration to execute.
		 */
		public OptimizationRunner(LibredeConfiguration defaultConfig, OptimizationConfiguration optimizationConfig) {
			super();
			this.defaultConfig = EcoreUtil.copy(defaultConfig);
			this.optimizationConfig = EcoreUtil.copy(optimizationConfig);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			optRunning = true;
			log.info("Executing optimization run.");
			long tic = System.currentTimeMillis();
			// run optimization
			Collection<EstimationSpecification> estimations = new tools.descartes.librede.rrde.optimization.OptimizationPlugin()
					.runConfigurationOptimization(EcoreUtil.copy(defaultConfig), optimizationConfig,
							optimizationWrapper, outputfolder + File.separator + "optimizations");
			long toc = System.currentTimeMillis();
			optResult = new OptimizationResult(toc);
			optResult.setOptimizedEstimators(estimations);
			LogEntry entry = new LogEntry(tic, toc, OperationType.OPTIMIZATION);
			logbook.insert(entry);
			log.info("Executed " + logbook.getLength(OperationType.OPTIMIZATION) + "th optimization run. Result-time: "
					+ optResult.getTimestamp());
			optRunning = false;
		}

	}

	/**
	 * Runnable for the recommendation.
	 * 
	 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
	 *
	 */
	private class RecommendationRunner implements Runnable {

		/**
		 * The logger used for logging
		 */
		private final Logger log = Logger.getLogger(RecommendationRunner.class);

		private LibredeConfiguration conf;

		/**
		 * @param conf
		 *            The librede configuration to recommend for.
		 */
		public RecommendationRunner(LibredeConfiguration conf) {
			super();
			this.conf = EcoreUtil.copy(conf);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			recoRunning = true;
			log.info("Executing recommendation run.");
			long tic = System.currentTimeMillis();
			long toc = 0;
			String chosenapproach = "None.";
			try {
				if (trainResult != null) {
					FeatureVector features = trainResult.getUsedExtractor().extractFeatures(conf);
					EstimationSpecification est = trainResult.getTrainedRecommender().recommendEstimation(features);
					if (est.getApproaches().size() != 1) {
						throw new IllegalStateException("Exactly one recommended approach expected.");
					}
					toc = System.currentTimeMillis();
					recoResult = new RecommendationResult(toc);
					recoResult.setRecommendedSpecification(EcoreUtil.copy(est));
					chosenapproach = est.getApproaches().get(0).toString();
				} else {
					log.warn("No Recommendation possible, before training is finished.");
					toc = System.currentTimeMillis();
				}
			} catch (Exception e) {
				log.error("Recommendation failed. Returning standard result.", e);
				e.printStackTrace();
				toc = System.currentTimeMillis();
			} finally {
				RecommendationEntry entry = new RecommendationEntry(tic, toc, chosenapproach);
				logbook.insert(entry);
				log.info("Executed " + logbook.getLength(OperationType.RECOMMENDATION)
						+ "th recommendation run. Result-time: " + toc);
				recoRunning = false;
			}
		}

	}

	/**
	 * Runnable for the recommendation training.
	 * 
	 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
	 *
	 */
	private class TrainingRunner implements Runnable {

		/**
		 * The logger used for logging
		 */
		private final Logger log = Logger.getLogger(TrainingRunner.class);

		private RecommendationTrainingConfiguration recommendationConfig;

		/**
		 * @param recommendationConfig
		 *            The training configuration to execute.
		 */
		public TrainingRunner(RecommendationTrainingConfiguration recommendationConfig) {
			super();
			this.recommendationConfig = EcoreUtil.copy(recommendationConfig);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			trainRunning = true;
			log.info("Executing training run.");
			if (optResult != null) {
				// delete the read estimators and replace them with the
				// optimized
				// ones
				recommendationConfig.getEstimators().clear();
				recommendationConfig.getEstimators().addAll(optResult.getOptimizedEstimators());
			}
			// train algorithm
			long tic = System.currentTimeMillis();
			IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
					.loadFeatureExtractor(recommendationConfig.getFeatureAlgorithm());
			IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
					.loadAndTrainAlgorithm(recommendationConfig, trainingWrapper);
			long toc = System.currentTimeMillis();
			logbook.insert(new LogEntry(tic, toc, OperationType.TRAINING));
			trainResult = new TrainingResult(toc);
			trainResult.setTrainedRecommender(algorithm);
			trainResult.setUsedExtractor(extractor);

			log.info("Executed " + logbook.getLength(OperationType.TRAINING) + "th training run. Result-time: "
					+ trainResult.getTimestamp());
			trainRunning = false;
		}

	}

}
