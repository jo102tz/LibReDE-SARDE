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
	public WorkloadClass(int id, float requestedCPU, float requestedMEM) {
		super();
		this.id = id;
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

}
