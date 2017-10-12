/**
 * ==============================================
 *  LibReDE : Library for Resource Demand Estimation
 * ==============================================
 *
 * (c) Copyright 2013-2014, by Simon Spinner and Contributors.
 *
 * Project Info:   http://www.descartes-research.net/
 *
 * All rights reserved. This software is made available under the terms of the
 * Eclipse Public License (EPL) v1.0 as published by the Eclipse Foundation
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * This software is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License (EPL)
 * for more details.
 *
 * You should have received a copy of the Eclipse Public License (EPL)
 * along with this software; if not visit http://www.eclipse.org or write to
 * Eclipse Foundation, Inc., 308 SW First Avenue, Suite 110, Portland, 97204 USA
 * Email: license (at) eclipse.org
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 */
package tools.descartes.librede.rrde.model.editor.forms;

import java.util.Arrays;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.Resource;
import tools.descartes.librede.configuration.ResourceDemand;
import tools.descartes.librede.configuration.Service;
import tools.descartes.librede.configuration.WorkloadDescription;
import tools.descartes.librede.configuration.editor.forms.ClassesViewerFilter;
import tools.descartes.librede.configuration.presentation.ConfigurationEditor;
import tools.descartes.librede.configuration.presentation.LibredeEditorPlugin;
import tools.descartes.librede.rrde.model.actions.RunLifecycleAction;
import tools.descartes.librede.rrde.model.actions.RunOptimizationAction;
import tools.descartes.librede.rrde.model.actions.RunRecommendationAction;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.presentation.LifecycleEditor;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.model.optimization.presentation.OptimizationEditor;

public class WorkloadDescriptionFormPage extends AbstractLifecycleConfigurationFormPage {

	private static class DisableOnEmptySelection extends UpdateValueStrategy {
		@Override
		public Object convert(Object value) {
			return value != null;
		}
	}

	private Composite resourcesComposite;
	private Button btnNewResource;
	private Button btnRemoveResource;
	private Button btnNewClass;
	private Button btnRemoveClass;
	private Section sctnResources;
	private Section sctnServices;
	private TreeViewer treeViewerResources;
	private TreeViewer treeViewerServices;
	private ScrolledForm form;
	
	private InputData input;

	private EMFDataBindingContext bindingContext = new EMFDataBindingContext();
	private Section sctnImport;

	/**
	 * Create the form page.
	 * 
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public WorkloadDescriptionFormPage(LifecycleEditor editor, String id, String title,
			AdapterFactoryEditingDomain editingDomain, LifeCycleConfiguration model) {
		super(editor, id, title, editingDomain, model);

	}

	private void initializeValues() {

		if (getModel().getOptimizationConfiguration().getContainsOf().size() == 0) {
			RunCall inputRun = OptimizationFactory.eINSTANCE.createRunCall();

			Command cmd = AddCommand.create(getEditingDomain(), getModel(),
					OptimizationPackage.Literals.OPTIMIZATION_CONFIGURATION__CONTAINS_OF, inputRun);
			getEditingDomain().getCommandStack().execute(cmd);

		}

		if (getModel().getOptimizationConfiguration().getContainsOf().get(0).getTrainingData().size() == 0) {
			input = OptimizationFactory.eINSTANCE.createInputData();
			input.setWorkloadDescription(ConfigurationFactory.eINSTANCE.createWorkloadDescription());
			Command cmd = AddCommand.create(getEditingDomain(), getModel().getOptimizationConfiguration().getContainsOf().get(0),
					OptimizationPackage.Literals.RUN_CALL__TRAINING_DATA, input);
			getEditingDomain().getCommandStack().execute(cmd);
		}

	}

	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		managedForm.getForm().setText("Workload Description");
		FormToolkit toolkit = managedForm.getToolkit();
		form = managedForm.getForm();
		// form.setImage(ExtendedImageRegistry.INSTANCE.getImage(LibredeEditorPlugin.getPlugin().getImage("full/page/WorkloadDescription")));
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);

		// Add run toolbar buttons
		form.getToolBarManager().add(new RunOptimizationAction(getModel()));	
		form.getToolBarManager().add(new RunRecommendationAction(getModel()));
		form.getToolBarManager().add(new RunLifecycleAction(getModel()));
		form.getToolBarManager().update(true);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.marginBottom = 12;
		gridLayout.marginTop = 12;
		gridLayout.marginLeft = 6;
		gridLayout.marginRight = 6;
		gridLayout.verticalSpacing = 17;
		gridLayout.horizontalSpacing = 20;
		managedForm.getForm().getBody().setLayout(gridLayout);

		createServicesSection(managedForm);

		createResourcesSection(managedForm);

		// sctnImport =
		// managedForm.getToolkit().createSection(managedForm.getForm().getBody(),
		// Section.TWISTIE | Section.TITLE_BAR);
		// sctnImport.setLayoutData(new TableWrapData(TableWrapData.FILL,
		// TableWrapData.TOP, 1, 2));
		// managedForm.getToolkit().paintBordersFor(sctnImport);
		// sctnImport.setText("Import");
		// sctnImport.setExpanded(true);
	}

	private void createResourcesSection(IManagedForm managedForm) {
		sctnResources = managedForm.getToolkit().createSection(managedForm.getForm().getBody(),
				Section.TWISTIE | Section.TITLE_BAR | Section.DESCRIPTION);
		GridData gd_sctnResources = new GridData(GridData.FILL_BOTH);
		sctnResources.setLayoutData(gd_sctnResources);
		managedForm.getToolkit().paintBordersFor(sctnResources);
		sctnResources.setText("Resources");
		sctnResources.descriptionVerticalSpacing = 10;
		sctnResources.setDescription("List all processing resources for which resource demands should be determined.");
		sctnResources.setExpanded(true);

		resourcesComposite = managedForm.getToolkit().createComposite(sctnResources, SWT.NONE);
		sctnResources.setClient(resourcesComposite);
		managedForm.getToolkit().paintBordersFor(resourcesComposite);
		resourcesComposite.setLayout(new GridLayout(2, false));

		treeViewerResources = createTreeViewer(resourcesComposite, Resource.class,
				new EStructuralFeature[] { ConfigurationPackage.Literals.NAMED_ELEMENT__NAME,
						ConfigurationPackage.Literals.RESOURCE__NUMBER_OF_SERVERS,
						ConfigurationPackage.Literals.RESOURCE__SCHEDULING_STRATEGY },
				new String[] { "Name", "Number of Servers", "Scheduling Strategy" }, new int[] { 10, 0, 0 });

		/*
		 * IMPORTANT: filter out resources below service entries (redundant)
		 */
		// treeViewerResources.addFilter(new ClassesViewerFilter(Service.class,
		// Resource.class));

		btnNewResource = new Button(resourcesComposite, SWT.NONE);
		GridData gd_btnNewResource = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		gd_btnNewResource.widthHint = 90;
		btnNewResource.setLayoutData(gd_btnNewResource);
		btnNewResource.setText("Add");
		btnNewResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleAddResource();
			}
		});

		btnRemoveResource = new Button(resourcesComposite, SWT.NONE);
		GridData gd_btnRemoveResource = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		gd_btnRemoveResource.widthHint = 90;
		btnRemoveResource.setLayoutData(gd_btnRemoveResource);
		btnRemoveResource.setText("Remove");
		btnRemoveResource.addSelectionListener(new RemoveSelectionSelectionListener(treeViewerResources));

		bindingContext.bindValue(WidgetProperties.enabled().observe(btnRemoveResource),
				ViewerProperties.singleSelection().observe(treeViewerResources), null, new UpdateValueStrategy() {
					@Override
					public Object convert(Object value) {
						return value != null;
					}
				});
	}

	private void createServicesSection(IManagedForm managedForm) {
		sctnServices = managedForm.getToolkit().createSection(managedForm.getForm().getBody(),
				Section.TWISTIE | Section.TITLE_BAR | Section.DESCRIPTION);
		GridData gd_sctnServices = new GridData(GridData.FILL_BOTH);
		sctnServices.setLayoutData(gd_sctnServices);
		managedForm.getToolkit().paintBordersFor(sctnServices);
		sctnServices.descriptionVerticalSpacing = 10;
		sctnServices.setDescription(
				"Services (or workload classes) are groups of requests with similar resource demand behaviors.");
		sctnServices.setText("Services");
		sctnServices.setExpanded(true);

		Composite wclComposite = managedForm.getToolkit().createComposite(sctnServices, SWT.NONE);
		sctnServices.setClient(wclComposite);
		managedForm.getToolkit().paintBordersFor(wclComposite);
		wclComposite.setLayout(new GridLayout(2, false));

		treeViewerServices = createTreeViewer(wclComposite, Service.class,
				new EStructuralFeature[] { ConfigurationPackage.Literals.NAMED_ELEMENT__NAME,
						ConfigurationPackage.Literals.SERVICE__BACKGROUND_SERVICE },
				new String[] { "Name", "Background Service" }, new int[] { 10, 0 });

		btnNewClass = new Button(wclComposite, SWT.NONE);
		GridData gd_btnNewClass = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		gd_btnNewClass.widthHint = 90;
		btnNewClass.setLayoutData(gd_btnNewClass);
		btnNewClass.setText("Add");
		btnNewClass.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleAddService();
			}
		});

		btnRemoveClass = new Button(wclComposite, SWT.NONE);
		GridData gd_btnRemoveClass = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		gd_btnRemoveClass.widthHint = 90;
		btnRemoveClass.setLayoutData(gd_btnRemoveClass);
		btnRemoveClass.setText("Remove");
		btnRemoveClass.addSelectionListener(new RemoveSelectionSelectionListener(treeViewerServices));

		bindingContext.bindValue(WidgetProperties.enabled().observe(btnRemoveClass),
				ViewerProperties.singleSelection().observe(treeViewerServices), null, new DisableOnEmptySelection());
	}

	private TreeViewer createTreeViewer(Composite composite, Class<?> objectType, EStructuralFeature[] attributes,
			String[] headers, int[] weights) {
		Composite tableComposite = new Composite(composite, SWT.NONE);

		GridData gd_tableComposite = new GridData(GridData.FILL_BOTH);
		gd_tableComposite.heightHint = 200;
		gd_tableComposite.widthHint = 50;
		gd_tableComposite.verticalSpan = 4;
		tableComposite.setLayoutData(gd_tableComposite);

		final TreeViewer viewer = new TreeViewer(tableComposite,
				SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				getLifecycleEditor().setCurrentViewer(viewer);
			}
		});

		initTreeFromEMF(tableComposite, viewer, objectType, attributes, headers, weights);
		getLifecycleEditor().createContextMenuFor(viewer);
		return viewer;
	}

	private void initTreeFromEMF(Composite composite, TreeViewer treeViewer, Class<?> objectType,
			EStructuralFeature[] attributes, String[] headers, int[] weights) {
		TreeColumnLayout colLayout = new TreeColumnLayout();
		composite.setLayout(colLayout);
		for (int i = 0; i < headers.length; i++) {
			// Create column
			TreeViewerColumn tableViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
			colLayout.setColumnData(tableViewerColumn.getColumn(), new ColumnWeightData(weights[i], 130, true));
			tableViewerColumn.getColumn().setText(headers[i]);
			tableViewerColumn
					.setEditingSupport(EObjectEditingSupport.create(treeViewer, getEditingDomain(), attributes[i]));
		}
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(getAdapterFactory()));
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(getAdapterFactory()));
		treeViewer.addFilter(new ClassesViewerFilter(WorkloadDescription.class, objectType));
		if (input != null && input.getWorkloadDescription() != null)
			treeViewer.setInput(input.getWorkloadDescription());
	}

	private void handleAddResource() {
		if (input != null) {
			Resource res = ConfigurationFactory.eINSTANCE.createResource();
			res.setName("New Resource");
			if (input.getWorkloadDescription() != null) {
				for (Service s : input.getWorkloadDescription().getServices()) {
					ResourceDemand d = ConfigurationFactory.eINSTANCE.createResourceDemand();
					d.setName(res.getName());
					d.setResource(res);
					s.getTasks().add(d);
				}
			}

			Command cmd;
			if (input.getWorkloadDescription() == null) {
				WorkloadDescription description = ConfigurationFactory.eINSTANCE.createWorkloadDescription();
				description.getResources().add(res);
				cmd = SetCommand.create(getEditingDomain(), input,
						OptimizationPackage.Literals.INPUT_DATA__WORKLOAD_DESCRIPTION, description);
			} else {
				cmd = AddCommand.create(getEditingDomain(), input.getWorkloadDescription(),
						ConfigurationPackage.Literals.WORKLOAD_DESCRIPTION__RESOURCES, res);
			}
			getEditingDomain().getCommandStack().execute(cmd);
		} else {
			MessageDialog.openInformation(getEditorSite().getShell(), "Info", "Select a Input Data first on either the Input Data Page for optimization configuration or the Recommendation Page for recommendation configuration.");
		}
	}

	private void handleAddService() {
		if (input != null) {
			Service service = ConfigurationFactory.eINSTANCE.createService();
			service.setName("New Service");

			if (input.getWorkloadDescription() != null) {
				for (Resource resource : input.getWorkloadDescription().getResources()) {
					ResourceDemand demand = ConfigurationFactory.eINSTANCE.createResourceDemand();
					demand.setName(resource.getName());
					demand.setResource(resource);
					service.getTasks().add(demand);
				}
			}

			Command cmd;
			if (input.getWorkloadDescription() == null) {
				WorkloadDescription description = ConfigurationFactory.eINSTANCE.createWorkloadDescription();
				description.getServices().add(service);
				cmd = SetCommand.create(getEditingDomain(), input,
						OptimizationPackage.Literals.INPUT_DATA__WORKLOAD_DESCRIPTION, description);
			} else {
				cmd = AddCommand.create(getEditingDomain(), input.getWorkloadDescription(),
						ConfigurationPackage.Literals.WORKLOAD_DESCRIPTION__SERVICES, service);
			}
			getEditingDomain().getCommandStack().execute(cmd);
		} else {
			MessageDialog.openInformation(getEditorSite().getShell(), "Info", "Select a Input Data first on either the Input Data Page for optimization configuration or the Recommendation Page for recommendation configuration.");
		}
	}

	private ElementListSelectionDialog createServiceSelectionDialog() {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(getEditorSite().getShell(),
				new AdapterFactoryLabelProvider(getAdapterFactory()));
		dialog.setHelpAvailable(false);
		dialog.setIgnoreCase(true);
		dialog.setTitle("Services");
		dialog.setMessage("Enter service name prefix or pattern (*, ?):");
		dialog.setMultipleSelection(true);
		dialog.setElements(input.getWorkloadDescription().getServices().toArray());
		return dialog;
	}

	public void inputDataPageSelectionChanged() {
		input = SelectionProvider.INSTANCE().getSelectedInputData();
		if (input != null) {
			
			if (treeViewerResources != null) {
				form.setText("Workload Description - Editing " + input.toString());
				treeViewerResources.setInput(input.getWorkloadDescription());
				treeViewerResources.refresh();
			}
			if (treeViewerServices != null) {
				treeViewerServices.setInput(input.getWorkloadDescription());
				treeViewerServices.refresh();
			}
		} else {
			if (treeViewerResources != null && treeViewerServices != null) {
				treeViewerServices.setInput(input);
				treeViewerResources.setInput(input);
				treeViewerResources.refresh();
				treeViewerServices.refresh();
			}
		}
	}
}
