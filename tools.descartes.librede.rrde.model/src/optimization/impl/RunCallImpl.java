/**
 */
package optimization.impl;

import java.util.Collection;
import optimization.IAlgorithm;
import optimization.InputData;
import optimization.OptimizationPackage;
import optimization.RunCall;
import optimization.Settings;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Run Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link optimization.impl.RunCallImpl#getExecutes <em>Executes</em>}</li>
 *   <li>{@link optimization.impl.RunCallImpl#getExecutesOn <em>Executes On</em>}</li>
 *   <li>{@link optimization.impl.RunCallImpl#getSpecifiedBy <em>Specified By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RunCallImpl extends MinimalEObjectImpl.Container implements RunCall {
	/**
	 * The cached value of the '{@link #getExecutes() <em>Executes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutes()
	 * @generated
	 * @ordered
	 */
	protected IAlgorithm executes;

	/**
	 * The cached value of the '{@link #getExecutesOn() <em>Executes On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutesOn()
	 * @generated
	 * @ordered
	 */
	protected EList<InputData> executesOn;

	/**
	 * The cached value of the '{@link #getSpecifiedBy() <em>Specified By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedBy()
	 * @generated
	 * @ordered
	 */
	protected Settings specifiedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.RUN_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAlgorithm getExecutes() {
		if (executes != null && executes.eIsProxy()) {
			InternalEObject oldExecutes = (InternalEObject)executes;
			executes = (IAlgorithm)eResolveProxy(oldExecutes);
			if (executes != oldExecutes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptimizationPackage.RUN_CALL__EXECUTES, oldExecutes, executes));
			}
		}
		return executes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAlgorithm basicGetExecutes() {
		return executes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutes(IAlgorithm newExecutes) {
		IAlgorithm oldExecutes = executes;
		executes = newExecutes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__EXECUTES, oldExecutes, executes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputData> getExecutesOn() {
		if (executesOn == null) {
			executesOn = new EObjectResolvingEList<InputData>(InputData.class, this, OptimizationPackage.RUN_CALL__EXECUTES_ON);
		}
		return executesOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Settings getSpecifiedBy() {
		if (specifiedBy != null && specifiedBy.eIsProxy()) {
			InternalEObject oldSpecifiedBy = (InternalEObject)specifiedBy;
			specifiedBy = (Settings)eResolveProxy(oldSpecifiedBy);
			if (specifiedBy != oldSpecifiedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptimizationPackage.RUN_CALL__SPECIFIED_BY, oldSpecifiedBy, specifiedBy));
			}
		}
		return specifiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Settings basicGetSpecifiedBy() {
		return specifiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifiedBy(Settings newSpecifiedBy) {
		Settings oldSpecifiedBy = specifiedBy;
		specifiedBy = newSpecifiedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__SPECIFIED_BY, oldSpecifiedBy, specifiedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.RUN_CALL__EXECUTES:
				if (resolve) return getExecutes();
				return basicGetExecutes();
			case OptimizationPackage.RUN_CALL__EXECUTES_ON:
				return getExecutesOn();
			case OptimizationPackage.RUN_CALL__SPECIFIED_BY:
				if (resolve) return getSpecifiedBy();
				return basicGetSpecifiedBy();
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
			case OptimizationPackage.RUN_CALL__EXECUTES:
				setExecutes((IAlgorithm)newValue);
				return;
			case OptimizationPackage.RUN_CALL__EXECUTES_ON:
				getExecutesOn().clear();
				getExecutesOn().addAll((Collection<? extends InputData>)newValue);
				return;
			case OptimizationPackage.RUN_CALL__SPECIFIED_BY:
				setSpecifiedBy((Settings)newValue);
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
			case OptimizationPackage.RUN_CALL__EXECUTES:
				setExecutes((IAlgorithm)null);
				return;
			case OptimizationPackage.RUN_CALL__EXECUTES_ON:
				getExecutesOn().clear();
				return;
			case OptimizationPackage.RUN_CALL__SPECIFIED_BY:
				setSpecifiedBy((Settings)null);
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
			case OptimizationPackage.RUN_CALL__EXECUTES:
				return executes != null;
			case OptimizationPackage.RUN_CALL__EXECUTES_ON:
				return executesOn != null && !executesOn.isEmpty();
			case OptimizationPackage.RUN_CALL__SPECIFIED_BY:
				return specifiedBy != null;
		}
		return super.eIsSet(featureID);
	}

} //RunCallImpl
