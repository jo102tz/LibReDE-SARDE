package tools.descartes.librede.rrde.model.editor.forms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.editor.util.TimeUnitSpinnerBuilder;
import tools.descartes.librede.metrics.Aggregation;
import tools.descartes.librede.metrics.MetricsFactory;
import tools.descartes.librede.metrics.MetricsPackage;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.actions.RunOptimizationAction;
import tools.descartes.librede.rrde.model.editor.forms.master.AbstractMasterBlock;
import tools.descartes.librede.rrde.model.editor.util.OptAlgorithmLabelProvider;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.presentation.LifecycleEditor;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.recommendation.DecisionTreeAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.NeuralNetworkAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.model.recommendation.SVMAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.util.extract.IFeatureExtractor;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.RequestRate;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.Unit;
import tools.descartes.librede.units.UnitsFactory;
import tools.descartes.librede.units.UnitsPackage;
import tools.descartes.librede.units.UnitsRepository;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

public class RecommendationConfigurationFormPage extends MasterDetailsFormPage {

	private LifeCycleConfiguration model;
	private AdapterFactoryEditingDomain editingDomain;
	private Spinner spnIntervalValue;
	private ComboViewer comboIntervalUnitViewer;

	public RecommendationConfigurationFormPage(LifecycleEditor editor, String id, String title,
			AdapterFactoryEditingDomain editingDomain, LifeCycleConfiguration model, AbstractMasterBlock masterBlock) {
		super(editor, id, title, title, editingDomain, model, masterBlock);
		this.model = model;
		this.editingDomain = editingDomain;

		initializeValues();
	}

	private Section sctnTraining;
	private Composite trainingComposite;
	private Section sctnExtractor;
	private Composite extractorComposite;
	private ComboViewer viewer;
	private ComboViewer extractorViewer;
	private ComboViewer extractorUnitViewer;

	private EMFDataBindingContext bindingContext;
	private EMFDataBindingContext extBindingContext = new EMFDataBindingContext();

	private List<Widget> widgetList = new ArrayList<Widget>();

	private void initializeValues() {
		if (model.getRecommendationConfiguration().getFeatureAlgorithm() == null) {
			model.getRecommendationConfiguration().eSet(
					RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM,
					RecommendationFactory.eINSTANCE.createFeatureExtractorSpecifier());
		}

		if (model.getRecommendationConfiguration().getFeatureAlgorithm().getAggregation() == null) {
			Quantity<Time> interval = UnitsFactory.eINSTANCE.createQuantity();
			interval.setUnit(Time.SECONDS);
			interval.setValue(0);
			model.getRecommendationConfiguration().getFeatureAlgorithm()
					.eSet(RecommendationPackage.Literals.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION, interval);

		}
		
	}

	@Override
	protected void createFormContentBeginning(FormToolkit toolkit, Composite parent) {
		super.createFormContentBeginning(toolkit, parent);

		createExtractorSection(toolkit, parent);

		createTrainingSection(toolkit, parent);
	}

	@SuppressWarnings("unchecked")
	private void createExtractorSection(FormToolkit toolkit, Composite parent) {
		sctnExtractor = toolkit.createSection(parent, Section.TWISTIE | Section.TITLE_BAR | Section.DESCRIPTION);
		GridData gd_sctnExtractor = new GridData(GridData.FILL_HORIZONTAL);
		gd_sctnExtractor.verticalAlignment = SWT.TOP;
		sctnExtractor.setLayoutData(gd_sctnExtractor);
		toolkit.paintBordersFor(sctnExtractor);
		sctnExtractor.setText("Extractor");
		sctnExtractor.descriptionVerticalSpacing = 10;
		sctnExtractor.setDescription("Extractor to be used for Recommendation");
		sctnExtractor.setExpanded(true);

		extractorComposite = toolkit.createComposite(sctnExtractor, SWT.NONE);
		sctnExtractor.setClient(extractorComposite);
		toolkit.paintBordersFor(extractorComposite);
		extractorComposite.setLayout(new GridLayout(2, false));

		Label lblNewLabel_2 = new Label(extractorComposite, SWT.NONE);
		toolkit.adapt(lblNewLabel_2, true, true);
		lblNewLabel_2.setText("Recommendation Extractor:");
		extractorViewer = new ComboViewer(extractorComposite, SWT.READ_ONLY);
		Combo combo = extractorViewer.getCombo();
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		toolkit.paintBordersFor(combo);

		extractorViewer.setContentProvider(new ObservableListContentProvider());
		extractorViewer.setLabelProvider(new OptAlgorithmLabelProvider());

		IObservableList<String> extractors = new WritableList<String>();
		extractors.addAll(Registry.INSTANCE.getInstances(IFeatureExtractor.class));
		extractorViewer.setInput(extractors);

		extBindingContext.bindValue(ViewerProperties.singleSelection().observe(extractorViewer),
				EMFEditProperties
						.value(editingDomain,
								RecommendationPackage.Literals.FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR)
						.observe(model.getRecommendationConfiguration().getFeatureAlgorithm()));

		Label lblNewLabel_1 = new Label(extractorComposite, SWT.NONE);
		toolkit.adapt(lblNewLabel_1, true, true);
		lblNewLabel_1.setText("Interval:");

		Composite intervalEditorComposite = TimeUnitSpinnerBuilder.createComposite(toolkit, extractorComposite);
		spnIntervalValue = TimeUnitSpinnerBuilder.createSpinnerControl(toolkit, intervalEditorComposite);
		comboIntervalUnitViewer = TimeUnitSpinnerBuilder.createTimeUnitControl(toolkit, getAdapterFactory(),
				intervalEditorComposite);

		extBindingContext.bindValue(WidgetProperties.selection().observe(spnIntervalValue), EMFEditProperties
				.value(editingDomain,
						FeaturePath.fromList(RecommendationPackage.Literals.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION,
								UnitsPackage.Literals.QUANTITY__VALUE))
				.observe(model.getRecommendationConfiguration().getFeatureAlgorithm()),
				TimeUnitSpinnerBuilder.createTargetToModelConverter(),
				TimeUnitSpinnerBuilder.createModelToTargetConverter());

		extBindingContext.bindValue(ViewerProperties.singleSelection().observe(comboIntervalUnitViewer),
				EMFEditProperties.value(editingDomain,
						FeaturePath.fromList(RecommendationPackage.Literals.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION,
								UnitsPackage.Literals.QUANTITY__UNIT))
						.observe(model.getRecommendationConfiguration().getFeatureAlgorithm()));
		
		Label lblNewLabel_3 = new Label(extractorComposite, SWT.NONE);
		toolkit.adapt(lblNewLabel_3, true, true);
		lblNewLabel_3.setText("Rate Unit:");
		extractorUnitViewer = new ComboViewer(extractorComposite, SWT.READ_ONLY);
		Combo comboUnits = extractorUnitViewer.getCombo();
		comboUnits.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		toolkit.paintBordersFor(comboUnits);

		extractorUnitViewer.setContentProvider(new ObservableListContentProvider());
		extractorUnitViewer.setLabelProvider(new AdapterFactoryLabelProvider(getAdapterFactory()));

		
		
		extractorUnitViewer.setInput(new WritableList(RequestRate.INSTANCE.getUnits(), Unit.class));
		extractorUnitViewer.setSelection(new StructuredSelection(RequestRate.INSTANCE.getBaseUnit()));

		extBindingContext.bindValue(ViewerProperties.singleSelection().observe(extractorUnitViewer),
				EMFEditProperties
						.value(editingDomain, RecommendationPackage.Literals.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT)
						.observe(model.getRecommendationConfiguration().getFeatureAlgorithm()));
	
	}

	private void createTrainingSection(FormToolkit toolkit, Composite parent) {
		sctnTraining = toolkit.createSection(parent, Section.TWISTIE | Section.TITLE_BAR | Section.DESCRIPTION);
		sctnTraining.descriptionVerticalSpacing = 10;
		GridData gd_sctnTraining = new GridData(GridData.FILL_HORIZONTAL);
		gd_sctnTraining.verticalAlignment = SWT.TOP;
		sctnTraining.setLayoutData(gd_sctnTraining);
		toolkit.paintBordersFor(sctnTraining);
		sctnTraining.setText("Training");
		sctnTraining.setDescription("Specify algorithm to be used for the recommendation.");
		sctnTraining.setExpanded(true);

		trainingComposite = toolkit.createComposite(sctnTraining, SWT.NONE);
		sctnTraining.setClient(trainingComposite);
		toolkit.paintBordersFor(trainingComposite);
		trainingComposite.setLayout(new GridLayout(2, false));

		Label lblNewLabel_2 = new Label(trainingComposite, SWT.NONE);
		toolkit.adapt(lblNewLabel_2, true, true);
		lblNewLabel_2.setText("Recommendation Algorithm:");
		viewer = new ComboViewer(trainingComposite, SWT.READ_ONLY);
		Combo combo = viewer.getCombo();
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		toolkit.paintBordersFor(combo);

		viewer.setContentProvider(new ObservableListContentProvider());
		viewer.setLabelProvider(new OptAlgorithmLabelProvider());

		IObservableList<String> recommendationAlgorithms = new WritableList<String>();
		recommendationAlgorithms.addAll(Registry.INSTANCE.getInstances(IRecomendationAlgorithm.class));

		viewer.setInput(recommendationAlgorithms);
		if (model.getRecommendationConfiguration().getLearningAlgorithm() != null
				&& model.getRecommendationConfiguration().getLearningAlgorithm().getAlgorithmName() != null) {
			IStructuredSelection sel = new StructuredSelection(
					model.getRecommendationConfiguration().getLearningAlgorithm().getAlgorithmName());
			viewer.setSelection(sel);
			updateRecAlgRegion(sel, toolkit);
		}

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				updateRecAlgRegion(sel, toolkit);
			}

		});
	}

	private void updateRecAlgRegion(IStructuredSelection sel, FormToolkit toolkit) {
		for (Widget wid : widgetList) {
			wid.dispose();

		}
		widgetList.clear();

		if (sel.size() == 1) {
			String recAlgSel = (String) sel.getFirstElement();
			Class<?> recAlgType = Registry.INSTANCE.getInstanceClass(recAlgSel);
			IRecomendationAlgorithm recAlg;
			try {
				recAlg = (IRecomendationAlgorithm) recAlgType.newInstance();
			} catch (Exception e) {
				throw new IllegalArgumentException("The type of the Algorithm is not set.");
			}

			if (bindingContext != null) {
				bindingContext.dispose();
			}

			bindingContext = new EMFDataBindingContext();

			if (recAlg.isSpecifierSupported(RecommendationFactory.eINSTANCE.createNeuralNetworkAlgorithmSpecifier())) {

				NeuralNetworkAlgorithmSpecifier spec = RecommendationFactory.eINSTANCE
						.createNeuralNetworkAlgorithmSpecifier();
				spec.setAlgorithmName(recAlgSel);
				model.getRecommendationConfiguration().eSet(
						RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM, spec);
				Label numbNeuronsLabel = toolkit.createLabel(trainingComposite, "Number of Neurons");
				Text numbNeuronsText = toolkit.createText(trainingComposite, "100", SWT.BORDER);

				bindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(numbNeuronsText),
						EMFEditProperties
								.value(editingDomain,
										RecommendationPackage.Literals.NEURAL_NETWORK_ALGORITHM_SPECIFIER__NUMBER_OF_NEURONS)
								.observe(model.getRecommendationConfiguration().getLearningAlgorithm()));

				widgetList.addAll(Arrays.asList(numbNeuronsLabel, numbNeuronsText));
			}

			if (recAlg.isSpecifierSupported(RecommendationFactory.eINSTANCE.createSVMAlgorithmSpecifier())) {

				SVMAlgorithmSpecifier spec = RecommendationFactory.eINSTANCE.createSVMAlgorithmSpecifier();
				spec.setAlgorithmName(recAlgSel);
				model.getRecommendationConfiguration().eSet(
						RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM, spec);
				Label gaussianLabel = toolkit.createLabel(trainingComposite, "Gaussian Sigma");
				Text gaussianText = toolkit.createText(trainingComposite, "8.0", SWT.BORDER);
				Label marginLabel = toolkit.createLabel(trainingComposite, "Soft Margin Penalty");
				Text marginText = toolkit.createText(trainingComposite, "5.0", SWT.BORDER);

				bindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(gaussianText),
						EMFEditProperties
								.value(editingDomain,
										RecommendationPackage.Literals.SVM_ALGORITHM_SPECIFIER__GAUSSIAN_SIGMA)
								.observe(model.getRecommendationConfiguration().getLearningAlgorithm()));

				bindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(marginText),
						EMFEditProperties
								.value(editingDomain,
										RecommendationPackage.Literals.SVM_ALGORITHM_SPECIFIER__SOFT_MARGIN_PENALTY)
								.observe(model.getRecommendationConfiguration().getLearningAlgorithm()));

				widgetList.addAll(Arrays.asList(gaussianText, gaussianLabel, marginLabel, marginText));

			}

			if (recAlg.isSpecifierSupported(RecommendationFactory.eINSTANCE.createDecisionTreeAlgorithmSpecifier())) {

				DecisionTreeAlgorithmSpecifier spec = RecommendationFactory.eINSTANCE
						.createDecisionTreeAlgorithmSpecifier();
				spec.setAlgorithmName(recAlgSel);
				model.getRecommendationConfiguration().eSet(
						RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM, spec);

				Label numbNodesLabel = toolkit.createLabel(trainingComposite, "Max. Number of Nodes");
				Text numbNodesText = toolkit.createText(trainingComposite, "100", SWT.BORDER);

				bindingContext.bindValue(WidgetProperties.text(SWT.Modify).observe(numbNodesText),
						EMFEditProperties
								.value(editingDomain,
										RecommendationPackage.Literals.DECISION_TREE_ALGORITHM_SPECIFIER__MAXIMUM_NUMBER_OF_NODES)
								.observe(model.getRecommendationConfiguration().getLearningAlgorithm()));

				widgetList.addAll(Arrays.asList(numbNodesLabel, numbNodesText));
			}

			for (Widget wid : widgetList) {
				GridData data = new GridData(SWT.FILL, SWT.NONE, false, false);
				if (wid instanceof Text) {
					Text t = (Text) wid;
					t.setLayoutData(data);
				} else if (wid instanceof Label) {
					Label l = (Label) wid;
					l.setLayoutData(data);
				}
			}
			sctnTraining.getParent().getParent().layout(true, true);

		}
	}

}
