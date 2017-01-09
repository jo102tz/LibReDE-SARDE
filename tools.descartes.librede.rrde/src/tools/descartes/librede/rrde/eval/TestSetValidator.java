/**
 * ==============================================
 *  LibReDE : Library for Resource Demand Estimation
 * ==============================================
 *
 * (c) Copyright 2013-2014, by Simon Spinner and Contributors.
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
package tools.descartes.librede.rrde.eval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.optimization.Discovery;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.optimization.Wrapper;
import tools.descartes.librede.rrde.optimization.algorithm.impl.ExportAlgorithm.FileExporter;

/**
 * This class is for validating via a Test set.
 * 
 * @author JS
 *
 */
public class TestSetValidator {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestSetValidator.class);

	private Set<LibredeConfiguration> testset;

	private Map<LibredeConfiguration, TestResult> before;

	private Map<LibredeConfiguration, TestResult> after;

	private StatisticsSummary stat;

	/**
	 * @return the testset
	 */
	public Set<LibredeConfiguration> getTestset() {
		return testset;
	}

	/**
	 * @param testset
	 *            the testset to set
	 */
	public void setTestset(Set<LibredeConfiguration> testset) {
		this.testset = testset;
	}

	/**
	 * @return the before
	 */
	public Map<LibredeConfiguration, TestResult> getBefore() {
		return before;
	}

	/**
	 * @param before
	 *            the before to set
	 */
	public void setBefore(Map<LibredeConfiguration, TestResult> before) {
		this.before = before;
	}

	/**
	 * @return the after
	 */
	public Map<LibredeConfiguration, TestResult> getAfter() {
		return after;
	}

	/**
	 * @param after
	 *            the after to set
	 */
	public void setAfter(Map<LibredeConfiguration, TestResult> after) {
		this.after = after;
	}

	/**
	 * Creates a new {@link TestSetValidator} instance and sets the testset
	 * accordingly.
	 * 
	 * @param testset
	 *            A {@link Set} of {@link LibredeConfiguration} to use for
	 *            validation.
	 */
	public TestSetValidator(Set<LibredeConfiguration> testset) {
		this.testset = testset;
	}

	/**
	 * Creates a mapping of {@link LibredeConfiguration}s to their initial
	 * corresponding {@link TestResult}s for later comparison. Using
	 * standardform.
	 *
	 * @return The mapping of created {@link LibredeConfiguration}s to their
	 *         {@link TestResult}s
	 */
	public Map<LibredeConfiguration, TestResult> calculateInitialErrors() {
		before = new HashMap<LibredeConfiguration, TestResult>();
		if (testset.isEmpty()) {
			log.warn("Testset is empty. No tests can be done.");
		} else {
			log.info("Available test configurations: " + testset.size());
		}
		for (LibredeConfiguration libredeConfiguration : testset) {
			long starttime = System.currentTimeMillis();
			LibredeResults res = Wrapper.executeLibrede(libredeConfiguration);
			long finish = System.currentTimeMillis() - starttime;
			before.put(libredeConfiguration, new TestResult(res, finish));
		}
		return before;
	}

	/**
	 * Creates a mapping of {@link LibredeConfiguration}s to their initial
	 * corresponding {@link TestResult}s for later comparison. Selecting one
	 * approach and saving it. For runtime calculations the standard
	 * {@link LibredeConfiguration} form is taken (should contain all
	 * approaches).
	 * 
	 * @param estimations
	 *            The different estimators to choose from
	 * 
	 * @param minimum
	 *            If the best approach or the median should be chosen.
	 *
	 * @return The mapping of created {@link LibredeConfiguration}s to their
	 *         {@link TestResult}s
	 */
	public Map<LibredeConfiguration, TestResult> calculateInitialErrorsRecommendation(
			Collection<EstimationApproachConfiguration> estimations, boolean minimum) {
		before = new HashMap<LibredeConfiguration, TestResult>();
		if (testset.isEmpty()) {
			log.warn("Testset is empty. No tests can be done.");
		} else {
			log.info("Available test configurations: " + testset.size());
		}
		for (LibredeConfiguration libredeConfiguration : testset) {

			// first measure runtime
			long starttime = System.currentTimeMillis();
			Wrapper.executeLibrede(libredeConfiguration);
			long finish = System.currentTimeMillis() - starttime;

			LibredeResults finalres = null;
			// create sorted set
			SortedSet<LibredeResults> set = new TreeSet<>(new Comparator<LibredeResults>() {
				@Override
				public int compare(LibredeResults one, LibredeResults two) {
					double errone = Util.getMeanValidationError(one);
					double errtwo = Util.getMeanValidationError(two);
					if (errone < errtwo) {
						return -1;
					} else if (errone == errtwo) {
						return 0;
					}
					return 1;
				}
			});
			// testing all approaches and choosing the minimum
			ArrayList<EstimationApproachConfiguration> tmp = new ArrayList<>();
			tmp.addAll(libredeConfiguration.getEstimation().getApproaches());
			for (EstimationApproachConfiguration est : estimations) {
				libredeConfiguration.getEstimation().getApproaches().clear();
				libredeConfiguration.getEstimation().getApproaches().add(EcoreUtil.copy(est));
				// check timestamps
				Discovery.fixTimeStamps(libredeConfiguration);
				LibredeResults res = Wrapper.executeLibrede(libredeConfiguration);
				set.add(res);
			}
			libredeConfiguration.getEstimation().getApproaches().addAll(tmp);

			// choose final comparator
			if (minimum) {
				finalres = set.first();
			} else {
				finalres = set.toArray(new LibredeResults[0])[set.size() / 2];
			}

			before.put(libredeConfiguration, new TestResult(finalres, finish));
		}
		return before;
	}

	/**
	 * Creates a mapping between all {@link LibredeConfiguration}s of the
	 * initial compare set and their new {@link TestResult}s.
	 * 
	 * @param exec
	 *            An {@link OptimizedLibredeExecutor} instance used for
	 *            execution of the {@link LibredeConfiguration}s.
	 * 
	 * @return The resulting mapping of {@link LibredeConfiguration} to
	 *         {@link TestResult}
	 */
	public Map<LibredeConfiguration, TestResult> compareOptimized(OptimizedLibredeExecutor exec) {
		after = new HashMap<LibredeConfiguration, TestResult>();
		for (LibredeConfiguration libredeConfiguration : testset) {
			long starttime = System.currentTimeMillis();
			LibredeResults res = exec.executeLibrede(libredeConfiguration);
			long finish = System.currentTimeMillis() - starttime;
			after.put(libredeConfiguration, new TestResult(res, finish));
		}
		return after;
	}

	/**
	 * Compares the initial results with the improved ones an writes it into the
	 * given log instance.
	 * 
	 * @param file
	 *            The {@link FileExporter} to use. If <code>null</code>, it is
	 *            ignored.
	 * @param log
	 *            The logger to use. If <code>null</code>, the default log of
	 *            the {@link TestSetValidator} is used.
	 * @param optimization
	 *            The time spent for optimization in milliseconds for
	 *            summarizing.
	 * @param recommendation
	 *            The time spent for recommendation in milliseconds for
	 *            summarizing.
	 * @param printHitRate
	 *            If the hit-ratio should be printed. Only useful for
	 *            recommendation.
	 * @return A {@link StatisticsSummary} instance, containing the key
	 *         statistics.
	 */
	public StatisticsSummary printResults(FileExporter file, Logger log, long optimization, long recommendation,
			boolean printHitRate) {
		if (log == null) {
			log = TestSetValidator.log;
		}
		DescriptiveStatistics statbeforetime = new DescriptiveStatistics();
		DescriptiveStatistics stataftertime = new DescriptiveStatistics();
		DescriptiveStatistics statbeforeerror = new DescriptiveStatistics();
		DescriptiveStatistics stataftererror = new DescriptiveStatistics();
		int hitted = 0;
		int beforeignored = 0;
		int afterignored = 0;
		log.info("Results:");
		log.info("----------------------------------------------------");
		log.info("Individual test results:");
		for (LibredeConfiguration libredeConfiguration : testset) {
			log.info("----------------------------------------------------");
			log.info("LibredeConfiguration: " + libredeConfiguration.toString());
			log.info("Execution time before optimization: " + before.get(libredeConfiguration).getRuntime());
			statbeforetime.addValue(before.get(libredeConfiguration).getRuntime());
			log.info("Execution time after optimization: " + after.get(libredeConfiguration).getRuntime());
			stataftertime.addValue(after.get(libredeConfiguration).getRuntime());
			double beforeerror = Util.getMeanValidationError(before.get(libredeConfiguration).getResults());
			if (beforeerror == Double.MAX_VALUE || beforeerror < 0)
				beforeignored++;
			else
				statbeforeerror.addValue(beforeerror);
			log.info("Validation error before optimization: " + beforeerror);
			double aftererror = Util.getMeanValidationError(after.get(libredeConfiguration).getResults());
			if (aftererror == Double.MAX_VALUE || aftererror < 0)
				afterignored++;
			else
				stataftererror.addValue(aftererror);
			log.info("Validation error after optimization: " + aftererror);
			log.info("Improvement: " + (beforeerror - aftererror) + " or "
					+ ((beforeerror - aftererror) * 100) / beforeerror + " %.");

			if (printHitRate) {
				if (before.get(libredeConfiguration).getResults().getApproaches().size() > 1
						|| after.get(libredeConfiguration).getResults().getApproaches().size() > 1) {
					log.error("Can not print hitrate, if before or after has no specified minimum.");
				} else {
					if (before.get(libredeConfiguration).getResults().getApproaches().iterator().next()
							.equals(after.get(libredeConfiguration).getResults().getApproaches().iterator().next())) {
						hitted++;
					}
				}
			}
		}
		stat = new StatisticsSummary();
		stat.setAvgTimeBefore(statbeforetime.getMean());
		stat.setStdDevTimeBefore(statbeforetime.getStandardDeviation());
		stat.setAvgTimeAfter(stataftertime.getMean());
		stat.setStdDevTimeAfter(stataftertime.getStandardDeviation());

		stat.setAvgErrorBefore(statbeforeerror.getMean());
		stat.setStdDevErrorBefore(statbeforeerror.getStandardDeviation());
		stat.setAvgErrorAfter(stataftererror.getMean());
		stat.setStdDevErrorAfter(stataftererror.getStandardDeviation());


		stat.setHitrate(((double) hitted) / ((double) testset.size()));

		stat.setOptimizationtime(optimization);
		stat.setRecommendationtime(recommendation);

		stat.setBeforeignored(beforeignored);
		stat.setAfterignored(afterignored);

		printStatistics(stat, printHitRate);

		printToFile(stat, printHitRate, file);

		return stat;
	}

	/**
	 * Prints the summary statistics to the given file, if not null.
	 * 
	 * @param stat
	 *            The statistics to print.
	 * @param printHitRate
	 *            If the hit-rate should be printed
	 * @param file
	 *            The file to write into. If <code>null</code>, nothing is
	 *            written.
	 */
	private void printToFile(StatisticsSummary stat, boolean printHitRate, FileExporter file) {
		if (file != null) {
			file.writeDouble(stat.getAvgTimeBefore());
			file.writeDouble(stat.getStdDevTimeBefore());
			file.writeDouble(stat.getAvgTimeAfter());
			file.writeDouble(stat.getStdDevTimeAfter());

			file.writeDouble(stat.getAvgErrorBefore());
			file.writeDouble(stat.getStdDevErrorBefore());
			file.writeDouble(stat.getAvgErrorAfter());
			file.writeDouble(stat.getStdDevTimeAfter());

			file.writeDouble(stat.getRecommendationtime() + stat.getOptimizationtime());

			if (printHitRate) {
				file.writeDouble(stat.getHitrate());
			}
		}
	}

	/**
	 * Prints the summary statistics to the log.
	 * 
	 * @param stat
	 *            The statistics to print.
	 * @param printHitRate
	 *            If the hit-rate should be printed
	 */
	private void printStatistics(StatisticsSummary stat, boolean printHitRate) {
		log.info("----------------------------------------------------");
		log.info("Summarized");
		log.info("----------------------------------------------------");
		log.info("Numer of test configurations: " + testset.size());
		log.info("Average Execution time before optimization: " + stat.getAvgTimeBefore() + "ms (Standard Deviation: "
				+ stat.getStdDevTimeBefore() + ")");
		log.info("Average Execution time after optimization: " + stat.getAvgTimeAfter() + "ms (Standard Deviation: "
				+ stat.getStdDevTimeAfter() + ")");
		log.info("This is an improvement of avg.: " + (stat.getAvgTimeBefore() - stat.getAvgTimeAfter() + "ms"));

		log.info("Average validation error before optimization: " + stat.getAvgErrorBefore() + "(Standard Deviation: "
				+ stat.getStdDevErrorBefore() + ")");
		log.info("Average validation error after optimization: " + stat.getAvgErrorAfter() + "(Standard Deviation: "
				+ stat.getStdDevErrorAfter() + ")");
		log.info("Improvement: " + (stat.getAvgErrorBefore() - stat.getAvgErrorAfter()) + " or "
				+ ((stat.getAvgErrorBefore() - stat.getAvgErrorAfter()) * 100) / stat.getAvgErrorBefore() + " %.");
		log.info("Due to invalid results " + stat.getBeforeignored() + " of total " + testset.size()
				+ " approaches were ignored before testing started.");
		log.info("After computation " + stat.getAfterignored() + " of total " + testset.size()
				+ " approaches were ignored. That is an improvement of "
				+ (stat.getBeforeignored() - stat.getAfterignored()) + ".");
		if (printHitRate) {
			log.info("A hit rate of " + (stat.getHitrate() * testset.size()) + "/" + testset.size()
					+ " was achieved or " + stat.getHitrate());
		}
		if (stat.getOptimizationtime() > 0 && stat.getRecommendationtime() > 0) {
			log.info("This took around " + stat.getOptimizationtime() + "ms for optimizations and "
					+ stat.getRecommendationtime() + "ms for training resulting in a total training time of "
					+ (stat.getOptimizationtime() + stat.getRecommendationtime()) + "ms.");
		} else if (stat.getOptimizationtime() > 0) {
			log.info("This took around " + stat.getOptimizationtime()
					+ "ms for optimizations. Recommendation was not done.");
		} else if (stat.getRecommendationtime() > 0) {
			log.info("This took around " + stat.getRecommendationtime()
					+ "ms for recommendation training. Optimization was not done.");
		}
	}

	/**
	 * Creates a mapping between all {@link LibredeConfiguration}s of the
	 * initial compare set and their new {@link TestResult}s.
	 * 
	 * @param estimations
	 *            The {@link EstimationSpecification}s to consider at once. All
	 *            of them are executed.
	 * @param minimum
	 *            If true, the {@link EstimationSpecification} with the minimum
	 *            error in each run is chosen as representative. If false, the
	 *            median is chosen instead.
	 * @return The resulting mapping of {@link LibredeConfiguration} to
	 *         {@link TestResult}
	 */
	public Map<LibredeConfiguration, TestResult> compareOptimized(Collection<EstimationSpecification> estimations,
			boolean minimum) {
		after = new HashMap<LibredeConfiguration, TestResult>();
		if (estimations.isEmpty()) {
			log.error("No estimators to compare.");
			return after;
		}
		for (LibredeConfiguration libredeConfiguration : testset) {

			LibredeResults finalres = null;
			// create sorted set
			SortedSet<LibredeResults> set = new TreeSet<>(new Comparator<LibredeResults>() {
				@Override
				public int compare(LibredeResults one, LibredeResults two) {
					double errone = Util.getMeanValidationError(one);
					double errtwo = Util.getMeanValidationError(two);
					if (errone < errtwo) {
						return -1;
					} else if (errone == errtwo) {
						return 0;
					}
					return 1;
				}
			});
			long starttime = System.currentTimeMillis();
			// testing all approaches and choosing the minimum
			for (EstimationSpecification estimationSpecification : estimations) {
				libredeConfiguration.setEstimation(EcoreUtil.copy(estimationSpecification));
				// check timestamps
				Discovery.fixTimeStamps(libredeConfiguration);
				LibredeResults res = Wrapper.executeLibrede(libredeConfiguration);
				set.add(res);
			}

			// choose final comparator
			if (minimum) {
				finalres = set.first();
			} else {
				finalres = set.toArray(new LibredeResults[0])[set.size() / 2];
			}

			long finish = System.currentTimeMillis() - starttime;
			after.put(libredeConfiguration, new TestResult(finalres, finish));
		}
		return after;
	}
}
