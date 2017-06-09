/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import tools.descartes.librede.rrde.recommendation.LASSOTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LASSO Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.LASSOTradeOffAlgorithmSpecifierImpl#getLambda <em>Lambda</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LASSOTradeOffAlgorithmSpecifierImpl extends RecommendationTradeOffAlgorithmSpecifierImpl implements LASSOTradeOffAlgorithmSpecifier {
	/**
	 * The default value of the '{@link #getLambda() <em>Lambda</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLambda()
	 * @generated
	 * @ordered
	 */
	protected static final double LAMBDA_EDEFAULT = 1.0;
	/**
	 * The cached value of the '{@link #getLambda() <em>Lambda</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLambda()
	 * @generated
	 * @ordered
	 */
	protected double lambda = LAMBDA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LASSOTradeOffAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.LASSO_TRADE_OFF_ALGORITHM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLambda() {
		return lambda;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLambda(double newLambda) {
		double oldLambda = lambda;
		lambda = newLambda;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.LASSO_TRADE_OFF_ALGORITHM_SPECIFIER__LAMBDA, oldLambda, lambda));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.LASSO_TRADE_OFF_ALGORITHM_SPECIFIER__LAMBDA:
				return getLambda();
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
			case RecommendationPackage.LASSO_TRADE_OFF_ALGORITHM_SPECIFIER__LAMBDA:
				setLambda((Double)newValue);
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
			case RecommendationPackage.LASSO_TRADE_OFF_ALGORITHM_SPECIFIER__LAMBDA:
				setLambda(LAMBDA_EDEFAULT);
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
			case RecommendationPackage.LASSO_TRADE_OFF_ALGORITHM_SPECIFIER__LAMBDA:
				return lambda != LAMBDA_EDEFAULT;
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
		result.append(" (lambda: ");
		result.append(lambda);
		result.append(')');
		return result.toString();
	}

} //LASSOTradeOffAlgorithmSpecifierImpl
