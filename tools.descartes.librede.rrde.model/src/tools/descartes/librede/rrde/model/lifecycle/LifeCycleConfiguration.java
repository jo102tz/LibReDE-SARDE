/**
 */
package tools.descartes.librede.rrde.model.lifecycle;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Life Cycle Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getRecommendationLoopTime <em>Recommendation Loop Time</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getOptimizationLoopTime <em>Optimization Loop Time</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getSelectionLoopTime <em>Selection Loop Time</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getRecommendationConfiguration <em>Recommendation Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getOptimizationConfiguration <em>Optimization Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getEstimationLoopTime <em>Estimation Loop Time</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage#getLifeCycleConfiguration()
 * @model
 * @generated
 */
public interface LifeCycleConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Recommendation Loop Time</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recommendation Loop Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recommendation Loop Time</em>' attribute.
	 * @see #setRecommendationLoopTime(long)
	 * @see tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage#getLifeCycleConfiguration_RecommendationLoopTime()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Long" required="true"
	 * @generated
	 */
	long getRecommendationLoopTime();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getRecommendationLoopTime <em>Recommendation Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recommendation Loop Time</em>' attribute.
	 * @see #getRecommendationLoopTime()
	 * @generated
	 */
	void setRecommendationLoopTime(long value);

	/**
	 * Returns the value of the '<em><b>Optimization Loop Time</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optimization Loop Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimization Loop Time</em>' attribute.
	 * @see #setOptimizationLoopTime(long)
	 * @see tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage#getLifeCycleConfiguration_OptimizationLoopTime()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Long" required="true"
	 * @generated
	 */
	long getOptimizationLoopTime();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getOptimizationLoopTime <em>Optimization Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimization Loop Time</em>' attribute.
	 * @see #getOptimizationLoopTime()
	 * @generated
	 */
	void setOptimizationLoopTime(long value);

	/**
	 * Returns the value of the '<em><b>Selection Loop Time</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Loop Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Loop Time</em>' attribute.
	 * @see #setSelectionLoopTime(long)
	 * @see tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage#getLifeCycleConfiguration_SelectionLoopTime()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Long" required="true"
	 * @generated
	 */
	long getSelectionLoopTime();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getSelectionLoopTime <em>Selection Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Loop Time</em>' attribute.
	 * @see #getSelectionLoopTime()
	 * @generated
	 */
	void setSelectionLoopTime(long value);

	/**
	 * Returns the value of the '<em><b>Recommendation Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recommendation Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recommendation Configuration</em>' reference.
	 * @see #setRecommendationConfiguration(RecommendationTrainingConfiguration)
	 * @see tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage#getLifeCycleConfiguration_RecommendationConfiguration()
	 * @model
	 * @generated
	 */
	RecommendationTrainingConfiguration getRecommendationConfiguration();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getRecommendationConfiguration <em>Recommendation Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recommendation Configuration</em>' reference.
	 * @see #getRecommendationConfiguration()
	 * @generated
	 */
	void setRecommendationConfiguration(RecommendationTrainingConfiguration value);

	/**
	 * Returns the value of the '<em><b>Optimization Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optimization Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimization Configuration</em>' reference.
	 * @see #setOptimizationConfiguration(OptimizationConfiguration)
	 * @see tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage#getLifeCycleConfiguration_OptimizationConfiguration()
	 * @model
	 * @generated
	 */
	OptimizationConfiguration getOptimizationConfiguration();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getOptimizationConfiguration <em>Optimization Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimization Configuration</em>' reference.
	 * @see #getOptimizationConfiguration()
	 * @generated
	 */
	void setOptimizationConfiguration(OptimizationConfiguration value);

	/**
	 * Returns the value of the '<em><b>Estimation Loop Time</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimation Loop Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimation Loop Time</em>' attribute.
	 * @see #setEstimationLoopTime(long)
	 * @see tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage#getLifeCycleConfiguration_EstimationLoopTime()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Long" required="true"
	 * @generated
	 */
	long getEstimationLoopTime();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration#getEstimationLoopTime <em>Estimation Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimation Loop Time</em>' attribute.
	 * @see #getEstimationLoopTime()
	 * @generated
	 */
	void setEstimationLoopTime(long value);

} // LifeCycleConfiguration
