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
package tools.descartes.librede.rrde;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.ResultPrinter;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class LifeCycleController {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(LifeCycleController.class);

	/**
	 * Method, that starts the online estimation and learning cycle.
	 * 
	 * @param lifeCycleConfiguration
	 * @param libredeConfiguration
	 * @throws Exception 
	 */
	public void startLifeCycle(LifeCycleConfiguration lifeCycleConfiguration,
			LibredeConfiguration libredeConfiguration) throws Exception {
		// get interval
		Quantity<Time> interval = EcoreUtil.copy(libredeConfiguration.getEstimation().getStepSize());
		interval.setValue(lifeCycleConfiguration.getEstimationLoopTime());
		interval.setUnit(Time.SECONDS);
		Quantity<Time> originalEnd = libredeConfiguration.getEstimation().getEndTimestamp();
		Quantity<Time> newEnd = libredeConfiguration.getEstimation().getStartTimestamp();
		
		log.info("Initializing repo.");
		LibredeVariables var = new LibredeVariables(libredeConfiguration);
		Librede.initRepo(var);
		log.info("Finished initializing repository.");
		
		int i = 0;
		while (newEnd.compareTo(originalEnd) < 0){
			newEnd.plus(interval);
			libredeConfiguration.getEstimation().setEndTimestamp(newEnd);
			LibredeResults res = Librede.runEstimationWithCrossValidation(var);
			ResultPrinter.printSummary(res);
			i++;
			log.info("Executed "+i+"th run. End-timestamp: "+newEnd.toString()+". Final end will be: "+originalEnd.toString());
		}

	}

}
