/**
 */
package tools.descartes.librede.rrde.model.lifecycle.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Life Cycle Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.impl.LifeCycleConfigurationImpl#getRecommendationLoopTime <em>Recommendation Loop Time</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.impl.LifeCycleConfigurationImpl#getOptimizationLoopTime <em>Optimization Loop Time</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.impl.LifeCycleConfigurationImpl#getSelectionLoopTime <em>Selection Loop Time</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.impl.LifeCycleConfigurationImpl#getRecommendationConfiguration <em>Recommendation Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.lifecycle.impl.LifeCycleConfigurationImpl#getOptimizationConfiguration <em>Optimization Configuration</em>}</li>
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
	 * The cached value of the '{@link #getRecommendationConfiguration() <em>Recommendation Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecommendationConfiguration()
	 * @generated
	 * @ordered
	 */
	protected RecommendationTrainingConfiguration recommendationConfiguration;

	/**
	 * The cached value of the '{@link #getOptimizationConfiguration() <em>Optimization Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizationConfiguration()
	 * @generated
	 * @ordered
	 */
	protected OptimizationConfiguration optimizationConfiguration;

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
		if (recommendationConfiguration != null && recommendationConfiguration.eIsProxy()) {
			InternalEObject oldRecommendationConfiguration = (InternalEObject)recommendationConfiguration;
			recommendationConfiguration = (RecommendationTrainingConfiguration)eResolveProxy(oldRecommendationConfiguration);
			if (recommendationConfiguration != oldRecommendationConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION, oldRecommendationConfiguration, recommendationConfiguration));
			}
		}
		return recommendationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationTrainingConfiguration basicGetRecommendationConfiguration() {
		return recommendationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecommendationConfiguration(RecommendationTrainingConfiguration newRecommendationConfiguration) {
		RecommendationTrainingConfiguration oldRecommendationConfiguration = recommendationConfiguration;
		recommendationConfiguration = newRecommendationConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION, oldRecommendationConfiguration, recommendationConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationConfiguration getOptimizationConfiguration() {
		if (optimizationConfiguration != null && optimizationConfiguration.eIsProxy()) {
			InternalEObject oldOptimizationConfiguration = (InternalEObject)optimizationConfiguration;
			optimizationConfiguration = (OptimizationConfiguration)eResolveProxy(oldOptimizationConfiguration);
			if (optimizationConfiguration != oldOptimizationConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION, oldOptimizationConfiguration, optimizationConfiguration));
			}
		}
		return optimizationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationConfiguration basicGetOptimizationConfiguration() {
		return optimizationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimizationConfiguration(OptimizationConfiguration newOptimizationConfiguration) {
		OptimizationConfiguration oldOptimizationConfiguration = optimizationConfiguration;
		optimizationConfiguration = newOptimizationConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION, oldOptimizationConfiguration, optimizationConfiguration));
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
				if (resolve) return getRecommendationConfiguration();
				return basicGetRecommendationConfiguration();
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION:
				if (resolve) return getOptimizationConfiguration();
				return basicGetOptimizationConfiguration();
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
		result.append(')');
		return result.toString();
	}

} //LifeCycleConfigurationImpl
