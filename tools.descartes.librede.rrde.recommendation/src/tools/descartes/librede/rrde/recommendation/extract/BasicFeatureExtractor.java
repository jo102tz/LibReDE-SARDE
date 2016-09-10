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

import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.correlation.KendallsCorrelation;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.ModelEntity;
import tools.descartes.librede.configuration.Resource;
import tools.descartes.librede.metrics.Aggregation;
import tools.descartes.librede.metrics.Metric;
import tools.descartes.librede.metrics.StandardMetrics;
import tools.descartes.librede.repository.IRepositoryCursor;
import tools.descartes.librede.repository.TimeSeries;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.recommendation.TraceFeatures;
import tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl;
import tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl;
import tools.descartes.librede.units.Dimension;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Ratio;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.Unit;
import tools.descartes.librede.units.UnitsFactory;

/**
 * Basic class extracting the {@link FeatureVector}s.
 * 
 * @author JS
 *
 */
public class BasicFeatureExtractor implements IFeatureExtractor {

	/**
	 * The logger used for logging.
	 */
	private static final Logger log = Logger
			.getLogger(BasicFeatureExtractor.class);

	/**
	 * The standard time unit for all features.
	 */
	public Unit<Time> basicTime = Time.MILLISECONDS;

	/**
	 * The standard step size for feature extraction used by the cursors.
	 */
	public Quantity<Time> basicStepSize = UnitsFactory.eINSTANCE
			.createQuantity();
	/**
	 * {@link PearsonsCorrelation} object for correlation calculations.
	 */
	private PearsonsCorrelation pear = new PearsonsCorrelation();

	/**
	 * Standard constructor setting basic values for all constants.
	 */
	public BasicFeatureExtractor() {
		basicStepSize.setUnit(basicTime);
		basicStepSize.setValue(10000);
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
		// extractRegressionAnalyzisInformation(vector, var);
		vector.setUtilizationStatistics(extractStatisticalFeatureVector(var,
				var.getRepo().getWorkload().getResources(),
				StandardMetrics.UTILIZATION, Ratio.PERCENTAGE,
				Aggregation.AVERAGE));
		vector.setResponseTimeStatistics(extractStatisticalFeatureVector(var,
				var.getRepo().getWorkload().getServices(),
				StandardMetrics.RESPONSE_TIME, basicTime, Aggregation.NONE));
		vector.setArrivalTimeStatistics(extractStatisticalFeatureVector(var,
				var.getRepo().getWorkload().getServices(),
				StandardMetrics.RESPONSE_TIME, basicTime, Aggregation.NONE));
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
	 * Creates a new {@link StatisticalFeatures} object filling the features
	 * with statistical data of the given {@link LibredeVariables}.
	 * 
	 * @param var
	 *            The {@link LibredeVariables} to extract from.
	 * @param entities
	 *            The list of {@link ModelEntity}s to aggregate.
	 * @param metric
	 *            The {@link Metric} to be used.
	 * @param unit
	 *            The {@link Unit} matching the given metric.
	 * @param aggregation
	 *            The {@link Aggregation} of the corresponding metric and unit.
	 * @return An object of type {@link StatisticalFeatures} filled with all
	 *         accessible data.
	 */
	protected <D extends Dimension> StatisticalFeatures extractStatisticalFeatureVector(
			LibredeVariables var, EList<? extends ModelEntity> entities,
			Metric<D> metric, Unit<D> unit, Aggregation aggregation) {
		DescriptiveStatistics stat = new DescriptiveStatistics();
		// collect information for all entities
		double[][] table = new double[entities.size()][];
		int i = 0;
		for (ModelEntity res : entities) {
			TimeSeries series = var.getRepo().select(metric, unit, res,
					aggregation);
			// time series should only contain one dimension
			if (series.getData().columns() > 1) {
				log.warn("The time series " + series
						+ " has more than one column. ");
			} else if (series.getData().columns() == 0 || series.isEmpty()) {
				log.warn("The time series " + series + " is empty.");
			}
			double[] data = series.getData().toArray1D();
			table[i] = data;

			// add to stat
			for (int j = 0; j < data.length; j++) {
				stat.addValue(data[j]);
			}
			i++;
		}

		// collect statistical features
		StatisticalFeatures vector = new StatisticalFeaturesImpl();
		vector.setN(stat.getN());
		vector.setGeometricMean(stat.getGeometricMean());
		vector.setArithmeticMean(stat.getMean());
		vector.setStandardDeviation(stat.getStandardDeviation());
		vector.setQuadraticMean(stat.getQuadraticMean());
		vector.setMaximum(stat.getMax());
		vector.setMinimum(stat.getMin());
		vector.setKurtosis(stat.getKurtosis());
		vector.setSkewness(stat.getSkewness());
		vector.setTenthpercentile(stat.getPercentile(10));
		vector.setNinetiethpercentile(stat.getPercentile(90));
		if (table.length > 1) {
			if (aggregation.equals(Aggregation.NONE)) {
				// if aggregation is NONE we have to deal with mismatched
				// dimensions
				table = cleanDimensions(table);
			}
			vector.setPearsonCorrelationMatrixNorm(pear
					.computeCorrelationMatrix(table).getNorm());
			vector.setCovarianceMatrixNorm(new Covariance(table)
					.getCovarianceMatrix().getNorm());
		} else {
			// if no inter-correlation is available
			vector.setPearsonCorrelationMatrixNorm(0);
			vector.setCovarianceMatrixNorm(0);
		}

		// TODO autocorrelation

		return vector;
	}

	/**
	 * Equalizes the dimensions of the table
	 * 
	 * @param table
	 *            The table to equalize
	 * @return the table with filled zeros
	 */
	private double[][] cleanDimensions(double[][] table) {
		int maxlength = Integer.MIN_VALUE;
		for (int i = 0; i < table.length; i++) {
			maxlength = Math.max(maxlength, table[i].length);
		}
		double[][] newtable = new double[table.length][maxlength];
		for (int i = 0; i < newtable.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				newtable[i][j] = table[i][j];
			}
		}
		return newtable;
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
		// create regression instance
		OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
		// fill data
		IRepositoryCursor cursor = var.getRepo().getCursor(
				var.getRepo().getCurrentTime(), basicStepSize);
		// TODO keinen plan

		// export Rsquared and calculate VIF
		double rsquared = regression.calculateRSquared();
		double vif = (1.0) / (1.0 - rsquared);
		vector.setVarianceInflationFactor(vif);
	}

}
