package tools.descartes.librede.rrde.optimization.cluster.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.weka.WekaClusterer;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.optimization.cluster.AbstractClusterer;
import tools.descartes.librede.rrde.optimization.cluster.model.FeatureWeights;
import tools.descartes.librede.rrde.util.Discovery;
import tools.descartes.librede.rrde.util.extract.ClusterFeatureExtractor;
import weka.clusterers.SimpleKMeans;

public class KMeansClusterer extends AbstractClusterer {
	
	public KMeansClusterer(EstimationSpecification estimation, EList<InputData> input, OptimizationSettings settings,
			ConfigurationOptimizationAlgorithmSpecifier specifier) {
		super(estimation, input, settings, specifier);
	}

	@Override
	public Dataset[] cluster() {
		instanceToID = mapInstanceToID(data);
		double[][] distanceTable = calculateDistances(data);
		double bestSilhouette = -2;
		Dataset[] bestResult = null;
		for (int i = 2; i < 6; i++) {
			Dataset[] result = kMeansCluster(data, i);
			instanceToCluster = mapInstanceToCluster(result);
			double silhouette = calculateSilhouette(result, distanceTable);
			System.out.println("Silhouette for k=" + i + " : "+ silhouette);
			if (silhouette > bestSilhouette) {
				bestSilhouette = silhouette;
				bestResult = result;
			}
		}
		
		List<Instance> means = new ArrayList<>();
		List<List<Double>> meanFeatureVectors = new ArrayList<>();
		for (Dataset d : bestResult) {
			Instance meanInstance = calculateMeanInstance(d);
			means.add(meanInstance);
			List<Double> meanFeatures = calculateMeanFeatures(d);
			meanFeatureVectors.add(meanFeatures);
		}
		setMeans(means);
		setMeanFeatures(meanFeatureVectors);
		
		FeatureWeights weights = new FeatureWeights(data, instanceToFeatureVector);
		setCoefficients(weights.learnCoefficients());
		return bestResult;
	}
	
	@Override
	public List<List<LibredeConfiguration>> featureCluster() {
		LinkedHashMap<Instance,LibredeConfiguration> featureVectorToConf = new LinkedHashMap<>();
		Dataset allData = new DefaultDataset();
		ClusterFeatureExtractor extractor = new ClusterFeatureExtractor();
		Set<LibredeConfiguration> confs = Discovery.createConfigurations(getInput(), getSpecification(), getSettings().getValidator());
		for (LibredeConfiguration conf : confs) {
			FeatureVector vector = extractor.extractFeatures(conf);
			List<Double> featureVector = createFeatures(vector);
			//TODO: coefficients setzen vorher!
			Instance featureInst = convertVectorToInstance(featureVector, getCoefficients());
			featureVectorToConf.put(featureInst, conf);
			allData.add(featureInst);
		}
		
		double[][] distanceTable = calculateDistances(allData);
		double bestSilhouette = -2;
		Dataset[] bestResult = null;
		for (int i = 2; i < 6; i++) {
			Dataset[] result = kMeansCluster(data, i);
			instanceToCluster = mapInstanceToCluster(result);
			double silhouette = calculateSilhouette(result, distanceTable);
			if (silhouette > bestSilhouette) {
				bestSilhouette = silhouette;
				bestResult = result;
			}
		}
		
		List<Instance> means = new ArrayList<>();
		for (Dataset d : bestResult) {
			Instance meanInstance = calculateMeanInstance(d);
			means.add(meanInstance);
		}
		setMeans(means);

		List<List<LibredeConfiguration>> result = new ArrayList<>();
		for (int i = 0; i < bestResult.length; i++) {
			List<LibredeConfiguration> tmp = new ArrayList<>();
			result.add(tmp);
			for (Instance instance : bestResult[i]) {
				result.get(i).add(featureVectorToConf.get(instance));
			}
		}
		resultMap = result;
		return result;
	}
	
	private List<Double> createFeatures(FeatureVector vector) {
		List<Double> result = new ArrayList<Double>();
		result.add((double)vector.getNumberOfRessources());
		result.add((double)vector.getNumberOfWorkloadClasses());
		result.add(vector.getVarianceInflationFactor());
		result.add(vector.getUtilizationStatistics().get(0).getArithmeticMean());
		return result;
	}
	
	private Dataset[] kMeansCluster(Dataset data, int k) {
		SimpleKMeans skm = new SimpleKMeans();
		try {
			skm.setNumClusters(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Clusterer jmlskm = new WekaClusterer(skm);
		Dataset[] results = jmlskm.cluster(data);
		return results;
	}
}
