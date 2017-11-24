package tools.descartes.librede.rrde.model.editor.forms;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.DateAndTimeObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;

import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.DataSourceConfiguration;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.FileTraceConfiguration;
import tools.descartes.librede.configuration.TraceConfiguration;
import tools.descartes.librede.configuration.editor.util.TimeUnitSpinnerBuilder;
import tools.descartes.librede.configuration.presentation.LibredeEditorPlugin;
import tools.descartes.librede.datasource.IDataSource;
import tools.descartes.librede.registry.Instantiator;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.editor.forms.master.AbstractMasterBlock;
import tools.descartes.librede.rrde.model.editor.util.SelectionProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.presentation.LifecycleEditor;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.UnitsFactory;
import tools.descartes.librede.units.UnitsPackage;

public class EstimationRecommendationFormPage extends EstimationFormPage {

	private EstimationSpecification input;

	public EstimationRecommendationFormPage(LifecycleEditor editor, String id, String title, String icon,
			AdapterFactoryEditingDomain editingDomain, LifeCycleConfiguration model, AbstractMasterBlock masterBlock) {
		super(editor, id, title, icon, editingDomain, model, masterBlock);

	}

	@Override
	protected void initializeQuantityFields() {
		if (input == null)
			return;
		if (input.getStepSize() == null) {
			Quantity<Time> stepSize = UnitsFactory.eINSTANCE.createQuantity();
			stepSize.setValue(60);
			stepSize.setUnit(Time.SECONDS);

			Command cmd = SetCommand.create(getEditingDomain(), input,
					ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__STEP_SIZE, stepSize);
			getEditingDomain().getCommandStack().execute(cmd);
		}

		if (input.getStartTimestamp() == null) {
			Quantity<Time> startTimestamp = UnitsFactory.eINSTANCE.createQuantity();
			startTimestamp.setValue(0);
			startTimestamp.setUnit(Time.SECONDS);
			Command cmd = SetCommand.create(getEditingDomain(), input,
					ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__START_TIMESTAMP, startTimestamp);
			getEditingDomain().getCommandStack().execute(cmd);
		}

		if (input.getEndTimestamp() == null) {
			Quantity<Time> endTimestamp = UnitsFactory.eINSTANCE.createQuantity();
			endTimestamp.setValue(0);
			endTimestamp.setUnit(Time.SECONDS);
			Command cmd = SetCommand.create(getEditingDomain(), input,
					ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__END_TIMESTAMP, endTimestamp);
			getEditingDomain().getCommandStack().execute(cmd);
		}
	}
	
	
	
	protected void createRecommendationBindings() {

		bindingContext.bindValue(WidgetProperties.selection().observe(spnStepValue),
				EMFEditProperties.value(getEditingDomain(),
						FeaturePath.fromList(ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__STEP_SIZE,
								UnitsPackage.Literals.QUANTITY__VALUE))
						.observe(input),
				TimeUnitSpinnerBuilder.createTargetToModelConverter(),
				TimeUnitSpinnerBuilder.createModelToTargetConverter());

		bindingContext
				.bindValue(
						ViewerProperties
								.singleSelection().observe(comboStepUnitViewer),
						EMFEditProperties.value(getEditingDomain(),
								FeaturePath.fromList(ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__STEP_SIZE,
										UnitsPackage.Literals.QUANTITY__UNIT))
								.observe(input));

		bindingContext.bindValue(
				new DateAndTimeObservableValue(WidgetProperties.selection().observe(startDate),
						WidgetProperties.selection().observe(startTime)),
				EMFEditProperties.value(getEditingDomain(),
						FeaturePath.fromList(ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__START_TIMESTAMP,
								UnitsPackage.Literals.QUANTITY__VALUE))
						.observe(input),
				createDateConverterTargetToModel(input.getStartTimestamp()),
				createDateConverterModelToTarget(input.getStartTimestamp()));
		bindingContext
				.bindValue(
						new DateAndTimeObservableValue(WidgetProperties.selection().observe(endDate),
								WidgetProperties.selection().observe(endTime)),
						EMFEditProperties.value(getEditingDomain(),
								FeaturePath.fromList(
										ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__END_TIMESTAMP,
										UnitsPackage.Literals.QUANTITY__VALUE))
								.observe(input),
						createDateConverterTargetToModel(input.getEndTimestamp()),
						createDateConverterModelToTarget(input.getEndTimestamp()));
		bindingContext
				.bindValue(
						WidgetProperties
								.text(SWT.Modify).observe(txtStartTimestamp),
						EMFEditProperties.value(getEditingDomain(),
								FeaturePath.fromList(
										ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__START_TIMESTAMP,
										UnitsPackage.Literals.QUANTITY__VALUE))
								.observe(input));
		bindingContext
				.bindValue(
						ViewerProperties
								.singleSelection().observe(comboStartUnitViewer),
						EMFEditProperties.value(getEditingDomain(),
								FeaturePath.fromList(
										ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__START_TIMESTAMP,
										UnitsPackage.Literals.QUANTITY__UNIT))
								.observe(input));
		bindingContext
				.bindValue(
						WidgetProperties
								.text(SWT.Modify).observe(txtEndTimestamp),
						EMFEditProperties.value(getEditingDomain(),
								FeaturePath.fromList(
										ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__END_TIMESTAMP,
										UnitsPackage.Literals.QUANTITY__VALUE))
								.observe(input));
		bindingContext
				.bindValue(
						ViewerProperties
								.singleSelection().observe(comboEndUnitViewer),
						EMFEditProperties.value(getEditingDomain(),
								FeaturePath.fromList(
										ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__END_TIMESTAMP,
										UnitsPackage.Literals.QUANTITY__UNIT))
								.observe(input));
		bindingContext
				.bindValue(WidgetProperties.selection().observe(btnRecursive),
						EMFEditProperties
								.value(getEditingDomain(),
										FeaturePath.fromList(
												ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__RECURSIVE))
								.observe(input));
		bindingContext.bindValue(WidgetProperties.selection().observe(btnAutomaticApproachSelection),
				EMFEditProperties
						.value(getEditingDomain(),
								FeaturePath.fromList(
										ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__AUTOMATIC_APPROACH_SELECTION))
						.observe(input));
		bindingContext
				.bindValue(WidgetProperties.selection().observe(spnWindow),
						EMFEditProperties
								.value(getEditingDomain(),
										FeaturePath.fromList(
												ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__WINDOW))
								.observe(input));
	}
	
	@Override
	protected void createEstimationBindings() {
		// We need to add the existing validators in the configuration first, so
		// that the test for
		// equality in the checked table binding works correctly. EMF always
		// does an equality check on
		// the object instance.
		if (input == null || tableApproachesViewer == null)
			return;
		
	
		IObservableList approaches = new WritableList();
		Set<String> existingApproaches = new HashSet<String>();
		for (EstimationApproachConfiguration v : input.getApproaches()) {
			approaches.add(v);
			existingApproaches.add(v.getType());
		}
		for (String instance : Registry.INSTANCE.getInstances(IEstimationApproach.class)) {
			if (!existingApproaches.contains(instance)) {
				EstimationApproachConfiguration a = ConfigurationFactory.eINSTANCE
						.createEstimationApproachConfiguration();
				a.setType(instance);
				approaches.add(a);
			}
		}
		tableApproachesViewer.setInput(approaches);

		// Binding: All checked approaches are added to the model instance

		bindingContext.bindSet(
				ViewerProperties.checkedElements(EstimationApproachConfiguration.class).observe(tableApproachesViewer),
				EMFEditProperties
						.set(getEditingDomain(),
								FeaturePath.fromList(
										ConfigurationPackage.Literals.ESTIMATION_SPECIFICATION__APPROACHES))
						.observe(input));
	}
	
	@Override
	protected void handleReadFromTrace() {
		Map<String, IDataSource> dataSources = new HashMap<String, IDataSource>();

		double maxStart = Double.MIN_VALUE;
		double minEnd = Double.MAX_VALUE;
		InputData data = SelectionProvider.INSTANCE().getSelectedInputData();
		if (data == null) {
			MessageDialog.openInformation(getEditorSite().getShell(), "Info",
					"No Input Data selected. Select one on the Input Data Selection pages.");
			return;
		}
		if (!getModel().getRecommendationConfiguration().getTrainingData().contains(data)) {
			MessageDialog.openInformation(getEditorSite().getShell(), "Info",
					"Input Data from Optimization selected. This is the Recommendation Estimation Page.");
			return;
		}
		for (TraceConfiguration trace : data.getInput().getObservations()) {
			if (trace instanceof FileTraceConfiguration) {
				FileTraceConfiguration fileTrace = (FileTraceConfiguration) trace;
				File inputFile = new File(fileTrace.getFile());
				if (inputFile.exists()) {
					DataSourceConfiguration dataSourceConf = fileTrace.getDataSource();
					if (dataSourceConf != null) {
						IDataSource ds = dataSources.get(dataSourceConf.getType());
						if (ds == null) {
							try {
								Class<?> cl = Registry.INSTANCE.getInstanceClass(dataSourceConf.getType());
								ds = (IDataSource) Instantiator.newInstance(cl, dataSourceConf.getParameters());
								dataSources.put(dataSourceConf.getType(), ds);
							} catch (Exception e) {
								ErrorDialog.openError(getEditor().getEditorSite().getShell(), null, null,
										new Status(IStatus.ERROR, LibredeEditorPlugin.ID,
												"Error instantiating data source instance.", e));
								return;
							}
						}
						// it is enough to load the first mapping as all will
						// have the same timestamps
						if (fileTrace.getMappings().size() >= 1) {
							int col = fileTrace.getMappings().get(0).getTraceColumn();
							FileInputStream in = null;
							try {
								in = new FileInputStream(inputFile);
								// TODO:
								// TimeSeries series = ds.load(in, col);
								// maxStart = Math.max(series.getStartTime(),
								// maxStart);
								// minEnd = Math.min(series.getEndTime(),
								// minEnd);
							} catch (Exception e) {
								// Fail graciously
							}
						}
					}
				}
			}
		}

		if (maxStart >= minEnd) {
			ErrorDialog.openError(getEditor().getEditorSite().getShell(), null, null,
					new Status(IStatus.WARNING, LibredeEditorPlugin.ID, "The time spans of the traces to no overlap."));
			return;
		}
		if (maxStart != Double.MIN_VALUE) {
			Command cmd = SetCommand.create(getEditingDomain(), input.getStartTimestamp(),
					UnitsPackage.Literals.QUANTITY__VALUE, maxStart);
			getEditingDomain().getCommandStack().execute(cmd);
		}
		if (minEnd != Double.MAX_VALUE) {
			Command cmd = SetCommand.create(getEditingDomain(), input.getEndTimestamp(),
					UnitsPackage.Literals.QUANTITY__VALUE, minEnd);
			getEditingDomain().getCommandStack().execute(cmd);
		}

	}

	public void estimationPageSelectionChanged() {
		input = SelectionProvider.INSTANCE().getSelectedEstimationSpecification();
		if (input != null) {
			if (tableApproachesViewer != null) {
				if (bindingContext != null)
					bindingContext.dispose();
				bindingContext = new EMFDataBindingContext();
				initializeQuantityFields();
				createEstimationBindings();
				createRecommendationBindings();
			}
		} else {
			if (bindingContext != null)
				bindingContext.dispose();
			if (tableApproachesViewer != null) {
				tableApproachesViewer.setInput(null);
				tableApproachesViewer.refresh();
			}
		}
	}

}
