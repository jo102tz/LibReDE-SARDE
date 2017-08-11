/**
 */
package tools.descartes.librede.rrde.lifecycle.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.lifecycle.LifecyclePackage;

import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;

import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Life Cycle Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl#getRecommendationLoopTime <em>Recommendation Loop Time</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl#getOptimizationLoopTime <em>Optimization Loop Time</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl#getSelectionLoopTime <em>Selection Loop Time</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl#getRecommendationConfiguration <em>Recommendation Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl#getOptimizationConfiguration <em>Optimization Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.lifecycle.impl.LifeCycleConfigurationImpl#getEstimationLoopTime <em>Estimation Loop Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LifeCycleConfigurationImpl extends MinimalEObjectImpl.Container implements LifeCycleConfiguration {
	/**
	 * The default value of the '{@link #getRecommendationLoopTime() <em>Recommendation Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecommendationLoopTime()
	 * @generated
	 * @ordered
	 */
	protected static final long RECOMMENDATION_LOOP_TIME_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getRecommendationLoopTime() <em>Recommendation Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecommendationLoopTime()
	 * @generated
	 * @ordered
	 */
	protected long recommendationLoopTime = RECOMMENDATION_LOOP_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptimizationLoopTime() <em>Optimization Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizationLoopTime()
	 * @generated
	 * @ordered
	 */
	protected static final long OPTIMIZATION_LOOP_TIME_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getOptimizationLoopTime() <em>Optimization Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizationLoopTime()
	 * @generated
	 * @ordered
	 */
	protected long optimizationLoopTime = OPTIMIZATION_LOOP_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSelectionLoopTime() <em>Selection Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionLoopTime()
	 * @generated
	 * @ordered
	 */
	protected static final long SELECTION_LOOP_TIME_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getSelectionLoopTime() <em>Selection Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionLoopTime()
	 * @generated
	 * @ordered
	 */
	protected long selectionLoopTime = SELECTION_LOOP_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRecommendationConfiguration() <em>Recommendation Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecommendationConfiguration()
	 * @generated
	 * @ordered
	 */
	protected RecommendationTrainingConfiguration recommendationConfiguration;

	/**
	 * The cached value of the '{@link #getOptimizationConfiguration() <em>Optimization Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizationConfiguration()
	 * @generated
	 * @ordered
	 */
	protected OptimizationConfiguration optimizationConfiguration;

	/**
	 * The default value of the '{@link #getEstimationLoopTime() <em>Estimation Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimationLoopTime()
	 * @generated
	 * @ordered
	 */
	protected static final long ESTIMATION_LOOP_TIME_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getEstimationLoopTime() <em>Estimation Loop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimationLoopTime()
	 * @generated
	 * @ordered
	 */
	protected long estimationLoopTime = ESTIMATION_LOOP_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifeCycleConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LifecyclePackage.Literals.LIFE_CYCLE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRecommendationLoopTime() {
		return recommendationLoopTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecommendationLoopTime(long newRecommendationLoopTime) {
		long oldRecommendationLoopTime = recommendationLoopTime;
		recommendationLoopTime = newRecommendationLoopTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME, oldRecommendationLoopTime, recommendationLoopTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getOptimizationLoopTime() {
		return optimizationLoopTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimizationLoopTime(long newOptimizationLoopTime) {
		long oldOptimizationLoopTime = optimizationLoopTime;
		optimizationLoopTime = newOptimizationLoopTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME, oldOptimizationLoopTime, optimizationLoopTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSelectionLoopTime() {
		return selectionLoopTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectionLoopTime(long newSelectionLoopTime) {
		long oldSelectionLoopTime = selectionLoopTime;
		selectionLoopTime = newSelectionLoopTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME, oldSelectionLoopTime, selectionLoopTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationTrainingConfiguration getRecommendationConfiguration() {
		return recommendationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecommendationConfiguration(RecommendationTrainingConfiguration newRecommendationConfiguration, NotificationChain msgs) {
		RecommendationTrainingConfiguration oldRecommendationConfiguration = recommendationConfiguration;
		recommendationConfiguration = newRecommendationConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION, oldRecommendationConfiguration, newRecommendationConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecommendationConfiguration(RecommendationTrainingConfiguration newRecommendationConfiguration) {
		if (newRecommendationConfiguration != recommendationConfiguration) {
			NotificationChain msgs = null;
			if (recommendationConfiguration != null)
				msgs = ((InternalEObject)recommendationConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION, null, msgs);
			if (newRecommendationConfiguration != null)
				msgs = ((InternalEObject)newRecommendationConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION, null, msgs);
			msgs = basicSetRecommendationConfiguration(newRecommendationConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION, newRecommendationConfiguration, newRecommendationConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationConfiguration getOptimizationConfiguration() {
		return optimizationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOptimizationConfiguration(OptimizationConfiguration newOptimizationConfiguration, NotificationChain msgs) {
		OptimizationConfiguration oldOptimizationConfiguration = optimizationConfiguration;
		optimizationConfiguration = newOptimizationConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION, oldOptimizationConfiguration, newOptimizationConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimizationConfiguration(OptimizationConfiguration newOptimizationConfiguration) {
		if (newOptimizationConfiguration != optimizationConfiguration) {
			NotificationChain msgs = null;
			if (optimizationConfiguration != null)
				msgs = ((InternalEObject)optimizationConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION, null, msgs);
			if (newOptimizationConfiguration != null)
				msgs = ((InternalEObject)newOptimizationConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION, null, msgs);
			msgs = basicSetOptimizationConfiguration(newOptimizationConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION, newOptimizationConfiguration, newOptimizationConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEstimationLoopTime() {
		return estimationLoopTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimationLoopTime(long newEstimationLoopTime) {
		long oldEstimationLoopTime = estimationLoopTime;
		estimationLoopTime = newEstimationLoopTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__ESTIMATION_LOOP_TIME, oldEstimationLoopTime, estimationLoopTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION:
				return basicSetRecommendationConfiguration(null, msgs);
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION:
				return basicSetOptimizationConfiguration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME:
				return getRecommendationLoopTime();
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME:
				return getOptimizationLoopTime();
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME:
				return getSelectionLoopTime();
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION:
				return getRecommendationConfiguration();
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION:
				return getOptimizationConfiguration();
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__ESTIMATION_LOOP_TIME:
				return getEstimationLoopTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME:
				setRecommendationLoopTime((Long)newValue);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME:
				setOptimizationLoopTime((Long)newValue);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME:
				setSelectionLoopTime((Long)newValue);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION:
				setRecommendationConfiguration((RecommendationTrainingConfiguration)newValue);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION:
				setOptimizationConfiguration((OptimizationConfiguration)newValue);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__ESTIMATION_LOOP_TIME:
				setEstimationLoopTime((Long)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME:
				setRecommendationLoopTime(RECOMMENDATION_LOOP_TIME_EDEFAULT);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME:
				setOptimizationLoopTime(OPTIMIZATION_LOOP_TIME_EDEFAULT);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME:
				setSelectionLoopTime(SELECTION_LOOP_TIME_EDEFAULT);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION:
				setRecommendationConfiguration((RecommendationTrainingConfiguration)null);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION:
				setOptimizationConfiguration((OptimizationConfiguration)null);
				return;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__ESTIMATION_LOOP_TIME:
				setEstimationLoopTime(ESTIMATION_LOOP_TIME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME:
				return recommendationLoopTime != RECOMMENDATION_LOOP_TIME_EDEFAULT;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME:
				return optimizationLoopTime != OPTIMIZATION_LOOP_TIME_EDEFAULT;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME:
				return selectionLoopTime != SELECTION_LOOP_TIME_EDEFAULT;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION:
				return recommendationConfiguration != null;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION:
				return optimizationConfiguration != null;
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__ESTIMATION_LOOP_TIME:
				return estimationLoopTime != ESTIMATION_LOOP_TIME_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (recommendationLoopTime: ");
		result.append(recommendationLoopTime);
		result.append(", optimizationLoopTime: ");
		result.append(optimizationLoopTime);
		result.append(", selectionLoopTime: ");
		result.append(selectionLoopTime);
		result.append(", estimationLoopTime: ");
		result.append(estimationLoopTime);
		result.append(')');
		return result.toString();
	}

} //LifeCycleConfigurationImpl
