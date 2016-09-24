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
	 * The feature id for the '<em><b>Validator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR = 0;

	/**
	 * The feature id for the '<em><b>Training Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA = 1;

	/**
	 * The feature id for the '<em><b>Feature Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM = 2;

	/**
	 * The feature id for the '<em><b>Learning Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM = 3;

	/**
	 * The feature id for the '<em><b>Estimators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS = 4;

	/**
	 * The number of structural features of the '<em>Training Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Training Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_TRAINING_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationAlgorithmSpecifierImpl <em>Algorithm Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationAlgorithmSpecifierImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getRecommendationAlgorithmSpecifier()
	 * @generated
	 */
	int RECOMMENDATION_ALGORITHM_SPECIFIER = 1;

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
	int FEATURE_EXTRACTOR_SPECIFIER = 2;

	/**
	 * The feature id for the '<em><b>Feature Extractor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR = 0;

	/**
	 * The feature id for the '<em><b>Rate Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Aggregation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION = 2;

	/**
	 * The number of structural features of the '<em>Feature Extractor Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXTRACTOR_SPECIFIER_FEATURE_COUNT = 3;

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
	int DATA_SET = 3;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET__CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Estimation Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET__ESTIMATION_ERRORS = 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET__FEATURES = 2;

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
	int FEATURE_VECTOR = 4;

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
	 * The feature id for the '<em><b>Variance Inflation Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR = 2;

	/**
	 * The feature id for the '<em><b>Utilization Statistics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__UTILIZATION_STATISTICS = 3;

	/**
	 * The feature id for the '<em><b>Response Time Statistics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__RESPONSE_TIME_STATISTICS = 4;

	/**
	 * The feature id for the '<em><b>Arrival Rate Statistics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__ARRIVAL_RATE_STATISTICS = 5;

	/**
	 * The feature id for the '<em><b>Response Arrival Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION = 6;

	/**
	 * The feature id for the '<em><b>Response Arrival Covariance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE = 7;

	/**
	 * The feature id for the '<em><b>Utilization Response Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION = 8;

	/**
	 * The feature id for the '<em><b>Utilization Response Covariance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE = 9;

	/**
	 * The feature id for the '<em><b>Utilization Arrival Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION = 10;

	/**
	 * The feature id for the '<em><b>Utilization Arrival Covariance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE = 11;

	/**
	 * The feature id for the '<em><b>Inter Utilization Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION = 12;

	/**
	 * The feature id for the '<em><b>Inter Utilization Covariance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE = 13;

	/**
	 * The feature id for the '<em><b>Inter Response Time Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION = 14;

	/**
	 * The feature id for the '<em><b>Inter Response Time Covariance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE = 15;

	/**
	 * The feature id for the '<em><b>Inter Arrival Rate Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION = 16;

	/**
	 * The feature id for the '<em><b>Inter Arrival Rate Covariance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE = 17;

	/**
	 * The number of structural features of the '<em>Feature Vector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR_FEATURE_COUNT = 18;

	/**
	 * The number of operations of the '<em>Feature Vector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VECTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl <em>Statistical Features</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getStatisticalFeatures()
	 * @generated
	 */
	int STATISTICAL_FEATURES = 5;

	/**
	 * The feature id for the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__N = 0;

	/**
	 * The feature id for the '<em><b>Arithmetic Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__ARITHMETIC_MEAN = 1;

	/**
	 * The feature id for the '<em><b>Geometric Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__GEOMETRIC_MEAN = 2;

	/**
	 * The feature id for the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__STANDARD_DEVIATION = 3;

	/**
	 * The feature id for the '<em><b>Quadratic Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__QUADRATIC_MEAN = 4;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__MINIMUM = 5;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__MAXIMUM = 6;

	/**
	 * The feature id for the '<em><b>Kurtosis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__KURTOSIS = 7;

	/**
	 * The feature id for the '<em><b>Skewness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__SKEWNESS = 8;

	/**
	 * The feature id for the '<em><b>Tenthpercentile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__TENTHPERCENTILE = 9;

	/**
	 * The feature id for the '<em><b>Ninetiethpercentile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__NINETIETHPERCENTILE = 10;

	/**
	 * The feature id for the '<em><b>Autocorrelation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES__AUTOCORRELATION = 11;

	/**
	 * The number of structural features of the '<em>Statistical Features</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Statistical Features</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_FEATURES_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.recommendation.impl.DecisionTreeAlgorithmSpecifierImpl <em>Decision Tree Algorithm Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.recommendation.impl.DecisionTreeAlgorithmSpecifierImpl
	 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getDecisionTreeAlgorithmSpecifier()
	 * @generated
	 */
	int DECISION_TREE_ALGORITHM_SPECIFIER = 6;

	/**
	 * The feature id for the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_TREE_ALGORITHM_SPECIFIER__ALGORITHM_NAME = RECOMMENDATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_TREE_ALGORITHM_SPECIFIER__MAXIMUM_NUMBER_OF_NODES = RECOMMENDATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decision Tree Algorithm Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_TREE_ALGORITHM_SPECIFIER_FEATURE_COUNT = RECOMMENDATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Decision Tree Algorithm Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_TREE_ALGORITHM_SPECIFIER_OPERATION_COUNT = RECOMMENDATION_ALGORITHM_SPECIFIER_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getValidator <em>Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Validator</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getValidator()
	 * @see #getRecommendationTrainingConfiguration()
	 * @generated
	 */
	EReference getRecommendationTrainingConfiguration_Validator();

	/**
	 * Returns the meta object for the containment reference list '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getTrainingData <em>Training Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Training Data</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getTrainingData()
	 * @see #getRecommendationTrainingConfiguration()
	 * @generated
	 */
	EReference getRecommendationTrainingConfiguration_TrainingData();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getFeatureAlgorithm <em>Feature Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Algorithm</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getFeatureAlgorithm()
	 * @see #getRecommendationTrainingConfiguration()
	 * @generated
	 */
	EReference getRecommendationTrainingConfiguration_FeatureAlgorithm();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getLearningAlgorithm <em>Learning Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Learning Algorithm</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getLearningAlgorithm()
	 * @see #getRecommendationTrainingConfiguration()
	 * @generated
	 */
	EReference getRecommendationTrainingConfiguration_LearningAlgorithm();

	/**
	 * Returns the meta object for the containment reference list '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getEstimators <em>Estimators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Estimators</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getEstimators()
	 * @see #getRecommendationTrainingConfiguration()
	 * @generated
	 */
	EReference getRecommendationTrainingConfiguration_Estimators();

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
	 * Returns the meta object for the reference '{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getRateUnit <em>Rate Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rate Unit</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getRateUnit()
	 * @see #getFeatureExtractorSpecifier()
	 * @generated
	 */
	EReference getFeatureExtractorSpecifier_RateUnit();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getAggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Aggregation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getAggregation()
	 * @see #getFeatureExtractorSpecifier()
	 * @generated
	 */
	EReference getFeatureExtractorSpecifier_Aggregation();

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
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.DataSet#getEstimationErrors <em>Estimation Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Estimation Errors</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.DataSet#getEstimationErrors()
	 * @see #getDataSet()
	 * @generated
	 */
	EAttribute getDataSet_EstimationErrors();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.recommendation.DataSet#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Features</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.DataSet#getFeatures()
	 * @see #getDataSet()
	 * @generated
	 */
	EReference getDataSet_Features();

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
	 * Returns the meta object for the reference list '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationStatistics <em>Utilization Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Utilization Statistics</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationStatistics()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EReference getFeatureVector_UtilizationStatistics();

	/**
	 * Returns the meta object for the reference list '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseTimeStatistics <em>Response Time Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Response Time Statistics</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseTimeStatistics()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EReference getFeatureVector_ResponseTimeStatistics();

	/**
	 * Returns the meta object for the reference list '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getArrivalRateStatistics <em>Arrival Rate Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arrival Rate Statistics</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getArrivalRateStatistics()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EReference getFeatureVector_ArrivalRateStatistics();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseArrivalCorrelation <em>Response Arrival Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Arrival Correlation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseArrivalCorrelation()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_ResponseArrivalCorrelation();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseArrivalCovariance <em>Response Arrival Covariance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Arrival Covariance</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseArrivalCovariance()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_ResponseArrivalCovariance();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationResponseCorrelation <em>Utilization Response Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization Response Correlation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationResponseCorrelation()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_UtilizationResponseCorrelation();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationResponseCovariance <em>Utilization Response Covariance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization Response Covariance</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationResponseCovariance()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_UtilizationResponseCovariance();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationArrivalCorrelation <em>Utilization Arrival Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization Arrival Correlation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationArrivalCorrelation()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_UtilizationArrivalCorrelation();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationArrivalCovariance <em>Utilization Arrival Covariance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization Arrival Covariance</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationArrivalCovariance()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_UtilizationArrivalCovariance();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterUtilizationCorrelation <em>Inter Utilization Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inter Utilization Correlation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getInterUtilizationCorrelation()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_InterUtilizationCorrelation();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterUtilizationCovariance <em>Inter Utilization Covariance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inter Utilization Covariance</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getInterUtilizationCovariance()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_InterUtilizationCovariance();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterResponseTimeCorrelation <em>Inter Response Time Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inter Response Time Correlation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getInterResponseTimeCorrelation()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_InterResponseTimeCorrelation();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterResponseTimeCovariance <em>Inter Response Time Covariance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inter Response Time Covariance</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getInterResponseTimeCovariance()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_InterResponseTimeCovariance();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterArrivalRateCorrelation <em>Inter Arrival Rate Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inter Arrival Rate Correlation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getInterArrivalRateCorrelation()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_InterArrivalRateCorrelation();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterArrivalRateCovariance <em>Inter Arrival Rate Covariance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inter Arrival Rate Covariance</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector#getInterArrivalRateCovariance()
	 * @see #getFeatureVector()
	 * @generated
	 */
	EAttribute getFeatureVector_InterArrivalRateCovariance();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures <em>Statistical Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statistical Features</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures
	 * @generated
	 */
	EClass getStatisticalFeatures();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getN <em>N</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>N</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getN()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_N();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getArithmeticMean <em>Arithmetic Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arithmetic Mean</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getArithmeticMean()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_ArithmeticMean();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getGeometricMean <em>Geometric Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Geometric Mean</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getGeometricMean()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_GeometricMean();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getStandardDeviation <em>Standard Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standard Deviation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getStandardDeviation()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_StandardDeviation();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getQuadraticMean <em>Quadratic Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quadratic Mean</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getQuadraticMean()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_QuadraticMean();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getMinimum()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getMaximum()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getKurtosis <em>Kurtosis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kurtosis</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getKurtosis()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_Kurtosis();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getSkewness <em>Skewness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skewness</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getSkewness()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_Skewness();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getTenthpercentile <em>Tenthpercentile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tenthpercentile</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getTenthpercentile()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_Tenthpercentile();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getNinetiethpercentile <em>Ninetiethpercentile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ninetiethpercentile</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getNinetiethpercentile()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_Ninetiethpercentile();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getAutocorrelation <em>Autocorrelation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autocorrelation</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getAutocorrelation()
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	EAttribute getStatisticalFeatures_Autocorrelation();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier <em>Decision Tree Algorithm Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision Tree Algorithm Specifier</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier
	 * @generated
	 */
	EClass getDecisionTreeAlgorithmSpecifier();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier#getMaximumNumberOfNodes <em>Maximum Number Of Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Nodes</em>'.
	 * @see tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier#getMaximumNumberOfNodes()
	 * @see #getDecisionTreeAlgorithmSpecifier()
	 * @generated
	 */
	EAttribute getDecisionTreeAlgorithmSpecifier_MaximumNumberOfNodes();

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
		 * The meta object literal for the '<em><b>Validator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR = eINSTANCE.getRecommendationTrainingConfiguration_Validator();

		/**
		 * The meta object literal for the '<em><b>Training Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA = eINSTANCE.getRecommendationTrainingConfiguration_TrainingData();

		/**
		 * The meta object literal for the '<em><b>Feature Algorithm</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM = eINSTANCE.getRecommendationTrainingConfiguration_FeatureAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Learning Algorithm</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM = eINSTANCE.getRecommendationTrainingConfiguration_LearningAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Estimators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS = eINSTANCE.getRecommendationTrainingConfiguration_Estimators();

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
		 * The meta object literal for the '<em><b>Rate Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT = eINSTANCE.getFeatureExtractorSpecifier_RateUnit();

		/**
		 * The meta object literal for the '<em><b>Aggregation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION = eINSTANCE.getFeatureExtractorSpecifier_Aggregation();

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
		 * The meta object literal for the '<em><b>Estimation Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SET__ESTIMATION_ERRORS = eINSTANCE.getDataSet_EstimationErrors();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SET__FEATURES = eINSTANCE.getDataSet_Features();

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
		 * The meta object literal for the '<em><b>Variance Inflation Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR = eINSTANCE.getFeatureVector_VarianceInflationFactor();

		/**
		 * The meta object literal for the '<em><b>Utilization Statistics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_VECTOR__UTILIZATION_STATISTICS = eINSTANCE.getFeatureVector_UtilizationStatistics();

		/**
		 * The meta object literal for the '<em><b>Response Time Statistics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_VECTOR__RESPONSE_TIME_STATISTICS = eINSTANCE.getFeatureVector_ResponseTimeStatistics();

		/**
		 * The meta object literal for the '<em><b>Arrival Rate Statistics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_VECTOR__ARRIVAL_RATE_STATISTICS = eINSTANCE.getFeatureVector_ArrivalRateStatistics();

		/**
		 * The meta object literal for the '<em><b>Response Arrival Correlation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION = eINSTANCE.getFeatureVector_ResponseArrivalCorrelation();

		/**
		 * The meta object literal for the '<em><b>Response Arrival Covariance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE = eINSTANCE.getFeatureVector_ResponseArrivalCovariance();

		/**
		 * The meta object literal for the '<em><b>Utilization Response Correlation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION = eINSTANCE.getFeatureVector_UtilizationResponseCorrelation();

		/**
		 * The meta object literal for the '<em><b>Utilization Response Covariance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE = eINSTANCE.getFeatureVector_UtilizationResponseCovariance();

		/**
		 * The meta object literal for the '<em><b>Utilization Arrival Correlation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION = eINSTANCE.getFeatureVector_UtilizationArrivalCorrelation();

		/**
		 * The meta object literal for the '<em><b>Utilization Arrival Covariance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE = eINSTANCE.getFeatureVector_UtilizationArrivalCovariance();

		/**
		 * The meta object literal for the '<em><b>Inter Utilization Correlation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION = eINSTANCE.getFeatureVector_InterUtilizationCorrelation();

		/**
		 * The meta object literal for the '<em><b>Inter Utilization Covariance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE = eINSTANCE.getFeatureVector_InterUtilizationCovariance();

		/**
		 * The meta object literal for the '<em><b>Inter Response Time Correlation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION = eINSTANCE.getFeatureVector_InterResponseTimeCorrelation();

		/**
		 * The meta object literal for the '<em><b>Inter Response Time Covariance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE = eINSTANCE.getFeatureVector_InterResponseTimeCovariance();

		/**
		 * The meta object literal for the '<em><b>Inter Arrival Rate Correlation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION = eINSTANCE.getFeatureVector_InterArrivalRateCorrelation();

		/**
		 * The meta object literal for the '<em><b>Inter Arrival Rate Covariance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE = eINSTANCE.getFeatureVector_InterArrivalRateCovariance();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl <em>Statistical Features</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getStatisticalFeatures()
		 * @generated
		 */
		EClass STATISTICAL_FEATURES = eINSTANCE.getStatisticalFeatures();

		/**
		 * The meta object literal for the '<em><b>N</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__N = eINSTANCE.getStatisticalFeatures_N();

		/**
		 * The meta object literal for the '<em><b>Arithmetic Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__ARITHMETIC_MEAN = eINSTANCE.getStatisticalFeatures_ArithmeticMean();

		/**
		 * The meta object literal for the '<em><b>Geometric Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__GEOMETRIC_MEAN = eINSTANCE.getStatisticalFeatures_GeometricMean();

		/**
		 * The meta object literal for the '<em><b>Standard Deviation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__STANDARD_DEVIATION = eINSTANCE.getStatisticalFeatures_StandardDeviation();

		/**
		 * The meta object literal for the '<em><b>Quadratic Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__QUADRATIC_MEAN = eINSTANCE.getStatisticalFeatures_QuadraticMean();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__MINIMUM = eINSTANCE.getStatisticalFeatures_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__MAXIMUM = eINSTANCE.getStatisticalFeatures_Maximum();

		/**
		 * The meta object literal for the '<em><b>Kurtosis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__KURTOSIS = eINSTANCE.getStatisticalFeatures_Kurtosis();

		/**
		 * The meta object literal for the '<em><b>Skewness</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__SKEWNESS = eINSTANCE.getStatisticalFeatures_Skewness();

		/**
		 * The meta object literal for the '<em><b>Tenthpercentile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__TENTHPERCENTILE = eINSTANCE.getStatisticalFeatures_Tenthpercentile();

		/**
		 * The meta object literal for the '<em><b>Ninetiethpercentile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__NINETIETHPERCENTILE = eINSTANCE.getStatisticalFeatures_Ninetiethpercentile();

		/**
		 * The meta object literal for the '<em><b>Autocorrelation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_FEATURES__AUTOCORRELATION = eINSTANCE.getStatisticalFeatures_Autocorrelation();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.recommendation.impl.DecisionTreeAlgorithmSpecifierImpl <em>Decision Tree Algorithm Specifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.recommendation.impl.DecisionTreeAlgorithmSpecifierImpl
		 * @see tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl#getDecisionTreeAlgorithmSpecifier()
		 * @generated
		 */
		EClass DECISION_TREE_ALGORITHM_SPECIFIER = eINSTANCE.getDecisionTreeAlgorithmSpecifier();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Nodes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECISION_TREE_ALGORITHM_SPECIFIER__MAXIMUM_NUMBER_OF_NODES = eINSTANCE.getDecisionTreeAlgorithmSpecifier_MaximumNumberOfNodes();

	}

} //RecommendationPackage
