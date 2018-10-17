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
package tools.descartes.librede.rrde.eval;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.log4j.Logger;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class TestSetCreator {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestSetCreator.class);

	/**
	 * Randomly selects validation sets and puts them in the respective folders.
	 * 
	 * @throws IOException
	 *             If something fails during execution and movements of files.
	 */
	public static void shuffle(String mainfolder, String trainingfolder, String validationfolder, double split,
			int substract) throws IOException {
		log.info("Reshuffeling training and validation data...");
		log.trace("Cleaning up training and validation folders...");
		cleanup(new File(trainingfolder));
		cleanup(new File(validationfolder));
		log.trace("Done cleanup.");

		ArrayList<File> directories = new ArrayList<>();
		getSingleTestCases(new File(mainfolder), directories);
		Collections.shuffle(directories);
		split(directories, new File(trainingfolder), new File(validationfolder), split, substract);

		log.info("Reshuffeling done!");
		log.info("Training set size: " + (directories.size() - split * directories.size()));
		log.info("Validation set size: " + split * directories.size());
	}

	private static void split(List<File> directories, File trainingfolder, File validationfolder, double split,
			int substract) throws IOException {
		Iterator<File> it = directories.iterator();
		for (int i = 0; i < directories.size() * split; i++) {
			// move first part of directories to validation folder until the
			// required split is met
			moveTestcase(it.next(), validationfolder, substract);
		}

		while (it.hasNext()) {
			// move rest to trainingsfolder
			moveTestcase(it.next(), trainingfolder, substract);
		}

	}

	/**
	 * Moves the directory and all its files to the given target folder. (Moves
	 * the testcase.)
	 * 
	 * @param testcase
	 *            The testcase to move.
	 * @param target
	 *            The target to move it into.
	 * @param substract
	 *            The number of letters ignored
	 * @throws IOException
	 *             If something fails along the way
	 */
	private static void moveTestcase(File testcase, File target, int subtract) throws IOException {
		String foldername = testcase.getPath().replaceAll(Matcher.quoteReplacement(File.separator), "-");
		File directory = new File(target.getAbsolutePath() + File.separator + foldername.substring(subtract + 1));
		if (directory.exists() || !directory.mkdir()) {
			throw new IOException("Creating directory " + directory.toString() + " failed.");
		}
		File[] files = testcase.listFiles();
		if (files != null)
			for (File f : files)
				Files.copy(f.toPath(), new File(directory.toString() + File.separator + f.getName()).toPath());
	}

	/**
	 * Finds all level one directories.
	 * 
	 * @return
	 */
	private static void getSingleTestCases(File main, List<File> directories) {
		File[] files = main.listFiles();
		if (!main.exists())
			return;
		if (!main.isDirectory() || files == null)
			return;
		boolean testcase = true;
		for (File file : files) {
			if (file.exists() && file.isDirectory()) {
				getSingleTestCases(file, directories);
				testcase = false;
			}
			if (!file.exists()) {
				testcase = false;
			}
		}
		if (files.length > 0 && testcase) {
			// this makes main a testcase
			directories.add(main);
		}
	}

	/**
	 * Cleans the folder up, i.e. deletes all files in the folder.
	 * 
	 * @param directory
	 *            The folder to clean
	 */
	public static void cleanup(File directory) throws IOException {
		if (!directory.exists()) {
			String message = directory + " does not exist";
			throw new IllegalArgumentException(message);
		}

		if (!directory.isDirectory()) {
			String message = directory + " is not a directory";
			throw new IllegalArgumentException(message);
		}

		File[] files = directory.listFiles();
		if (files == null) { // null if security restricted
			throw new IOException("Failed to list contents of " + directory);
		}

		IOException exception = null;
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			try {
				forceDelete(file);
			} catch (IOException ioe) {
				exception = ioe;
			}
		}
		if (null != exception) {
			throw exception;
		}
	}

	/**
	 * Deletes the file or directory.
	 * 
	 * @param file
	 *            The file to delete.
	 */
	private static void forceDelete(File file) throws IOException {
		if (file.isDirectory()) {
			cleanup(file);
			if (!file.delete())
				throw new IOException("Unable to delete directory " + file + ".");
		} else {
			boolean filePresent = file.exists();
			if (!file.delete()) {
				if (!filePresent) {
					throw new FileNotFoundException("File does not exist: " + file);
				}
				String message = "Unable to delete file: " + file;
				throw new IOException(message);
			}
		}
	}

}
