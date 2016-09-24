/**
 */
package tools.descartes.librede.rrde.lifecycle.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import tools.descartes.librede.configuration.ConfigurationPackage;

import tools.descartes.librede.metrics.MetricsPackage;

import tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.lifecycle.LifecycleFactory;
import tools.descartes.librede.rrde.lifecycle.LifecyclePackage;

import tools.descartes.librede.rrde.optimization.OptimizationPackage;

import tools.descartes.librede.rrde.optimization.impl.OptimizationPackageImpl;

import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

import tools.descartes.librede.rrde.recommendation.impl.RecommendationPackageImpl;

import tools.descartes.librede.units.UnitsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LifecyclePackageImpl extends EPackageImpl implements LifecyclePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lifeCycleConfigurationEClass = null;

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
	 * @see tools.descartes.librede.rrde.lifecycle.LifecyclePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LifecyclePackageImpl() {
		super(eNS_URI, LifecycleFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LifecyclePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LifecyclePackage init() {
		if (isInited) return (LifecyclePackage)EPackage.Registry.INSTANCE.getEPackage(LifecyclePackage.eNS_URI);

		// Obtain or create and register package
		LifecyclePackageImpl theLifecyclePackage = (LifecyclePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LifecyclePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LifecyclePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConfigurationPackage.eINSTANCE.eClass();
		MetricsPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		OptimizationPackageImpl theOptimizationPackage = (OptimizationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI) instanceof OptimizationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI) : OptimizationPackage.eINSTANCE);
		RecommendationPackageImpl theRecommendationPackage = (RecommendationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RecommendationPackage.eNS_URI) instanceof RecommendationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RecommendationPackage.eNS_URI) : RecommendationPackage.eINSTANCE);

		// Create package meta-data objects
		theLifecyclePackage.createPackageContents();
		theOptimizationPackage.createPackageContents();
		theRecommendationPackage.createPackageContents();

		// Initialize created meta-data
		theLifecyclePackage.initializePackageContents();
		theOptimizationPackage.initializePackageContents();
		theRecommendationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLifecyclePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LifecyclePackage.eNS_URI, theLifecyclePackage);
		return theLifecyclePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLifeCycleConfiguration() {
		return lifeCycleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifeCycleConfiguration_RecommendationLoopTime() {
		return (EAttribute)lifeCycleConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifeCycleConfiguration_OptimizationLoopTime() {
		return (EAttribute)lifeCycleConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifeCycleConfiguration_SelectionLoopTime() {
		return (EAttribute)lifeCycleConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifeCycleConfiguration_RecommendationConfiguration() {
		return (EReference)lifeCycleConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifeCycleConfiguration_OptimizationConfiguration() {
		return (EReference)lifeCycleConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifecycleFactory getLifecycleFactory() {
		return (LifecycleFactory)getEFactoryInstance();
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
		lifeCycleConfigurationEClass = createEClass(LIFE_CYCLE_CONFIGURATION);
		createEAttribute(lifeCycleConfigurationEClass, LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME);
		createEAttribute(lifeCycleConfigurationEClass, LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME);
		createEAttribute(lifeCycleConfigurationEClass, LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME);
		createEReference(lifeCycleConfigurationEClass, LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION);
		createEReference(lifeCycleConfigurationEClass, LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION);
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
		RecommendationPackage theRecommendationPackage = (RecommendationPackage)EPackage.Registry.INSTANCE.getEPackage(RecommendationPackage.eNS_URI);
		OptimizationPackage theOptimizationPackage = (OptimizationPackage)EPackage.Registry.INSTANCE.getEPackage(OptimizationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(lifeCycleConfigurationEClass, LifeCycleConfiguration.class, "LifeCycleConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLifeCycleConfiguration_RecommendationLoopTime(), theXMLTypePackage.getLong(), "recommendationLoopTime", "-1", 1, 1, LifeCycleConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifeCycleConfiguration_OptimizationLoopTime(), theXMLTypePackage.getLong(), "optimizationLoopTime", "-1", 1, 1, LifeCycleConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifeCycleConfiguration_SelectionLoopTime(), theXMLTypePackage.getLong(), "selectionLoopTime", "-1", 1, 1, LifeCycleConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifeCycleConfiguration_RecommendationConfiguration(), theRecommendationPackage.getRecommendationTrainingConfiguration(), null, "recommendationConfiguration", null, 0, 1, LifeCycleConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifeCycleConfiguration_OptimizationConfiguration(), theOptimizationPackage.getOptimizationConfiguration(), null, "optimizationConfiguration", null, 0, 1, LifeCycleConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LifecyclePackageImpl
