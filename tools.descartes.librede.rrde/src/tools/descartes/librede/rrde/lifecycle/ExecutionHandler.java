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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.lifecycle.logs.EstimationEntry;
import tools.descartes.librede.rrde.lifecycle.logs.EvaluationEntry;
import tools.descartes.librede.rrde.lifecycle.logs.LogBook;
import tools.descartes.librede.rrde.lifecycle.logs.LogEntry;
import tools.descartes.librede.rrde.lifecycle.logs.OperationType;
import tools.descartes.librede.rrde.lifecycle.logs.OptimizedEvaluationEntry;
import tools.descartes.librede.rrde.lifecycle.logs.RecommendationEntry;
import tools.descartes.librede.rrde.lifecycle.logs.SkippedEntry;
import tools.descartes.librede.rrde.lifecycle.semaphors.DefaultOptimizationResult;
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

	private Map<String, IWrapper> evaluationMap;

	private Map<String, IWrapper> optimizedEvaluationMap;

	private IWrapper optimizationWrapper;

	private IWrapper trainingWrapper;

	private IWrapper recommendationWrapper;

	private OptimizationResult optResult;

	private DefaultOptimizationResult optDefault;

	private TrainingResult trainResult;

	private RecommendationResult recoResult;

	private boolean optRunning = false;

	private boolean estRunning = false;

	private boolean recoRunning = false;

	private boolean trainRunning = false;

	private boolean evalRunning = false;

	private boolean optEvalRunning = false;

	private String outputfolder;

	private ExecutorService executor;

	/**
	 * Constructor.
	 * 
	 * @param outputfolder The folder to store all results to.
	 */
	public ExecutionHandler(String outputfolder) {
		logbook = new LogBook();
		optimizationWrapper = new CachedWrapper();
		recommendationWrapper = new CachedWrapper();
		trainingWrapper = new Wrapper();
		executor = Executors.newCachedThreadPool();
		this.outputfolder = outputfolder;
	}

	/**
	 * Initializes all semaphors and caches.
	 * 
	 * @param allConf LibredeConfiguration containing all approaches to be cached
	 *                for later use.
	 * @param warumup If the cached should be warmed-up. (Takes time, but probably
	 *                speeds up later uses.)
	 * 
	 * @return True, if initializing successful, false otherwise.
	 */
	public boolean init(LibredeConfiguration allConf, boolean warmup) {
		estimationMap = new HashMap<>();
		evaluationMap = new HashMap<>();
		optimizedEvaluationMap = new HashMap<>();
		for (EstimationApproachConfiguration est : allConf.getEstimation().getApproaches()) {
			estimationMap.put(est.getType(), new CachedWrapper());
			evaluationMap.put(est.getType(), new CachedWrapper());
			optimizedEvaluationMap.put(est.getType(), new CachedWrapper());
		}
		if (warmup) {
			// warm cache
			for (IWrapper wrap : estimationMap.values()) {
				wrap.executeLibrede(allConf);
			}
			for (IWrapper wrap : evaluationMap.values()) {
				wrap.executeLibrede(allConf);
			}
			for (IWrapper wrap : optimizedEvaluationMap.values()) {
				wrap.executeLibrede(allConf);
			}
		}

		return true;
	}

	/**
	 * Schedules one estimation run.
	 * 
	 * @param The Librede configuration to execute.
	 */
	public void executeEstimation(LibredeConfiguration defaultConfig) {
		synchronized (this) {
			if (!estRunning) {
				// This synchronized is probably unnecessary, but technically, there
				// might still occur double entry here, so thats why this is here.

				estRunning = true;
				executor.execute(new EstimationRunner(defaultConfig));
			} else {
				logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.ESTIMATION));
				log.warn("There is currently one estimation run still running. Therefore we skip the "
						+ logbook.getLength(OperationType.ESTIMATION) + "th operation.");
			}
		}
	}

	/**
	 * Schedules one evaluation estimation run.
	 * 
	 * @param The Librede configuration to execute. (Contains all approaches to
	 *            execute.
	 */
	public void executeEvaluation(LibredeConfiguration allConf) {
		synchronized (this) {
			if (!evalRunning) {
				evalRunning = true;
				log.info("Executing evaluation estimations run.");
				Collection<Future<?>> futures = new ArrayList<>();
				try {
					LibredeConfiguration toExec = EcoreUtil.copy(allConf);
					for (EstimationApproachConfiguration est : allConf.getEstimation().getApproaches()) {
						toExec.getEstimation().getApproaches().clear();
						toExec.getEstimation().getApproaches().add(EcoreUtil.copy(est));
						futures.add(executor.submit(new SingleEvaluationRunner(toExec)));
					}
					// wait for all tasks to complete in order to reschedule new
					// runs
					for (Future<?> f : futures) {
						f.get();
					}
				} catch (Exception e) {
					log.warn("Organizing the evaluation estimation threw an error.", e);
					e.printStackTrace();
				}
				evalRunning = false;

			} else {
				logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.EVALUATION));
				log.warn("There is currently one evaluation run still running. Therefore we skip the "
						+ logbook.getLength(OperationType.EVALUATION) + "th operation.");
			}
		}
	}

	/**
	 * Schedules one evaluation run of the optimized estimator.
	 * 
	 * @param The Librede configuration to execute. (Contains all approaches to
	 *            execute.
	 */
	public void executeOptimizedEvaluation(LibredeConfiguration allConf) {
		synchronized (this) {
			if (!optEvalRunning) {
				optEvalRunning = true;
				log.info("Executing optimized evaluation estimations run.");
				Collection<Future<?>> futures = new ArrayList<>();
				try {
					LibredeConfiguration toExec = EcoreUtil.copy(allConf);
					for (EstimationApproachConfiguration est : allConf.getEstimation().getApproaches()) {
						toExec.getEstimation().getApproaches().clear();
						toExec.getEstimation().getApproaches().add(EcoreUtil.copy(est));
						futures.add(executor.submit(new SingleOptimizedEvaluationRunner(toExec)));
					}
					// wait for all tasks to complete in order to reschedule new
					// runs
					for (Future<?> f : futures) {
						f.get();
					}
				} catch (Exception e) {
					log.warn("Organizing the optimized evaluation estimation runs threw an error.", e);
					e.printStackTrace();
				}
				optEvalRunning = false;

			} else {
				logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.OPTIMIZED_EVALUATION));
				log.warn("There is currently one optimized evaluation run still running. Therefore we skip the "
						+ logbook.getLength(OperationType.OPTIMIZED_EVALUATION) + "th operation.");
			}
		}
	}

	/**
	 * Runs an optimization run for the given variables.
	 * 
	 * @param optimizationConfig The optimization configuration to execute.
	 * @param defaultConfig      The librede configuration to use as skeleton for
	 *                           outputs.
	 */
	public void executeOptimization(OptimizationConfiguration optimizationConfig, LibredeConfiguration defaultConfig) {
		synchronized (this) {
			if (!optRunning) {
				// This synchronized is probably unnecessary, but technically, there
				// might still occur double entry here, so thats why this is here.
				optRunning = true;
				executor.execute(new OptimizationRunner(defaultConfig, optimizationConfig));
			} else {
				logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.OPTIMIZATION));
				log.warn("There is currently one optimization run still running. Therefore we skip the "
						+ logbook.getLength(OperationType.OPTIMIZATION) + "th operation.");
			}
		}
	}

	/**
	 * Schedules one recommendation run.
	 * 
	 * @param conf The librede configuration to recommend for.
	 */
	public void executeRecommendation(LibredeConfiguration conf) {
		synchronized (this) {
			if (!recoRunning) {
				// This synchronized is probably unnecessary, but technically, there
				// might still occur double entry here, so thats why this is here.

				recoRunning = true;

				executor.execute(new RecommendationRunner(conf));

			} else {
				logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.RECOMMENDATION));
				log.warn("There is currently one recommendation run still running. Therefore we skip the "
						+ logbook.getLength(OperationType.RECOMMENDATION) + "th operation.");
			}
		}
	}

	/**
	 * Schedules one training run.
	 * 
	 * @param recommendationConfig The training configuration to execute.
	 */
	public void executeTraining(RecommendationTrainingConfiguration recommendationConfig) {
		synchronized (this) {
			if (!trainRunning) {
				// This synchronized is probably unnecessary, but technically, there
				// might still occur double entry here, so thats why this is here.

				trainRunning = true;
				executor.execute(new TrainingRunner(recommendationConfig));

			} else {
				logbook.insert(new SkippedEntry(System.currentTimeMillis(), OperationType.TRAINING));
				log.warn("There is currently one training run still running. Therefore we skip the "
						+ logbook.getLength(OperationType.TRAINING) + "th operation.");
			}
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
		 * @param The config to execute.
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
			log.info("Executing estimation run.");
			LibredeResults res = null;
			EstimationEntry entry = null;
			long tic = System.currentTimeMillis();
			try {
				if (recoResult != null) {
					// use recommended configuration, but reuse new end-time
					// configuration
					libredeConfiguration = Util.setEstimationSpec(libredeConfiguration,
							recoResult.getRecommendedSpecification());
				} else {
					log.info("Executed default configuration, as no approach is selected yet.");
					if (optDefault != null) {
						log.info(
								"However, the default configuration has been optimized, therefore we use optimized default approach.");
						libredeConfiguration = Util.setEstimationSpec(libredeConfiguration,
								optDefault.getOptimizedEstimator());
					} else {
						// using the standard default behavior
					}
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
				entry = new EstimationEntry(tic, toc, "Error when running estimation.",
						"Error when running estimation.");
				if (res != null) {
					try {
						entry.setError(new Double(Util.getValidationError(res, libredeConfiguration.getValidation()))
								.toString());
//						ApproachResult appres = res
//								.getApproachResults(res.getAllEstimates().keySet().iterator().next());
//						ResultTable tab = appres.getResultOfFold(0);
//						Vector pred = tab.getValidationPredictions(tab.getValidators().iterator().next());
//						Vector err = tab.getValidationErrors(tab.getValidators().iterator().next());
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
					+ libredeConfiguration.getEstimation().getEndTimestamp().toString() + ", Error: "
					+ entry.getError());
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
		 * @param defaultConfig      The librede configuration to use as skeleton for
		 *                           outputs.
		 * @param optimizationConfig The optimization configuration to execute.
		 */
		public OptimizationRunner(LibredeConfiguration defaultConfig, OptimizationConfiguration optimizationConfig) {
			super();
			// do not copy the default config, as we want to modify it later
			this.defaultConfig = defaultConfig;
			this.optimizationConfig = EcoreUtil.copy(optimizationConfig);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			log.info("Executing optimization run.");
			long tic = System.currentTimeMillis();
			// run optimization
			Collection<EstimationSpecification> estimations = new tools.descartes.librede.rrde.optimization.OptimizationPlugin()
					.runConfigurationOptimization(EcoreUtil.copy(defaultConfig), optimizationConfig,
							optimizationWrapper, outputfolder + File.separator + "optimizations");
			long toc = System.currentTimeMillis();
			OptimizationResult res = new OptimizationResult(toc);
			res.setOptimizedEstimators(estimations);
			propagateToDefaultConfig(this.defaultConfig, res, toc);
			optResult = res;
			LogEntry entry = new LogEntry(tic, toc, OperationType.OPTIMIZATION);
			logbook.insert(entry);
			log.info("Executed " + logbook.getLength(OperationType.OPTIMIZATION) + "th optimization run. Result-time: "
					+ optResult.getTimestamp());
			optRunning = false;
		}

		/**
		 * Propagates the optimization result to the default config.
		 * 
		 * @param defaultConf
		 * @param result
		 */
		private void propagateToDefaultConfig(LibredeConfiguration defaultConf, OptimizationResult result,
				long timestamp) {
			for (EstimationSpecification opt : result.getOptimizedEstimators()) {
				if (opt.getApproaches().get(0).getType()
						.equals(defaultConf.getEstimation().getApproaches().get(0).getType())) {
					// we have found an optimized version for the default
					// configuration
					DefaultOptimizationResult res = new DefaultOptimizationResult(timestamp);
					res.setOptimizedEstimator(EcoreUtil.copy(opt));
					optDefault = res;
				}
			}
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
		 * @param conf The librede configuration to recommend for.
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
			log.info("Executing recommendation run.");
			long tic = System.currentTimeMillis();
			long toc = 0;
			String chosenapproach = "None.";
			try {
				if (trainResult != null) {
					LibredeVariables vars = null;
					if (recommendationWrapper instanceof CachedWrapper) {
						vars = ((CachedWrapper) recommendationWrapper).loadRepo(conf);
					} else {
						vars = new LibredeVariables(conf);
						Librede.initRepo(vars);
//						recommendationWrapper.executeLibrede(conf);
						vars.getRepo().setCurrentTime(EcoreUtil.copy(conf.getEstimation().getEndTimestamp()));
					}

					FeatureVector features = trainResult.getUsedExtractor().extractFeatures(EcoreUtil.copy(conf), vars);

					EstimationSpecification est = trainResult.getTrainedRecommender().recommendEstimation(features);
					if (est == null || est.getApproaches() == null || est.getApproaches().size() != 1) {
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
		 * @param recommendationConfig The training configuration to execute.
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

	/**
	 * Runnable for the evaluation estimations.
	 * 
	 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
	 *
	 */
	private class SingleEvaluationRunner implements Runnable {

		/**
		 * The logger used for logging
		 */
		private final Logger log = Logger.getLogger(SingleEvaluationRunner.class);

		private LibredeConfiguration toExec;

		/**
		 * Constructor.
		 * 
		 * @param The config to execute.
		 */
		public SingleEvaluationRunner(LibredeConfiguration toExec) {
			this.toExec = EcoreUtil.copy(toExec);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			log.info("Executing evaluation run for approach " + toExec.getEstimation().getApproaches().get(0).getType()
					+ ".");
			LibredeResults res = null;
			EvaluationEntry entry = null;
			long tic = System.currentTimeMillis();
			try {
				if (toExec.getEstimation().getApproaches().size() != 1) {
					throw new IllegalArgumentException("Exactly one defined approach expected.");
				}
				IWrapper wrapper = evaluationMap.get(toExec.getEstimation().getApproaches().get(0).getType());
				if (wrapper == null) {
					throw new IllegalStateException(
							"The evaluation estimation aprpoach " + toExec.getEstimation().getApproaches().get(0)
									+ " has no valid evaluation wrapper type assigned.");
				}
				res = wrapper.executeLibrede(toExec);
			} catch (Exception e) {
				log.warn("Executing the evaluation estimation threw an error.", e);
				e.printStackTrace();
			} finally {
				long toc = System.currentTimeMillis();
				entry = new EvaluationEntry(tic, toc, toExec.getEstimation().getApproaches().get(0).getType(),
						"Error when running evaluation estimation.", "Error when running evaluation estimation.");
				if (res != null) {
					try {
						entry.setError(new Double(Util.getValidationError(res, toExec.getValidation())).toString());
						entry.setEstimate(res.getAllEstimates().values().toString());
					} catch (Exception e) {
						// do nothing, continue
						log.warn("Error when estimating the estimation error.", e);
						e.printStackTrace();
					}
				}
				logbook.insert(entry);
			}
			log.info("Executed " + logbook.getLength(OperationType.EVALUATION) + "th evaluation run for approach "
					+ entry.getApproach() + ". End-timestamp: " + toExec.getEstimation().getEndTimestamp().toString()
					+ ", Error: " + entry.getError());
		}
	}

	/**
	 * Runnable for the evaluation estimations.
	 * 
	 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
	 *
	 */
	private class SingleOptimizedEvaluationRunner implements Runnable {

		/**
		 * The logger used for logging
		 */
		private final Logger log = Logger.getLogger(SingleOptimizedEvaluationRunner.class);

		private LibredeConfiguration toExec;

		/**
		 * Constructor.
		 * 
		 * @param The config to execute.
		 */
		public SingleOptimizedEvaluationRunner(LibredeConfiguration toExec) {
			this.toExec = EcoreUtil.copy(toExec);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			log.info("Executing optimized single evaluation run for approach "
					+ toExec.getEstimation().getApproaches().get(0).getType() + ".");
			LibredeResults res = null;
			EvaluationEntry entry = null;
			long tic = System.currentTimeMillis();
			try {
				if (toExec.getEstimation().getApproaches().size() != 1) {
					throw new IllegalArgumentException("Exactly one defined approach expected.");
				}
				// get current optimized result
				if (optResult != null) {
					// if the optimized results contain an optimized specification, we replace the
					// current approach with the optimized one.
					for (EstimationSpecification estimation : optResult.getOptimizedEstimators()) {
						if (toExec.getEstimation().getApproaches().get(0).getType()
								.equals(estimation.getApproaches().get(0).getType())) {
							Util.setEstimationSpec(toExec, estimation);
							log.trace("Replaced standard approach of approach "
									+ toExec.getEstimation().getApproaches().get(0).getType() + " with optimized one.");
						}
					}
				}

				IWrapper wrapper = evaluationMap.get(toExec.getEstimation().getApproaches().get(0).getType());
				if (wrapper == null) {
					throw new IllegalStateException("The optimized evaluation estimation aprpoach "
							+ toExec.getEstimation().getApproaches().get(0)
							+ " has no valid evaluation wrapper type assigned.");
				}
				res = wrapper.executeLibrede(toExec);
			} catch (Exception e) {
				log.warn("Executing the evaluation estimation threw an error.", e);
				e.printStackTrace();
			} finally {
				long toc = System.currentTimeMillis();
				entry = new OptimizedEvaluationEntry(tic, toc, toExec.getEstimation().getApproaches().get(0).getType(),
						"Error when running optimized evaluation estimation.",
						"Error when running optimized evaluation estimation.");
				if (res != null) {
					try {
						entry.setError(new Double(Util.getValidationError(res, toExec.getValidation())).toString());
						entry.setEstimate(res.getAllEstimates().values().toString());
					} catch (Exception e) {
						// do nothing, continue
						log.warn("Error when estimating the estimation error.", e);
						e.printStackTrace();
					}
				}
				logbook.insert(entry);
			}
			log.info("Executed " + logbook.getLength(OperationType.OPTIMIZED_EVALUATION)
					+ "th optimized evaluation run for approach " + entry.getApproach() + ". End-timestamp: "
					+ toExec.getEstimation().getEndTimestamp().toString() + ", Error: " + entry.getError());
		}
	}

}
