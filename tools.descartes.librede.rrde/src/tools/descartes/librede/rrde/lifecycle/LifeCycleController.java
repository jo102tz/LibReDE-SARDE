/**
 * ==============================================
 *  LibReDE : Library for Resource Demand Estimation
 * ==============================================
 *
 * (c) Copyright 2013-2018, by Simon Spinner, Johannes Grohmann
 * and Contributors.
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
package tools.descartes.librede.rrde.lifecycle;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.UnitsFactory;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class LifeCycleController {

	/**
	 * The logger used for logging.
	 */
	private static final Logger log = Logger.getLogger(LifeCycleController.class);

	/**
	 * Method, that starts the online estimation and learning cycle.
	 * 
	 * @param lifeCycleConfiguration
	 *            The configuration to execute.
	 * @param libredeConfiguration
	 *            The librede Configuration to execute (default until
	 *            overwritten).
	 * @param logFolder
	 *            Location to log intermediate information to.
	 * @throws Exception
	 */
	public void startLifeCycle(LifeCycleConfiguration lifeCycleConfiguration, LibredeConfiguration libredeConfiguration,
			String logFolder) throws Exception {
		ExecutionHandler handler = new ExecutionHandler(logFolder);

		Quantity<Time> originalEnd = libredeConfiguration.getEstimation().getEndTimestamp();
		Quantity<Time> newEnd = libredeConfiguration.getEstimation().getStartTimestamp();
		// we use an increment of 1 second here.
		// this can be easily adapted, however for now, we assume 1 second to be
		// the smallest unit.
		// get intervals
		Quantity<Time> increment = UnitsFactory.eINSTANCE.createQuantity();
		increment.setUnit(Time.SECONDS);
		increment.setValue(1);
		long starttime = System.currentTimeMillis();
		int timepassed = 0;
		while (newEnd.compareTo(originalEnd) <= 0) {
			timepassed = (int) ((System.currentTimeMillis() - starttime) / 1000);
			timepassed++;
			newEnd = newEnd.plus(increment);
			setConfigurationEndTime(libredeConfiguration, lifeCycleConfiguration, newEnd);
			if (lifeCycleConfiguration.getEstimationLoopTime() != -1 &&  timepassed % lifeCycleConfiguration.getEstimationLoopTime() == 0) {
				handler.executeEstimation(libredeConfiguration);
			}
			if (lifeCycleConfiguration.getSelectionLoopTime() != -1 &&  timepassed % lifeCycleConfiguration.getSelectionLoopTime() == 0) {
				handler.executeRecommendation(libredeConfiguration);
			}
			if (lifeCycleConfiguration.getRecommendationLoopTime() != -1 &&  timepassed % lifeCycleConfiguration.getRecommendationLoopTime() == 0) {
				handler.executeTraining(lifeCycleConfiguration.getRecommendationConfiguration());
			}
			if (lifeCycleConfiguration.getOptimizationLoopTime() != -1 && timepassed % lifeCycleConfiguration.getOptimizationLoopTime() == 0) {
				handler.executeOptimization(lifeCycleConfiguration.getOptimizationConfiguration(),
						libredeConfiguration);
			}
			Thread.sleep(1000);
			log.trace("Executed " + timepassed + "th loop interval.");
		}
		handler.finish();
	}

	private void setConfigurationEndTime(LibredeConfiguration conf, LifeCycleConfiguration lifeCycleConfiguration,
			Quantity<Time> newEnd) {
		// var.getConf().getEstimation().setEndTimestamp(EcoreUtil.copy(newEnd));
		conf.getEstimation().setEndTimestamp(EcoreUtil.copy(newEnd));
		for (RunCall i : lifeCycleConfiguration.getOptimizationConfiguration().getContainsOf()) {
			i.getEstimation().setEndTimestamp(EcoreUtil.copy(newEnd));
		}
		for (EstimationSpecification i : lifeCycleConfiguration.getRecommendationConfiguration().getEstimators()) {
			i.setEndTimestamp(EcoreUtil.copy(newEnd));
		}
	}

}
