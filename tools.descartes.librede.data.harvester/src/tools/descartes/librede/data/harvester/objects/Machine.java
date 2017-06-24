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

import java.util.LinkedList;
import java.util.List;

import tools.descartes.librede.data.harvester.objects.utilization.Point;
import tools.descartes.librede.data.harvester.objects.utilization.UtilizationTimeLine;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class Machine {

	private long id;

	private long addtime;

	private long removetime;

	private boolean wasupdated = false;

	private String platformid;

	private float cpu;

	private float memory;
	
	private int totalTasks = 0;

	private UtilizationTimeLine utiltl;

	/**
	 * @param id
	 */
	public Machine(int id) {
		super();
		this.id = id;
		utiltl = new UtilizationTimeLine();
	}

	/**
	 * @param id
	 * @param addtime
	 * @param platformid
	 * @param cpu
	 * @param memory
	 */
	public Machine(long id, long addtime, String platformid, float cpu, float memory) {
		super();
		this.id = id;
		this.addtime = addtime;
		this.platformid = platformid;
		this.cpu = cpu;
		this.memory = memory;
		utiltl = new UtilizationTimeLine();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the addtime
	 */
	public long getAddtime() {
		return addtime;
	}

	/**
	 * @param addtime
	 *            the addtime to set
	 */
	public void setAddtime(long addtime) {
		this.addtime = addtime;
	}

	/**
	 * @return the removetime
	 */
	public long getRemovetime() {
		return removetime;
	}

	/**
	 * @param removetime
	 *            the removetime to set
	 */
	public void setRemovetime(long removetime) {
		this.removetime = removetime;
	}

	/**
	 * @return the wasupdated
	 */
	public boolean isWasupdated() {
		return wasupdated;
	}

	/**
	 * @param wasupdated
	 *            the wasupdated to set
	 */
	public void setWasupdated(boolean wasupdated) {
		this.wasupdated = wasupdated;
	}

	/**
	 * @return the platformid
	 */
	public String getPlatformid() {
		return platformid;
	}

	/**
	 * @param platformid
	 *            the platformid to set
	 */
	public void setPlatformid(String platformid) {
		this.platformid = platformid;
	}

	/**
	 * @return the cpu
	 */
	public float getCpu() {
		return cpu;
	}

	/**
	 * @param cpu
	 *            the cpu to set
	 */
	public void setCpu(float cpu) {
		this.cpu = cpu;
	}

	/**
	 * @return the memory
	 */
	public float getMemory() {
		return memory;
	}

	/**
	 * @param memory
	 *            the memory to set
	 */
	public void setMemory(float memory) {
		this.memory = memory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Machine other = (Machine) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * @return the totalTasks
	 */
	public int getTotalTasks() {
		return totalTasks;
	}

	/**
	 * @param totalTasks the totalTasks to set
	 */
	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}

	public void addTask(TaskUsage task) {
		totalTasks++;
		utiltl.addTask(task);
	}

	public List<Point> getUtilization() {
		LinkedList<Point> list = new LinkedList<Point>();
		Point cur = utiltl.getStart();

		while (cur != null) {
			list.add(cur);
			cur = cur.getPost();
		}

		// delete helper points
		list.removeFirst();
		list.removeLast();
		return list;
	}

}
