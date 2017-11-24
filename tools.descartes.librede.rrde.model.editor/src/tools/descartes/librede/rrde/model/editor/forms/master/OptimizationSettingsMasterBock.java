package tools.descartes.librede.rrde.model.editor.forms.master;

import java.util.Iterator;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IFormPart;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.EstimationAlgorithmConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.ExporterConfiguration;
import tools.descartes.librede.configuration.TraceConfiguration;
import tools.descartes.librede.configuration.editor.forms.ClassesViewerFilter;
import tools.descartes.librede.export.IExporter;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.forms.details.DataExportDetailsPage;
import tools.descartes.librede.rrde.model.editor.forms.details.GenericParameterDetailsPage;
import tools.descartes.librede.rrde.model.editor.forms.details.IterativeParameterDetailsPage;
import tools.descartes.librede.rrde.model.editor.forms.details.LocalSearchDetailsPage;
import tools.descartes.librede.rrde.model.editor.forms.details.OptimizableParameterDetailsPage;
import tools.descartes.librede.rrde.model.editor.util.InputDataRegistry;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.model.optimization.impl.DataExportSpecifierImpl;
import tools.descartes.librede.rrde.model.optimization.impl.GenericParameterImpl;
import tools.descartes.librede.rrde.model.optimization.impl.StepSizeImpl;
import tools.descartes.librede.rrde.model.optimization.impl.WindowSizeImpl;

public class OptimizationSettingsMasterBock extends AbstractMasterBlockWithButtons {

	private Table optSettingsTable;
	private TableViewer optSettingsViewer;
	private OptimizableParameterDetailsPage optParameterPage;
	private GenericParameterDetailsPage genParameterPage;
	EMFDataBindingContext bindingContext;
	private RunCall input;

	public OptimizationSettingsMasterBock(AdapterFactoryEditingDomain domain, LifeCycleConfiguration model) {
		super(domain, model);

	}

	private void initializeValues() {
		// prevent NullPointerException if no RunCall was added and the Page is
		// selected
		if (input == null) {
			try {
				input = model.getOptimizationConfiguration().getContainsOf().get(0);
			} catch (Exception e) {
				input = OptimizationFactory.eINSTANCE.createRunCall();

				input.setSettings(OptimizationFactory.eINSTANCE.createOptimizationSettings());
				Command cmd = AddCommand.create(domain, model.getOptimizationConfiguration(),
						OptimizationPackage.Literals.OPTIMIZATION_CONFIGURATION__CONTAINS_OF, input);
				domain.getCommandStack().execute(cmd);

			}
		}

	}

	@Override
	protected void handleAdd() {
		if (input == null) {
			MessageDialog.openInformation(page.getSite().getShell(), "Info",
					"Select the RunCall, for which the parameters should be added, on the RunCall page first.");
			return;
		}

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(page.getSite().getShell(),
				new LabelProvider());
		dialog.setElements(new String[] { "Generic Parameter", "Window Size", "Step Size" });
		dialog.setAllowDuplicates(false);
		dialog.setMultipleSelection(false);
		dialog.setTitle("Optimizabel Parameter Types");
		dialog.setMessage("Select a type for the new optmizable Parameter:");
		dialog.create();
		if (dialog.open() == Window.OK) {
			addOptimizableParameter(dialog.getResult());
		}
	}

	private void addOptimizableParameter(Object[] objects) {
		for (Object r : objects) {
			IOptimizableParameter para = null;
			if ((String) r == "Generic Parameter") {
				para = OptimizationFactory.eINSTANCE.createGenericParameter();
			} else if ((String) r == "Window Size") {
				para = OptimizationFactory.eINSTANCE.createWindowSize();
			} else if ((String) r == "Step Size") {
				para = OptimizationFactory.eINSTANCE.createStepSize();
			}
			if (para == null)
				return;

			para.setLowerBound(0.0);
			para.setStartValue(0.0);
			para.setUpperBound(1.0);

			Command cmd = AddCommand.create(domain, input.getSettings(),
					OptimizationPackage.Literals.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE, para);
			domain.getCommandStack().execute(cmd);
		}
	}

	@Override
	protected void handleRemove() {
		IStructuredSelection selection = (IStructuredSelection) optSettingsViewer.getSelection();
		Iterator<?> iterator = selection.iterator();
		while (iterator.hasNext()) {
			Object o = iterator.next();
			if (o instanceof IOptimizableParameter) {
				Command cmd = RemoveCommand.create(domain, o);
				domain.getCommandStack().execute(cmd);
			}
		}
	}

	@Override
	protected String getMasterSectionTitle() {
		return "Optimization Settings";
	}

	@Override
	protected Control createItemsList(Composite parent) {
		optSettingsViewer = new TableViewer(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		optSettingsTable = optSettingsViewer.getTable();

		optSettingsViewer.setContentProvider(new AdapterFactoryContentProvider(page.getAdapterFactory()));
		optSettingsViewer.setLabelProvider(new AdapterFactoryLabelProvider(page.getAdapterFactory()));
		if (input != null) {
			optSettingsViewer.setInput(input.getSettings());
			managedForm.getForm().setText("Optimization Parameters - Currently editing " + InputDataRegistry.INSTANCE.getLabelFromRunCall(input));
		} else {
			managedForm.getForm().setText("Optimization Parameters - No RunCall selected.");
		}
		
		optSettingsViewer.addFilter(new ClassesViewerFilter(OptimizationSettings.class, IOptimizableParameter.class));
		optSettingsViewer.addSelectionChangedListener(this);

		registerViewer(optSettingsViewer);
		return optSettingsTable;
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		optParameterPage = new OptimizableParameterDetailsPage(page, domain, model);
		genParameterPage = new GenericParameterDetailsPage(page, domain, model);
		detailsPart.registerPage(WindowSizeImpl.class, optParameterPage);
		detailsPart.registerPage(StepSizeImpl.class, optParameterPage);
		detailsPart.registerPage(GenericParameterImpl.class, genParameterPage);

	}

	public void runCallPageSelectionChanged() {
		input = SelectionProvider.INSTANCE().getSelectedRunCall();

		if (input != null) {
			if (optSettingsViewer != null) {
				optSettingsViewer.setInput(input.getSettings());
				managedForm.getForm().setText("Optimization Parameters - Currently editing "
					+ InputDataRegistry.INSTANCE.getLabelFromRunCall(input));
				
			}
		} else {
			if (btnAdd != null && optSettingsViewer != null) {
				optSettingsViewer.setInput(input);
				managedForm.getForm().setText("Optimization Parameters - No RunCall selected.");
				optSettingsViewer.refresh();
			}
		}
	}

}
