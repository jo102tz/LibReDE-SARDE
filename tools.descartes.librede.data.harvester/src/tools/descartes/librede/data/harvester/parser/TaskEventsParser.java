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
package tools.descartes.librede.data.harvester.parser;

import org.apache.log4j.Logger;

import tools.descartes.librede.data.harvester.objects.Cluster;
import tools.descartes.librede.data.harvester.objects.Machine;
import tools.descartes.librede.data.harvester.objects.Task;
import tools.descartes.librede.data.harvester.objects.TaskUsage;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class TaskEventsParser extends Parser {

	private Cluster cluster;

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * @param cluster2
	 */
	public TaskEventsParser(Cluster cluster) {
		this.cluster = cluster;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.data.harvester.parser.Parser#processLine()
	 */
	@Override
	protected void processLine() {
		String[] split = getSplit();
		Task t = new Task(Long.parseLong(split[2]), Long.parseLong(split[3]));
		Task oldt = null;
		Machine m = null;
		if (!split[4].equals("")) {
			m = cluster.getContainingMachine(Long.parseLong(split[4]));
			if (m == null)
				log.warn("The machine id " + split[4] + " could not be found.");
			else if (m.getTasks().containsValue(t)) {
				oldt = m.getTasks().get(t);
			}
		} else if (Integer.parseInt(split[5]) == 0) {
			// SUBMIT
			// its okay, do nothing
		} else {
			log.debug("No machine was given for task " + t.getTaskId() + " of job " + t.getJobId() + ".");
		}

		switch (Integer.parseInt(split[5])) {
		case 0: // SUBMIT
			// do nothing, was handled above
			break;
		case 1: // SCHEDULE
			if (oldt == null) {
				if (m != null) { // only if the machine was found
					t.setStarttime(Long.parseLong(split[0]));
					m.getTasks().put(t, t);
				}
			} else {
				// task already present, exclude since anomaly behavior
				oldt.setWasExcluded(true);
			}
			break;
		case 2: // EVICT
			// exclude since anomaly behavior
			if (oldt != null)
				oldt.setWasExcluded(true);
			break;
		case 3: // FAIL
			// exclude since anomaly behavior
			if (oldt != null)
				oldt.setWasExcluded(true);
			break;
		case 4: // FINISH
			// if not excluded, add finish time
			if (oldt != null)
				oldt.setEndtime(Long.parseLong(split[0]));
			break;
		case 5: // KILL
			// exclude since anomaly behavior
			if (oldt != null)
				oldt.setWasExcluded(true);
			break;
		case 6: // LOST
			// exclude since anomaly behavior
			if (oldt != null)
				oldt.setWasExcluded(true);
			break;
		case 7: // UPDATE_PENDING
			// exclude since anomaly behavior
			if (oldt != null)
				oldt.setWasExcluded(true);
			break;
		case 8: // UPDATE_RUNNING
			// exclude since anomaly behavior
			if (oldt != null)
				oldt.setWasExcluded(true);
			break;
		}
	}

}
