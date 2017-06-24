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
public class TaskUsage {

	private long tasknr;

	private long starttime;

	private long endtime;

	private float meanCPU;

	private float sampledCPU;

	private float maxCPU;

	/**
	 * @param tasknr
	 * @param starttime
	 * @param endtime
	 * @param meanCPU
	 * @param sampledCPU
	 * @param maxCPU
	 */
	public TaskUsage(long tasknr, long starttime, long endtime, float meanCPU, float sampledCPU, float maxCPU) {
		super();
		this.tasknr = tasknr;
		this.starttime = starttime;
		this.endtime = endtime;
		this.meanCPU = meanCPU;
		this.sampledCPU = sampledCPU;
		this.maxCPU = maxCPU;
	}

	/**
	 * @return the tasknr
	 */
	public long getTasknr() {
		return tasknr;
	}

	/**
	 * @param tasknr
	 *            the tasknr to set
	 */
	public void setTasknr(long tasknr) {
		this.tasknr = tasknr;
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
	 * @return the meanCPU
	 */
	public float getMeanCPU() {
		return meanCPU;
	}

	/**
	 * @param meanCPU
	 *            the meanCPU to set
	 */
	public void setMeanCPU(float meanCPU) {
		this.meanCPU = meanCPU;
	}

	/**
	 * @return the sampledCPU
	 */
	public float getSampledCPU() {
		return sampledCPU;
	}

	/**
	 * @param sampledCPU
	 *            the sampledCPU to set
	 */
	public void setSampledCPU(float sampledCPU) {
		this.sampledCPU = sampledCPU;
	}

	/**
	 * @return the maxCPU
	 */
	public float getMaxCPU() {
		return maxCPU;
	}

	/**
	 * @param maxCPU
	 *            the maxCPU to set
	 */
	public void setMaxCPU(float maxCPU) {
		this.maxCPU = maxCPU;
	}

}
