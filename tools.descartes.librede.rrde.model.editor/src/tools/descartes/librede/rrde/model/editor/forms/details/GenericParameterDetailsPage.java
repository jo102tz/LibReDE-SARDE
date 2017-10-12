package tools.descartes.librede.rrde.model.editor.forms.details;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.widgets.Section;

import tools.descartes.librede.algorithm.IEstimationAlgorithm;
import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.EstimationAlgorithmConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.Parameter;
import tools.descartes.librede.registry.Component;
import tools.descartes.librede.registry.ParameterDefinition;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.forms.AbstractLifecycleConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.forms.AbstractOptimizationConfigurationFormPage;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.GenericParameter;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.algorithm.IConfigurationOptimizer;

public class GenericParameterDetailsPage extends AbstractDetailsPage {

	private Text inpLowerBound;
	private Text inpUpperBound;
	private Text inpStartValue;
	private GenericParameter paraInput;
	private ComboViewer viewer;
	private EMFDataBindingContext detailBindingContext;
	private RunCall selectedRunCall;
	private IObservableList viewerInput;

	public GenericParameterDetailsPage(AbstractLifecycleConfigurationFormPage page,
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
		sctnOptimizableParameter.setText("Generic Parameter");
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

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		managedForm.getToolkit().adapt(lblNewLabel_2, true, true);		
		lblNewLabel_2.setText("Parameter:");
		viewer = new ComboViewer(composite, SWT.READ_ONLY);
		Combo combo = viewer.getCombo();
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		managedForm.getToolkit().paintBordersFor(combo);

		viewer.setContentProvider(new ObservableListContentProvider());
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(page.getAdapterFactory()));

		/*
		 * List<String> parameters = new ArrayList<String>();
		 * 
		 * // Set<Class<?>> allTypes = Registry.INSTANCE.getAllInstances();
		 * 
		 * // for (Class<?> type : allTypes) {
		 * 
		 * // get all Parameters for Estimation Algorithm and the Optimizer
		 * Set<String> allInstances =
		 * Registry.INSTANCE.getInstances(IEstimationAlgorithm.class);
		 * 
		 * for (String str : allInstances) { Class<?> curInstance =
		 * Registry.INSTANCE.getInstanceClass(str); if
		 * (curInstance.isAnnotationPresent(Component.class)) { for (Field field
		 * : curInstance.getDeclaredFields()) { ParameterDefinition def =
		 * field.getAnnotation(ParameterDefinition.class); if (def != null) {
		 * parameters.add(def.name()); } } } // } }
		 * 
		 * viewer.setInput(parameters.toArray());
		 * 
		 * viewer.addPostSelectionChangedListener(new
		 * ISelectionChangedListener() {
		 * 
		 * @Override public void selectionChanged(SelectionChangedEvent event) {
		 * IStructuredSelection sel = (IStructuredSelection)
		 * event.getSelection(); if (sel.size() == 1) { String
		 * selParameterString = (String) sel.getFirstElement();
		 * 
		 * for (EstimationAlgorithmConfiguration conf :
		 * selectedRunCall.getEstimation().getAlgorithms()) { for (Parameter par
		 * : conf.getParameters()) { if
		 * (par.getName().equals(selParameterString)) { Command cmd =
		 * SetCommand.create(domain, paraInput,
		 * OptimizationPackage.Literals.GENERIC_PARAMETER__PARAMETER, par);
		 * domain.getCommandStack().execute(cmd); } } } }
		 * 
		 * } });
		 */
	}

	private void initParameters() {

		if (selectedRunCall.getEstimation() == null) {
			EstimationSpecification spec = ConfigurationFactory.eINSTANCE.createEstimationSpecification();

			Command cmd = SetCommand.create(domain, selectedRunCall, OptimizationPackage.Literals.RUN_CALL__ESTIMATION,
					spec);
			domain.getCommandStack().execute(cmd);
		}
		
		Set<String> existingAlgorithms = new HashSet<String>();
		for (EstimationAlgorithmConfiguration v : selectedRunCall.getEstimation().getAlgorithms()) {
			existingAlgorithms.add(v.getType());
		}
		for (String instance : Registry.INSTANCE.getInstances(IEstimationAlgorithm.class)) {
			if (!existingAlgorithms.contains(instance)) {
				EstimationAlgorithmConfiguration a = ConfigurationFactory.eINSTANCE
						.createEstimationAlgorithmConfiguration();
				a.setType(instance);
				Command cmd = AddCommand.create(domain, selectedRunCall.getEstimation(), ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__ALGORITHMS, a);
				domain.getCommandStack().execute(cmd);
			}
		}

		Set<String> existingParameters = new HashSet<String>();
		for (EstimationAlgorithmConfiguration conf : selectedRunCall.getEstimation().getAlgorithms()) {
			for (Parameter para : conf.getParameters()) {
				existingParameters.add(para.getName());
			}
		}
		// initialize the parameters of estimation algorithms so the are available to be added as optimizable parameter
		for (String type : Registry.INSTANCE.getInstances(IEstimationAlgorithm.class)) {
			Class<?> classType = Registry.INSTANCE.getInstanceClass(type);
			if (classType != null) {
				if (classType.isAnnotationPresent(Component.class)) {
					for (Field field : classType.getDeclaredFields()) {
						ParameterDefinition paraDef = field.getAnnotation(ParameterDefinition.class);
						if (paraDef != null) {
							for (EstimationAlgorithmConfiguration config : selectedRunCall.getEstimation().getAlgorithms()) {
								if (!existingParameters.contains(paraDef.name()) && config.getType().equals(type)) {
									Parameter newPara = ConfigurationFactory.eINSTANCE.createParameter();
									newPara.setName(paraDef.name());
									newPara.setValue(paraDef.defaultValue());
									
									Command cmd = AddCommand.create(domain, config, ConfigurationPackage.Literals.ESTIMATION_ALGORITHM_CONFIGURATION__PARAMETERS, newPara);
									domain.getCommandStack().execute(cmd);
								}

							}
						}
					}
				}
			}
		}
	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		selectedRunCall = SelectionProvider.INSTANCE().getSelectedRunCall();
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		
		if (detailBindingContext != null) {
			detailBindingContext.dispose();
			detailBindingContext = null;
		}
		if (structuredSelection.size() == 1) {
			paraInput = (GenericParameter) structuredSelection.getFirstElement();
			initParameters();
			viewerInput = new WritableList();
			for (EstimationAlgorithmConfiguration conf : selectedRunCall.getEstimation().getAlgorithms()) {
				for (Parameter para : conf.getParameters()) {
					viewerInput.add(para);
				}
			}
			
			viewer.setInput(viewerInput);
			createBindings();
		} else {
			paraInput = null;
		}
		update();

	}

	private void createBindings() {
		detailBindingContext = new EMFDataBindingContext();

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpUpperBound), EMFEditProperties
				.value(domain, OptimizationPackage.Literals.IOPTIMIZABLE_PARAMETER__UPPER_BOUND).observe(paraInput));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpLowerBound), EMFEditProperties
				.value(domain, OptimizationPackage.Literals.IOPTIMIZABLE_PARAMETER__LOWER_BOUND).observe(paraInput));

		detailBindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(inpStartValue), EMFEditProperties
				.value(domain, OptimizationPackage.Literals.IOPTIMIZABLE_PARAMETER__START_VALUE).observe(paraInput));

		detailBindingContext.bindValue(ViewerProperties.singleSelection().observe(viewer), EMFEditProperties
				.value(domain, OptimizationPackage.Literals.GENERIC_PARAMETER__PARAMETER).observe(paraInput));

	}

}
