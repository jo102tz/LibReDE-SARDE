/**
 */
package optimization;

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
 * @see optimization.OptimizationFactory
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
	String eNS_PREFIX = "tools.descartes.librede.rrde.optimization";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OptimizationPackage eINSTANCE = optimization.impl.OptimizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link optimization.impl.OptimizationConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimization.impl.OptimizationConfigurationImpl
	 * @see optimization.impl.OptimizationPackageImpl#getOptimizationConfiguration()
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
	 * The meta object id for the '{@link optimization.IAlgorithm <em>IAlgorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimization.IAlgorithm
	 * @see optimization.impl.OptimizationPackageImpl#getIAlgorithm()
	 * @generated
	 */
	int IALGORITHM = 1;

	/**
	 * The number of structural features of the '<em>IAlgorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IALGORITHM_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IAlgorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IALGORITHM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimization.impl.SettingsImpl <em>Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimization.impl.SettingsImpl
	 * @see optimization.impl.OptimizationPackageImpl#getSettings()
	 * @generated
	 */
	int SETTINGS = 5;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__TIME_OUT = 0;

	/**
	 * The number of structural features of the '<em>Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimization.impl.HillClimbingSettingsImpl <em>Hill Climbing Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimization.impl.HillClimbingSettingsImpl
	 * @see optimization.impl.OptimizationPackageImpl#getHillClimbingSettings()
	 * @generated
	 */
	int HILL_CLIMBING_SETTINGS = 2;

	/**
	 * The feature id for the '<em><b>Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_SETTINGS__TIME_OUT = SETTINGS__TIME_OUT;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_SETTINGS__MINIMUM = SETTINGS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_SETTINGS__MAXIMUM = SETTINGS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_SETTINGS__TOLERANCE = SETTINGS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Steps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS = SETTINGS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_SETTINGS__START_VALUE = SETTINGS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_SETTINGS__STEP_SIZE = SETTINGS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Hill Climbing Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_SETTINGS_FEATURE_COUNT = SETTINGS_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Hill Climbing Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_SETTINGS_OPERATION_COUNT = SETTINGS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link optimization.impl.RunCallImpl <em>Run Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimization.impl.RunCallImpl
	 * @see optimization.impl.OptimizationPackageImpl#getRunCall()
	 * @generated
	 */
	int RUN_CALL = 3;

	/**
	 * The feature id for the '<em><b>Executes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL__EXECUTES = 0;

	/**
	 * The feature id for the '<em><b>Executes On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL__EXECUTES_ON = 1;

	/**
	 * The feature id for the '<em><b>Specified By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL__SPECIFIED_BY = 2;

	/**
	 * The number of structural features of the '<em>Run Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Run Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_CALL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimization.impl.InputDataImpl <em>Input Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimization.impl.InputDataImpl
	 * @see optimization.impl.OptimizationPackageImpl#getInputData()
	 * @generated
	 */
	int INPUT_DATA = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA__LOCATION = 0;

	/**
	 * The number of structural features of the '<em>Input Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Input Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link optimization.OptimizationConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see optimization.OptimizationConfiguration
	 * @generated
	 */
	EClass getOptimizationConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link optimization.OptimizationConfiguration#getContainsOf <em>Contains Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains Of</em>'.
	 * @see optimization.OptimizationConfiguration#getContainsOf()
	 * @see #getOptimizationConfiguration()
	 * @generated
	 */
	EReference getOptimizationConfiguration_ContainsOf();

	/**
	 * Returns the meta object for class '{@link optimization.IAlgorithm <em>IAlgorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IAlgorithm</em>'.
	 * @see optimization.IAlgorithm
	 * @generated
	 */
	EClass getIAlgorithm();

	/**
	 * Returns the meta object for class '{@link optimization.HillClimbingSettings <em>Hill Climbing Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hill Climbing Settings</em>'.
	 * @see optimization.HillClimbingSettings
	 * @generated
	 */
	EClass getHillClimbingSettings();

	/**
	 * Returns the meta object for the attribute '{@link optimization.HillClimbingSettings#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see optimization.HillClimbingSettings#getMinimum()
	 * @see #getHillClimbingSettings()
	 * @generated
	 */
	EAttribute getHillClimbingSettings_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link optimization.HillClimbingSettings#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see optimization.HillClimbingSettings#getMaximum()
	 * @see #getHillClimbingSettings()
	 * @generated
	 */
	EAttribute getHillClimbingSettings_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link optimization.HillClimbingSettings#getTolerance <em>Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tolerance</em>'.
	 * @see optimization.HillClimbingSettings#getTolerance()
	 * @see #getHillClimbingSettings()
	 * @generated
	 */
	EAttribute getHillClimbingSettings_Tolerance();

	/**
	 * Returns the meta object for the attribute '{@link optimization.HillClimbingSettings#getMaximumNumberOfSteps <em>Maximum Number Of Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Steps</em>'.
	 * @see optimization.HillClimbingSettings#getMaximumNumberOfSteps()
	 * @see #getHillClimbingSettings()
	 * @generated
	 */
	EAttribute getHillClimbingSettings_MaximumNumberOfSteps();

	/**
	 * Returns the meta object for the attribute '{@link optimization.HillClimbingSettings#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see optimization.HillClimbingSettings#getStartValue()
	 * @see #getHillClimbingSettings()
	 * @generated
	 */
	EAttribute getHillClimbingSettings_StartValue();

	/**
	 * Returns the meta object for the attribute '{@link optimization.HillClimbingSettings#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see optimization.HillClimbingSettings#getStepSize()
	 * @see #getHillClimbingSettings()
	 * @generated
	 */
	EAttribute getHillClimbingSettings_StepSize();

	/**
	 * Returns the meta object for class '{@link optimization.RunCall <em>Run Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Call</em>'.
	 * @see optimization.RunCall
	 * @generated
	 */
	EClass getRunCall();

	/**
	 * Returns the meta object for the reference '{@link optimization.RunCall#getExecutes <em>Executes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executes</em>'.
	 * @see optimization.RunCall#getExecutes()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_Executes();

	/**
	 * Returns the meta object for the reference list '{@link optimization.RunCall#getExecutesOn <em>Executes On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Executes On</em>'.
	 * @see optimization.RunCall#getExecutesOn()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_ExecutesOn();

	/**
	 * Returns the meta object for the reference '{@link optimization.RunCall#getSpecifiedBy <em>Specified By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specified By</em>'.
	 * @see optimization.RunCall#getSpecifiedBy()
	 * @see #getRunCall()
	 * @generated
	 */
	EReference getRunCall_SpecifiedBy();

	/**
	 * Returns the meta object for class '{@link optimization.InputData <em>Input Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Data</em>'.
	 * @see optimization.InputData
	 * @generated
	 */
	EClass getInputData();

	/**
	 * Returns the meta object for the attribute '{@link optimization.InputData#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see optimization.InputData#getLocation()
	 * @see #getInputData()
	 * @generated
	 */
	EAttribute getInputData_Location();

	/**
	 * Returns the meta object for class '{@link optimization.Settings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settings</em>'.
	 * @see optimization.Settings
	 * @generated
	 */
	EClass getSettings();

	/**
	 * Returns the meta object for the attribute '{@link optimization.Settings#getTimeOut <em>Time Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Out</em>'.
	 * @see optimization.Settings#getTimeOut()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_TimeOut();

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
		 * The meta object literal for the '{@link optimization.impl.OptimizationConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimization.impl.OptimizationConfigurationImpl
		 * @see optimization.impl.OptimizationPackageImpl#getOptimizationConfiguration()
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
		 * The meta object literal for the '{@link optimization.IAlgorithm <em>IAlgorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimization.IAlgorithm
		 * @see optimization.impl.OptimizationPackageImpl#getIAlgorithm()
		 * @generated
		 */
		EClass IALGORITHM = eINSTANCE.getIAlgorithm();

		/**
		 * The meta object literal for the '{@link optimization.impl.HillClimbingSettingsImpl <em>Hill Climbing Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimization.impl.HillClimbingSettingsImpl
		 * @see optimization.impl.OptimizationPackageImpl#getHillClimbingSettings()
		 * @generated
		 */
		EClass HILL_CLIMBING_SETTINGS = eINSTANCE.getHillClimbingSettings();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HILL_CLIMBING_SETTINGS__MINIMUM = eINSTANCE.getHillClimbingSettings_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HILL_CLIMBING_SETTINGS__MAXIMUM = eINSTANCE.getHillClimbingSettings_Maximum();

		/**
		 * The meta object literal for the '<em><b>Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HILL_CLIMBING_SETTINGS__TOLERANCE = eINSTANCE.getHillClimbingSettings_Tolerance();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Steps</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS = eINSTANCE.getHillClimbingSettings_MaximumNumberOfSteps();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HILL_CLIMBING_SETTINGS__START_VALUE = eINSTANCE.getHillClimbingSettings_StartValue();

		/**
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HILL_CLIMBING_SETTINGS__STEP_SIZE = eINSTANCE.getHillClimbingSettings_StepSize();

		/**
		 * The meta object literal for the '{@link optimization.impl.RunCallImpl <em>Run Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimization.impl.RunCallImpl
		 * @see optimization.impl.OptimizationPackageImpl#getRunCall()
		 * @generated
		 */
		EClass RUN_CALL = eINSTANCE.getRunCall();

		/**
		 * The meta object literal for the '<em><b>Executes</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_CALL__EXECUTES = eINSTANCE.getRunCall_Executes();

		/**
		 * The meta object literal for the '<em><b>Executes On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_CALL__EXECUTES_ON = eINSTANCE.getRunCall_ExecutesOn();

		/**
		 * The meta object literal for the '<em><b>Specified By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_CALL__SPECIFIED_BY = eINSTANCE.getRunCall_SpecifiedBy();

		/**
		 * The meta object literal for the '{@link optimization.impl.InputDataImpl <em>Input Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimization.impl.InputDataImpl
		 * @see optimization.impl.OptimizationPackageImpl#getInputData()
		 * @generated
		 */
		EClass INPUT_DATA = eINSTANCE.getInputData();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_DATA__LOCATION = eINSTANCE.getInputData_Location();

		/**
		 * The meta object literal for the '{@link optimization.impl.SettingsImpl <em>Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimization.impl.SettingsImpl
		 * @see optimization.impl.OptimizationPackageImpl#getSettings()
		 * @generated
		 */
		EClass SETTINGS = eINSTANCE.getSettings();

		/**
		 * The meta object literal for the '<em><b>Time Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__TIME_OUT = eINSTANCE.getSettings_TimeOut();

	}

} //OptimizationPackage
