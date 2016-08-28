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
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.InputDataImpl#getInput <em>Input</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.InputDataImpl#getWorkloadDescription <em>Workload Description</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.InputDataImpl#getRootFolder <em>Root Folder</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.InputDataImpl#isMultiFolderStructures <em>Multi Folder Structures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputDataImpl extends MinimalEObjectImpl.Container implements InputData {
	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected InputSpecification input;

	/**
	 * The cached value of the '{@link #getWorkloadDescription() <em>Workload Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkloadDescription()
	 * @generated
	 * @ordered
	 */
	protected WorkloadDescription workloadDescription;

	/**
	 * The default value of the '{@link #getRootFolder() <em>Root Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRootFolder() <em>Root Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootFolder()
	 * @generated
	 * @ordered
	 */
	protected String rootFolder = ROOT_FOLDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isMultiFolderStructures() <em>Multi Folder Structures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiFolderStructures()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTI_FOLDER_STRUCTURES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiFolderStructures() <em>Multi Folder Structures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiFolderStructures()
	 * @generated
	 * @ordered
	 */
	protected boolean multiFolderStructures = MULTI_FOLDER_STRUCTURES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDataImpl() {
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
	public InputSpecification getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(InputSpecification newInput, NotificationChain msgs) {
		InputSpecification oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(InputSpecification newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.INPUT_DATA__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.INPUT_DATA__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkloadDescription getWorkloadDescription() {
		return workloadDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkloadDescription(WorkloadDescription newWorkloadDescription, NotificationChain msgs) {
		WorkloadDescription oldWorkloadDescription = workloadDescription;
		workloadDescription = newWorkloadDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__WORKLOAD_DESCRIPTION, oldWorkloadDescription, newWorkloadDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkloadDescription(WorkloadDescription newWorkloadDescription) {
		if (newWorkloadDescription != workloadDescription) {
			NotificationChain msgs = null;
			if (workloadDescription != null)
				msgs = ((InternalEObject)workloadDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.INPUT_DATA__WORKLOAD_DESCRIPTION, null, msgs);
			if (newWorkloadDescription != null)
				msgs = ((InternalEObject)newWorkloadDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.INPUT_DATA__WORKLOAD_DESCRIPTION, null, msgs);
			msgs = basicSetWorkloadDescription(newWorkloadDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__WORKLOAD_DESCRIPTION, newWorkloadDescription, newWorkloadDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootFolder() {
		return rootFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootFolder(String newRootFolder) {
		String oldRootFolder = rootFolder;
		rootFolder = newRootFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__ROOT_FOLDER, oldRootFolder, rootFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiFolderStructures() {
		return multiFolderStructures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiFolderStructures(boolean newMultiFolderStructures) {
		boolean oldMultiFolderStructures = multiFolderStructures;
		multiFolderStructures = newMultiFolderStructures;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.INPUT_DATA__MULTI_FOLDER_STRUCTURES, oldMultiFolderStructures, multiFolderStructures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptimizationPackage.INPUT_DATA__INPUT:
				return basicSetInput(null, msgs);
			case OptimizationPackage.INPUT_DATA__WORKLOAD_DESCRIPTION:
				return basicSetWorkloadDescription(null, msgs);
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
			case OptimizationPackage.INPUT_DATA__INPUT:
				return getInput();
			case OptimizationPackage.INPUT_DATA__WORKLOAD_DESCRIPTION:
				return getWorkloadDescription();
			case OptimizationPackage.INPUT_DATA__ROOT_FOLDER:
				return getRootFolder();
			case OptimizationPackage.INPUT_DATA__MULTI_FOLDER_STRUCTURES:
				return isMultiFolderStructures();
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
			case OptimizationPackage.INPUT_DATA__INPUT:
				setInput((InputSpecification)newValue);
				return;
			case OptimizationPackage.INPUT_DATA__WORKLOAD_DESCRIPTION:
				setWorkloadDescription((WorkloadDescription)newValue);
				return;
			case OptimizationPackage.INPUT_DATA__ROOT_FOLDER:
				setRootFolder((String)newValue);
				return;
			case OptimizationPackage.INPUT_DATA__MULTI_FOLDER_STRUCTURES:
				setMultiFolderStructures((Boolean)newValue);
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
			case OptimizationPackage.INPUT_DATA__INPUT:
				setInput((InputSpecification)null);
				return;
			case OptimizationPackage.INPUT_DATA__WORKLOAD_DESCRIPTION:
				setWorkloadDescription((WorkloadDescription)null);
				return;
			case OptimizationPackage.INPUT_DATA__ROOT_FOLDER:
				setRootFolder(ROOT_FOLDER_EDEFAULT);
				return;
			case OptimizationPackage.INPUT_DATA__MULTI_FOLDER_STRUCTURES:
				setMultiFolderStructures(MULTI_FOLDER_STRUCTURES_EDEFAULT);
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
			case OptimizationPackage.INPUT_DATA__INPUT:
				return input != null;
			case OptimizationPackage.INPUT_DATA__WORKLOAD_DESCRIPTION:
				return workloadDescription != null;
			case OptimizationPackage.INPUT_DATA__ROOT_FOLDER:
				return ROOT_FOLDER_EDEFAULT == null ? rootFolder != null : !ROOT_FOLDER_EDEFAULT.equals(rootFolder);
			case OptimizationPackage.INPUT_DATA__MULTI_FOLDER_STRUCTURES:
				return multiFolderStructures != MULTI_FOLDER_STRUCTURES_EDEFAULT;
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
		result.append(" (rootFolder: ");
		result.append(rootFolder);
		result.append(", multiFolderStructures: ");
		result.append(multiFolderStructures);
		result.append(')');
		return result.toString();
	}

} //InputDataImpl
