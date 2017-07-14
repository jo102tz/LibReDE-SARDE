package tools.descartes.librede.rrde.optimization.algorithm;

import java.util.List;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import tools.descartes.librede.configuration.EstimationSpecification;

public interface IClusterer {
	
	/**
	 * Clusters the given Dataset specified in the constructor.
	 * @return clustering result. Each cluster is represented by a Dataset.
	 */
	public Dataset[] cluster();
	/**
	 * Returns the cluster results found by method above
	 * @return
	 */
	public Dataset[] getResults();
	/**
	 * 
	 * @return the mean instances
	 */
	public List<Instance> getMeans();
	/**
	 * 
	 * @return the feature vectors of the mean instances.
	 */
	public List<List<Double>> getMeanFeatures();
	/**
	 * The coefficients found by OLS.
	 * @return coefficients
	 */
	public double[] getCoefficients();
	/**
	 * 
	 * @return
	 * 		EstimationSpecification
	 */
	public EstimationSpecification getSpecification();
	/**
	 * Header values needed for optimum value specification.
	 * @return
	 */
	public List<Double> getHeader();

}
