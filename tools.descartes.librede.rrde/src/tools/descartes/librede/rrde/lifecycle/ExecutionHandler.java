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

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.repository.IMonitoringRepository;
import tools.descartes.librede.rrde.optimization.util.Util;

/**
 * Handler for executing, logging and storing all execution runs.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class ExecutionHandler {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(ExecutionHandler.class);

	private LogBook estimationLog;

	/**
	 * Constructor.
	 */
	public ExecutionHandler() {
		estimationLog = new LogBook(OperationType.ESTIMATION);
	}

	/**
	 * Executes one estimation run with the given variables. The variables
	 * should not be modified during this execution (based on a copy).
	 * 
	 * @param var
	 *            The variables (containing the configuration) to execute.
	 */
	public void executeEstimation(LibredeVariables var) {
		log.info("Executing estimation run.");
		LibredeResults res = null;
		long tic = System.currentTimeMillis();
		try {
			res = Librede.runEstimationWithCrossValidation(var);
		} catch (Exception e) {
			log.warn("Executing the estimation threw an error.");
			e.printStackTrace();
		} finally {
			long toc = System.currentTimeMillis();
			LogEntry entry = new LogEntry(tic, toc, "Estimation Error.");
			if (res != null) {
				entry.setMetric(new Double(Util.getValidationError(res, var.getConf().getValidation())).toString());
			}
			estimationLog.insert(entry);
		}
		log.info("Executed " + estimationLog.getLength() + "th run. End-timestamp: "
				+ var.getConf().getEstimation().getEndTimestamp().toString() + ".");
	}

	/**
	 * Executes one estimation run with the given variables. The variables
	 * should not be modified during this execution (based on a copy).
	 * 
	 * @param repo
	 * @param libredeConfiguration
	 */
	public void executeEstimation(IMonitoringRepository repo, LibredeConfiguration libredeConfiguration) {
		// TODO Auto-generated method stub

	}

}
