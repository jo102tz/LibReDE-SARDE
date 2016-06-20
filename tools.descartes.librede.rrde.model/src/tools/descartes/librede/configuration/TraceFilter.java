/**
 */
package tools.descartes.librede.configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.TraceFilter#getValue <em>Value</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.TraceFilter#getTraceColumn <em>Trace Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceFilter()
 * @model
 * @generated
 */
public interface TraceFilter extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceFilter_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.TraceFilter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Trace Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Column</em>' attribute.
	 * @see #setTraceColumn(int)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getTraceFilter_TraceColumn()
	 * @model required="true"
	 * @generated
	 */
	int getTraceColumn();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.TraceFilter#getTraceColumn <em>Trace Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Column</em>' attribute.
	 * @see #getTraceColumn()
	 * @generated
	 */
	void setTraceColumn(int value);

} // TraceFilter
