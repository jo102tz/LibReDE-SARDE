package tools.descartes.librede.rrde.model.editor.forms.master;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.DetailsPart;

import tools.descartes.librede.algorithm.IEstimationAlgorithm;
import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.EstimationAlgorithmConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.Parameter;
import tools.descartes.librede.export.IExporter;
import tools.descartes.librede.registry.Component;
import tools.descartes.librede.registry.ParameterDefinition;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.forms.details.DataExportDetailsPage;
import tools.descartes.librede.rrde.model.editor.forms.details.IterativeParameterDetailsPage;
import tools.descartes.librede.rrde.model.editor.forms.details.LocalSearchDetailsPage;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.model.optimization.impl.DataExportSpecifierImpl;
import tools.descartes.librede.rrde.model.optimization.impl.IterativeParameterOptimizerSpecifierImpl;
import tools.descartes.librede.rrde.model.optimization.impl.LocalSearchSpecifierImpl;
import tools.descartes.librede.rrde.model.optimization.impl.RunCallImpl;
import tools.descartes.librede.rrde.model.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;

public class ConfigurationOptimizationAlgorithmSpecifierMasterPage extends AbstractMasterBlockWithButtons {

	private Table runCallTable;
	private TableViewer runCallViewer;
	private DataExportDetailsPage dataExportPage;
	private IterativeParameterDetailsPage parameterPage;
	private LocalSearchDetailsPage localSearchPage;
	private int counter = 0;

	private List<ConfigurationOptimizationAlgorithmSpecifier> configurationsList = new ArrayList<ConfigurationOptimizationAlgorithmSpecifier>();

	public ConfigurationOptimizationAlgorithmSpecifierMasterPage(AdapterFactoryEditingDomain domain,
			LifeCycleConfiguration model) {
		super(domain, model);
				
		initializeValues();
	}

	@Override
	protected void handleAdd() {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(page.getSite().getShell(),
				new LabelProvider());
		dialog.setElements(new String[] { "Local Search Specifier Algorithm", "Iterative Parameter Specifier Algorithm",
				"Data Export Specifier Algorithm" });
		dialog.setAllowDuplicates(false);
		dialog.setMultipleSelection(false);
		dialog.setTitle("Specifier Algorithm Types");
		dialog.setMessage("Select the specifier of the algorithm you want to use:");
		dialog.create();
		if (dialog.open() == Window.OK) {
			addAlgorithm(dialog.getResult());
		}

	}

	private void addAlgorithm(Object[] results) {

		for (Object result : results) {

			RunCall call = OptimizationFactory.eINSTANCE.createRunCall();
			if ((String) result == "Local Search Specifier Algorithm") {
				LocalSearchSpecifier spec = OptimizationFactory.eINSTANCE.createLocalSearchSpecifier();
				spec.setTimeOut(-1);
				spec.setTolerance(0.05);
				spec.setMaximumNumberOfSteps(-1);
				spec.setStepSize(1);

				call.setAlgorithm(spec);
				configurationsList.add(spec);
			} else if ((String) result == "Iterative Parameter Specifier Algorithm") {
				IterativeParameterOptimizerSpecifier spec = OptimizationFactory.eINSTANCE
						.createIterativeParameterOptimizerSpecifier();
				spec.setTimeOut(-1);
				spec.setNumberOfExplorations(3);
				spec.setNumberOfIterations(3);
				spec.setNumberOfSplits(3);

				call.setAlgorithm(spec);
				configurationsList.add(spec);
			} else if ((String) result == "Data Export Specifier Algorithm") {
				DataExportSpecifier spec = OptimizationFactory.eINSTANCE.createDataExportSpecifier();
				spec.setTimeOut(-1);
				spec.setOutputDirectory("");
				spec.setStepSize(1.0);
				spec.setMultidimensional(false);
				spec.setSplitConfigurations(true);

				call.setAlgorithm(spec);
				configurationsList.add(spec);
			}

			InputData inpData = OptimizationFactory.eINSTANCE.createInputData();
			call.getTrainingData().add(inpData);

			EstimationSpecification specification = ConfigurationFactory.eINSTANCE.createEstimationSpecification();
			call.setEstimation(specification);
			/*
			Set<String> existingAlgorithms = new HashSet<String>();
			for (EstimationAlgorithmConfiguration v : specification.getAlgorithms()) {
				existingAlgorithms.add(v.getType());
			}
			for (String instance : Registry.INSTANCE.getInstances(IEstimationAlgorithm.class)) {
				if (!existingAlgorithms.contains(instance)) {
					EstimationAlgorithmConfiguration a = ConfigurationFactory.eINSTANCE
							.createEstimationAlgorithmConfiguration();
					a.setType(instance);
					specification.getAlgorithms().add(a);
				}
			}

			Set<String> existingParameters = new HashSet<String>();
			for (EstimationAlgorithmConfiguration conf : specification.getAlgorithms()) {
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
								for (EstimationAlgorithmConfiguration config : specification.getAlgorithms()) {
									if (!existingParameters.contains(paraDef.name()) && config.getType().equals(type)) {
										Parameter newPara = ConfigurationFactory.eINSTANCE.createParameter();
										newPara.setName(paraDef.name());
										newPara.setValue(paraDef.defaultValue());
										config.getParameters().add(newPara);
									}

								}
							}
						}
					}
				}
			}
			*/

			OptimizationSettings settings = OptimizationFactory.eINSTANCE.createOptimizationSettings();
			call.setSettings(settings);

			Command cmd = AddCommand.create(domain, model.getOptimizationConfiguration(),
					OptimizationPackage.Literals.OPTIMIZATION_CONFIGURATION__CONTAINS_OF, call);
			domain.getCommandStack().execute(cmd);

		}
		runCallViewer.setInput(configurationsList);
		//runCallViewer.refresh();
	}

	@Override
	protected void handleRemove() {
		IStructuredSelection selection = (IStructuredSelection) runCallViewer.getSelection();
		Iterator<?> iterator = selection.iterator();
		Command cmd = null;
		while (iterator.hasNext()) {
			Object o = iterator.next();
			if (o instanceof LocalSearchSpecifier || o instanceof DataExportSpecifier
					|| o instanceof IterativeParameterOptimizerSpecifier) {
				Iterator<RunCall> iter = model.getOptimizationConfiguration().getContainsOf().iterator();
				while (iter.hasNext()) {
					RunCall call = iter.next();
					if (call.getAlgorithm() == o) {
						cmd = RemoveCommand.create(domain, call);

					}
				}
				domain.getCommandStack().execute(cmd);
				configurationsList.remove((ConfigurationOptimizationAlgorithmSpecifier) o);

			}
		}
		 runCallViewer.setInput(configurationsList);

		// after remove inform other pages that the selection changed, to
		// refresh their view by passing null to the pages
		ISelection sel = new StructuredSelection();
		SelectionChangedEvent event = new SelectionChangedEvent(runCallViewer, sel);
		SelectionProvider.INSTANCE().inputDataPageSelectionChanged(event);
		SelectionProvider.INSTANCE().runCallPageSelectionChanged(event);
	}

	@Override
	protected String getMasterSectionTitle() {

		return "Optimization Configuration";
	}

	public class ConfigurationLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof DataExportSpecifier) {
				
				
				return "Data Export Specifier";
			} else if (element instanceof IterativeParameterOptimizerSpecifier) {
				
				
				return "Iterative Parameter Specifier";
			} else if (element instanceof LocalSearchSpecifier) {
				
				
				return "Local Search Specifier";
			}
			return "none";
		}
	}

	@Override
	protected Control createItemsList(Composite parent) {
		runCallViewer = new TableViewer(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		runCallTable = runCallViewer.getTable();

		runCallViewer.setContentProvider(new ArrayContentProvider());
		runCallViewer.setLabelProvider(new ConfigurationLabelProvider());

		runCallViewer.setInput(configurationsList);
		runCallViewer.addSelectionChangedListener(this);

		registerViewer(runCallViewer);
		return runCallTable;
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		dataExportPage = new DataExportDetailsPage(page, domain, model);
		parameterPage = new IterativeParameterDetailsPage(page, domain, model);
		localSearchPage = new LocalSearchDetailsPage(page, domain, model);

		detailsPart.registerPage(DataExportSpecifierImpl.class, dataExportPage);
		detailsPart.registerPage(IterativeParameterOptimizerSpecifierImpl.class, parameterPage);
		detailsPart.registerPage(LocalSearchSpecifierImpl.class, localSearchPage);
	}

	protected void initializeValues() {

		for (RunCall call : model.getOptimizationConfiguration().getContainsOf()) {
			if (call.getAlgorithm() != null) {
				configurationsList.add(call.getAlgorithm());
			} else {
				LocalSearchSpecifier spec = OptimizationFactory.eINSTANCE.createLocalSearchSpecifier();
				spec.setTimeOut(-1);
				spec.setTolerance(0.05);
				spec.setMaximumNumberOfSteps(-1);
				spec.setStepSize(1);

				call.setAlgorithm(spec);
				configurationsList.add(spec);
				Command cmd = SetCommand.create(domain, call, OptimizationPackage.Literals.RUN_CALL__ALGORITHM, spec);
				domain.getCommandStack().execute(cmd);
			}
		}
		/*
		 * for (RunCall call : model.getContainsOf()) { if (call.getAlgorithm()
		 * == null) { ConfigurationOptimizationAlgorithmSpecifier spec =
		 * OptimizationFactory.eINSTANCE.
		 * createConfigurationOptimizationAlgorithmSpecifier();
		 * spec.setTimeOut(-1); spec.setAlgorithmName("Empty"); Command cmd =
		 * SetCommand.create(domain, call,
		 * OptimizationPackage.Literals.RUN_CALL__ALGORITHM, spec);
		 * domain.getCommandStack().execute(cmd);
		 * 
		 * DataExportSpecifier exp =
		 * OptimizationFactory.eINSTANCE.createDataExportSpecifier();
		 * exp.setMultidimensional(false); exp.setOutputDirectory("");
		 * exp.setSplitConfigurations(true); exp.setStepSize(1.0); cmd =
		 * SetCommand.create(domain, spec,
		 * OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER, exp);
		 * domain.getCommandStack().execute(cmd);
		 * 
		 * IterativeParameterOptimizerSpecifier para =
		 * OptimizationFactory.eINSTANCE.
		 * createIterativeParameterOptimizerSpecifier();
		 * para.setNumberOfExplorations(3); para.setNumberOfIterations(3);
		 * para.setNumberOfSplits(3); cmd = SetCommand.create(domain, spec,
		 * OptimizationPackage.Literals.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER,
		 * para); domain.getCommandStack().execute(cmd);
		 * 
		 * LocalSearchSpecifier loc =
		 * OptimizationFactory.eINSTANCE.createLocalSearchSpecifier();
		 * loc.setStepSize(1.0); loc.setMaximumNumberOfSteps(-1);
		 * loc.setTolerance(0.05); cmd = SetCommand.create(domain, spec,
		 * OptimizationPackage.Literals.LOCAL_SEARCH_SPECIFIER, loc);
		 * domain.getCommandStack().execute(cmd); } }
		 */
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {

		managedForm.fireSelectionChanged(masterPart, event.getSelection());

		// pass the selection to the singleton for selections so other FormPages
		// can access it

		if (((IStructuredSelection) event.getSelection()).size() == 1 || model.getOptimizationConfiguration().getContainsOf().size() == 0) {
			SelectionProvider.INSTANCE().runCallPageSelectionChanged(event);
		}
	}

}
