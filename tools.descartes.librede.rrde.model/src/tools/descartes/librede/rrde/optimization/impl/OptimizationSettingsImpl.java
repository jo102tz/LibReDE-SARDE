/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import tools.descartes.librede.configuration.ValidationSpecification;

import tools.descartes.librede.rrde.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.optimization.OptimizationSettings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.OptimizationSettingsImpl#getIgnoreApproaches <em>Ignore Approaches</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.OptimizationSettingsImpl#getParametersToOptmize <em>Parameters To Optmize</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.OptimizationSettingsImpl#getValidator <em>Validator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptimizationSettingsImpl extends MinimalEObjectImpl.Container implements OptimizationSettings {
	/**
	 * The cached value of the '{@link #getIgnoreApproaches() <em>Ignore Approaches</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnoreApproaches()
	 * @generated
	 * @ordered
	 */
	protected EList<String> ignoreApproaches;

	/**
	 * The cached value of the '{@link #getParametersToOptmize() <em>Parameters To Optmize</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParametersToOptmize()
	 * @generated
	 * @ordered
	 */
	protected EList<String> parametersToOptmize;

	/**
	 * The cached value of the '{@link #getValidator() <em>Validator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidator()
	 * @generated
	 * @ordered
	 */
	protected ValidationSpecification validator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimizationSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.OPTIMIZATION_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIgnoreApproaches() {
		if (ignoreApproaches == null) {
			ignoreApproaches = new EDataTypeUniqueEList<String>(String.class, this, OptimizationPackage.OPTIMIZATION_SETTINGS__IGNORE_APPROACHES);
		}
		return ignoreApproaches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParametersToOptmize() {
		if (parametersToOptmize == null) {
			parametersToOptmize = new EDataTypeUniqueEList<String>(String.class, this, OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTMIZE);
		}
		return parametersToOptmize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidationSpecification getValidator() {
		return validator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidator(ValidationSpecification newValidator, NotificationChain msgs) {
		ValidationSpecification oldValidator = validator;
		validator = newValidator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR, oldValidator, newValidator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidator(ValidationSpecification newValidator) {
		if (newValidator != validator) {
			NotificationChain msgs = null;
			if (validator != null)
				msgs = ((InternalEObject)validator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR, null, msgs);
			if (newValidator != null)
				msgs = ((InternalEObject)newValidator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR, null, msgs);
			msgs = basicSetValidator(newValidator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR, newValidator, newValidator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR:
				return basicSetValidator(null, msgs);
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
			case OptimizationPackage.OPTIMIZATION_SETTINGS__IGNORE_APPROACHES:
				return getIgnoreApproaches();
			case OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTMIZE:
				return getParametersToOptmize();
			case OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR:
				return getValidator();
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
			case OptimizationPackage.OPTIMIZATION_SETTINGS__IGNORE_APPROACHES:
				getIgnoreApproaches().clear();
				getIgnoreApproaches().addAll((Collection<? extends String>)newValue);
				return;
			case OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTMIZE:
				getParametersToOptmize().clear();
				getParametersToOptmize().addAll((Collection<? extends String>)newValue);
				return;
			case OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR:
				setValidator((ValidationSpecification)newValue);
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
			case OptimizationPackage.OPTIMIZATION_SETTINGS__IGNORE_APPROACHES:
				getIgnoreApproaches().clear();
				return;
			case OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTMIZE:
				getParametersToOptmize().clear();
				return;
			case OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR:
				setValidator((ValidationSpecification)null);
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
			case OptimizationPackage.OPTIMIZATION_SETTINGS__IGNORE_APPROACHES:
				return ignoreApproaches != null && !ignoreApproaches.isEmpty();
			case OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTMIZE:
				return parametersToOptmize != null && !parametersToOptmize.isEmpty();
			case OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR:
				return validator != null;
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
		result.append(" (IgnoreApproaches: ");
		result.append(ignoreApproaches);
		result.append(", parametersToOptmize: ");
		result.append(parametersToOptmize);
		result.append(')');
		return result.toString();
	}

} //OptimizationSettingsImpl
