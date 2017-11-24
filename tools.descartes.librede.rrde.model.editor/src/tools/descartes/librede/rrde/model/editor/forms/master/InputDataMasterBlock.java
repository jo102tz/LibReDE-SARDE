package tools.descartes.librede.rrde.model.editor.forms.master;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.widgets.Section;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.InputSpecification;
import tools.descartes.librede.configuration.TraceConfiguration;
import tools.descartes.librede.configuration.WorkloadDescription;
import tools.descartes.librede.configuration.editor.forms.ClassesViewerFilter;
import tools.descartes.librede.rrde.model.editor.forms.details.InputDataDetailsPage;
import tools.descartes.librede.rrde.model.editor.util.InputDataRegistry;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.presentation.RrdeEditorPlugin;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;

import tools.descartes.librede.rrde.model.optimization.impl.InputDataImpl;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;

public class InputDataMasterBlock extends AbstractMasterBlockWithButtons {

	private Table inpDataTable;
	private TableViewer inpDataViewer;
	private InputDataDetailsPage inpDataPage;
	private LifeCycleConfiguration model;
	private RunCall input;

	public InputDataMasterBlock(AdapterFactoryEditingDomain domain, LifeCycleConfiguration model) {
		super(domain, model);
		this.model = model;
	}

	@Override
	protected void createToolbarAction(Section sctnMaster) {

		ToolBar toolbar = new ToolBar(sctnMaster, SWT.NONE);

		ToolItem copyFromRecommendationItem = new ToolItem(toolbar, SWT.NONE);
		copyFromRecommendationItem.setImage(ExtendedImageRegistry.INSTANCE
				.getImage(RrdeEditorPlugin.getPlugin().getImage("full/obj16/refresh_remote")));
		copyFromRecommendationItem.setToolTipText("Copy Input Data from Recommendation");
		copyFromRecommendationItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				copyInputDataFromRecommendation();
			}
		});

		ToolItem copyFromOtherRunCallItem = new ToolItem(toolbar, SWT.NONE);
		copyFromOtherRunCallItem.setImage(ExtendedImageRegistry.INSTANCE
				.getImage(RrdeEditorPlugin.getPlugin().getImage("full/obj16/refresh_remote")));
		copyFromOtherRunCallItem.setToolTipText("Copy Input Data from other Run Call");
		copyFromOtherRunCallItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				copyInputDataFromOptimization();
			}
		});

		sctnMaster.setTextClient(toolbar);
	}

	private void copyInputDataFromRecommendation() {
		if (input == null) {
			MessageDialog.openInformation(page.getSite().getShell(), "Info",
					"Select a Run Call first on the RunCall page.");
			return;
		}
		for (InputData data : model.getRecommendationConfiguration().getTrainingData()) {
			InputData copy = EcoreUtil.copy(data);
			Command cmd = AddCommand.create(domain, input, OptimizationPackage.Literals.RUN_CALL__TRAINING_DATA, copy);
			domain.getCommandStack().execute(cmd);
			InputDataRegistry.INSTANCE.registerOptimizationInputData(copy);
		}
	}

	private void copyInputDataFromOptimization() {
		if (input == null) {
			MessageDialog.openInformation(page.getSite().getShell(), "Info",
					"Select a Run Call first on the RunCall page.");
			return;
		}
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(page.getSite().getShell(),
				new LabelProvider() {
					@Override
					public String getText(Object element) {
						if (element instanceof RunCall)
							return InputDataRegistry.INSTANCE.getLabelFromRunCall((RunCall) element);
						return "";
					}
				});

		dialog.setElements(model.getOptimizationConfiguration().getContainsOf().toArray());
		dialog.setMultipleSelection(false);
		dialog.setAllowDuplicates(false);
		dialog.setTitle("Optimization Configuration Run Calls");
		dialog.setMessage(
				"Select a RunCall of the Optimization, of which you want the InputData to be added to the currently edited RunCall:");
		dialog.create();
		if (dialog.open() == Window.OK) {
			addInputDataFromRunCall(dialog.getResult());
		}

	}

	private void addInputDataFromRunCall(Object[] results) {

		for (Object r : results) {
			RunCall call = (RunCall) r;
			for (InputData data : call.getTrainingData()) {
				InputData copy = EcoreUtil.copy(data);
				Command cmd = AddCommand.create(domain, input, OptimizationPackage.Literals.RUN_CALL__TRAINING_DATA,
						copy);
				domain.getCommandStack().execute(cmd);
				InputDataRegistry.INSTANCE.registerOptimizationInputData(copy);
			}

		}

	}

	@Override
	protected void handleAdd() {
		if (input == null) {
			MessageDialog.openInformation(page.getSite().getShell(), "Info",
					"Select a Run Call first on the RunCall page.");
		}
		InputData inptDat = OptimizationFactory.eINSTANCE.createInputData();
		inptDat.setRootFolder("");
		inptDat.setMultiFolderStructures(false);

		WorkloadDescription desc = ConfigurationFactory.eINSTANCE.createWorkloadDescription();
		inptDat.setWorkloadDescription(desc);

		InputSpecification inpSpec = ConfigurationFactory.eINSTANCE.createInputSpecification();
		inptDat.setInput(inpSpec);

		Command cmd = AddCommand.create(domain, input, OptimizationPackage.Literals.RUN_CALL__TRAINING_DATA, inptDat);
		domain.getCommandStack().execute(cmd);

		// Register the Label for the inputData
		InputDataRegistry.INSTANCE.registerOptimizationInputData(inptDat);

	}

	@Override
	protected void handleRemove() {
		IStructuredSelection selection = (IStructuredSelection) inpDataViewer.getSelection();
		Iterator<?> iterator = selection.iterator();
		while (iterator.hasNext()) {
			Object o = iterator.next();
			if (o instanceof InputData) {
				Command cmd = RemoveCommand.create(domain, o);
				domain.getCommandStack().execute(cmd);
				InputDataRegistry.INSTANCE.deleteInputDataValue((InputData) o);
			}
		}

		// after remove inform other pages that the selection changed, to
		// refresh their view by passing null to the pages
		ISelection sel = new StructuredSelection();
		SelectionChangedEvent event = new SelectionChangedEvent(inpDataViewer, sel);
		SelectionProvider.INSTANCE().inputDataPageSelectionChanged(event);

	}

	@Override
	protected String getMasterSectionTitle() {
		return "Input Data - Edit on Workload Desc., Data Sources and Traces Page";
	}

	@Override
	protected Control createItemsList(Composite parent) {
		inpDataViewer = new TableViewer(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		inpDataTable = inpDataViewer.getTable();

		inpDataViewer.setContentProvider(new AdapterFactoryContentProvider(page.getAdapterFactory()));
		inpDataViewer.setLabelProvider(new InputDataLabelProvider());
		if (input != null) {
			managedForm.getForm().setText(
					"Input Data - Currently editing " + InputDataRegistry.INSTANCE.getLabelFromRunCall(input));
			inpDataViewer.setInput(input);
		} else {
			managedForm.getForm().setText("Input Data - No Run Call selected.");
		}
		inpDataViewer.addFilter(new ClassesViewerFilter(RunCall.class, InputData.class));
		inpDataViewer.addSelectionChangedListener(this);

		registerViewer(inpDataViewer);
		return inpDataTable;
	}

	public class InputDataLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof InputData) {
				InputData input = (InputData) element;
				return InputDataRegistry.INSTANCE.getLabelFromInputData(input);
			}
			return "Input Data";
		}
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		inpDataPage = new InputDataDetailsPage(page, domain, model);

		detailsPart.registerPage(InputDataImpl.class, inpDataPage);

	}

	// edit selected RunCall on
	// ConfigurationOptimizationAlgorithmSpecifierMasterPage
	public void runCallPageSelectionChanged() {
		input = SelectionProvider.INSTANCE().getSelectedRunCall();
		if (inpDataViewer != null) {
			if (input != null) {
				for (InputData inputData : input.getTrainingData()) {
					InputDataRegistry.INSTANCE.registerOptimizationInputData(inputData);
				}
				managedForm.getForm().setText(
						"Input Data - Currently editing " + InputDataRegistry.INSTANCE.getLabelFromRunCall(input));
				inpDataViewer.setInput(input);
				inpDataViewer.refresh(true, true);
			} else {
				managedForm.getForm().setText("Input Data - No Run Call selected.");
			}
		}

	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		managedForm.fireSelectionChanged(masterPart, event.getSelection());

		// pass the selection to the singleton so other FormPages can access it

		if (((IStructuredSelection) event.getSelection()).size() == 1) {
			SelectionProvider.INSTANCE().inputDataPageSelectionChanged(event);

		}
	}
}
