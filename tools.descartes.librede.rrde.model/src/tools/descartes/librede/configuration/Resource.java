/**
 */
package tools.descartes.librede.configuration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.Resource#getNumberOfServers <em>Number Of Servers</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.Resource#getSchedulingStrategy <em>Scheduling Strategy</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.Resource#getChildResources <em>Child Resources</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.Resource#getDemands <em>Demands</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.Resource#getAccessingServices <em>Accessing Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.configuration.ConfigurationPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends ModelEntity {
	/**
	 * Returns the value of the '<em><b>Number Of Servers</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Servers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Servers</em>' attribute.
	 * @see #setNumberOfServers(int)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getResource_NumberOfServers()
	 * @model default="1"
	 * @generated
	 */
	int getNumberOfServers();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.Resource#getNumberOfServers <em>Number Of Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Servers</em>' attribute.
	 * @see #getNumberOfServers()
	 * @generated
	 */
	void setNumberOfServers(int value);

	/**
	 * Returns the value of the '<em><b>Scheduling Strategy</b></em>' attribute.
	 * The default value is <code>"Unkown"</code>.
	 * The literals are from the enumeration {@link tools.descartes.librede.configuration.SchedulingStrategy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling Strategy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling Strategy</em>' attribute.
	 * @see tools.descartes.librede.configuration.SchedulingStrategy
	 * @see #setSchedulingStrategy(SchedulingStrategy)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getResource_SchedulingStrategy()
	 * @model default="Unkown"
	 * @generated
	 */
	SchedulingStrategy getSchedulingStrategy();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.Resource#getSchedulingStrategy <em>Scheduling Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduling Strategy</em>' attribute.
	 * @see tools.descartes.librede.configuration.SchedulingStrategy
	 * @see #getSchedulingStrategy()
	 * @generated
	 */
	void setSchedulingStrategy(SchedulingStrategy value);

	/**
	 * Returns the value of the '<em><b>Child Resources</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Resources</em>' reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getResource_ChildResources()
	 * @model
	 * @generated
	 */
	EList<Resource> getChildResources();

	/**
	 * Returns the value of the '<em><b>Demands</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.ResourceDemand}.
	 * It is bidirectional and its opposite is '{@link tools.descartes.librede.configuration.ResourceDemand#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demands</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demands</em>' reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getResource_Demands()
	 * @see tools.descartes.librede.configuration.ResourceDemand#getResource
	 * @model opposite="resource"
	 * @generated
	 */
	EList<ResourceDemand> getDemands();

	/**
	 * Returns the value of the '<em><b>Accessing Services</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessing Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessing Services</em>' reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getResource_AccessingServices()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Service> getAccessingServices();

} // Resource
