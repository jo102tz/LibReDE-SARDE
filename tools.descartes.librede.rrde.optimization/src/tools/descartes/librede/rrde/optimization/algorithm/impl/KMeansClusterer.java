package tools.descartes.librede.rrde.optimization.algorithm.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.weka.WekaClusterer;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.optimization.algorithm.AbstractClusterer;
import tools.descartes.librede.rrde.optimization.algorithm.clustermodel.FeatureWeights;
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
		
		FeatureWeights weights = new FeatureWeights(distanceTable, instanceToFeatureVector);
		setCoefficients(weights.learnCoefficients());
		return bestResult;
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
