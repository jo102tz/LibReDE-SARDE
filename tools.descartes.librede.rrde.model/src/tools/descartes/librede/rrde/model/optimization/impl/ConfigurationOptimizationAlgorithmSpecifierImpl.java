/**
 */
package tools.descartes.librede.rrde.model.optimization.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Optimization Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.ConfigurationOptimizationAlgorithmSpecifierImpl#getTimeOut <em>Time Out</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.ConfigurationOptimizationAlgorithmSpecifierImpl#getAlgorithmName <em>Algorithm Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationOptimizationAlgorithmSpecifierImpl extends MinimalEObjectImpl.Container implements ConfigurationOptimizationAlgorithmSpecifier {
	/**
	 * The default value of the '{@link #getTimeOut() <em>Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOut()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_OUT_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getTimeOut() <em>Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOut()
	 * @generated
	 * @ordered
	 */
	protected long timeOut = TIME_OUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlgorithmName() <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithmName() <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected String algorithmName = ALGORITHM_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationOptimizationAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeOut() {
		return timeOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeOut(long newTimeOut) {
		long oldTimeOut = timeOut;
		timeOut = newTimeOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT, oldTimeOut, timeOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithmName() {
		return algorithmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithmName(String newAlgorithmName) {
		String oldAlgorithmName = algorithmName;
		algorithmName = newAlgorithmName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME, oldAlgorithmName, algorithmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT:
				return getTimeOut();
			case OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME:
				return getAlgorithmName();
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
			case OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT:
				setTimeOut((Long)newValue);
				return;
			case OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME:
				setAlgorithmName((String)newValue);
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
			case OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT:
				setTimeOut(TIME_OUT_EDEFAULT);
				return;
			case OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME:
				setAlgorithmName(ALGORITHM_NAME_EDEFAULT);
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
			case OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT:
				return timeOut != TIME_OUT_EDEFAULT;
			case OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME:
				return ALGORITHM_NAME_EDEFAULT == null ? algorithmName != null : !ALGORITHM_NAME_EDEFAULT.equals(algorithmName);
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
		result.append(" (timeOut: ");
		result.append(timeOut);
		result.append(", algorithmName: ");
		result.append(algorithmName);
		result.append(')');
		return result.toString();
	}

} //ConfigurationOptimizationAlgorithmSpecifierImpl
