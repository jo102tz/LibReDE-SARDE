package tools.descartes.librede.rrde.optimization.cluster;

import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.optimization.algorithm.IConfigurationOptimizer;

public interface IClusterConfigurationOptimizerWrapper extends IConfigurationOptimizer{
	
	public IClusterer getClusterer();
	public void setClusterer(IClusterer clusterer);
	public IClusterConfigurationOptimizer getOptimizer();
	public void setOptimizer(IClusterConfigurationOptimizer optimizer);
	public boolean train(EstimationSpecification estimation, EList<InputData> input, OptimizationSettings settings,
			ConfigurationOptimizationAlgorithmSpecifier specifier);
	public boolean optimize(EstimationSpecification estimation, EList<InputData> input, OptimizationSettings settings,
			ConfigurationOptimizationAlgorithmSpecifier specifier);

}