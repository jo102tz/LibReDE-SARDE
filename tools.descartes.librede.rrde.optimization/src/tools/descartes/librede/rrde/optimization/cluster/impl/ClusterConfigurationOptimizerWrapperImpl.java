package tools.descartes.librede.rrde.optimization.cluster.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.optimization.impl.ClusterOptimizationSpecifierImpl;
import tools.descartes.librede.rrde.optimization.cluster.IClusterConfigurationOptimizer;
import tools.descartes.librede.rrde.optimization.cluster.IClusterConfigurationOptimizerWrapper;
import tools.descartes.librede.rrde.optimization.cluster.IClusterer;
import tools.descartes.librede.rrde.util.Util;

public class ClusterConfigurationOptimizerWrapperImpl implements IClusterConfigurationOptimizerWrapper {

	private IClusterer clusterer;
	private IClusterConfigurationOptimizer optimizer;
	private HashMap<LibredeConfiguration, Double> instanceToOptimum = new HashMap<>();
	
	//TODO: normale cluster funktionalität steht
	//TODO: feature cluster funktionalität implementieren!
		
	public boolean doWork(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier) {
		
		if (this.clusterer == null || clusterer.isParameterSupported(settings.getParametersToOptimize().get(0))) {
			init(estimation, input, settings, specifier);
		} else {
			ClusterOptimizationSpecifier spec = (ClusterOptimizationSpecifierImpl) specifier;
			if (spec.featureCluster()) {
				optimize(estimation, input, settings, specifier);
			} else {
				if (optimize(estimation, input, settings, specifier)) {
					this.instanceToOptimum = this.optimizer.confToOptimum();
					//TODO: setTargetValues so richtig?
					double value = instanceToOptimum.entrySet().iterator().next().getValue();
					Util.setValue(estimation, value, settings.getParametersToOptimize().get(0));
				}
			}
		}
		return true;
	}
	
	private void init(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier)
			throws IllegalArgumentException {
		
		if (!isSpecifierSupported(specifier)) {
			throw new IllegalArgumentException("Invalid specifier for clustering");
		}
		ClusterOptimizationSpecifier spec = (ClusterOptimizationSpecifierImpl) specifier;
		String clusterAlgoName = spec.getClusterAlgorithm();
		try {
			Class<?> c = Class.forName(clusterAlgoName);
			Constructor<?> constructor = c.getConstructor(EstimationSpecification.class, EList.class, OptimizationSettings.class, ClusterOptimizationSpecifier.class);
			this.clusterer = (IClusterer) constructor.newInstance(estimation, input, settings, spec);		
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			//TODO: logger?
			e.printStackTrace();
		}
		this.optimizer = new ClusterConfigurationOptimizer(clusterer);
		if (spec.featureCluster()) {
			if (optimize(estimation, input, settings, spec)) {
				//TODO: was jetzt? feature clustering wurde hier ausgeführt
			}
		} else {
			if (train(estimation, input, settings, spec)) {
				if (optimize(estimation, input, settings, spec)) {
					this.instanceToOptimum = this.optimizer.confToOptimum();
					//TODO: setTargetValues
				}
			}
		}
	}
	
	@Override
	public IClusterer getClusterer() {
		return clusterer;
	}

	@Override
	public void setClusterer(IClusterer clusterer) {
		this.clusterer = clusterer;
	}

	@Override
	public IClusterConfigurationOptimizer getOptimizer() {
		return optimizer;
	}

	@Override
	public void setOptimizer(IClusterConfigurationOptimizer optimizer) {
		this.optimizer = optimizer;
	}

	@Override
	public boolean train(EstimationSpecification estimation, EList<InputData> input, OptimizationSettings settings,
			ConfigurationOptimizationAlgorithmSpecifier specifier) {
		return clusterer.initExport();
	}

	@Override
	public boolean optimize(EstimationSpecification estimation, EList<InputData> input, OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier) {
		if (optimizer.optimizeConfiguration(estimation, input, settings, specifier)) {
			instanceToOptimum = optimizer.confToOptimum();
			return true;
		} else {
			//TODO: logger?
			return false;
		}

	}
	
	public boolean isSpecifierSupported(ConfigurationOptimizationAlgorithmSpecifier specifier) {
		if (specifier instanceof ClusterOptimizationSpecifier) {
			return true;
		}
		return false;
	}

	public HashMap<LibredeConfiguration, Double> getInstanceToOptimum() {
		return instanceToOptimum;
	}

	@Override
	public boolean optimizeConfiguration(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier)
			throws IllegalArgumentException {
		return doWork(estimation, input, settings, specifier);
	}

	@Override
	public EstimationSpecification getResult() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSimpleName() {
		// TODO Auto-generated method stub
		return null;
	}

}
