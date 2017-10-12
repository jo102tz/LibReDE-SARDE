package tools.descartes.librede.rrde.model.editor.forms.master;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.DetailsPart;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.InputSpecification;
import tools.descartes.librede.configuration.TraceConfiguration;
import tools.descartes.librede.configuration.WorkloadDescription;
import tools.descartes.librede.configuration.editor.forms.ClassesViewerFilter;
import tools.descartes.librede.rrde.model.editor.forms.details.InputDataDetailsPage;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;

import tools.descartes.librede.rrde.model.optimization.impl.InputDataImpl;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;

public class EstimationSelectionMasterBlock extends AbstractMasterBlockWithButtons {

	private Table estimationTable;
	private TableViewer estimationViewer;

	private LifeCycleConfiguration model;

	public EstimationSelectionMasterBlock(AdapterFactoryEditingDomain domain, LifeCycleConfiguration model) {
		super(domain, model);
		this.model = model;
	}

	@Override
	protected void handleAdd() {
		EstimationSpecification spec = ConfigurationFactory.eINSTANCE.createEstimationSpecification();

		Command cmd = AddCommand.create(domain, model.getRecommendationConfiguration(),
				RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS, spec);
		domain.getCommandStack().execute(cmd);
		
		
	}

	@Override
	protected void handleRemove() {
		IStructuredSelection selection = (IStructuredSelection) estimationViewer.getSelection();
		Iterator<?> iterator = selection.iterator();
		while (iterator.hasNext()) {
			Object o = iterator.next();
			if (o instanceof InputData) {
				Command cmd = RemoveCommand.create(domain, o);
				domain.getCommandStack().execute(cmd);
			}
		}

		// after remove inform other pages that the selection changed, to
		// refresh their view by passing null to the pages
		ISelection sel = new StructuredSelection();
		SelectionChangedEvent event = new SelectionChangedEvent(estimationViewer, sel);
		SelectionProvider.INSTANCE().inputDataPageSelectionChanged(event);

	}

	@Override
	protected String getMasterSectionTitle() {
		return "Estimation Selection - Edit selected on next page";
	}

	@Override
	protected Control createItemsList(Composite parent) {
		estimationViewer = new TableViewer(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		estimationTable = estimationViewer.getTable();

		estimationViewer.setContentProvider(new AdapterFactoryContentProvider(page.getAdapterFactory()));
		estimationViewer.setLabelProvider(new EstimationLabelProvider());
		
		estimationViewer.setInput(model.getRecommendationConfiguration());
		estimationViewer.addFilter(new ClassesViewerFilter(RecommendationTrainingConfiguration.class, EstimationSpecification.class));
		estimationViewer.addSelectionChangedListener(this);

		registerViewer(estimationViewer);
		return estimationTable;
	}
	
	public class EstimationLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			return "Estimation Specification";
		}
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {

	}


	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		managedForm.fireSelectionChanged(masterPart, event.getSelection());

		// pass the selection to the singleton so other FormPages can access it

		if (((IStructuredSelection) event.getSelection()).size() == 1) {
			SelectionProvider.INSTANCE().estimationPageSelectionChanged(event);

		}
	}
}
