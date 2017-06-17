package algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.evaluation.SumOfCentroidSimilarities;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClusterer;
import weka.clusterers.SimpleKMeans;

public class Main {
	
	public static String FILES_TO_WORK_WITH = "C:\\Users\\pc\\git\\ma\\tools.descartes.librede.rrde\\resources\\test\\validation\\output";
	
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

	private static HashMap<Instance, List<Double>> instanceToFeatureVector = new HashMap<Instance, List<Double>>();
	private static SortedMap<String, Double> rating = new TreeMap<>();
	private static HashMap<String, Integer> bestK = new HashMap<>();

	public static void main(String[] args) throws Exception{
		resetRating();
		
		for (int k=2; k < 7; k++) {
			kMeansCluster(WKF_STEP_WINDOW_REL, k, "wkf", "step_window_rel");
			kMeansCluster(WKF_BOUNDSFACTOR, k, "wkf", "boundsfactor");
			kMeansCluster(WKF_BOUNDSDISTANCE, k, "wkf", "initialboundsdistance");
			kMeansCluster(WKF_OBSERVENOISECOVARIANCE, k, "wkf", "observenoisecovariance");
			kMeansCluster(WKF_STATENOISECOVARIANCE, k, "wkf", "statenoisecovariance");
			kMeansCluster(WKF_STATENOISECOUPLING, k, "wkf", "statenoisecoupling");
			
			kMeansCluster(KKF_STEP_WINDOW_REL, k, "kkf", "step_window_rel");
			kMeansCluster(KKF_BOUNDSFACTOR, k, "kkf", "boundsfactor");
			kMeansCluster(KKF_BOUNDSDISTANCE, k, "kkf", "initialboundsdistance");
			kMeansCluster(KKF_OBSERVENOISECOVARIANCE, k, "kkf", "observenoisecovariance");
			kMeansCluster(KKF_STATENOISECOVARIANCE, k, "kkf", "statenoisecovariance");
			kMeansCluster(KKF_STATENOISECOUPLING, k, "kkf", "statenoisecoupling");
		}
		printRating();
	}
	
	/**
	 * Uses a k-Means implementation to cluster the data from the given .csv file
	 * @param path: the path to the .csv file
	 * @param numberOfClusters: the number of clusters (k)
	 * @param algorithm: the name of the RDE algorithm (needed for output directory)
	 * @param parameter: the name of the parameter (needed for output directory)
	 * @throws Exception
	 */
	public static void kMeansCluster(String path, int numberOfClusters, String rdeAlgo, String parameter) throws Exception {
//		System.out.println("reading new file...");
		Dataset data = FileHandler.loadDataset(new File(path), ";");
		//extract header
		String header = "";
		for (double value : data.get(0)) {
			header += value + ";";
		}
		header += System.lineSeparator();
		//remove header from data
		data.remove(0);
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
		//initialize clustering and export results
		SimpleKMeans skm = new SimpleKMeans();
		skm.setNumClusters(numberOfClusters);
		Clusterer jmlskm = new WekaClusterer(skm);
		Dataset[] results = jmlskm.cluster(data);
		exportToCSV(results, header, numberOfClusters, "kMeans", rdeAlgo, parameter);
		//since we are using a static map, we need to clear it after every iteration
		instanceToFeatureVector = new HashMap<Instance, List<Double>>();
		//we store the best value for 'k' in 'bestK' and the respective score in 'rating'
		SumOfCentroidSimilarities judge = new SumOfCentroidSimilarities();
		double score = judge.score(results);
		if (Double.isNaN(score)) {
			for (Dataset dataset : results) {
				System.out.println(dataset.get(0));
				dataset.remove(0);
				System.out.println(dataset.get(0));
			}
			score = judge.score(results);
		}
		System.out.println(Double.isNaN(score) + " k=" + numberOfClusters + " " + rdeAlgo + " " + parameter);
		if (rating.containsKey(rdeAlgo + " " + parameter)) {
			if (rating.get(rdeAlgo + " " + parameter) > score) {
				rating.put(rdeAlgo + " " + parameter, score);
				bestK.put(rdeAlgo + " " + parameter, numberOfClusters);
			}
		} else {
			rating.put(rdeAlgo + " " + parameter, score);
			bestK.put(rdeAlgo + " " + parameter, numberOfClusters);
		}
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
	public static void exportToCSV(Dataset[] datasets, String header, int numberOfClusters, String clusterAlgo, String rdeAlgo, String parameter) throws IOException {
		for (int i = 0; i < datasets.length; i++) {
			String outputpath = String.format("C:\\Users\\pc\\Desktop\\Bachelor Arbeit\\Trainingsdaten\\Results\\%s\\%s\\%s\\%sclusters", rdeAlgo, parameter, clusterAlgo, numberOfClusters);
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
			List<Double> featureVector = instanceToFeatureVector.get(instance);
			for (Double d : featureVector) {
				cluster.add(d.toString());
				cluster.add(";");
			}
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
	
	private static void resetRating() {
		rating = new TreeMap<>();
	}
	
	private static void printRating() {
		for (String key : rating.keySet()) {
			System.out.println("Optimal 'k' for " + key + " : " + bestK.get(key));
			System.out.println("Total Score: "+ rating.get(key));
		}
	}
}
