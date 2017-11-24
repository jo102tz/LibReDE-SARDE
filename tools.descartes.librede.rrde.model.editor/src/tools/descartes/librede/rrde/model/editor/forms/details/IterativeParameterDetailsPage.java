package tools.descartes.librede.rrde.model.editor.forms.details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.databinding.EMFDataBindingContext;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.IFormPart;

import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.forms.AbstractLifecycleConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.forms.AbstractOptimizationConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.util.OptAlgorithmLabelProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.algorithm.IConfigurationOptimizer;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class IterativeParameterDetailsPage extends AbstractDetailsPage {

	private LifeCycleConfiguration model;
	private Text inpNumbSplits;
	private Text inpNumbExplor;
	private Text inpNumbIter;
	IterativeParameterOptimizerSpecifier itParaSpec;
	private ComboViewer viewer;
	EMFDataBindingContext detailBindingContext;

	public IterativeParameterDetailsPage(AbstractLifecycleConfigurationFormPage page,
			AdapterFactoryEditingDomain domain, LifeCycleConfiguration model) {
		super(page, domain);
		this.model = model;
	}

	@Override
	public void createContents(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Section sctnIterativeParameter = managedForm.getToolkit().createSection(parent,
				Section.TWISTIE | Section.TITLE_BAR);
		sctnIterativeParameter.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnIterativeParameter);
		sctnIterativeParameter.setText("Iterative Parameter");
		sctnIterativeParameter.setExpanded(true);

		Composite composite = new Composite(sctnIterativeParameter, SWT.NONE);
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);
		sctnIterativeParameter.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblNumbSplits = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNumbSplits, true, true);
		lblNumbSplits.setText("Number of Splits:");

		inpNumbSplits = new Text(composite, SWT.BORDER);
		inpNumbSplits.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpNumbSplits, true, true);

		Label lblNumbExplor = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNumbExplor, true, true);
		lblNumbExplor.setText("Number of Explorations:");

		inpNumbExplor = new Text(composite, SWT.BORDER);
		inpNumbExplor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpNumbExplor, true, true);

		Label lblNumbIter = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNumbIter, true, true);
		lblNumbIter.setText("Number of Iterations:");

		inpNumbIter = new Text(composite, SWT.BORDER);
		inpNumbIter.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpNumbIter, true, true);

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
		List<String> suitedAlgs = new ArrayList<String>();
		try {
			Set<String> algorithms = Registry.INSTANCE.getInstances(IConfigurationOptimizer.class);
			for (String alg : algorithms) {
				Class<?> o = Registry.INSTANCE.getInstanceClass(alg);
				String displayName = Registry.INSTANCE.getDisplayName(o);
				displayNameTypeMapping.put(displayName, alg);
				IConfigurationOptimizer opt = (IConfigurationOptimizer) o.newInstance();
				if (opt.isSpecifierSupported(
						OptimizationFactory.eINSTANCE.createIterativeParameterOptimizerSpecifier()))
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
			itParaSpec = (IterativeParameterOptimizerSpecifier) structuredSelection.getFirstElement();
			createBindings();
		} else {
			itParaSpec = null;
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
						.observe(itParaSpec));
		
		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpNumbSplits),
				EMFEditProperties
						.value(domain,
								OptimizationPackage.Literals.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS)
						.observe(itParaSpec));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpNumbExplor),
				EMFEditProperties
						.value(domain,
								OptimizationPackage.Literals.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS)
						.observe(itParaSpec));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpNumbIter),
				EMFEditProperties
						.value(domain,
								OptimizationPackage.Literals.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS)
						.observe(itParaSpec));
	}
}
