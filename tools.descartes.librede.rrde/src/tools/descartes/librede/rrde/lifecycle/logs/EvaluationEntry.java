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
package tools.descartes.librede.rrde.lifecycle.logs;

/**
 * This class represents a specific log entry for evaluation purposes only,
 * logged by the evaluation process.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class EvaluationEntry extends LogEntry {

	/**
	 * The error of the specific estimation.
	 */
	private String error;

	/**
	 * The estimation to log.
	 */
	private String estimate;
	
	/**
	 * The approach to log.
	 */
	private String approach;

	/**
	 * Constructor.
	 * 
	 * @param starttimems
	 *            The start time of the process in milliseconds.
	 * @param endtimems
	 *            The end time of the process in milliseconds.
	 * @param estimate
	 *            The estimation to log.
	 * @param error
	 *            The error of the specific estimation.
	 */
	public EvaluationEntry(long starttimems, long endtimems, String approach, String estimate, String error) {
		super(starttimems, endtimems, OperationType.EVALUATION);
		this.error = error;
		this.estimate = estimate;
		this.approach = approach;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the estimate
	 */
	public String getEstimate() {
		return estimate;
	}

	/**
	 * @param estimate
	 *            the estimate to set
	 */
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
	
	/**
	 * @return the approach
	 */
	public String getApproach() {
		return approach;
	}

	/**
	 * @param approach the approach to set
	 */
	public void setApproach(String approach) {
		this.approach = approach;
	}


}
