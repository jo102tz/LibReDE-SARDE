package tools.descartes.librede.rrde.optimization.algorithm.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.GenericParameter;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.util.extract.ClusterFeatureExtractor;

public class ClusterExportAlgorithm extends ExportAlgorithm {
	
	private final Logger log = Logger.getLogger(ClusterExportAlgorithm.class);

//	public ClusterExportAlgorithm() {
//		super();
//	}

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
			s.writeString("numverOfWorkloadClasses");
			s.writeString("varianceInflationFactor");
			s.writeString("utilizationArtihmeticMean");
			s.writeString("utilizationGeometricMean");
			s.writeString("utilizationStandardDeviation");
			s.writeString("minimumUtilization");
			s.writeString("maximumUtilization");
			s.writeString("utilizationAutoCorrelation");
			s.writeString("utilizationDistribution");
			s.writeString("responseTimeArithmeticMean");
			s.writeString("responseTimeGeometricMean");
			s.writeString("responseTimeStandardDeviation");
			s.writeString("minimumResponseTime");
			s.writeString("maximumResponseTime");
			s.writeString("responseTimeAutoCorrelation");
			s.writeString("responseTimeDistribution");
			s.writeString("arrivalRateArithmeticMean");
			s.writeString("arrivalRateGeometricMean");
			s.writeString("arrivalRateStandardDeviation");
			s.writeString("minimumArrivalRate");
			s.writeString("maximumArrivalRate");
			s.writeString("arrivalRateAutoCorrelation");
			s.writeString("arrivalRateDistribution");
			s.newLine();
			
			ClusterFeatureExtractor ex = new ClusterFeatureExtractor();
			// split for configurations
			for (LibredeConfiguration conf : original) {
				getConfs().clear();
				getConfs().add(conf);
				for (double i = param.getLowerBound(); i <= param.getUpperBound(); i += settings().getStepSize()) {
					setTargetValue(param, i);
					runIteration();
					s.writeError(getLastError());
				}
				// add feature vector here
				FeatureVector fv = ex.extractFeatures(conf);
				s.writeDouble(fv.getNumberOfRessources());
				s.writeDouble(fv.getNumberOfWorkloadClasses());
				s.writeDouble(fv.getVarianceInflationFactor());
				StatisticalFeatures features = fv.getUtilizationStatistics().get(0);
				writeFeatures(s, features);
				for (int i = 0; i < 3; i++) {
					if (fv.getResponseTimeStatistics().size() <= i) {
						writeZeros(s);
					} else {
						features = fv.getResponseTimeStatistics().get(i);
						writeFeatures(s, features);
					}
					if (fv.getArrivalRateStatistics().size() <= i) {
						writeZeros(s);
					} else {
						features = fv.getArrivalRateStatistics().get(i);
						writeFeatures(s, features);
					}
				}
				s.newLine();
			}
			getConfs().clear();
			getConfs().addAll(original);

		}

		// set to default again
		setTargetValue(param, param.getStartValue());

		s.close();
	}

	private void writeFeatures(FileExporter s, StatisticalFeatures features) {
		s.writeDouble(features.getArithmeticMean());
		s.writeDouble(features.getGeometricMean());
		s.writeDouble(features.getStandardDeviation());
		s.writeDouble(features.getMinimum());
		s.writeDouble(features.getMaximum());
		s.writeDouble(features.getAutocorrelation());
		s.writeDouble(features.getIsNormalDistributed());
	}

	private void writeZeros(FileExporter s) {
		s.writeDouble(-1);
		s.writeDouble(-1);
		s.writeDouble(-1);
		s.writeDouble(-1);
		s.writeDouble(-1);
		s.writeDouble(-1);
		s.writeDouble(-1);
	}

}
