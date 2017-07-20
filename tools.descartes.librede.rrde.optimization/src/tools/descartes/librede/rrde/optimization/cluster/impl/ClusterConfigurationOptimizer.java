package tools.descartes.librede.rrde.optimization.cluster.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.optimization.impl.ClusterOptimizationSpecifierImpl;
import tools.descartes.librede.rrde.model.optimization.impl.LocalSearchSpecifierImpl;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.optimization.algorithm.impl.BruteForceAlgorithm;
import tools.descartes.librede.rrde.optimization.cluster.IClusterConfigurationOptimizer;
import tools.descartes.librede.rrde.optimization.cluster.IClusterer;
import tools.descartes.librede.rrde.util.Discovery;
import tools.descartes.librede.rrde.util.Util;
import tools.descartes.librede.rrde.util.extract.ClusterFeatureExtractor;

public class ClusterConfigurationOptimizer implements IClusterConfigurationOptimizer {

	private HashMap<LibredeConfiguration, Double> instanceToOptimum = new HashMap<>();
	HashMap<Instance,LibredeConfiguration> instanceToConf = new HashMap<>();
//	private Map<Dataset,Double> clusterToOptimum = new HashMap<>();
	private IClusterer clusterer;
	private int numberOfFeatures;
	protected EstimationSpecification estimation;
	protected EList<InputData> input;
	protected OptimizationSettings settings;
	public boolean firstRun = true;
	public boolean firstFeatureRun = true;
//	protected ConfigurationOptimizationAlgorithmSpecifier specifier = clusterer.;
	
	public ClusterConfigurationOptimizer(IClusterer clusterer) {
		this.clusterer = clusterer;
	}
	
	public boolean firstRun(EList<InputData> input, OptimizationSettings settings) throws IllegalArgumentException {
		if (settings.getParametersToOptimize().size() > 1) {
			throw new IllegalArgumentException("Functionality for multiple parameters not yet implemented. Only one parameter is supported.");
		}
		this.settings = settings;
		this.input = input;
		if (!clusterer.finishedCalculation()) {
			return false;
		}
		instanceToConf = clusterer.getInstanceToConf();
		Dataset[] result = clusterer.getResults();
		
		for (Dataset dataset : result) {
			for (Instance instance : dataset) {
				int lowIndex = getLowestPoint(instance);
				double lowValue = lowIndex;
				//TODO: get low Value from index!! need stepSize for that?
//				double lowValue = (settings.getParametersToOptimize().get(0).getUpperBound()
//						- settings.getParametersToOptimize().get(0).getLowerBound()) 
//						/ settings
				LibredeConfiguration conf = instanceToConf.get(instance);
				instanceToOptimum.put(conf, lowValue);
			}
		}
		firstRun = false;
		return true;
	}
	
	/**
	 * DO THE ASSIGN INSTANCE TO CLUSTER THING HERE!!!!
	 * @param input
	 * @param settings
	 * @return
	 * @throws IllegalArgumentException
	 */
	@Override
	public boolean optimizeConfiguration(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier)
			throws IllegalArgumentException {
		
		ClusterOptimizationSpecifierImpl spec = (ClusterOptimizationSpecifierImpl) specifier;
		if (spec.featureCluster()) {
			return firstFeatureCluster(estimation, input, settings, specifier);
		}
		
		if (firstRun) {
			return firstRun(input, settings);
		}
		
		if (settings.getParametersToOptimize().size() > 1) {
			throw new IllegalArgumentException("Functionality for multiple parameters not yet implemented. Only one parameter is supported.");
		}
		if (!clusterer.finishedCalculation()) {
			return false;
		}
		
		ClusterFeatureExtractor extractor = new ClusterFeatureExtractor();
		Set<LibredeConfiguration> confs = Discovery.createConfigurations(input, estimation, settings.getValidator());
		for (LibredeConfiguration conf : confs) {
			FeatureVector fv = extractor.extractFeatures(conf);
			List<Double> newVector = new ArrayList<>();
			newVector.add((double)fv.getNumberOfRessources());
			newVector.add((double)fv.getNumberOfWorkloadClasses());
			newVector.add(fv.getVarianceInflationFactor());
			newVector.add(fv.getUtilizationStatistics().get(0).getArithmeticMean());
			int clusterIndex = assignInstanceToCluster(newVector, clusterer.getMeanFeatures(), clusterer.getCoefficients());
			double optimum = getLowestPoint(clusterer.getMeans().get(clusterIndex));
			System.out.println("Found optimal value for conf at: " + optimum);
			instanceToOptimum.put(conf, optimum);
		}
		return true;
	}
	
	private boolean featureCluster(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier) {
		
		ClusterFeatureExtractor extractor = new ClusterFeatureExtractor();
		List<List<LibredeConfiguration>> featureClusterResults = clusterer.getConfResult();
		Set<LibredeConfiguration> confs = Discovery.createConfigurations(input, estimation, settings.getValidator());
		for (LibredeConfiguration conf : confs) {
			FeatureVector fv = extractor.extractFeatures(conf);
			List<Double> newVector = new ArrayList<>();
			newVector.add((double)fv.getNumberOfRessources());
			newVector.add((double)fv.getNumberOfWorkloadClasses());
			newVector.add(fv.getVarianceInflationFactor());
			newVector.add(fv.getUtilizationStatistics().get(0).getArithmeticMean());
			List<Instance> means = clusterer.getMeans();
			List<List<Double>> meanFeatures = new ArrayList<>();
			for (Instance instance : means) {
				List<Double> features = new ArrayList<>(instance.values());
				meanFeatures.add(features);
			}
			int clusterIndex = assignInstanceToCluster(newVector, meanFeatures, clusterer.getCoefficients());
			//TODO: hier brauchen wir die resultate vom S3 um dem gefundenen cluster ein optimum zuordnen zu k�nnen!!
			double result = instanceToOptimum.get(featureClusterResults.get(clusterIndex).get(0));
			instanceToOptimum.put(conf, result);
		}
		return true;
	}
	
	private boolean firstFeatureCluster(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier) {
		
		if (!firstFeatureRun) {
			return featureCluster(estimation, input, settings, specifier);
		}
		boolean allGood = true;
		List<List<LibredeConfiguration>> featureClusters = clusterer.featureCluster();
		BruteForceAlgorithm bruce = new BruteForceAlgorithm();
		for (List<LibredeConfiguration> list : featureClusters) {
			System.out.println("starting brute force");
			Set<LibredeConfiguration> set = new HashSet<>(list);
			bruce.setConfs(set);
			LocalSearchSpecifierImpl d = new LocalSearchSpecifierImpl();
			allGood = bruce.optimizeConfiguration(estimation, input, settings, d);
			//TODO: save values for later -> so richtig?
			double result = Util.getValue(estimation, settings.getParametersToOptimize().get(0));
			System.out.println("bruce result: " + result);
			for (LibredeConfiguration conf : set) {
				instanceToOptimum.put(conf, result);
			}
		}
		if (allGood) {
			firstFeatureRun = false;
		}
		return allGood;
	}
	
	private int assignInstanceToCluster(List<Double> newVector, List<List<Double>> meanFeatureVectors, double[] coefficients) {
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
		for (List<Double> list : meanFeatureVectors) {
			Instance inst = convertVectorToInstance(list, coefficients);
			result.add(inst);
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
	public HashMap<LibredeConfiguration, Double> confToOptimum() {
		return instanceToOptimum;
	}

	@Override
	public IClusterer getClusterer() {
		return clusterer;
	}
	
	public void setClusterer(IClusterer clusterer) {
		this.clusterer = clusterer;
	}

	@Override
	public EstimationSpecification getResult() throws IllegalStateException {
		// TODO this is not needed here and will not work either. What to do?
		// Proposal: add hashmap to specification, mapping each conf to its result
		
		// set actual output
//		Util.setValue(estimation, value, param);

		return null;
	}

	@Override
	public String getSimpleName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public boolean isSpecifierSupported(ConfigurationOptimizationAlgorithmSpecifier specifier) {
		if (specifier instanceof ClusterOptimizationSpecifier) {
			return true;
		}
		return false;
	}

	public int getNumberOfFeatures() {
		return numberOfFeatures;
	}

	public void setNumberOfFeatures(int numberOfFeatures) {
		this.numberOfFeatures = numberOfFeatures;
	}
}
