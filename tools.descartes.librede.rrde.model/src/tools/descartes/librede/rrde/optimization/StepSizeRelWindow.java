/**
 */
package tools.descartes.librede.rrde.optimization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step Size Rel Window</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.StepSizeRelWindow#getProductMaxValue <em>Product Max Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getStepSizeRelWindow()
 * @model
 * @generated
 */
public interface StepSizeRelWindow extends StepSize {

	/**
	 * Returns the value of the '<em><b>Product Max Value</b></em>' attribute.
	 * The default value is <code>"10000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Max Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Max Value</em>' attribute.
	 * @see #setProductMaxValue(double)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getStepSizeRelWindow_ProductMaxValue()
	 * @model default="10000" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getProductMaxValue();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.StepSizeRelWindow#getProductMaxValue <em>Product Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Max Value</em>' attribute.
	 * @see #getProductMaxValue()
	 * @generated
	 */
	void setProductMaxValue(double value);
} // StepSizeRelWindow
