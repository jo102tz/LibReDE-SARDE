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
package tools.descartes.librede.rrde.lifecycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	private ArrayList<LogEntry> book;

	/**
	 * The type of logs this Book contains.
	 */
	private OperationType type;

	/**
	 * Constructor.
	 * 
	 * @param type
	 *            The type of records that should be contained in this LogBook.
	 */
	public LogBook(OperationType type) {
		this.type = type;
		book = new ArrayList<>();
	}

	/**
	 * Add this entry to logbook.
	 * 
	 * @param entry
	 *            The entry to add.
	 */
	public void insert(LogEntry entry) {
		book.add(entry);
	}

	/**
	 * Returns the number of logs (executions) contained in the book.
	 * 
	 * @return Size of the {@link LogBook}.
	 */
	public int getLength() {
		return book.size();
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
		sb.append("Timestamp,");
		sb.append("Metric,");
		sb.append("Time,");
		sb.append("\n");

		// entries
		for (LogEntry entry : book) {
			sb.append(entry.getEndtimems() + ", ");
			sb.append(entry.getMetric() + ", ");
			sb.append(entry.getEndtimems() - entry.getStarttimems() + ", ");
			sb.append("\n");
		}

		pw.write(sb.toString());
		pw.close();
	}

}
