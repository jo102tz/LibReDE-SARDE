package tools.descartes.librede.rrde.optimization.cluster.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.Instance;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.optimization.cluster.AbstractClusterer;
import tools.descartes.librede.rrde.optimization.cluster.model.FeatureWeights;
import tools.descartes.librede.rrde.optimization.cluster.model.MyKMedoids;
import tools.descartes.librede.rrde.util.Discovery;
import tools.descartes.librede.rrde.util.extract.ClusterFeatureExtractor;

public class KMedoidsClusterer extends AbstractClusterer {
	
	private List<Instance> tmpMeans = new ArrayList<>();
	private List<List<Double>> tmpMeanFeatureVectors = new ArrayList<>();


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
				setMeanFeatures(tmpMeanFeatureVectors);
				setMeans(tmpMeans);
			}
		}
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
			double[] dummyCoeff = new double[featureVector.size()];
			Arrays.fill(dummyCoeff, 1);
			setCoefficients(dummyCoeff);
			Instance featureInst = convertVectorToInstance(featureVector, getCoefficients());
			featureVectorToConf.put(featureInst, conf);
			allData.add(featureInst);
		}
		
		double[][] distanceTable = calculateDistances(allData);
		double bestSilhouette = -2;
		Dataset[] bestResult = null;
		for (int i = 2; i < 6; i++) {
			Dataset[] result = kMedoidsCluster(allData, i);
			instanceToCluster = mapInstanceToCluster(result);
			double silhouette = calculateSilhouette(result, distanceTable);
			if (silhouette > bestSilhouette) {
				bestSilhouette = silhouette;
				bestResult = result;
				setMeanFeatures(tmpMeanFeatureVectors);
				setMeans(tmpMeans);
			}
		}
		System.out.println("Optimal number of clusters found: " + bestResult.length);
		
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
		this.tmpMeanFeatureVectors = meanFeatureVectors;
		this.tmpMeans = means;
		return results;
	}


}
