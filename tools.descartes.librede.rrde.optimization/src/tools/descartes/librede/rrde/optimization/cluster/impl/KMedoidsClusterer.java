package tools.descartes.librede.rrde.optimization.cluster.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.optimization.cluster.AbstractClusterer;
import tools.descartes.librede.rrde.optimization.cluster.model.FeatureWeights;
import tools.descartes.librede.rrde.optimization.cluster.model.MyKMedoids;

public class KMedoidsClusterer extends AbstractClusterer {

	public KMedoidsClusterer(EstimationSpecification estimation, EList<InputData> input, OptimizationSettings settings,
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
			Dataset[] result = kMedoidsCluster(data, i);
			instanceToCluster = mapInstanceToCluster(result);
			double silhouette = calculateSilhouette(result, distanceTable);
			if (silhouette > bestSilhouette) {
				bestSilhouette = silhouette;
				bestResult = result;
			}
		}
		FeatureWeights weights = new FeatureWeights(data, instanceToFeatureVector);
		setCoefficients(weights.learnCoefficients());
		return bestResult;
	}
	
	@Override
	public List<List<LibredeConfiguration>> featureCluster() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Dataset[] kMedoidsCluster(Dataset data, int k) {
		MyKMedoids mkm = new MyKMedoids(k);
		Dataset[] results = mkm.cluster(data);
		Instance[] medoids = mkm.getMedoids();
		List<Instance> means = new ArrayList<>();
		List<List<Double>> meanFeatureVectors = new ArrayList<>();
		for (Instance instance : medoids) {
			meanFeatureVectors.add(instanceToFeatureVector.get(instance));
			means.add(instance);
		}
		setMeanFeatures(meanFeatureVectors);
		setMeans(means);
		return results;
	}


}
