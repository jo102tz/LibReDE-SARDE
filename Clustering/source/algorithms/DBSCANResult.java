package algorithms;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;

public class DBSCANResult implements IClusterResult {
	
	private final double epsilon;
	private final int minPts;
	private int numClusters;
	private double score;
	private Dataset[] datasets;
	private String rdeAlgo;
	private String parameter;
	private String header;
	
	public DBSCANResult(double epsilon, int minPts, int numClusters, double score, Dataset[] datasets, String rdeAlgo, String parameter) {
		this.epsilon = epsilon;
		this.minPts = minPts;
		this.numClusters = numClusters;
		this.score = score;
		this.datasets = datasets;
		this.rdeAlgo = rdeAlgo;
		this.parameter = parameter;
	}
	
	public DBSCANResult(double epsilon, int minPts, int numClusters, double score, Dataset[] datasets, String rdeAlgo, String parameter, String header) {
		this.epsilon = epsilon;
		this.minPts = minPts;
		this.numClusters = numClusters;
		this.score = score;
		this.datasets = datasets;
		this.rdeAlgo = rdeAlgo;
		this.parameter = parameter;
		this.header = header;
	}


	@Override
	public String toString() {
		return "DBSCANResult [epsilon=" + epsilon + ", minPts=" + minPts + ", numClusters=" + numClusters + ", score="
				+ score + ", rdeAlgo=" + rdeAlgo + ", parameter="
				+ parameter + "]";
	}

	public String getHeader() {
		return header;
	}
	
	public LinkedHashMap<Instance, List<Double>> getInstFeatVec() {
		return null;
	}
	
	@Override
	public int getNumClusters() {
		return numClusters;
	}

	@Override
	public double getScore() {
		return score;
	}

	@Override
	public Dataset[] getDatasets() {
		return datasets;
	}

	@Override
	public String getRdeAlgo() {
		return rdeAlgo;
	}

	@Override
	public String getParameter() {
		return parameter;
	}

}
