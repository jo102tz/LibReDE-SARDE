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

import java.io.BufferedWriter;

import org.apache.log4j.Logger;

import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.StepSize;
import tools.descartes.librede.rrde.optimization.WindowSize;

/**
 * This algorithm is a subclass of {@link ExportAlgorithm} and alternates the
 * window size in dependence of the altering step size and vice versa in order
 * to keep a certain total time window.
 * 
 * @author JS
 *
 */
public class StepWindowExportAlgorithm extends ExportAlgorithm {

	/**
	 * The log used for logging.
	 */
	private static final Logger log = Logger.getLogger(ExportAlgorithm.class);

	/**
	 * The value that should be achieved at all times. Usually its considered to
	 * be seconds, but the unit depends on the value of the step size quantity.
	 */
	private static final int TOTAL_VALUE = 10000;

	@Override
	protected void adaptOtherValues(IOptimizableParameter param, double i) {
		try {
			double newVal = (TOTAL_VALUE / i);
			if (param instanceof WindowSize) {
				if (newVal < 1) {
					log.warn("The calculated step size was smaller than one");
					newVal = 1;
				}
				log.info("Adapting StepSize according to total value of "
						+ TOTAL_VALUE + " to " + newVal + ".");
				setTargetValue(getParam(StepSize.class), newVal);
			} else if (param instanceof StepSize) {
				newVal = (int) newVal;
				if (newVal < 1) {
					log.warn("The calculated window size was smaller than one");
					newVal = 1;
				}
				log.info("Adapting Window Size according to total value of "
						+ TOTAL_VALUE + " to " + newVal + ".");
				setTargetValue(getParam(WindowSize.class), newVal);
			}
		} catch (Exception e) {
			log.error("Adapting the window size/step size could not be done.",
					e);
		}
	}

	/**
	 * Returns the instance of the given class in the available List of
	 * {@link IOptimizableParameter}
	 * 
	 * @param clazz
	 *            The class of the instance
	 * @return The object of the available list
	 */
	private IOptimizableParameter getParam(Class<? extends IOptimizableParameter> clazz) {
		
		for (IOptimizableParameter par : getSettings()
				.getParametersToOptimize()) {
			if (clazz.isInstance(par))
				return par;
		}
		log.error("Parameter of class " + clazz.getName()
				+ " is not available in the given list.");
		return null;
	}

	@Override
	public void executeAlgorithm() {
		boolean window = false;
		boolean step = false;
		for (IOptimizableParameter para : getSettings()
				.getParametersToOptimize()) {
			if (para instanceof WindowSize) {
				window = true;
			}
			if (para instanceof StepSize) {
				step = true;
			}
		}
		if (!step || !window) {
			getLog().error(
					"Both WindowSize and StepSize must be activated for optimization, when using StepWindowExportAlgorithm.");
		}
		super.executeAlgorithm();
	}

	@Override
	protected Logger getLog() {
		return log;
	}

	@Override
	protected BufferedWriter initFile(String suffix) {
		// deletes ".csv" at the end
		suffix = suffix.substring(0, suffix.length() - 4);
		suffix += "_relativeChanges_" + TOTAL_VALUE + ".csv";
		return super.initFile(suffix);
	}
}
