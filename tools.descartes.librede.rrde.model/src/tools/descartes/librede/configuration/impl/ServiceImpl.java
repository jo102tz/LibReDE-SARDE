/**
 */
package tools.descartes.librede.configuration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.ExternalCall;
import tools.descartes.librede.configuration.Resource;
import tools.descartes.librede.configuration.ResourceDemand;
import tools.descartes.librede.configuration.Service;
import tools.descartes.librede.configuration.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.impl.ServiceImpl#isBackgroundService <em>Background Service</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.impl.ServiceImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.impl.ServiceImpl#getAccessedResources <em>Accessed Resources</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.impl.ServiceImpl#getIncomingCalls <em>Incoming Calls</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.impl.ServiceImpl#getOutgoingCalls <em>Outgoing Calls</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.impl.ServiceImpl#getResourceDemands <em>Resource Demands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends ModelEntityImpl implements Service {
	/**
	 * The default value of the '{@link #isBackgroundService() <em>Background Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBackgroundService()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BACKGROUND_SERVICE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBackgroundService() <em>Background Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBackgroundService()
	 * @generated
	 * @ordered
	 */
	protected boolean backgroundService = BACKGROUND_SERVICE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> tasks;

	/**
	 * The cached value of the '{@link #getIncomingCalls() <em>Incoming Calls</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingCalls()
	 * @generated
	 * @ordered
	 */
	protected EList<ExternalCall> incomingCalls;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBackgroundService() {
		return backgroundService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundService(boolean newBackgroundService) {
		boolean oldBackgroundService = backgroundService;
		backgroundService = newBackgroundService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SERVICE__BACKGROUND_SERVICE, oldBackgroundService, backgroundService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getTasks() {
		if (tasks == null) {
			tasks = new EObjectContainmentWithInverseEList<Task>(Task.class, this, ConfigurationPackage.SERVICE__TASKS, ConfigurationPackage.TASK__SERVICE);
		}
		return tasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getAccessedResources() {
		// TODO: implement this method to return the 'Accessed Resources' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalCall> getIncomingCalls() {
		if (incomingCalls == null) {
			incomingCalls = new EObjectWithInverseResolvingEList<ExternalCall>(ExternalCall.class, this, ConfigurationPackage.SERVICE__INCOMING_CALLS, ConfigurationPackage.EXTERNAL_CALL__CALLED_SERVICE);
		}
		return incomingCalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalCall> getOutgoingCalls() {
		// TODO: implement this method to return the 'Outgoing Calls' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceDemand> getResourceDemands() {
		// TODO: implement this method to return the 'Resource Demands' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.SERVICE__TASKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTasks()).basicAdd(otherEnd, msgs);
			case ConfigurationPackage.SERVICE__INCOMING_CALLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingCalls()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.SERVICE__TASKS:
				return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
			case ConfigurationPackage.SERVICE__INCOMING_CALLS:
				return ((InternalEList<?>)getIncomingCalls()).basicRemove(otherEnd, msgs);
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
			case ConfigurationPackage.SERVICE__BACKGROUND_SERVICE:
				return isBackgroundService();
			case ConfigurationPackage.SERVICE__TASKS:
				return getTasks();
			case ConfigurationPackage.SERVICE__ACCESSED_RESOURCES:
				return getAccessedResources();
			case ConfigurationPackage.SERVICE__INCOMING_CALLS:
				return getIncomingCalls();
			case ConfigurationPackage.SERVICE__OUTGOING_CALLS:
				return getOutgoingCalls();
			case ConfigurationPackage.SERVICE__RESOURCE_DEMANDS:
				return getResourceDemands();
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
			case ConfigurationPackage.SERVICE__BACKGROUND_SERVICE:
				setBackgroundService((Boolean)newValue);
				return;
			case ConfigurationPackage.SERVICE__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case ConfigurationPackage.SERVICE__INCOMING_CALLS:
				getIncomingCalls().clear();
				getIncomingCalls().addAll((Collection<? extends ExternalCall>)newValue);
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
			case ConfigurationPackage.SERVICE__BACKGROUND_SERVICE:
				setBackgroundService(BACKGROUND_SERVICE_EDEFAULT);
				return;
			case ConfigurationPackage.SERVICE__TASKS:
				getTasks().clear();
				return;
			case ConfigurationPackage.SERVICE__INCOMING_CALLS:
				getIncomingCalls().clear();
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
			case ConfigurationPackage.SERVICE__BACKGROUND_SERVICE:
				return backgroundService != BACKGROUND_SERVICE_EDEFAULT;
			case ConfigurationPackage.SERVICE__TASKS:
				return tasks != null && !tasks.isEmpty();
			case ConfigurationPackage.SERVICE__ACCESSED_RESOURCES:
				return !getAccessedResources().isEmpty();
			case ConfigurationPackage.SERVICE__INCOMING_CALLS:
				return incomingCalls != null && !incomingCalls.isEmpty();
			case ConfigurationPackage.SERVICE__OUTGOING_CALLS:
				return !getOutgoingCalls().isEmpty();
			case ConfigurationPackage.SERVICE__RESOURCE_DEMANDS:
				return !getResourceDemands().isEmpty();
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
		result.append(" (backgroundService: ");
		result.append(backgroundService);
		result.append(')');
		return result.toString();
	}

} //ServiceImpl
