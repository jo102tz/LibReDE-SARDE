package tools.descartes.librede.rrde.model.editor.forms.master;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import tools.descartes.librede.algorithm.IEstimationAlgorithm;
import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.EstimationAlgorithmConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.editor.forms.ClassesViewerFilter;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;

public class EstimationApproachesRecommendationMasterBlock extends EstimationApproachesMasterBlock {
	
	private EstimationSpecification input;
	
	public EstimationApproachesRecommendationMasterBlock(AdapterFactoryEditingDomain domain,
			LifeCycleConfiguration model) {
		super(domain, model);		
	}
	

	@Override
	protected Control createItemsList(Composite composite) {
		tableAlgorithmsViewer = new TableViewer(composite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		tableAlgorithms = tableAlgorithmsViewer.getTable();

		tableAlgorithmsViewer.setLabelProvider(new AdapterFactoryLabelProvider(page.getAdapterFactory()));
		tableAlgorithmsViewer.setContentProvider(new AdapterFactoryContentProvider(page.getAdapterFactory()));
		if (input != null) {
			existAlgorithmAdder();
			tableAlgorithmsViewer.setInput(input);
		}
		tableAlgorithmsViewer.addFilter(
				new ClassesViewerFilter(EstimationSpecification.class, EstimationAlgorithmConfiguration.class));
		tableAlgorithmsViewer.addSelectionChangedListener(this);

		registerViewer(tableAlgorithmsViewer);

		return tableAlgorithms;
	}
	
	@Override
	protected void existAlgorithmAdder() {
		// We need to add the existing validators in the configuration
		// first, so
		// that the test for
		// equality in the checked table binding works correctly. EMF always
		// does an equality check on
		// the object instance.
		Set<String> existingAlgorithms = new HashSet<String>();
		for (EstimationAlgorithmConfiguration v : input.getAlgorithms()) {
			existingAlgorithms.add(v.getType());
		}
		for (String instance : Registry.INSTANCE.getInstances(IEstimationAlgorithm.class)) {
			if (!existingAlgorithms.contains(instance)) {
				EstimationAlgorithmConfiguration a = ConfigurationFactory.eINSTANCE
						.createEstimationAlgorithmConfiguration();
				a.setType(instance);
				Command cmd = AddCommand.create(domain, input,
						ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__ALGORITHMS, a);
				domain.getCommandStack().execute(cmd);
			}
		}
	}
	
	public void estimationPageSelectionChanged() {
		input = SelectionProvider.INSTANCE().getSelectedEstimationSpecification();
		if (input != null) {

			if (tableAlgorithmsViewer != null) {
				existAlgorithmAdder();
				tableAlgorithmsViewer.setInput(input);
			}
		} else {
			if (tableAlgorithmsViewer != null) {
				tableAlgorithmsViewer.setInput(input);
				tableAlgorithmsViewer.refresh();
			}
			
			
		}
	}
	
}
