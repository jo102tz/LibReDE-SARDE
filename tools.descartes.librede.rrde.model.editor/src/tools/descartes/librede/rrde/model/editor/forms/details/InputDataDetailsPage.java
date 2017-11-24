package tools.descartes.librede.rrde.model.editor.forms.details;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.widgets.Section;

import tools.descartes.librede.rrde.model.editor.forms.AbstractLifecycleConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.forms.AbstractOptimizationConfigurationFormPage;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class InputDataDetailsPage extends AbstractDetailsPage {

	EMFDataBindingContext detailBindingContext;
	private InputData input;
	private Label lblNewLabel;
	private Text inpOutput;
	private DirectoryDialog directoryDialog;
	private Button btnMultiFolderStruct;

	public InputDataDetailsPage(AbstractLifecycleConfigurationFormPage page, AdapterFactoryEditingDomain domain,
			LifeCycleConfiguration model) {
		super(page, domain);

	}

	@Override
	public void createContents(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Section sctnNewSection = managedForm.getToolkit().createSection(parent, Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Edit");
		sctnNewSection.setExpanded(true);

		Composite composite = managedForm.getToolkit().createComposite(sctnNewSection, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(composite);
		sctnNewSection.setClient(composite);
		composite.setLayout(new GridLayout(3, false));

		Label lblNewLabel = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNewLabel, true, true);
		lblNewLabel.setText("Root Folder");

		inpOutput = new Text(composite, SWT.BORDER);
		inpOutput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(inpOutput, true, true);

		Button btnBrowse = managedForm.getToolkit().createButton(composite, "Browse ...", SWT.PUSH);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (directoryDialog == null) {
					directoryDialog = new DirectoryDialog(page.getSite().getShell(), SWT.OPEN);
				}
	
				String res = directoryDialog.open();
				if (res != null) {
					inpOutput.setText(res);
				}
			}
		});

		btnMultiFolderStruct = managedForm.getToolkit().createButton(composite, "", SWT.CHECK);
		managedForm.getToolkit().adapt(btnMultiFolderStruct, true, true);
		btnMultiFolderStruct.setText("Multidimensional");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (detailBindingContext != null) {
			detailBindingContext.dispose();
			detailBindingContext = null;
		}
		if (structuredSelection.size() == 1) {
			input = (InputData) structuredSelection.getFirstElement();

			createBindings();
		} else {
			input = null;
		}
		update();
	}

	protected void createBindings() {
		detailBindingContext = new EMFDataBindingContext();

		detailBindingContext.bindValue(WidgetProperties.selection().observe(btnMultiFolderStruct),
				EMFEditProperties.value(domain, OptimizationPackage.Literals.INPUT_DATA__MULTI_FOLDER_STRUCTURES)
						.observe(input));
		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpOutput),
				EMFEditProperties.value(domain, OptimizationPackage.Literals.INPUT_DATA__ROOT_FOLDER)
						.observe(input));	

	}

}
