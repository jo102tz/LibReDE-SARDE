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
package tools.descartes.librede.rrde.configuration.implementations;

import org.apache.log4j.Logger;

import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.UnitsFactory;

/**
 * @author JS
 *
 */
public class SeparateWindowSizeOptimizer extends HillClimbingAlgorithm {

	private static final Logger log = Logger
			.getLogger(SeparateStepSizeOptimizer.class);

	private Class<? extends IEstimationApproach> approach;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		getLog().info("Now optimizing window size.");
		hillclimbing();
		getLog().info(
				"Optimization of window size is done. New step size for "
						+ approach.getCanonicalName() + " : "
						+ getConfiguration().getEstimation().getStepSize());
	}

	/**
	 * @param approach
	 */
	public SeparateWindowSizeOptimizer(
			Class<? extends IEstimationApproach> approach) {
		super();
		this.approach = approach;
	}

	/**
	 * @return the approach
	 */
	public Class<? extends IEstimationApproach> getApproach() {
		return approach;
	}

	/**
	 * @param approach
	 *            the approach to set
	 */
	public void setApproach(Class<? extends IEstimationApproach> approach) {
		this.approach = approach;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.configuration.AbstractConfigurationOptimizer
	 * #getLog()
	 */
	@Override
	protected Logger getLog() {
		return log;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.configuration.implementations.
	 * SimpleStepSizeOptimizer#errorFunction()
	 */
	@Override
	protected double errorFunction() {
		return getError(getApproach());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.configuration.implementations.
	 * HillClimbingAlgorithm#setTargetValue(double)
	 */
	@Override
	protected void setTargetValue(double value) {
		getConfiguration().getEstimation().setWindow((int) value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.configuration.implementations.
	 * HillClimbingAlgorithm#getTargetValue()
	 */
	@Override
	protected double getTargetValue() {
		return getConfiguration().getEstimation().getWindow();
	}

}
