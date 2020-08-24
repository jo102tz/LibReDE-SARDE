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
	 * @param type The type of records that should be contained in this LogBook.
	 */
	public LogBook() {
		counts = new HashMap<>();
		counts.put(OperationType.ESTIMATION, 0);
		counts.put(OperationType.RECOMMENDATION, 0);
		counts.put(OperationType.TRAINING, 0);
		counts.put(OperationType.OPTIMIZATION, 0);
		counts.put(OperationType.EVALUATION, 0);
		counts.put(OperationType.OPTIMIZED_EVALUATION, 0);
		book = new TreeSet<>();
	}

	/**
	 * Add this entry to logbook.
	 * 
	 * @param entry The entry to add.
	 */
	public void insert(LogEntry entry) {
		book.add(entry);
		counts.put(entry.getType(), counts.get(entry.getType()) + 1);
	}

	/**
	 * Returns the number of logs (executions) of the specific type contained in the
	 * book.
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
	 * @param file The file to write to.
	 * @throws FileNotFoundException If the given file object does not denote an
	 *                               existing, writable regular file and a new
	 *                               regular file of that name cannot be created, or
	 *                               if some other error occurs while opening
	 *                               or creating the file.
	 */
	public void exportToCsv(String file) throws FileNotFoundException {
		PrintWriter pw;
		pw = new PrintWriter(new File(file));

		// header
		pw.write("Finish time,");
		pw.write("Time,");
		pw.write("Type,");
		pw.write("Selected Approach,");
		pw.write("Estimated Demand,");
		pw.write("Estimated Error,");
		pw.write("\n");

		// entries
		for (LogEntry entry : book) {
			pw.write(entry.getEndtimems() + ", ");
			pw.write(entry.getEndtimems() - entry.getStarttimems() + ", ");
			pw.write(entry.getType() + ", ");
			if (entry instanceof RecommendationEntry) {
				pw.write(((RecommendationEntry) entry).getChosenApproach() + ", ");
				pw.write("-,");
				pw.write("-,");
			} else if (entry instanceof EstimationEntry) {
				pw.write("-,");
				pw.write(((EstimationEntry) entry).getEstimate() + ", ");
				pw.write(((EstimationEntry) entry).getError() + ", ");
			} else if (entry instanceof EvaluationEntry) {
				pw.write(((EvaluationEntry) entry).getApproach() + ", ");
				pw.write(((EvaluationEntry) entry).getEstimate() + ", ");
				pw.write(((EvaluationEntry) entry).getError() + ", ");
			} else if (entry instanceof OptimizedEvaluationEntry) {
				pw.write(((OptimizedEvaluationEntry) entry).getApproach() + ", ");
				pw.write(((OptimizedEvaluationEntry) entry).getEstimate() + ", ");
				pw.write(((OptimizedEvaluationEntry) entry).getError() + ", ");
			} else if (entry instanceof SkippedEntry) {
				pw.write("SKIPPED,");
				pw.write("SKIPPED,");
				pw.write("SKIPPED,");
			} else {
				pw.write("-,");
				pw.write("-,");
				pw.write("-,");
			}
			pw.write("\n");
			pw.flush();
		}
		pw.close();
	}

}
