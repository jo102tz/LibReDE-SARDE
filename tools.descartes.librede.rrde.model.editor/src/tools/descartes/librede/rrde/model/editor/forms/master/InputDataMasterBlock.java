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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
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
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.widgets.Section;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.InputSpecification;
import tools.descartes.librede.configuration.TraceConfiguration;
import tools.descartes.librede.configuration.WorkloadDescription;
import tools.descartes.librede.configuration.editor.forms.ClassesViewerFilter;
import tools.descartes.librede.rrde.model.editor.forms.details.InputDataDetailsPage;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;

import tools.descartes.librede.rrde.model.optimization.impl.InputDataImpl;

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
		ToolItem readFromTracesItem = new ToolItem(toolbar, SWT.NONE);
		//readFromTracesItem.setImage(ExtendedImageRegistry.INSTANCE
		//		.getImage(LibredeEditorPlugin.getPlugin().getImage("full/obj16/refresh_remote")));
		readFromTracesItem.setToolTipText("Copy Input Data from Recommendation");
		readFromTracesItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				copyInputDataFromRecommendation();
			}
		});
		sctnMaster.setTextClient(toolbar);
	}
	
	@Override
	protected String getInfoLabelContent() {
		return "Add and remove input data from the optimization. Edit it through the Workload Desc., Traces and Data Souces Pages.";
	}
	
	private void copyInputDataFromRecommendation() {
		for (InputData data : model.getRecommendationConfiguration().getTrainingData()) {
			InputData copy = EcoreUtil.copy(data);
			Command cmd = AddCommand.create(domain, input, OptimizationPackage.Literals.RUN_CALL__TRAINING_DATA, copy);
			domain.getCommandStack().execute(cmd);
		}
	}
	
	@Override
	protected void handleAdd() {
		if (input == null) {
			MessageDialog.openInformation(page.getSite().getShell(), "Info", "Select a Run Call first on the RunCall page.");
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
			}
		}
		
		// after remove inform other pages that the selection changed, to refresh their view by passing null to the pages
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
		inpDataViewer.setLabelProvider(new AdapterFactoryLabelProvider(page.getAdapterFactory()));
		if (input != null)
			inpDataViewer.setInput(input);
		inpDataViewer.addFilter(new ClassesViewerFilter(RunCall.class, InputData.class));
		inpDataViewer.addSelectionChangedListener(this);

		registerViewer(inpDataViewer);
		return inpDataTable;
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
			inpDataViewer.setInput(input);
			inpDataViewer.refresh(true, true);
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
