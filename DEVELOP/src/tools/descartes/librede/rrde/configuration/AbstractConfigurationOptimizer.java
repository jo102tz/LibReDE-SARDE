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
package tools.descartes.librede.rrde.configuration;

import java.util.ArrayList;
import java.util.List;

import optimization.ConfigurationSettings;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.Wrapper;
import tools.descartes.librede.rrde.configuration.settings.ConfigurationOptimizationSettings;
import tools.descartes.librede.rrde.configuration.settings.ConfigurationOptimizationSettingsBuilder;

/**
 * This class contains an abstract implementation of an
 * {@link IConfigurationOptimizer}. Basic functionality is implemented as a
 * framework in order to support different subclass implementations.
 * 
 * @author JS
 *
 */
public abstract class AbstractConfigurationOptimizer implements
		IConfigurationOptimizer, Runnable {

	/**
	 * The settings of the optimizer specifying its behavior.
	 */
	private ConfigurationOptimizationSettings settings;

	/**
	 * The configuration to be modified
	 */
	private LibredeConfiguration configuration;

	/**
	 * The stored result of the most recent execution or null if no execution
	 * has been done yet.
	 */
	private LibredeResults result;

	/**
	 * A counter storing the number of executed iterations for debugging
	 */
	private int iterationcounter;

	/**
	 * The time when starting the run
	 */
	private long time;

	/**
	 * @return the settings
	 */
	public ConfigurationOptimizationSettings getSettings() {
		return settings;
	}

	/**
	 * @param settings
	 *            the settings to set
	 */
	private void setSettings(ConfigurationOptimizationSettings settings) {
		this.settings = settings;
	}

	/**
	 * @return the configuration
	 */
	public LibredeConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * @param configuration
	 *            the configuration to set
	 */
	public void setConfiguration(LibredeConfiguration configuration) {
		this.configuration = configuration;
	}

	/**
	 * @return the result
	 */
	public LibredeResults getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(LibredeResults result) {
		this.result = result;
	}

	/**
	 * Constructor preparing and initializing execution
	 */
	public AbstractConfigurationOptimizer() {
		super();
		iterationcounter = 0;
	}

	@Override
	public String getSimpleName() {
		return this.getClass().getSimpleName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.configuration.IConfigurationOptimizer#
	 * optimizeConfiguration
	 * (tools.descartes.librede.configuration.LibredeConfiguration,
	 * tools.descartes
	 * .librede.rrde.configuration.ConfigurationOptimizationSettings)
	 */
	@Override
	public boolean optimizeConfiguration(LibredeConfiguration configuration,
			ConfigurationOptimizationSettings settings) {
		setSettings(settings);
		setConfiguration(configuration);
		getLog().info(
				"Starting reconfiguration of configuration file "
						+ getConfiguration().toString());
		time = System.currentTimeMillis();
		Thread t = new Thread(this);
		t.start();
		while (t.isAlive()) {
			if (getSettings().getTimeout() > 0
					&& time + getSettings().getTimeout() > System
							.currentTimeMillis()) {
				getLog().warn("Timeout expired. Trying to shut down optimizer.");
				shutdown(t);
				return false;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				getLog().warn("Execution of estimators encountered problems.",
						e);
				return false;
			}
		}
		getLog().info(
				"Successfully ran reconfiguration of configuration file "
						+ getConfiguration().toString());
		getLog().info("Number of iterations:" + iterationcounter);
		getLog().info("Time: " + (System.currentTimeMillis() - time) + " ms");
		return true;
	}

	/**
	 * Tries to shutdown the thread. Default implementation just waits for its
	 * termination. Subclasses can override this behavior.
	 * 
	 * @param t
	 *            The thread to shutdown
	 */
	protected void shutdown(Thread t) {
		while (t.isAlive()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				getLog().warn("Thread was interrupted.", e);
			}
		}
		getLog().warn(
				"Optimizer did time out, but terminated without intervention.");
	}

	/**
	 * Returns the log instance, to provide proper visibile logging.
	 * 
	 * @return the logger of the implementing class
	 */
	protected abstract Logger getLog();

	/**
	 * Runs one iteration with the current configuration. The Result table is
	 * stored and returned.
	 * 
	 * @return
	 */
	protected LibredeResults runIteration() {
		iterationcounter++;
		setResult(Wrapper.executeLibrede(getConfiguration()));
		return getResult();
	}

	// /**
	// * Modifies the configuration that only the given approach is executed.
	// * After the execution the configuration is restored.
	// *
	// * @param approach
	// */
	// private synchronized LibredeResults runSingleIteration(
	// Class<? extends IEstimationApproach> approach) {
	// ArrayList<EstimationApproachConfiguration> lastConf = new
	// ArrayList<EstimationApproachConfiguration>();
	// for (EstimationApproachConfiguration a : getConfiguration()
	// .getEstimation().getApproaches()) {
	// if (a.getClass() != approach) {
	// lastConf.add(a);
	// getConfiguration().getEstimation().getApproaches().remove(a);
	// } else {
	// System.out.println("not deleting" + a.getClass());
	// }
	// }
	// LibredeResults res = runIteration();
	// getConfiguration().getEstimation().getApproaches().addAll(lastConf);
	// return res;
	// }

	/**
	 * Runs one iteration with the current configuration and returns the
	 * validation error of the given approach. Note, that all approaches in the
	 * configurations file are still executed.
	 * 
	 * @return The validation error of the given approach
	 */
	protected double getError(Class<? extends IEstimationApproach> approach) {
		runIteration();
		return getResult().getApproachValidationErrors(approach);
	}

	/**
	 * Runs one iteration with the current configuration and returns the average
	 * error in terms of validation this run.
	 * 
	 * @return The average error of all estimates
	 */
	protected double getAverageError() {
		runIteration();
		double cum = 0;
		for (Class<? extends IEstimationApproach> approach : getResult()
				.getApproaches()) {
			cum += getResult().getApproachValidationErrors(approach);
		}
		return cum / (double) getResult().getApproaches().size();
	}

	/**
	 * Runs one iteration with the current configuration and returns the minimum
	 * error in terms of validation run.
	 * 
	 * @return The smallest error of all estimates
	 */
	protected double getMinimumError() {
		runIteration();
		double min = Double.MAX_VALUE;
		for (Class<? extends IEstimationApproach> approach : getResult()
				.getApproaches()) {
			min = Math.min(min,
					getResult().getApproachValidationErrors(approach));

			System.out.println(approach.getSimpleName() + " validation error: "
					+ getResult().getApproachValidationErrors(approach));
		}
		System.out.println("Min: " + min);
		return min;
	}
}
