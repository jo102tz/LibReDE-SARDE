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

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.DetailsPart;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.InputSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.ModelEntity;
import tools.descartes.librede.configuration.TraceConfiguration;
import tools.descartes.librede.configuration.TraceToEntityMapping;
import tools.descartes.librede.configuration.WorkloadDescription;
import tools.descartes.librede.configuration.editor.forms.ClassesViewerFilter;

import tools.descartes.librede.configuration.impl.FileTraceConfigurationImpl;
import tools.descartes.librede.metrics.Aggregation;
import tools.descartes.librede.metrics.StandardMetrics;
import tools.descartes.librede.rrde.model.editor.forms.details.FileTraceDetailsPage;
import tools.descartes.librede.rrde.model.editor.util.InputDataRegistry;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.UnitsFactory;

public class TracesMasterBlock extends AbstractMasterBlockWithButtons {

	private Table tableTraces;
	private TableViewer tableTracesViewer;
	private FileTraceDetailsPage details;

	private InputData inputData;

	/**
	 * Create the master details block.
	 */
	public TracesMasterBlock(AdapterFactoryEditingDomain domain, LifeCycleConfiguration model) {
		super(domain, model);

	}

	/**
	 * Register the pages.
	 * 
	 * @param part
	 */
	@Override
	protected void registerPages(DetailsPart part) {
		details = new FileTraceDetailsPage(page, domain, model);
		part.registerPage(FileTraceConfigurationImpl.class, details);
	}

	@Override
	protected String getMasterSectionTitle() {
		return "All Measurement Traces";
	}

	@Override
	protected Control createItemsList(Composite parent) {
		tableTracesViewer = new TableViewer(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		tableTraces = tableTracesViewer.getTable();

		tableTracesViewer.setContentProvider(new AdapterFactoryContentProvider(page.getAdapterFactory()));
		tableTracesViewer.setLabelProvider(new AdapterFactoryLabelProvider(page.getAdapterFactory()));
		if (inputData != null) {
			tableTracesViewer.setInput(inputData.getInput());
			managedForm.getForm().setText("Traces - Currently editing " + InputDataRegistry.INSTANCE.getLabelFromInputData(inputData));
		} else {
			managedForm.getForm().setText("Traces - No Input Data selected.");
		}
		tableTracesViewer.addFilter(new ClassesViewerFilter(InputSpecification.class, TraceConfiguration.class));
		tableTracesViewer.addSelectionChangedListener(this);

		registerViewer(tableTracesViewer);

		return tableTraces;
	}

	@Override
	protected void handleAdd() {
		if (inputData != null) {
			TraceConfiguration series = null;

			// The user can select any trace before clicking add
			// and the new configuration will have the same initial values
			ISelection sel = tableTracesViewer.getSelection();
			if (!sel.isEmpty()) {
				TraceConfiguration selSeries = (TraceConfiguration) ((IStructuredSelection) sel).getFirstElement();
				series = EcoreUtil.copy(selSeries);
			}

			if (series == null) {
				series = ConfigurationFactory.eINSTANCE.createFileTraceConfiguration();

				// Initialize default values
				if (inputData.getInput() == null) {
					InputSpecification inpSpec = ConfigurationFactory.eINSTANCE.createInputSpecification();
					Command cmd = SetCommand.create(domain, inputData, OptimizationPackage.Literals.INPUT_DATA__INPUT,
							inpSpec);
					domain.getCommandStack().execute(cmd);
				}

				if (inputData.getWorkloadDescription() == null) {
					WorkloadDescription desc = ConfigurationFactory.eINSTANCE.createWorkloadDescription();
					Command cmd = SetCommand.create(domain, inputData,
							OptimizationPackage.Literals.INPUT_DATA__WORKLOAD_DESCRIPTION, desc);
					domain.getCommandStack().execute(cmd);
				}
				if (inputData.getInput().getDataSources().size() > 0) {
					series.setDataSource(inputData.getInput().getDataSources().get(0));
					series.setMetric(StandardMetrics.RESPONSE_TIME);
					series.setUnit(Time.INSTANCE.getBaseUnit());
					series.setAggregation(Aggregation.NONE);
					Quantity<Time> interval = UnitsFactory.eINSTANCE.createQuantity();
					interval.setUnit(Time.SECONDS);
					interval.setValue(0);
					series.setInterval(interval);

					ModelEntity entity = null;
					if (inputData.getWorkloadDescription().getResources().size() > 0) {
						entity = inputData.getWorkloadDescription().getResources().get(0);
					} else if (inputData.getWorkloadDescription().getServices().size() > 0) {
						entity = inputData.getWorkloadDescription().getServices().get(0);
					}

					if (entity != null) {
						TraceToEntityMapping mapping = ConfigurationFactory.eINSTANCE.createTraceToEntityMapping();
						mapping.setEntity(entity);
						mapping.setTraceColumn(1);
						series.getMappings().add(mapping);
					}
				}
			}
			Command cmd = AddCommand.create(domain, inputData.getInput(),
					ConfigurationPackage.Literals.INPUT_SPECIFICATION__OBSERVATIONS, series);
			domain.getCommandStack().execute(cmd);
		} else {

			MessageDialog.openInformation(page.getSite().getShell(), "Info",
					"Select Input Data to edit first on either Input Data page for OptimizatioConfiguration or Recommendation page for Recommenation Configuration.");

		}
	}

	@Override
	protected void handleRemove() {
		IStructuredSelection selection = (IStructuredSelection) tableTracesViewer.getSelection();
		Iterator<?> iterator = selection.iterator();
		while (iterator.hasNext()) {
			Object o = iterator.next();
			if (o instanceof TraceConfiguration) {
				Command cmd = RemoveCommand.create(domain, o);
				domain.getCommandStack().execute(cmd);
			}
		}
	}

	private void initializeValues() {

		if (inputData.getInput() == null) {
			InputSpecification inpSpec = ConfigurationFactory.eINSTANCE.createInputSpecification();
			inputData.setInput(inpSpec);

			Command cmd = AddCommand.create(domain, model.getOptimizationConfiguration(),
					OptimizationPackage.Literals.INPUT_DATA__INPUT, inpSpec);
			domain.getCommandStack().execute(cmd);
		}
		for (TraceConfiguration trace : inputData.getInput().getObservations()) {
			if (trace.getInterval() == null) {
				Quantity<Time> interval = UnitsFactory.eINSTANCE.createQuantity();
				interval.setValue(0);
				interval.setUnit(Time.SECONDS);
				Command cmd = SetCommand.create(domain, trace,
						ConfigurationPackage.Literals.TRACE_CONFIGURATION__INTERVAL, interval);
				domain.getCommandStack().execute(cmd);
			}
			if (trace.getAggregation() == null) {
				if (trace.getInterval().getValue() > 0) {
					trace.setAggregation(Aggregation.AVERAGE);
				} else {
					trace.setAggregation(Aggregation.NONE);
				}
			}
		}
	}

	public void inputDataPageSelectionChanged() {
		inputData = SelectionProvider.INSTANCE().getSelectedInputData();
		if (tableTracesViewer != null) {
			if (inputData != null) {
				managedForm.getForm().setText("Traces - Currently editing " + InputDataRegistry.INSTANCE.getLabelFromInputData(inputData));
				initializeValues();
				tableTracesViewer.setInput(inputData.getInput());
				tableTracesViewer.refresh();

			} else {
				managedForm.getForm().setText("Traces - No Input Data selected.");
				tableTracesViewer.setInput(inputData);
				tableTracesViewer.refresh();
			}
		}
	}
}
