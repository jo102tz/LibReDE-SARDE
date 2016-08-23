/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Extractor Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureExtractorSpecifierImpl#getFeatureExtractor <em>Feature Extractor</em>}</li>
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER__FEATURE_EXTRACTOR:
				return getFeatureExtractor();
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
