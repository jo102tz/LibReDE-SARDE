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
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;

import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.rrde.configuration.AbstractConfigurationOptimizer;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.UnitsFactory;

/**
 * A simple test algorithm, that optimizes the step size.
 * 
 * @author JS
 *
 */
public class SimpleStepSizeOptimizer extends AbstractConfigurationOptimizer {

	private static final Logger log = Logger
			.getLogger(SimpleStepSizeOptimizer.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		getLog().info("Now optimizing step size.");
		getLog().info(
				"Initial step size: "
						+ getConfiguration().getEstimation().getStepSize());
		setStepsize(70);
		getLog().info(
				"Optimization of step size is done. New step size: "
						+ getConfiguration().getEstimation().getStepSize());

	}

	@SuppressWarnings("unchecked")
	private void setStepsize(int stepsize) {

		// avoid use of commands in order to improve performance
		EStructuralFeature feature = getConfiguration()
				.getEstimation()
				.eClass()
				.getEStructuralFeature(
						ConfigurationPackage.ESTIMATION_SPECIFICATION__STEP_SIZE);
		Quantity<Time> stepSize = UnitsFactory.eINSTANCE.createQuantity();
		stepSize.setValue(stepsize);
		stepSize.setUnit(Time.SECONDS);
		getConfiguration().getEstimation().eSet(feature, stepSize);

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

}
