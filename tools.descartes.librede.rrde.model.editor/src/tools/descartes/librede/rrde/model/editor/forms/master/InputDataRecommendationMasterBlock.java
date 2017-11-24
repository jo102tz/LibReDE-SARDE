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
import tools.descartes.librede.datasource.IDataSource;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.forms.details.InputDataDetailsPage;
import tools.descartes.librede.rrde.model.editor.util.InputDataRegistry;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.presentation.RrdeEditorPlugin;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;

import tools.descartes.librede.rrde.model.optimization.impl.InputDataImpl;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;

public class InputDataRecommendationMasterBlock extends AbstractMasterBlockWithButtons {

	private Table inpDataTable;
	private TableViewer inpDataViewer;
	private InputDataDetailsPage inpDataPage;

	public InputDataRecommendationMasterBlock(AdapterFactoryEditingDomain domain, LifeCycleConfiguration model) {
		super(domain, model);
		init();
	}

	private void init() {
		for (InputData data : model.getRecommendationConfiguration().getTrainingData()) {
			InputDataRegistry.INSTANCE.registerRecommendationInputData(data);
		}

	}

	@Override
	protected void handleAdd() {
		InputData inptDat = OptimizationFactory.eINSTANCE.createInputData();
		inptDat.setRootFolder("");
		inptDat.setMultiFolderStructures(false);

		WorkloadDescription desc = ConfigurationFactory.eINSTANCE.createWorkloadDescription();
		inptDat.setWorkloadDescription(desc);

		InputSpecification inpSpec = ConfigurationFactory.eINSTANCE.createInputSpecification();
		inptDat.setInput(inpSpec);

		InputDataRegistry.INSTANCE.registerRecommendationInputData(inptDat);

		Command cmd = AddCommand.create(domain, model.getRecommendationConfiguration(),
				RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA, inptDat);
		domain.getCommandStack().execute(cmd);

		inpDataViewer.refresh(true);

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

		inpDataViewer.setInput(model.getRecommendationConfiguration());
		inpDataViewer.addFilter(new ClassesViewerFilter(RecommendationTrainingConfiguration.class, InputData.class));
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
			return "";
		}
	}

	@Override
	protected void createToolbarAction(Section sctnMaster) {
		sctnMaster.setDescription(
				"Add and remove input data from the recommendation. Edit it through the Workload Desc., Traces and Data Souces Pages.");

		ToolBar toolbar = new ToolBar(sctnMaster, SWT.NONE);
		ToolItem copyFromOptimizationItem = new ToolItem(toolbar, SWT.NONE);
		copyFromOptimizationItem.setImage(ExtendedImageRegistry.INSTANCE
				.getImage(RrdeEditorPlugin.getPlugin().getImage("full/obj16/refresh_remote")));
		copyFromOptimizationItem.setToolTipText("Copy Input Data from Optimization");
		copyFromOptimizationItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				copyInputDataFromOptimization();
			}
		});
		sctnMaster.setTextClient(toolbar);
	}

	private void copyInputDataFromOptimization() {
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
		dialog.setMessage("Select a RunCall of the Optimization, of which you want the InputData to be added to the recommendation:");
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
				Command cmd = AddCommand.create(domain, model.getRecommendationConfiguration(),
						RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA,
						copy);
				domain.getCommandStack().execute(cmd);
				InputDataRegistry.INSTANCE.registerRecommendationInputData(copy);
			}

		}

	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		inpDataPage = new InputDataDetailsPage(page, domain, model);

		detailsPart.registerPage(InputDataImpl.class, inpDataPage);

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
