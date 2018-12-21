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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A class containing log information of different runs.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class LogBook {

	/**
	 * The actual log entries.
	 */
	private SortedSet<LogEntry> book;

	/**
	 * The map storing the counts.
	 */
	private Map<OperationType, Integer> counts;

	/**
	 * Constructor.
	 * 
	 * @param type
	 *            The type of records that should be contained in this LogBook.
	 */
	public LogBook() {
		counts = new HashMap<>();
		counts.put(OperationType.ESTIMATION, 0);
		counts.put(OperationType.RECOMMENDATION, 0);
		counts.put(OperationType.TRAINING, 0);
		counts.put(OperationType.OPTIMIZATION, 0);
		book = new TreeSet<>();
	}

	/**
	 * Add this entry to logbook.
	 * 
	 * @param entry
	 *            The entry to add.
	 */
	public void insert(LogEntry entry) {
		book.add(entry);
		counts.put(entry.getType(), counts.get(entry.getType()) + 1);
	}

	/**
	 * Returns the number of logs (executions) of the specific type contained in
	 * the book.
	 * 
	 * @return Size of the {@link LogBook}.
	 */
	public int getLength(OperationType type) {
		if (counts.containsKey(type)) {
			return counts.get(type);
		} else {
			return book.size();
		}
	}

	/**
	 * Writes this logbook to the given CSV-File.
	 * 
	 * @param file
	 *            The file to write to.
	 * @throws FileNotFoundException
	 *             If the given file object does not denote an existing,
	 *             writable regular file and a new regular file of that name
	 *             cannot be created, or if some other error occurs while
	 *             opening orcreating the file.
	 */
	public void exportToCsv(String file) throws FileNotFoundException {
		PrintWriter pw;
		pw = new PrintWriter(new File(file));
		StringBuilder sb = new StringBuilder();

		// header
		sb.append("Finish time,");
		sb.append("Time,");
		sb.append("Type,");
		sb.append("Selected Approach,");
		sb.append("Estimated Demand,");
		sb.append("Estimated Error,");
		sb.append("\n");

		// entries
		for (LogEntry entry : book) {
			sb.append(entry.getEndtimems() + ", ");
			sb.append(entry.getEndtimems() - entry.getStarttimems() + ", ");
			sb.append(entry.getType() + ", ");
			if (entry instanceof RecommendationEntry) {
				sb.append(((RecommendationEntry) entry).getChosenApproach() + ", ");
				sb.append("-,");
				sb.append("-,");
			} else if (entry instanceof EstimationEntry) {
				sb.append("-,");
				sb.append(((EstimationEntry) entry).getEstimate() + ", ");
				sb.append(((EstimationEntry) entry).getError() + ", ");
			} else if (entry instanceof SkippedEntry){
				sb.append("SKIPPED,");
				sb.append("SKIPPED,");
				sb.append("SKIPPED,");
			} else {
				sb.append("-,");
				sb.append("-,");
				sb.append("-,");
			}
			sb.append("\n");
		}

		pw.write(sb.toString());
		pw.close();
	}

}
