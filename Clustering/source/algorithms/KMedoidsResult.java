package algorithms;

import java.util.LinkedHashMap;
import java.util.List;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;

public class KMedoidsResult implements IClusterResult {

	private int k;
	private double score;
	private Dataset[] datasets;
	private String rdeAlgo;
	private String parameter;
	private String header = "no header specified";
	private LinkedHashMap<Instance, List<Double>> instFeatVec;
	
	public KMedoidsResult(int k, double score, Dataset[] datasets, String rdeAlgo, String parameter) {
		this.k = k;
		this.score = score;
		this.datasets = datasets;
		this.rdeAlgo = rdeAlgo;
		this.parameter = parameter;
	}
	
	public KMedoidsResult(int k, double score, Dataset[] datasets, String rdeAlgo, String parameter, String header, LinkedHashMap<Instance, List<Double>> instFeatVec) {
		this.k = k;
		this.score = score;
		this.datasets = datasets;
		this.rdeAlgo = rdeAlgo;
		this.parameter = parameter;
		this.header = header;
		this.instFeatVec = instFeatVec;
	}
	
	public LinkedHashMap<Instance, List<Double>> getInstFeatVec() {
		return instFeatVec;
	}
	
	public String getHeader() {
		return header;
	}
	
	public int getNumClusters() {
		return k;
	}
	
	public double getScore() {
		return score;
	}
	
	public Dataset[] getDatasets() {
		return datasets;
	}
	
	public String getRdeAlgo() {
		return rdeAlgo;
	}
	
	public String getParameter() {
		return parameter;
	}

	@Override
	public String toString() {
		return "KMedoidsResult [k=" + k + ", score=" + score + ", rdeAlgo="
				+ rdeAlgo + ", parameter=" + parameter + "]";
	}


}
