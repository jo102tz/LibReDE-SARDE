/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import tools.descartes.librede.configuration.ConfigurationPackage;

import tools.descartes.librede.metrics.MetricsPackage;

import tools.descartes.librede.rrde.optimization.GenericParameter;
import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.StepSize;
import tools.descartes.librede.rrde.optimization.WindowSize;

import tools.descartes.librede.units.UnitsPackage;

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
	private EClass iConfigurationOptimizationAlgorithmSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localSearchSpecifierEClass = null;

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
	private EClass optimizationSettingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterativeParameterOptimizerSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iOptimizableParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepSizeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowSizeEClass = null;

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
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#eNS_URI
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

		// Initialize simple dependencies
		ConfigurationPackage.eINSTANCE.eClass();
		MetricsPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOptimizationPackage.createPackageContents();

		// Initialize created meta-data
		theOptimizationPackage.initializePackageContents();

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
	public EClass getIConfigurationOptimizationAlgorithmSpecifier() {
		return iConfigurationOptimizationAlgorithmSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConfigurationOptimizationAlgorithmSpecifier_TimeOut() {
		return (EAttribute)iConfigurationOptimizationAlgorithmSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalSearchSpecifier() {
		return localSearchSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalSearchSpecifier_Tolerance() {
		return (EAttribute)localSearchSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalSearchSpecifier_MaximumNumberOfSteps() {
		return (EAttribute)localSearchSpecifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalSearchSpecifier_StepSize() {
		return (EAttribute)localSearchSpecifierEClass.getEStructuralFeatures().get(2);
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
	public EReference getRunCall_Algorithm() {
		return (EReference)runCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRunCall_TrainingData() {
		return (EReference)runCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRunCall_Settings() {
		return (EReference)runCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRunCall_EstimationSpecification() {
		return (EReference)runCallEClass.getEStructuralFeatures().get(3);
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
	public EReference getInputData_InputSpecification() {
		return (EReference)inputDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputData_Description() {
		return (EReference)inputDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputData_RootFolder() {
		return (EAttribute)inputDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptimizationSettings() {
		return optimizationSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOptimizationSettings_IgnoreApproaches() {
		return (EAttribute)optimizationSettingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOptimizationSettings_Validator() {
		return (EReference)optimizationSettingsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOptimizationSettings_ParametersToOptimize() {
		return (EReference)optimizationSettingsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterativeParameterOptimizerSpecifier() {
		return iterativeParameterOptimizerSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterativeParameterOptimizerSpecifier_NumberOfSplits() {
		return (EAttribute)iterativeParameterOptimizerSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterativeParameterOptimizerSpecifier_NumberOfExplorations() {
		return (EAttribute)iterativeParameterOptimizerSpecifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIterativeParameterOptimizerSpecifier__Stop() {
		return iterativeParameterOptimizerSpecifierEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIOptimizableParameter() {
		return iOptimizableParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOptimizableParameter_LowerBound() {
		return (EAttribute)iOptimizableParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOptimizableParameter_UpperBound() {
		return (EAttribute)iOptimizableParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOptimizableParameter_StartValue() {
		return (EAttribute)iOptimizableParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericParameter() {
		return genericParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericParameter_Key() {
		return (EAttribute)genericParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStepSize() {
		return stepSizeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowSize() {
		return windowSizeEClass;
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

		iConfigurationOptimizationAlgorithmSpecifierEClass = createEClass(ICONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER);
		createEAttribute(iConfigurationOptimizationAlgorithmSpecifierEClass, ICONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT);

		localSearchSpecifierEClass = createEClass(LOCAL_SEARCH_SPECIFIER);
		createEAttribute(localSearchSpecifierEClass, LOCAL_SEARCH_SPECIFIER__TOLERANCE);
		createEAttribute(localSearchSpecifierEClass, LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS);
		createEAttribute(localSearchSpecifierEClass, LOCAL_SEARCH_SPECIFIER__STEP_SIZE);

		runCallEClass = createEClass(RUN_CALL);
		createEReference(runCallEClass, RUN_CALL__ALGORITHM);
		createEReference(runCallEClass, RUN_CALL__TRAINING_DATA);
		createEReference(runCallEClass, RUN_CALL__SETTINGS);
		createEReference(runCallEClass, RUN_CALL__ESTIMATION_SPECIFICATION);

		inputDataEClass = createEClass(INPUT_DATA);
		createEReference(inputDataEClass, INPUT_DATA__INPUT_SPECIFICATION);
		createEReference(inputDataEClass, INPUT_DATA__DESCRIPTION);
		createEAttribute(inputDataEClass, INPUT_DATA__ROOT_FOLDER);

		optimizationSettingsEClass = createEClass(OPTIMIZATION_SETTINGS);
		createEAttribute(optimizationSettingsEClass, OPTIMIZATION_SETTINGS__IGNORE_APPROACHES);
		createEReference(optimizationSettingsEClass, OPTIMIZATION_SETTINGS__VALIDATOR);
		createEReference(optimizationSettingsEClass, OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE);

		iterativeParameterOptimizerSpecifierEClass = createEClass(ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER);
		createEAttribute(iterativeParameterOptimizerSpecifierEClass, ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS);
		createEAttribute(iterativeParameterOptimizerSpecifierEClass, ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS);
		createEOperation(iterativeParameterOptimizerSpecifierEClass, ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER___STOP);

		iOptimizableParameterEClass = createEClass(IOPTIMIZABLE_PARAMETER);
		createEAttribute(iOptimizableParameterEClass, IOPTIMIZABLE_PARAMETER__LOWER_BOUND);
		createEAttribute(iOptimizableParameterEClass, IOPTIMIZABLE_PARAMETER__UPPER_BOUND);
		createEAttribute(iOptimizableParameterEClass, IOPTIMIZABLE_PARAMETER__START_VALUE);

		genericParameterEClass = createEClass(GENERIC_PARAMETER);
		createEAttribute(genericParameterEClass, GENERIC_PARAMETER__KEY);

		stepSizeEClass = createEClass(STEP_SIZE);

		windowSizeEClass = createEClass(WINDOW_SIZE);
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		localSearchSpecifierEClass.getESuperTypes().add(this.getIConfigurationOptimizationAlgorithmSpecifier());
		iterativeParameterOptimizerSpecifierEClass.getESuperTypes().add(this.getIConfigurationOptimizationAlgorithmSpecifier());
		genericParameterEClass.getESuperTypes().add(this.getIOptimizableParameter());
		stepSizeEClass.getESuperTypes().add(this.getIOptimizableParameter());
		windowSizeEClass.getESuperTypes().add(this.getIOptimizableParameter());

		// Initialize classes, features, and operations; add parameters
		initEClass(optimizationConfigurationEClass, OptimizationConfiguration.class, "OptimizationConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptimizationConfiguration_ContainsOf(), this.getRunCall(), null, "containsOf", null, 0, -1, OptimizationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iConfigurationOptimizationAlgorithmSpecifierEClass, IConfigurationOptimizationAlgorithmSpecifier.class, "IConfigurationOptimizationAlgorithmSpecifier", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIConfigurationOptimizationAlgorithmSpecifier_TimeOut(), ecorePackage.getELong(), "timeOut", "-1", 1, 1, IConfigurationOptimizationAlgorithmSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localSearchSpecifierEClass, LocalSearchSpecifier.class, "LocalSearchSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalSearchSpecifier_Tolerance(), ecorePackage.getEDouble(), "tolerance", "0.05", 1, 1, LocalSearchSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalSearchSpecifier_MaximumNumberOfSteps(), ecorePackage.getELong(), "maximumNumberOfSteps", "-1", 1, 1, LocalSearchSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalSearchSpecifier_StepSize(), ecorePackage.getEDouble(), "stepSize", "1", 1, 1, LocalSearchSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runCallEClass, RunCall.class, "RunCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRunCall_Algorithm(), this.getIConfigurationOptimizationAlgorithmSpecifier(), null, "algorithm", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_TrainingData(), this.getInputData(), null, "trainingData", null, 1, -1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_Settings(), this.getOptimizationSettings(), null, "settings", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_EstimationSpecification(), theConfigurationPackage.getEstimationSpecification(), null, "estimationSpecification", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputDataEClass, InputData.class, "InputData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputData_InputSpecification(), theConfigurationPackage.getInputSpecification(), null, "inputSpecification", null, 1, 1, InputData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputData_Description(), theConfigurationPackage.getWorkloadDescription(), null, "description", null, 1, 1, InputData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInputData_RootFolder(), theXMLTypePackage.getString(), "rootFolder", null, 1, 1, InputData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optimizationSettingsEClass, OptimizationSettings.class, "OptimizationSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOptimizationSettings_IgnoreApproaches(), theXMLTypePackage.getString(), "IgnoreApproaches", null, 0, -1, OptimizationSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimizationSettings_Validator(), theConfigurationPackage.getValidationSpecification(), null, "validator", null, 1, 1, OptimizationSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimizationSettings_ParametersToOptimize(), this.getIOptimizableParameter(), null, "parametersToOptimize", null, 0, -1, OptimizationSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterativeParameterOptimizerSpecifierEClass, IterativeParameterOptimizerSpecifier.class, "IterativeParameterOptimizerSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIterativeParameterOptimizerSpecifier_NumberOfSplits(), theXMLTypePackage.getInt(), "numberOfSplits", "10", 1, 1, IterativeParameterOptimizerSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterativeParameterOptimizerSpecifier_NumberOfExplorations(), theXMLTypePackage.getInt(), "numberOfExplorations", "50", 1, 1, IterativeParameterOptimizerSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIterativeParameterOptimizerSpecifier__Stop(), theXMLTypePackage.getBoolean(), "stop", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iOptimizableParameterEClass, IOptimizableParameter.class, "IOptimizableParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIOptimizableParameter_LowerBound(), theXMLTypePackage.getAnySimpleType(), "lowerBound", null, 0, 1, IOptimizableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIOptimizableParameter_UpperBound(), theXMLTypePackage.getAnySimpleType(), "upperBound", null, 0, 1, IOptimizableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIOptimizableParameter_StartValue(), theXMLTypePackage.getAnySimpleType(), "startValue", null, 0, 1, IOptimizableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genericParameterEClass, GenericParameter.class, "GenericParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenericParameter_Key(), theXMLTypePackage.getString(), "key", null, 1, 1, GenericParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stepSizeEClass, StepSize.class, "StepSize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(windowSizeEClass, WindowSize.class, "WindowSize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OptimizationPackageImpl
