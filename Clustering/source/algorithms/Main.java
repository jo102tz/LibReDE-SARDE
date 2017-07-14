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
import net.sf.javaml.clustering.DensityBasedSpatialClustering;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.DistanceMeasure;
import net.sf.javaml.distance.ManhattanDistance;
import net.sf.javaml.distance.NormalizedEuclideanDistance;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClusterer;
import weka.clusterers.SimpleKMeans;
import smile.clustering.*;
import smile.math.distance.Distance;

public class Main {
	
	public static String header;
	
	public static String FILES_TO_WORK_WITH = "C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\Clusterdaten\\output";
	
	public static String LIU = FILES_TO_WORK_WITH + "\\LiuOptimizationApproach_StepSize_relative7200.0.csv";
	public static String MENASCE = FILES_TO_WORK_WITH + "\\MenasceOptimizationApproach_StepSize_relative7200.0.csv";
	public static String RTA = FILES_TO_WORK_WITH + "\\ResponseTimeApproximationApproach_StepSize_relative7200.0.csv";
	public static String RTR = FILES_TO_WORK_WITH + "\\ResponseTimeRegressionApproach_StepSize_relative7200.0.csv";
	public static String SDL = FILES_TO_WORK_WITH + "\\ServiceDemandLawApproach_StepSize_relative7200.0.csv";
	public static String URA = FILES_TO_WORK_WITH + "\\UtilizationRegressionApproach_StepSize_relative7200.0.csv";
	
	public static String WKF_STEP_WINDOW_REL = FILES_TO_WORK_WITH + "\\WangKalmanFilterApproach_StepSize_relative7200.0.csv";
	public static String WKF_BOUNDSFACTOR =  FILES_TO_WORK_WITH + "\\WangKalmanFilterApproach_BoundsFactor.csv";
	public static String WKF_BOUNDSDISTANCE = FILES_TO_WORK_WITH + "\\WangKalmanFilterApproach_InitialBoundsDistance.csv";
	public static String WKF_OBSERVENOISECOVARIANCE = FILES_TO_WORK_WITH + "\\WangKalmanFilterApproach_ObserveNoiseCovariance.csv";
	public static String WKF_STATENOISECOVARIANCE = FILES_TO_WORK_WITH + "\\WangKalmanFilterApproach_StateNoiseCovariance.csv";
	public static String WKF_STATENOISECOUPLING = FILES_TO_WORK_WITH + "\\WangKalmanFilterApproach_StateNoiseCoupling.csv";
	
	public static String KKF_STEP_WINDOW_REL = FILES_TO_WORK_WITH + "\\KumarKalmanFilterApproach_StepSize_relative7200.0.csv";
	public static String KKF_BOUNDSFACTOR = FILES_TO_WORK_WITH + "\\KumarKalmanFilterApproach_BoundsFactor.csv";
	public static String KKF_BOUNDSDISTANCE = FILES_TO_WORK_WITH + "\\KumarKalmanFilterApproach_InitialBoundsDistance.csv";
	public static String KKF_OBSERVENOISECOVARIANCE = FILES_TO_WORK_WITH + "\\KumarKalmanFilterApproach_ObserveNoiseCovariance.csv";
	public static String KKF_STATENOISECOVARIANCE = FILES_TO_WORK_WITH + "\\KumarKalmanFilterApproach_StateNoiseCovariance.csv";
	public static String KKF_STATENOISECOUPLING = FILES_TO_WORK_WITH + "\\KumarKalmanFilterApproach_StateNoiseCoupling.csv";
	
	public static String RTA_STEPWINDOW_REL = "C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\Clusterdaten\\Johannes' Daten\\WS-relative-20-500-1\\ResponseTimeApproximationApproach_StepSizeImpl_relativeChanges_10000.csv";
	
	public static String TEST_FILE = "C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\Clusterdaten\\Test2.csv";
	
	private static LinkedHashMap<Instance, List<Double>> instanceToFeatureVector = new LinkedHashMap<Instance, List<Double>>();
	private static LinkedHashMap<Instance, Dataset> instanceToCluster = new LinkedHashMap<>();
	private static LinkedHashMap<Instance, Integer> instanceToID = new LinkedHashMap<>();
	private static List<List<IClusterResult>> listOfResults = new ArrayList<>();
	
	private static double[][] distanceTable;
	
	public static void main(String[] args) throws Exception{
		
		boolean rated = true;
		
		long start = System.currentTimeMillis();
		instantiateListOfResults(6);
		
//		doKMeans(2, 6, rated);
//		doDBScan(rated);
		doKMedoids(rated);
//		doOLS();
//		testSilhouette();
		if(rated) {
			BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\evaluations\\evaluation.txt"));
			for(IClusterResult r : evaluate()) {
				br.write(r.toString() + System.lineSeparator());
				System.out.println(r);
			}
			br.close();
		}
		System.out.println("finished calculation, spent time in millis: " + (System.currentTimeMillis()-start));
	}
	
	private static void doKMedoids(boolean rated) throws Exception {
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(WKF_STEP_WINDOW_REL);
//			kMedoidsCluster(data, k, "wkf", "step_window_rel", 0, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(WKF_BOUNDSFACTOR);
//			kMedoidsCluster(data, k, "wkf", "boundsfactor", 1, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(WKF_BOUNDSDISTANCE);
//			kMedoidsCluster(data, k, "wkf", "boundsdistance", 2, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(WKF_OBSERVENOISECOVARIANCE);
//			kMedoidsCluster(data, k, "wkf", "observenoisecovariance", 3, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(WKF_STATENOISECOUPLING);
//			kMedoidsCluster(data, k, "wkf", "statenoisecoupling", 4, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(WKF_STATENOISECOVARIANCE);
//			kMedoidsCluster(data, k, "wkf", "statenoisecovariance", 5, rated);
//		}
//		
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(KKF_STEP_WINDOW_REL);
//			kMedoidsCluster(data, k, "kkf", "step_window_rel", 6, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(KKF_BOUNDSFACTOR);
//			kMedoidsCluster(data, k, "kkf", "boundsfactor", 7, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(KKF_BOUNDSDISTANCE);
//			kMedoidsCluster(data, k, "kkf", "boundsdistance", 8, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(KKF_OBSERVENOISECOVARIANCE);
//			kMedoidsCluster(data, k, "kkf", "observenoisecovariance", 9, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(KKF_STATENOISECOUPLING);
//			kMedoidsCluster(data, k, "kkf", "statenoisecoupling", 10, rated);
//		}
//		for (int k=2; k < 7; k++) {
//			Dataset data = prepareData(KKF_STATENOISECOVARIANCE);
//			kMedoidsCluster(data, k, "kkf", "statenoisecovariance", 11, rated);
//		}
		
		for (int k=2; k < 6; k++) {
			Dataset data = prepareData(LIU);
			kMedoidsCluster(data, k, "liu", "step_win_rel", 0, rated);
		}
		for (int k=2; k < 6; k++) {
			Dataset data = prepareData(MENASCE);
			kMedoidsCluster(data, k, "menasce", "step_win_rel", 1, rated);
		}
		for (int k=2; k < 6; k++) {
			Dataset data = prepareData(RTA);
			kMedoidsCluster(data, k, "rta", "step_win_rel", 2, rated);
		}
		for (int k=2; k < 6; k++) {
			Dataset data = prepareData(RTR);
			kMedoidsCluster(data, k, "rtr", "step_win_rel", 3, rated);
		}
		for (int k=2; k < 6; k++) {
			Dataset data = prepareData(SDL);
			kMedoidsCluster(data, k, "sdl", "step_win_rel", 4, rated);
		}
		for (int k=2; k < 6; k++) {
			Dataset data = prepareData(URA);
			kMedoidsCluster(data, k, "ura", "step_win_rel", 5, rated);
		}
	}
	
	private static void testSilhouette() throws Exception {
		kMeansCluster(WKF_BOUNDSFACTOR, 4, "test", "test", 0, true);
	}
	
	private static void doOLS() throws Exception {
		kMeansCluster(KKF_STATENOISECOUPLING, 2, "test", "test", 0, false);
		FeatureWeights weights = new FeatureWeights(distanceTable, instanceToFeatureVector);
		double[] coeff = weights.learnCoefficients();
		
		BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\Karsten\\Dropbox\\Bachelor Arbeit\\Bachelor Arbeit Cluster\\OLS\\"
				+ "KKF_STATENOISECOUPLING.csv"));
		br.write(featureHeader() + System.lineSeparator());
		for (double d : coeff) {
			br.write(d + ";");
		}
		br.close();

//		dbscanCluster(0.1,6,TEST_FILE, "test", "test", 0, rated);
	}
	
	private static void doKMeans(int minK, int maxK, boolean rated) throws Exception {
		for (int k=minK; k < maxK+1; k++) {
//			kMeansCluster(WKF_STEP_WINDOW_REL, k, "wkf", "step_window_rel", 0, rated);
//			kMeansCluster(WKF_BOUNDSFACTOR, k, "wkf", "boundsfactor", 1, rated);
//			kMeansCluster(WKF_BOUNDSDISTANCE, k, "wkf", "initialboundsdistance", 2, rated);
//			kMeansCluster(WKF_OBSERVENOISECOVARIANCE, k, "wkf", "observenoisecovariance", 3, rated);
//			kMeansCluster(WKF_STATENOISECOVARIANCE, k, "wkf", "statenoisecovariance", 4, rated);
//			kMeansCluster(WKF_STATENOISECOUPLING, k, "wkf", "statenoisecoupling", 5, rated);
//			
//			kMeansCluster(KKF_STEP_WINDOW_REL, k, "kkf", "step_window_rel", 6, rated);
//			kMeansCluster(KKF_BOUNDSFACTOR, k, "kkf", "boundsfactor", 7, rated);
//			kMeansCluster(KKF_BOUNDSDISTANCE, k, "kkf", "initialboundsdistance", 8, rated);
//			kMeansCluster(KKF_OBSERVENOISECOVARIANCE, k, "kkf", "observenoisecovariance", 9, rated);
//			kMeansCluster(KKF_STATENOISECOVARIANCE, k, "kkf", "statenoisecovariance", 10, rated);
//			kMeansCluster(KKF_STATENOISECOUPLING, k, "kkf", "statenoisecoupling", 11, rated);
			kMeansCluster(LIU, k, "liu", "step_win_rel", 0, rated);
			kMeansCluster(MENASCE, k, "menasce", "step_win_rel", 1, rated);
			kMeansCluster(RTA, k, "rta", "step_win_rel", 2, rated);
			kMeansCluster(RTR, k, "rtr", "step_win_rel", 3, rated);
			kMeansCluster(SDL, k, "sdl", "step_win_rel", 4, rated);
			kMeansCluster(URA, k, "ura", "step_win_rel", 5, rated);
		}
	}
	
	private static void doDBScan(boolean rated) throws Exception {
//		Dataset data = prepareData(WKF_STEP_WINDOW_REL);
//		for (int i = 1; i < 10; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " wkf step_win_rel");
//			dbscanCluster(data,j, 6, WKF_STEP_WINDOW_REL, "wkf", "step_window_rel", 0, rated);
//		}
		Dataset data = prepareData(WKF_BOUNDSFACTOR);
//		for (int i = 1; i < 10; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " wkf boundsfactor");
			dbscanCluster(data,0.03,2, "wkf", "boundsfactor", 0, rated);
//		}
//		
//		Dataset data = prepareData(WKF_BOUNDSDISTANCE);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.1;
//			System.out.println("initializing another cluster with eps=" + j + " wkf initialboundsdist");
//			dbscanCluster(data,j,6,WKF_BOUNDSDISTANCE, "wkf", "initialboundsdistance", 0, rated);
//		}
//		
//		data.clear();
//		data = prepareData(WKF_OBSERVENOISECOVARIANCE);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.1;
//			System.out.println("initializing another cluster with eps=" + j + " wkf obsnoisecov");
//			dbscanCluster(data,j,6,WKF_OBSERVENOISECOVARIANCE, "wkf", "observenoisecovariance", 3, rated);
//		}
//		
//		data.clear();
//		data = prepareData(WKF_STATENOISECOVARIANCE);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " wkf statenoisecov");
//			dbscanCluster(data,j,6,WKF_STATENOISECOVARIANCE, "wkf", "statenoisecovariance", 4, rated);
//		}
//		
//		data.clear();
//		data = prepareData(WKF_STATENOISECOUPLING);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " wkf statenoisecoupl");
//			dbscanCluster(data,j,6,WKF_STATENOISECOUPLING, "wkf", "statenoisecoupling", 5, rated);
//		}
//		
//		data.clear();
//		data = prepareData(KKF_STEP_WINDOW_REL);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " kkf step_win_rel");
//			dbscanCluster(data,j,6,KKF_STEP_WINDOW_REL, "kkf", "step_window_rel", 6, rated);
//		}
//		
//		data.clear();
//		data = prepareData(KKF_BOUNDSFACTOR);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " kkf boundsfactor");
//			dbscanCluster(data,j,6,KKF_BOUNDSFACTOR, "kkf", "boundsfactor", 7, rated);
//		}
//		
//		data.clear();
//		data = prepareData(KKF_BOUNDSDISTANCE);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " kkf boundsdistance");
//			dbscanCluster(data,j,6,KKF_BOUNDSDISTANCE, "kkf", "initialboundsdistance", 8, rated);
//		}
//		
//		data.clear();
//		data = prepareData(KKF_OBSERVENOISECOVARIANCE);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " kkf obsnoisecov");
//			dbscanCluster(data,j,6,KKF_OBSERVENOISECOVARIANCE, "kkf", "observenoisecovariance", 9, rated);
//		}
//
//		data.clear();
//		data = prepareData(KKF_STATENOISECOVARIANCE);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " kkf statenoisecov");
//			dbscanCluster(data,j,6,KKF_STATENOISECOVARIANCE, "kkf", "statenoisecovariance", 10, rated);
//		}
//
//		data.clear();
//		data = prepareData(KKF_STATENOISECOUPLING);
//		for (int i = 1; i < 20; i++) {
//			double j = i*0.01;
//			System.out.println("initializing another cluster with eps=" + j + " kkf statenoisecoup");
//			dbscanCluster(data,j,6,KKF_STATENOISECOUPLING, "kkf", "statenoisecoupling", 11, rated);
//		}
	}
	
	/**
	 * Uses a k-Means implementation to cluster the data from the given .csv file
	 * @param path: the path to the .csv file
	 * @param numberOfClusters: the number of clusters (k)
	 * @param algorithm: the name of the RDE algorithm (needed for output directory)
	 * @param parameter: the name of the parameter (needed for output directory)
	 * @throws Exception
	 */
	public static void kMeansCluster(String path, int numberOfClusters, String rdeAlgo, String parameter, int paramID, boolean rated) throws Exception {
		Dataset data = prepareData(path);
		//initialize clustering and export results
		SimpleKMeans skm = new SimpleKMeans();
		skm.setNumClusters(numberOfClusters);
		Clusterer jmlskm = new WekaClusterer(skm);
		Dataset[] results = jmlskm.cluster(data);
		mapInstanceToCluster(results);
		exportToCSV(results, header, numberOfClusters, "kMeans", rdeAlgo, parameter);
				
//		for (Dataset dataset : results) {
//			if (Double.isNaN(dataset.get(0).value(0))) {
//				for (Instance instance : dataset) {
//					instance.removeAttribute(0);
//				}
//			}
//		}
		
		if(rated) {
			double score = calculateSilhouette(results);
			KMeansResult result = new KMeansResult(numberOfClusters, score, results, rdeAlgo, parameter, header, instanceToFeatureVector);
			listOfResults.get(paramID).add(result);
		}
		//since we are using a static map, we need to clear it after every iteration
		//TODO: das nervt...
		instanceToFeatureVector = new LinkedHashMap<Instance, List<Double>>();
	}
	
	public static void dbscanCluster(double eps, int minPts, String path, String rdeAlgo, String parameter, int paramID, boolean rated) throws Exception {
		Dataset data = readIn(path);
		System.out.println("now watching: " + rdeAlgo + " " + parameter + " eps = " + eps + " minPts = " + minPts);
		String header = extractHeader(data);
		data.remove(0);
		data = extractFeatureVector(data);
		calculateDistances(data);
		//initialize clustering and export results
		DensityBasedSpatialClustering dbscan = new DensityBasedSpatialClustering(eps, minPts);
		Dataset[] results = dbscan.cluster(data);
		mapInstanceToCluster(results);
//		exportToCSV(results, header, -1, "dbscan", rdeAlgo, parameter);
		
		//since we are using a static map, we need to clear it after every iteration
		instanceToFeatureVector = new LinkedHashMap<Instance, List<Double>>();
		
//		for (Dataset dataset : results) {
//			if (Double.isNaN(dataset.get(0).value(0))) {
//				for (Instance instance : dataset) {
//					instance.removeAttribute(0);
//				}
//			}
//		}
		
		if (rated) {
			double score = calculateSilhouette(results);
			DBSCANResult result = new DBSCANResult(eps, minPts, results.length, score, results, rdeAlgo, parameter);
			listOfResults.get(paramID).add(result);
		}
		
	}
	
	public static void dbscanCluster(Dataset data, double eps, int minPts, String rdeAlgo, String parameter, int paramID, boolean rated) throws Exception {
		
		//initialize clustering and export results
		DensityBasedSpatialClustering dbscan = new DensityBasedSpatialClustering(eps, minPts);
		Dataset[] results = dbscan.cluster(data);
		mapInstanceToCluster(results);
		exportToCSV(results, header, eps, "dbscan", rdeAlgo, parameter);
		
		//since we are using a static map, we need to clear it after every iteration
//		instanceToFeatureVector = new LinkedHashMap<Instance, List<Double>>();
		
//		for (Dataset dataset : results) {
//			if (Double.isNaN(dataset.get(0).value(0))) {
//				for (Instance instance : dataset) {
//					instance.removeAttribute(0);
//				}
//			}
//		}
		
		if (rated) {
			double score = calculateSilhouette(results);
			DBSCANResult result = new DBSCANResult(eps, minPts, results.length, score, results, rdeAlgo, parameter);
			listOfResults.get(paramID).add(result);
		}
		
	}
	
	private static void kMedoidsCluster(Dataset data, int k, String rdeAlgo, String parameter, int paramID, boolean rated) throws Exception {
		MyKMedoids km = new MyKMedoids(k);
		Dataset[] results = km.cluster(data, false);
		mapInstanceToCluster(results);
		exportToCSV(results, header, k, "kMedoids", rdeAlgo, parameter);
		
		if (rated) {
			double score = calculateSilhouette(results);
			KMedoidsResult result = new KMedoidsResult(k, score, results, rdeAlgo, parameter);
			System.out.println(result);
			listOfResults.get(paramID).add(result);
		}
		
		//since we are using a static map, we need to clear it after every iteration
		instanceToFeatureVector = new LinkedHashMap<Instance, List<Double>>();
	}
	
	public static Dataset prepareData(String path) throws IOException {
		Dataset data = readIn(path);
		header = extractHeader(data);
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
	
	private static Dataset readIn(String path) throws IOException {
		System.out.println("reading new file...");
		Dataset data = FileHandler.loadDataset(new File(path), ";");
		return data;
	}
	
	private static String extractHeader(Dataset data) {
		//extract header
		String header = "";
		for (double value : data.get(0)) {
			header += value + ";";
		}
		header += System.lineSeparator();
		return header;
	}
	
	private static Dataset extractFeatureVector(Dataset data) {
		//extract and remove feature vector
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
	
	/**
	 * printing the results to the outputpath
	 * @param datasets
	 * @param header
	 * @param numberOfClusters
	 * @param algorithm
	 * @param parameter
	 * @throws IOException
	 */
	public static void exportToCSV(Dataset[] datasets, String header, double numberOfClusters, String clusterAlgo, String rdeAlgo, String parameter) throws IOException {
		System.out.println("starting export");
		for (int i = 0; i < datasets.length; i++) {
			String outputpath = String.format("C:\\Users\\Karsten\\Desktop\\Bachelor Arbeit\\FeatureCluster\\%s\\%s\\%s\\%sclusters", rdeAlgo, parameter, clusterAlgo, numberOfClusters);
			exportSingleCluster(datasets[i], header, outputpath, i+1);
		}
		
	}
	
	public static void exportSingleCluster(Dataset dataset, String header, String outputpath, int numberOfClusters) throws IOException{
//		System.out.println("writing another cluster...");
		File outputDirectory = new File(outputpath);
		if (!outputDirectory.exists()) {
			outputDirectory.mkdirs();
		}
		outputpath = String.format(outputpath + "\\%s.csv", numberOfClusters);
		List<String> cluster = new ArrayList<>();
		for (Instance instance : dataset) {
			for (Double val : instance.values()) {
				cluster.add(val.toString());
				cluster.add(";");
			}
//			List<Double> featureVector = instanceToFeatureVector.get(instance);
//			for (Double d : featureVector) {
//				cluster.add(d.toString());
//				cluster.add(";");
//			}
			cluster.add(System.lineSeparator());
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputpath));
		StringBuilder builder = new StringBuilder();
		builder.append(header);
		for (String s : cluster) {
			builder.append(s);
		}
		writer.write(builder.toString());
		writer.close();
	}
	
	private static void instantiateListOfResults(int numOfIterations) {
		for (int i = 0; i < numOfIterations; i++) {
			List<IClusterResult> tmp = new ArrayList<>();
			listOfResults.add(tmp);
		}
	}
	
	private static List<IClusterResult> evaluate() {
		List<IClusterResult> result = new ArrayList<>();
		for (List<IClusterResult> list : listOfResults) {
			IClusterResult bestValue = list.get(0);
			for (IClusterResult r : list) {
				if (r.getScore() > bestValue.getScore()) {
					bestValue = r;
				}
			}
			result.add(bestValue);
		}
		return result;
	}
	
	public static double calculateSilhouette(Dataset[] datasets) {
		double result = 0;
//		System.out.println("Silh: number of clusters = " + instanceToCluster.size());
		for (Map.Entry<Instance, Dataset> entry : instanceToCluster.entrySet()) {
			Dataset cluster = entry.getValue();
			Instance inst = entry.getKey();
			double a = calculateDistance(cluster, inst);
			double b = Double.MAX_VALUE;
//			System.out.println("Silh: number of clusters in dataset = " + datasets.length);
			for (Dataset alienCluster : datasets) {
				if (!alienCluster.equals(cluster)) {
					double tmp = calculateDistance(alienCluster, inst);
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
		double x = result/instanceToCluster.size();
		double y = instanceToCluster.size();
		System.out.println("Silhouette of whole Clustering= " + x + " for k= " + datasets.length);
		return x;
	}
	
	private static double calculateDistance(Dataset cluster, Instance instance) {
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
	
	private static void mapInstanceToCluster(Dataset[] datasets) {
		LinkedHashMap<Instance,Dataset> tmpCluster = new LinkedHashMap<>();
		for (Dataset dataset : datasets) {
			for (Instance instance : dataset) {
				tmpCluster.put(instance, dataset);
			}
		}
		instanceToCluster = tmpCluster;
	}
	
	public static double[][] calculateDistances(Dataset dataset) {
		System.out.println("calculating distance table...");
		double[][] result = new double[dataset.size()][dataset.size()];
//		LinkedHashMap<Instance,Dataset> tmpCluster = new LinkedHashMap<>();
		LinkedHashMap<Instance,Integer> tmpID = new LinkedHashMap<>();
		
		//fill HashMap Instance -> Cluster and Instance -> ID
		for (int i = 0; i < dataset.size(); i++) {
//			tmpCluster.put(dataset.get(i), dataset);
			if (tmpID.containsKey(dataset.get(i))) {
			}
			tmpID.put(dataset.get(i), i);
		}

		//fill distanceTable
		for (int column = 0; column < dataset.size(); column++) {
			NormalizedEuclideanDistance dist = new NormalizedEuclideanDistance(dataset);
			for (int row = column; row < dataset.size(); row++) {
//				System.out.println("Distance between Inst " + column + " and " + row + " = " + dist.calculateDistance(dataset.get(row), dataset.get(column)));
				result[column][row] = dist.calculateDistance(dataset.get(row), dataset.get(column));
				result[row][column] = result[column][row];
			}
		}
//		instanceToCluster = tmpCluster;
		instanceToID = tmpID;
		distanceTable = result;
		return result;
	}
	
	private static String distancesToString() {
		StringBuilder result = new StringBuilder();
		for (int col = 0; col < distanceTable.length; col++) {
			for (int row = 0; row < distanceTable[col].length; row++) {
				result.append(distanceTable[row][col] + ";");
			}
			result.append(System.lineSeparator());
		}
		return result.toString();
	}
	
	private static String featureHeader() {
		StringBuilder sb = new StringBuilder();
		sb.append("numberOfRessources;");
		sb.append("numberOfWorkloadClasses;");
		sb.append("varianceInflationFactor;");
		sb.append("utilizationArtihmeticMean;");
		sb.append("utilizationGeometricMean;");
		sb.append("utilizationStandardDeviation;");
		sb.append("minimumUtilization;");
		sb.append("maximumUtilization;");
		sb.append("utilizationAutoCorrelation;");
		sb.append("utilizationDistribution;");
		
		//the following features exist per workloadClass
		for (int i = 0; i < 3; i++) {
			sb.append("responseTimeArithmeticMean;");
			sb.append("responseTimeGeometricMean;");
			sb.append("responseTimeStandardDeviation;");
			sb.append("minimumResponseTime;");
			sb.append("maximumResponseTime;");
			sb.append("responseTimeAutoCorrelation;");
			sb.append("responseTimeDistribution;");
			sb.append("arrivalRateArithmeticMean;");
			sb.append("arrivalRateGeometricMean;");
			sb.append("arrivalRateStandardDeviation;");
			sb.append("minimumArrivalRate;");
			sb.append("maximumArrivalRate;");
			sb.append("arrivalRateAutoCorrelation;");
			sb.append("arrivalRateDistribution;");
		}
		return sb.toString();
	}
	
}