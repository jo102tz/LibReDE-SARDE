package algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import net.sf.javaml.distance.ManhattanDistance;
import net.sf.javaml.distance.NormalizedEuclideanDistance;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClusterer;
import weka.clusterers.SimpleKMeans;

public class Validation {
	
	private Instance[] medoids;
	private String headerString;
	private boolean isNaN = false;
	
	private LinkedHashMap<Instance, List<Double>> instanceToFeatureVector = new LinkedHashMap<Instance, List<Double>>();
	private LinkedHashMap<Instance, List<Double>> instanceToFeatureVectorShort = new LinkedHashMap<Instance, List<Double>>();
	private LinkedHashMap<Instance, Integer> instanceToID = new LinkedHashMap<Instance, Integer>();
	private LinkedHashMap<Instance, Dataset> instanceToClusterCompare = new LinkedHashMap<>();
	private LinkedHashMap<Instance, Dataset> instanceToCluster = new LinkedHashMap<>();
	private LinkedHashMap<Instance, Instance> featureVectorToInstance = new LinkedHashMap<>();
	private List<Double> header = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		double start = System.currentTimeMillis();
//		kmeans();
//		kmedoids();
//		notkf();
//		showThatItsShit(Main.WKF_STATENOISECOUPLING, 3, "wkf_statenoisecoupling_is_it_shit");
		clusterFeatures(4);
		double end = System.currentTimeMillis();
		System.out.println("Time elapsed: " + (end-start));
	}
	
	private static void clusterFeatures(int k) throws Exception {
		Validation validator = new Validation();
		Dataset data = validator.prepareData(Main.WKF_BOUNDSFACTOR);
		
		//get coefficients
//		double[][] distanceTable = validator.calculateDistances(data);
//		Dataset[] tmp = validator.kMeansCluster(data, k);
		validator.instanceToFeatureVector = validator.mapFeatureVector(data);
		FeatureWeights weights = new FeatureWeights(data, validator.instanceToFeatureVector);
//		FeatureWeights weights = new FeatureWeights(distanceTable, validator.instanceToFeatureVector);
		double[] coefficients = weights.learnCoefficients();
		//TODO: warum kommt hier exakt das gleiche ergebnis raus?
		Dataset featureData = new DefaultDataset();
		double[] coefficientsDummy = new double[52];
		Arrays.fill(coefficientsDummy, 1);
		for (Instance instance : data) {
			List<Double> fv = validator.instanceToFeatureVector.get(instance);
			Instance fInst = validator.convertVectorToInstance(fv, coefficients);
			featureData.add(fInst);
			validator.featureVectorToInstance.put(fInst, instance);
		}
		Dataset[] featureResult = validator.kMeansCluster(featureData, k);
		Dataset[] result = new Dataset[k];
		for (int i = 0; i < featureResult.length; i++) {
			Dataset d = new DefaultDataset();
			result[i] = d;
		}
		for (int i = 0; i < featureResult.length; i++) {
			for (Instance instance : featureResult[i]) {
				result[i].add(validator.featureVectorToInstance.get(instance));
			}
		}
		Main.exportToCSV(result, validator.headerString, k, "featureKMeans", "wkf", "bf");
	}
	
	private static void notkf() throws Exception {
		for (int i = 0; i < 5; i++) {
			doKMeans(i, Main.LIU, 2, "liu_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMeans(i, Main.MENASCE, 3, "menasce_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMeans(i, Main.RTA, 2, "rta_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMeans(i, Main.RTR, 2, "rtr_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMeans(i, Main.SDL, 2, "sdl_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMeans(i, Main.URA, 2, "ura_stepwinrel");
		}
		
		for (int i = 0; i < 5; i++) {
			doKMedoids(i, Main.LIU, 2, "liu_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMedoids(i, Main.MENASCE, 3, "menasce_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMedoids(i, Main.RTA, 4, "rta_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMedoids(i, Main.RTR, 2, "rtr_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMedoids(i, Main.SDL, 2, "sdl_stepwinrel");
		}
		for (int i = 0; i < 5; i++) {
			doKMedoids(i, Main.URA, 2, "ura_stepwinrel");
		}
	}
	
	private static void kmedoids() throws Exception {
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.KKF_BOUNDSDISTANCE, 2, "kkf_boundsdistance");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.KKF_BOUNDSFACTOR, 5, "kkf_boundsfactor");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.KKF_OBSERVENOISECOVARIANCE, 2, "kkf_observenoisecov");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.KKF_STATENOISECOUPLING, 2, "kkf_statenoisecoupl");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.KKF_STATENOISECOVARIANCE, 2, "kkf_statenoisecov");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.KKF_STEP_WINDOW_REL, 2, "kkf_stepwinrel");
		}
		
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.WKF_BOUNDSDISTANCE, 2, "wkf_boundsdistance");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.WKF_BOUNDSFACTOR, 5, "wkf_boundsfactor");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.WKF_OBSERVENOISECOVARIANCE, 3, "wkf_observenoisecov");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.WKF_STATENOISECOUPLING, 2, "wkf_statenoisecoupl");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.WKF_STATENOISECOVARIANCE, 2, "wkf_statenoisecov");
		}
		for(int i = 0; i < 5; i++) {
			doKMedoids(i, Main.WKF_STEP_WINDOW_REL, 2, "wkf_stepwinrel");
		}
	}
	
	private static void kmeans() throws Exception {
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.KKF_BOUNDSDISTANCE, 2, "kkf_boundsdistance");
//		}
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.KKF_BOUNDSFACTOR, 2, "kkf_boundsfactor");
//		}
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.KKF_OBSERVENOISECOVARIANCE, 2, "kkf_observenoisecov");
//		}
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.KKF_STATENOISECOUPLING, 2, "kkf_statenoisecoupl");
//		}
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.KKF_STATENOISECOVARIANCE, 2, "kkf_statenoisecov");
//		}
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.KKF_STEP_WINDOW_REL, 2, "kkf_stepwinrel");
//		}
//		
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.WKF_BOUNDSDISTANCE, 2, "wkf_boundsdistance");
//		}
		for(int i = 0; i < 10; i++) {
			doKMeans(i, Main.WKF_BOUNDSFACTOR, 4, "wkf_boundsfactor");
		}
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.WKF_OBSERVENOISECOVARIANCE, 3, "wkf_observenoisecov");
//		}
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.WKF_STATENOISECOUPLING, 2, "wkf_statenoisecoupl");
//		}
//		for(int i = 0; i < 5; i++) {
//			doKMeans(i, Main.WKF_STATENOISECOVARIANCE, 3, "wkf_statenoisecov");
//		}
		for(int i = 0; i < 10; i++) {
			doKMeans(i, Main.WKF_STEP_WINDOW_REL, 2, "wkf_stepwinrel");
		}
	}
	
	private static void doKMedoids(int kfoldIteration, String path, int numClusters, String filename) throws Exception {
		System.out.println("initializing another round of kmedoids with " + filename);
		Validation validator = new Validation();
		Dataset data = validator.prepareData(path);
		validator.instanceToID = validator.mapInstanceToID(data);
		Dataset[] compareResult = validator.kMedoidsCluster(data, numClusters);
		validator.instanceToClusterCompare = validator.mapInstanceToCluster(compareResult);
		double compareSilhouette = validator.calculateCompareSilhouette(compareResult, validator.calculateDistances(data));
//		System.out.println("silh of whole clustering: " + compareSilhouette);
		Dataset[] alldata = validator.splitData(data, 5);
		Dataset training = new DefaultDataset();
		for (int i = 0; i < alldata.length; i++) {
			if (i != kfoldIteration) {
				for (Instance instance : alldata[i]) {
					training.add(instance);
				}
			}
		}
		Dataset validation = alldata[kfoldIteration];
		Dataset[] result = validator.kMedoidsCluster(training, numClusters);
		
		double[][] distanceTable = validator.calculateDistances(data);
		validator.instanceToCluster = validator.mapInstanceToCluster(result);
		double firstSilhouette = validator.calculateSilhouette(result, distanceTable);
		double[][] distanceTableShort = validator.calculateDistances(training);

		List<Instance> means = new ArrayList<>();
		List<List<Double>> meanFeatureVectors = new ArrayList<>();
		for (int i = 0; i < validator.medoids.length; i++) {
			means.add(validator.medoids[i]);
			meanFeatureVectors.add(validator.instanceToFeatureVector.get(validator.medoids[i]));
		}		
//		System.out.println("doing the OLS thing...");
		FeatureWeights weights = new FeatureWeights(distanceTableShort, validator.instanceToFeatureVectorShort);
		double[] coefficients = weights.learnCoefficients();
		
		StringBuilder sb = new StringBuilder();
		
		double errorDiff = 0.0;
		int count = 0;
		
		int wrongAssign = 0;
		
		for (Instance newInstance : validation) {
			int clusterIndex = validator.assignInstanceToCluster(validator.instanceToFeatureVector.get(newInstance), meanFeatureVectors, coefficients);
			int realIndex = validator.realAssign(newInstance, means);
			if (realIndex == -1) {
				System.out.println("WARNING: something went wrong");
			}
			if (clusterIndex != realIndex) {
				wrongAssign++;
			}
			int newLow = validator.getLowestPoint(newInstance);
			int meanLow = validator.getLowestPoint(means.get(clusterIndex));
			double newError = newInstance.value(newLow);
			double meanError = newInstance.value(meanLow);
			double diff = Math.abs(newError-meanError);
			errorDiff += diff;
			if (validator.isNaN) {
				newLow++;
				meanLow++;
			}
			errorDiff = errorDiff/count;
			sb.append("Actual optimum: " + validator.header.get(newLow) + System.lineSeparator() + "Optimum found by cluster: " + validator.header.get(meanLow) + System.lineSeparator()
				+ "Error differs: " + diff + System.lineSeparator() + System.lineSeparator());
			sb.append("Actual optimum: " + newLow + System.lineSeparator() + "Optimum found by cluster: " + meanLow + System.lineSeparator() + System.lineSeparator());
			training.add(newInstance);
			result[clusterIndex].add(newInstance);
			count++;
		}
		
		sb.append(System.lineSeparator() + "Number of wrong assignments: " + wrongAssign);
		sb.append(System.lineSeparator());
		
		validator.instanceToCluster = validator.mapInstanceToCluster(result);
		double secondSilhouette = validator.calculateSilhouette(result, distanceTable);
		sb.append("Silhouette after clustering the whole set (compareSilhouette): " + compareSilhouette + System.lineSeparator() + 
				"Silhouette before adding new instances: " + firstSilhouette + System.lineSeparator() +  
				"Silhouette when clustering based on feature vectors: " + secondSilhouette);
		String outputPath = String.format("C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\kfold\\kmedoids\\%s%d.txt", filename, kfoldIteration);
		BufferedWriter br = new BufferedWriter(new FileWriter(outputPath));
		sb.append(System.lineSeparator() + System.lineSeparator() + validator.compareResults(compareResult, result));
		br.write(sb.toString());
		br.close();
//		Main.exportToCSV(result, validator.headerString, numClusters, "kmedoids", filename, filename+kfoldIteration);
		String outputpath = String.format("C:\\Users\\Karsten\\Desktop\\Bachelor Arbeit\\Zuordnungen\\%s\\%s\\%s\\%s.0clusters", filename, filename+kfoldIteration, "kmedoids", numClusters);
//		Main.exportSingleCluster(validation, validator.headerString, outputpath, -1);
	}
	
	private static void showThatItsShit(String path, int numClusters, String filename) throws Exception {
		StringBuilder sb = new StringBuilder();
		Validation validator = new Validation();
		Dataset data = validator.prepareData(path);
		validator.instanceToID = validator.mapInstanceToID(data);
		Dataset[] result =  validator.kMeansCluster(data, numClusters);
		double[][] distanceTable = validator.calculateDistances(data);
		Dataset validation = data;
		validator.instanceToCluster = validator.mapInstanceToCluster(result);
		int z = 0;
//		for (Instance instance : data) {
//			sb.append("Instance " + z + " is clustered in cluster #" + whichCluster(result,validator.instanceToCluster.get(instance)));
//			sb.append(System.lineSeparator());
//			z++;
//		}
		double firstSilhouette = validator.calculateSilhouette(result, distanceTable);
		List<Instance> means = new ArrayList<>();
		List<List<Double>> meanFeatureVectors = new ArrayList<>();
		for (Dataset d : result) {
//			System.out.println("calculating another mean...");
			Instance meanInstance = validator.calculateMeanInstance(d);
			means.add(meanInstance);
//			System.out.println("calculating another mean feature...");
			List<Double> meanFeatures = validator.calculateMeanFeatures(d);
			meanFeatureVectors.add(meanFeatures);
		}
		FeatureWeights weights = new FeatureWeights(distanceTable, validator.instanceToFeatureVector);
		double[] coefficients = weights.learnCoefficients();
		
		int count = 0;
		double errorDiff = 0.0;
		
		LinkedHashMap<Instance, Dataset> secondMapping = new LinkedHashMap<>();
		int wrongAssign = 0;
		
		for (Instance newInstance : validation) {
			int clusterIndex = validator.assignInstanceToCluster(validator.instanceToFeatureVector.get(newInstance), meanFeatureVectors, coefficients);
			int realIndex = validator.realAssign(newInstance, means);
			if (clusterIndex != realIndex) {
				wrongAssign++;
			}
			int newLow = validator.getLowestPoint(newInstance);
			int meanLow = validator.getLowestPoint(means.get(clusterIndex));
			double newError = newInstance.value(newLow);
			double meanError = newInstance.value(meanLow);
			double diff = Math.abs(newError-meanError);
			errorDiff += diff;
			if (validator.isNaN) {
				newLow++;
				meanLow++;
			}
//			sb.append("Instance " + count + " is clustered in cluster #" + clusterIndex);
//			sb.append(System.lineSeparator());
//			sb.append("Actual optimum: " + validator.header.get(newLow) + System.lineSeparator() + "Optimum found by cluster: " + validator.header.get(meanLow) + System.lineSeparator()
//				+ "Error differs: " + diff + System.lineSeparator() + System.lineSeparator());
//			training.add(newInstance);
			result[clusterIndex].add(newInstance);
			secondMapping.put(newInstance, result[clusterIndex]);
			count++;
		}
		
		sb.append(System.lineSeparator() + "Number of wrong assignments: " + wrongAssign);
		sb.append(System.lineSeparator());
		errorDiff = errorDiff/count;
		
		sb.append("Average difference of estimated errors: " + errorDiff + System.lineSeparator());
		
		validator.instanceToCluster = validator.mapInstanceToCluster(result);
		double secondSilhouette = validator.calculateSilhouette(result, distanceTable);
		sb.append("Silhouette after clustering the whole set (compareSilhouette): " + firstSilhouette + System.lineSeparator() + 
				"Silhouette before adding new instances: " + firstSilhouette + System.lineSeparator() +  
				"Silhouette when clustering based on feature vectors: " + secondSilhouette);
		
		
		String outputPath = String.format("C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\kfold\\kmeans\\%s%d.txt", filename, 0);
		BufferedWriter br = new BufferedWriter(new FileWriter(outputPath));
//		sb.append(System.lineSeparator() + System.lineSeparator() + validator.compareResults(result, result));
		br.write(sb.toString());
//		System.out.println(sb.toString());
		br.close();
//		System.out.println(validator.compareResults(compareResult, result));
//		Main.exportToCSV(result, validator.headerString, numClusters, "kmeans", filename, filename+kfoldIteration);
		String outputpath = String.format("C:\\Users\\Karsten\\Desktop\\Bachelor Arbeit\\Zuordnungen\\%s\\%s\\%s\\%s.0clusters", filename, filename+0, "kmeans", numClusters);
//		Main.exportSingleCluster(validation, validator.headerString, outputpath, -1);

	}
	
	private static void doKMeans(int kfoldIteration, String path, int numClusters, String filename) throws Exception {
		System.out.println("initializing another round of kmeans with " + filename);
		Validation validator = new Validation();
		Dataset data = validator.prepareData(path);
		validator.instanceToID = validator.mapInstanceToID(data);
		Dataset[] compareResult = validator.kMeansCluster(data, numClusters);
		validator.instanceToClusterCompare = validator.mapInstanceToCluster(compareResult);
		double compareSilhouette = validator.calculateCompareSilhouette(compareResult, validator.calculateDistances(data));
//		System.out.println("silh of whole clustering: " + compareSilhouette);
		Dataset[] alldata = validator.splitData(data, 10);
		Dataset training = new DefaultDataset();
		for (int i = 0; i < alldata.length; i++) {
			if (i != kfoldIteration) {
				for (Instance instance : alldata[i]) {
					training.add(instance);
				}
			}
		}
		Dataset validation = alldata[kfoldIteration];
		Dataset[] result = validator.kMeansCluster(training, numClusters);
		
		double[][] distanceTable = validator.calculateDistances(data);
		validator.instanceToCluster = validator.mapInstanceToCluster(result);
		double firstSilhouette = validator.calculateSilhouette(result, distanceTable);
//		double[][] distanceTableShort = validator.calculateDistances(training);

		List<Instance> means = new ArrayList<>();
		List<List<Double>> meanFeatureVectors = new ArrayList<>();
		for (Dataset d : result) {
//			System.out.println("calculating another mean...");
			Instance meanInstance = validator.calculateMeanInstance(d);
			means.add(meanInstance);
//			System.out.println("calculating another mean feature...");
			List<Double> meanFeatures = validator.calculateMeanFeatures(d);
			meanFeatureVectors.add(meanFeatures);
		}
		
//		System.out.println("doing the OLS thing...");
//		FeatureWeights weights = new FeatureWeights(distanceTableShort, validator.instanceToFeatureVectorShort);
		validator.instanceToFeatureVectorShort = validator.mapFeatureVector(training);
		FeatureWeights weights = new FeatureWeights(training, validator.instanceToFeatureVectorShort);
		double[] coefficients = weights.learnCoefficients();
		
		StringBuilder sb = new StringBuilder();
		
		int count = 0;
		double errorDiff = 0.0;
		
		int wrongAssign = 0;
		
		for (Instance newInstance : validation) {
			int clusterIndex = validator.assignInstanceToCluster(validator.instanceToFeatureVector.get(newInstance), meanFeatureVectors, coefficients);
			int realIndex = validator.realAssign(newInstance, means);
			if (realIndex == -1) {
				System.out.println("WARNING: something went wrong");
			}
			if (clusterIndex != realIndex) {
				wrongAssign++;
			}
			int newLow = validator.getLowestPoint(newInstance);
			int meanLow = validator.getLowestPoint(means.get(clusterIndex));
			double newError = newInstance.value(newLow);
			double meanError = newInstance.value(meanLow);
			double diff = Math.abs(newError-meanError);
			errorDiff += diff;
			if (validator.isNaN) {
				newLow++;
				meanLow++;
			}
			sb.append("Actual optimum: " + validator.header.get(newLow) + System.lineSeparator() + "Optimum found by cluster: " + validator.header.get(meanLow) + System.lineSeparator()
				+ "Error differs: " + diff + System.lineSeparator() + System.lineSeparator());
			training.add(newInstance);
			result[clusterIndex].add(newInstance);
			count++;
		}
		
		sb.append(System.lineSeparator() + "Number of wrong assignments: " + wrongAssign);
		sb.append(System.lineSeparator());
		
		errorDiff = errorDiff/count;
		
		sb.append("Average difference of estimated errors: " + errorDiff + System.lineSeparator());
		
		validator.instanceToCluster = validator.mapInstanceToCluster(result);
		double secondSilhouette = validator.calculateSilhouette(result, distanceTable);
		sb.append("Silhouette after clustering the whole set (compareSilhouette): " + compareSilhouette + System.lineSeparator() + 
				"Silhouette before adding new instances: " + firstSilhouette + System.lineSeparator() +  
				"Silhouette when clustering based on feature vectors: " + secondSilhouette);
		String outputPath = String.format("C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\kfold\\kmeans\\%s%d.txt", filename, kfoldIteration);
		BufferedWriter br = new BufferedWriter(new FileWriter(outputPath));
		sb.append(System.lineSeparator() + System.lineSeparator() + validator.compareResults(compareResult, result));
		br.write(sb.toString());
//		System.out.println(sb.toString());
		br.close();
//		System.out.println(validator.compareResults(compareResult, result));
		Main.exportToCSV(result, validator.headerString, numClusters, "kmeans", filename, filename+kfoldIteration);
		String outputpath = String.format("C:\\Users\\Karsten\\Desktop\\Bachelor Arbeit\\Zuordnungen\\%s\\%s\\%s\\%s.0clusters", filename, filename+kfoldIteration, "kmeans", numClusters);
		Main.exportSingleCluster(validation, validator.headerString, outputpath, -1);
	}
	
	private int realAssign(Instance newInstance, List<Instance> means) {
		Dataset tmp = new DefaultDataset();
		for (Instance instance : means) {
			tmp.add(instance);
		}
		double bestDist = Double.POSITIVE_INFINITY;
		int bestMean = -1;
		DistanceMeasure dist = new NormalizedEuclideanDistance(tmp);
		for (int i = 0; i < means.size(); i++) {
			if (dist.measure(newInstance, means.get(i)) < bestDist) {
				bestDist = dist.measure(newInstance, means.get(i));
				bestMean = i;
			}
		}
		return bestMean;
	}

	private String compareResults(Dataset[] firstSet, Dataset[] secondSet) {
		if (firstSet.length != secondSet.length) {
			System.out.println("WARNING: number of clusters does not match");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < firstSet.length; i++) {
			for (int j = 0; j < secondSet.length; j++) {
				sb.append("SimilarityScore of Cluster " + i + " and " + j + " = " + compareClusters(firstSet[i], secondSet[j]));
				sb.append(System.lineSeparator());
				sb.append("Size of " + i + ": " + firstSet[i].size() + " Size of " + j + ": " + secondSet[j].size());
				sb.append(System.lineSeparator());
				sb.append("Number of same Instances in " + i + " and " + j + " = " + getNumberOfSameInstances(firstSet[i], secondSet[j]));
				sb.append(System.lineSeparator());
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
	
	private int getNumberOfSameInstances(Dataset first, Dataset second) {
		int result = 0;
		for (Instance instance : first) {
			if (second.contains(instance)) {
				result++;
			}
		}
		return result;
	}
	
	private double compareClusters(Dataset first, Dataset second) {
		double result = 0.0;
		int count = 0;
		double divideByMe = (first.noAttributes()-second.noAttributes())/2;
		if (first.noAttributes() > second.noAttributes()) {
			for (Instance instance : first) {
				if (second.contains(instance)) {
					result++;
				} else {
					result--;
				}
				count++;
			}
			divideByMe += count;
			result = result/divideByMe;
		} else {
			for (Instance instance : second) {
				if (first.contains(instance)) {
					result++;
				} else {
					result--;
				}
				count++;
			}
			divideByMe += count;
			result = result/divideByMe;
		}
		return result;
	}
	
	private List<Double> calculateMeanFeatures(Dataset d) {
		List<Double> result = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
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
	
	public Dataset[] kMedoidsCluster(Dataset data, int k) throws Exception {
		MyKMedoids mkm = new MyKMedoids(k);
		Dataset[] results = mkm.cluster(data);
		this.medoids = mkm.getMedoids();
		return results;
	}
	
	public Dataset prepareData(String path) throws IOException {
		Dataset data = readIn(path);
		headerString = extractHeader(data);
		data.remove(0);
		for (Instance instance : data) {
			if (Double.isNaN(instance.value(0))) {
				instance.removeAttribute(0);
				isNaN = true;
			}
		}
		data = extractFeatureVector(data);
//		calculateDistances(data);
		return data;
	}

	private Dataset readIn(String path) throws IOException {
		System.out.println("reading new file...");
		Dataset data = FileHandler.loadDataset(new File(path), ";");
		return data;
	}
	
	private String extractHeader(Dataset data) {
		String header = "";
//		if (Double.isNaN(data.get(1).value(0))) {
//			for (int i = 1; i < data.get(0).noAttributes(); i++) {
//				this.header.add(data.get(0).value(i));
//				header += data.get(0).value(i) + ";";
//			}
//			header += System.lineSeparator();
//		} else {
			for (double value : data.get(0)) {
				this.header.add(value);
				header += value + ";";
			}
			header += System.lineSeparator();
//		}
		return header;
	}
	
	private LinkedHashMap<Instance,List<Double>> mapFeatureVector(Dataset data) {
		LinkedHashMap<Instance,List<Double>> instanceToFeatureVectorShort = new LinkedHashMap<>();
		for (int cj = 0; cj < data.size(); cj++) {
			instanceToFeatureVectorShort.put(data.get(cj), instanceToFeatureVector.get(data.get(cj)));
		}
		return instanceToFeatureVectorShort;
	}
	
	private Dataset extractFeatureVector(Dataset data) {
		//TODO: hier mit k-fold aufpassen, HARDCODE
		//extract and remove feature vector
		for (int cj = 0; cj < data.size()-21; cj++) {
			List<Double> featureVector = new ArrayList<>();
			Instance instance = data.get(cj);
			int size = instance.noAttributes();
			int j = size - 5;
			for (int i = 0; i < 5; i++) {
				featureVector.add(instance.value(j));
				instance.removeAttribute(j);
			}
			instanceToFeatureVectorShort.put(instance, featureVector);
			instanceToFeatureVector.put(instance, featureVector);
		}
		for (int cj = data.size()-21; cj < data.size(); cj++) {
			List<Double> featureVector = new ArrayList<>();
			Instance instance = data.get(cj);
			int size = instance.noAttributes();
			int j = size - 5;
			for (int i = 0; i < 5; i++) {
				featureVector.add(instance.value(j));
				instance.removeAttribute(j);
			}
			instanceToFeatureVector.put(instance, featureVector);
		}
		return data;
	}

	public double[][] calculateDistances(Dataset dataset) {
//		System.out.println("calculating distance table...");
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
		//TODO: watch this
//		Arrays.fill(coefficients, 1);
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
	
	private LinkedHashMap<Instance, Dataset> mapInstanceToCluster(Dataset[] datasets) {
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
			if (silh < -1 || silh > 1) {
				System.out.println("WARNING: silhouette is out of bounds " + instanceToID.get(inst));
			}
//			System.out.println("Silh of Instance " + instanceToID.get(inst)  + " is " + silh);
		}
		return result/instanceToCluster.size();
	}
	
	public double calculateCompareSilhouette(Dataset[] datasets, double[][] distanceTable) {
//		LinkedHashMap<Instance,Dataset> instanceToCluster = mapInstanceToCluster(datasets);
//		LinkedHashMap<Instance,Integer> instanceToID = mapInstanceToID(datasets);
		double result = 0;
//		System.out.println("Silh: number of clusters = " + instanceToCluster.size());
		for (Map.Entry<Instance, Dataset> entry : instanceToClusterCompare.entrySet()) {
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
		return result/instanceToClusterCompare.size();
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
	
	private static int whichCluster(Dataset[] array, Dataset value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

}
