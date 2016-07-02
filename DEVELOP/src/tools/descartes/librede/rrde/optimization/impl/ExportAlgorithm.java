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
package tools.descartes.librede.rrde.optimization.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import tools.descartes.librede.rrde.optimization.AbstractConfigurationOptimizer;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;

/**
 * Algorithm that simply tries out every combination and prints the result to a
 * file in order for further analyzes as well as verification.
 * 
 * @author JS
 *
 */
public class ExportAlgorithm extends AbstractConfigurationOptimizer {

	/**
	 * The log used for logging.
	 */
	private static final Logger log = Logger.getLogger(ExportAlgorithm.class);

	/**
	 * The settings used by this algorithm
	 */
	private DataExportSpecifier settings;

	/**
	 * The character to differentiate between to elements in the file
	 */
	private static final String BREAK = ";";

	/**
	 * The character to skip to the next line
	 */
	private static final String BREAKLINE = System
			.getProperty("line.separator");

	/**
	 * @return the settings
	 */
	public DataExportSpecifier settings() {
		return settings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizer#
	 * getSimpleName()
	 */
	@Override
	public String getSimpleName() {
		return this.getClass().getSimpleName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizer#
	 * isSpecifierSupported(tools.descartes.librede.rrde.optimization.
	 * IConfigurationOptimizationAlgorithmSpecifier)
	 */
	@Override
	public boolean isSpecifierSupported(
			IConfigurationOptimizationAlgorithmSpecifier specifier) {
		if (specifier == null)
			return false;
		if (specifier instanceof DataExportSpecifier) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.optimization.AbstractConfigurationOptimizer
	 * #getLog()
	 */
	@Override
	protected Logger getLog() {
		return log;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.optimization.AbstractConfigurationOptimizer
	 * #executeAlgorithm()
	 */
	@Override
	public void executeAlgorithm() {
		settings = (DataExportSpecifier) getAlgorithm();
		if (settings().isMultidimensional()
				&& settings().isSplitConfigurations()) {
			getLog().error(
					"It is not possible to export multiple parameters and with configurations values. Only choose one of the options.");
		}
		if (!settings.isMultidimensional()) {
			getLog().info("Separate outputs for each parameter.");
			for (IOptimizableParameter param : getSettings()
					.getParametersToOptimize()) {
				getLog().info(
						"Now exporting "
								+ param.toString()
								+ " of approach "
								+ getSpecification().getApproaches().get(0)
										.getType());
				exportSingleParameter(param);

			}
		} else {
			getLog().info(
					"Exporting all parameters of "
							+ getSpecification().getApproaches().get(0)
									.getType());
			exportAllParameters(getSettings().getParametersToOptimize());
		}
		getLog().info(
				"Done exporting to " + settings().getOutputDirectory() + " .");
	}

	/**
	 * Constructs a matrix of the parameters. Currently just supports 2
	 * parameters at a time
	 * 
	 * @param parametersToOptimize
	 *            the parameters to export
	 */
	private void exportAllParameters(
			EList<IOptimizableParameter> parametersToOptimize) {
		if (parametersToOptimize.size() != 2) {
			getLog().error(
					"Output with other than two parameters is not supported yet.");
			return;
		} else if (parametersToOptimize.size() <= 0) {
			getLog().warn("No parameters specified.");
			return;
		}
		BufferedWriter s = initFile(getSimpleApproachName() + "_allParams.csv");
		if (s == null) {
			return;
		}

		// write headerline
		writeString(s, parametersToOptimize.get(1).getClass().getSimpleName());
		for (double j = parametersToOptimize.get(1).getLowerBound(); j <= parametersToOptimize
				.get(1).getUpperBound(); j++) {
			writeDouble(s, j);
		}
		newLine(s);

		// write matrix
		for (double i = parametersToOptimize.get(0).getLowerBound(); i <= parametersToOptimize
				.get(0).getUpperBound(); i++) {
			writeDouble(s, i);
			setTargetValue(parametersToOptimize.get(0), i);
			for (double j = parametersToOptimize.get(1).getLowerBound(); j <= parametersToOptimize
					.get(1).getUpperBound(); j++) {
				setTargetValue(parametersToOptimize.get(1), j);
				runIteration();
				writeDouble(s, getLastError());
			}
			newLine(s);
		}
		writeString(s, parametersToOptimize.get(0).getClass().getSimpleName());
		try {
			s.close();
		} catch (IOException e) {
			getLog().error("Closing resource caused an error.", e);
		}
	}

	/**
	 * Exports a single parameter with all its configuration file results, if
	 * specified.
	 * 
	 * @param param
	 *            the parameter to export
	 */
	private void exportSingleParameter(IOptimizableParameter param) {
		// TODO Auto-generated method stub
	}

	/**
	 * Writes a string in the output file
	 * 
	 * @param s
	 *            the writer
	 * @param simpleName
	 *            the string to write
	 */
	private void writeString(BufferedWriter s, String simpleName) {
		if (s == null)
			return;
		try {
			s.write(simpleName);
			s.write(BREAK);
		} catch (IOException e) {
			getLog().error("Writing caused an error.", e);
		}
	}

	/**
	 * Writes a double in the output file
	 * 
	 * @param s
	 *            the writer
	 * @param double the double to write
	 */
	private void writeDouble(BufferedWriter s, double d) {
		writeString(s, Double.toString(d));
	}

	/**
	 * Writes a double in the output file
	 * 
	 * @param s
	 *            the writer
	 * @param double the double to write
	 */
	private void newLine(BufferedWriter s) {
		if (s == null)
			return;
		try {
			s.write(BREAKLINE);
		} catch (IOException e) {
			getLog().error("Writing caused an error.", e);
		}
	}

	/**
	 * Creates and inits a file
	 * 
	 * @param suffix
	 *            the name of the file
	 * @return The write to use later
	 */
	private BufferedWriter initFile(String suffix) {
		URI uri = null;
		try {
			uri = URI
					.createFileURI(new File(settings().getOutputDirectory())
							.toString() + File.separator + suffix);
		} catch (Exception e) {
			getLog().error(
					"The given direction was not found."
							+ settings().getOutputDirectory() + File.separator
							+ suffix);
			return null;
		}

		if (uri == null) {
			getLog().error(
					"The given direction was not found."
							+ settings().getOutputDirectory() + File.separator
							+ suffix);
			return null;
		}
		try {
			File f = new File(uri.path());
			if(!f.exists()){
				f.createNewFile();
			}
			return new BufferedWriter(new FileWriter(f));
		} catch (IOException e) {
			getLog().error("There was an error when opening the file", e);
		}
		return null;
	}
}
