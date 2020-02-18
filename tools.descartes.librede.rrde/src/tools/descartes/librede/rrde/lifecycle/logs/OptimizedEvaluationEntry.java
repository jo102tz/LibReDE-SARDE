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
 * This class represents a specific log entry for the evaluation of optimized
 * executions only.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class OptimizedEvaluationEntry extends EvaluationEntry {
	/**
	 * Constructor.
	 * 
	 * @param starttimems The start time of the process in milliseconds.
	 * @param endtimems   The end time of the process in milliseconds.
	 * @param estimate    The estimation to log.
	 * @param error       The error of the specific estimation.
	 */
	public OptimizedEvaluationEntry(long starttimems, long endtimems, String approach, String estimate, String error) {
		super(starttimems, endtimems, approach, estimate, error);
		setType(OperationType.OPTIMIZED_EVALUATION);
	}

}
