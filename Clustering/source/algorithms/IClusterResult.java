package algorithms;

import java.util.LinkedHashMap;
import java.util.List;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;

public interface IClusterResult {
	
	public int getNumClusters();
	public double getScore();
	public Dataset[] getDatasets();
	public String getRdeAlgo();
	public String getParameter();
	public String getHeader();
	public LinkedHashMap<Instance, List<Double>> getInstFeatVec();
}
