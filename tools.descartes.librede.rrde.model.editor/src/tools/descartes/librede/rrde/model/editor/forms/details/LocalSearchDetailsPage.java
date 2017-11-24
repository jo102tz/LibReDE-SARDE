package tools.descartes.librede.rrde.model.editor.forms.details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IFormPart;

import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.forms.AbstractLifecycleConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.forms.AbstractOptimizationConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.util.OptAlgorithmLabelProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.algorithm.IConfigurationOptimizer;
import tools.descartes.librede.units.UnitsPackage;

import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class LocalSearchDetailsPage extends AbstractDetailsPage {

	private LifeCycleConfiguration model;
	private Text inpTolerance;
	private Text inpMaxNumber;
	private Text inpStepSize;
	private LocalSearchSpecifier locSearchSpec;
	private ComboViewer viewer;

	EMFDataBindingContext detailBindingContext;

	public LocalSearchDetailsPage(AbstractLifecycleConfigurationFormPage page, AdapterFactoryEditingDomain domain,
			LifeCycleConfiguration model) {
		super(page, domain);
		this.model = model;
	}

	@Override
	public void createContents(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Section sctnLocalSearch = managedForm.getToolkit().createSection(parent, Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_sctnLocalSearch = new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1);
		gd_sctnLocalSearch.heightHint = 310;
		gd_sctnLocalSearch.widthHint = 320;
		sctnLocalSearch.setLayoutData(gd_sctnLocalSearch);
		managedForm.getToolkit().paintBordersFor(sctnLocalSearch);
		sctnLocalSearch.setText("Local Search Specifier");
		sctnLocalSearch.setExpanded(true);

		Composite composite = new Composite(sctnLocalSearch, SWT.NONE);
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);
		sctnLocalSearch.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblTolerance = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblTolerance, true, true);
		lblTolerance.setText("Tolerance:");

		inpTolerance = new Text(composite, SWT.BORDER);
		inpTolerance.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpTolerance, true, true);

		Label lblMaxSteps = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblMaxSteps, true, true);
		lblMaxSteps.setText("Maximum Number of Steps:");

		inpMaxNumber = new Text(composite, SWT.BORDER);
		inpMaxNumber.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpMaxNumber, true, true);

		Label lblStepSize = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblStepSize, true, true);
		lblStepSize.setText("Step Size:");

		inpStepSize = new Text(composite, SWT.BORDER);
		inpStepSize.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpStepSize, true, true);

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNewLabel_2, true, true);
		lblNewLabel_2.setText("Algorithm:");
		viewer = new ComboViewer(composite, SWT.READ_ONLY);
		Combo combo = viewer.getCombo();
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		managedForm.getToolkit().paintBordersFor(combo);

		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new OptAlgorithmLabelProvider());
		
		HashMap<String, String> displayNameTypeMapping = new HashMap<String, String>();
		
		// get all algorithms that use the local search specifier
		List<String> suitedAlgs = new ArrayList<String>();
		try {
			Set<String> algorithms = Registry.INSTANCE.getInstances(IConfigurationOptimizer.class);
			for (String alg : algorithms) {
				Class<?> o = Registry.INSTANCE.getInstanceClass(alg);
				String displayName = Registry.INSTANCE.getDisplayName(o);
				displayNameTypeMapping.put(displayName, alg);
				IConfigurationOptimizer opt = (IConfigurationOptimizer) o.newInstance();
				if (opt.isSpecifierSupported(OptimizationFactory.eINSTANCE.createLocalSearchSpecifier()))
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
			locSearchSpec = (LocalSearchSpecifier) structuredSelection.getFirstElement();
			createBindings();
			
		} else {
			locSearchSpec = null;
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
						.observe(locSearchSpec));
		
		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpMaxNumber),
				EMFEditProperties
						.value(domain, OptimizationPackage.Literals.LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS)
						.observe(locSearchSpec));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpStepSize), EMFEditProperties
				.value(domain, OptimizationPackage.Literals.LOCAL_SEARCH_SPECIFIER__STEP_SIZE).observe(locSearchSpec));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpTolerance), EMFEditProperties
				.value(domain, OptimizationPackage.Literals.LOCAL_SEARCH_SPECIFIER__TOLERANCE).observe(locSearchSpec));

	}
}
