/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

import tools.descartes.librede.units.Unit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Extractor Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureExtractorSpecifierImpl#getFeatureExtractor <em>Feature Extractor</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureExtractorSpecifierImpl#getTimeUnit <em>Time Unit</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureExtractorSpecifierImpl#getAggregationInterval <em>Aggregation Interval</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureExtractorSpecifierImpl#getRateUnit <em>Rate Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureExtractorSpecifierImpl extends MinimalEObjectImpl.Container implements FeatureExtractorSpecifier {
	/**
	 * The default value of the '{@link #getFeatureExtractor() <em>Feature Extractor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureExtractor()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_EXTRACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureExtractor() <em>Feature Extractor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureExtractor()
	 * @generated
	 * @ordered
	 */
	protected String featureExtractor = FEATURE_EXTRACTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimeUnit() <em>Time Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeUnit()
	 * @generated
	 * @ordered
	 */
	protected Unit<?> timeUnit;

	/**
	 * The default value of the '{@link #getAggregationInterval() <em>Aggregation Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationInterval()
	 * @generated
	 * @ordered
	 */
	protected static final int AGGREGATION_INTERVAL_EDEFAULT = 60000;

	/**
	 * The cached value of the '{@link #getAggregationInterval() <em>Aggregation Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationInterval()
	 * @generated
	 * @ordered
	 */
	protected int aggregationInterval = AGGREGATION_INTERVAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRateUnit() <em>Rate Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRateUnit()
	 * @generated
	 * @ordered
	 */
	protected Unit<?> rateUnit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureExtractorSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.FEATURE_EXTRACTOR_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureExtractor() {
		return featureExtractor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureExtractor(String newFeatureExtractor) {
		String oldFeatureExtractor = featureExtractor;
		featureExtractor = newFeatureExtractor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR, oldFeatureExtractor, featureExtractor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit<?> getTimeUnit() {
		if (timeUnit != null && timeUnit.eIsProxy()) {
			InternalEObject oldTimeUnit = (InternalEObject)timeUnit;
			timeUnit = (Unit<?>)eResolveProxy(oldTimeUnit);
			if (timeUnit != oldTimeUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__TIME_UNIT, oldTimeUnit, timeUnit));
			}
		}
		return timeUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit<?> basicGetTimeUnit() {
		return timeUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeUnit(Unit<?> newTimeUnit) {
		Unit<?> oldTimeUnit = timeUnit;
		timeUnit = newTimeUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__TIME_UNIT, oldTimeUnit, timeUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAggregationInterval() {
		return aggregationInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregationInterval(int newAggregationInterval) {
		int oldAggregationInterval = aggregationInterval;
		aggregationInterval = newAggregationInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION_INTERVAL, oldAggregationInterval, aggregationInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit<?> getRateUnit() {
		if (rateUnit != null && rateUnit.eIsProxy()) {
			InternalEObject oldRateUnit = (InternalEObject)rateUnit;
			rateUnit = (Unit<?>)eResolveProxy(oldRateUnit);
			if (rateUnit != oldRateUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT, oldRateUnit, rateUnit));
			}
		}
		return rateUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit<?> basicGetRateUnit() {
		return rateUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRateUnit(Unit<?> newRateUnit) {
		Unit<?> oldRateUnit = rateUnit;
		rateUnit = newRateUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT, oldRateUnit, rateUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR:
				return getFeatureExtractor();
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__TIME_UNIT:
				if (resolve) return getTimeUnit();
				return basicGetTimeUnit();
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION_INTERVAL:
				return getAggregationInterval();
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT:
				if (resolve) return getRateUnit();
				return basicGetRateUnit();
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
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR:
				setFeatureExtractor((String)newValue);
				return;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__TIME_UNIT:
				setTimeUnit((Unit<?>)newValue);
				return;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION_INTERVAL:
				setAggregationInterval((Integer)newValue);
				return;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT:
				setRateUnit((Unit<?>)newValue);
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
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR:
				setFeatureExtractor(FEATURE_EXTRACTOR_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__TIME_UNIT:
				setTimeUnit((Unit<?>)null);
				return;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION_INTERVAL:
				setAggregationInterval(AGGREGATION_INTERVAL_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT:
				setRateUnit((Unit<?>)null);
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
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR:
				return FEATURE_EXTRACTOR_EDEFAULT == null ? featureExtractor != null : !FEATURE_EXTRACTOR_EDEFAULT.equals(featureExtractor);
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__TIME_UNIT:
				return timeUnit != null;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION_INTERVAL:
				return aggregationInterval != AGGREGATION_INTERVAL_EDEFAULT;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT:
				return rateUnit != null;
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
		result.append(" (featureExtractor: ");
		result.append(featureExtractor);
		result.append(", aggregationInterval: ");
		result.append(aggregationInterval);
		result.append(')');
		return result.toString();
	}

} //FeatureExtractorSpecifierImpl
