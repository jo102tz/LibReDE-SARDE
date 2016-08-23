/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see tools.descartes.librede.rrde.recommendation.RecommendationFactory
 * @model kind="package"
 * @generated
 */
public interface RecommendationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "recommendation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://tools/descartes/librede/rrde/recommendation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "librede-recommendation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RecommendationPackage eINSTANCE = tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl.init();

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationTrainingConfigurationImpl <em>Training Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationTrainingConfigurationImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getRecommendationTrainingConfiguration()
	 * @generated
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Training Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA = 0;

	/**
	 * The feature id for the '<em><b>Learning Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM = 1;

	/**
	 * The feature id for the '<em><b>Feature Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM = 2;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS = 3;

	/**
	 * The number of structural features of the '<em>Training Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Training Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.ConfigurationResultImpl <em>Configuration Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.ConfigurationResultImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getConfigurationResult()
	 * @generated
	 */
	int CONFIGURATION_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_RESULT__CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Error Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_RESULT__ERROR_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Configuration Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_RESULT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Configuration Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationAlgorithmSpecifierImpl <em>Algorithm Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationAlgorithmSpecifierImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getRecommendationAlgorithmSpecifier()
	 * @generated
	 */
	int RECOMMENDATION_ALGORITHM_SPECIFIER = 2;

	/**
	 * The feature id for the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME = 0;

	/**
	 * The number of structural features of the '<em>Algorithm Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_ALGORITHM_SPECIFIER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Algorithm Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_ALGORITHM_SPECIFIER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.FeatureExtractorSpecifierImpl <em>Feature Extractor Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.FeatureExtractorSpecifierImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getFeatureExtractorSpecifier()
	 * @generated
	 */
	int FEATURE_EXTRACTOR_SPECIFIER = 3;

	/**
	 * The feature id for the '<em><b>Feature Extractor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR = 0;

	/**
	 * The number of structural features of the '<em>Feature Extractor Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXTRACTOR_SPECIFIER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Feature Extractor Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXTRACTOR_SPECIFIER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.DataSetImpl <em>Data Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.DataSetImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getDataSet()
	 * @generated
	 */
	int DATA_SET = 4;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET__CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET__FEATURES = 1;

	/**
	 * The feature id for the '<em><b>Configuration Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET__CONFIGURATION_VALUES = 2;

	/**
	 * The number of structural features of the '<em>Data Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Data Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl <em>Feature Vector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getFeatureVector()
	 * @generated
	 */
	int FEATURE_VECTOR = 5;

	/**
	 * The feature id for the '<em><b>Number Of Ressources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__NUMBER_OF_RESSOURCES = 0;

	/**
	 * The feature id for the '<em><b>Number Of Workload Classes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES = 1;

	/**
	 * The feature id for the '<em><b>Utilization Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__UTILIZATION_MEAN = 2;

	/**
	 * The feature id for the '<em><b>Utilization Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__UTILIZATION_VARIANCE = 3;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__TRACES = 4;

	/**
	 * The feature id for the '<em><b>Variance Inflation Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR = 5;

	/**
	 * The number of structural features of the '<em>Feature Vector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Feature Vector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl <em>Trace Features</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getTraceFeatures()
	 * @generated
	 */
	int TRACE_FEATURES = 6;

	/**
	 * The feature id for the '<em><b>Arithmetic Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__ARITHMETIC_MEAN = 0;

	/**
	 * The feature id for the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__STANDARD_DEVIATION = 1;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__MINIMUM = 2;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__MAXIMUM = 3;

	/**
	 * The feature id for the '<em><b>Number Of Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__NUMBER_OF_SAMPLES = 4;

	/**
	 * The feature id for the '<em><b>Aggregation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__AGGREGATION_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Aggregation Interval</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__AGGREGATION_INTERVAL = 6;

	/**
	 * The feature id for the '<em><b>Auto Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__AUTO_CORRELATION = 7;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__METRIC = 8;

	/**
	 * The feature id for the '<em><b>Original Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES__ORIGINAL_INPUT = 9;

	/**
	 * The number of structural features of the '<em>Trace Features</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Trace Features</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURES_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration <em>Training Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Training Configuration</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration
	 * @generated
	 */
	EClass getRecommendationTrainingConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getTrainingData <em>Training Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Training Data</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getTrainingData()
	 * @see #getRecommendationTrainingConfiguration()
	 * @generated
	 */
	EReference getRecommendationTrainingConfiguration_TrainingData();

	/**
	 * Returns the meta object for the reference '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getLearningAlgorithm <em>Learning Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Learning Algorithm</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getLearningAlgorithm()
	 * @see #getRecommendationTrainingConfiguration()
	 * @generated
	 */
	EReference getRecommendationTrainingConfiguration_LearningAlgorithm();

	/**
	 * Returns the meta object for the reference '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getFeatureAlgorithm <em>Feature Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Algorithm</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getFeatureAlgorithm()
	 * @see #getRecommendationTrainingConfiguration()
	 * @generated
	 */
	EReference getRecommendationTrainingConfiguration_FeatureAlgorithm();

	/**
	 * Returns the meta object for the reference list '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Configurations</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getConfigurations()
	 * @see #getRecommendationTrainingConfiguration()
	 * @generated
	 */
	EReference getRecommendationTrainingConfiguration_Configurations();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.recommendation.ConfigurationResult <em>Configuration Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Result</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.ConfigurationResult
	 * @generated
	 */
	EClass getConfigurationResult();

	/**
	 * Returns the meta object for the reference '{@link tools.descartes.librede.rrde.recommendation.ConfigurationResult#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configuration</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.ConfigurationResult#getConfiguration()
	 * @see #getConfigurationResult()
	 * @generated
	 */
	EReference getConfigurationResult_Configuration();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.ConfigurationResult#getErrorValue <em>Error Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Value</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.ConfigurationResult#getErrorValue()
	 * @see #getConfigurationResult()
	 * @generated
	 */
	EAttribute getConfigurationResult_ErrorValue();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier <em>Algorithm Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Algorithm Specifier</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier
	 * @generated
	 */
	EClass getRecommendationAlgorithmSpecifier();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier#getAlgorithmName <em>Algorithm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm Name</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier#getAlgorithmName()
	 * @see #getRecommendationAlgorithmSpecifier()
	 * @generated
	 */
	EAttribute getRecommendationAlgorithmSpecifier_AlgorithmName();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier <em>Feature Extractor Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Extractor Specifier</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier
	 * @generated
	 */
	EClass getFeatureExtractorSpecifier();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getFeatureExtractor <em>Feature Extractor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Extractor</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getFeatureExtractor()
	 * @see #getFeatureExtractorSpecifier()
	 * @generated
	 */
	EAttribute getFeatureExtractorSpecifier_FeatureExtractor();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.recommendation.DataSet <em>Data Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Set</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.DataSet
	 * @generated
	 */
	EClass getDataSet();

	/**
	 * Returns the meta object for the reference '{@link tools.descartes.librede.rrde.recommendation.DataSet#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configuration</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.DataSet#getConfiguration()
	 * @see #getDataSet()
	 * @generated
	 */
	EReference getDataSet_Configuration();

	/**
	 * Returns the meta object for the reference '{@link tools.descartes.librede.rrde.recommendation.DataSet#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Features</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.DataSet#getFeatures()
	 * @see #getDataSet()
	 * @generated
	 */
	EReference getDataSet_Features();

	/**
	 * Returns the meta object for the reference list '{@link tools.descartes.librede.rrde.recommendation.DataSet#getConfigurationValues <em>Configuration Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Configuration Values</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.DataSet#getConfigurationValues()
	 * @see #getDataSet()
	 * @generated
	 */
	EReference getDataSet_ConfigurationValues();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.recommendation.FeatureVector <em>Feature Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Vector</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector
	 * @generated
	 */
	EClass getFeatureVector();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getNumberOfRessources <em>Number Of Ressources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Ressources</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getNumberOfRessources()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_NumberOfRessources();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getNumberOfWorkloadClasses <em>Number Of Workload Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Workload Classes</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getNumberOfWorkloadClasses()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_NumberOfWorkloadClasses();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationMean <em>Utilization Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization Mean</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationMean()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_UtilizationMean();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationVariance <em>Utilization Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization Variance</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationVariance()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_UtilizationVariance();

	/**
	 * Returns the meta object for the reference list '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Traces</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getTraces()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EReference getFeatureVector_Traces();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getVarianceInflationFactor <em>Variance Inflation Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variance Inflation Factor</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getVarianceInflationFactor()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_VarianceInflationFactor();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures <em>Trace Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Features</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures
	 * @generated
	 */
	EClass getTraceFeatures();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getArithmeticMean <em>Arithmetic Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arithmetic Mean</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#getArithmeticMean()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EAttribute getTraceFeatures_ArithmeticMean();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getStandardDeviation <em>Standard Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standard Deviation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#getStandardDeviation()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EAttribute getTraceFeatures_StandardDeviation();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#getMinimum()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EAttribute getTraceFeatures_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#getMaximum()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EAttribute getTraceFeatures_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getNumberOfSamples <em>Number Of Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Samples</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#getNumberOfSamples()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EAttribute getTraceFeatures_NumberOfSamples();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getAggregationType <em>Aggregation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aggregation Type</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#getAggregationType()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EAttribute getTraceFeatures_AggregationType();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getAggregationInterval <em>Aggregation Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Aggregation Interval</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#getAggregationInterval()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EReference getTraceFeatures_AggregationInterval();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getAutoCorrelation <em>Auto Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Correlation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#getAutoCorrelation()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EAttribute getTraceFeatures_AutoCorrelation();

	/**
	 * Returns the meta object for the reference '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#getMetric()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EReference getTraceFeatures_Metric();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#isOriginalInput <em>Original Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Input</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.TraceFeatures#isOriginalInput()
	 * @see #getTraceFeatures()
	 * @generated
	 */
	EAttribute getTraceFeatures_OriginalInput();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RecommendationFactory getRecommendationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationTrainingConfigurationImpl <em>Training Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationTrainingConfigurationImpl
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getRecommendationTrainingConfiguration()
		 * @generated
		 */
		EClass RECOMMENDATION_TRAINING_CONFIGURATION = eINSTANCE.getRecommendationTrainingConfiguration();

		/**
		 * The meta object literal for the '<em><b>Training Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA = eINSTANCE.getRecommendationTrainingConfiguration_TrainingData();

		/**
		 * The meta object literal for the '<em><b>Learning Algorithm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM = eINSTANCE.getRecommendationTrainingConfiguration_LearningAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Feature Algorithm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM = eINSTANCE.getRecommendationTrainingConfiguration_FeatureAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS = eINSTANCE.getRecommendationTrainingConfiguration_Configurations();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.recommendation.impl.ConfigurationResultImpl <em>Configuration Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.recommendation.impl.ConfigurationResultImpl
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getConfigurationResult()
		 * @generated
		 */
		EClass CONFIGURATION_RESULT = eINSTANCE.getConfigurationResult();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_RESULT__CONFIGURATION = eINSTANCE.getConfigurationResult_Configuration();

		/**
		 * The meta object literal for the '<em><b>Error Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_RESULT__ERROR_VALUE = eINSTANCE.getConfigurationResult_ErrorValue();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationAlgorithmSpecifierImpl <em>Algorithm Specifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationAlgorithmSpecifierImpl
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getRecommendationAlgorithmSpecifier()
		 * @generated
		 */
		EClass RECOMMENDATION_ALGORITHM_SPECIFIER = eINSTANCE.getRecommendationAlgorithmSpecifier();

		/**
		 * The meta object literal for the '<em><b>Algorithm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOMMENDATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME = eINSTANCE.getRecommendationAlgorithmSpecifier_AlgorithmName();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.recommendation.impl.FeatureExtractorSpecifierImpl <em>Feature Extractor Specifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.recommendation.impl.FeatureExtractorSpecifierImpl
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getFeatureExtractorSpecifier()
		 * @generated
		 */
		EClass FEATURE_EXTRACTOR_SPECIFIER = eINSTANCE.getFeatureExtractorSpecifier();

		/**
		 * The meta object literal for the '<em><b>Feature Extractor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR = eINSTANCE.getFeatureExtractorSpecifier_FeatureExtractor();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.recommendation.impl.DataSetImpl <em>Data Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.recommendation.impl.DataSetImpl
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getDataSet()
		 * @generated
		 */
		EClass DATA_SET = eINSTANCE.getDataSet();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SET__CONFIGURATION = eINSTANCE.getDataSet_Configuration();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SET__FEATURES = eINSTANCE.getDataSet_Features();

		/**
		 * The meta object literal for the '<em><b>Configuration Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SET__CONFIGURATION_VALUES = eINSTANCE.getDataSet_ConfigurationValues();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl <em>Feature Vector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getFeatureVector()
		 * @generated
		 */
		EClass FEATURE_VECTOR = eINSTANCE.getFeatureVector();

		/**
		 * The meta object literal for the '<em><b>Number Of Ressources</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__NUMBER_OF_RESSOURCES = eINSTANCE.getFeatureVector_NumberOfRessources();

		/**
		 * The meta object literal for the '<em><b>Number Of Workload Classes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES = eINSTANCE.getFeatureVector_NumberOfWorkloadClasses();

		/**
		 * The meta object literal for the '<em><b>Utilization Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__UTILIZATION_MEAN = eINSTANCE.getFeatureVector_UtilizationMean();

		/**
		 * The meta object literal for the '<em><b>Utilization Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__UTILIZATION_VARIANCE = eINSTANCE.getFeatureVector_UtilizationVariance();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_VECTOR__TRACES = eINSTANCE.getFeatureVector_Traces();

		/**
		 * The meta object literal for the '<em><b>Variance Inflation Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR = eINSTANCE.getFeatureVector_VarianceInflationFactor();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl <em>Trace Features</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getTraceFeatures()
		 * @generated
		 */
		EClass TRACE_FEATURES = eINSTANCE.getTraceFeatures();

		/**
		 * The meta object literal for the '<em><b>Arithmetic Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_FEATURES__ARITHMETIC_MEAN = eINSTANCE.getTraceFeatures_ArithmeticMean();

		/**
		 * The meta object literal for the '<em><b>Standard Deviation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_FEATURES__STANDARD_DEVIATION = eINSTANCE.getTraceFeatures_StandardDeviation();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_FEATURES__MINIMUM = eINSTANCE.getTraceFeatures_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_FEATURES__MAXIMUM = eINSTANCE.getTraceFeatures_Maximum();

		/**
		 * The meta object literal for the '<em><b>Number Of Samples</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_FEATURES__NUMBER_OF_SAMPLES = eINSTANCE.getTraceFeatures_NumberOfSamples();

		/**
		 * The meta object literal for the '<em><b>Aggregation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_FEATURES__AGGREGATION_TYPE = eINSTANCE.getTraceFeatures_AggregationType();

		/**
		 * The meta object literal for the '<em><b>Aggregation Interval</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_FEATURES__AGGREGATION_INTERVAL = eINSTANCE.getTraceFeatures_AggregationInterval();

		/**
		 * The meta object literal for the '<em><b>Auto Correlation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_FEATURES__AUTO_CORRELATION = eINSTANCE.getTraceFeatures_AutoCorrelation();

		/**
		 * The meta object literal for the '<em><b>Metric</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_FEATURES__METRIC = eINSTANCE.getTraceFeatures_Metric();

		/**
		 * The meta object literal for the '<em><b>Original Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_FEATURES__ORIGINAL_INPUT = eINSTANCE.getTraceFeatures_OriginalInput();

	}

} //RecommendationPackage
