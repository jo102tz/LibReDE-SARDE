package tools.descartes.librede.rrde.util.extract;

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
import tools.descartes.librede.rrde.model.optimization.util.OptimizationAdapterFactory;
import tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.model.recommendation.impl.FeatureExtractorSpecifierImpl;
import tools.descartes.librede.rrde.model.recommendation.impl.FeatureVectorImpl;
import tools.descartes.librede.rrde.model.recommendation.impl.RecommendationFactoryImpl;
import tools.descartes.librede.rrde.model.recommendation.impl.StatisticalFeaturesImpl;
import tools.descartes.librede.units.Dimension;
import tools.descartes.librede.units.Ratio;
import tools.descartes.librede.units.RequestRate;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.Unit;
import tools.descartes.librede.units.impl.QuantityImpl;
import tools.descartes.librede.units.impl.UnitsFactoryImpl;

public class ClusterFeatureExtractor implements IFeatureExtractor{
	
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
	private Unit<Time> standardTimeUnit;

	/**
	 * The standard rate for all exports
	 */
	private Unit<RequestRate> rateUnit;

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
	 * Returns the logger for logging events.
	 * 
	 * @return the {@link Logger}
	 */
	protected Logger getLog() {
		return log;
	}

	/**
	 * Standard constructor setting basic values for all constants.
	 */
//	public ClusterFeatureExtractor(FeatureExtractorSpecifier specifier) {
//		this.spec = specifier;
//		if (spec == null || spec.getRateUnit() == null
//				|| spec.getAggregation() == null) {
//			getLog().warn("Specifier is null. Using default values...");
//			standardTimeUnit = Time.MILLISECONDS;
//		} else {
//			try {
//				standardTimeUnit = spec.getAggregation().getUnit();
//			} catch (Exception e) {
//				getLog().warn(
//						"Time unit could not be cast. Using default value...");
//				standardTimeUnit = Time.MILLISECONDS;
//			}
//			try {
//				rateUnit = (Unit<RequestRate>) spec.getRateUnit();
//			} catch (Exception e) {
//				getLog().warn(
//						"Request rate unit could not be cast. Using default value...");
//				rateUnit = RequestRate.REQ_PER_MINUTE;
//			}
//		}
//		if (spec.getAggregation() == null || spec.getAggregation().getValue() <= 0) {
//			getLog().warn(
//					"Aggreation interval could not be read. Using default value...");
//			UnitsFactoryImpl factory = (UnitsFactoryImpl) UnitsFactoryImpl.init();
//			spec.setAggregation(factory.createQuantity());
//			spec.getAggregation().setValue(60000);
//		}
//	}


	public ClusterFeatureExtractor() {
		standardTimeUnit = Time.MILLISECONDS;
		rateUnit = RequestRate.REQ_PER_MINUTE;
//		UnitsFactoryImpl factory = (UnitsFactoryImpl) UnitsFactoryImpl.init();
//		spec.setAggregation(factory.createQuantity());
//		spec.getAggregation().setValue(60000);
//		spec.getAggregation().setUnit(standardTimeUnit);

	}

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
					getLog().warn(
							"The time series " + series
							+ " has more than one column. ");
				} else if (series.getData().columns() == 0 || series.isEmpty()) {
					getLog().warn("The time series " + series + " is empty.");
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
//				vector.setN(stat.getN());
		vector.setGeometricMean(stat.getGeometricMean());
		vector.setArithmeticMean(stat.getMean());
		vector.setStandardDeviation(stat.getStandardDeviation());
//				vector.setQuadraticMean(stat.getQuadraticMean());
		vector.setMaximum(stat.getMax());
		vector.setMinimum(stat.getMin());
//				vector.setKurtosis(stat.getKurtosis());
//				vector.setSkewness(stat.getSkewness());
//				vector.setTenthpercentile(stat.getPercentile(10));
//				vector.setNinetiethpercentile(stat.getPercentile(90));

		computeIsNormaldistributed(vector, stat.getMean(),
				stat.getStandardDeviation(), stat.getValues());

		computeAutocorrelation(vector, stat.getValues());

		return vector;
	}
	
	protected void computeAutocorrelation(StatisticalFeatures vector,
			double[] values) {
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
		vector.setAutocorrelation(sumofcorrelations / ((double) MAX_LAG));
	}

	protected void computeIsNormaldistributed(StatisticalFeatures vector,
			double mean, double standardDeviation, double[] values) {
		vector.setIsNormalDistributed(TestUtils.kolmogorovSmirnovStatistic(
				new NormalDistribution(mean, standardDeviation), values));
	}


	protected void extractCorrelationAndCovarianceInformation(
			FeatureVector vector, LibredeVariables var) {
			//We dont want to extract correlation and covariances, so we leaves this empty
	}
	
	protected void extractWorkloadDescription(FeatureVector vector,
			LibredeVariables var) {
		vector.setNumberOfRessources(var.getConf().getWorkloadDescription()
				.getResources().size());
		vector.setNumberOfWorkloadClasses(var.getConf()
				.getWorkloadDescription().getServices().size());
	}
	
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
		ArrayList<Double>[] throughputs = new ArrayList[var.getRepo()
				.getWorkload().getServices().size()];
		for (int i = 0; i < var.getRepo().getWorkload().getServices().size(); i++) {
			throughputs[i] = new ArrayList<>();
		}

		@SuppressWarnings("unchecked")
		ArrayList<Double>[] utilizations = new ArrayList[var.getRepo()
				.getWorkload().getResources().size()];
		for (int i = 0; i < var.getRepo().getWorkload().getResources().size(); i++) {
			utilizations[i] = new ArrayList<>();
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
			for (int i = 0; i < var.getRepo().getWorkload().getResources()
					.size(); i++) {
				utilizations[i].add(cursor.getAggregatedValue(
						cursor.getLastInterval(), StandardMetrics.UTILIZATION,
						Ratio.PERCENTAGE, var.getRepo().getWorkload()
								.getResources().get(i), Aggregation.AVERAGE));
			}
		}

		double[] avgutilization = new double[utilizations[0].size()];
		for (int i = 0; i < avgutilization.length; i++) {
			double avg = 0;
			for (int j = 0; j < utilizations.length; j++) {
				avg += utilizations[j].get(i);
			}
			avgutilization[i] = avg / utilizations.length;
		}

		double[][] preds = new double[throughputs[0].size()][throughputs.length];
		for (int i = 0; i < preds.length; i++) {
			for (int j = 0; j < preds[i].length; j++) {
				preds[i][j] = throughputs[j].get(i);
			}
		}

		regression.newSampleData(avgutilization, preds);

		// export Rsquared and calculate VIF
		double rsquared = regression.calculateRSquared();
		double vif = (1.0) / (1.0 - rsquared);
		if (vif > MAX_VIF) {
			vector.setVarianceInflationFactor(MAX_VIF);
		} else {
			vector.setVarianceInflationFactor(vif);
		}
	}


	@Override
	public FeatureVector extractFeatures(LibredeConfiguration conf) {
		// init variables
		LibredeVariables var = new LibredeVariables(conf);
		Librede.initRepo(var);
		FeatureVector vector = new FeatureVectorImpl();
		//TODO: NPE here?
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

}
