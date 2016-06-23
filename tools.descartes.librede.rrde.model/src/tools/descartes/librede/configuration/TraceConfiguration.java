/**
 */
package tools.descartes.librede.configuration;

import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.TraceConfiguration#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.TraceConfiguration#getInterval <em>Interval</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.TraceConfiguration#getLocation <em>Location</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.TraceConfiguration#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceConfiguration()
 * @model
 * @generated
 */
public interface TraceConfiguration extends Observation {
	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' reference.
	 * @see #setDataSource(DataSourceConfiguration)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceConfiguration_DataSource()
	 * @model required="true"
	 * @generated
	 */
	DataSourceConfiguration getDataSource();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.TraceConfiguration#getDataSource <em>Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' reference.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(DataSourceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Interval</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interval</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interval</em>' containment reference.
	 * @see #setInterval(Quantity)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceConfiguration_Interval()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Quantity<Time> getInterval();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.TraceConfiguration#getInterval <em>Interval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval</em>' containment reference.
	 * @see #getInterval()
	 * @generated
	 */
	void setInterval(Quantity<Time> value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceConfiguration_Location()
	 * @model required="true"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.TraceConfiguration#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.TraceToEntityMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceConfiguration_Mappings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TraceToEntityMapping> getMappings();

} // TraceConfiguration
