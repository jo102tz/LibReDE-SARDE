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
package tools.descartes.librede.data.harvester.objects;

import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.logging.Logger;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class Cluster {

	private HashMap<Long, Machine> machines;

	private HashMap<Task, Task> tasks;

	private int numberOfWCs;

	/**
	 * @param machines
	 */
	public Cluster() {
		super();
		this.machines = new HashMap<Long, Machine>();
		this.tasks = new HashMap<Task, Task>();
	}

	/**
	 * @return the machines
	 */
	public HashMap<Long, Machine> getMachines() {
		return machines;
	}

	/**
	 * @param machines
	 *            the machines to set
	 */
	public void setMachines(HashMap<Long, Machine> machines) {
		this.machines = machines;
	}

	public void addMachine(Machine m) {
		if (machines.containsKey(m.getId())) {
			if (getContainingMachine(m.getId()).getRemovetime() == 0)
				Logger.getGlobal().info("Machine " + m.getId() + " was added twice.");
			getContainingMachine(m.getId()).setWasupdated(true);
		} else
			machines.put(m.getId(), m);
	}

	public void removeMachine(long id, long time) {
		Machine machine = getContainingMachine(id);
		if (machine != null) {
			// machine is our already contained element
			machine.setRemovetime(time);
			machine.setWasupdated(true);
		} else
			throw new NoSuchElementException("Machine " + id + " is not known.");
	}

	public void updateMachine(long id) {
		getContainingMachine(id).setWasupdated(true);
	}

	public Machine getContainingMachine(long id) {
		return machines.get(id);
	}

	public void addTask(Task t) {
		tasks.put(t, t);
	}

	public Task getTask(Task t) {
		return tasks.get(t);
	}

	public HashMap<Task, Task> getTasks() {
		return tasks;
	}

	/**
	 * @return the numberOfWCs
	 */
	public int getNumberOfWCs() {
		return numberOfWCs;
	}

	/**
	 * @param numberOfWCs
	 *            the numberOfWCs to set
	 */
	public void setNumberOfWCs(int numberOfWCs) {
		this.numberOfWCs = numberOfWCs;
	}

}
