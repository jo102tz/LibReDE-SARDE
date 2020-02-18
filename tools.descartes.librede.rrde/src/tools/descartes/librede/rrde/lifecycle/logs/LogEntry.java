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
 * This class describes one log entity.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class LogEntry implements Comparable<LogEntry> {

	/**
	 * The start time in milliseconds.
	 */
	private long starttimems;

	/**
	 * The end time in milliseconds.
	 */
	private long endtimems;

	/**
	 * The payload type.
	 */
	private OperationType type;

	/**
	 * @param starttimems
	 *            The start time of the process in milliseconds.
	 * @param endtimems
	 *            The end time of the process in milliseconds.
	 * @param type
	 *            The {@link OperationType} of this logging entry.
	 */
	public LogEntry(long starttimems, long endtimems, OperationType type) {
		super();
		this.starttimems = starttimems;
		this.endtimems = endtimems;
		this.type = type;
	}

	/**
	 * @return the starttimems
	 */
	public long getStarttimems() {
		return starttimems;
	}

	/**
	 * @param starttimems
	 *            the starttimems to set
	 */
	public void setStarttimems(long starttimems) {
		this.starttimems = starttimems;
	}

	/**
	 * @return the endtimems
	 */
	public long getEndtimems() {
		return endtimems;
	}

	/**
	 * @param endtimems
	 *            the endtimems to set
	 */
	public void setEndtimems(long endtimems) {
		this.endtimems = endtimems;
	}

	/**
	 * @return the type
	 */
	public OperationType getType() {
		return type;
	}
	
	/**
	 * @return the type
	 */
	public void setType(OperationType type) {
		this.type = type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setMetric(OperationType type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LogEntry o) {
		// ordering the elements after their finish time, i.e., their logging
		// order
		return Long.valueOf(this.getEndtimems()).compareTo(o.getEndtimems());
	}
}
