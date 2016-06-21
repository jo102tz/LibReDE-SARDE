/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import tools.descartes.librede.configuration.InputSpecification;
import tools.descartes.librede.configuration.WorkloadDescription;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.InputDataImpl#getInputSpecification <em>Input Specification</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.InputDataImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputDataImpl extends MinimalEObjectImpl.Container implements InputData {
	/**
	 * The cached value of the '{@link #getInputSpecification() <em>Input Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSpecification()
	 * @generated
	 * @ordered
	 */
	protected InputSpecification inputSpecification;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected WorkloadDescription description;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.INPUT_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSpecification getInputSpecification() {
		return inputSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputSpecification(InputSpecification newInputSpecification, NotificationChain msgs) {
		InputSpecification oldInputSpecification = inputSpecification;
		inputSpecification = newInputSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__INPUT_SPECIFICATION, oldInputSpecification, newInputSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputSpecification(InputSpecification newInputSpecification) {
		if (newInputSpecification != inputSpecification) {
			NotificationChain msgs = null;
			if (inputSpecification != null)
				msgs = ((InternalEObject)inputSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.INPUT_DATA__INPUT_SPECIFICATION, null, msgs);
			if (newInputSpecification != null)
				msgs = ((InternalEObject)newInputSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.INPUT_DATA__INPUT_SPECIFICATION, null, msgs);
			msgs = basicSetInputSpecification(newInputSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__INPUT_SPECIFICATION, newInputSpecification, newInputSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkloadDescription getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(WorkloadDescription newDescription, NotificationChain msgs) {
		WorkloadDescription oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(WorkloadDescription newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.INPUT_DATA__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.INPUT_DATA__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptimizationPackage.INPUT_DATA__INPUT_SPECIFICATION:
				return basicSetInputSpecification(null, msgs);
			case OptimizationPackage.INPUT_DATA__DESCRIPTION:
				return basicSetDescription(null, msgs);
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
			case OptimizationPackage.INPUT_DATA__INPUT_SPECIFICATION:
				return getInputSpecification();
			case OptimizationPackage.INPUT_DATA__DESCRIPTION:
				return getDescription();
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
			case OptimizationPackage.INPUT_DATA__INPUT_SPECIFICATION:
				setInputSpecification((InputSpecification)newValue);
				return;
			case OptimizationPackage.INPUT_DATA__DESCRIPTION:
				setDescription((WorkloadDescription)newValue);
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
			case OptimizationPackage.INPUT_DATA__INPUT_SPECIFICATION:
				setInputSpecification((InputSpecification)null);
				return;
			case OptimizationPackage.INPUT_DATA__DESCRIPTION:
				setDescription((WorkloadDescription)null);
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
			case OptimizationPackage.INPUT_DATA__INPUT_SPECIFICATION:
				return inputSpecification != null;
			case OptimizationPackage.INPUT_DATA__DESCRIPTION:
				return description != null;
		}
		return super.eIsSet(featureID);
	}

} //InputDataImpl
