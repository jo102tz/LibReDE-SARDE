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

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.LibredeConfiguration;

import tools.descartes.librede.configuration.presentation.ConfigurationEditor;
import tools.descartes.librede.rrde.model.editor.forms.master.AbstractMasterBlock;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.presentation.LifecycleEditor;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.model.optimization.presentation.OptimizationEditor;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;

public class ValidationFormPage extends MasterDetailsFormPage {

	private Button btnCrossValidation;
	private Spinner spnFolds;
	private EMFDataBindingContext bindingContext = new EMFDataBindingContext();
	private String title;
	private RunCall input;
	private LifeCycleConfiguration model;

	public ValidationFormPage(LifecycleEditor editor, String id, String title, String icon,
			AdapterFactoryEditingDomain editingDomain, LifeCycleConfiguration model, AbstractMasterBlock masterBlock) {
		super(editor, id, title, icon, editingDomain, model, masterBlock);
		this.title = title;
		this.model = model;
	}

	@Override
	protected void createFormContentBeginning(FormToolkit toolkit, Composite parent) {
		super.createFormContentBeginning(toolkit, parent);
		createCrossValidationSection(toolkit, parent);
	}

	private void createCrossValidationSection(FormToolkit toolkit, Composite body) {
		Section sctnCrossValidation = toolkit.createSection(body, Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_sctnCrossValidation = new GridData(GridData.FILL_HORIZONTAL);
		gd_sctnCrossValidation.horizontalSpan = 2;
		sctnCrossValidation.setLayoutData(gd_sctnCrossValidation);
		sctnCrossValidation.setText("Cross-Validation Settings");
		sctnCrossValidation.setExpanded(true);

		Composite client = toolkit.createComposite(sctnCrossValidation, SWT.NONE);
		sctnCrossValidation.setClient(client);
		toolkit.paintBordersFor(client);
		client.setLayout(new GridLayout(2, false));

		btnCrossValidation = toolkit.createButton(client, "Run k-Fold Cross-Validation", SWT.CHECK);
		GridData gd_btnCrossValidation = new GridData();
		gd_btnCrossValidation.horizontalSpan = 2;
		btnCrossValidation.setLayoutData(gd_btnCrossValidation);

		toolkit.createLabel(client, "Number of Folds k:");
		spnFolds = new Spinner(client, SWT.BORDER);
		spnFolds.setMinimum(1);
		spnFolds.setMaximum(Integer.MAX_VALUE);
		toolkit.paintBordersFor(spnFolds);
		createBindings();
	}

	private void createBindings() {
		if (title.equals("Opt. Validator") && input != null) {
			bindingContext.bindValue(WidgetProperties.selection().observe(btnCrossValidation),
					EMFEditProperties
							.value(getEditingDomain(),
									FeaturePath.fromList(OptimizationPackage.Literals.RUN_CALL__SETTINGS,
											OptimizationPackage.Literals.OPTIMIZATION_SETTINGS__VALIDATOR,
											ConfigurationPackage.Literals.VALIDATION_SPECIFICATION__VALIDATE_ESTIMATES))
							.observe(input));
			bindingContext.bindValue(WidgetProperties.selection().observe(spnFolds),
					EMFEditProperties
							.value(getEditingDomain(),
									FeaturePath.fromList(OptimizationPackage.Literals.RUN_CALL__SETTINGS,
											OptimizationPackage.Literals.OPTIMIZATION_SETTINGS__VALIDATOR,
											ConfigurationPackage.Literals.VALIDATION_SPECIFICATION__VALIDATION_FOLDS))
							.observe(input));
		}
		if (title.equals("Rec. Validation") && spnFolds != null) {
			// create Recommendation bindings
			if (model.getRecommendationConfiguration().getValidator() == null) {
				model.getRecommendationConfiguration().eSet(
						RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR,
						ConfigurationFactory.eINSTANCE.createValidationSpecification());
			}
			bindingContext.bindValue(WidgetProperties.selection().observe(btnCrossValidation),
					EMFEditProperties
							.value(getEditingDomain(),
									FeaturePath.fromList(
											RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR,
											ConfigurationPackage.Literals.VALIDATION_SPECIFICATION__VALIDATE_ESTIMATES))
							.observe(model.getRecommendationConfiguration()));

			bindingContext.bindValue(WidgetProperties.selection().observe(spnFolds),
					EMFEditProperties
							.value(getEditingDomain(),
									ConfigurationPackage.Literals.VALIDATION_SPECIFICATION__VALIDATION_FOLDS)
							.observe(model.getRecommendationConfiguration().getValidator()));
		}
	}

	public void runCallPageSelectionChanged() {
		input = SelectionProvider.INSTANCE().getSelectedRunCall();
		if (btnCrossValidation != null && input != null)
			createBindings();
	}

}
