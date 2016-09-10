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

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.configuration.DataSourceConfiguration;
import tools.descartes.librede.configuration.FileTraceConfiguration;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.optimization.Discovery;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.optimization.Wrapper;
import tools.descartes.librede.rrde.optimization.impl.InputDataImpl;

/**
 * This class is for validating via a Test set.
 * 
 * @author JS
 *
 */
public class TestSetValidator {

	// TODO comment

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestSetValidator.class);

	private Set<LibredeConfiguration> testset;

	private Map<LibredeConfiguration, TestResult> before;

	private Map<LibredeConfiguration, TestResult> after;

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

	public Map<LibredeConfiguration, TestResult> calculateInitialErrors(
			String testfolder, LibredeConfiguration conf) {
		before = new HashMap<LibredeConfiguration, TestResult>();
		InputData input = new InputDataImpl();
		input.setRootFolder(testfolder);
		input.setWorkloadDescription(conf.getWorkloadDescription());
		input.setInput(conf.getInput());
//		for (DataSourceConfiguration ds : input.getInput().getDataSources()) {
//			FileTraceConfiguration ft = (FileTraceConfiguration) ds;
//			(ft).setFile(new File(ft.getFile()).getName());
//		}
		EList<InputData> list = new BasicEList<InputData>();
		list.add(input);
		testset = Discovery.createConfigurations(list, conf.getEstimation(),
				conf.getValidation());
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

	public Map<LibredeConfiguration, TestResult> compareOptimized(
			OptimizedLibredeExecutor exec) {
		after = new HashMap<LibredeConfiguration, TestResult>();
		for (LibredeConfiguration libredeConfiguration : testset) {
			long starttime = System.currentTimeMillis();
			LibredeResults res = exec.executeLibrede(libredeConfiguration);
			long finish = System.currentTimeMillis() - starttime;
			after.put(libredeConfiguration, new TestResult(res, finish));
		}
		return after;
	}

	public void printResults(Logger log, long optimization, long recommendation) {
		if (log == null) {
			log = TestSetValidator.log;
		}
		DescriptiveStatistics statbeforetime = new DescriptiveStatistics();
		DescriptiveStatistics stataftertime = new DescriptiveStatistics();
		DescriptiveStatistics statbeforeerror = new DescriptiveStatistics();
		DescriptiveStatistics stataftererror = new DescriptiveStatistics();
		log.info("Results:");
		log.info("----------------------------------------------------");
		log.info("Individual test results:");
		for (LibredeConfiguration libredeConfiguration : testset) {
			log.info("----------------------------------------------------");
			log.info("LibredeConfiguration: " + libredeConfiguration.toString());
			log.info("Execution time before optimization: "
					+ before.get(libredeConfiguration).getRuntime());
			statbeforetime.addValue(before.get(libredeConfiguration)
					.getRuntime());
			log.info("Execution time after optimization: "
					+ after.get(libredeConfiguration).getRuntime());
			stataftertime
					.addValue(after.get(libredeConfiguration).getRuntime());
			double beforeerror = Util.getMeanValidationError(before.get(
					libredeConfiguration).getResults());
			log.info("Validation error before optimization: " + beforeerror);
			statbeforeerror.addValue(beforeerror);
			double aftererror = Util.getMeanValidationError(after.get(
					libredeConfiguration).getResults());
			log.info("Validation error after optimization: " + aftererror);
			stataftererror.addValue(aftererror);
			log.info("Improvement: " + (beforeerror - aftererror) + " or "
					+ ((beforeerror - aftererror) * 100) / beforeerror + " %.");
		}
		log.info("----------------------------------------------------");
		log.info("Summarized");
		log.info("----------------------------------------------------");
		log.info("Numer of test configurations: " + testset.size());
		log.info("Average Execution time before optimization: "
				+ statbeforetime.getMean());
		log.info("Average Execution time after optimization: "
				+ stataftertime.getMean());
		log.info("This is an improvement of avg.: "
				+ (statbeforetime.getMean() - stataftertime.getMean()));
		log.info("\n");
		log.info("Average validation error before optimization: "
				+ statbeforeerror.getMean());
		log.info("Average validation error after optimization: "
				+ stataftererror.getMean());
		log.info("Improvement: "
				+ (statbeforeerror.getMean() - stataftererror.getMean())
				+ " or "
				+ ((statbeforeerror.getMean() - stataftererror.getMean()) * 100)
				/ statbeforeerror.getMean() + " %.");
		if (optimization > 0 && recommendation > 0) {
			log.info("This took around " + optimization
					+ "ms for optimizations and " + recommendation
					+ "ms for training resulting in a total training time of "
					+ optimization + recommendation + "ms.");
		}
	}
}
