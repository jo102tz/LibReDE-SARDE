/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.TraceFeatures;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Vector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getNumberOfRessources <em>Number Of Ressources</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getNumberOfWorkloadClasses <em>Number Of Workload Classes</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getVarianceInflationFactor <em>Variance Inflation Factor</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationFeatures <em>Utilization Features</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getResponseTimeFeatures <em>Response Time Features</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getArrivalTimeFeatures <em>Arrival Time Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureVectorImpl extends MinimalEObjectImpl.Container implements FeatureVector {
	/**
	 * The default value of the '{@link #getNumberOfRessources() <em>Number Of Ressources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfRessources()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_RESSOURCES_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getNumberOfRessources() <em>Number Of Ressources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfRessources()
	 * @generated
	 * @ordered
	 */
	protected int numberOfRessources = NUMBER_OF_RESSOURCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfWorkloadClasses() <em>Number Of Workload Classes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfWorkloadClasses()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_WORKLOAD_CLASSES_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getNumberOfWorkloadClasses() <em>Number Of Workload Classes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfWorkloadClasses()
	 * @generated
	 * @ordered
	 */
	protected int numberOfWorkloadClasses = NUMBER_OF_WORKLOAD_CLASSES_EDEFAULT;

	/**
	 * The default value of the '{@link #getVarianceInflationFactor() <em>Variance Inflation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarianceInflationFactor()
	 * @generated
	 * @ordered
	 */
	protected static final double VARIANCE_INFLATION_FACTOR_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getVarianceInflationFactor() <em>Variance Inflation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarianceInflationFactor()
	 * @generated
	 * @ordered
	 */
	protected double varianceInflationFactor = VARIANCE_INFLATION_FACTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUtilizationFeatures() <em>Utilization Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationFeatures()
	 * @generated
	 * @ordered
	 */
	protected TraceFeatures utilizationFeatures;

	/**
	 * The cached value of the '{@link #getResponseTimeFeatures() <em>Response Time Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseTimeFeatures()
	 * @generated
	 * @ordered
	 */
	protected TraceFeatures responseTimeFeatures;

	/**
	 * The cached value of the '{@link #getArrivalTimeFeatures() <em>Arrival Time Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalTimeFeatures()
	 * @generated
	 * @ordered
	 */
	protected TraceFeatures arrivalTimeFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureVectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.FEATURE_VECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfRessources() {
		return numberOfRessources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfRessources(int newNumberOfRessources) {
		int oldNumberOfRessources = numberOfRessources;
		numberOfRessources = newNumberOfRessources;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES, oldNumberOfRessources, numberOfRessources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfWorkloadClasses() {
		return numberOfWorkloadClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfWorkloadClasses(int newNumberOfWorkloadClasses) {
		int oldNumberOfWorkloadClasses = numberOfWorkloadClasses;
		numberOfWorkloadClasses = newNumberOfWorkloadClasses;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES, oldNumberOfWorkloadClasses, numberOfWorkloadClasses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVarianceInflationFactor() {
		return varianceInflationFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarianceInflationFactor(double newVarianceInflationFactor) {
		double oldVarianceInflationFactor = varianceInflationFactor;
		varianceInflationFactor = newVarianceInflationFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR, oldVarianceInflationFactor, varianceInflationFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFeatures getUtilizationFeatures() {
		if (utilizationFeatures != null && utilizationFeatures.eIsProxy()) {
			InternalEObject oldUtilizationFeatures = (InternalEObject)utilizationFeatures;
			utilizationFeatures = (TraceFeatures)eResolveProxy(oldUtilizationFeatures);
			if (utilizationFeatures != oldUtilizationFeatures) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_FEATURES, oldUtilizationFeatures, utilizationFeatures));
			}
		}
		return utilizationFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFeatures basicGetUtilizationFeatures() {
		return utilizationFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationFeatures(TraceFeatures newUtilizationFeatures) {
		TraceFeatures oldUtilizationFeatures = utilizationFeatures;
		utilizationFeatures = newUtilizationFeatures;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_FEATURES, oldUtilizationFeatures, utilizationFeatures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFeatures getResponseTimeFeatures() {
		if (responseTimeFeatures != null && responseTimeFeatures.eIsProxy()) {
			InternalEObject oldResponseTimeFeatures = (InternalEObject)responseTimeFeatures;
			responseTimeFeatures = (TraceFeatures)eResolveProxy(oldResponseTimeFeatures);
			if (responseTimeFeatures != oldResponseTimeFeatures) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_FEATURES, oldResponseTimeFeatures, responseTimeFeatures));
			}
		}
		return responseTimeFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFeatures basicGetResponseTimeFeatures() {
		return responseTimeFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseTimeFeatures(TraceFeatures newResponseTimeFeatures) {
		TraceFeatures oldResponseTimeFeatures = responseTimeFeatures;
		responseTimeFeatures = newResponseTimeFeatures;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_FEATURES, oldResponseTimeFeatures, responseTimeFeatures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFeatures getArrivalTimeFeatures() {
		if (arrivalTimeFeatures != null && arrivalTimeFeatures.eIsProxy()) {
			InternalEObject oldArrivalTimeFeatures = (InternalEObject)arrivalTimeFeatures;
			arrivalTimeFeatures = (TraceFeatures)eResolveProxy(oldArrivalTimeFeatures);
			if (arrivalTimeFeatures != oldArrivalTimeFeatures) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_FEATURES, oldArrivalTimeFeatures, arrivalTimeFeatures));
			}
		}
		return arrivalTimeFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFeatures basicGetArrivalTimeFeatures() {
		return arrivalTimeFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrivalTimeFeatures(TraceFeatures newArrivalTimeFeatures) {
		TraceFeatures oldArrivalTimeFeatures = arrivalTimeFeatures;
		arrivalTimeFeatures = newArrivalTimeFeatures;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_FEATURES, oldArrivalTimeFeatures, arrivalTimeFeatures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES:
				return getNumberOfRessources();
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES:
				return getNumberOfWorkloadClasses();
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				return getVarianceInflationFactor();
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_FEATURES:
				if (resolve) return getUtilizationFeatures();
				return basicGetUtilizationFeatures();
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_FEATURES:
				if (resolve) return getResponseTimeFeatures();
				return basicGetResponseTimeFeatures();
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_FEATURES:
				if (resolve) return getArrivalTimeFeatures();
				return basicGetArrivalTimeFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES:
				setNumberOfRessources((Integer)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES:
				setNumberOfWorkloadClasses((Integer)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				setVarianceInflationFactor((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_FEATURES:
				setUtilizationFeatures((TraceFeatures)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_FEATURES:
				setResponseTimeFeatures((TraceFeatures)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_FEATURES:
				setArrivalTimeFeatures((TraceFeatures)newValue);
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
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES:
				setNumberOfRessources(NUMBER_OF_RESSOURCES_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES:
				setNumberOfWorkloadClasses(NUMBER_OF_WORKLOAD_CLASSES_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				setVarianceInflationFactor(VARIANCE_INFLATION_FACTOR_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_FEATURES:
				setUtilizationFeatures((TraceFeatures)null);
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_FEATURES:
				setResponseTimeFeatures((TraceFeatures)null);
				return;
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_FEATURES:
				setArrivalTimeFeatures((TraceFeatures)null);
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
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES:
				return numberOfRessources != NUMBER_OF_RESSOURCES_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES:
				return numberOfWorkloadClasses != NUMBER_OF_WORKLOAD_CLASSES_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				return varianceInflationFactor != VARIANCE_INFLATION_FACTOR_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_FEATURES:
				return utilizationFeatures != null;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_FEATURES:
				return responseTimeFeatures != null;
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_FEATURES:
				return arrivalTimeFeatures != null;
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
		result.append(" (numberOfRessources: ");
		result.append(numberOfRessources);
		result.append(", numberOfWorkloadClasses: ");
		result.append(numberOfWorkloadClasses);
		result.append(", varianceInflationFactor: ");
		result.append(varianceInflationFactor);
		result.append(')');
		return result.toString();
	}

} //FeatureVectorImpl
