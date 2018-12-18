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

import tools.descartes.librede.rrde.lifecycle.OperationType;

/**
 * This class represents a specific log entry, logged by the selection process.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class RecommendationEntry extends LogEntry {

	private String chosenApproach;

	/**
	 * Constructor.
	 * 
	 * @param starttimems
	 *            The start time of the process in milliseconds.
	 * @param endtimems
	 *            The end time of the process in milliseconds.
	 * @param chosenApproach
	 *            The approach chosen by the selection entry.
	 */
	public RecommendationEntry(long starttimems, long endtimems, String chosenApproach) {
		super(starttimems, endtimems, OperationType.RECOMENDATION);
		this.chosenApproach = chosenApproach;
	}

	/**
	 * @return the chosenApproach
	 */
	public String getChosenApproach() {
		return chosenApproach;
	}

	/**
	 * @param chosenApproach
	 *            the chosenApproach to set
	 */
	public void setChosenApproach(String chosenApproach) {
		this.chosenApproach = chosenApproach;
	}

}
