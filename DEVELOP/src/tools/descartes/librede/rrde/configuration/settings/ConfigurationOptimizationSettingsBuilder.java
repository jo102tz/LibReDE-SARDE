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
package tools.descartes.librede.rrde.configuration.settings;

import java.util.List;

/**
 * Builder class as outlined in the Second Edition of Joshua Bloch's Effective
 * Java that is used to build a {@link ConfigurationOptimizationSettings}
 * instance.
 */
public class ConfigurationOptimizationSettingsBuilder {

	private long timeout = 0;

	private List<String> approaches = null;

	private HillClimbingSettings hillClimbingSettings = new HillClimbingSettings();

	public ConfigurationOptimizationSettingsBuilder setTimeOut(
			final long timeout) {
		this.timeout = timeout;
		return this;
	}

	public ConfigurationOptimizationSettingsBuilder setApproaches(
			final List<String> approaches) {
		this.approaches = approaches;
		return this;
	}
	
	public ConfigurationOptimizationSettingsBuilder setHillClimbingSettings(
			final HillClimbingSettings hillClimbingSettings) {
		this.hillClimbingSettings = hillClimbingSettings;
		return this;
	}

	/**
	 * Create an instance using the specified values. Does not reset the values,
	 * so they can be reused again.
	 * 
	 * @return
	 */
	public ConfigurationOptimizationSettings build() {
		return new ConfigurationOptimizationSettings(timeout, approaches,
				hillClimbingSettings);
	}

	/**
	 * Deeply clones the given settings, i.e. creates a new instance with
	 * exactly the same values.
	 * 
	 * @param c
	 *            The settings to copy
	 * @return A new instance of {@link ConfigurationOptimizationSettings}
	 */
	public static ConfigurationOptimizationSettings copy(
			ConfigurationOptimizationSettings c) {
		return new ConfigurationOptimizationSettings(c.getTimeout(),
				c.getApproaches(), c.getHillClimbingSettings());
	}
}
