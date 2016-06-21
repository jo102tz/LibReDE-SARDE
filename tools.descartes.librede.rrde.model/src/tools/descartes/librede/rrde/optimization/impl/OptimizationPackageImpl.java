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

import tools.descartes.librede.configuration.impl.ConfigurationPackageImpl;

import tools.descartes.librede.metrics.MetricsPackage;

import tools.descartes.librede.metrics.impl.MetricsPackageImpl;

import tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer;
import tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer;
import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.optimization.RunCall;

import tools.descartes.librede.units.UnitsPackage;

import tools.descartes.librede.units.impl.UnitsPackageImpl;

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
	private EClass iConfigurationOptimizationAlgorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractLocalSearchOptimizerEClass = null;

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
	private EClass abstractIterativeParameterOptimizerEClass = null;

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
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ConfigurationPackageImpl theConfigurationPackage = (ConfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI) instanceof ConfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI) : ConfigurationPackage.eINSTANCE);
		UnitsPackageImpl theUnitsPackage = (UnitsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UnitsPackage.eNS_URI) instanceof UnitsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UnitsPackage.eNS_URI) : UnitsPackage.eINSTANCE);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) instanceof MetricsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) : MetricsPackage.eINSTANCE);

		// Create package meta-data objects
		theOptimizationPackage.createPackageContents();
		theConfigurationPackage.createPackageContents();
		theUnitsPackage.createPackageContents();
		theMetricsPackage.createPackageContents();

		// Initialize created meta-data
		theOptimizationPackage.initializePackageContents();
		theConfigurationPackage.initializePackageContents();
		theUnitsPackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();

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
	public EClass getIConfigurationOptimizationAlgorithm() {
		return iConfigurationOptimizationAlgorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConfigurationOptimizationAlgorithm_TimeOut() {
		return (EAttribute)iConfigurationOptimizationAlgorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIConfigurationOptimizationAlgorithm__RunOptimization__InputData_OptimizationSettings_EstimationSpecification() {
		return iConfigurationOptimizationAlgorithmEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIConfigurationOptimizationAlgorithm__Configure__String_EObject() {
		return iConfigurationOptimizationAlgorithmEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractLocalSearchOptimizer() {
		return abstractLocalSearchOptimizerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractLocalSearchOptimizer_Minimum() {
		return (EAttribute)abstractLocalSearchOptimizerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractLocalSearchOptimizer_Maximum() {
		return (EAttribute)abstractLocalSearchOptimizerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractLocalSearchOptimizer_Tolerance() {
		return (EAttribute)abstractLocalSearchOptimizerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractLocalSearchOptimizer_MaximumNumberOfSteps() {
		return (EAttribute)abstractLocalSearchOptimizerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractLocalSearchOptimizer_StartValue() {
		return (EAttribute)abstractLocalSearchOptimizerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractLocalSearchOptimizer_StepSize() {
		return (EAttribute)abstractLocalSearchOptimizerEClass.getEStructuralFeatures().get(5);
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
	public EAttribute getInputData_ResultsFile() {
		return (EAttribute)inputDataEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getOptimizationSettings_ParametersToOptmize() {
		return (EAttribute)optimizationSettingsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOptimizationSettings_Validator() {
		return (EReference)optimizationSettingsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractIterativeParameterOptimizer() {
		return abstractIterativeParameterOptimizerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractIterativeParameterOptimizer_NumberOfSplits() {
		return (EAttribute)abstractIterativeParameterOptimizerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractIterativeParameterOptimizer_NumberOfExplorations() {
		return (EAttribute)abstractIterativeParameterOptimizerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractIterativeParameterOptimizer__Stop() {
		return abstractIterativeParameterOptimizerEClass.getEOperations().get(0);
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

		iConfigurationOptimizationAlgorithmEClass = createEClass(ICONFIGURATION_OPTIMIZATION_ALGORITHM);
		createEAttribute(iConfigurationOptimizationAlgorithmEClass, ICONFIGURATION_OPTIMIZATION_ALGORITHM__TIME_OUT);
		createEOperation(iConfigurationOptimizationAlgorithmEClass, ICONFIGURATION_OPTIMIZATION_ALGORITHM___RUN_OPTIMIZATION__INPUTDATA_OPTIMIZATIONSETTINGS_ESTIMATIONSPECIFICATION);
		createEOperation(iConfigurationOptimizationAlgorithmEClass, ICONFIGURATION_OPTIMIZATION_ALGORITHM___CONFIGURE__STRING_EOBJECT);

		abstractLocalSearchOptimizerEClass = createEClass(ABSTRACT_LOCAL_SEARCH_OPTIMIZER);
		createEAttribute(abstractLocalSearchOptimizerEClass, ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MINIMUM);
		createEAttribute(abstractLocalSearchOptimizerEClass, ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM);
		createEAttribute(abstractLocalSearchOptimizerEClass, ABSTRACT_LOCAL_SEARCH_OPTIMIZER__TOLERANCE);
		createEAttribute(abstractLocalSearchOptimizerEClass, ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM_NUMBER_OF_STEPS);
		createEAttribute(abstractLocalSearchOptimizerEClass, ABSTRACT_LOCAL_SEARCH_OPTIMIZER__START_VALUE);
		createEAttribute(abstractLocalSearchOptimizerEClass, ABSTRACT_LOCAL_SEARCH_OPTIMIZER__STEP_SIZE);

		runCallEClass = createEClass(RUN_CALL);
		createEReference(runCallEClass, RUN_CALL__ALGORITHM);
		createEReference(runCallEClass, RUN_CALL__TRAINING_DATA);
		createEReference(runCallEClass, RUN_CALL__SETTINGS);
		createEReference(runCallEClass, RUN_CALL__ESTIMATION_SPECIFICATION);

		inputDataEClass = createEClass(INPUT_DATA);
		createEAttribute(inputDataEClass, INPUT_DATA__RESULTS_FILE);

		optimizationSettingsEClass = createEClass(OPTIMIZATION_SETTINGS);
		createEAttribute(optimizationSettingsEClass, OPTIMIZATION_SETTINGS__IGNORE_APPROACHES);
		createEAttribute(optimizationSettingsEClass, OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTMIZE);
		createEReference(optimizationSettingsEClass, OPTIMIZATION_SETTINGS__VALIDATOR);

		abstractIterativeParameterOptimizerEClass = createEClass(ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER);
		createEAttribute(abstractIterativeParameterOptimizerEClass, ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_SPLITS);
		createEAttribute(abstractIterativeParameterOptimizerEClass, ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_EXPLORATIONS);
		createEOperation(abstractIterativeParameterOptimizerEClass, ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER___STOP);
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
		abstractLocalSearchOptimizerEClass.getESuperTypes().add(this.getIConfigurationOptimizationAlgorithm());
		inputDataEClass.getESuperTypes().add(theConfigurationPackage.getInputSpecification());
		abstractIterativeParameterOptimizerEClass.getESuperTypes().add(this.getIConfigurationOptimizationAlgorithm());

		// Initialize classes, features, and operations; add parameters
		initEClass(optimizationConfigurationEClass, OptimizationConfiguration.class, "OptimizationConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptimizationConfiguration_ContainsOf(), this.getRunCall(), null, "containsOf", null, 0, -1, OptimizationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iConfigurationOptimizationAlgorithmEClass, IConfigurationOptimizationAlgorithm.class, "IConfigurationOptimizationAlgorithm", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIConfigurationOptimizationAlgorithm_TimeOut(), ecorePackage.getELong(), "timeOut", "-1", 1, 1, IConfigurationOptimizationAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getIConfigurationOptimizationAlgorithm__RunOptimization__InputData_OptimizationSettings_EstimationSpecification(), theConfigurationPackage.getEstimationSpecification(), "runOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInputData(), "input", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOptimizationSettings(), "settings", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theConfigurationPackage.getEstimationSpecification(), "estimation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIConfigurationOptimizationAlgorithm__Configure__String_EObject(), theXMLTypePackage.getBoolean(), "configure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "parameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(abstractLocalSearchOptimizerEClass, AbstractLocalSearchOptimizer.class, "AbstractLocalSearchOptimizer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractLocalSearchOptimizer_Minimum(), ecorePackage.getEDouble(), "minimum", "0", 1, 1, AbstractLocalSearchOptimizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractLocalSearchOptimizer_Maximum(), ecorePackage.getEDouble(), "maximum", "200", 1, 1, AbstractLocalSearchOptimizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractLocalSearchOptimizer_Tolerance(), ecorePackage.getEDouble(), "tolerance", "0.05", 1, 1, AbstractLocalSearchOptimizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractLocalSearchOptimizer_MaximumNumberOfSteps(), ecorePackage.getELong(), "maximumNumberOfSteps", "-1", 1, 1, AbstractLocalSearchOptimizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractLocalSearchOptimizer_StartValue(), ecorePackage.getEDouble(), "startValue", "60", 1, 1, AbstractLocalSearchOptimizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractLocalSearchOptimizer_StepSize(), ecorePackage.getEDouble(), "stepSize", "1", 1, 1, AbstractLocalSearchOptimizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runCallEClass, RunCall.class, "RunCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRunCall_Algorithm(), this.getIConfigurationOptimizationAlgorithm(), null, "algorithm", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_TrainingData(), this.getInputData(), null, "trainingData", null, 1, -1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_Settings(), this.getOptimizationSettings(), null, "settings", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRunCall_EstimationSpecification(), theConfigurationPackage.getEstimationSpecification(), null, "estimationSpecification", null, 1, 1, RunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputDataEClass, InputData.class, "InputData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputData_ResultsFile(), ecorePackage.getEString(), "resultsFile", null, 0, 1, InputData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optimizationSettingsEClass, OptimizationSettings.class, "OptimizationSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOptimizationSettings_IgnoreApproaches(), theXMLTypePackage.getString(), "IgnoreApproaches", null, 0, -1, OptimizationSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOptimizationSettings_ParametersToOptmize(), theXMLTypePackage.getString(), "parametersToOptmize", null, 0, -1, OptimizationSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimizationSettings_Validator(), theConfigurationPackage.getValidationSpecification(), null, "validator", null, 1, 1, OptimizationSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractIterativeParameterOptimizerEClass, AbstractIterativeParameterOptimizer.class, "AbstractIterativeParameterOptimizer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractIterativeParameterOptimizer_NumberOfSplits(), theXMLTypePackage.getInt(), "numberOfSplits", "10", 1, 1, AbstractIterativeParameterOptimizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractIterativeParameterOptimizer_NumberOfExplorations(), theXMLTypePackage.getInt(), "numberOfExplorations", "50", 1, 1, AbstractIterativeParameterOptimizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAbstractIterativeParameterOptimizer__Stop(), theXMLTypePackage.getBoolean(), "stop", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OptimizationPackageImpl
