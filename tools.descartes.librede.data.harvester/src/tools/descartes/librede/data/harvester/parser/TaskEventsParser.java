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

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import tools.descartes.librede.data.harvester.objects.Cluster;
import tools.descartes.librede.data.harvester.objects.Machine;
import tools.descartes.librede.data.harvester.objects.Task;
import tools.descartes.librede.data.harvester.objects.TaskStatus;
import tools.descartes.librede.data.harvester.objects.WorkloadClass;

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
		long currentTime = -1;
		try {
			currentTime = Long.parseLong(split[0]);
		} catch (NumberFormatException e) {
			currentTime = Long.MAX_VALUE;
		}
		// override t is task already existed
		t = getTask(t);

		// Assigning machine
		if (!split[4].equals("")) {
			if (t.getMachineid() != 0 && Long.parseLong(split[4]) != t.getMachineid() && !t.isWasExcluded()) {
				if (t.getStatus() != TaskStatus.PENDING)
					log.warn("The same task was moved from machine " + t.getMachineid() + " to machine " + split[4]
							+ "!");
				else {
					// if pending its fine
				}
			}
			t.setMachineid(Long.parseLong(split[4]));
		}

		switch (Integer.parseInt(split[5])) {
		case 0: // SUBMIT
			if (t.getStatus() == TaskStatus.SUCCESSFUL) {
				splitTask(t, currentTime).setStatus(TaskStatus.PENDING);
				t.setStatus(TaskStatus.SUCCESSFULLY_SPLITTED);
			} else if (t.getStatus() == TaskStatus.DEAD) {
				t.setStatus(TaskStatus.PENDING);
			} else {
				assertThat(t, TaskStatus.UNSUBMITTED, split[5]);
				if (split.length >= 11) {
					// if let empty, leave zero
					t.setRequestedCPU(Float.parseFloat(split[9]));
					t.setRequestedMEM(Float.parseFloat(split[10]));
				}
				t.setStatus(TaskStatus.PENDING);
				cluster.addTask(t);
			}
			break;
		case 1: // SCHEDULE
			t.setStarttime(currentTime);
			// task already present, exclude since anomaly behavior
			assertThat(t, TaskStatus.PENDING, split[5]);
			t.setStatus(TaskStatus.RUNNING);
			break;
		case 2: // EVICT
			if (t.getStatus() == TaskStatus.PENDING)
				t.setStatus(TaskStatus.DEAD);
			else {
				assertThat(t, TaskStatus.RUNNING, split[5]);
				splitTask(t, currentTime).setStatus(TaskStatus.DEAD);
			}
			break;
		case 3: // FAIL
			if (t.getStatus() == TaskStatus.PENDING)
				t.setStatus(TaskStatus.DEAD);
			else {
				assertThat(t, TaskStatus.RUNNING, split[5]);
				splitTask(t, currentTime).setStatus(TaskStatus.DEAD);
			}
			break;
		case 4: // FINISH
			assertThat(t, TaskStatus.RUNNING, split[5]);
			t.setEndtime(currentTime);
			t.setStatus(TaskStatus.SUCCESSFUL);
			break;
		case 5: // KILL
			if (t.getStatus() == TaskStatus.PENDING)
				t.setStatus(TaskStatus.DEAD);
			else {
				assertThat(t, TaskStatus.RUNNING, split[5]);
				splitTask(t, currentTime).setStatus(TaskStatus.DEAD);
			}
			break;
		case 6: // LOST
			if (t.getStatus() == TaskStatus.PENDING)
				t.setStatus(TaskStatus.DEAD);
			else {
				assertThat(t, TaskStatus.RUNNING, split[5]);
				splitTask(t, currentTime).setStatus(TaskStatus.DEAD);
			}
			break;
		case 7: // UPDATE_PENDING
			// exclude since anomaly behavior
			assertThat(t, TaskStatus.PENDING, split[5]);
			t.setRequestedCPU(Float.parseFloat(split[9]));
			t.setRequestedMEM(Float.parseFloat(split[10]));
			break;
		case 8: // UPDATE_RUNNING
			// split tasks into two
			assertThat(t, TaskStatus.RUNNING, split[5]);
			splitTask(t, currentTime).setStatus(TaskStatus.RUNNING);
			break;
		}
	}

	private Task getTask(Task t) {
		int internalcounter = 0;
		while (cluster.getTask(t) != null && (cluster.getTask(t).getStatus() == TaskStatus.SPLIT
				|| cluster.getTask(t).getStatus() == TaskStatus.SUCCESSFULLY_SPLITTED)) {
			internalcounter++;
			t.setInternalRepeatId(internalcounter);
		}
		if (cluster.getTask(t) != null)
			return cluster.getTask(t);
		else
			return t;
	}

	private void assertThat(Task t, TaskStatus status, String operation) {
		if (t.getStatus() != status) {
			log.warn("Illegal status " + t.getStatus() + " when performing operation " + operation + ".");
			t.setWasExcluded(true);
		}
	}

	private Task splitTask(Task t, long currentTime) {
		t.setEndtime(currentTime);
		t.setStatus(TaskStatus.SPLIT);
		Task newt = new Task(t.getJobId(), t.getTaskId());
		newt.setInternalRepeatId(t.getInternalRepeatId() + 1);
		newt.setStarttime(currentTime);
		newt.setStatus(TaskStatus.DEAD);
		cluster.addTask(newt);
		return newt;
	}

	/**
	 * 
	 */
	public void organizeWorkloadClasses(Cluster cluster) {
		// find our wcs
		HashMap<WorkloadClass, WorkloadClass> wcs = new HashMap<WorkloadClass, WorkloadClass>();
		int numberOfWCs = 0;
		// assign to machines and find our wcs
		for (Task t : cluster.getTasks().values()) {
			WorkloadClass wc = new WorkloadClass(t.getRequestedCPU(), t.getRequestedMEM());
			if (wcs.containsKey(wc)) {
				t.setWc(wcs.get(wc));
			} else {
				wc.setId(numberOfWCs++);
				t.setWc(wc);
				wcs.put(wc, wc);
			}
			// assign task to machine
			Machine m = cluster.getContainingMachine(t.getMachineid());
			if (m != null) {
				// create empty list if not yet there
				if (m.getTasks().get(wcs.get(wc)) == null)
					m.getTasks().put(wcs.get(wc), new TreeSet<Task>(new Comparator<Task>() {
						@Override
						public int compare(Task o1, Task o2) {
							return Long.compare(o1.getStarttime(), o2.getStarttime());
						}

					}));
				m.getTasks().get(wcs.get(wc)).add(t);

			}

		}
		cluster.setNumberOfWCs(numberOfWCs);
	}

}
