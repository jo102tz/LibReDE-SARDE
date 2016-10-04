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
package tools.descartes.librede.rrde.optimization.algorithm.impl;

import org.apache.log4j.Logger;

import tools.descartes.librede.rrde.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.algorithm.AbstractConfigurationOptimizer;

/**
 * @author JS
 *
 */
public class BruteForceAlgorithm extends AbstractConfigurationOptimizer {

	/* (non-Javadoc)
	 * @see tools.descartes.librede.rrde.optimization.algorithm.IConfigurationOptimizer#isSpecifierSupported(tools.descartes.librede.rrde.optimization.ConfigurationOptimizationAlgorithmSpecifier)
	 */
	@Override
	public boolean isSpecifierSupported(
			ConfigurationOptimizationAlgorithmSpecifier specifier) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see tools.descartes.librede.rrde.optimization.algorithm.AbstractConfigurationOptimizer#getLog()
	 */
	@Override
	protected Logger getLog() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see tools.descartes.librede.rrde.optimization.algorithm.AbstractConfigurationOptimizer#executeAlgorithm()
	 */
	@Override
	public void executeAlgorithm() {
		// TODO Auto-generated method stub
		
	}

}
