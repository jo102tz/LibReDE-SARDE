/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import tools.descartes.librede.rrde.recommendation.GaussianProcessRegressionTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gaussian Process Regression Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.GaussianProcessRegressionTradeOffAlgorithmSpecifierImpl#getShrinkFactor <em>Shrink Factor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GaussianProcessRegressionTradeOffAlgorithmSpecifierImpl extends RecommendationTradeOffAlgorithmSpecifierImpl implements GaussianProcessRegressionTradeOffAlgorithmSpecifier {
	/**
	 * The default value of the '{@link #getShrinkFactor() <em>Shrink Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShrinkFactor()
	 * @generated
	 * @ordered
	 */
	protected static final double SHRINK_FACTOR_EDEFAULT = 0.5;
	/**
	 * The cached value of the '{@link #getShrinkFactor() <em>Shrink Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShrinkFactor()
	 * @generated
	 * @ordered
	 */
	protected double shrinkFactor = SHRINK_FACTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaussianProcessRegressionTradeOffAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.GAUSSIAN_PROCESS_REGRESSION_TRADE_OFF_ALGORITHM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getShrinkFactor() {
		return shrinkFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShrinkFactor(double newShrinkFactor) {
		double oldShrinkFactor = shrinkFactor;
		shrinkFactor = newShrinkFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.GAUSSIAN_PROCESS_REGRESSION_TRADE_OFF_ALGORITHM_SPECIFIER__SHRINK_FACTOR, oldShrinkFactor, shrinkFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.GAUSSIAN_PROCESS_REGRESSION_TRADE_OFF_ALGORITHM_SPECIFIER__SHRINK_FACTOR:
				return getShrinkFactor();
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
			case RecommendationPackage.GAUSSIAN_PROCESS_REGRESSION_TRADE_OFF_ALGORITHM_SPECIFIER__SHRINK_FACTOR:
				setShrinkFactor((Double)newValue);
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
			case RecommendationPackage.GAUSSIAN_PROCESS_REGRESSION_TRADE_OFF_ALGORITHM_SPECIFIER__SHRINK_FACTOR:
				setShrinkFactor(SHRINK_FACTOR_EDEFAULT);
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
			case RecommendationPackage.GAUSSIAN_PROCESS_REGRESSION_TRADE_OFF_ALGORITHM_SPECIFIER__SHRINK_FACTOR:
				return shrinkFactor != SHRINK_FACTOR_EDEFAULT;
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
		result.append(" (shrinkFactor: ");
		result.append(shrinkFactor);
		result.append(')');
		return result.toString();
	}

} //GaussianProcessRegressionTradeOffAlgorithmSpecifierImpl
