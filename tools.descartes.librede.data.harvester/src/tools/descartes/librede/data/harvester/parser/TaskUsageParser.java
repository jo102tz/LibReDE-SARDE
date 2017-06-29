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

import tools.descartes.librede.data.harvester.Harvester;
import tools.descartes.librede.data.harvester.objects.Cluster;
import tools.descartes.librede.data.harvester.objects.Machine;
import tools.descartes.librede.data.harvester.objects.TaskUsage;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class TaskUsageParser extends Parser {

	private long earliestStart = Long.MAX_VALUE;

	private long latestEnd = 0;

	private Cluster cluster;

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * @param cluster
	 */
	public TaskUsageParser(Cluster cluster) {
		super();
		this.cluster = cluster;
	}

	@Override
	protected void processLine() {
		String[] split = getSplit();
		long machineId = Long.parseLong(split[4]);
		long starttime = Long.parseLong(split[0]);
		earliestStart = Long.min(earliestStart, starttime);
		long endtime = Long.parseLong(split[1]);
		latestEnd = Long.max(latestEnd, endtime);

		Machine m = cluster.getContainingMachine(machineId);
		if (m != null) {
			if (!Harvester.IGNORE_UPDATED_MACHINES || !m.isWasupdated()) {
				m.addTaskUsage(new TaskUsage(Long.parseLong(split[3]), starttime, endtime, Float.parseFloat(split[5]),
						Float.parseFloat(split[19]), Float.parseFloat(split[13])));
			}
		} else {
			log.warn("No machine found with id " + machineId + ".");
		}
	}

	/**
	 * @return the earliestStart
	 */
	public long getEarliestStart() {
		return earliestStart;
	}

	/**
	 * @param earliestStart
	 *            the earliestStart to set
	 */
	public void setEarliestStart(long earliestStart) {
		this.earliestStart = earliestStart;
	}

	/**
	 * @return the latestEnd
	 */
	public long getLatestEnd() {
		return latestEnd;
	}

	/**
	 * @param latestEnd
	 *            the latestEnd to set
	 */
	public void setLatestEnd(long latestEnd) {
		this.latestEnd = latestEnd;
	}

}
