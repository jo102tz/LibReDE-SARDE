/**
 */
package tools.descartes.librede.rrde.model.optimization;

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
 * @see tools.descartes.librede.rrde.model.optimization.OptimizationFactory
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
	OptimizationPackage eINSTANCE = tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.OptimizationConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationConfigurationImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getOptimizationConfiguration()
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
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.ConfigurationOptimizationAlgorithmSpecifierImpl <em>Configuration Optimization Algorithm Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.ConfigurationOptimizationAlgorithmSpecifierImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getConfigurationOptimizationAlgorithmSpecifier()
	 * @generated
	 */
	int CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER = 1;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME = 1;

	/**
	 * The number of structural features of the '<em>Configuration Optimization Algorithm Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Configuration Optimization Algorithm Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.LocalSearchSpecifierImpl <em>Local Search Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.LocalSearchSpecifierImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getLocalSearchSpecifier()
	 * @generated
	 */
	int LOCAL_SEARCH_SPECIFIER = 2;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_SPECIFIER__TIME_OUT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT;

	/**
	 * The feature id for the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_SPECIFIER__ALGORITHM_NAME = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME;

	/**
	 * The feature id for the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_SPECIFIER__TOLERANCE = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Steps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_SPECIFIER__STEP_SIZE = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Local Search Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_SPECIFIER_FEATURE_COUNT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Local Search Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_SPECIFIER_OPERATION_COUNT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.RunCallImpl <em>Run Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.RunCallImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getRunCall()
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
	 * The feature id for the '<em><b>Estimation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL__ESTIMATION = 3;

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
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.InputDataImpl <em>Input Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.InputDataImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getInputData()
	 * @generated
	 */
	int INPUT_DATA = 4;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA__INPUT = 0;

	/**
	 * The feature id for the '<em><b>Workload Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA__WORKLOAD_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Root Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA__ROOT_FOLDER = 2;

	/**
	 * The feature id for the '<em><b>Multi Folder Structures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA__MULTI_FOLDER_STRUCTURES = 3;

	/**
	 * The number of structural features of the '<em>Input Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Input Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.OptimizationSettingsImpl <em>Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationSettingsImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getOptimizationSettings()
	 * @generated
	 */
	int OPTIMIZATION_SETTINGS = 5;

	/**
	 * The feature id for the '<em><b>Validator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_SETTINGS__VALIDATOR = 0;

	/**
	 * The feature id for the '<em><b>Parameters To Optimize</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE = 1;

	/**
	 * The number of structural features of the '<em>Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_SETTINGS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_SETTINGS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.IterativeParameterOptimizerSpecifierImpl <em>Iterative Parameter Optimizer Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.IterativeParameterOptimizerSpecifierImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getIterativeParameterOptimizerSpecifier()
	 * @generated
	 */
	int ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER = 6;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__TIME_OUT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT;

	/**
	 * The feature id for the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__ALGORITHM_NAME = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME;

	/**
	 * The feature id for the '<em><b>Number Of Splits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Number Of Explorations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Number Of Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Iterative Parameter Optimizer Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER_FEATURE_COUNT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Iterative Parameter Optimizer Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER_OPERATION_COUNT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.IOptimizableParameter <em>IOptimizable Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.IOptimizableParameter
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getIOptimizableParameter()
	 * @generated
	 */
	int IOPTIMIZABLE_PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOPTIMIZABLE_PARAMETER__LOWER_BOUND = 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOPTIMIZABLE_PARAMETER__UPPER_BOUND = 1;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOPTIMIZABLE_PARAMETER__START_VALUE = 2;

	/**
	 * The number of structural features of the '<em>IOptimizable Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOPTIMIZABLE_PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>IOptimizable Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOPTIMIZABLE_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.GenericParameterImpl <em>Generic Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.GenericParameterImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getGenericParameter()
	 * @generated
	 */
	int GENERIC_PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PARAMETER__LOWER_BOUND = IOPTIMIZABLE_PARAMETER__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PARAMETER__UPPER_BOUND = IOPTIMIZABLE_PARAMETER__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PARAMETER__START_VALUE = IOPTIMIZABLE_PARAMETER__START_VALUE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PARAMETER__PARAMETER = IOPTIMIZABLE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Generic Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PARAMETER_FEATURE_COUNT = IOPTIMIZABLE_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Generic Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PARAMETER_OPERATION_COUNT = IOPTIMIZABLE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.StepSizeImpl <em>Step Size</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.StepSizeImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getStepSize()
	 * @generated
	 */
	int STEP_SIZE = 9;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE__LOWER_BOUND = IOPTIMIZABLE_PARAMETER__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE__UPPER_BOUND = IOPTIMIZABLE_PARAMETER__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE__START_VALUE = IOPTIMIZABLE_PARAMETER__START_VALUE;

	/**
	 * The number of structural features of the '<em>Step Size</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE_FEATURE_COUNT = IOPTIMIZABLE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Step Size</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE_OPERATION_COUNT = IOPTIMIZABLE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.WindowSizeImpl <em>Window Size</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.WindowSizeImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getWindowSize()
	 * @generated
	 */
	int WINDOW_SIZE = 10;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_SIZE__LOWER_BOUND = IOPTIMIZABLE_PARAMETER__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_SIZE__UPPER_BOUND = IOPTIMIZABLE_PARAMETER__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_SIZE__START_VALUE = IOPTIMIZABLE_PARAMETER__START_VALUE;

	/**
	 * The number of structural features of the '<em>Window Size</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_SIZE_FEATURE_COUNT = IOPTIMIZABLE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Window Size</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_SIZE_OPERATION_COUNT = IOPTIMIZABLE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.DataExportSpecifierImpl <em>Data Export Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.DataExportSpecifierImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getDataExportSpecifier()
	 * @generated
	 */
	int DATA_EXPORT_SPECIFIER = 11;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EXPORT_SPECIFIER__TIME_OUT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT;

	/**
	 * The feature id for the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EXPORT_SPECIFIER__ALGORITHM_NAME = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME;

	/**
	 * The feature id for the '<em><b>Output Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EXPORT_SPECIFIER__STEP_SIZE = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multidimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Split Configurations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Data Export Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EXPORT_SPECIFIER_FEATURE_COUNT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Data Export Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EXPORT_SPECIFIER_OPERATION_COUNT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.StepSizeRelWindowImpl <em>Step Size Rel Window</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.StepSizeRelWindowImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getStepSizeRelWindow()
	 * @generated
	 */
	int STEP_SIZE_REL_WINDOW = 12;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE_REL_WINDOW__LOWER_BOUND = STEP_SIZE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE_REL_WINDOW__UPPER_BOUND = STEP_SIZE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE_REL_WINDOW__START_VALUE = STEP_SIZE__START_VALUE;

	/**
	 * The feature id for the '<em><b>Product Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE_REL_WINDOW__PRODUCT_MAX_VALUE = STEP_SIZE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Step Size Rel Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE_REL_WINDOW_FEATURE_COUNT = STEP_SIZE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Step Size Rel Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_SIZE_REL_WINDOW_OPERATION_COUNT = STEP_SIZE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.model.optimization.impl.ClusterOptimizationSpecifierImpl <em>Cluster Optimization Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.model.optimization.impl.ClusterOptimizationSpecifierImpl
	 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getClusterOptimizationSpecifier()
	 * @generated
	 */
	int CLUSTER_OPTIMIZATION_SPECIFIER = 13;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_OPTIMIZATION_SPECIFIER__TIME_OUT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT;

	/**
	 * The feature id for the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_OPTIMIZATION_SPECIFIER__ALGORITHM_NAME = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME;

	/**
	 * The feature id for the '<em><b>Cluster Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_OPTIMIZATION_SPECIFIER__CLUSTER_ALGORITHM = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_OPTIMIZATION_SPECIFIER__SUB_ALGORITHM = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cluster Optimization Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_OPTIMIZATION_SPECIFIER_FEATURE_COUNT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cluster Optimization Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_OPTIMIZATION_SPECIFIER_OPERATION_COUNT = CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration
	 * @generated
	 */
	EClass getOptimizationConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration#getContainsOf <em>Contains Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains Of</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration#getContainsOf()
	 * @see #getOptimizationConfiguration()
	 * @generated
	 */
	EReference getOptimizationConfiguration_ContainsOf();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier <em>Configuration Optimization Algorithm Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Optimization Algorithm Specifier</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier
	 * @generated
	 */
	EClass getConfigurationOptimizationAlgorithmSpecifier();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier#getTimeOut <em>Time Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Out</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier#getTimeOut()
	 * @see #getConfigurationOptimizationAlgorithmSpecifier()
	 * @generated
	 */
	EAttribute getConfigurationOptimizationAlgorithmSpecifier_TimeOut();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier#getAlgorithmName <em>Algorithm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm Name</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier#getAlgorithmName()
	 * @see #getConfigurationOptimizationAlgorithmSpecifier()
	 * @generated
	 */
	EAttribute getConfigurationOptimizationAlgorithmSpecifier_AlgorithmName();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier <em>Local Search Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Search Specifier</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier
	 * @generated
	 */
	EClass getLocalSearchSpecifier();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier#getTolerance <em>Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tolerance</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier#getTolerance()
	 * @see #getLocalSearchSpecifier()
	 * @generated
	 */
	EAttribute getLocalSearchSpecifier_Tolerance();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier#getMaximumNumberOfSteps <em>Maximum Number Of Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Steps</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier#getMaximumNumberOfSteps()
	 * @see #getLocalSearchSpecifier()
	 * @generated
	 */
	EAttribute getLocalSearchSpecifier_MaximumNumberOfSteps();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier#getStepSize()
	 * @see #getLocalSearchSpecifier()
	 * @generated
	 */
	EAttribute getLocalSearchSpecifier_StepSize();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.RunCall <em>Run Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Call</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.RunCall
	 * @generated
	 */
	EClass getRunCall();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.model.optimization.RunCall#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Algorithm</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.RunCall#getAlgorithm()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_Algorithm();

	/**
	 * Returns the meta object for the containment reference list '{@link tools.descartes.librede.rrde.model.optimization.RunCall#getTrainingData <em>Training Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Training Data</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.RunCall#getTrainingData()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_TrainingData();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.model.optimization.RunCall#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Settings</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.RunCall#getSettings()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_Settings();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.model.optimization.RunCall#getEstimation <em>Estimation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Estimation</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.RunCall#getEstimation()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_Estimation();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.InputData <em>Input Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Data</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.InputData
	 * @generated
	 */
	EClass getInputData();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.model.optimization.InputData#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.InputData#getInput()
	 * @see #getInputData()
	 * @generated
	 */
	EReference getInputData_Input();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.model.optimization.InputData#getWorkloadDescription <em>Workload Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Workload Description</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.InputData#getWorkloadDescription()
	 * @see #getInputData()
	 * @generated
	 */
	EReference getInputData_WorkloadDescription();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.InputData#getRootFolder <em>Root Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root Folder</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.InputData#getRootFolder()
	 * @see #getInputData()
	 * @generated
	 */
	EAttribute getInputData_RootFolder();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.InputData#isMultiFolderStructures <em>Multi Folder Structures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Folder Structures</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.InputData#isMultiFolderStructures()
	 * @see #getInputData()
	 * @generated
	 */
	EAttribute getInputData_MultiFolderStructures();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.OptimizationSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settings</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationSettings
	 * @generated
	 */
	EClass getOptimizationSettings();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.model.optimization.OptimizationSettings#getValidator <em>Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Validator</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationSettings#getValidator()
	 * @see #getOptimizationSettings()
	 * @generated
	 */
	EReference getOptimizationSettings_Validator();

	/**
	 * Returns the meta object for the containment reference list '{@link tools.descartes.librede.rrde.model.optimization.OptimizationSettings#getParametersToOptimize <em>Parameters To Optimize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters To Optimize</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationSettings#getParametersToOptimize()
	 * @see #getOptimizationSettings()
	 * @generated
	 */
	EReference getOptimizationSettings_ParametersToOptimize();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier <em>Iterative Parameter Optimizer Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterative Parameter Optimizer Specifier</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier
	 * @generated
	 */
	EClass getIterativeParameterOptimizerSpecifier();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfSplits <em>Number Of Splits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Splits</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfSplits()
	 * @see #getIterativeParameterOptimizerSpecifier()
	 * @generated
	 */
	EAttribute getIterativeParameterOptimizerSpecifier_NumberOfSplits();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfExplorations <em>Number Of Explorations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Explorations</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfExplorations()
	 * @see #getIterativeParameterOptimizerSpecifier()
	 * @generated
	 */
	EAttribute getIterativeParameterOptimizerSpecifier_NumberOfExplorations();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfIterations <em>Number Of Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Iterations</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfIterations()
	 * @see #getIterativeParameterOptimizerSpecifier()
	 * @generated
	 */
	EAttribute getIterativeParameterOptimizerSpecifier_NumberOfIterations();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.IOptimizableParameter <em>IOptimizable Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IOptimizable Parameter</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.IOptimizableParameter
	 * @generated
	 */
	EClass getIOptimizableParameter();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.IOptimizableParameter#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.IOptimizableParameter#getLowerBound()
	 * @see #getIOptimizableParameter()
	 * @generated
	 */
	EAttribute getIOptimizableParameter_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.IOptimizableParameter#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.IOptimizableParameter#getUpperBound()
	 * @see #getIOptimizableParameter()
	 * @generated
	 */
	EAttribute getIOptimizableParameter_UpperBound();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.IOptimizableParameter#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.IOptimizableParameter#getStartValue()
	 * @see #getIOptimizableParameter()
	 * @generated
	 */
	EAttribute getIOptimizableParameter_StartValue();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.GenericParameter <em>Generic Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Parameter</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.GenericParameter
	 * @generated
	 */
	EClass getGenericParameter();

	/**
	 * Returns the meta object for the reference '{@link tools.descartes.librede.rrde.model.optimization.GenericParameter#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.GenericParameter#getParameter()
	 * @see #getGenericParameter()
	 * @generated
	 */
	EReference getGenericParameter_Parameter();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.StepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Size</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.StepSize
	 * @generated
	 */
	EClass getStepSize();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.WindowSize <em>Window Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Window Size</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.WindowSize
	 * @generated
	 */
	EClass getWindowSize();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.DataExportSpecifier <em>Data Export Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Export Specifier</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.DataExportSpecifier
	 * @generated
	 */
	EClass getDataExportSpecifier();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.DataExportSpecifier#getOutputDirectory <em>Output Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Directory</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.DataExportSpecifier#getOutputDirectory()
	 * @see #getDataExportSpecifier()
	 * @generated
	 */
	EAttribute getDataExportSpecifier_OutputDirectory();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.DataExportSpecifier#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.DataExportSpecifier#getStepSize()
	 * @see #getDataExportSpecifier()
	 * @generated
	 */
	EAttribute getDataExportSpecifier_StepSize();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.DataExportSpecifier#isMultidimensional <em>Multidimensional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multidimensional</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.DataExportSpecifier#isMultidimensional()
	 * @see #getDataExportSpecifier()
	 * @generated
	 */
	EAttribute getDataExportSpecifier_Multidimensional();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.DataExportSpecifier#isSplitConfigurations <em>Split Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Split Configurations</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.DataExportSpecifier#isSplitConfigurations()
	 * @see #getDataExportSpecifier()
	 * @generated
	 */
	EAttribute getDataExportSpecifier_SplitConfigurations();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow <em>Step Size Rel Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Size Rel Window</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow
	 * @generated
	 */
	EClass getStepSizeRelWindow();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow#getProductMaxValue <em>Product Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Max Value</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow#getProductMaxValue()
	 * @see #getStepSizeRelWindow()
	 * @generated
	 */
	EAttribute getStepSizeRelWindow_ProductMaxValue();

	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier <em>Cluster Optimization Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cluster Optimization Specifier</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier
	 * @generated
	 */
	EClass getClusterOptimizationSpecifier();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier#getClusterAlgorithm <em>Cluster Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cluster Algorithm</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier#getClusterAlgorithm()
	 * @see #getClusterOptimizationSpecifier()
	 * @generated
	 */
	EAttribute getClusterOptimizationSpecifier_ClusterAlgorithm();

	/**
	 * Returns the meta object for the reference '{@link tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier#getSubAlgorithm <em>Sub Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub Algorithm</em>'.
	 * @see tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier#getSubAlgorithm()
	 * @see #getClusterOptimizationSpecifier()
	 * @generated
	 */
	EReference getClusterOptimizationSpecifier_SubAlgorithm();

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
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.OptimizationConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationConfigurationImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getOptimizationConfiguration()
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
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.ConfigurationOptimizationAlgorithmSpecifierImpl <em>Configuration Optimization Algorithm Specifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.ConfigurationOptimizationAlgorithmSpecifierImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getConfigurationOptimizationAlgorithmSpecifier()
		 * @generated
		 */
		EClass CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER = eINSTANCE.getConfigurationOptimizationAlgorithmSpecifier();

		/**
		 * The meta object literal for the '<em><b>Time Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT = eINSTANCE.getConfigurationOptimizationAlgorithmSpecifier_TimeOut();

		/**
		 * The meta object literal for the '<em><b>Algorithm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME = eINSTANCE.getConfigurationOptimizationAlgorithmSpecifier_AlgorithmName();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.LocalSearchSpecifierImpl <em>Local Search Specifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.LocalSearchSpecifierImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getLocalSearchSpecifier()
		 * @generated
		 */
		EClass LOCAL_SEARCH_SPECIFIER = eINSTANCE.getLocalSearchSpecifier();

		/**
		 * The meta object literal for the '<em><b>Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH_SPECIFIER__TOLERANCE = eINSTANCE.getLocalSearchSpecifier_Tolerance();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Steps</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS = eINSTANCE.getLocalSearchSpecifier_MaximumNumberOfSteps();

		/**
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH_SPECIFIER__STEP_SIZE = eINSTANCE.getLocalSearchSpecifier_StepSize();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.RunCallImpl <em>Run Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.RunCallImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getRunCall()
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
		 * The meta object literal for the '<em><b>Estimation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_CALL__ESTIMATION = eINSTANCE.getRunCall_Estimation();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.InputDataImpl <em>Input Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.InputDataImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getInputData()
		 * @generated
		 */
		EClass INPUT_DATA = eINSTANCE.getInputData();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_DATA__INPUT = eINSTANCE.getInputData_Input();

		/**
		 * The meta object literal for the '<em><b>Workload Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_DATA__WORKLOAD_DESCRIPTION = eINSTANCE.getInputData_WorkloadDescription();

		/**
		 * The meta object literal for the '<em><b>Root Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_DATA__ROOT_FOLDER = eINSTANCE.getInputData_RootFolder();

		/**
		 * The meta object literal for the '<em><b>Multi Folder Structures</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_DATA__MULTI_FOLDER_STRUCTURES = eINSTANCE.getInputData_MultiFolderStructures();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.OptimizationSettingsImpl <em>Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationSettingsImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getOptimizationSettings()
		 * @generated
		 */
		EClass OPTIMIZATION_SETTINGS = eINSTANCE.getOptimizationSettings();

		/**
		 * The meta object literal for the '<em><b>Validator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMIZATION_SETTINGS__VALIDATOR = eINSTANCE.getOptimizationSettings_Validator();

		/**
		 * The meta object literal for the '<em><b>Parameters To Optimize</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE = eINSTANCE.getOptimizationSettings_ParametersToOptimize();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.IterativeParameterOptimizerSpecifierImpl <em>Iterative Parameter Optimizer Specifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.IterativeParameterOptimizerSpecifierImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getIterativeParameterOptimizerSpecifier()
		 * @generated
		 */
		EClass ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER = eINSTANCE.getIterativeParameterOptimizerSpecifier();

		/**
		 * The meta object literal for the '<em><b>Number Of Splits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS = eINSTANCE.getIterativeParameterOptimizerSpecifier_NumberOfSplits();

		/**
		 * The meta object literal for the '<em><b>Number Of Explorations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS = eINSTANCE.getIterativeParameterOptimizerSpecifier_NumberOfExplorations();

		/**
		 * The meta object literal for the '<em><b>Number Of Iterations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS = eINSTANCE.getIterativeParameterOptimizerSpecifier_NumberOfIterations();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.IOptimizableParameter <em>IOptimizable Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.IOptimizableParameter
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getIOptimizableParameter()
		 * @generated
		 */
		EClass IOPTIMIZABLE_PARAMETER = eINSTANCE.getIOptimizableParameter();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IOPTIMIZABLE_PARAMETER__LOWER_BOUND = eINSTANCE.getIOptimizableParameter_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IOPTIMIZABLE_PARAMETER__UPPER_BOUND = eINSTANCE.getIOptimizableParameter_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IOPTIMIZABLE_PARAMETER__START_VALUE = eINSTANCE.getIOptimizableParameter_StartValue();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.GenericParameterImpl <em>Generic Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.GenericParameterImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getGenericParameter()
		 * @generated
		 */
		EClass GENERIC_PARAMETER = eINSTANCE.getGenericParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_PARAMETER__PARAMETER = eINSTANCE.getGenericParameter_Parameter();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.StepSizeImpl <em>Step Size</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.StepSizeImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getStepSize()
		 * @generated
		 */
		EClass STEP_SIZE = eINSTANCE.getStepSize();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.WindowSizeImpl <em>Window Size</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.WindowSizeImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getWindowSize()
		 * @generated
		 */
		EClass WINDOW_SIZE = eINSTANCE.getWindowSize();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.DataExportSpecifierImpl <em>Data Export Specifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.DataExportSpecifierImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getDataExportSpecifier()
		 * @generated
		 */
		EClass DATA_EXPORT_SPECIFIER = eINSTANCE.getDataExportSpecifier();

		/**
		 * The meta object literal for the '<em><b>Output Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY = eINSTANCE.getDataExportSpecifier_OutputDirectory();

		/**
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_EXPORT_SPECIFIER__STEP_SIZE = eINSTANCE.getDataExportSpecifier_StepSize();

		/**
		 * The meta object literal for the '<em><b>Multidimensional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL = eINSTANCE.getDataExportSpecifier_Multidimensional();

		/**
		 * The meta object literal for the '<em><b>Split Configurations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS = eINSTANCE.getDataExportSpecifier_SplitConfigurations();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.StepSizeRelWindowImpl <em>Step Size Rel Window</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.StepSizeRelWindowImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getStepSizeRelWindow()
		 * @generated
		 */
		EClass STEP_SIZE_REL_WINDOW = eINSTANCE.getStepSizeRelWindow();

		/**
		 * The meta object literal for the '<em><b>Product Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP_SIZE_REL_WINDOW__PRODUCT_MAX_VALUE = eINSTANCE.getStepSizeRelWindow_ProductMaxValue();

		/**
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.model.optimization.impl.ClusterOptimizationSpecifierImpl <em>Cluster Optimization Specifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.model.optimization.impl.ClusterOptimizationSpecifierImpl
		 * @see tools.descartes.librede.rrde.model.optimization.impl.OptimizationPackageImpl#getClusterOptimizationSpecifier()
		 * @generated
		 */
		EClass CLUSTER_OPTIMIZATION_SPECIFIER = eINSTANCE.getClusterOptimizationSpecifier();

		/**
		 * The meta object literal for the '<em><b>Cluster Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLUSTER_OPTIMIZATION_SPECIFIER__CLUSTER_ALGORITHM = eINSTANCE.getClusterOptimizationSpecifier_ClusterAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Sub Algorithm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER_OPTIMIZATION_SPECIFIER__SUB_ALGORITHM = eINSTANCE.getClusterOptimizationSpecifier_SubAlgorithm();

	}

} //OptimizationPackage
