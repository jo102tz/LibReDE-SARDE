/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import tools.descartes.librede.rrde.recommendation.GradientTreeBoostTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gradient Tree Boost Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.GradientTreeBoostTradeOffAlgorithmSpecifierImpl#getIterationNumber <em>Iteration Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GradientTreeBoostTradeOffAlgorithmSpecifierImpl extends RecommendationTradeOffAlgorithmSpecifierImpl implements GradientTreeBoostTradeOffAlgorithmSpecifier {
	/**
	 * The default value of the '{@link #getIterationNumber() <em>Iteration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int ITERATION_NUMBER_EDEFAULT = 100;
	/**
	 * The cached value of the '{@link #getIterationNumber() <em>Iteration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationNumber()
	 * @generated
	 * @ordered
	 */
	protected int iterationNumber = ITERATION_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GradientTreeBoostTradeOffAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.GRADIENT_TREE_BOOST_TRADE_OFF_ALGORITHM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIterationNumber() {
		return iterationNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterationNumber(int newIterationNumber) {
		int oldIterationNumber = iterationNumber;
		iterationNumber = newIterationNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.GRADIENT_TREE_BOOST_TRADE_OFF_ALGORITHM_SPECIFIER__ITERATION_NUMBER, oldIterationNumber, iterationNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.GRADIENT_TREE_BOOST_TRADE_OFF_ALGORITHM_SPECIFIER__ITERATION_NUMBER:
				return getIterationNumber();
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
			case RecommendationPackage.GRADIENT_TREE_BOOST_TRADE_OFF_ALGORITHM_SPECIFIER__ITERATION_NUMBER:
				setIterationNumber((Integer)newValue);
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
			case RecommendationPackage.GRADIENT_TREE_BOOST_TRADE_OFF_ALGORITHM_SPECIFIER__ITERATION_NUMBER:
				setIterationNumber(ITERATION_NUMBER_EDEFAULT);
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
			case RecommendationPackage.GRADIENT_TREE_BOOST_TRADE_OFF_ALGORITHM_SPECIFIER__ITERATION_NUMBER:
				return iterationNumber != ITERATION_NUMBER_EDEFAULT;
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
		result.append(" (iterationNumber: ");
		result.append(iterationNumber);
		result.append(')');
		return result.toString();
	}

} //GradientTreeBoostTradeOffAlgorithmSpecifierImpl
