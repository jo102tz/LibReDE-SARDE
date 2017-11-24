package tools.descartes.librede.rrde.model.editor.forms.details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.widgets.Section;

import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.forms.AbstractLifecycleConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.forms.AbstractOptimizationConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.util.OptAlgorithmLabelProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.optimization.algorithm.IConfigurationOptimizer;

public class DataExportDetailsPage extends AbstractDetailsPage {

	private LifeCycleConfiguration model;
	private DataExportSpecifier dataExSpec;
	private Text inpOutput;
	private Text inpStepSize;
	private Button btnMultidimensional;
	private Button btnSplitConfigs;
	private DirectoryDialog fileDialog;
	private ComboViewer viewer;

	private EMFDataBindingContext detailBindingContext;

	public DataExportDetailsPage(AbstractLifecycleConfigurationFormPage page, AdapterFactoryEditingDomain domain,
			LifeCycleConfiguration model) {
		super(page, domain);
		this.model = model;
	}

	@Override
	public void createContents(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Section sctnNewSection = managedForm.getToolkit().createSection(parent, Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Data Export");
		sctnNewSection.setExpanded(true);

		Composite composite = managedForm.getToolkit().createComposite(sctnNewSection, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(composite);
		sctnNewSection.setClient(composite);
		composite.setLayout(new GridLayout(3, false));

		Label lblNewLabel = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNewLabel, true, true);
		lblNewLabel.setText("OutputDirectory");

		inpOutput = new Text(composite, SWT.BORDER);
		inpOutput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpOutput, true, true);

		Button btnBrowse = managedForm.getToolkit().createButton(composite, "Browse ...", SWT.PUSH);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (fileDialog == null) {
					fileDialog = new DirectoryDialog(page.getSite().getShell(), SWT.OPEN);
				}

				String res = fileDialog.open();
				if (res != null) {
					inpOutput.setText(res);
				}
			}
		});

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNewLabel_1, true, true);
		lblNewLabel_1.setText("Step  Size:");

		inpStepSize = new Text(composite, SWT.BORDER);
		inpStepSize.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		managedForm.getToolkit().adapt(inpStepSize, true, true);

		btnMultidimensional = managedForm.getToolkit().createButton(composite, "", SWT.CHECK);
		managedForm.getToolkit().adapt(btnMultidimensional, true, true);
		btnMultidimensional.setText("Multidimensional");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		btnSplitConfigs = managedForm.getToolkit().createButton(composite, "", SWT.CHECK);
		managedForm.getToolkit().adapt(btnSplitConfigs, true, true);
		btnSplitConfigs.setText("Split Configurations");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNewLabel_2, true, true);
		lblNewLabel_2.setText("Algorithm:");
		viewer = new ComboViewer(composite, SWT.READ_ONLY);
		Combo combo = viewer.getCombo();
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		managedForm.getToolkit().paintBordersFor(combo);
		new Label(composite, SWT.NONE);

		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new OptAlgorithmLabelProvider());
		
		HashMap<String, String> displayNameTypeMapping = new HashMap<String, String>();
		
		
		List<String> suitedAlgs = new ArrayList<String>();
		try {
			Set<String> algorithms = Registry.INSTANCE.getInstances(IConfigurationOptimizer.class);
			for (String alg : algorithms) {
				Class<?> o = Registry.INSTANCE.getInstanceClass(alg);
				String displayName = Registry.INSTANCE.getDisplayName(o);
				displayNameTypeMapping.put(displayName, alg);
				IConfigurationOptimizer opt = (IConfigurationOptimizer) o.newInstance();
				if (opt.isSpecifierSupported(OptimizationFactory.eINSTANCE.createDataExportSpecifier()))
					suitedAlgs.add(alg);

			}
		} catch (Exception e) {
			// ignore
		}

		viewer.setInput(suitedAlgs.toArray());	

	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (detailBindingContext != null) {
			detailBindingContext.dispose();
			detailBindingContext = null;
		}
		if (structuredSelection.size() == 1) {
			dataExSpec = (DataExportSpecifier) structuredSelection.getFirstElement();

			createBindings();
		} else {
			dataExSpec = null;
		}
		update();

	}

	private void createBindings() {
		detailBindingContext = new EMFDataBindingContext();
		
		detailBindingContext
		.bindValue(
				ViewerProperties
						.singleSelection().observe(viewer),
				EMFEditProperties.value(domain,
						OptimizationPackage.Literals.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME)
						.observe(dataExSpec));

		detailBindingContext.bindValue(WidgetProperties.selection().observe(btnMultidimensional),
				EMFEditProperties.value(domain, OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL)
						.observe(dataExSpec));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpStepSize), EMFEditProperties
				.value(domain, OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER__STEP_SIZE).observe(dataExSpec));

		detailBindingContext.bindValue(WidgetProperties.selection().observe(btnSplitConfigs),
				EMFEditProperties
						.value(domain, OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS)
						.observe(dataExSpec));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpOutput),
				EMFEditProperties.value(domain, OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY)
						.observe(dataExSpec));


	}

}
