/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import tools.descartes.librede.configuration.ConfigurationPackage;

import tools.descartes.librede.metrics.MetricsPackage;

import tools.descartes.librede.rrde.lifecycle.LifecyclePackage;

import tools.descartes.librede.rrde.lifecycle.impl.LifecyclePackageImpl;

import tools.descartes.librede.rrde.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.GenericParameter;
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

import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

import tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl;

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
	private EClass configurationOptimizationAlgorithmSpecifierEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataExportSpecifierEClass = null;

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

		// Obtain or create and register interdependencies
		LifecyclePackageImpl theLifecyclePackage = (LifecyclePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LifecyclePackage.eNS_URI) instanceof LifecyclePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LifecyclePackage.eNS_URI) : LifecyclePackage.eINSTANCE);
		RecommendationPackageImpl theRecommendationPackage = (RecommendationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RecommendationPackage.eNS_URI) instanceof RecommendationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RecommendationPackage.eNS_URI) : RecommendationPackage.eINSTANCE);

		// Create package meta-data objects
		theOptimizationPackage.createPackageContents();
		theLifecyclePackage.createPackageContents();
		theRecommendationPackage.createPackageContents();

		// Initialize created meta-data
		theOptimizationPackage.initializePackageContents();
		theLifecyclePackage.initializePackageContents();
		theRecommendationPackage.initializePackageContents();

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
	public EClass getConfigurationOptimizationAlgorithmSpecifier() {
		return configurationOptimizationAlgorithmSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationOptimizationAlgorithmSpecifier_TimeOut() {
		return (EAttribute)configurationOptimizationAlgorithmSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationOptimizationAlgorithmSpecifier_AlgorithmName() {
		return (EAttribute)configurationOptimizationAlgorithmSpecifierEClass.getEStructuralFeatures().get(1);
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
	public EReference getRunCall_Estimation() {
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
	public EReference getInputData_Input() {
		return (EReference)inputDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputData_WorkloadDescription() {
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
	public EAttribute getInputData_MultiFolderStructures() {
		return (EAttribute)inputDataEClass.getEStructuralFeatures().get(3);
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
	public EReference getOptimizationSettings_Validator() {
		return (EReference)optimizationSettingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOptimizationSettings_ParametersToOptimize() {
		return (EReference)optimizationSettingsEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getIterativeParameterOptimizerSpecifier_NumberOfIterations() {
		return (EAttribute)iterativeParameterOptimizerSpecifierEClass.getEStructuralFeatures().get(2);
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
	public EReference getGenericParameter_Parameter() {
		return (EReference)genericParameterEClass.getEStructuralFeatures().get(0);
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
	public EClass getDataExportSpecifier() {
		return dataExportSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataExportSpecifier_OutputDirectory() {
		return (EAttribute)dataExportSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataExportSpecifier_StepSize() {
		return (EAttribute)dataExportSpecifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataExportSpecifier_Multidimensional() {
		return (EAttribute)dataExportSpecifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataExportSpecifier_SplitConfigurations() {
		return (EAttribute)dataExportSpecifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataExportSpecifier_UseBestResult() {
		return (EAttribute)dataExportSpecifierEClass.getEStructuralFeatures().get(4);
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

		configurationOptimizationAlgorithmSpecifierEClass = createEClass(CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER);
		createEAttribute(configurationOptimizationAlgorithmSpecifierEClass, CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT);
		createEAttribute(configurationOptimizationAlgorithmSpecifierEClass, CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME);

		localSearchSpecifierEClass = createEClass(LOCAL_SEARCH_SPECIFIER);
		createEAttribute(localSearchSpecifierEClass, LOCAL_SEARCH_SPECIFIER__TOLERANCE);
		createEAttribute(localSearchSpecifierEClass, LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS);
		createEAttribute(localSearchSpecifierEClass, LOCAL_SEARCH_SPECIFIER__STEP_SIZE);

		runCallEClass = createEClass(RUN_CALL);
		createEReference(runCallEClass, RUN_CALL__ALGORITHM);
		createEReference(runCallEClass, RUN_CALL__TRAINING_DATA);
		createEReference(runCallEClass, RUN_CALL__SETTINGS);
		createEReference(runCallEClass, RUN_CALL__ESTIMATION);

		inputDataEClass = createEClass(INPUT_DATA);
		createEReference(inputDataEClass, INPUT_DATA__INPUT);
		createEReference(inputDataEClass, INPUT_DATA__WORKLOAD_DESCRIPTION);
		createEAttribute(inputDataEClass, INPUT_DATA__ROOT_FOLDER);
		createEAttribute(inputDataEClass, INPUT_DATA__MULTI_FOLDER_STRUCTURES);

		optimizationSettingsEClass = createEClass(OPTIMIZATION_SETTINGS);
		createEReference(optimizationSettingsEClass, OPTIMIZATION_SETTINGS__VALIDATOR);
		createEReference(optimizationSettingsEClass, OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE);

		iterativeParameterOptimizerSpecifierEClass = createEClass(ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER);
		createEAttribute(iterativeParameterOptimizerSpecifierEClass, ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS);
		createEAttribute(iterativeParameterOptimizerSpecifierEClass, ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS);
		createEAttribute(iterativeParameterOptimizerSpecifierEClass, ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS);

		iOptimizableParameterEClass = createEClass(IOPTIMIZABLE_PARAMETER);
		createEAttribute(iOptimizableParameterEClass, IOPTIMIZABLE_PARAMETER__LOWER_BOUND);
		createEAttribute(iOptimizableParameterEClass, IOPTIMIZABLE_PARAMETER__UPPER_BOUND);
		createEAttribute(iOptimizableParameterEClass, IOPTIMIZABLE_PARAMETER__START_VALUE);

		genericParameterEClass = createEClass(GENERIC_PARAMETER);
		createEReference(genericParameterEClass, GENERIC_PARAMETER__PARAMETER);

		stepSizeEClass = createEClass(STEP_SIZE);

		windowSizeEClass = createEClass(WINDOW_SIZE);

		dataExportSpecifierEClass = createEClass(DATA_EXPORT_SPECIFIER);
		createEAttribute(dataExportSpecifierEClass, DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY);
		createEAttribute(dataExportSpecifierEClass, DATA_EXPORT_SPECIFIER__STEP_SIZE);
		createEAttribute(dataExportSpecifierEClass, DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL);
		createEAttribute(dataExportSpecifierEClass, DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS);
		createEAttribute(dataExportSpecifierEClass, DATA_EXPORT_SPECIFIER__USE_BEST_RESULT);
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		ConfigurationPackage theConfigurationPackage = (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		localSearchSpecifierEClass.getESuperTypes().add(this.getConfigurationOptimizationAlgorithmSpecifier());
		iterativeParameterOptimizerSpecifierEClass.getESuperTypes().add(this.getConfigurationOptimizationAlgorithmSpecifier());
		genericParameterEClass.getESuperTypes().add(this.getIOptimizableParameter());
		stepSizeEClass.getESuperTypes().add(this.getIOptimizableParameter());
		windowSizeEClass.getESuperTypes().add(this.getIOptimizableParameter());
		dataExportSpecifierEClass.getESuperTypes().add(this.getConfigurationOptimizationAlgorithmSpecifier());

		// Initialize classes, features, and operations; add parameters
		initEClass(optimizationConfigurationEClass, OptimizationConfiguration.class, "OptimizationConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptimizationConfiguration_ContainsOf(), this.getRunCall(), null, "containsOf", null, 0, -1, OptimizationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationOptimizationAlgorithmSpecifierEClass, ConfigurationOptimizationAlgorithmSpecifier.class, "ConfigurationOptimizationAlgorithmSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationOptimizationAlgorithmSpecifier_TimeOut(), theXMLTypePackage.getLong(), "timeOut", "-1", 1, 1, ConfigurationOptimizationAlgorithmSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationOptimizationAlgorithmSpecifier_AlgorithmName(), theXMLTypePackage.getString(), "algorithmName", null, 1, 1, ConfigurationOptimizationAlgorithmSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localSearchSpecifierEClass, LocalSearchSpecifier.class, "LocalSearchSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalSearchSpecifier_Tolerance(), theXMLTypePackage.getDouble(), "tolerance", "0.05", 1, 1, LocalSearchSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalSearchSpecifier_MaximumNumberOfSteps(), theXMLTypePackage.getLong(), "maximumNumberOfSteps", "-1", 1, 1, LocalSearchSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalSearchSpecifier_StepSize(), theXMLTypePackage.getDouble(), "stepSize", "1", 1, 1, LocalSearchSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runCallEClass, RunCall.class, "RunCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRunCall_Algorithm(), this.getConfigurationOptimizationAlgorithmSpecifier(), null, "algorithm", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_TrainingData(), this.getInputData(), null, "trainingData", null, 1, -1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_Settings(), this.getOptimizationSettings(), null, "settings", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_Estimation(), theConfigurationPackage.getEstimationSpecification(), null, "estimation", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputDataEClass, InputData.class, "InputData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputData_Input(), theConfigurationPackage.getInputSpecification(), null, "input", null, 1, 1, InputData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputData_WorkloadDescription(), theConfigurationPackage.getWorkloadDescription(), null, "workloadDescription", null, 1, 1, InputData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInputData_RootFolder(), theXMLTypePackage.getString(), "rootFolder", null, 1, 1, InputData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInputData_MultiFolderStructures(), theXMLTypePackage.getBoolean(), "multiFolderStructures", "false", 1, 1, InputData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optimizationSettingsEClass, OptimizationSettings.class, "OptimizationSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptimizationSettings_Validator(), theConfigurationPackage.getValidationSpecification(), null, "validator", null, 1, 1, OptimizationSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimizationSettings_ParametersToOptimize(), this.getIOptimizableParameter(), null, "parametersToOptimize", null, 0, -1, OptimizationSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterativeParameterOptimizerSpecifierEClass, IterativeParameterOptimizerSpecifier.class, "IterativeParameterOptimizerSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIterativeParameterOptimizerSpecifier_NumberOfSplits(), theXMLTypePackage.getInt(), "numberOfSplits", "3", 1, 1, IterativeParameterOptimizerSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterativeParameterOptimizerSpecifier_NumberOfExplorations(), theXMLTypePackage.getInt(), "numberOfExplorations", "3", 1, 1, IterativeParameterOptimizerSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterativeParameterOptimizerSpecifier_NumberOfIterations(), theXMLTypePackage.getInt(), "numberOfIterations", "3", 1, 1, IterativeParameterOptimizerSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iOptimizableParameterEClass, IOptimizableParameter.class, "IOptimizableParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIOptimizableParameter_LowerBound(), theXMLTypePackage.getDouble(), "lowerBound", "0", 1, 1, IOptimizableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIOptimizableParameter_UpperBound(), theXMLTypePackage.getDouble(), "upperBound", "1", 1, 1, IOptimizableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIOptimizableParameter_StartValue(), theXMLTypePackage.getDouble(), "startValue", "0", 1, 1, IOptimizableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genericParameterEClass, GenericParameter.class, "GenericParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenericParameter_Parameter(), theConfigurationPackage.getParameter(), null, "parameter", null, 1, 1, GenericParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stepSizeEClass, StepSize.class, "StepSize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(windowSizeEClass, WindowSize.class, "WindowSize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataExportSpecifierEClass, DataExportSpecifier.class, "DataExportSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataExportSpecifier_OutputDirectory(), theXMLTypePackage.getString(), "outputDirectory", "\"\"", 1, 1, DataExportSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataExportSpecifier_StepSize(), theXMLTypePackage.getDouble(), "stepSize", "1.0", 1, 1, DataExportSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataExportSpecifier_Multidimensional(), theXMLTypePackage.getBoolean(), "multidimensional", "false", 1, 1, DataExportSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataExportSpecifier_SplitConfigurations(), theXMLTypePackage.getBoolean(), "splitConfigurations", "true", 1, 1, DataExportSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataExportSpecifier_UseBestResult(), theXMLTypePackage.getBoolean(), "useBestResult", "true", 0, 1, DataExportSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OptimizationPackageImpl
