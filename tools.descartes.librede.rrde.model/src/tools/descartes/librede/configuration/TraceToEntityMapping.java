/**
 */
package tools.descartes.librede.configuration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace To Entity Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.TraceToEntityMapping#getTraceColumn <em>Trace Column</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.TraceToEntityMapping#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceToEntityMapping()
 * @model
 * @generated
 */
public interface TraceToEntityMapping extends ObservationToEntityMapping {
	/**
	 * Returns the value of the '<em><b>Trace Column</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Column</em>' attribute.
	 * @see #setTraceColumn(int)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceToEntityMapping_TraceColumn()
	 * @model default="1"
	 * @generated
	 */
	int getTraceColumn();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.TraceToEntityMapping#getTraceColumn <em>Trace Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Column</em>' attribute.
	 * @see #getTraceColumn()
	 * @generated
	 */
	void setTraceColumn(int value);

	/**
	 * Returns the value of the '<em><b>Filters</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.TraceFilter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filters</em>' containment reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceToEntityMapping_Filters()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceFilter> getFilters();

} // TraceToEntityMapping
