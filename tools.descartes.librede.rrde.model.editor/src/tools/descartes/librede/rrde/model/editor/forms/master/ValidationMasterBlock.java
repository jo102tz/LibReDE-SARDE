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
package tools.descartes.librede.rrde.model.editor.forms.master;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.ValidatorConfiguration;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.forms.details.ParametersDetailsPage;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;
import tools.descartes.librede.validation.IValidator;

public class ValidationMasterBlock extends AbstractMasterBlock implements IDetailsPageProvider {

	private Table tableValidators;
	private CheckboxTableViewer tableValidatorsViewer;
	private RunCall input;
	private Boolean createRecommendationBindings;

	private EMFDataBindingContext bindingContext = new EMFDataBindingContext();

	public ValidationMasterBlock(AdapterFactoryEditingDomain domain, LifeCycleConfiguration model,
			Boolean createRecommendationBindings) {
		super(domain, model);
		this.createRecommendationBindings = createRecommendationBindings;

	}

	private void initializeValues() {
		// prevent NullPointerException if no RunCall was added and the Page is
		// selected
		if (input == null) {
			try {
				input = model.getOptimizationConfiguration().getContainsOf().get(0);
			} catch (Exception e) {
				input = OptimizationFactory.eINSTANCE.createRunCall();
				OptimizationSettings settings = OptimizationFactory.eINSTANCE.createOptimizationSettings();
				settings.setValidator(ConfigurationFactory.eINSTANCE.createValidationSpecification());
				input.setSettings(settings);
				Command cmd = AddCommand.create(domain, model.getOptimizationConfiguration(),
						OptimizationPackage.Literals.OPTIMIZATION_CONFIGURATION__CONTAINS_OF, input);
				domain.getCommandStack().execute(cmd);

			}
		}

	}

	@Override
	protected String getMasterSectionTitle() {
		return "All Validators";
	}

	@Override
	protected Control createItemsList(Composite parent) {
		tableValidatorsViewer = CheckboxTableViewer.newCheckList(parent,
				SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
		tableValidators = tableValidatorsViewer.getTable();
		tableValidators.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		toolkit.paintBordersFor(tableValidators);

		tableValidatorsViewer.setContentProvider(new ObservableListContentProvider());
		tableValidatorsViewer.setLabelProvider(new AdapterFactoryLabelProvider(page.getAdapterFactory()));

		tableValidatorsViewer.addSelectionChangedListener(this);

		registerViewer(tableValidatorsViewer);

		createValidatorBindings();
		return tableValidators;
	}

	private void createValidatorBindings() {
		// We need to add the existing validators in the configuration first, so
		// that the test for
		// equality in the checked table binding works correctly. EMF always
		// does an equality check on
		// the object instance.
		IObservableList validators = new WritableList();
		Set<String> existingValidators = new HashSet<String>();
		if (createRecommendationBindings == false && input != null) {

			if (input.getSettings() == null) {
				Command cmd = SetCommand.create(domain, input, OptimizationPackage.Literals.RUN_CALL__SETTINGS,
						OptimizationFactory.eINSTANCE.createOptimizationSettings());
				domain.getCommandStack().execute(cmd);
			}
			if (input.getSettings().getValidator() == null) {
				Command cmd = SetCommand.create(domain, input.getSettings(),
						OptimizationPackage.Literals.OPTIMIZATION_SETTINGS__VALIDATOR,
						ConfigurationFactory.eINSTANCE.createValidationSpecification());
				domain.getCommandStack().execute(cmd);
			}
			for (ValidatorConfiguration v : input.getSettings().getValidator().getValidators()) {
				validators.add(v);
				existingValidators.add(v.getType());
			}
			for (String instance : Registry.INSTANCE.getInstances(IValidator.class)) {
				if (!existingValidators.contains(instance)) {
					ValidatorConfiguration a = ConfigurationFactory.eINSTANCE.createValidatorConfiguration();
					a.setType(instance);
					validators.add(a);
				}
			}
			if (tableValidatorsViewer != null)
				tableValidatorsViewer.setInput(validators);

			if (tableValidatorsViewer != null) {
				// Binding: All checked validators are added to the model
				// instance
				bindingContext.bindSet(
						ViewerProperties.checkedElements(ValidatorConfiguration.class).observe(tableValidatorsViewer),
						EMFEditProperties.set(domain,
								FeaturePath.fromList(OptimizationPackage.Literals.RUN_CALL__SETTINGS,
										OptimizationPackage.Literals.OPTIMIZATION_SETTINGS__VALIDATOR,
										ConfigurationPackage.Literals.VALIDATION_SPECIFICATION__VALIDATORS))

								.observe(input));
			}

		}
		if (createRecommendationBindings == true) {
			// create Bindings for recommendation Page
			if (model.getRecommendationConfiguration().getValidator() == null) {
				model.getRecommendationConfiguration().eSet(
						RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR,
						ConfigurationFactory.eINSTANCE.createValidationSpecification());
			}
			for (ValidatorConfiguration v : model.getRecommendationConfiguration().getValidator().getValidators()) {
				validators.add(v);
				existingValidators.add(v.getType());
			}
			for (String instance : Registry.INSTANCE.getInstances(IValidator.class)) {
				if (!existingValidators.contains(instance)) {
					ValidatorConfiguration a = ConfigurationFactory.eINSTANCE.createValidatorConfiguration();
					a.setType(instance);
					validators.add(a);
				}
			}
			if (tableValidatorsViewer != null)
				tableValidatorsViewer.setInput(validators);

			if (tableValidatorsViewer != null) {
				// Binding: All checked validators are added to the model
				// instance
				bindingContext.bindSet(
						ViewerProperties.checkedElements(ValidatorConfiguration.class).observe(tableValidatorsViewer),
						EMFEditProperties
								.set(domain,
										FeaturePath.fromList(
												RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR,
												ConfigurationPackage.Literals.VALIDATION_SPECIFICATION__VALIDATORS))
								.observe(model.getRecommendationConfiguration()));
			}
		}
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.setPageProvider(this);
	}

	@Override
	public Object getPageKey(Object object) {
		if (object instanceof ValidatorConfiguration) {
			return ((ValidatorConfiguration) object).getType();
		}
		return null;
	}

	@Override
	public IDetailsPage getPage(Object key) {
		return new ParametersDetailsPage(page, domain, "Validator Configuration",
				ConfigurationPackage.Literals.VALIDATOR_CONFIGURATION, (String) key,
				ConfigurationPackage.Literals.VALIDATOR_CONFIGURATION__PARAMETERS);
	}

	public void runCallPageSelectionChanged() {
		input = SelectionProvider.INSTANCE().getSelectedRunCall();
		if (input != null) {
			if (tableValidatorsViewer != null) {
				if (bindingContext != null)
					bindingContext.dispose();
				bindingContext = new EMFDataBindingContext();
				createValidatorBindings();
			}
		} else {
			if (tableValidatorsViewer != null) {
				tableValidatorsViewer.setInput(input);
				tableValidatorsViewer.refresh();
				if (bindingContext != null)
					bindingContext.dispose();
			}
		}
	}

}
