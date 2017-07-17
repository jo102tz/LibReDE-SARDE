package tools.descartes.librede.rrde.optimization.cluster.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.NormalizedEuclideanDistance;
import smile.regression.OLS;

public class FeatureWeights {
	
	private final double[][] distanceTable;
	private LinkedHashMap<Instance, List<Double>> instanceToFeatureVector;
	private Dataset data;
	private double[][] featureDistances;
	
	public FeatureWeights(Dataset data, LinkedHashMap<Instance, List<Double>> instanceToFeatureVector) {
		this.data = data;
		this.instanceToFeatureVector = instanceToFeatureVector;
		this.featureDistances = new double[instanceToFeatureVector.size()*instanceToFeatureVector.size()][instanceToFeatureVector.values().iterator().next().size()];
		this.distanceTable = calculateDistances(this.data);
	}
	
	public double[] learnCoefficients() {
		System.out.println("starting to calculate coefficients");
		double[][] x = featureDistances;
		double[] y = appendDistanceTable();
		OLS ols = new OLS(x,y);
		System.out.println("done calculating coefficients");
		return ols.coefficients();
	}

	private double[] appendDistanceTable() {
		double[] result = new double[0];
		for (double[] d : distanceTable) {
			result = concat(result,d);
		}
		return result;
	}

	private double[] concat(double[] a, double[] b) {
		int aLen = a.length;
		int bLen = b.length;
		double[] c= new double[aLen+bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}
	
	private double[] calculateFeatureDistance(double[] a, double[] b) {
		double[] result = new double[a.length];
		if (a.equals(b)) {
			Arrays.fill(result, 0);
			return result;
		}
		for (int i = 0; i < a.length; i++) {
			result[i] = Math.abs(a[i]-b[i]);
		}
		return result;
	}
	
	private double[] convertListToArray(List<Double> list) {
		double[] result = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public double[][] calculateDistances(Dataset dataset) {
		double[][] result = new double[dataset.size()][dataset.size()];
		for (int column = 0; column < dataset.size(); column++) {
			NormalizedEuclideanDistance dist = new NormalizedEuclideanDistance(dataset);
			for (int row = column; row < dataset.size(); row++) {
				result[column][row] = dist.calculateDistance(dataset.get(row), dataset.get(column));
				result[row][column] = result[column][row];
			}
		}
		
		for (int first = 0; first < dataset.size(); first++) {
			for (int second = 0; second < dataset.size(); second++) {
				int pos = (first*dataset.size())+second;
				Instance firstInst = dataset.get(first);
				Instance secInst = dataset.get(second);
				List<Double> firstVector = instanceToFeatureVector.get(firstInst);
				List<Double> secVector = instanceToFeatureVector.get(secInst);
				double[] a = convertListToArray(firstVector);
				double[] b = convertListToArray(secVector);
				featureDistances[pos] = calculateFeatureDistance(a, b);
			}
		}
		return result;
	}
}
