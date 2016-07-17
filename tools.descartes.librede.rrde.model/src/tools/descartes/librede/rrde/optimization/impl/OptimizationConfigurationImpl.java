/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.optimization.RunCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.OptimizationConfigurationImpl#getContainsOf <em>Contains Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptimizationConfigurationImpl extends MinimalEObjectImpl.Container implements OptimizationConfiguration {
	/**
	 * The cached value of the '{@link #getContainsOf() <em>Contains Of</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainsOf()
	 * @generated
	 * @ordered
	 */
	protected EList<RunCall> containsOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimizationConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.OPTIMIZATION_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RunCall> getContainsOf() {
		if (containsOf == null) {
			containsOf = new EObjectContainmentEList<RunCall>(RunCall.class, this, OptimizationPackage.OPTIMIZATION_CONFIGURATION__CONTAINS_OF);
		}
		return containsOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptimizationPackage.OPTIMIZATION_CONFIGURATION__CONTAINS_OF:
				return ((InternalEList<?>)getContainsOf()).basicRemove(otherEnd, msgs);
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
			case OptimizationPackage.OPTIMIZATION_CONFIGURATION__CONTAINS_OF:
				return getContainsOf();
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
			case OptimizationPackage.OPTIMIZATION_CONFIGURATION__CONTAINS_OF:
				getContainsOf().clear();
				getContainsOf().addAll((Collection<? extends RunCall>)newValue);
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
			case OptimizationPackage.OPTIMIZATION_CONFIGURATION__CONTAINS_OF:
				getContainsOf().clear();
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
			case OptimizationPackage.OPTIMIZATION_CONFIGURATION__CONTAINS_OF:
				return containsOf != null && !containsOf.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OptimizationConfigurationImpl
