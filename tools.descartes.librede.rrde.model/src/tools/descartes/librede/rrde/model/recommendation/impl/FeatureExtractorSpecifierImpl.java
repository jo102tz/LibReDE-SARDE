/**
 */
package tools.descartes.librede.rrde.model.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;

import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.Unit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Extractor Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.FeatureExtractorSpecifierImpl#getFeatureExtractor <em>Feature Extractor</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.FeatureExtractorSpecifierImpl#getRateUnit <em>Rate Unit</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.FeatureExtractorSpecifierImpl#getAggregation <em>Aggregation</em>}</li>
 * </ul>
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
	 * The cached value of the '{@link #getRateUnit() <em>Rate Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRateUnit()
	 * @generated
	 * @ordered
	 */
	protected Unit<?> rateUnit;

	/**
	 * The cached value of the '{@link #getAggregation() <em>Aggregation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregation()
	 * @generated
	 * @ordered
	 */
	protected Quantity<Time> aggregation;

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
	public Quantity<Time> getAggregation() {
		return aggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregation(Quantity<Time> newAggregation, NotificationChain msgs) {
		Quantity<Time> oldAggregation = aggregation;
		aggregation = newAggregation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION, oldAggregation, newAggregation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregation(Quantity<Time> newAggregation) {
		if (newAggregation != aggregation) {
			NotificationChain msgs = null;
			if (aggregation != null)
				msgs = ((InternalEObject)aggregation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION, null, msgs);
			if (newAggregation != null)
				msgs = ((InternalEObject)newAggregation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION, null, msgs);
			msgs = basicSetAggregation(newAggregation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION, newAggregation, newAggregation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION:
				return basicSetAggregation(null, msgs);
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
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR:
				return getFeatureExtractor();
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT:
				if (resolve) return getRateUnit();
				return basicGetRateUnit();
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION:
				return getAggregation();
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
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR:
				setFeatureExtractor((String)newValue);
				return;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT:
				setRateUnit((Unit<?>)newValue);
				return;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION:
				setAggregation((Quantity<Time>)newValue);
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
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT:
				setRateUnit((Unit<?>)null);
				return;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION:
				setAggregation((Quantity<Time>)null);
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
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__RATE_UNIT:
				return rateUnit != null;
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__AGGREGATION:
				return aggregation != null;
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
		result.append(')');
		return result.toString();
	}

} //FeatureExtractorSpecifierImpl
