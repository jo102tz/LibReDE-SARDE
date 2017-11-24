package tools.descartes.librede.rrde.model.editor.util;

import java.util.HashMap;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.model.optimization.RunCall;

public class InputDataRegistry {

	public static final InputDataRegistry INSTANCE = new InputDataRegistry();

	private int optimizationInputDataCounter = 1;
	private int recommendationInputDataCounter = 1;
	private int runCallCounter = 1;
	private int estimationCounter = 1;
	private HashMap<InputData, String> optInputDataName = new HashMap<InputData, String>();
	private HashMap<InputData, String> recInputDataName = new HashMap<InputData, String>();
	private HashMap<RunCall, String> runCallName = new HashMap<RunCall, String>();
	private HashMap<EstimationSpecification, String> estimationSpecName = new HashMap<EstimationSpecification, String>();

	private InputDataRegistry() {

	}

	public void registerOptimizationInputData(InputData input) {
		if (!optInputDataName.containsKey(input)) {
			optInputDataName.put(input, "Optimization Input Data " + String.valueOf(optimizationInputDataCounter));
			optimizationInputDataCounter += 1;
		}
	}

	public void registerRecommendationInputData(InputData input) {
		if (!recInputDataName.containsKey(input)) {
			recInputDataName.put(input, "Recommendation Input Data " + String.valueOf(recommendationInputDataCounter));
			recommendationInputDataCounter += 1;
		}
	}

	public void deleteInputDataValue(InputData input) {
		optInputDataName.remove(input);
		recInputDataName.remove(input);
	}

	public String getLabelFromInputData(InputData input) {
		return (optInputDataName.containsKey(input)) ? optInputDataName.get(input) : recInputDataName.get(input);
	}

	public void registerRunCall(RunCall call) {
		if (!runCallName.containsKey(call)) {
			if (call.getAlgorithm() instanceof DataExportSpecifier)
				runCallName.put(call, "Data Export Specifier " + String.valueOf(runCallCounter));
			else if (call.getAlgorithm() instanceof IterativeParameterOptimizerSpecifier)
				runCallName.put(call, "Iterative Export Specifier " + String.valueOf(runCallCounter));
			else if (call.getAlgorithm() instanceof LocalSearchSpecifier)
				runCallName.put(call, "Local Search Specifier " + String.valueOf(runCallCounter));
			runCallCounter += 1;
		}
	}

	public void deleteRunCallValue(RunCall call) {
		runCallName.remove(call);
	}

	public String getLabelFromRunCall(RunCall call) {
		return runCallName.get(call);
	}

	public void registerEstimationSpecification(EstimationSpecification spec) {
		if (!estimationSpecName.containsKey(spec)) {
			estimationSpecName.put(spec, "Estimation Specification " + String.valueOf(estimationCounter));
			estimationCounter += 1;
		}
	}
	
	public void deleteEstimationValue(EstimationSpecification spec) {
		estimationSpecName.remove(spec);
	}
	
	public String getLabelFromEstimationSpec(EstimationSpecification spec) {
		return estimationSpecName.get(spec);
	}
}
