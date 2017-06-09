/**
 */
package tools.descartes.librede.rrde.optimization;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IOptimizable Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An interface for the different parameter types that can be optimized.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.IOptimizableParameter#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.IOptimizableParameter#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.IOptimizableParameter#getStartValue <em>Start Value</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIOptimizableParameter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IOptimizableParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(double)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIOptimizableParameter_LowerBound()
	 * @model default="0" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getLowerBound();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.IOptimizableParameter#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(double value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(double)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIOptimizableParameter_UpperBound()
	 * @model default="1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getUpperBound();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.IOptimizableParameter#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(double value);

	/**
	 * Returns the value of the '<em><b>Start Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Value</em>' attribute.
	 * @see #setStartValue(double)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIOptimizableParameter_StartValue()
	 * @model default="0" id="true" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getStartValue();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.IOptimizableParameter#getStartValue <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Value</em>' attribute.
	 * @see #getStartValue()
	 * @generated
	 */
	void setStartValue(double value);

} // IOptimizableParameter
