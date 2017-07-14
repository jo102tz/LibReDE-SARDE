package tools.descartes.librede.rrde.optimization.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.DistanceMeasure;
import net.sf.javaml.distance.ManhattanDistance;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.util.Discovery;
import tools.descartes.librede.rrde.util.extract.ClusterFeatureExtractor;

/**
 * gedachte reihenfolge: erst clusterer ausführen mit den 210 (oder whatever) traces. danach diese klasse 
 * mit dem angegebenen clusterer ausführen und mit einer (oder vielen) neuen LibredeConfigs füttern.
 * zurückgegeben wird einer hashmap, die eine LibredeConfiguration auf einen double mappt (optimum)
 * @author Karsten
 *
 */
public abstract class AbstractClusterConfigurationOptimizer implements IClusterConfigurationOptimizer {

	private Map<LibredeConfiguration, Double> instanceToValue = new HashMap<>();
	private Map<Dataset,Double> clusterToOptimum = new HashMap<>();
	private IClusterer clusterer;
	protected EstimationSpecification estimation;
	protected EList<InputData> input;
	protected OptimizationSettings settings;
	protected ConfigurationOptimizationAlgorithmSpecifier specifier;
	
	public AbstractClusterConfigurationOptimizer(IClusterer clusterer) {
		this.clusterer = clusterer;
		this.estimation = clusterer.getSpecification();
	}
	
	public boolean optimizeConfiguration(EList<InputData> input, OptimizationSettings settings) {
		Dataset[] result = clusterer.getResults();
		for (int i = 0; i < result.length; i++) {
			clusterToOptimum.put(result[i], clusterer.getHeader().get(getLowestPoint(clusterer.getMeans().get(i))));
		}
		ClusterFeatureExtractor extractor = new ClusterFeatureExtractor();
		Set<LibredeConfiguration> confs = Discovery.createConfigurations(input, estimation, settings.getValidator());
		for (LibredeConfiguration conf : confs) {
			FeatureVector featureVector = extractor.extractFeatures(conf);
			List<Double> features = new ArrayList<>();
			fillFeatures(features, featureVector);
			int clusterIndex = assignInstanceToCluster(features, clusterer.getMeanFeatures(), clusterer.getCoefficients());
			if (clusterIndex < 0 || clusterIndex >= result.length) {
				return false;
			}
			instanceToValue.put(conf, clusterToOptimum.get(result[clusterIndex]));
		}
		
		return true;
	}
	
	private void fillFeatures(List<Double> features, FeatureVector fv) {
		features.add((double) fv.getNumberOfRessources());
		features.add((double) fv.getNumberOfWorkloadClasses());
		features.add(fv.getVarianceInflationFactor());
		StatisticalFeatures stats = fv.getUtilizationStatistics().get(0);
		addStats(features, stats);
		for (int i = 0; i < 3; i++) {
			if (fv.getResponseTimeStatistics().size() <= i) {
				if (fv.getResponseTimeStatistics().size() <= i-1) {
					stats = fv.getResponseTimeStatistics().get(i-2);
					addStats(features, stats);
				} else {
					stats = fv.getResponseTimeStatistics().get(i-1);
					addStats(features, stats);
				}
			} else {
				stats = fv.getResponseTimeStatistics().get(i);
				addStats(features, stats);
			}
			if (fv.getArrivalRateStatistics().size() <= i) {
				if (fv.getArrivalRateStatistics().size() <= i-1) {
					stats = fv.getArrivalRateStatistics().get(i-2);
					addStats(features, stats);
				} else {
					stats = fv.getArrivalRateStatistics().get(i-1);
					addStats(features, stats);
				}
			} else {
				stats = fv.getArrivalRateStatistics().get(i);
				addStats(features, stats);
			}
		}
	}

	private void addStats(List<Double> features, StatisticalFeatures stats) {
		features.add(stats.getArithmeticMean());
		features.add(stats.getGeometricMean());
		features.add(stats.getStandardDeviation());
		features.add(stats.getMinimum());
		features.add(stats.getMaximum());
		features.add(stats.getAutocorrelation());
		features.add(stats.getIsNormalDistributed());
	}

	
	public int assignInstanceToCluster(List<Double> newVector, List<List<Double>> meanFeatureVectors, double[] coefficients) {
		Instance newVectorInst = convertVectorToInstance(newVector, coefficients);
		Dataset meanFeatureVectorsDataset = convertMeanFeaturesToDataset(meanFeatureVectors, coefficients);
		DistanceMeasure dist = new ManhattanDistance();
		int closestMeanIndex = -1;
		double bestDistance = Double.POSITIVE_INFINITY;
		for (int i = 0; i < meanFeatureVectorsDataset.size(); i++) {
			double distance  = dist.measure(newVectorInst, meanFeatureVectorsDataset.get(i));
			if (distance < bestDistance) {
				bestDistance = distance;
				closestMeanIndex = i;
			}
		}
		return closestMeanIndex;
	}

	private Dataset convertMeanFeaturesToDataset(List<List<Double>> meanFeatureVectors, double[] coefficients) {
		Dataset result = new DefaultDataset();
		for (int i = 0; i < meanFeatureVectors.size(); i++) {
			for (List<Double> list : meanFeatureVectors) {
				Instance inst = convertVectorToInstance(list, coefficients);
				result.add(inst);
			}
		}
		return result;
	}

	private Instance convertVectorToInstance(List<Double> newVector, double[] coefficients) {
		double[] values = new double[newVector.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = newVector.get(i)*coefficients[i];
		}
		Instance result = new DenseInstance(values);
		return result;
	}
	
	private int getLowestPoint(Instance instance) {
		double lowPoint = Double.MAX_VALUE;
		int lowIndex = 0;
		for (int i = 0; i < instance.noAttributes(); i++) {
			if (instance.value(i) < lowPoint) {
				lowPoint = instance.value(i);
				lowIndex = i;
			}
		}
		return lowIndex;
	}


	
	@Override
	public Map<LibredeConfiguration, Double> instanceToValue() {
		return instanceToValue;
	}

	@Override
	public IClusterer getClusterer() {
		return clusterer;
	}
	
	public void setClusterer(IClusterer clusterer) {
		this.clusterer = clusterer;
	}

}
