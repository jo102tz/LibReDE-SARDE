/**
 */
package tools.descartes.librede.rrde.optimization;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import tools.descartes.librede.configuration.ConfigurationPackage;

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
 * @see tools.descartes.librede.rrde.optimization.OptimizationFactory
 * @model kind="package"
 * @generated
 */
public interface OptimizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "optimization";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://tools/descartes/librede/rrde/optimization";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "librede-optimization";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OptimizationPackage eINSTANCE = tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.optimization.impl.OptimizationConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationConfigurationImpl
	 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getOptimizationConfiguration()
	 * @generated
	 */
	int OPTIMIZATION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Contains Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_CONFIGURATION__CONTAINS_OF = 0;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm <em>IConfiguration Optimization Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm
	 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getIConfigurationOptimizationAlgorithm()
	 * @generated
	 */
	int ICONFIGURATION_OPTIMIZATION_ALGORITHM = 1;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONFIGURATION_OPTIMIZATION_ALGORITHM__TIME_OUT = 0;

	/**
	 * The number of structural features of the '<em>IConfiguration Optimization Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Run Optimization</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONFIGURATION_OPTIMIZATION_ALGORITHM___RUN_OPTIMIZATION__INPUTDATA_OPTIMIZATIONSETTINGS_ESTIMATIONSPECIFICATION = 0;

	/**
	 * The operation id for the '<em>Configure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONFIGURATION_OPTIMIZATION_ALGORITHM___CONFIGURE__STRING_EOBJECT = 1;

	/**
	 * The number of operations of the '<em>IConfiguration Optimization Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONFIGURATION_OPTIMIZATION_ALGORITHM_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.optimization.impl.AbstractLocalSearchOptimizerImpl <em>Abstract Local Search Optimizer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.optimization.impl.AbstractLocalSearchOptimizerImpl
	 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getAbstractLocalSearchOptimizer()
	 * @generated
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER = 2;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER__TIME_OUT = ICONFIGURATION_OPTIMIZATION_ALGORITHM__TIME_OUT;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MINIMUM = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER__TOLERANCE = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Steps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM_NUMBER_OF_STEPS = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER__START_VALUE = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER__STEP_SIZE = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Abstract Local Search Optimizer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER_FEATURE_COUNT = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Run Optimization</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER___RUN_OPTIMIZATION__INPUTDATA_OPTIMIZATIONSETTINGS_ESTIMATIONSPECIFICATION = ICONFIGURATION_OPTIMIZATION_ALGORITHM___RUN_OPTIMIZATION__INPUTDATA_OPTIMIZATIONSETTINGS_ESTIMATIONSPECIFICATION;

	/**
	 * The operation id for the '<em>Configure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER___CONFIGURE__STRING_EOBJECT = ICONFIGURATION_OPTIMIZATION_ALGORITHM___CONFIGURE__STRING_EOBJECT;

	/**
	 * The number of operations of the '<em>Abstract Local Search Optimizer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCAL_SEARCH_OPTIMIZER_OPERATION_COUNT = ICONFIGURATION_OPTIMIZATION_ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl <em>Run Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.optimization.impl.RunCallImpl
	 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getRunCall()
	 * @generated
	 */
	int RUN_CALL = 3;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL__ALGORITHM = 0;

	/**
	 * The feature id for the '<em><b>Training Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL__TRAINING_DATA = 1;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL__SETTINGS = 2;

	/**
	 * The feature id for the '<em><b>Estimation Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL__ESTIMATION_SPECIFICATION = 3;

	/**
	 * The number of structural features of the '<em>Run Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Run Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.optimization.impl.InputDataImpl <em>Input Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.optimization.impl.InputDataImpl
	 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getInputData()
	 * @generated
	 */
	int INPUT_DATA = 4;

	/**
	 * The feature id for the '<em><b>Data Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA__DATA_SOURCES = ConfigurationPackage.INPUT_SPECIFICATION__DATA_SOURCES;

	/**
	 * The feature id for the '<em><b>Observations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA__OBSERVATIONS = ConfigurationPackage.INPUT_SPECIFICATION__OBSERVATIONS;

	/**
	 * The feature id for the '<em><b>Constant Data Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA__CONSTANT_DATA_POINTS = ConfigurationPackage.INPUT_SPECIFICATION__CONSTANT_DATA_POINTS;

	/**
	 * The feature id for the '<em><b>Results File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA__RESULTS_FILE = ConfigurationPackage.INPUT_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_FEATURE_COUNT = ConfigurationPackage.INPUT_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Input Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_OPERATION_COUNT = ConfigurationPackage.INPUT_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.optimization.impl.OptimizationSettingsImpl <em>Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationSettingsImpl
	 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getOptimizationSettings()
	 * @generated
	 */
	int OPTIMIZATION_SETTINGS = 5;

	/**
	 * The feature id for the '<em><b>Ignore Approaches</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_SETTINGS__IGNORE_APPROACHES = 0;

	/**
	 * The feature id for the '<em><b>Parameters To Optmize</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTMIZE = 1;

	/**
	 * The feature id for the '<em><b>Validator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_SETTINGS__VALIDATOR = 2;

	/**
	 * The number of structural features of the '<em>Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_SETTINGS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_SETTINGS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.optimization.impl.AbstractIterativeParameterOptimizerImpl <em>Abstract Iterative Parameter Optimizer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.optimization.impl.AbstractIterativeParameterOptimizerImpl
	 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getAbstractIterativeParameterOptimizer()
	 * @generated
	 */
	int ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER = 6;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__TIME_OUT = ICONFIGURATION_OPTIMIZATION_ALGORITHM__TIME_OUT;

	/**
	 * The feature id for the '<em><b>Number Of Splits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_SPLITS = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Number Of Explorations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_EXPLORATIONS = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Iterative Parameter Optimizer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER_FEATURE_COUNT = ICONFIGURATION_OPTIMIZATION_ALGORITHM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Run Optimization</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER___RUN_OPTIMIZATION__INPUTDATA_OPTIMIZATIONSETTINGS_ESTIMATIONSPECIFICATION = ICONFIGURATION_OPTIMIZATION_ALGORITHM___RUN_OPTIMIZATION__INPUTDATA_OPTIMIZATIONSETTINGS_ESTIMATIONSPECIFICATION;

	/**
	 * The operation id for the '<em>Configure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER___CONFIGURE__STRING_EOBJECT = ICONFIGURATION_OPTIMIZATION_ALGORITHM___CONFIGURE__STRING_EOBJECT;

	/**
	 * The operation id for the '<em>Stop</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER___STOP = ICONFIGURATION_OPTIMIZATION_ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abstract Iterative Parameter Optimizer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER_OPERATION_COUNT = ICONFIGURATION_OPTIMIZATION_ALGORITHM_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.optimization.OptimizationConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationConfiguration
	 * @generated
	 */
	EClass getOptimizationConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link tools.descartes.librede.rrde.optimization.OptimizationConfiguration#getContainsOf <em>Contains Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains Of</em>'.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationConfiguration#getContainsOf()
	 * @see #getOptimizationConfiguration()
	 * @generated
	 */
	EReference getOptimizationConfiguration_ContainsOf();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm <em>IConfiguration Optimization Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IConfiguration Optimization Algorithm</em>'.
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm
	 * @generated
	 */
	EClass getIConfigurationOptimizationAlgorithm();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm#getTimeOut <em>Time Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Out</em>'.
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm#getTimeOut()
	 * @see #getIConfigurationOptimizationAlgorithm()
	 * @generated
	 */
	EAttribute getIConfigurationOptimizationAlgorithm_TimeOut();

	/**
	 * Returns the meta object for the '{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm#runOptimization(tools.descartes.librede.rrde.optimization.InputData, tools.descartes.librede.rrde.optimization.OptimizationSettings, tools.descartes.librede.configuration.EstimationSpecification) <em>Run Optimization</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Run Optimization</em>' operation.
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm#runOptimization(tools.descartes.librede.rrde.optimization.InputData, tools.descartes.librede.rrde.optimization.OptimizationSettings, tools.descartes.librede.configuration.EstimationSpecification)
	 * @generated
	 */
	EOperation getIConfigurationOptimizationAlgorithm__RunOptimization__InputData_OptimizationSettings_EstimationSpecification();

	/**
	 * Returns the meta object for the '{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm#configure(java.lang.String, org.eclipse.emf.ecore.EObject) <em>Configure</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Configure</em>' operation.
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm#configure(java.lang.String, org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getIConfigurationOptimizationAlgorithm__Configure__String_EObject();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer <em>Abstract Local Search Optimizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Local Search Optimizer</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer
	 * @generated
	 */
	EClass getAbstractLocalSearchOptimizer();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getMinimum()
	 * @see #getAbstractLocalSearchOptimizer()
	 * @generated
	 */
	EAttribute getAbstractLocalSearchOptimizer_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getMaximum()
	 * @see #getAbstractLocalSearchOptimizer()
	 * @generated
	 */
	EAttribute getAbstractLocalSearchOptimizer_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getTolerance <em>Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tolerance</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getTolerance()
	 * @see #getAbstractLocalSearchOptimizer()
	 * @generated
	 */
	EAttribute getAbstractLocalSearchOptimizer_Tolerance();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getMaximumNumberOfSteps <em>Maximum Number Of Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Steps</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getMaximumNumberOfSteps()
	 * @see #getAbstractLocalSearchOptimizer()
	 * @generated
	 */
	EAttribute getAbstractLocalSearchOptimizer_MaximumNumberOfSteps();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getStartValue()
	 * @see #getAbstractLocalSearchOptimizer()
	 * @generated
	 */
	EAttribute getAbstractLocalSearchOptimizer_StartValue();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer#getStepSize()
	 * @see #getAbstractLocalSearchOptimizer()
	 * @generated
	 */
	EAttribute getAbstractLocalSearchOptimizer_StepSize();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.optimization.RunCall <em>Run Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Call</em>'.
	 * @see tools.descartes.librede.rrde.optimization.RunCall
	 * @generated
	 */
	EClass getRunCall();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.optimization.RunCall#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Algorithm</em>'.
	 * @see tools.descartes.librede.rrde.optimization.RunCall#getAlgorithm()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_Algorithm();

	/**
	 * Returns the meta object for the containment reference list '{@link tools.descartes.librede.rrde.optimization.RunCall#getTrainingData <em>Training Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Training Data</em>'.
	 * @see tools.descartes.librede.rrde.optimization.RunCall#getTrainingData()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_TrainingData();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.optimization.RunCall#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Settings</em>'.
	 * @see tools.descartes.librede.rrde.optimization.RunCall#getSettings()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_Settings();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.optimization.RunCall#getEstimationSpecification <em>Estimation Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Estimation Specification</em>'.
	 * @see tools.descartes.librede.rrde.optimization.RunCall#getEstimationSpecification()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_EstimationSpecification();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.optimization.InputData <em>Input Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Data</em>'.
	 * @see tools.descartes.librede.rrde.optimization.InputData
	 * @generated
	 */
	EClass getInputData();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.InputData#getResultsFile <em>Results File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Results File</em>'.
	 * @see tools.descartes.librede.rrde.optimization.InputData#getResultsFile()
	 * @see #getInputData()
	 * @generated
	 */
	EAttribute getInputData_ResultsFile();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.optimization.OptimizationSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settings</em>'.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationSettings
	 * @generated
	 */
	EClass getOptimizationSettings();

	/**
	 * Returns the meta object for the attribute list '{@link tools.descartes.librede.rrde.optimization.OptimizationSettings#getIgnoreApproaches <em>Ignore Approaches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ignore Approaches</em>'.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationSettings#getIgnoreApproaches()
	 * @see #getOptimizationSettings()
	 * @generated
	 */
	EAttribute getOptimizationSettings_IgnoreApproaches();

	/**
	 * Returns the meta object for the attribute list '{@link tools.descartes.librede.rrde.optimization.OptimizationSettings#getParametersToOptmize <em>Parameters To Optmize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameters To Optmize</em>'.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationSettings#getParametersToOptmize()
	 * @see #getOptimizationSettings()
	 * @generated
	 */
	EAttribute getOptimizationSettings_ParametersToOptmize();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.optimization.OptimizationSettings#getValidator <em>Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Validator</em>'.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationSettings#getValidator()
	 * @see #getOptimizationSettings()
	 * @generated
	 */
	EReference getOptimizationSettings_Validator();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer <em>Abstract Iterative Parameter Optimizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Iterative Parameter Optimizer</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer
	 * @generated
	 */
	EClass getAbstractIterativeParameterOptimizer();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer#getNumberOfSplits <em>Number Of Splits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Splits</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer#getNumberOfSplits()
	 * @see #getAbstractIterativeParameterOptimizer()
	 * @generated
	 */
	EAttribute getAbstractIterativeParameterOptimizer_NumberOfSplits();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer#getNumberOfExplorations <em>Number Of Explorations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Explorations</em>'.
	 * @see tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer#getNumberOfExplorations()
	 * @see #getAbstractIterativeParameterOptimizer()
	 * @generated
	 */
	EAttribute getAbstractIterativeParameterOptimizer_NumberOfExplorations();

	/**
	 * Returns the meta object for the '{@link tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer#stop() <em>Stop</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Stop</em>' operation.
	 * @see tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer#stop()
	 * @generated
	 */
	EOperation getAbstractIterativeParameterOptimizer__Stop();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OptimizationFactory getOptimizationFactory();

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
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.optimization.impl.OptimizationConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationConfigurationImpl
		 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getOptimizationConfiguration()
		 * @generated
		 */
		EClass OPTIMIZATION_CONFIGURATION = eINSTANCE.getOptimizationConfiguration();

		/**
		 * The meta object literal for the '<em><b>Contains Of</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMIZATION_CONFIGURATION__CONTAINS_OF = eINSTANCE.getOptimizationConfiguration_ContainsOf();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm <em>IConfiguration Optimization Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm
		 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getIConfigurationOptimizationAlgorithm()
		 * @generated
		 */
		EClass ICONFIGURATION_OPTIMIZATION_ALGORITHM = eINSTANCE.getIConfigurationOptimizationAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Time Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICONFIGURATION_OPTIMIZATION_ALGORITHM__TIME_OUT = eINSTANCE.getIConfigurationOptimizationAlgorithm_TimeOut();

		/**
		 * The meta object literal for the '<em><b>Run Optimization</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ICONFIGURATION_OPTIMIZATION_ALGORITHM___RUN_OPTIMIZATION__INPUTDATA_OPTIMIZATIONSETTINGS_ESTIMATIONSPECIFICATION = eINSTANCE.getIConfigurationOptimizationAlgorithm__RunOptimization__InputData_OptimizationSettings_EstimationSpecification();

		/**
		 * The meta object literal for the '<em><b>Configure</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ICONFIGURATION_OPTIMIZATION_ALGORITHM___CONFIGURE__STRING_EOBJECT = eINSTANCE.getIConfigurationOptimizationAlgorithm__Configure__String_EObject();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.optimization.impl.AbstractLocalSearchOptimizerImpl <em>Abstract Local Search Optimizer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.optimization.impl.AbstractLocalSearchOptimizerImpl
		 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getAbstractLocalSearchOptimizer()
		 * @generated
		 */
		EClass ABSTRACT_LOCAL_SEARCH_OPTIMIZER = eINSTANCE.getAbstractLocalSearchOptimizer();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MINIMUM = eINSTANCE.getAbstractLocalSearchOptimizer_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM = eINSTANCE.getAbstractLocalSearchOptimizer_Maximum();

		/**
		 * The meta object literal for the '<em><b>Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_LOCAL_SEARCH_OPTIMIZER__TOLERANCE = eINSTANCE.getAbstractLocalSearchOptimizer_Tolerance();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Steps</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM_NUMBER_OF_STEPS = eINSTANCE.getAbstractLocalSearchOptimizer_MaximumNumberOfSteps();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_LOCAL_SEARCH_OPTIMIZER__START_VALUE = eINSTANCE.getAbstractLocalSearchOptimizer_StartValue();

		/**
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_LOCAL_SEARCH_OPTIMIZER__STEP_SIZE = eINSTANCE.getAbstractLocalSearchOptimizer_StepSize();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl <em>Run Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.optimization.impl.RunCallImpl
		 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getRunCall()
		 * @generated
		 */
		EClass RUN_CALL = eINSTANCE.getRunCall();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_CALL__ALGORITHM = eINSTANCE.getRunCall_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Training Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_CALL__TRAINING_DATA = eINSTANCE.getRunCall_TrainingData();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_CALL__SETTINGS = eINSTANCE.getRunCall_Settings();

		/**
		 * The meta object literal for the '<em><b>Estimation Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_CALL__ESTIMATION_SPECIFICATION = eINSTANCE.getRunCall_EstimationSpecification();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.optimization.impl.InputDataImpl <em>Input Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.optimization.impl.InputDataImpl
		 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getInputData()
		 * @generated
		 */
		EClass INPUT_DATA = eINSTANCE.getInputData();

		/**
		 * The meta object literal for the '<em><b>Results File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_DATA__RESULTS_FILE = eINSTANCE.getInputData_ResultsFile();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.optimization.impl.OptimizationSettingsImpl <em>Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationSettingsImpl
		 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getOptimizationSettings()
		 * @generated
		 */
		EClass OPTIMIZATION_SETTINGS = eINSTANCE.getOptimizationSettings();

		/**
		 * The meta object literal for the '<em><b>Ignore Approaches</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIMIZATION_SETTINGS__IGNORE_APPROACHES = eINSTANCE.getOptimizationSettings_IgnoreApproaches();

		/**
		 * The meta object literal for the '<em><b>Parameters To Optmize</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTMIZE = eINSTANCE.getOptimizationSettings_ParametersToOptmize();

		/**
		 * The meta object literal for the '<em><b>Validator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMIZATION_SETTINGS__VALIDATOR = eINSTANCE.getOptimizationSettings_Validator();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.optimization.impl.AbstractIterativeParameterOptimizerImpl <em>Abstract Iterative Parameter Optimizer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.optimization.impl.AbstractIterativeParameterOptimizerImpl
		 * @see tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl#getAbstractIterativeParameterOptimizer()
		 * @generated
		 */
		EClass ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER = eINSTANCE.getAbstractIterativeParameterOptimizer();

		/**
		 * The meta object literal for the '<em><b>Number Of Splits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_SPLITS = eINSTANCE.getAbstractIterativeParameterOptimizer_NumberOfSplits();

		/**
		 * The meta object literal for the '<em><b>Number Of Explorations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_EXPLORATIONS = eINSTANCE.getAbstractIterativeParameterOptimizer_NumberOfExplorations();

		/**
		 * The meta object literal for the '<em><b>Stop</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER___STOP = eINSTANCE.getAbstractIterativeParameterOptimizer__Stop();

	}

} //OptimizationPackage
