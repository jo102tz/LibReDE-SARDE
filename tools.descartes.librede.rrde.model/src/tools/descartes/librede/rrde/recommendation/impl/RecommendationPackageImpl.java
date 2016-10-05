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

import tools.descartes.librede.rrde.lifecycle.LifecyclePackage;

import tools.descartes.librede.rrde.lifecycle.impl.LifecyclePackageImpl;

import tools.descartes.librede.rrde.optimization.OptimizationPackage;

import tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl;

import tools.descartes.librede.rrde.recommendation.DataSet;
import tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.NeuralNetworkAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.SVMAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;

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
	private EClass statisticalFeaturesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decisionTreeAlgorithmSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass neuralNetworkAlgorithmSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass svmAlgorithmSpecifierEClass = null;

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
		LifecyclePackageImpl theLifecyclePackage = (LifecyclePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LifecyclePackage.eNS_URI) instanceof LifecyclePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LifecyclePackage.eNS_URI) : LifecyclePackage.eINSTANCE);
		OptimizationPackageImpl theOptimizationPackage = (OptimizationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI) instanceof OptimizationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI) : OptimizationPackage.eINSTANCE);

		// Create package meta-data objects
		theRecommendationPackage.createPackageContents();
		theLifecyclePackage.createPackageContents();
		theOptimizationPackage.createPackageContents();

		// Initialize created meta-data
		theRecommendationPackage.initializePackageContents();
		theLifecyclePackage.initializePackageContents();
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
	public EReference getRecommendationTrainingConfiguration_Validator() {
		return (EReference)recommendationTrainingConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecommendationTrainingConfiguration_TrainingData() {
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
	public EReference getRecommendationTrainingConfiguration_LearningAlgorithm() {
		return (EReference)recommendationTrainingConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecommendationTrainingConfiguration_Estimators() {
		return (EReference)recommendationTrainingConfigurationEClass.getEStructuralFeatures().get(4);
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
	public EReference getFeatureExtractorSpecifier_RateUnit() {
		return (EReference)featureExtractorSpecifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureExtractorSpecifier_Aggregation() {
		return (EReference)featureExtractorSpecifierEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getDataSet_EstimationErrors() {
		return (EAttribute)dataSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSet_Features() {
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
	public EAttribute getFeatureVector_VarianceInflationFactor() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureVector_UtilizationStatistics() {
		return (EReference)featureVectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureVector_ResponseTimeStatistics() {
		return (EReference)featureVectorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureVector_ArrivalRateStatistics() {
		return (EReference)featureVectorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_ResponseArrivalCorrelation() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_ResponseArrivalCovariance() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_UtilizationResponseCorrelation() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_UtilizationResponseCovariance() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_UtilizationArrivalCorrelation() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_UtilizationArrivalCovariance() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_InterUtilizationCorrelation() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_InterUtilizationCovariance() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_InterResponseTimeCorrelation() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_InterResponseTimeCovariance() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_InterArrivalRateCorrelation() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureVector_InterArrivalRateCovariance() {
		return (EAttribute)featureVectorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatisticalFeatures() {
		return statisticalFeaturesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_N() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_ArithmeticMean() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_GeometricMean() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_StandardDeviation() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_QuadraticMean() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_Minimum() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_Maximum() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_Kurtosis() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_Skewness() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_Tenthpercentile() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_Ninetiethpercentile() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_Autocorrelation() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalFeatures_IsNormalDistributed() {
		return (EAttribute)statisticalFeaturesEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecisionTreeAlgorithmSpecifier() {
		return decisionTreeAlgorithmSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecisionTreeAlgorithmSpecifier_MaximumNumberOfNodes() {
		return (EAttribute)decisionTreeAlgorithmSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNeuralNetworkAlgorithmSpecifier() {
		return neuralNetworkAlgorithmSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNeuralNetworkAlgorithmSpecifier_NumberOfNeurons() {
		return (EAttribute)neuralNetworkAlgorithmSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSVMAlgorithmSpecifier() {
		return svmAlgorithmSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSVMAlgorithmSpecifier_GaussianSigma() {
		return (EAttribute)svmAlgorithmSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSVMAlgorithmSpecifier_SoftMarginPenalty() {
		return (EAttribute)svmAlgorithmSpecifierEClass.getEStructuralFeatures().get(1);
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
		createEReference(recommendationTrainingConfigurationEClass, RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR);
		createEReference(recommendationTrainingConfigurationEClass, RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA);
		createEReference(recommendationTrainingConfigurationEClass, RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM);
		createEReference(recommendationTrainingConfigurationEClass, RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM);
		createEReference(recommendationTrainingConfigurationEClass, RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS);

		recommendationAlgorithmSpecifierEClass = createEClass(RECOMMENDATION_ALGORITHM_SPECIFIER);
		createEAttribute(recommendationAlgorithmSpecifierEClass, RECOMMENDATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME);

		featureExtractorSpecifierEClass = createEClass(FEATURE_EXTRACTOR_SPECIFIER);
		createEAttribute(featureExtractorSpecifierEClass, FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR);
		createEReference(featureExtractorSpecifierEClass, FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT);
		createEReference(featureExtractorSpecifierEClass, FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION);

		dataSetEClass = createEClass(DATA_SET);
		createEReference(dataSetEClass, DATA_SET__CONFIGURATION);
		createEAttribute(dataSetEClass, DATA_SET__ESTIMATION_ERRORS);
		createEReference(dataSetEClass, DATA_SET__FEATURES);

		featureVectorEClass = createEClass(FEATURE_VECTOR);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__NUMBER_OF_RESSOURCES);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR);
		createEReference(featureVectorEClass, FEATURE_VECTOR__UTILIZATION_STATISTICS);
		createEReference(featureVectorEClass, FEATURE_VECTOR__RESPONSE_TIME_STATISTICS);
		createEReference(featureVectorEClass, FEATURE_VECTOR__ARRIVAL_RATE_STATISTICS);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION);
		createEAttribute(featureVectorEClass, FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE);

		statisticalFeaturesEClass = createEClass(STATISTICAL_FEATURES);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__N);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__ARITHMETIC_MEAN);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__GEOMETRIC_MEAN);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__STANDARD_DEVIATION);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__QUADRATIC_MEAN);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__MINIMUM);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__MAXIMUM);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__KURTOSIS);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__SKEWNESS);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__TENTHPERCENTILE);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__NINETIETHPERCENTILE);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__AUTOCORRELATION);
		createEAttribute(statisticalFeaturesEClass, STATISTICAL_FEATURES__IS_NORMAL_DISTRIBUTED);

		decisionTreeAlgorithmSpecifierEClass = createEClass(DECISION_TREE_ALGORITHM_SPECIFIER);
		createEAttribute(decisionTreeAlgorithmSpecifierEClass, DECISION_TREE_ALGORITHM_SPECIFIER__MAXIMUM_NUMBER_OF_NODES);

		neuralNetworkAlgorithmSpecifierEClass = createEClass(NEURAL_NETWORK_ALGORITHM_SPECIFIER);
		createEAttribute(neuralNetworkAlgorithmSpecifierEClass, NEURAL_NETWORK_ALGORITHM_SPECIFIER__NUMBER_OF_NEURONS);

		svmAlgorithmSpecifierEClass = createEClass(SVM_ALGORITHM_SPECIFIER);
		createEAttribute(svmAlgorithmSpecifierEClass, SVM_ALGORITHM_SPECIFIER__GAUSSIAN_SIGMA);
		createEAttribute(svmAlgorithmSpecifierEClass, SVM_ALGORITHM_SPECIFIER__SOFT_MARGIN_PENALTY);
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
		ConfigurationPackage theConfigurationPackage = (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI);
		OptimizationPackage theOptimizationPackage = (OptimizationPackage)EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		UnitsPackage theUnitsPackage = (UnitsPackage)EPackage.Registry.INSTANCE.getEPackage(UnitsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		decisionTreeAlgorithmSpecifierEClass.getESuperTypes().add(this.getRecommendationAlgorithmSpecifier());
		neuralNetworkAlgorithmSpecifierEClass.getESuperTypes().add(this.getRecommendationAlgorithmSpecifier());
		svmAlgorithmSpecifierEClass.getESuperTypes().add(this.getRecommendationAlgorithmSpecifier());

		// Initialize classes, features, and operations; add parameters
		initEClass(recommendationTrainingConfigurationEClass, RecommendationTrainingConfiguration.class, "RecommendationTrainingConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecommendationTrainingConfiguration_Validator(), theConfigurationPackage.getValidationSpecification(), null, "validator", null, 1, 1, RecommendationTrainingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationTrainingConfiguration_TrainingData(), theOptimizationPackage.getInputData(), null, "trainingData", null, 0, -1, RecommendationTrainingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationTrainingConfiguration_FeatureAlgorithm(), this.getFeatureExtractorSpecifier(), null, "featureAlgorithm", null, 1, 1, RecommendationTrainingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationTrainingConfiguration_LearningAlgorithm(), this.getRecommendationAlgorithmSpecifier(), null, "learningAlgorithm", null, 1, 1, RecommendationTrainingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationTrainingConfiguration_Estimators(), theConfigurationPackage.getEstimationSpecification(), null, "estimators", null, 1, -1, RecommendationTrainingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recommendationAlgorithmSpecifierEClass, RecommendationAlgorithmSpecifier.class, "RecommendationAlgorithmSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecommendationAlgorithmSpecifier_AlgorithmName(), theXMLTypePackage.getString(), "algorithmName", null, 1, 1, RecommendationAlgorithmSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureExtractorSpecifierEClass, FeatureExtractorSpecifier.class, "FeatureExtractorSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureExtractorSpecifier_FeatureExtractor(), ecorePackage.getEString(), "featureExtractor", null, 1, 1, FeatureExtractorSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(theUnitsPackage.getUnit());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getFeatureExtractorSpecifier_RateUnit(), g1, null, "rateUnit", null, 1, 1, FeatureExtractorSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theUnitsPackage.getQuantity());
		g2 = createEGenericType(theUnitsPackage.getTime());
		g1.getETypeArguments().add(g2);
		initEReference(getFeatureExtractorSpecifier_Aggregation(), g1, null, "aggregation", null, 1, 1, FeatureExtractorSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataSetEClass, DataSet.class, "DataSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSet_Configuration(), theConfigurationPackage.getLibredeConfiguration(), null, "configuration", null, 1, 1, DataSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(theConfigurationPackage.getEstimationAlgorithmConfiguration());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theXMLTypePackage.getDoubleObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getDataSet_EstimationErrors(), g1, "estimationErrors", null, 1, 1, DataSet.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSet_Features(), this.getFeatureVector(), null, "features", null, 1, 1, DataSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureVectorEClass, FeatureVector.class, "FeatureVector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureVector_NumberOfRessources(), theXMLTypePackage.getInt(), "numberOfRessources", "1", 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_NumberOfWorkloadClasses(), theXMLTypePackage.getInt(), "numberOfWorkloadClasses", "1", 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_VarianceInflationFactor(), theXMLTypePackage.getDouble(), "varianceInflationFactor", "-1", 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureVector_UtilizationStatistics(), this.getStatisticalFeatures(), null, "utilizationStatistics", null, 1, -1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureVector_ResponseTimeStatistics(), this.getStatisticalFeatures(), null, "responseTimeStatistics", null, 1, -1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureVector_ArrivalRateStatistics(), this.getStatisticalFeatures(), null, "arrivalRateStatistics", null, 1, -1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_ResponseArrivalCorrelation(), theXMLTypePackage.getDouble(), "responseArrivalCorrelation", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_ResponseArrivalCovariance(), theXMLTypePackage.getDouble(), "responseArrivalCovariance", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_UtilizationResponseCorrelation(), theXMLTypePackage.getDouble(), "utilizationResponseCorrelation", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_UtilizationResponseCovariance(), theXMLTypePackage.getDouble(), "utilizationResponseCovariance", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_UtilizationArrivalCorrelation(), theXMLTypePackage.getDouble(), "utilizationArrivalCorrelation", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_UtilizationArrivalCovariance(), theXMLTypePackage.getDouble(), "utilizationArrivalCovariance", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_InterUtilizationCorrelation(), theXMLTypePackage.getDouble(), "interUtilizationCorrelation", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_InterUtilizationCovariance(), theXMLTypePackage.getDouble(), "interUtilizationCovariance", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_InterResponseTimeCorrelation(), theXMLTypePackage.getDouble(), "interResponseTimeCorrelation", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_InterResponseTimeCovariance(), theXMLTypePackage.getDouble(), "interResponseTimeCovariance", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_InterArrivalRateCorrelation(), theXMLTypePackage.getDouble(), "interArrivalRateCorrelation", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureVector_InterArrivalRateCovariance(), theXMLTypePackage.getDouble(), "interArrivalRateCovariance", null, 1, 1, FeatureVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statisticalFeaturesEClass, StatisticalFeatures.class, "StatisticalFeatures", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatisticalFeatures_N(), theXMLTypePackage.getDouble(), "N", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_ArithmeticMean(), theXMLTypePackage.getDouble(), "arithmeticMean", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_GeometricMean(), theXMLTypePackage.getDouble(), "geometricMean", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_StandardDeviation(), theXMLTypePackage.getDouble(), "standardDeviation", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_QuadraticMean(), theXMLTypePackage.getDouble(), "quadraticMean", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_Minimum(), theXMLTypePackage.getDouble(), "minimum", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_Maximum(), theXMLTypePackage.getDouble(), "maximum", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_Kurtosis(), theXMLTypePackage.getDouble(), "kurtosis", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_Skewness(), theXMLTypePackage.getDouble(), "skewness", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_Tenthpercentile(), theXMLTypePackage.getDouble(), "tenthpercentile", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_Ninetiethpercentile(), theXMLTypePackage.getDouble(), "ninetiethpercentile", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_Autocorrelation(), theXMLTypePackage.getDouble(), "autocorrelation", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalFeatures_IsNormalDistributed(), theXMLTypePackage.getDouble(), "isNormalDistributed", "-1", 1, 1, StatisticalFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decisionTreeAlgorithmSpecifierEClass, DecisionTreeAlgorithmSpecifier.class, "DecisionTreeAlgorithmSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDecisionTreeAlgorithmSpecifier_MaximumNumberOfNodes(), theXMLTypePackage.getInt(), "maximumNumberOfNodes", "100", 1, 1, DecisionTreeAlgorithmSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(neuralNetworkAlgorithmSpecifierEClass, NeuralNetworkAlgorithmSpecifier.class, "NeuralNetworkAlgorithmSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNeuralNetworkAlgorithmSpecifier_NumberOfNeurons(), theXMLTypePackage.getInt(), "numberOfNeurons", "100", 1, 1, NeuralNetworkAlgorithmSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(svmAlgorithmSpecifierEClass, SVMAlgorithmSpecifier.class, "SVMAlgorithmSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSVMAlgorithmSpecifier_GaussianSigma(), theXMLTypePackage.getDouble(), "gaussianSigma", "8.0", 1, 1, SVMAlgorithmSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSVMAlgorithmSpecifier_SoftMarginPenalty(), theXMLTypePackage.getDouble(), "softMarginPenalty", "5.0", 1, 1, SVMAlgorithmSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RecommendationPackageImpl
