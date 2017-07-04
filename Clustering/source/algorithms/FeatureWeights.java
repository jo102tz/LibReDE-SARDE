package algorithms;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import net.sf.javaml.core.Instance;
import smile.regression.OLS;

public class FeatureWeights {
	
	private final double[][] distanceTable;
	private LinkedHashMap<Instance, List<Double>> instanceToFeatureVector;
	
	public FeatureWeights(double[][] distanceTable, LinkedHashMap<Instance, List<Double>> instanceToFeatureVector) {
		this.distanceTable = distanceTable;
		this.instanceToFeatureVector = instanceToFeatureVector;
	}
	
	public double[] learnCoefficients() {
		double[][] x = createFeatureDistances();
		double[] y = appendDistanceTable();
		OLS ols = new OLS(x,y);
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
	
	private double[][] extractFeatureVectorAsArray() {
		double[][] result = new double[instanceToFeatureVector.size()][instanceToFeatureVector.values().iterator().next().size()];
		int count = 0;
		for (Entry<Instance, List<Double>> entry : instanceToFeatureVector.entrySet()) {
			List<Double> val = entry.getValue();
			double[] tmp = new double[val.size()];
			for (int i = 0; i < val.size(); i++) {
				tmp[i] = val.get(i);
			}
			result[count] = tmp;
			count++;
		}
		return result;
	}
	
	private double[][] createFeatureDistances() {
		int count = 0;
		double[][] result = new double[instanceToFeatureVector.size()*instanceToFeatureVector.size()][instanceToFeatureVector.values().iterator().next().size()];
		for (Entry<Instance, List<Double>> entry : instanceToFeatureVector.entrySet()) {
			List<Double> val = entry.getValue();
			double[] valArr = convertListToArray(val);
			for (Entry<Instance, List<Double>> entry2 : instanceToFeatureVector.entrySet()) {
				List<Double> val2 = entry2.getValue();
				double[] valArr2 = convertListToArray(val2);
				result[count] = calculateFeatureDistance(valArr, valArr2);
				count++;
			}
		}
		return result;
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

}
