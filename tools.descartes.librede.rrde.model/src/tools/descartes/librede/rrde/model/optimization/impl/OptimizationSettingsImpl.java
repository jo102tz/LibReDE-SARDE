/**
 */
package tools.descartes.librede.rrde.model.optimization.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.descartes.librede.configuration.ValidationSpecification;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.OptimizationSettingsImpl#getValidator <em>Validator</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.OptimizationSettingsImpl#getParametersToOptimize <em>Parameters To Optimize</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptimizationSettingsImpl extends MinimalEObjectImpl.Container implements OptimizationSettings {
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
	 * The cached value of the '{@link #getParametersToOptimize() <em>Parameters To Optimize</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParametersToOptimize()
	 * @generated
	 * @ordered
	 */
	protected EList<IOptimizableParameter> parametersToOptimize;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationSettingsImpl() {
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
	public EList<IOptimizableParameter> getParametersToOptimize() {
		if (parametersToOptimize == null) {
			parametersToOptimize = new EObjectContainmentEList<IOptimizableParameter>(IOptimizableParameter.class, this, OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE);
		}
		return parametersToOptimize;
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
			case OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE:
				return ((InternalEList<?>)getParametersToOptimize()).basicRemove(otherEnd, msgs);
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
			case OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR:
				return getValidator();
			case OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE:
				return getParametersToOptimize();
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
			case OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR:
				setValidator((ValidationSpecification)newValue);
				return;
			case OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE:
				getParametersToOptimize().clear();
				getParametersToOptimize().addAll((Collection<? extends IOptimizableParameter>)newValue);
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
			case OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR:
				setValidator((ValidationSpecification)null);
				return;
			case OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE:
				getParametersToOptimize().clear();
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
			case OptimizationPackage.OPTIMIZATION_SETTINGS__VALIDATOR:
				return validator != null;
			case OptimizationPackage.OPTIMIZATION_SETTINGS__PARAMETERS_TO_OPTIMIZE:
				return parametersToOptimize != null && !parametersToOptimize.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OptimizationSettingsImpl
