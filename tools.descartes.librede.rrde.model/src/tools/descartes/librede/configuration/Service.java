/**
 */
package tools.descartes.librede.configuration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.Service#isBackgroundService <em>Background Service</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.Service#getTasks <em>Tasks</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.Service#getAccessedResources <em>Accessed Resources</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.Service#getIncomingCalls <em>Incoming Calls</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.Service#getOutgoingCalls <em>Outgoing Calls</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.Service#getResourceDemands <em>Resource Demands</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.configuration.ConfigurationPackage#getService()
 * @model
 * @generated
 */
public interface Service extends ModelEntity {
	/**
	 * Returns the value of the '<em><b>Background Service</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Service</em>' attribute.
	 * @see #setBackgroundService(boolean)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getService_BackgroundService()
	 * @model default="false"
	 * @generated
	 */
	boolean isBackgroundService();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.Service#isBackgroundService <em>Background Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Service</em>' attribute.
	 * @see #isBackgroundService()
	 * @generated
	 */
	void setBackgroundService(boolean value);

	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.Task}.
	 * It is bidirectional and its opposite is '{@link tools.descartes.librede.configuration.Task#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getService_Tasks()
	 * @see tools.descartes.librede.configuration.Task#getService
	 * @model opposite="service" containment="true"
	 * @generated
	 */
	EList<Task> getTasks();

	/**
	 * Returns the value of the '<em><b>Accessed Resources</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessed Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessed Resources</em>' reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getService_AccessedResources()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Resource> getAccessedResources();

	/**
	 * Returns the value of the '<em><b>Incoming Calls</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.ExternalCall}.
	 * It is bidirectional and its opposite is '{@link tools.descartes.librede.configuration.ExternalCall#getCalledService <em>Called Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Calls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Calls</em>' reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getService_IncomingCalls()
	 * @see tools.descartes.librede.configuration.ExternalCall#getCalledService
	 * @model opposite="calledService"
	 * @generated
	 */
	EList<ExternalCall> getIncomingCalls();

	/**
	 * Returns the value of the '<em><b>Outgoing Calls</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.ExternalCall}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Calls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Calls</em>' reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getService_OutgoingCalls()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ExternalCall> getOutgoingCalls();

	/**
	 * Returns the value of the '<em><b>Resource Demands</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.ResourceDemand}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Demands</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Demands</em>' reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getService_ResourceDemands()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ResourceDemand> getResourceDemands();

} // Service
