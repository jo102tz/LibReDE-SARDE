package tools.descartes.librede.rrde.model.editor.forms.details;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.widgets.Section;

import tools.descartes.librede.rrde.model.editor.forms.AbstractLifecycleConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.forms.AbstractOptimizationConfigurationFormPage;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;

public class OptimizableParameterDetailsPage extends AbstractDetailsPage {

	private Text inpLowerBound;
	private Text inpUpperBound;
	private Text inpStartValue;
	private IOptimizableParameter paraInput;

	private EMFDataBindingContext detailBindingContext;

	public OptimizableParameterDetailsPage(AbstractLifecycleConfigurationFormPage page,
			AdapterFactoryEditingDomain domain, LifeCycleConfiguration model) {
		super(page, domain);
	}

	@Override
	public void createContents(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Section sctnOptimizableParameter = managedForm.getToolkit().createSection(parent,
				Section.TWISTIE | Section.TITLE_BAR);
		sctnOptimizableParameter.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnOptimizableParameter);
		sctnOptimizableParameter.setText("Optimizable Parameter");
		sctnOptimizableParameter.setExpanded(true);

		Composite composite = new Composite(sctnOptimizableParameter, SWT.NONE);
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);
		sctnOptimizableParameter.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblNumbSplits = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNumbSplits, true, true);
		lblNumbSplits.setText("Lower Bound:");

		inpLowerBound = new Text(composite, SWT.BORDER);
		inpLowerBound.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpLowerBound, true, true);

		Label lblNumbExplor = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNumbExplor, true, true);
		lblNumbExplor.setText("Upper Bound:");

		inpUpperBound = new Text(composite, SWT.BORDER);
		inpUpperBound.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpUpperBound, true, true);

		Label lblNumbIter = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNumbIter, true, true);
		lblNumbIter.setText("Start Value:");

		inpStartValue = new Text(composite, SWT.BORDER);
		inpStartValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpStartValue, true, true);

	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (detailBindingContext != null) {
			detailBindingContext.dispose();
			detailBindingContext = null;
		}
		if (structuredSelection.size() == 1) {
			paraInput = (IOptimizableParameter) structuredSelection.getFirstElement();
			createBindings();
		} else {
			paraInput = null;
		}
		update();

	}

	private void createBindings() {
		detailBindingContext = new EMFDataBindingContext();

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpUpperBound),
				EMFEditProperties
						.value(domain,
								OptimizationPackage.Literals.IOPTIMIZABLE_PARAMETER__UPPER_BOUND)
						.observe(paraInput));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpLowerBound),
				EMFEditProperties
						.value(domain,
								OptimizationPackage.Literals.IOPTIMIZABLE_PARAMETER__LOWER_BOUND)
						.observe(paraInput));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpStartValue),
				EMFEditProperties
						.value(domain,
								OptimizationPackage.Literals.IOPTIMIZABLE_PARAMETER__START_VALUE)
						.observe(paraInput));

	}

}
