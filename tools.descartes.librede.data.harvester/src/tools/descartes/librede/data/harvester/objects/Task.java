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

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class Task {

	private long taskId;

	private long jobId;

	private long internalRepeatId;

	private WorkloadClass wc;

	private long starttime;

	private long endtime;

	private long machineid;

	private boolean wasExcluded;

	private float requestedCPU;

	private float requestedMEM;

	private TaskStatus status;

	/**
	 * @param taskId
	 * @param jobId
	 */
	public Task(long jobId, long taskId) {
		super();
		this.taskId = taskId;
		this.jobId = jobId;
		status = TaskStatus.UNSUBMITTED;
		internalRepeatId = 0;
		wasExcluded = false;
	}

	/**
	 * @return the wc
	 */
	public WorkloadClass getWc() {
		return wc;
	}

	/**
	 * @param wc
	 *            the wc to set
	 */
	public void setWc(WorkloadClass wc) {
		this.wc = wc;
	}

	/**
	 * @return the starttime
	 */
	public long getStarttime() {
		return starttime;
	}

	/**
	 * @param starttime
	 *            the starttime to set
	 */
	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return the endtime
	 */
	public long getEndtime() {
		return endtime;
	}

	/**
	 * @param endtime
	 *            the endtime to set
	 */
	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}

	/**
	 * @return the wasExcluded
	 */
	public boolean isWasExcluded() {
		return wasExcluded;
	}

	/**
	 * @param wasExcluded
	 *            the wasExcluded to set
	 */
	public void setWasExcluded(boolean wasExcluded) {
		this.wasExcluded = wasExcluded;
	}

	/**
	 * @return the taskId
	 */
	public long getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the jobId
	 */
	public long getJobId() {
		return jobId;
	}

	/**
	 * @param jobId
	 *            the jobId to set
	 */
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the internalRepeatId
	 */
	public long getInternalRepeatId() {
		return internalRepeatId;
	}

	/**
	 * @param internalRepeatId
	 *            the internalRepeatId to set
	 */
	public void setInternalRepeatId(long internalRepeatId) {
		this.internalRepeatId = internalRepeatId;
	}

	/**
	 * @return the machineid
	 */
	public long getMachineid() {
		return machineid;
	}

	/**
	 * @param machineid
	 *            the machineid to set
	 */
	public void setMachineid(long machineid) {
		this.machineid = machineid;
	}

	/**
	 * @return the requestedCPU
	 */
	public float getRequestedCPU() {
		return requestedCPU;
	}

	/**
	 * @param requestedCPU
	 *            the requestedCPU to set
	 */
	public void setRequestedCPU(float requestedCPU) {
		this.requestedCPU = requestedCPU;
	}

	/**
	 * @return the requestedMEM
	 */
	public float getRequestedMEM() {
		return requestedMEM;
	}

	/**
	 * @param requestedMEM
	 *            the requestedMEM to set
	 */
	public void setRequestedMEM(float requestedMEM) {
		this.requestedMEM = requestedMEM;
	}

	/**
	 * @return the status
	 */
	public TaskStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(TaskStatus status) {
		this.status = status;
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
		result = prime * result + (int) (internalRepeatId ^ (internalRepeatId >>> 32));
		result = prime * result + (int) (jobId ^ (jobId >>> 32));
		result = prime * result + (int) (taskId ^ (taskId >>> 32));
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
		Task other = (Task) obj;
		if (internalRepeatId != other.internalRepeatId)
			return false;
		if (jobId != other.jobId)
			return false;
		if (taskId != other.taskId)
			return false;
		return true;
	}

}
