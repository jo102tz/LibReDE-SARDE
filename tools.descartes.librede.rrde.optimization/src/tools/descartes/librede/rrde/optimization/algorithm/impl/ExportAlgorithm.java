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
import tools.descartes.librede.rrde.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.GenericParameter;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.StepSizeRelWindow;
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
	private final Logger log = Logger.getLogger(ExportAlgorithm.class);

	/**
	 * The settings used by this algorithm
	 */
	private DataExportSpecifier settings;

	public ExportAlgorithm() {
		super();
	}

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
			ConfigurationOptimizationAlgorithmSpecifier specifier) {
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
		return this.log;
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
	 * parameters at a time. Does not support automatic selection of the best
	 * value
	 * 
	 * @param parametersToOptimize
	 *            the parameters to export
	 */
	protected void exportAllParameters(
			EList<IOptimizableParameter> parametersToOptimize) {
		if (parametersToOptimize.size() != 2) {
			getLog().error(
					"Output with other than two parameters is not supported yet.");
			return;
		} else if (parametersToOptimize.size() <= 0) {
			getLog().warn("No parameters specified.");
			return;
		}
		FileExporter s = new FileExporter(settings.getOutputDirectory(), getSimpleApproachName()
				+ "_allParams.csv");

		// write headerline
		s.writeString(parametersToOptimize.get(1).getClass().getSimpleName());
		for (double j = parametersToOptimize.get(1).getLowerBound(); j <= parametersToOptimize
				.get(1).getUpperBound(); j += settings().getStepSize()) {
			s.writeDouble(j);
		}
		s.newLine();

		// write matrix
		for (double i = parametersToOptimize.get(0).getLowerBound(); i <= parametersToOptimize
				.get(0).getUpperBound(); i += settings().getStepSize()) {
			s.writeDouble(i);
			setTargetValue(parametersToOptimize.get(0), i);
			for (double j = parametersToOptimize.get(1).getLowerBound(); j <= parametersToOptimize
					.get(1).getUpperBound(); j += settings().getStepSize()) {
				setTargetValue(parametersToOptimize.get(1), j);
				runIteration();
				s.writeError(getLastError());
			}
			s.newLine();
		}
		s.writeString(parametersToOptimize.get(0).getClass().getSimpleName());

		// set to default again
		setTargetValue(parametersToOptimize.get(0), parametersToOptimize.get(0)
				.getStartValue());
		setTargetValue(parametersToOptimize.get(1), parametersToOptimize.get(1)
				.getStartValue());
		
		s.close();
	}

	/**
	 * Exports a single parameter with all its configuration file results, if
	 * specified. Sets the best value of each parameter at the end if required.
	 * 
	 * @param param
	 *            the parameter to export
	 */
	protected void exportSingleParameter(IOptimizableParameter param) {
		String paramname = param.getClass().getSimpleName();
		if (param instanceof GenericParameter) {
			paramname = ((GenericParameter) param).getParameter().getName();
		}
		if (param instanceof StepSizeRelWindow) {
			paramname = "StepSize_relative"
					+ ((StepSizeRelWindow) param).getProductMaxValue();
		}
		FileExporter s = new FileExporter(settings.getOutputDirectory(), getSimpleApproachName() + "_"
				+ paramname + ".csv");
		if (!settings().isSplitConfigurations()) {
			for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings()
					.getStepSize()) {
				s.writeDouble(i);
				setTargetValue(param, i);
				runIteration();
				s.writeError(getLastError());
				s.newLine();
			}
		} else {
			Set<LibredeConfiguration> original = new HashSet<LibredeConfiguration>(
					getConfs());
			// write header
			for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings()
					.getStepSize()) {
				s.writeDouble(i);
			}
			s.newLine();
			// split for configurations
			for (LibredeConfiguration conf : original) {
				getConfs().clear();
				getConfs().add(conf);
				for (double i = param.getLowerBound(); i <= param
						.getUpperBound(); i += settings().getStepSize()) {
					setTargetValue(param, i);
					runIteration();
					s.writeError(getLastError());
				}
				s.newLine();
			}
			getConfs().clear();
			getConfs().addAll(original);

		}

		// set to default again
		setTargetValue(param, param.getStartValue());

		s.close();
	}

	public class FileExporter {
		/**
		 * The Decimal format to format the output values.
		 */
		private DecimalFormat df;

		/**
		 * This value will be used to replace MAX_DOUBLE values.
		 */
		private static final String MAX_DOUBLE_REPLACE = "NA";

		/**
		 * This value will be used to replace NaN values.
		 */
		private static final String NaN_REPLACE = "NA";

		/**
		 * The character to differentiate between to elements in the file.
		 */
		private static final String BREAK = ";";

		/**
		 * The character to skip to the next line.
		 */
		private String BREAKLINE;

		/**
		 * The writer used as file.
		 */
		private BufferedWriter writer;

		/**
		 * Creates the instance.
		 * 
		 * @param suffix
		 *            the name of the file.
		 */
		public FileExporter(String outputdir, String suffix) {
			// define output format
			df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
			df.setMaximumFractionDigits(8);
			df.setGroupingUsed(false);
			writer = initFile(outputdir, suffix);
			BREAKLINE = System.getProperty("line.separator");
		}

		/**
		 * Closes the attached File.
		 */
		public void close() {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				getLog().error("Closing resource caused an error.", e);
			}
		}

		/**
		 * Creates and inits a file
		 * 
		 * @param suffix
		 *            the name of the file
		 * @return The write to use later
		 */
		protected BufferedWriter initFile(String outputdir, String suffix) {
			URI uri = null;
			try {
				uri = URI.createFileURI(new File(outputdir).toString()
						+ File.separator
						+ suffix);
			} catch (Exception e) {
				getLog().error(
						"The given direction was not found."
								+ outputdir
								+ File.separator + suffix);
				return null;
			}

			if (uri == null) {
				getLog().error(
						"The given direction was not found."
								+ outputdir
								+ File.separator + suffix);
				return null;
			}
			try {
				File f = new File(uri.path());
				if (!f.exists()) {
					f.getParentFile().mkdirs();
					f.createNewFile();
				}
				return new BufferedWriter(new FileWriter(f));
			} catch (IOException e) {
				getLog().error("There was an error when opening the file", e);
			}
			return null;
		}

		/**
		 * Writes an error value in the output (as opposed to an index) and
		 * therefore checks if the error is of somewhat of a malformed
		 * structure. If so, an error message is logged to the console.
		 * 
		 * @param double the error to write
		 */
		protected void writeError(double d) {
			if (d == Double.MAX_VALUE) {
				getLog().warn("Error is Double.MAX_VALUE.");
				writeString(MAX_DOUBLE_REPLACE);
				return;
			}
			if (Double.isNaN(d)) {
				getLog().warn("Error is NaN.");
				writeString(NaN_REPLACE);
				return;
			}
			if (d < 0) {
				getLog().warn("Error is negative.");
				writeDouble(0);
				return;
			}
			writeDouble(d);
		}

		/**
		 * Writes a string in the output file
		 * 
		 * @param simpleName
		 *            the string to write
		 */
		protected void writeString(String simpleName) {
			if (writer == null)
				return;
			try {
				writer.write(simpleName);
				writer.write(BREAK);
			} catch (IOException e) {
				getLog().error("Writing caused an error.", e);
			}
		}

		/**
		 * Writes a double in the output file
		 * 
		 * @param double the double to write
		 */
		protected void writeDouble(double d) {
			writeString(df.format(d));
		}

		/**
		 * Writes a new line
		 */
		protected void newLine() {
			if (writer == null)
				return;
			try {
				writer.write(BREAKLINE);
				writer.flush();
			} catch (IOException e) {
				getLog().error("Writing caused an error.", e);
			}
		}
	}
}
