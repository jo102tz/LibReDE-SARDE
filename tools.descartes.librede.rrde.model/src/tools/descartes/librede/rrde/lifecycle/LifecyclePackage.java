/**
 */
package tools.descartes.librede.rrde.lifecycle;

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
 * @see tools.descartes.librede.rrde.lifecycle.LifecycleFactory
 * @model kind="package"
 * @generated
 */
public interface LifecyclePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "lifecycle";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://tools/descartes/librede/rrde/lifecycle";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "librede-lifecycle";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LifecyclePackage eINSTANCE = tools.descartes.librede.rrde.lifecycle.impl.LifecyclePackageImpl.init();

	/**
	 * The meta object id for the '{@link tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl <em>Life Cycle Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl
	 * @see tools.descartes.librede.rrde.lifecycle.impl.LifecyclePackageImpl#getLifeCycleConfiguration()
	 * @generated
	 */
	int LIFE_CYCLE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Recommendation Loop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME = 0;

	/**
	 * The feature id for the '<em><b>Optimization Loop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME = 1;

	/**
	 * The feature id for the '<em><b>Selection Loop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME = 2;

	/**
	 * The feature id for the '<em><b>Recommendation Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Optimization Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Estimation Loop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_CYCLE_CONFIGURATION__ESTIMATION_LOOP_TIME = 5;

	/**
	 * The number of structural features of the '<em>Life Cycle Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_CYCLE_CONFIGURATION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Life Cycle Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_CYCLE_CONFIGURATION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration <em>Life Cycle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Life Cycle Configuration</em>'.
	 * @see tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration
	 * @generated
	 */
	EClass getLifeCycleConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getRecommendationLoopTime <em>Recommendation Loop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recommendation Loop Time</em>'.
	 * @see tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getRecommendationLoopTime()
	 * @see #getLifeCycleConfiguration()
	 * @generated
	 */
	EAttribute getLifeCycleConfiguration_RecommendationLoopTime();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getOptimizationLoopTime <em>Optimization Loop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optimization Loop Time</em>'.
	 * @see tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getOptimizationLoopTime()
	 * @see #getLifeCycleConfiguration()
	 * @generated
	 */
	EAttribute getLifeCycleConfiguration_OptimizationLoopTime();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getSelectionLoopTime <em>Selection Loop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection Loop Time</em>'.
	 * @see tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getSelectionLoopTime()
	 * @see #getLifeCycleConfiguration()
	 * @generated
	 */
	EAttribute getLifeCycleConfiguration_SelectionLoopTime();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getRecommendationConfiguration <em>Recommendation Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Recommendation Configuration</em>'.
	 * @see tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getRecommendationConfiguration()
	 * @see #getLifeCycleConfiguration()
	 * @generated
	 */
	EReference getLifeCycleConfiguration_RecommendationConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getOptimizationConfiguration <em>Optimization Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Optimization Configuration</em>'.
	 * @see tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getOptimizationConfiguration()
	 * @see #getLifeCycleConfiguration()
	 * @generated
	 */
	EReference getLifeCycleConfiguration_OptimizationConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getEstimationLoopTime <em>Estimation Loop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Estimation Loop Time</em>'.
	 * @see tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration#getEstimationLoopTime()
	 * @see #getLifeCycleConfiguration()
	 * @generated
	 */
	EAttribute getLifeCycleConfiguration_EstimationLoopTime();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LifecycleFactory getLifecycleFactory();

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
		 * The meta object literal for the '{@link tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl <em>Life Cycle Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl
		 * @see tools.descartes.librede.rrde.lifecycle.impl.LifecyclePackageImpl#getLifeCycleConfiguration()
		 * @generated
		 */
		EClass LIFE_CYCLE_CONFIGURATION = eINSTANCE.getLifeCycleConfiguration();

		/**
		 * The meta object literal for the '<em><b>Recommendation Loop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME = eINSTANCE.getLifeCycleConfiguration_RecommendationLoopTime();

		/**
		 * The meta object literal for the '<em><b>Optimization Loop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME = eINSTANCE.getLifeCycleConfiguration_OptimizationLoopTime();

		/**
		 * The meta object literal for the '<em><b>Selection Loop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME = eINSTANCE.getLifeCycleConfiguration_SelectionLoopTime();

		/**
		 * The meta object literal for the '<em><b>Recommendation Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION = eINSTANCE.getLifeCycleConfiguration_RecommendationConfiguration();

		/**
		 * The meta object literal for the '<em><b>Optimization Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION = eINSTANCE.getLifeCycleConfiguration_OptimizationConfiguration();

		/**
		 * The meta object literal for the '<em><b>Estimation Loop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFE_CYCLE_CONFIGURATION__ESTIMATION_LOOP_TIME = eINSTANCE.getLifeCycleConfiguration_EstimationLoopTime();

	}

} //LifecyclePackage
