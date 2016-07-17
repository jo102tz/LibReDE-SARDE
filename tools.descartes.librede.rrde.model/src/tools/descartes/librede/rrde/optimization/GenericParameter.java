/**
 */
package tools.descartes.librede.rrde.optimization;

import tools.descartes.librede.configuration.Parameter;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.GenericParameter#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getGenericParameter()
 * @model
 * @generated
 */
public interface GenericParameter extends IOptimizableParameter {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(Parameter)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getGenericParameter_Parameter()
	 * @model required="true"
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.GenericParameter#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

} // GenericParameter
