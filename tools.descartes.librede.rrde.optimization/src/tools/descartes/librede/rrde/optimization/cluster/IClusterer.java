package tools.descartes.librede.rrde.optimization.cluster;

import java.util.HashMap;
import java.util.List;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;

public interface IClusterer {
	
	public boolean initExport();
	
	/**
	 * Clusters the given Dataset specified in the constructor.
	 * @return clustering result. Each cluster is represented by a Dataset.
	 */
	public Dataset[] cluster();
	/**
	 * Method for clustering based on features. The coefficients are not calculated dynamically and have to 
	 * be set first.
	 * @return
	 * 		A List containing Lists of {@link LibredeConfiguration}. 
	 * 		Every sublist represents one cluster.
	 */
	public List<List<LibredeConfiguration>> featureCluster();
	/**
	 * Returns the cluster results found by {@link cluster()}
	 * @return
	 */
	public Dataset[] getResults();
	
	public List<List<LibredeConfiguration>> getConfResult();

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
	public void setCoefficients(double[] coefficients);
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
	/**
	 * This method should be called before querying the results.
	 * @return
	 * 		'false' if the clustering is not yet finished,
	 * 		'true' else.
	 */
	public boolean finishedCalculation();
	/**
	 * Compares the given {@link IOptimizableParameter} to the parameter stored in the Clusterer.
	 * @return
	 * 		'false' if parameters differ,
	 * 		'true' else.
	 */
	public boolean isParameterSupported(IOptimizableParameter parameter);
	
	public int getNumberOfFeatures();
	
	public List<Double> getFeatures();
	
	public HashMap<Instance,LibredeConfiguration> getInstanceToConf();

}
