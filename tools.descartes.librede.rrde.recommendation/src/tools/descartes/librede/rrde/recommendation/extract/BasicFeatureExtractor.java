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

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.inference.TestUtils;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.log4j.Logger;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.ModelEntity;
import tools.descartes.librede.metrics.Aggregation;
import tools.descartes.librede.metrics.Metric;
import tools.descartes.librede.metrics.StandardMetrics;
import tools.descartes.librede.repository.IRepositoryCursor;
import tools.descartes.librede.repository.TimeSeries;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl;
import tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl;
import tools.descartes.librede.units.Dimension;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Ratio;
import tools.descartes.librede.units.RequestRate;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.Unit;

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
	 * The maximum VIF to be exported
	 */
	private static final double MAX_VIF = 1000;

	/**
	 * The maximum lag to be considered
	 */
	private static final int MAX_LAG = 10;

	/**
	 * The standard time unit for all features.
	 */
	public Unit<Time> standardTimeUnit;

	/**
	 * The standard step size for feature extraction used by the cursors.
	 */
	public Quantity<Time> basicStepSize;

	/**
	 * The standard rate for all exports
	 */
	public Unit<RequestRate> rateUnit;

	/**
	 * {@link PearsonsCorrelation} object for correlation calculations.
	 */
	private PearsonsCorrelation pear = new PearsonsCorrelation();

	/**
	 * {@link Covariance} object for covariance calculations.
	 */
	private Covariance cov = new Covariance();

	/**
	 * The {@link FeatureExtractorSpecifier} containing paramter values for
	 * extraction.
	 */
	private FeatureExtractorSpecifier spec;

	/**
	 * Standard constructor setting basic values for all constants.
	 */
	@SuppressWarnings("unchecked")
	public BasicFeatureExtractor(FeatureExtractorSpecifier specifier) {
		this.spec = specifier;
		if (spec == null || spec.getRateUnit() == null
				|| spec.getAggregation() == null) {
			log.warn("Specifier is null. Using default values...");
			standardTimeUnit = Time.MILLISECONDS;
		} else {
			try {
				standardTimeUnit = spec.getAggregation().getUnit();
			} catch (Exception e) {
				log.warn("Time unit could not be cast. Using default value...");
				standardTimeUnit = Time.MILLISECONDS;
			}
			try {
				rateUnit = (Unit<RequestRate>) spec.getRateUnit();
			} catch (Exception e) {
				log.warn("Request rate unit could not be cast. Using default value...");
				rateUnit = RequestRate.REQ_PER_MINUTE;
			}
		}
		if (spec.getAggregation().getValue() <= 0) {
			log.warn("Aggreation interval could not be read. Using default value...");
			spec.getAggregation().setValue(60000);
		}
		basicStepSize = spec.getAggregation();
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
		extractRegressionAnalyzisInformation(vector, var);

		for (ModelEntity res : var.getRepo().getWorkload().getResources()) {
			vector.getUtilizationStatistics().add(
					extractStatisticalFeatureVector(
							var.getCursor(var.getConf().getEstimation()
									.getApproaches().get(0).getType()), res,
							StandardMetrics.UTILIZATION, Ratio.PERCENTAGE,
							Aggregation.AVERAGE));
		}

		for (ModelEntity ser : var.getRepo().getWorkload().getServices()) {
			vector.getResponseTimeStatistics().add(
					extractStatisticalFeatureVector(
							var.getCursor(var.getConf().getEstimation()
									.getApproaches().get(0).getType()), ser,
							StandardMetrics.RESPONSE_TIME, standardTimeUnit,
							Aggregation.NONE));
			vector.getArrivalRateStatistics().add(
					extractStatisticalFeatureVector(
							var.getCursor(var.getConf().getEstimation()
									.getApproaches().get(0).getType()), ser,
							StandardMetrics.ARRIVAL_RATE, rateUnit,
							Aggregation.AVERAGE));
		}

		// extract correlation and covariance information
		extractCorrelationAndCovarianceInformation(vector, var);

		return vector;
	}

	/**
	 * Extracts and adds correlation and covariane about the workload into the
	 * given {@link FeatureVector}.
	 * 
	 * @param vector
	 *            The vector to modify
	 * @param var
	 *            The {@link LibredeVariables} to analyze
	 */
	private void extractCorrelationAndCovarianceInformation(
			FeatureVector vector, LibredeVariables var) {

		double[][][] data = extractDoubleArray(var);

		// inter entity correlation
		if (var.getRepo().getWorkload().getResources().size() > 1) {
			// only if there are more than one resources, else zero
			vector.setIntraUtilizationCorrelation(pear
					.computeCorrelationMatrix(data[0]).getNorm());
			vector.setIntraUtilizationCovariance(new Covariance(data[0])
					.getCovarianceMatrix().getNorm());
		}
		if (var.getRepo().getWorkload().getServices().size() > 1) {
			// only if there are more than one service, else zero
			vector.setIntraResponseTimeCorrelation(pear
					.computeCorrelationMatrix(data[1]).getNorm());
			vector.setIntraResponseTimeCovariance(new Covariance(data[1])
					.getCovarianceMatrix().getNorm());
			vector.setIntraArrivalRateCorrelation(pear
					.computeCorrelationMatrix(data[2]).getNorm());
			vector.setIntraArrivalRateCovariance(new Covariance(data[2])
					.getCovarianceMatrix().getNorm());
		}

		// combine arrays
		double[][] averaged = new double[data.length][];

		int k = 0;
		for (double[][] entity : data) {
			double[] avg = new double[entity[0].length];
			for (int j = 0; j < avg.length; j++) {
				for (int i = 0; i < entity.length; i++) {
					avg[j] += entity[i][j];
				}
				avg[j] /= ((double) entity.length);
			}

			averaged[k++] = avg;
		}

		vector.setUtilizationResponseCorrelation(pear.correlation(averaged[0],
				averaged[1]));
		vector.setUtilizationArrivalCorrelation(pear.correlation(averaged[0],
				averaged[2]));
		vector.setResponseArrivalCorrelation(pear.correlation(averaged[1],
				averaged[2]));
		vector.setUtilizationArrivalCovariance(cov.covariance(averaged[0],
				averaged[1]));
		vector.setUtilizationResponseCovariance(cov.covariance(averaged[0],
				averaged[2]));
		vector.setResponseArrivalCovariance(cov.covariance(averaged[1],
				averaged[2]));

	}

	/**
	 * Extracts all data as aggregated values into a set of double arrays.
	 * 
	 * @param var
	 *            The variables to extract
	 * @return The double array
	 */
	private double[][][] extractDoubleArray(LibredeVariables var) {

		// create cursor
		IRepositoryCursor cursor = var.getCursor(var.getConf().getEstimation()
				.getApproaches().get(0).getType());
		cursor.reset();
		int maxintervalNumber = 0;
		while (cursor.next()) {
			maxintervalNumber = cursor.getLastInterval();
		}

		// initializes array
		double[][][] data = new double[3][][];
		data[0] = new double[var.getRepo().getWorkload().getResources().size()][maxintervalNumber];
		data[1] = new double[var.getRepo().getWorkload().getServices().size()][maxintervalNumber];
		data[2] = new double[var.getRepo().getWorkload().getServices().size()][maxintervalNumber];

		// extract all information and store it as doubles
		// resources first
		for (int intervalNo = 0; intervalNo < maxintervalNumber; intervalNo++) {
			int line = 0;
			// utilization of resources
			for (ModelEntity res : var.getRepo().getWorkload().getResources()) {
				data[0][line++][intervalNo] = cursor.getAggregatedValue(
						intervalNo, StandardMetrics.UTILIZATION,
						Ratio.PERCENTAGE, res, Aggregation.AVERAGE);
			}

			// of services
			line = 0;
			for (ModelEntity ser : var.getRepo().getWorkload().getServices()) {
				// response times
				data[1][line][intervalNo] = cursor.getAggregatedValue(
						intervalNo, StandardMetrics.RESPONSE_TIME,
						standardTimeUnit, ser, Aggregation.AVERAGE);
				data[2][line++][intervalNo] = cursor.getAggregatedValue(
						intervalNo, StandardMetrics.ARRIVAL_RATE, rateUnit,
						ser, Aggregation.AVERAGE);
			}
		}
		return data;
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
	 * with statistical data of the given {@link IRepositoryCursor}.
	 * 
	 * @param cursor
	 *            The {@link IRepositoryCursor} to extract from.
	 * @param entity
	 *            The {@link ModelEntity} to extract.
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
			IRepositoryCursor cursor, ModelEntity entity, Metric<D> metric,
			Unit<D> unit, Aggregation aggregation) {
		DescriptiveStatistics stat = new DescriptiveStatistics();
		// collect information for all entities
		cursor.reset();
		while (cursor.next()) {
			if (aggregation == Aggregation.NONE) {
				TimeSeries series = (cursor.getValues(cursor.getLastInterval(),
						metric, unit, entity));
				// time series should only contain one dimension
				if (series.getData().columns() > 1) {
					log.warn("The time series " + series
							+ " has more than one column. ");
				} else if (series.getData().columns() == 0 || series.isEmpty()) {
					log.warn("The time series " + series + " is empty.");
				}
				double[] data = series.getData().toArray1D();
				for (int j = 0; j < data.length; j++) {
					stat.addValue(data[j]);
				}
			} else {
				stat.addValue(cursor.getAggregatedValue(
						cursor.getLastInterval(), metric, unit, entity,
						aggregation));
			}
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
		vector.setIsNormalDistributed(TestUtils.kolmogorovSmirnovStatistic(
				new NormalDistribution(), stat.getValues()));

		// TODO effective autocorrelation
		vector.setAutocorrelation(computeAutocorrelation(stat.getValues()));

		return vector;
	}

	/**
	 * Computes the autocorrelation of the given double array.
	 * 
	 * @param values
	 *            The array to check
	 * @return The autocorrelation of the array
	 */
	private double computeAutocorrelation(double[] values) {
		double[] copy = Arrays.copyOf(values, values.length);
		double sumofcorrelations = 0;
		// for all possible lag values
		for (int lag = 0; lag < MAX_LAG; lag++) {
			// cyclic shift copy array one to the left
			double tmp = copy[0];
			for (int i = 1; i < copy.length; i++) {
				copy[i - 1] = copy[i];
			}
			copy[copy.length - 1] = tmp;
			// add correlation value
			sumofcorrelations += pear.correlation(values, copy);
		}
		// return average over all lags
		return sumofcorrelations / MAX_LAG;
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
		if (var.getConf().getWorkloadDescription().getServices().size() < 2) {
			vector.setVarianceInflationFactor(0);
			return;
		}
		// create regression instance
		OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();

		// fill data
		@SuppressWarnings("unchecked")
		ArrayList<Double>[] throughputs = new ArrayList[var.getRepo().getWorkload()
				.getServices().size()];
		for (int i = 0; i < var.getRepo().getWorkload().getServices().size(); i++) {
			throughputs[i] = new ArrayList<>();
		}
		IRepositoryCursor cursor = var.getCursor(var.getConf().getEstimation()
				.getApproaches().get(0).getType());
		while (cursor.next()) {
			for (int i = 0; i < var.getRepo().getWorkload().getServices()
					.size(); i++) {
				throughputs[i].add(cursor.getAggregatedValue(
						cursor.getLastInterval(), StandardMetrics.THROUGHPUT,
						rateUnit, var.getRepo().getWorkload().getServices()
								.get(i), Aggregation.AVERAGE));
			}
		}
		double[][] preds = new double[throughputs[0].size()][throughputs.length -1];
		for (int i = 0; i < preds.length; i++) {
			for(int j = 0; j < preds[i].length;j++){
				preds[i][j] = throughputs[j+1].get(i);
			}
		}

		regression.newSampleData(
				Util.convertListDouble(throughputs[0].toArray(new Double[0])), preds);

		// export Rsquared and calculate VIF
		double rsquared = regression.calculateRSquared();
		double vif = (1.0) / (1.0 - rsquared);
		if(vif > MAX_VIF){
			vector.setVarianceInflationFactor(MAX_VIF);
		} else {
			vector.setVarianceInflationFactor(vif);
		}
	}
}
