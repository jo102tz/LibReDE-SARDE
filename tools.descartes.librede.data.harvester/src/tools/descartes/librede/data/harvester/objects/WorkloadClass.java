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
public class WorkloadClass {

	private int id;

	private float requestedCPU;

	private float requestedMEM;

	/**
	 * @param id
	 * @param requestedCPU
	 * @param requestedMEM
	 */
	public WorkloadClass(float requestedCPU, float requestedMEM) {
		super();
		this.requestedCPU = requestedCPU;
		this.requestedMEM = requestedMEM;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(requestedCPU);
		result = prime * result + Float.floatToIntBits(requestedMEM);
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
		WorkloadClass other = (WorkloadClass) obj;
		if (Float.floatToIntBits(requestedCPU) != Float.floatToIntBits(other.requestedCPU))
			return false;
		if (Float.floatToIntBits(requestedMEM) != Float.floatToIntBits(other.requestedMEM))
			return false;
		return true;
	}

}
