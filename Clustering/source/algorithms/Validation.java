package algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.DistanceMeasure;
import net.sf.javaml.distance.NormalizedEuclideanDistance;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClusterer;
import weka.clusterers.SimpleKMeans;

public class Validation {
	
	private LinkedHashMap<Instance, List<Double>> instanceToFeatureVector = new LinkedHashMap<Instance, List<Double>>();
	private LinkedHashMap<Instance, List<Double>> instanceToFeatureVectorShort = new LinkedHashMap<Instance, List<Double>>();
	private List<Double> header = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		Validation validator = new Validation();
		Dataset data = validator.prepareData(Main.WKF_BOUNDSFACTOR);
		Dataset[] compareResult = validator.kMeansCluster(data, 4);
		double compareSilhouette = validator.calculateSilhouette(compareResult, validator.calculateDistances(data));
		//TODO: check silhouette calculation.. seems wrong
		System.out.println("silh of whole clustering: " + compareSilhouette);
		Dataset[] alldata = validator.splitData(data, 5);
		Dataset training = new DefaultDataset();
		for (int i = 0; i < alldata.length-1; i++) {
			for (Instance instance : alldata[i]) {
				training.add(instance);
			}
		}
		Dataset validation = alldata[4];
		Dataset[] result = validator.kMeansCluster(training, 4);
		
		List<Instance> means = new ArrayList<>();
		List<List<Double>> meanFeatureVectors = new ArrayList<>();
		for (Dataset d : result) {
			System.out.println("calculating another mean...");
			Instance meanInstance = validator.calculateMeanInstance(d);
			means.add(meanInstance);
			System.out.println("calculating another mean feature...");
			List<Double> meanFeatures = validator.calculateMeanFeatures(d);
			meanFeatureVectors.add(meanFeatures);
		}
		
		System.out.println("doing the OLS thing...");
		double[][] distanceTable = validator.calculateDistances(training);
		FeatureWeights weights = new FeatureWeights(distanceTable, validator.instanceToFeatureVectorShort);
		double[] coefficients = weights.learnCoefficients();
		
		StringBuilder sb = new StringBuilder();
		for (Instance newInstance : validation) {
			int clusterIndex = validator.assignInstanceToCluster(validator.instanceToFeatureVector.get(newInstance), meanFeatureVectors, coefficients);
			double newLow = validator.getLowestPoint(newInstance);
			double meanLow = validator.getLowestPoint(means.get(clusterIndex));
			sb.append("Actual optimum: " + newLow + System.lineSeparator() + "Optimum found by cluster: " + meanLow + System.lineSeparator() + System.lineSeparator());
			training.add(newInstance);
			result[clusterIndex].add(newInstance);
		}
		distanceTable = validator.calculateDistances(training);
		double secondSilhouette = validator.calculateSilhouette(result, distanceTable);
		sb.append("Silhouette after clustering the whole set: " + compareSilhouette + System.lineSeparator() + 
				"Silhouette when clustering based on feature vectors: " + secondSilhouette);
		BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\kfold\\kmeans\\5foldCluster_wkf_boundsfactor.txt"));
		br.write(sb.toString());
		System.out.println(sb.toString());
		br.close();
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
	
	private double getLowestPoint(Instance instance) {
		double lowPoint = Double.MAX_VALUE;
		double lowIndex = 0;
		for (int i = 0; i < instance.noAttributes(); i++) {
			if (instance.value(i) < lowPoint) {
				//TODO: check this thing
				lowIndex = i+1;
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

	public Validation() {
		
	}
			
	private Dataset[] splitData(Dataset data, int k) {
		Dataset[] result = new Dataset[k];
		for (int i = 0; i < k; i++) {
			Dataset d = new DefaultDataset();
			result[i] = d;
		}
		int size = Math.floorDiv(data.size(), k);
		for (int i = 0; i < k-1; i++) {
			for (int j = 0; j < size; j++) {
				result[i].add(data.get((i*size)+j));
			}
		}
		for (int i = (k-1)*size; i < data.size(); i++) {
			result[k-1].add(data.get(i));
		}
		return result;
	}
	
	public Dataset[] kMeansCluster(Dataset data, int k) throws Exception {
		SimpleKMeans skm = new SimpleKMeans();
		skm.setNumClusters(k);
		Clusterer jmlskm = new WekaClusterer(skm);
		Dataset[] results = jmlskm.cluster(data);
		return results;
	}
	
	public Dataset prepareData(String path) throws IOException {
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
			this.header.add(value);
			header += value + ";";
		}
		header += System.lineSeparator();
		return header;
	}
	
	private Dataset extractFeatureVector(Dataset data) {
		//extract and remove feature vector
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
		System.out.println("calculating distance table...");
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

	private int assignInstanceToCluster(List<Double> newVector, List<List<Double>> meanFeatureVectors, double[] coefficients) {
		Instance newVectorInst = convertVectorToInstance(newVector, coefficients);
		Dataset meanFeatureVectorsDataset = convertMeanFeaturesToDataset(meanFeatureVectors, coefficients);
		DistanceMeasure dist = new NormalizedEuclideanDistance(meanFeatureVectorsDataset);
		int closestMeanIndex = -1;
		double bestDistance = Integer.MAX_VALUE;
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
	
	private static LinkedHashMap<Instance, Dataset> mapInstanceToCluster(Dataset[] datasets) {
		LinkedHashMap<Instance,Dataset> tmpCluster = new LinkedHashMap<>();
		for (Dataset dataset : datasets) {
			for (Instance instance : dataset) {
				tmpCluster.put(instance, dataset);
			}
		}
		return tmpCluster;
	}


	private Instance convertVectorToInstance(List<Double> newVector, double[] coefficients) {
		double[] values = new double[newVector.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = newVector.get(i)*coefficients[i];
		}
		Instance result = new DenseInstance(values);
		return result;
	}
	
	private LinkedHashMap<Instance,Integer> mapInstanceToID(Dataset[] dataset) {
		LinkedHashMap<Instance,Integer> tmpID = new LinkedHashMap<>();
		for (int j = 0; j < dataset.length; j++) {
			for (int i = j*dataset.length; i < dataset[j].size(); i++) {
				if (tmpID.containsKey(dataset[j].get(i))) {
				}
				tmpID.put(dataset[j].get(i), i);
			}
		}
		//TODO: liegt entweder hier oder an instancetocluster
		return tmpID;
	}

	public double calculateSilhouette(Dataset[] datasets, double[][] distanceTable) {
		LinkedHashMap<Instance,Dataset> instanceToCluster = mapInstanceToCluster(datasets);
		LinkedHashMap<Instance,Integer> instanceToID = mapInstanceToID(datasets);
		double result = 0;
//		System.out.println("Silh: number of clusters = " + instanceToCluster.size());
		for (Map.Entry<Instance, Dataset> entry : instanceToCluster.entrySet()) {
			Dataset cluster = entry.getValue();
			Instance inst = entry.getKey();
			double a = calculateDistance(cluster, inst, instanceToID, distanceTable);
			double b = Double.MAX_VALUE;
//			System.out.println("Silh: number of clusters in dataset = " + datasets.length);
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
			if (silh < -1 || silh > 1) {
				System.out.println("WARNING: silhouette is out of bounds " + instanceToID.get(inst));
			}
//			System.out.println("Silh of Instance " + instanceToID.get(inst)  + " is " + silh);
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

}
