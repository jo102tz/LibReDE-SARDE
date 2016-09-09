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
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;

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
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationStatistics <em>Utilization Statistics</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getResponseTimeStatistics <em>Response Time Statistics</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getArrivalTimeStatistics <em>Arrival Time Statistics</em>}</li>
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
	 * The cached value of the '{@link #getUtilizationStatistics() <em>Utilization Statistics</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationStatistics()
	 * @generated
	 * @ordered
	 */
	protected StatisticalFeatures utilizationStatistics;

	/**
	 * The cached value of the '{@link #getResponseTimeStatistics() <em>Response Time Statistics</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseTimeStatistics()
	 * @generated
	 * @ordered
	 */
	protected StatisticalFeatures responseTimeStatistics;

	/**
	 * The cached value of the '{@link #getArrivalTimeStatistics() <em>Arrival Time Statistics</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalTimeStatistics()
	 * @generated
	 * @ordered
	 */
	protected StatisticalFeatures arrivalTimeStatistics;

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
	public StatisticalFeatures getUtilizationStatistics() {
		if (utilizationStatistics != null && utilizationStatistics.eIsProxy()) {
			InternalEObject oldUtilizationStatistics = (InternalEObject)utilizationStatistics;
			utilizationStatistics = (StatisticalFeatures)eResolveProxy(oldUtilizationStatistics);
			if (utilizationStatistics != oldUtilizationStatistics) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS, oldUtilizationStatistics, utilizationStatistics));
			}
		}
		return utilizationStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeatures basicGetUtilizationStatistics() {
		return utilizationStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationStatistics(StatisticalFeatures newUtilizationStatistics) {
		StatisticalFeatures oldUtilizationStatistics = utilizationStatistics;
		utilizationStatistics = newUtilizationStatistics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS, oldUtilizationStatistics, utilizationStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeatures getResponseTimeStatistics() {
		if (responseTimeStatistics != null && responseTimeStatistics.eIsProxy()) {
			InternalEObject oldResponseTimeStatistics = (InternalEObject)responseTimeStatistics;
			responseTimeStatistics = (StatisticalFeatures)eResolveProxy(oldResponseTimeStatistics);
			if (responseTimeStatistics != oldResponseTimeStatistics) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS, oldResponseTimeStatistics, responseTimeStatistics));
			}
		}
		return responseTimeStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeatures basicGetResponseTimeStatistics() {
		return responseTimeStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseTimeStatistics(StatisticalFeatures newResponseTimeStatistics) {
		StatisticalFeatures oldResponseTimeStatistics = responseTimeStatistics;
		responseTimeStatistics = newResponseTimeStatistics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS, oldResponseTimeStatistics, responseTimeStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeatures getArrivalTimeStatistics() {
		if (arrivalTimeStatistics != null && arrivalTimeStatistics.eIsProxy()) {
			InternalEObject oldArrivalTimeStatistics = (InternalEObject)arrivalTimeStatistics;
			arrivalTimeStatistics = (StatisticalFeatures)eResolveProxy(oldArrivalTimeStatistics);
			if (arrivalTimeStatistics != oldArrivalTimeStatistics) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_STATISTICS, oldArrivalTimeStatistics, arrivalTimeStatistics));
			}
		}
		return arrivalTimeStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeatures basicGetArrivalTimeStatistics() {
		return arrivalTimeStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrivalTimeStatistics(StatisticalFeatures newArrivalTimeStatistics) {
		StatisticalFeatures oldArrivalTimeStatistics = arrivalTimeStatistics;
		arrivalTimeStatistics = newArrivalTimeStatistics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_STATISTICS, oldArrivalTimeStatistics, arrivalTimeStatistics));
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
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS:
				if (resolve) return getUtilizationStatistics();
				return basicGetUtilizationStatistics();
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS:
				if (resolve) return getResponseTimeStatistics();
				return basicGetResponseTimeStatistics();
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_STATISTICS:
				if (resolve) return getArrivalTimeStatistics();
				return basicGetArrivalTimeStatistics();
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
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS:
				setUtilizationStatistics((StatisticalFeatures)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS:
				setResponseTimeStatistics((StatisticalFeatures)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_STATISTICS:
				setArrivalTimeStatistics((StatisticalFeatures)newValue);
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
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS:
				setUtilizationStatistics((StatisticalFeatures)null);
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS:
				setResponseTimeStatistics((StatisticalFeatures)null);
				return;
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_STATISTICS:
				setArrivalTimeStatistics((StatisticalFeatures)null);
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
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS:
				return utilizationStatistics != null;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS:
				return responseTimeStatistics != null;
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_TIME_STATISTICS:
				return arrivalTimeStatistics != null;
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
