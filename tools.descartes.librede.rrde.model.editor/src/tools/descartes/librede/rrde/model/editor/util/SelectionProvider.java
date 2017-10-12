package tools.descartes.librede.rrde.model.editor.util;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.model.editor.forms.EstimationFormPage;
import tools.descartes.librede.rrde.model.editor.forms.EstimationRecommendationFormPage;
import tools.descartes.librede.rrde.model.editor.forms.ValidationFormPage;
import tools.descartes.librede.rrde.model.editor.forms.WorkloadDescriptionFormPage;
import tools.descartes.librede.rrde.model.editor.forms.details.FileTraceDetailsPage;
import tools.descartes.librede.rrde.model.editor.forms.master.DataSourcesMasterBlock;
import tools.descartes.librede.rrde.model.editor.forms.master.EstimationApproachesMasterBlock;
import tools.descartes.librede.rrde.model.editor.forms.master.EstimationApproachesRecommendationMasterBlock;
import tools.descartes.librede.rrde.model.editor.forms.master.InputDataMasterBlock;
import tools.descartes.librede.rrde.model.editor.forms.master.OptimizationSettingsMasterBock;
import tools.descartes.librede.rrde.model.editor.forms.master.TracesMasterBlock;
import tools.descartes.librede.rrde.model.editor.forms.master.ValidationMasterBlock;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;

public class SelectionProvider {
	private static SelectionProvider instance;

	private RunCall selectedRunCall;
	private InputData selectedInputData;
	private static LifeCycleConfiguration model;
	private EstimationSpecification selectedEstimation;

	// input Data selection
	private DataSourcesMasterBlock dataSourcesMasterBlock;
	private TracesMasterBlock tracesMasterBlock;
	private WorkloadDescriptionFormPage workloadDescriptionFormPage;

	// Run call selection
	private EstimationApproachesMasterBlock estimationApproachesMasterBlock;
	private InputDataMasterBlock inputDataMasterBlock;
	private OptimizationSettingsMasterBock optimizationSettingsMasterBock;
	private ValidationMasterBlock validitionMasterBlock;
	private EstimationFormPage estimationFormPage;
	private ValidationFormPage validationFormPage;

	// estimation specification selection
	private EstimationRecommendationFormPage estimationRecommendationFormPage;
	private EstimationApproachesRecommendationMasterBlock estimationApproachesRecommendationMasterBlock;

	private EditingDomain domain;

	private SelectionProvider() {

	}

	public static SelectionProvider INSTANCE() {
		if (instance == null) {
			instance = new SelectionProvider();
		}
		return instance;
	}

	public void init(LifeCycleConfiguration model, EditingDomain domain, DataSourcesMasterBlock dataSourcesMasterBlock,
			TracesMasterBlock tracesMasterBlock, WorkloadDescriptionFormPage workloadDescriptionFormPage,
			EstimationApproachesMasterBlock estimationApproachesMasterBlock, InputDataMasterBlock inputDataMasterBlock,
			OptimizationSettingsMasterBock optimizationSettingsMasterBlock, ValidationMasterBlock validitonMasterBlock,
			EstimationFormPage estimiationFormpage, ValidationFormPage validationFormPage,
			EstimationRecommendationFormPage estimationRecommendationFormPage,
			EstimationApproachesRecommendationMasterBlock estimationApproachesRecommendationMasterBlock) {
		SelectionProvider.model = model;
		this.domain = domain;
		this.dataSourcesMasterBlock = dataSourcesMasterBlock;
		this.tracesMasterBlock = tracesMasterBlock;
		this.workloadDescriptionFormPage = workloadDescriptionFormPage;
		this.estimationApproachesMasterBlock = estimationApproachesMasterBlock;
		this.inputDataMasterBlock = inputDataMasterBlock;
		this.optimizationSettingsMasterBock = optimizationSettingsMasterBlock;
		this.validationFormPage = validationFormPage;
		this.estimationFormPage = estimiationFormpage;
		this.validitionMasterBlock = validitonMasterBlock;
		this.estimationRecommendationFormPage = estimationRecommendationFormPage;
		this.estimationApproachesRecommendationMasterBlock = estimationApproachesRecommendationMasterBlock;
	}

	public void runCallPageSelectionChanged(SelectionChangedEvent event) {
		selectedRunCall = getRunCall(event.getSelection());

		// notify all FormPages which depend on the RunCall selected from
		// ConfigurationOptimizationAlgorithmSpecifierMasterBlock
		estimationApproachesMasterBlock.runCallPageSelectionChanged();
		inputDataMasterBlock.runCallPageSelectionChanged();
		optimizationSettingsMasterBock.runCallPageSelectionChanged();
		validitionMasterBlock.runCallPageSelectionChanged();
		estimationFormPage.runCallPageSelectionChanged();
		validationFormPage.runCallPageSelectionChanged();
	}

	public void inputDataPageSelectionChanged(SelectionChangedEvent event) {
		selectedInputData = getInputData(event.getSelection());

		// notify all FormPages which depend on selection of
		// InputDataMasterBlock
		dataSourcesMasterBlock.inputDataPageSelectionChanged();
		tracesMasterBlock.inputDataPageSelectionChanged();
		workloadDescriptionFormPage.inputDataPageSelectionChanged();
	}

	public void estimationPageSelectionChanged(SelectionChangedEvent event) {
		selectedEstimation = getEstimation(event.getSelection());

		// notify estimation pages
		estimationApproachesRecommendationMasterBlock.estimationPageSelectionChanged();
		estimationRecommendationFormPage.estimationPageSelectionChanged();
	}

	private EstimationSpecification getEstimation(ISelection sel) {
		EstimationSpecification spec = null;
		IStructuredSelection structuredSelection = (IStructuredSelection) sel;
		if (structuredSelection.size() == 1) {
			spec = (EstimationSpecification) structuredSelection.getFirstElement();
		}

		return spec;
	}

	private RunCall getRunCall(ISelection selection) {
		RunCall input = null;
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (structuredSelection.size() == 1) {
			ConfigurationOptimizationAlgorithmSpecifier spec = (ConfigurationOptimizationAlgorithmSpecifier) structuredSelection
					.getFirstElement();
			for (RunCall call : model.getOptimizationConfiguration().getContainsOf()) {
				if (call.getAlgorithm() == spec) {
					input = call;
					break;
				}
			}

			if (input == null) {
				try {
					input = model.getOptimizationConfiguration().getContainsOf().get(0);
				} catch (Exception e) {
					input = OptimizationFactory.eINSTANCE.createRunCall();
					Command cmd = AddCommand.create(domain, model.getOptimizationConfiguration(),
							OptimizationPackage.Literals.OPTIMIZATION_CONFIGURATION__CONTAINS_OF, input);
					domain.getCommandStack().execute(cmd);
				}
			}
		}
		return input;
	}

	public RunCall getSelectedRunCall() {
		return selectedRunCall;
	}

	private InputData getInputData(ISelection sel) {
		InputData input = null;
		IStructuredSelection structuredSelection = (IStructuredSelection) sel;
		if (structuredSelection.size() == 1) {
			input = (InputData) structuredSelection.getFirstElement();
		}
		return input;
	}

	public InputData getSelectedInputData() {
		return selectedInputData;
	}

	public EstimationSpecification getSelectedEstimationSpecification() {
		return selectedEstimation;
	}
}
