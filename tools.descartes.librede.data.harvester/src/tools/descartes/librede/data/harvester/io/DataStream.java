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
package tools.descartes.librede.data.harvester.io;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Logger;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class DataStream {

	private LineIterator it;

	private Iterator<IndexedFile> fileiterator;

	private Folder folder;

	Logger log = Logger.getLogger(this.getClass());

	public DataStream(Folder folder) {
		this.folder = folder;
		fileiterator = folder.getFiles().iterator();
		if (!openNextFile()) {
			log.warn("Could not open file. There were no files present.");
		}
	}

	public String getNextLine() {
		if (it.hasNext())
			return it.nextLine();
		else if (checkIfFileEnd()) {
			return it.nextLine();
		} else {
			return null;
		}
	}

	private boolean checkIfFileEnd() {
		LineIterator.closeQuietly(it);
		return openNextFile();
	}

	private boolean openNextFile() {
		if (fileiterator.hasNext()) {
			IndexedFile next = fileiterator.next();
			log.info("Opening file " + next.getFile() + " with index " + next.getIndex() + " of a total "
					+ folder.getMaxIndex() + ".");
			try {
				it = FileUtils.lineIterator(next.getFile(), "UTF8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		} else
			return false;
	}
}
