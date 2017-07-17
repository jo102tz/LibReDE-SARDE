package tools.descartes.librede.rrde.optimization.cluster;

import java.util.HashMap;

import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.optimization.algorithm.IConfigurationOptimizer;

public interface IClusterConfigurationOptimizer extends IConfigurationOptimizer{
	
	public HashMap<LibredeConfiguration, Double> confToOptimum();
	public IClusterer getClusterer();
	
}
