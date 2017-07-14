package tools.descartes.librede.rrde.optimization.algorithm;

import java.util.Map;

import tools.descartes.librede.configuration.LibredeConfiguration;

public interface IClusterConfigurationOptimizer extends IConfigurationOptimizer{
	
	public Map<LibredeConfiguration, Double> instanceToValue();
	public IClusterer getClusterer();
	
}
