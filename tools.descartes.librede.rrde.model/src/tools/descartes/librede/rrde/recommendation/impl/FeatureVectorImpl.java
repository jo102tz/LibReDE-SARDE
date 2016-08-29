/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

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
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationMean <em>Utilization Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationVariance <em>Utilization Variance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getTraces <em>Traces</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getVarianceInflationFactor <em>Variance Inflation Factor</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationMin <em>Utilization Min</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationMax <em>Utilization Max</em>}</li>
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
	 * The default value of the '{@link #getUtilizationMean() <em>Utilization Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationMean()
	 * @generated
	 * @ordered
	 */
	protected static final double UTILIZATION_MEAN_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getUtilizationMean() <em>Utilization Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationMean()
	 * @generated
	 * @ordered
	 */
	protected double utilizationMean = UTILIZATION_MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getUtilizationVariance() <em>Utilization Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationVariance()
	 * @generated
	 * @ordered
	 */
	protected static final double UTILIZATION_VARIANCE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getUtilizationVariance() <em>Utilization Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationVariance()
	 * @generated
	 * @ordered
	 */
	protected double utilizationVariance = UTILIZATION_VARIANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTraces() <em>Traces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraces()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceFeatures> traces;

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
	 * The default value of the '{@link #getUtilizationMin() <em>Utilization Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationMin()
	 * @generated
	 * @ordered
	 */
	protected static final double UTILIZATION_MIN_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getUtilizationMin() <em>Utilization Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationMin()
	 * @generated
	 * @ordered
	 */
	protected double utilizationMin = UTILIZATION_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getUtilizationMax() <em>Utilization Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationMax()
	 * @generated
	 * @ordered
	 */
	protected static final double UTILIZATION_MAX_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getUtilizationMax() <em>Utilization Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationMax()
	 * @generated
	 * @ordered
	 */
	protected double utilizationMax = UTILIZATION_MAX_EDEFAULT;

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
	public double getUtilizationMean() {
		return utilizationMean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationMean(double newUtilizationMean) {
		double oldUtilizationMean = utilizationMean;
		utilizationMean = newUtilizationMean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MEAN, oldUtilizationMean, utilizationMean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUtilizationVariance() {
		return utilizationVariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationVariance(double newUtilizationVariance) {
		double oldUtilizationVariance = utilizationVariance;
		utilizationVariance = newUtilizationVariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_VARIANCE, oldUtilizationVariance, utilizationVariance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceFeatures> getTraces() {
		if (traces == null) {
			traces = new EObjectResolvingEList<TraceFeatures>(TraceFeatures.class, this, RecommendationPackage.FEATURE_VECTOR__TRACES);
		}
		return traces;
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
	public double getUtilizationMin() {
		return utilizationMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationMin(double newUtilizationMin) {
		double oldUtilizationMin = utilizationMin;
		utilizationMin = newUtilizationMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MIN, oldUtilizationMin, utilizationMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUtilizationMax() {
		return utilizationMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationMax(double newUtilizationMax) {
		double oldUtilizationMax = utilizationMax;
		utilizationMax = newUtilizationMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MAX, oldUtilizationMax, utilizationMax));
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
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MEAN:
				return getUtilizationMean();
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_VARIANCE:
				return getUtilizationVariance();
			case RecommendationPackage.FEATURE_VECTOR__TRACES:
				return getTraces();
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				return getVarianceInflationFactor();
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MIN:
				return getUtilizationMin();
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MAX:
				return getUtilizationMax();
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
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MEAN:
				setUtilizationMean((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_VARIANCE:
				setUtilizationVariance((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__TRACES:
				getTraces().clear();
				getTraces().addAll((Collection<? extends TraceFeatures>)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				setVarianceInflationFactor((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MIN:
				setUtilizationMin((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MAX:
				setUtilizationMax((Double)newValue);
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
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MEAN:
				setUtilizationMean(UTILIZATION_MEAN_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_VARIANCE:
				setUtilizationVariance(UTILIZATION_VARIANCE_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__TRACES:
				getTraces().clear();
				return;
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				setVarianceInflationFactor(VARIANCE_INFLATION_FACTOR_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MIN:
				setUtilizationMin(UTILIZATION_MIN_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MAX:
				setUtilizationMax(UTILIZATION_MAX_EDEFAULT);
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
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MEAN:
				return utilizationMean != UTILIZATION_MEAN_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_VARIANCE:
				return utilizationVariance != UTILIZATION_VARIANCE_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__TRACES:
				return traces != null && !traces.isEmpty();
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				return varianceInflationFactor != VARIANCE_INFLATION_FACTOR_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MIN:
				return utilizationMin != UTILIZATION_MIN_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_MAX:
				return utilizationMax != UTILIZATION_MAX_EDEFAULT;
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
		result.append(", utilizationMean: ");
		result.append(utilizationMean);
		result.append(", utilizationVariance: ");
		result.append(utilizationVariance);
		result.append(", varianceInflationFactor: ");
		result.append(varianceInflationFactor);
		result.append(", utilizationMin: ");
		result.append(utilizationMin);
		result.append(", utilizationMax: ");
		result.append(utilizationMax);
		result.append(')');
		return result.toString();
	}

} //FeatureVectorImpl
