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

import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.configuration.settings.ConfigurationOptimizationSettings;

/**
 * Basic interface for algorithms optimizing LibReDE configuration files.
 * 
 * @author JS
 *
 */
public interface IConfigurationOptimizer {

	/**
	 * Tries to change the given configuration in order to optimize the quality
	 * and the runtime of the activated algorithms of the
	 * {@link LibredeConfiguration}. Different parameters can be changed in the
	 * {@link ConfigurationOptimizationSettings}.
	 * 
	 * @param configuration
	 *            The {@link LibredeConfiguration} to be optimized.
	 * @param settings
	 *            A {@link ConfigurationOptimizationSettings} instance
	 *            containing defining parameters.
	 * @return True, if the executed finished successfully, false if the
	 *         execution was interrupted or otherwise not finish as planned.
	 */
	public boolean optimizeConfiguration(LibredeConfiguration configuration,
			ConfigurationOptimizationSettings settings);

	/**
	 * Returns the name of the algorithm.
	 * 
	 * @return The short name.
	 */
	public String getSimpleName();

}
