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

import tools.descartes.librede.rrde.configuration.IConfigurationOptimizer;

/**
 * Instances of this class contain important parameter settings for different
 * implementations of {@link IConfigurationOptimizer}.
 * 
 * @author JS
 *
 */
public class ConfigurationOptimizationSettings {

	/**
	 * The maximum time to be spent in milliseconds. Implementations may ignore
	 * this field, if not supported.
	 * 
	 * If supported however, algorithms will try to finish execution within the
	 * given time, but there is still NO GUARANTEED RUNTIME LIMIT!
	 * 
	 * If less than or equal zero, the algorithm runs as long as necessary.
	 * Note, that the timeout does not interrupt the algorithm at any time.
	 */
	private long timeout;

	/**
	 * @param timeout
	 */
	ConfigurationOptimizationSettings(long timeout) {
		super();
		this.timeout = timeout;
	}

	/**
	 * @return the timeout
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *            the timeout to set
	 */
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}



}
