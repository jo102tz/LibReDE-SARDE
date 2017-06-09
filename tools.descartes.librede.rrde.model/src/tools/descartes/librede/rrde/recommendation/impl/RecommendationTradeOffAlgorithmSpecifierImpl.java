/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.RecommendationTradeOffAlgorithmSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationTradeOffAlgorithmSpecifierImpl#getTradeOffAlgorithmName <em>Trade Off Algorithm Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecommendationTradeOffAlgorithmSpecifierImpl extends RecommendationAlgorithmSpecifierImpl implements RecommendationTradeOffAlgorithmSpecifier {
	/**
	 * The default value of the '{@link #getTradeOffAlgorithmName() <em>Trade Off Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTradeOffAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected static final String TRADE_OFF_ALGORITHM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTradeOffAlgorithmName() <em>Trade Off Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTradeOffAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected String tradeOffAlgorithmName = TRADE_OFF_ALGORITHM_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationTradeOffAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.RECOMMENDATION_TRADE_OFF_ALGORITHM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTradeOffAlgorithmName() {
		return tradeOffAlgorithmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTradeOffAlgorithmName(String newTradeOffAlgorithmName) {
		String oldTradeOffAlgorithmName = tradeOffAlgorithmName;
		tradeOffAlgorithmName = newTradeOffAlgorithmName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.RECOMMENDATION_TRADE_OFF_ALGORITHM_SPECIFIER__TRADE_OFF_ALGORITHM_NAME, oldTradeOffAlgorithmName, tradeOffAlgorithmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.RECOMMENDATION_TRADE_OFF_ALGORITHM_SPECIFIER__TRADE_OFF_ALGORITHM_NAME:
				return getTradeOffAlgorithmName();
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
			case RecommendationPackage.RECOMMENDATION_TRADE_OFF_ALGORITHM_SPECIFIER__TRADE_OFF_ALGORITHM_NAME:
				setTradeOffAlgorithmName((String)newValue);
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
			case RecommendationPackage.RECOMMENDATION_TRADE_OFF_ALGORITHM_SPECIFIER__TRADE_OFF_ALGORITHM_NAME:
				setTradeOffAlgorithmName(TRADE_OFF_ALGORITHM_NAME_EDEFAULT);
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
			case RecommendationPackage.RECOMMENDATION_TRADE_OFF_ALGORITHM_SPECIFIER__TRADE_OFF_ALGORITHM_NAME:
				return TRADE_OFF_ALGORITHM_NAME_EDEFAULT == null ? tradeOffAlgorithmName != null : !TRADE_OFF_ALGORITHM_NAME_EDEFAULT.equals(tradeOffAlgorithmName);
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
		result.append(" (tradeOffAlgorithmName: ");
		result.append(tradeOffAlgorithmName);
		result.append(')');
		return result.toString();
	}

} //RecommendationTradeOffAlgorithmSpecifierImpl
