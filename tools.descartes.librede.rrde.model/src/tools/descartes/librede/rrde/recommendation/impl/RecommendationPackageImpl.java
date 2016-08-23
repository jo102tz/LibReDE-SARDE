/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import tools.descartes.librede.configuration.ConfigurationPackage;

import tools.descartes.librede.metrics.MetricsPackage;

import tools.descartes.librede.rrde.optimization.OptimizationPackage;

import tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl;

import tools.descartes.librede.rrde.recommendation.ConfigurationResult;
import tools.descartes.librede.rrde.recommendation.DataSet;
import tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.TraceFeatures;

import tools.descartes.librede.units.UnitsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecommendationPackageImpl extends EPackageImpl implements RecommendationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recommendationTrainingConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recommendationAlgorithmSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureExtractorSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureVectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceFeaturesEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RecommendationPackageImpl() {
		super(eNS_URI, RecommendationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RecommendationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RecommendationPackage init() {
		if (isInited) return (RecommendationPackage)EPackage.Registry.INSTANCE.getEPackage(RecommendationPackage.eNS_URI);

		// Obtain or create and register package
		RecommendationPackageImpl theRecommendationPackage = (RecommendationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RecommendationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RecommendationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConfigurationPackage.eINSTANCE.eClass();
		MetricsPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		OptimizationPackageImpl theOptimizationPackage = (OptimizationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI) instanceof OptimizationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI) : OptimizationPackage.eINSTANCE);

		// Create package meta-data objects
		theRecommendationPackage.createPackageContents();
		theOptimizationPackage.createPackageContents();

		// Initialize created meta-data
		theRecommendationPackage.initializePackageContents();
		theOptimizationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRecommendationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RecommendationPackage.eNS_URI, theRecommendationPackage);
		return theRecommendationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecommendationTrainingConfiguration() {
		return recommendationTrainingConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecommendationTrainingConfiguration_TrainingData() {
		return (EReference)recommendationTrainingConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecommendationTrainingConfiguration_LearningAlgorithm() {
		return (EReference)recommendationTrainingConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecommendationTrainingConfiguration_FeatureAlgorithm() {
		return (EReference)recommendationTrainingConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecommendationTrainingConfiguration_Configurations() {
		return (EReference)recommendationTrainingConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationResult() {
		return configurationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationResult_Configuration() {
		return (EReference)configurationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationResult_ErrorValue() {
		return (EAttribute)configurationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecommendationAlgorithmSpecifier() {
		return recommendationAlgorithmSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecommendationAlgorithmSpecifier_AlgorithmName() {
		return (EAttribute)recommendationAlgorithmSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureExtractorSpecifier() {
		return featureExtractorSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureExtractorSpecifier_FeatureExtractor() {
		return (EAttribute)featureExtractorSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSet() {
		return dataSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSet_Configuration() {
		return (EReference)dataSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSet_Features() {
		return (EReference)dataSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSet_ConfigurationValues() {
		return (EReference)dataSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureVector() {
		return featureVectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_NumberOfRessources() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_NumberOfWorkloadClasses() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_UtilizationMean() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_UtilizationVariance() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureVector_Traces() {
		return (EReference)featureVectorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_VarianceInflationFactor() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceFeatures() {
		return traceFeaturesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceFeatures_ArithmeticMean() {
		return (EAttribute)traceFeaturesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceFeatures_StandardDeviation() {
		return (EAttribute)traceFeaturesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceFeatures_Minimum() {
		return (EAttribute)traceFeaturesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceFeatures_Maximum() {
		return (EAttribute)traceFeaturesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceFeatures_NumberOfSamples() {
		return (EAttribute)traceFeaturesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceFeatures_AggregationType() {
		return (EAttribute)traceFeaturesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceFeatures_AggregationInterval() {
		return (EReference)traceFeaturesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceFeatures_AutoCorrelation() {
		return (EAttribute)traceFeaturesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceFeatures_Metric() {
		return (EReference)traceFeaturesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceFeatures_OriginalInput() {
		return (EAttribute)traceFeaturesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationFactory getRecommendationFactory() {
		return (RecommendationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		recommendationTrainingConfigurationEClass = createEClass(RECOMMENDATION_TRAINING_CONFIGURATION);
		createEReference(recommendationTrainingConfigurationEClass, RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA);
		createEReference(recommendationTrainingConfigurationEClass, RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM);
		createEReference(recommendationTrainingConfigurationEClass, RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM);
		createEReference(recommendationTrainingConfigurationEClass, RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS);

		configurationResultEClass = createEClass(CONFIGURATION_RESULT);
		createEReference(configurationResultEClass, CONFIGURATION_RESULT__CONFIGURATION);
		createEAttribute(configurationResultEClass, CONFIGURATION_RESULT__ERROR_VALUE);

		recommendationAlgorithmSpecifierEClass = createEClass(RECOMMENDATION_ALGORITHM_SPECIFIER);
		createEAttribute(recommendationAlgorithmSpecifierEClass, RECOMMENDATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME);

		featureExtractorSpecifierEClass = createEClass(FEATURE_EXTRACTOR_SPECIFIER);
		createEAttribute(featureExtractorSpecifierEClass, FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR);

		dataSetEClass = createEClass(DATA_SET);
		createEReference(dataSetEClass, DATA_SET__CONFIGURATION);
		createEReference(dataSetEClass, DATA_SET__FEATURES);
		createEReference(dataSetEClass, DATA_SET__CONFIGURATION_VALUES);

		featureVectorEClass = createEClass(FEATURE_VECTOR);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__NUMBER_OF_RESSOURCES);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__UTILIZATION_MEAN);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__UTILIZATION_VARIANCE);
		createEReference(featureVectorEClass, FEATURE_VECTOR__TRACES);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR);

		traceFeaturesEClass = createEClass(TRACE_FEATURES);
		createEAttribute(traceFeaturesEClass, TRACE_FEATURES__ARITHMETIC_MEAN);
		createEAttribute(traceFeaturesEClass, TRACE_FEATURES__STANDARD_DEVIATION);
		createEAttribute(traceFeaturesEClass, TRACE_FEATURES__MINIMUM);
		createEAttribute(traceFeaturesEClass, TRACE_FEATURES__MAXIMUM);
		createEAttribute(traceFeaturesEClass, TRACE_FEATURES__NUMBER_OF_SAMPLES);
		createEAttribute(traceFeaturesEClass, TRACE_FEATURES__AGGREGATION_TYPE);
		createEReference(traceFeaturesEClass, TRACE_FEATURES__AGGREGATION_INTERVAL);
		createEAttribute(traceFeaturesEClass, TRACE_FEATURES__AUTO_CORRELATION);
		createEReference(traceFeaturesEClass, TRACE_FEATURES__METRIC);
		createEAttribute(traceFeaturesEClass, TRACE_FEATURES__ORIGINAL_INPUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		OptimizationPackage theOptimizationPackage = (OptimizationPackage)EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI);
		ConfigurationPackage theConfigurationPackage = (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		MetricsPackage theMetricsPackage = (MetricsPackage)EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);
		UnitsPackage theUnitsPackage = (UnitsPackage)EPackage.Registry.INSTANCE.getEPackage(UnitsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(recommendationTrainingConfigurationEClass, RecommendationTrainingConfiguration.class, "RecommendationTrainingConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecommendationTrainingConfiguration_TrainingData(), theOptimizationPackage.getInputData(), null, "trainingData", null, 1, -1, RecommendationTrainingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationTrainingConfiguration_LearningAlgorithm(), this.getRecommendationAlgorithmSpecifier(), null, "learningAlgorithm", null, 1, 1, RecommendationTrainingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationTrainingConfiguration_FeatureAlgorithm(), this.getFeatureExtractorSpecifier(), null, "featureAlgorithm", null, 1, 1, RecommendationTrainingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationTrainingConfiguration_Configurations(), theConfigurationPackage.getEstimationSpecification(), null, "configurations", null, 1, -1, RecommendationTrainingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationResultEClass, ConfigurationResult.class, "ConfigurationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurationResult_Configuration(), theConfigurationPackage.getEstimationSpecification(), null, "configuration", null, 1, 1, ConfigurationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationResult_ErrorValue(), theXMLTypePackage.getDouble(), "errorValue", "-1", 1, 1, ConfigurationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recommendationAlgorithmSpecifierEClass, RecommendationAlgorithmSpecifier.class, "RecommendationAlgorithmSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecommendationAlgorithmSpecifier_AlgorithmName(), ecorePackage.getEString(), "algorithmName", null, 1, 1, RecommendationAlgorithmSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureExtractorSpecifierEClass, FeatureExtractorSpecifier.class, "FeatureExtractorSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureExtractorSpecifier_FeatureExtractor(), ecorePackage.getEString(), "featureExtractor", null, 1, 1, FeatureExtractorSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataSetEClass, DataSet.class, "DataSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSet_Configuration(), theConfigurationPackage.getLibredeConfiguration(), null, "configuration", null, 1, 1, DataSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSet_Features(), this.getFeatureVector(), null, "features", null, 1, 1, DataSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSet_ConfigurationValues(), this.getConfigurationResult(), null, "configurationValues", null, 1, -1, DataSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureVectorEClass, FeatureVector.class, "FeatureVector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureVector_NumberOfRessources(), theXMLTypePackage.getInt(), "numberOfRessources", "1", 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_NumberOfWorkloadClasses(), theXMLTypePackage.getInt(), "numberOfWorkloadClasses", "1", 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_UtilizationMean(), theXMLTypePackage.getDouble(), "utilizationMean", "-1", 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_UtilizationVariance(), theXMLTypePackage.getDouble(), "utilizationVariance", "-1", 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureVector_Traces(), this.getTraceFeatures(), null, "traces", null, 0, -1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_VarianceInflationFactor(), theXMLTypePackage.getDouble(), "varianceInflationFactor", "-1", 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceFeaturesEClass, TraceFeatures.class, "TraceFeatures", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceFeatures_ArithmeticMean(), theXMLTypePackage.getDouble(), "arithmeticMean", "-1", 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceFeatures_StandardDeviation(), theXMLTypePackage.getDouble(), "standardDeviation", "-1", 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceFeatures_Minimum(), theXMLTypePackage.getDouble(), "minimum", "-1", 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceFeatures_Maximum(), theXMLTypePackage.getDouble(), "maximum", "-1", 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceFeatures_NumberOfSamples(), theXMLTypePackage.getInt(), "numberOfSamples", "-1", 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceFeatures_AggregationType(), theMetricsPackage.getAggregation(), "aggregationType", "NONE", 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(theUnitsPackage.getQuantity());
		EGenericType g2 = createEGenericType(theUnitsPackage.getTime());
		g1.getETypeArguments().add(g2);
		initEReference(getTraceFeatures_AggregationInterval(), g1, null, "aggregationInterval", null, 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceFeatures_AutoCorrelation(), theXMLTypePackage.getDouble(), "autoCorrelation", "-1", 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theMetricsPackage.getMetric());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(theUnitsPackage.getDimension());
		g2.setEUpperBound(g3);
		initEReference(getTraceFeatures_Metric(), g1, null, "metric", null, 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceFeatures_OriginalInput(), theXMLTypePackage.getBoolean(), "originalInput", "true", 1, 1, TraceFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RecommendationPackageImpl
