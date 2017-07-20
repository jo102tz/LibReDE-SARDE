package tools.descartes.librede.rrde.optimization.cluster.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.GenericParameter;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.optimization.algorithm.impl.ExportAlgorithm;
import tools.descartes.librede.rrde.util.extract.ClusterFeatureExtractor;

public class ClusterExportAlgorithm extends ExportAlgorithm {
	
	private HashMap<Instance,LibredeConfiguration> instanceToConf = new HashMap<>();
	private LinkedHashMap<Instance,List<Double>> instanceToFeatureVector = new LinkedHashMap<>();
	private Dataset data = new DefaultDataset();
	
	protected void exportSingleParameter(IOptimizableParameter param) {
		String paramname = param.getClass().getSimpleName();
		if (param instanceof GenericParameter) {
			paramname = ((GenericParameter) param).getParameter().getName();
		}
		if (param instanceof StepSizeRelWindow) {
			paramname = "StepSize_relative" + ((StepSizeRelWindow) param).getProductMaxValue();
		}
		FileExporter s = new FileExporter(settings().getOutputDirectory(),
				getSimpleApproachName() + "_" + paramname + ".csv");
		if (!settings().isSplitConfigurations()) {
			for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings().getStepSize()) {
				s.writeDouble(i);
				setTargetValue(param, i);
				runIteration();
				s.writeError(getLastError());
				s.newLine();
			}
		} else {
			Set<LibredeConfiguration> original = new HashSet<LibredeConfiguration>(getConfs());
			// write header
			for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings().getStepSize()) {
				s.writeDouble(i);
			}
			// extend header with features
			s.writeString("numberOfRessources");
			s.writeString("numberOfWorkloadClasses");
			s.writeString("varianceInflationFactor");
			s.writeString("utilizationArtihmeticMean");
			
			s.newLine();
			
			ClusterFeatureExtractor ex = new ClusterFeatureExtractor();
			// split for configurations
			for (LibredeConfiguration conf : original) {
				getConfs().clear();
				getConfs().add(conf);
				double[] array = new double[0];
				for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings().getStepSize()) {
					setTargetValue(param, i);
					runIteration();
					s.writeError(getLastError());
					if (!Double.isNaN(getLastError())) {
						double[] tmpArray = {getLastError()};
						double[] concat = (double[]) ArrayUtils.addAll(array, tmpArray);
						array = concat;
					}
				}
				Instance instance = new DenseInstance(array);
				instanceToConf.put(instance, conf);
				data.add(instance);
				// add feature vector here
				FeatureVector fv = ex.extractFeatures(conf);
				s.writeDouble(fv.getNumberOfRessources());
				s.writeDouble(fv.getNumberOfWorkloadClasses());
				s.writeDouble(fv.getVarianceInflationFactor());
				s.writeDouble(fv.getUtilizationStatistics().get(0).getArithmeticMean());
				s.newLine();
				List<Double> featureVector = new ArrayList<>();
				featureVector.add((double) fv.getNumberOfRessources());
				featureVector.add((double) fv.getNumberOfWorkloadClasses());
				featureVector.add(fv.getVarianceInflationFactor());
				featureVector.add(fv.getUtilizationStatistics().get(0).getArithmeticMean());
				instanceToFeatureVector.put(instance, featureVector);
			}
			getConfs().clear();
			getConfs().addAll(original);

		}

		// set to default again
		setTargetValue(param, param.getStartValue());

		s.close();
	}
	
	public Dataset getData() {
		return data;
	}
	
	public HashMap<Instance,LibredeConfiguration> getInstanceToConf() {
		return instanceToConf;
	}
	
	public LinkedHashMap<Instance, List<Double>> getInstanceToFeatureVector() {
		return instanceToFeatureVector;
	}
	
	@Override
	public boolean isSpecifierSupported(
			ConfigurationOptimizationAlgorithmSpecifier specifier) {
		if (specifier == null)
			return false;
		if (specifier instanceof DataExportSpecifier || specifier instanceof ConfigurationOptimizationAlgorithmSpecifier) {
			return true;
		}
		return false;
	}
}
