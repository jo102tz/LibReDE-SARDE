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
package tools.descartes.librede.rrde.optimization.algorithm.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.GenericParameter;
import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.algorithm.AbstractConfigurationOptimizer;

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
	 * The Decimal format to format the output values.
	 */
	private DecimalFormat df;

	/**
	 * This value will be used to replace MAX_DOUBLE values.
	 */
	private static final double MAX_DOUBLE_REPLACE = 10;

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
		// define output format
		df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
		df.setMaximumFractionDigits(8);

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
				.get(1).getUpperBound(); j += settings().getStepSize()) {
			writeDouble(s, j);
		}
		newLine(s);

		// write matrix
		for (double i = parametersToOptimize.get(0).getLowerBound(); i <= parametersToOptimize
				.get(0).getUpperBound(); i += settings().getStepSize()) {
			writeDouble(s, i);
			setTargetValue(parametersToOptimize.get(0), i);
			for (double j = parametersToOptimize.get(1).getLowerBound(); j <= parametersToOptimize
					.get(1).getUpperBound(); j += settings().getStepSize()) {
				setTargetValue(parametersToOptimize.get(1), j);
				runIteration();
				writeError(s, getLastError());
			}
			newLine(s);
		}
		writeString(s, parametersToOptimize.get(0).getClass().getSimpleName());

		// set to default again
		setTargetValue(parametersToOptimize.get(0), parametersToOptimize.get(0)
				.getStartValue());
		setTargetValue(parametersToOptimize.get(1), parametersToOptimize.get(1)
				.getStartValue());
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
		String paramname = param.getClass().getSimpleName();
		if (param instanceof GenericParameter) {
			paramname = ((GenericParameter) param).getParameter().getName();
		}
		BufferedWriter s = initFile(getSimpleApproachName() + "_" + paramname
				+ ".csv");
		if (!settings().isSplitConfigurations()) {
			for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings()
					.getStepSize()) {
				writeDouble(s, i);
				setTargetValue(param, i);
				adaptOtherValues(param, i);
				runIteration();
				writeError(s, getLastError());
				newLine(s);
			}
		} else {
			Set<LibredeConfiguration> original = new HashSet<LibredeConfiguration>(
					getConfs());
			// write header
			for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings()
					.getStepSize()) {
				writeDouble(s, i);
			}
			newLine(s);
			// split for configurations
			for (LibredeConfiguration conf : original) {
				getConfs().clear();
				getConfs().add(conf);
				for (double i = param.getLowerBound(); i <= param
						.getUpperBound(); i += settings().getStepSize()) {
					setTargetValue(param, i);
					adaptOtherValues(param, i);
					runIteration();
					writeError(s, getLastError());
				}
				newLine(s);
			}
			getConfs().clear();
			getConfs().addAll(original);
		}
		// set to default again
		setTargetValue(param, param.getStartValue());
		adaptOtherValues(param, param.getStartValue());
		try {
			s.close();
		} catch (IOException e) {
			getLog().error("Closing resource caused an error.", e);
		}
	}

	/**
	 * This method can be overwritten by subclasses (such as
	 * {@link StepWindowExportAlgorithm}) to react to changes in the target
	 * value of the given parameter
	 * 
	 * @param param
	 *            The parameter that has been changed
	 * @param i
	 *            The new value of the parameter
	 */
	protected void adaptOtherValues(IOptimizableParameter param, double i) {
		// do nothing, default is empty
	}

	/**
	 * Writes an error value in the output (as opposed to an index) and
	 * therefore checks if the error is of somewhat of a malformed structure. If
	 * so, an error message is logged to the console.
	 * 
	 * @param s
	 *            the writer
	 * @param double the error to write
	 */
	private void writeError(BufferedWriter s, double d) {
		if (d == Double.MAX_VALUE) {
			getLog().warn("Error is Double.MAX_VALUE.");
			writeDouble(s, MAX_DOUBLE_REPLACE);
			return;
		}
		if (d < 0) {
			getLog().warn("Error is negative.");
			writeDouble(s, 0);
			return;
		}
		writeDouble(s, d);
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
		writeString(s, df.format(d));
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
			s.flush();
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
	protected BufferedWriter initFile(String suffix) {
		URI uri = null;
		try {
			uri = URI.createFileURI(new File(settings().getOutputDirectory())
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
			if (!f.exists()) {
				f.createNewFile();
			}
			return new BufferedWriter(new FileWriter(f));
		} catch (IOException e) {
			getLog().error("There was an error when opening the file", e);
		}
		return null;
	}
}
