package tools.descartes.librede.rrde.optimization.algorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.NormalizedEuclideanDistance;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClusterer;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.optimization.algorithm.clustermodel.FeatureWeights;
import tools.descartes.librede.rrde.optimization.algorithm.impl.ClusterExportAlgorithm;
import weka.clusterers.SimpleKMeans;

public abstract class AbstractClusterer implements IClusterer {
	
	protected LinkedHashMap<Instance, List<Double>> instanceToFeatureVector = new LinkedHashMap<Instance, List<Double>>();
	protected LinkedHashMap<Instance, List<Double>> instanceToFeatureVectorShort = new LinkedHashMap<Instance, List<Double>>();
	protected LinkedHashMap<Instance, Integer> instanceToID = new LinkedHashMap<Instance, Integer>();
	protected LinkedHashMap<Instance, Dataset> instanceToCluster = new LinkedHashMap<>();
	protected List<Double> headerValues = new ArrayList<Double>();

	private List<List<Double>> meanFeatures = new ArrayList<>();
	private List<Instance> means = new ArrayList<>();
	private double[] coefficients;
	private Dataset[] result;
	
	private EstimationSpecification estimation;
	
	protected Dataset data;

	public AbstractClusterer(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier) {
		this.estimation = estimation;
		ClusterExportAlgorithm export = new ClusterExportAlgorithm();
		export.optimizeConfiguration(estimation, input, settings, specifier);
		String sourceDirectory = ((DataExportSpecifier) settings).getOutputDirectory();
		try {
			data = prepareData(sourceDirectory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method should not be used and should be overwritten. Standard Algorithm is k-Means.
	 */
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
		this.result = bestResult;
		return bestResult;
	}

	@Override
	public List<Instance> getMeans() {
		return means;
	}
	
	public void setMeans(List<Instance> newMeans) {
		this.means = newMeans;
	}

	@Override
	public List<List<Double>> getMeanFeatures() {
		return meanFeatures;
	}
	
	public void setMeanFeatures(List<List<Double>> newFeatures) {
		this.meanFeatures = newFeatures;
	}

	@Override
	public double[] getCoefficients() {
		return coefficients;
	}
	
	public void setCoefficients(double[] coefficients) {
		this.coefficients = coefficients;
	}	
	
	protected LinkedHashMap<Instance, Dataset> mapInstanceToCluster(Dataset[] datasets) {
		LinkedHashMap<Instance,Dataset> tmpCluster = new LinkedHashMap<>();
		for (Dataset dataset : datasets) {
			for (Instance instance : dataset) {
				tmpCluster.put(instance, dataset);
			}
		}
		return tmpCluster;
	}

	protected LinkedHashMap<Instance,Integer> mapInstanceToID(Dataset dataset) {
		LinkedHashMap<Instance,Integer> tmpID = new LinkedHashMap<>();
		for (int i = 0; i < dataset.size(); i++) {
			tmpID.put(dataset.get(i), i);
		}
		return tmpID;
	}

	protected double[][] calculateDistances(Dataset dataset) {
		double[][] result = new double[dataset.size()][dataset.size()];
		for (int column = 0; column < dataset.size(); column++) {
			NormalizedEuclideanDistance dist = new NormalizedEuclideanDistance(dataset);
			for (int row = column; row < dataset.size(); row++) {
				result[column][row] = dist.calculateDistance(dataset.get(row), dataset.get(column));
				result[row][column] = result[column][row];
			}
		}
		return result;
	}
	
	protected double calculateSilhouette(Dataset[] datasets, double[][] distanceTable) {
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

	protected Instance calculateMeanInstance(Dataset d) {
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
	
	protected List<Double> calculateMeanFeatures(Dataset d) {
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

	private Dataset prepareData(String path) throws IOException {
		Dataset data = readIn(path);
		extractHeader(data);
		data.remove(0);
		for (Instance instance : data) {
			if (Double.isNaN(instance.value(0))) {
				instance.removeAttribute(0);
			}
		}
		data = extractFeatureVector(data);
		calculateDistances(data);
		return data;
	}
	
	private Dataset readIn(String path) throws IOException {
		System.out.println("reading new file...");
		Dataset data = FileHandler.loadDataset(new File(path), ";");
		return data;
	}
	
	private String extractHeader(Dataset data) {
		//extract header
		String header = "";
		for (double value : data.get(0)) {
			headerValues.add(value);
			header += value + ";";
		}
		header += System.lineSeparator();
		return header;
	}
	
	private Dataset extractFeatureVector(Dataset data) {
		for (Instance instance : data) {
			List<Double> featureVector = new ArrayList<>();
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
	
	@Override
	public Dataset[] getResults() {
		return result;
	}
	
	@Override
	public List<Double> getHeader() {
		return headerValues;
	}

	@Override
	public EstimationSpecification getSpecification() {
		return estimation;
	}

	public void setSpecification(EstimationSpecification estimation) {
		this.estimation = estimation;
	}

}
