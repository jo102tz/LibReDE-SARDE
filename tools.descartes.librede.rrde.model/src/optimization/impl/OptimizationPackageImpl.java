/**
 */
package optimization.impl;

import optimization.HillClimbingSettings;
import optimization.IAlgorithm;
import optimization.InputData;
import optimization.OptimizationConfiguration;
import optimization.OptimizationFactory;
import optimization.OptimizationPackage;
import optimization.RunCall;
import optimization.Settings;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OptimizationPackageImpl extends EPackageImpl implements OptimizationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optimizationConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAlgorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hillClimbingSettingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settingsEClass = null;

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
	 * @see optimization.OptimizationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OptimizationPackageImpl() {
		super(eNS_URI, OptimizationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OptimizationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OptimizationPackage init() {
		if (isInited) return (OptimizationPackage)EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI);

		// Obtain or create and register package
		OptimizationPackageImpl theOptimizationPackage = (OptimizationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OptimizationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OptimizationPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		optimization.optimization.impl.OptimizationPackageImpl theOptimizationPackage_1 = (optimization.optimization.impl.OptimizationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(optimization.optimization.OptimizationPackage.eNS_URI) instanceof optimization.optimization.impl.OptimizationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(optimization.optimization.OptimizationPackage.eNS_URI) : optimization.optimization.OptimizationPackage.eINSTANCE);

		// Create package meta-data objects
		theOptimizationPackage.createPackageContents();
		theOptimizationPackage_1.createPackageContents();

		// Initialize created meta-data
		theOptimizationPackage.initializePackageContents();
		theOptimizationPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOptimizationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OptimizationPackage.eNS_URI, theOptimizationPackage);
		return theOptimizationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptimizationConfiguration() {
		return optimizationConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOptimizationConfiguration_ContainsOf() {
		return (EReference)optimizationConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAlgorithm() {
		return iAlgorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHillClimbingSettings() {
		return hillClimbingSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHillClimbingSettings_Minimum() {
		return (EAttribute)hillClimbingSettingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHillClimbingSettings_Maximum() {
		return (EAttribute)hillClimbingSettingsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHillClimbingSettings_Tolerance() {
		return (EAttribute)hillClimbingSettingsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHillClimbingSettings_MaximumNumberOfSteps() {
		return (EAttribute)hillClimbingSettingsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHillClimbingSettings_StartValue() {
		return (EAttribute)hillClimbingSettingsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHillClimbingSettings_StepSize() {
		return (EAttribute)hillClimbingSettingsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRunCall() {
		return runCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRunCall_Executes() {
		return (EReference)runCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRunCall_ExecutesOn() {
		return (EReference)runCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRunCall_SpecifiedBy() {
		return (EReference)runCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputData() {
		return inputDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputData_Location() {
		return (EAttribute)inputDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSettings() {
		return settingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_TimeOut() {
		return (EAttribute)settingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationFactory getOptimizationFactory() {
		return (OptimizationFactory)getEFactoryInstance();
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
		optimizationConfigurationEClass = createEClass(OPTIMIZATION_CONFIGURATION);
		createEReference(optimizationConfigurationEClass, OPTIMIZATION_CONFIGURATION__CONTAINS_OF);

		iAlgorithmEClass = createEClass(IALGORITHM);

		hillClimbingSettingsEClass = createEClass(HILL_CLIMBING_SETTINGS);
		createEAttribute(hillClimbingSettingsEClass, HILL_CLIMBING_SETTINGS__MINIMUM);
		createEAttribute(hillClimbingSettingsEClass, HILL_CLIMBING_SETTINGS__MAXIMUM);
		createEAttribute(hillClimbingSettingsEClass, HILL_CLIMBING_SETTINGS__TOLERANCE);
		createEAttribute(hillClimbingSettingsEClass, HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS);
		createEAttribute(hillClimbingSettingsEClass, HILL_CLIMBING_SETTINGS__START_VALUE);
		createEAttribute(hillClimbingSettingsEClass, HILL_CLIMBING_SETTINGS__STEP_SIZE);

		runCallEClass = createEClass(RUN_CALL);
		createEReference(runCallEClass, RUN_CALL__EXECUTES);
		createEReference(runCallEClass, RUN_CALL__EXECUTES_ON);
		createEReference(runCallEClass, RUN_CALL__SPECIFIED_BY);

		inputDataEClass = createEClass(INPUT_DATA);
		createEAttribute(inputDataEClass, INPUT_DATA__LOCATION);

		settingsEClass = createEClass(SETTINGS);
		createEAttribute(settingsEClass, SETTINGS__TIME_OUT);
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
		optimization.optimization.OptimizationPackage theOptimizationPackage_1 = (optimization.optimization.OptimizationPackage)EPackage.Registry.INSTANCE.getEPackage(optimization.optimization.OptimizationPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theOptimizationPackage_1);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		hillClimbingSettingsEClass.getESuperTypes().add(this.getSettings());

		// Initialize classes, features, and operations; add parameters
		initEClass(optimizationConfigurationEClass, OptimizationConfiguration.class, "OptimizationConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptimizationConfiguration_ContainsOf(), this.getRunCall(), null, "containsOf", null, 0, -1, OptimizationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iAlgorithmEClass, IAlgorithm.class, "IAlgorithm", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hillClimbingSettingsEClass, HillClimbingSettings.class, "HillClimbingSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHillClimbingSettings_Minimum(), ecorePackage.getEDouble(), "minimum", "0", 0, 1, HillClimbingSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHillClimbingSettings_Maximum(), ecorePackage.getEDouble(), "maximum", "200", 0, 1, HillClimbingSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHillClimbingSettings_Tolerance(), ecorePackage.getEDouble(), "tolerance", "0.05", 0, 1, HillClimbingSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHillClimbingSettings_MaximumNumberOfSteps(), ecorePackage.getELong(), "maximumNumberOfSteps", null, 0, 1, HillClimbingSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHillClimbingSettings_StartValue(), ecorePackage.getEDouble(), "startValue", "60", 0, 1, HillClimbingSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHillClimbingSettings_StepSize(), ecorePackage.getEDouble(), "stepSize", "1", 0, 1, HillClimbingSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runCallEClass, RunCall.class, "RunCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRunCall_Executes(), this.getIAlgorithm(), null, "executes", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_ExecutesOn(), this.getInputData(), null, "executesOn", null, 1, -1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_SpecifiedBy(), this.getSettings(), null, "specifiedBy", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputDataEClass, InputData.class, "InputData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputData_Location(), ecorePackage.getEString(), "location", null, 0, 1, InputData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(settingsEClass, Settings.class, "Settings", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSettings_TimeOut(), ecorePackage.getELong(), "timeOut", "-1", 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OptimizationPackageImpl
