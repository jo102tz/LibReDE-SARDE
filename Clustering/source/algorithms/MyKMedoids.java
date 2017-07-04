package algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Stream;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.DistanceMeasure;
import net.sf.javaml.distance.ManhattanDistance;
import net.sf.javaml.distance.fastdtw.util.Arrays;

public class MyKMedoids implements Clusterer{

	private DistanceMeasure dist;
	private int k;
	
	public MyKMedoids(int k) {
		this.dist = new ManhattanDistance();
		this.k = k;
	}
	
	public MyKMedoids(int k, DistanceMeasure dist) {
		if (!dist.equals(new ManhattanDistance())) {
			System.out.println("WARNING: the used distance measure should be manhattan distance");
		}
		this.dist = dist;
		this.k = k;
	}
	
	public Dataset[] cluster(Dataset data) {
		return cluster(data, false);
	}
	
	/** 
	 * Uses a variant of k-Medoids. The quality of result is highly dependent on
	 * the initial medoids, which can be chosen randomly, and (if so) can vary between consequent 
	 * calls of this method.
	 * @param data
	 * @return the found clusters
	 */
	public Dataset[] cluster(Dataset data, boolean randomInit) {
		Dataset[] clusters;
		Instance[] medoids = new Instance[k];
		if(randomInit) {
			int[] picked = new int[k];
//		choose k random medoids
			for (int i = 0; i < k; i++) {
				int index;
				do {
					Random rand = new Random(System.currentTimeMillis());
					index = rand.nextInt(data.size());
				} while (Arrays.contains(picked, index));
				picked[i] = index;
				medoids[i] = data.get(index);
			}
		} else {
			medoids = selectInitialMedoids(data, k);
		}
		//repeat until not changing: assign each instance to its nearest medoid and recalculate medoids. 
		clusters = assign(data, medoids);
		while(recalculateMedoids(data, clusters, medoids)) {
			clusters = assign(data, medoids);
		}
		return clusters;
	}
	
	private Instance[] selectInitialMedoids(Dataset data, int k) {
		Instance[] result = new Instance[k];
		HashMap<Instance, Double> map = new HashMap<>();
		for (Instance inst : data) {
			double v = calculateSingleV(data, inst);
			map.put(inst, v);
		}
		Stream<Map.Entry<Instance,Double>> sorted =
			    map.entrySet().stream()
			       .sorted(Map.Entry.comparingByValue()).limit(k);
		Iterator<Entry<Instance, Double>> iter = sorted.iterator();
		for(int i = 0; i < k; i++) {
			result[i] = iter.next().getKey();
		}
		return result;
	}
	
	private double calculateSingleV(Dataset data, Instance inst) {
		double sum = 0;
		for (Instance instance2 : data) {
			double x = dist.measure(inst, instance2);
			double y = calculateSingleCost(data, instance2);
			sum += x/y;
		}
		return sum;
	}
	
	/**
	 * assigns each instance to the cluster with the closest mean
	 * @param data
	 * @param clusters
	 * @param medoids
	 * @return the sum of distances of every instance to its closest mean
	 */
	private Dataset[] assign(Dataset data, Instance[] medoids) {
		Dataset[] clusters = new Dataset[k];
		for (int i = 0; i < k; i++) {
			Dataset d = new DefaultDataset();
			clusters[i] = d;
		}
		for (Instance instance : data) {
			int bestMedoid = 0;
			double bestDist = Double.MAX_VALUE;
			for (int i = 0; i < k; i++) {
				double distance = dist.measure(instance, medoids[i]);
				if (distance < bestDist) {
					bestDist = distance;
					bestMedoid = i;
				}
			}
			clusters[bestMedoid].add(instance);
		}
		return clusters;
	}
	
	private double calculateSingleCost(Dataset cluster, Instance medoid) {
		double result = 0;
		for (int i = 0; i < cluster.size(); i++) {
			result += dist.measure(cluster.get(i), medoid);
		}
		return result;
	}
	
	private double calculateTotalCost(Dataset[] clusters, Instance[] medoids) {
		double result = 0;
		for (int i = 0; i < k; i++) {
			result += calculateSingleCost(clusters[i], medoids[i]);
		}
		return result;
	}
	
	private boolean recalculateMedoids(Dataset data, Dataset[] clusters, Instance[] medoids) {
		boolean changed = false;
		for (int i = 0; i < k; i++) {
			Instance bestMedoid = medoids[i];
			double bestCost = calculateSingleCost(clusters[i], bestMedoid);
			for (Instance instance : clusters[i]) {
				double tmpCost = calculateSingleCost(clusters[i], instance);
				if (tmpCost < bestCost) {
					bestCost = tmpCost;
					bestMedoid = instance;
					changed = true;
				}
			}
			medoids[i] = bestMedoid;
		}
		return changed;
	}
	
	private double[][] distanceTable(Dataset data) {
		double[][] result = new double[data.size()][data.size()];
		for (int column = 0; column < data.size(); column++) {
			for (int row = column; row < data.size(); row++) {
				result[column][row] = dist.measure(data.get(row), data.get(column));
				result[row][column] = result[column][row];
			}
		}
		return result;
	}

}
