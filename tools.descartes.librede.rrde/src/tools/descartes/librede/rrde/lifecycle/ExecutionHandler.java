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

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.ipopt.java.RecursiveOptimization;
import tools.descartes.librede.repository.IMonitoringRepository;
import tools.descartes.librede.rrde.lifecycle.logs.EstimationEntry;
import tools.descartes.librede.rrde.lifecycle.logs.LogBook;
import tools.descartes.librede.rrde.lifecycle.logs.LogEntry;
import tools.descartes.librede.rrde.lifecycle.logs.RecommendationEntry;
import tools.descartes.librede.rrde.lifecycle.semaphors.OptimizationResult;
import tools.descartes.librede.rrde.lifecycle.semaphors.RecommendationResult;
import tools.descartes.librede.rrde.lifecycle.semaphors.TrainingResult;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.util.Discovery;
import tools.descartes.librede.rrde.optimization.util.Util;
import tools.descartes.librede.rrde.optimization.util.wrapper.CachedWrapper;
import tools.descartes.librede.rrde.optimization.util.wrapper.IWrapper;
import tools.descartes.librede.rrde.optimization.util.wrapper.Wrapper;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;

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

	private IWrapper estimationWrapper;

	private IWrapper optimizationWrapper;

	private IWrapper trainingWrapper;

	private OptimizationResult optResult;

	private TrainingResult trainResult;

	private RecommendationResult recoResult;

	private boolean optRunning = false;

	private String outputfolder;

	/**
	 * Constructor.
	 */
	public ExecutionHandler(String outputfolder) {
		logbook = new LogBook();
		estimationWrapper = new CachedWrapper();
		optimizationWrapper = new CachedWrapper();
		trainingWrapper = new CachedWrapper();
		this.outputfolder = outputfolder;
	}

	/**
	 * Executes one estimation run with the given variables.
	 * 
	 * @param libredeConfiguration
	 *            The configuration to use.
	 */
	public void executeEstimation(LibredeConfiguration libredeConfiguration) {
		log.info("Executing estimation run.");
		LibredeResults res = null;
		long tic = System.currentTimeMillis();
		try {
			res = estimationWrapper.executeLibrede(libredeConfiguration);
		} catch (Exception e) {
			log.warn("Executing the estimation threw an error.");
			e.printStackTrace();
		} finally {
			long toc = System.currentTimeMillis();
			EstimationEntry entry = new EstimationEntry(tic, toc, "Error when running estimation.",
					"Error when running estimation.");
			if (res != null) {
				entry.setError(
						new Double(Util.getValidationError(res, libredeConfiguration.getValidation())).toString());
				entry.setEstimate(res.getAllEstimates().values().toString());
			}
			logbook.insert(entry);
		}
		log.info("Executed " + logbook.getLength(OperationType.ESTIMATION) + "th run. End-timestamp: "
				+ libredeConfiguration.getEstimation().getEndTimestamp().toString() + ".");

	}

	/**
	 * Runs an optimization run for the given variables.
	 * 
	 * 
	 * @param optimization
	 *            The OptimizationConfiguration, specifying the desired
	 *            optimizations
	 * @param librede
	 *            The LibReDE configuration to use as skeleton for the outputs
	 */
	public void executeOptimization(OptimizationConfiguration optimization, LibredeConfiguration librede) {
		if (!optRunning) {
			synchronized (this) {
				optRunning = true;
				log.info("Executing optimization run.");
				long tic = System.currentTimeMillis();
				// run optimization
				Collection<EstimationSpecification> estimations = new tools.descartes.librede.rrde.optimization.Plugin()
						.runConfigurationOptimization(librede, optimization, optimizationWrapper,
								outputfolder + File.separator + "optimizations");
				long toc = System.currentTimeMillis();
				optResult = new OptimizationResult(toc);
				optResult.setOptimizedEstimators(estimations);
				LogEntry entry = new LogEntry(tic, toc, OperationType.OPTIMIZATION);
				logbook.insert(entry);
				log.info("Executed " + logbook.getLength(OperationType.OPTIMIZATION) + "th run. Result-time: "
						+ optResult.getTimestamp());
				optRunning = false;
			}
		} else {
			log.warn("There is currently one optimization run still running. Therefore we skip this iteration.");
		}
	}

	public void executeRecommendation(LibredeConfiguration conf) {
		log.info("Executing recommendation run.");
		long tic = System.currentTimeMillis();
		long toc = 0;
		String chosenapproach = "None.";
		if (trainResult != null) {
			FeatureVector features = trainResult.getUsedExtractor().extractFeatures(conf);
			EstimationSpecification est = trainResult.getTrainedRecommender().recommendEstimation(features);
			toc = System.currentTimeMillis();
			if (est != null) {
				recoResult = new RecommendationResult(toc);
				recoResult.setRecommendedSpecification(est);
				chosenapproach = est.getApproaches().get(0).toString();
			} else {
				log.warn("Recommendation failed. Returning standard result.");
			}
		} else {
			log.warn("No Recommendation possible, before training is finished.");
			toc = System.currentTimeMillis();
		}
		RecommendationEntry entry = new RecommendationEntry(tic, toc, chosenapproach);
		logbook.insert(entry);
		log.info("Executed " + logbook.getLength(OperationType.RECOMENDATION) + "th run. Result-time: " + toc);
	}

	public void executeTraining(RecommendationTrainingConfiguration recommendation) {
		log.info("Executing training run.");
		if (optResult != null) {
			// delete the read estimators and replace them with the optimized
			// ones
			recommendation.getEstimators().clear();
			recommendation.getEstimators().addAll(optResult.getOptimizedEstimators());
		}
		// train algorithm
		long tic = System.currentTimeMillis();
		IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
				.loadFeatureExtractor(recommendation.getFeatureAlgorithm());
		IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
				.loadAndTrainAlgorithm(recommendation, trainingWrapper);
		long toc = System.currentTimeMillis();
		logbook.insert(new LogEntry(tic, toc, OperationType.TRAINING));
		trainResult = new TrainingResult(toc);
		trainResult.setTrainedRecommender(algorithm);
		trainResult.setUsedExtractor(extractor);

		log.info("Executed " + logbook.getLength(OperationType.TRAINING) + "th run. Result-time: "
				+ trainResult.getTimestamp());

	}

	/**
	 * Flushes all logs, and closes all remaining threads.
	 */
	public void finish() {
		try {
			logbook.exportToCsv(outputfolder + File.separator + "logbook.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("Error with logging the estimation log.");
		}
	}

}
