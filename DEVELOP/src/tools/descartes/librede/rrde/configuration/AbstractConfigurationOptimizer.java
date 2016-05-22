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

import org.apache.log4j.Logger;

import tools.descartes.librede.configuration.LibredeConfiguration;
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
	 * Returns a copy of the underlying algorithm settings, so a change in them
	 * has no effect on the currently running execution.
	 * 
	 * @return the settings
	 */
	public ConfigurationOptimizationSettings getSettings() {
		return ConfigurationOptimizationSettingsBuilder.copy(settings);
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
	 * Constructor preparing and initializing execution
	 */
	public AbstractConfigurationOptimizer() {
		super();
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
		Thread t = new Thread(this);
		t.start();
		while (t.isAlive()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				getLog().warn("Execution of estimators encountered problems.",
						e);
				return false;
			}
		}
		getLog().info(
				"Successfully ran a reconfiguration of configuration file "
						+ getConfiguration().toString());
		return true;
	}

	/**
	 * Returns the log instance, to provide proper visibile logging.
	 * 
	 * @return the logger of the implementing class
	 */
	protected abstract Logger getLog();

}
