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
package tools.descartes.librede.rrde.recommendation.extract;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.Resource;
import tools.descartes.librede.linalg.Matrix;
import tools.descartes.librede.metrics.Aggregation;
import tools.descartes.librede.metrics.StandardMetrics;
import tools.descartes.librede.repository.TimeSeries;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl;
import tools.descartes.librede.units.Ratio;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.Unit;

/**
 * Basic class extracting the {@link FeatureVector}s.
 * 
 * @author JS
 *
 */
public class BasicFeatureExtractor implements IFeatureExtractor {

	public Unit<? extends Time> basicTime;

	public BasicFeatureExtractor(Unit<? extends Time> basicUnit) {

		this.basicTime = basicUnit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor
	 * #extractFeatures
	 * (tools.descartes.librede.configuration.LibredeConfiguration)
	 */
	@Override
	public FeatureVector extractFeatures(LibredeConfiguration conf) {
		// init variables
		LibredeVariables var = new LibredeVariables(conf);
		Librede.initRepo(var);
		FeatureVector vector = new FeatureVectorImpl();
		extractWorkloadDescription(vector, var);
		extractUtilizationInformation(vector, var);
		extractRegressionAnalyzisInformation(vector, var);
		return vector;
	}

	/**
	 * Extracts and adds general information about the workload description into
	 * the given {@link FeatureVector}.
	 * 
	 * @param vector
	 *            The vector to modify
	 * @param var
	 *            The {@link LibredeVariables} to analyze
	 */
	protected void extractWorkloadDescription(FeatureVector vector,
			LibredeVariables var) {
		vector.setNumberOfRessources(var.getConf().getWorkloadDescription()
				.getResources().size());
		vector.setNumberOfWorkloadClasses(var.getConf()
				.getWorkloadDescription().getServices().size());
	}

	/**
	 * Extracts and adds the information about utilization into the given
	 * {@link FeatureVector}.
	 * 
	 * @param vector
	 *            The vector to modify
	 * @param var
	 *            The {@link LibredeVariables} to analyze
	 */
	protected void extractUtilizationInformation(FeatureVector vector,
			LibredeVariables var) {
		DescriptiveStatistics stat = new DescriptiveStatistics();
		// collect information for all resources
		for (Resource res : var.getRepo().getWorkload().getResources()) {
			TimeSeries series = var.getRepo().select(
					StandardMetrics.UTILIZATION, Ratio.PERCENTAGE, res,
					Aggregation.NONE);
			Matrix data = series.getData();
			stat.addValue(data.get(0, 0));
		}
		// TODO
	}

	/**
	 * Extracts and adds the information using regression analysis into the
	 * given {@link FeatureVector}.
	 * 
	 * @param vector
	 *            The vector to modify
	 * @param var
	 *            The {@link LibredeVariables} to analyze
	 */
	protected void extractRegressionAnalyzisInformation(FeatureVector vector,
			LibredeVariables var) {
		// TODO Auto-generated method stub

	}

}
