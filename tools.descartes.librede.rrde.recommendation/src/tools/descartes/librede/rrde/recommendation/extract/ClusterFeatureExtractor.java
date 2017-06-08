package tools.descartes.librede.rrde.recommendation.extract;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.ModelEntity;
import tools.descartes.librede.metrics.Aggregation;
import tools.descartes.librede.metrics.Metric;
import tools.descartes.librede.repository.IRepositoryCursor;
import tools.descartes.librede.repository.TimeSeries;
import tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.model.recommendation.impl.StatisticalFeaturesImpl;
import tools.descartes.librede.rrde.util.extract.BasicFeatureExtractor;
import tools.descartes.librede.units.Dimension;
import tools.descartes.librede.units.Unit;

public class ClusterFeatureExtractor extends BasicFeatureExtractor{

	public ClusterFeatureExtractor(FeatureExtractorSpecifier specifier) {
		super(specifier);
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

	protected void extractCorrelationAndCovarianceInformation(
			FeatureVector vector, LibredeVariables var) {
			//We dont want to extract correlation and covariances, so we leaves this empty
	}

}
