package tools.descartes.librede.rrde.optimization.algorithm.impl;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.DistanceMeasure;
import net.sf.javaml.distance.ManhattanDistance;
import net.sf.javaml.distance.NormalizedEuclideanDistance;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClusterer;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.optimization.algorithm.IClusterConfigurationOptimizer;
import tools.descartes.librede.rrde.optimization.algorithm.IClusterer;
import tools.descartes.librede.rrde.optimization.algorithm.clustermodel.FeatureWeights;
import tools.descartes.librede.rrde.optimization.algorithm.clustermodel.MyKMedoids;
import tools.descartes.librede.rrde.util.Discovery;
import tools.descartes.librede.rrde.util.Util;
import tools.descartes.librede.rrde.util.extract.ClusterFeatureExtractor;
import weka.clusterers.SimpleKMeans;

/**
 * ALTE KLASSE, LÖSCHEN FALLS NICHT MEHR BENÖTIGT
 * @author Karsten
 *
 */
public class ClusterOptimizeAlgorithm implements IClusterConfigurationOptimizer {
	
	private static final Logger log = Logger.getLogger(ClusterOptimizeAlgorithm.class);
	
	private LinkedHashMap<Instance, List<Double>> instanceToFeatureVector = new LinkedHashMap<Instance, List<Double>>();
	private LinkedHashMap<Instance, List<Double>> instanceToFeatureVectorShort = new LinkedHashMap<Instance, List<Double>>();
	private LinkedHashMap<Instance, Integer> instanceToID = new LinkedHashMap<Instance, Integer>();
	private LinkedHashMap<Instance, Dataset> instanceToCluster = new LinkedHashMap<>();
	
	private String headerString;
	private Instance[] medoids;

	//TODO: change this
	private String trainingDataPath = "C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\Clusterdaten\\Results";
	
	private Set<LibredeConfiguration> confs;
	private DescriptiveStatistics stat;

	@Override
	public boolean optimizeConfiguration(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier)
			throws IllegalArgumentException {
		//TODO: wie geht das hier? was macht confs, was muss ich pro parameter machen?
		
		ClusterFeatureExtractor extractor = new ClusterFeatureExtractor();
		ClusterExportAlgorithm export = new ClusterExportAlgorithm();
		export.optimizeConfiguration(estimation, input, settings, specifier);
		//hier schreibt er das zeug auf die festplatte
		((DataExportSpecifier) settings).getOutputDirectory();
		
		// set actual output
//		Util.setValue(estimation, value, param);
		
		//TODO: nur einen parameter coden, sonst fehler werfen!
		for (IOptimizableParameter param : settings.getParametersToOptimize()) {
			confs = Discovery.createConfigurations(input, estimation, settings.getValidator());
			for (LibredeConfiguration conf : confs) {
				FeatureVector featureVector = extractor.extractFeatures(conf);
				List<Double> features = new ArrayList<>();
				fillFeatures(features, featureVector);
				
			}
		}
		// TODO Auto-generated method stub
		return false;
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
	
	/**
	 * 
	 * @param featureVector
	 * @param parameter
	 * @param estimations
	 * @return optimal value for the parameter
	 */
	private double executeKMeans(List<Double> featureVector, IOptimizableParameter parameter, EstimationSpecification estimations) {
		String paramname = parameter.getClass().getSimpleName();
		//TODO: rdeAlgo name in EstimationSpecification?
		String rdeAlgo = "???";
		String trainingPath = String.format(trainingDataPath + "\\%s\\%s\\%s.csv", rdeAlgo, paramname, rdeAlgo + "_" + paramname);
		Dataset data = null;
		try {
			data = prepareData(trainingPath);
		} catch (IOException e) {
			log.error("Failed to read in training data");
			e.printStackTrace();
		}
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
		
		FeatureWeights weights = new FeatureWeights(distanceTable, instanceToFeatureVector);
		double[] coefficients = weights.learnCoefficients();
		
		int index = assignInstanceToCluster(featureVector, meanFeatureVectors, coefficients);
		int meanLow = getLowestPoint(means.get(index));
		return meanLow;
	}
	
	private double executeKMedoids(List<Double> featureVector, IOptimizableParameter parameter, EstimationSpecification estimations) {
		String paramname = parameter.getClass().getSimpleName();
		//TODO: rdeAlgo name in EstimationSpecification?
		String rdeAlgo = "???";
		String trainingPath = String.format(trainingDataPath + "\\%s\\%s\\%s.csv", rdeAlgo, paramname, rdeAlgo + "_" + paramname);
		Dataset data = null;
		try {
			data = prepareData(trainingPath);
		} catch (IOException e) {
			log.error("Failed to read in training data");
			e.printStackTrace();
		}
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
		
		List<Instance> means = new ArrayList<>();
		List<List<Double>> meanFeatureVectors = new ArrayList<>();
		for (int i = 0; i < medoids.length; i++) {
			means.add(medoids[i]);
			meanFeatureVectors.add(instanceToFeatureVector.get(medoids[i]));
		}	
		
		FeatureWeights weights = new FeatureWeights(distanceTable, instanceToFeatureVector);
		double[] coefficients = weights.learnCoefficients();
		
		int index = assignInstanceToCluster(featureVector, meanFeatureVectors, coefficients);
		int meanLow = getLowestPoint(means.get(index));
		return meanLow;
	}
	
	private Dataset[] kMeansCluster(Dataset data, int k) {
		SimpleKMeans skm = new SimpleKMeans();
		try {
			skm.setNumClusters(k);
		} catch (Exception e) {
			log.error("failed to set value for k");
			e.printStackTrace();
		}
		Clusterer jmlskm = new WekaClusterer(skm);
		Dataset[] results = jmlskm.cluster(data);
		return results;
	}
	
	private Dataset[] kMedoidsCluster(Dataset data, int k) {
		MyKMedoids mkm = new MyKMedoids(k);
		Dataset[] results = mkm.cluster(data);
		medoids = mkm.getMedoids();
		return results;
	}

	
	public Dataset prepareData(String path) throws IOException {
		Dataset data = readIn(path);
		headerString = extractHeader(data);
		data.remove(0);
		for (Instance instance : data) {
			if (Double.isNaN(instance.value(0))) {
				instance.removeAttribute(0);
			}
		}
		data = extractFeatureVector(data);
		return data;
	}
	
	private Dataset readIn(String path) throws IOException {
		System.out.println("reading new file...");
		Dataset data = FileHandler.loadDataset(new File(path), ";");
		return data;
	}
	
	private String extractHeader(Dataset data) {
		String header = "";
		for (double value : data.get(0)) {
			header += value + ";";
		}
		header += System.lineSeparator();
		return header;
	}
	
	private Dataset extractFeatureVector(Dataset data) {
		for (int cj = 0; cj < data.size()-42; cj++) {
			List<Double> featureVector = new ArrayList<>();
			Instance instance = data.get(cj);
			int size = instance.noAttributes();
			int j = size - 52;
			for (int i = 0; i < 52; i++) {
				featureVector.add(instance.value(j));
				instance.removeAttribute(j);
			}
			instanceToFeatureVectorShort.put(instance, featureVector);
			instanceToFeatureVector.put(instance, featureVector);
		}
		for (int cj = data.size()-42; cj < data.size(); cj++) {
			List<Double> featureVector = new ArrayList<>();
			Instance instance = data.get(cj);
			int size = instance.noAttributes();
			int j = size - 52;
			for (int i = 0; i < 52; i++) {
				featureVector.add(instance.value(j));
				instance.removeAttribute(j);
			}
			instanceToFeatureVector.put(instance, featureVector);
		}
		return data;
	}

	public double[][] calculateDistances(Dataset dataset) {
		double[][] result = new double[dataset.size()][dataset.size()];
		//fill distanceTable
		for (int column = 0; column < dataset.size(); column++) {
			NormalizedEuclideanDistance dist = new NormalizedEuclideanDistance(dataset);
			for (int row = column; row < dataset.size(); row++) {
				result[column][row] = dist.calculateDistance(dataset.get(row), dataset.get(column));
				result[row][column] = result[column][row];
			}
		}
		return result;
	}
	
	private LinkedHashMap<Instance,Integer> mapInstanceToID(Dataset dataset) {
		LinkedHashMap<Instance,Integer> tmpID = new LinkedHashMap<>();
		for (int i = 0; i < dataset.size(); i++) {
			tmpID.put(dataset.get(i), i);
		}
		return tmpID;
	}
	
	public double calculateSilhouette(Dataset[] datasets, double[][] distanceTable) {
		double result = 0;
		for (Map.Entry<Instance, Dataset> entry : instanceToCluster.entrySet()) {
			Dataset cluster = entry.getValue();
			Instance inst = entry.getKey();
			double a = calculateDistance(cluster, inst, instanceToID, distanceTable);
			double b = Double.POSITIVE_INFINITY;
			for (Dataset alienCluster : datasets) {
				if (!alienCluster.equals(cluster)) {
					double tmp = calculateDistance(alienCluster, inst, instanceToID, distanceTable);
					if (tmp < b) {
						b = tmp;
					}
				}
			}
			double silh;
			if (a == 0) {
				silh = 0;
			} else if (a > b) {
				silh = (b-a)/a;
			} else {
				silh = (b-a)/b;
			}
			result += silh;
		}
		return result/instanceToCluster.size();
	}

	private static double calculateDistance(Dataset cluster, Instance instance, LinkedHashMap<Instance, Integer> instanceToID, double[][] distanceTable) {
		double sum = 0;
		for (Instance newInst : cluster) {
			Set<Map.Entry<Instance, Integer>> entries = instanceToID.entrySet();
			int instID=0;
			int newInstID=0;
			for (Entry<Instance, Integer> entry : entries) {
				if (entry.getKey().equals(instance)) {
					instID = entry.getValue();
				}
				if (entry.getKey().equals(newInst)) {
					newInstID = entry.getValue();
				}
			}
			sum += distanceTable[instID][newInstID];
		}
		return sum/cluster.size();
	}

	private LinkedHashMap<Instance, Dataset> mapInstanceToCluster(Dataset[] datasets) {
		LinkedHashMap<Instance,Dataset> tmpCluster = new LinkedHashMap<>();
		for (Dataset dataset : datasets) {
			for (Instance instance : dataset) {
				tmpCluster.put(instance, dataset);
			}
		}
		return tmpCluster;
	}
	
	private int assignInstanceToCluster(List<Double> newVector, List<List<Double>> meanFeatureVectors, double[] coefficients) {
		Instance newVectorInst = convertVectorToInstance(newVector, coefficients);
		Dataset meanFeatureVectorsDataset = convertMeanFeaturesToDataset(meanFeatureVectors, coefficients);
//		DistanceMeasure dist = new NormalizedEuclideanDistance(meanFeatureVectorsDataset);
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
	
	private Instance convertVectorToInstance(List<Double> newVector, double[] coefficients) {
		double[] values = new double[newVector.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = newVector.get(i)*coefficients[i];
		}
		Instance result = new DenseInstance(values);
		return result;
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
	
	private List<Double> calculateMeanFeatures(Dataset d) {
		List<Double> result = new ArrayList<>();
		for (int i = 0; i < 52; i++) {
			double sum = 0;
			for (Instance instance : d) {
				double feature = instanceToFeatureVector.get(instance).get(i);
				sum += feature;
			}
			sum = sum/d.size();
			result.add(sum);
		}
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

	private Instance calculateMeanInstance(Dataset d) {
		double[] values = new double[d.get(0).noAttributes()];
		for (int i = 0; i < values.length; i++) {
			double sum = 0;
			for (Instance inst : d) {
				sum += inst.value(i);
			}
			sum = sum/d.size();
			values[i] = sum;
		}
		Instance result = new DenseInstance(values);
		return result;
	}

	

	@Override
	public Map<LibredeConfiguration, Double> instanceToValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IClusterer getClusterer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstimationSpecification getResult() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSimpleName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSpecifierSupported(ConfigurationOptimizationAlgorithmSpecifier specifier) {
		// TODO Auto-generated method stub
		return false;
	}

}
