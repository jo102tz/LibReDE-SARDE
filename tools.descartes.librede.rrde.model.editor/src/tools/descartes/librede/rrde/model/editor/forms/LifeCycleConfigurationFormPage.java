package tools.descartes.librede.rrde.model.editor.forms;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import tools.descartes.librede.rrde.model.actions.RunLifecycleAction;
import tools.descartes.librede.rrde.model.actions.RunOptimizationAction;
import tools.descartes.librede.rrde.model.actions.RunRecommendationAction;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage;
import tools.descartes.librede.rrde.model.lifecycle.presentation.LifecycleEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class LifeCycleConfigurationFormPage extends AbstractLifecycleConfigurationFormPage {

	private ScrolledForm form;
	private Text optLoopTime;
	private Text recLoopTime;
	private Text selLoopTime;
	private Section loopTimeSection;

	private EMFDataBindingContext bindingContext = new EMFDataBindingContext();

	public LifeCycleConfigurationFormPage(LifecycleEditor editor, String id, String title,
			AdapterFactoryEditingDomain editingDomain, LifeCycleConfiguration model) {
		super(editor, id, title, editingDomain, model);
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		managedForm.getForm().setText("Lifeycle Configuration");
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
		gridLayout.numColumns = 1;
		gridLayout.marginBottom = 12;
		gridLayout.marginTop = 12;
		gridLayout.marginLeft = 6;
		gridLayout.marginRight = 6;
		gridLayout.verticalSpacing = 17;
		gridLayout.horizontalSpacing = 20;
		managedForm.getForm().getBody().setLayout(gridLayout);

		loopTimeSection = toolkit.createSection(body, Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_loopTimeSection = new GridData(GridData.FILL_BOTH);
		loopTimeSection.setLayoutData(gd_loopTimeSection);
		toolkit.paintBordersFor(loopTimeSection);
		loopTimeSection.setText("Loop Times");
		loopTimeSection.setExpanded(true);

		Composite loopTimeSectionComposite = managedForm.getToolkit().createComposite(loopTimeSection, SWT.NONE);
		loopTimeSection.setClient(loopTimeSectionComposite);
		managedForm.getToolkit().paintBordersFor(loopTimeSectionComposite);
		loopTimeSectionComposite.setLayout(new GridLayout(2, true));

		Label lblNewLabel = managedForm.getToolkit().createLabel(loopTimeSectionComposite, "Optimization Loop Time:",
				SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));

		optLoopTime = managedForm.getToolkit().createText(loopTimeSectionComposite,
				Long.toString(getModel().getOptimizationLoopTime()), SWT.BORDER);
		optLoopTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_1 = managedForm.getToolkit().createLabel(loopTimeSectionComposite,
				"Recommendation Loop Time:", SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));

		recLoopTime = managedForm.getToolkit().createText(loopTimeSectionComposite,
				Long.toString(getModel().getRecommendationLoopTime()), SWT.BORDER);
		recLoopTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_2 = managedForm.getToolkit().createLabel(loopTimeSectionComposite, "Selection Loop Time:",
				SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));

		selLoopTime = managedForm.getToolkit().createText(loopTimeSectionComposite,
				Long.toString(getModel().getSelectionLoopTime()), SWT.BORDER);
		selLoopTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		optLoopTime.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				try {
					getModel().eSet(LifecyclePackage.Literals.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME,
							Long.parseLong(optLoopTime.getText()));

				} catch (NumberFormatException error) {
					System.out.println("Not a valid long. Change not propagated to model.");
				}

			}
		});

		recLoopTime.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				try {
					getModel().eSet(LifecyclePackage.Literals.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME,
							Long.parseLong(recLoopTime.getText()));

				} catch (NumberFormatException error) {
					System.out.println("Not a valid long. Change not propagated to model.");
				}

			}
		});

		selLoopTime.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				try {
					getModel().eSet(LifecyclePackage.Literals.LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME,
							Long.parseLong(selLoopTime.getText()));

				} catch (NumberFormatException error) {
					System.out.println("Not a valid long. Change not propagated to model.");
				}

			}
		});

	}
}
