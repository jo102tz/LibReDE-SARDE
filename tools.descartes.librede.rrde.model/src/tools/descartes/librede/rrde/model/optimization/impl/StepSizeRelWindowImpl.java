/**
 */
package tools.descartes.librede.rrde.model.optimization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Step Size Rel Window</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.StepSizeRelWindowImpl#getProductMaxValue <em>Product Max Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StepSizeRelWindowImpl extends StepSizeImpl implements StepSizeRelWindow {
	/**
	 * The default value of the '{@link #getProductMaxValue() <em>Product Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final double PRODUCT_MAX_VALUE_EDEFAULT = 10000.0;

	/**
	 * The cached value of the '{@link #getProductMaxValue() <em>Product Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductMaxValue()
	 * @generated
	 * @ordered
	 */
	protected double productMaxValue = PRODUCT_MAX_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepSizeRelWindowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.STEP_SIZE_REL_WINDOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProductMaxValue() {
		return productMaxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductMaxValue(double newProductMaxValue) {
		double oldProductMaxValue = productMaxValue;
		productMaxValue = newProductMaxValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.STEP_SIZE_REL_WINDOW__PRODUCT_MAX_VALUE, oldProductMaxValue, productMaxValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.STEP_SIZE_REL_WINDOW__PRODUCT_MAX_VALUE:
				return getProductMaxValue();
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
			case OptimizationPackage.STEP_SIZE_REL_WINDOW__PRODUCT_MAX_VALUE:
				setProductMaxValue((Double)newValue);
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
			case OptimizationPackage.STEP_SIZE_REL_WINDOW__PRODUCT_MAX_VALUE:
				setProductMaxValue(PRODUCT_MAX_VALUE_EDEFAULT);
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
			case OptimizationPackage.STEP_SIZE_REL_WINDOW__PRODUCT_MAX_VALUE:
				return productMaxValue != PRODUCT_MAX_VALUE_EDEFAULT;
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
		result.append(" (productMaxValue: ");
		result.append(productMaxValue);
		result.append(')');
		return result.toString();
	}

} //StepSizeRelWindowImpl
