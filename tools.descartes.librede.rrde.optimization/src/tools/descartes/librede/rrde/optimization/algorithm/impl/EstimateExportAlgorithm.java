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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.ModelEntity;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.GenericParameter;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.validation.ResponseTimeValidator;

/**
 * Algorithm for exporting the actual estimate
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class EstimateExportAlgorithm extends ExportAlgorithm {

	/**
	 * The log used for logging.
	 */
	private static final Logger log = Logger
			.getLogger(EstimateExportAlgorithm.class);

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

	@Override
	protected void exportAllParameters(
			EList<IOptimizableParameter> parametersToOptimize) {
		throw new UnsupportedOperationException("The "
				+ this.getClass().getSimpleName()
				+ " does not support mulit-parameter resolution.");
	}

	/**
	 * Exports a single parameter with all its configuration file results, if
	 * specified.
	 * 
	 * @param param
	 *            the parameter to export
	 */
	@SuppressWarnings("unchecked")
	protected void exportSingleParameter(IOptimizableParameter param) {
		runIteration();
		Map<LibredeConfiguration, LibredeResults> results = getLastResults();
		Class<? extends IEstimationApproach> approach = null;
		try {
			approach = (Class<? extends IEstimationApproach>) Class
					.forName(getSpecification().getApproaches().get(0)
							.getType());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String paramname = param.getClass().getSimpleName();
		if (param instanceof GenericParameter) {
			paramname = ((GenericParameter) param).getParameter().getName();
		}

		List<FileExporter> writers = new ArrayList<FileExporter>();
		for (ModelEntity res : results.get(getConfs().iterator().next())
				.getValidatedEntities().get(ResponseTimeValidator.class)) {
			writers.add(new FileExporter(((DataExportSpecifier) getAlgorithm())
					.getOutputDirectory(), getSimpleApproachName() + "_"
					+ paramname + "_" + res.getName() + "_estimates.csv"));
		}

		if (!settings().isSplitConfigurations()) {
			for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings()
					.getStepSize()) {
				setTargetValue(param, i);
				runIteration();
				int j = 0;
				for (FileExporter s : writers) {
					s.writeDouble(i);
					// aggregate over all configurations for average
					DescriptiveStatistics stat = new DescriptiveStatistics();
					for (LibredeConfiguration conf : getConfs()) {
						stat.addValue(getLastResults().get(conf)
								.getApproachResults(approach)
								.getMeanEstimates().get(j, 0));
						j++;
					}
					s.writeDouble(stat.getMean());
					s.newLine();
				}
			}
		} else {
			Set<LibredeConfiguration> original = new HashSet<LibredeConfiguration>(
					getConfs());
			// write header
			for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings()
					.getStepSize()) {
				for (FileExporter s : writers) {
					s.writeDouble(i);
				}
			}
			for (FileExporter s : writers) {
				s.newLine();
			}
			// split for configurations
			for (LibredeConfiguration conf : original) {
				getConfs().clear();
				getConfs().add(conf);
				for (double i = param.getLowerBound(); i <= param
						.getUpperBound(); i += settings().getStepSize()) {
					setTargetValue(param, i);
					runIteration();
					int j = 0;
					for (FileExporter s : writers) {
						s.writeDouble(getLastResults().get(conf)
								.getApproachResults(approach)
								.getMeanEstimates().get(j, 0));
						j++;
					}
				}
				for (FileExporter s : writers) {
					s.newLine();
				}
			}
			getConfs().clear();
			getConfs().addAll(original);
		}
		// set to default again
		setTargetValue(param, param.getStartValue());
		for (FileExporter s : writers) {
			s.close();
		}

	}
}
