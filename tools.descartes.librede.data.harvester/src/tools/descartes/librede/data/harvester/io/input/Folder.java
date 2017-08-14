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
package tools.descartes.librede.data.harvester.io.input;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class Folder {

	private SortedSet<IndexedFile> files;

	private int maxIndex;

	private File folder;

	private String name;

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * 
	 * @param folder
	 * @param name
	 * @param reversed
	 */
	public Folder(File folder, String name, boolean reversed) {
		super();
		this.folder = folder;
		this.name = name;
		if (reversed) {
			files = new TreeSet<IndexedFile>(new Comparator<IndexedFile>() {
				@Override
				public int compare(IndexedFile o1, IndexedFile o2) {
					// ordering files in the reversed order (500 before 499) in
					// order to improve performance !!!
					if (o1.getIndex() > o2.getIndex())
						return -1;
					else if (o1.getIndex() == o2.getIndex()) {
						if (!o1.equals(o2))
							log.warn("Indexes are equal!");
						return 0;
					} else
						return 1;

				}
			});
		} else {
			files = new TreeSet<IndexedFile>(new Comparator<IndexedFile>() {
				@Override
				public int compare(IndexedFile o1, IndexedFile o2) {
					// ordering in chronological order
					if (o1.getIndex() < o2.getIndex())
						return -1;
					else if (o1.getIndex() == o2.getIndex()) {
						if (!o1.equals(o2))
							log.warn("Indexes are equal!");
						return 0;
					} else
						return 1;
				}
			});
		}
		if (!folder.exists() || !folder.isDirectory()) {
			log.warn("Folder " + folder + " is not a valid folder.");
			return;
		}
		maxIndex = folder.listFiles().length;
		File[] filearray = folder.listFiles();
		Arrays.sort(filearray);
		for (int i = 0; i < filearray.length; i++) {
			files.add(new IndexedFile(filearray[i], i));
		}

	}

	/**
	 * @return the files
	 */
	public SortedSet<IndexedFile> getFiles() {
		return files;
	}

	/**
	 * @param files
	 *            the files to set
	 */
	public void setFiles(SortedSet<IndexedFile> files) {
		this.files = files;
	}

	/**
	 * @return the folder
	 */
	public File getFolder() {
		return folder;
	}

	/**
	 * @param folder
	 *            the folder to set
	 */
	public void setFolder(File folder) {
		this.folder = folder;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the maxIndex
	 */
	public int getMaxIndex() {
		return maxIndex;
	}

	/**
	 * @param maxIndex
	 *            the maxIndex to set
	 */
	public void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}

}
