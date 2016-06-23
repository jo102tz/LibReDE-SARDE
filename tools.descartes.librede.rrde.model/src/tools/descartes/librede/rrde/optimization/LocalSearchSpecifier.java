/**
 */
package tools.descartes.librede.rrde.optimization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Search Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.LocalSearchSpecifier#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.LocalSearchSpecifier#getMaximumNumberOfSteps <em>Maximum Number Of Steps</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.LocalSearchSpecifier#getStepSize <em>Step Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getLocalSearchSpecifier()
 * @model
 * @generated
 */
public interface LocalSearchSpecifier extends IConfigurationOptimizationAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Tolerance</b></em>' attribute.
	 * The default value is <code>"0.05"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tolerance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tolerance</em>' attribute.
	 * @see #setTolerance(double)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getLocalSearchSpecifier_Tolerance()
	 * @model default="0.05" required="true"
	 * @generated
	 */
	double getTolerance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.LocalSearchSpecifier#getTolerance <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tolerance</em>' attribute.
	 * @see #getTolerance()
	 * @generated
	 */
	void setTolerance(double value);

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Steps</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Steps</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Steps</em>' attribute.
	 * @see #setMaximumNumberOfSteps(long)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getLocalSearchSpecifier_MaximumNumberOfSteps()
	 * @model default="-1" required="true"
	 * @generated
	 */
	long getMaximumNumberOfSteps();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.LocalSearchSpecifier#getMaximumNumberOfSteps <em>Maximum Number Of Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Steps</em>' attribute.
	 * @see #getMaximumNumberOfSteps()
	 * @generated
	 */
	void setMaximumNumberOfSteps(long value);

	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Size</em>' attribute.
	 * @see #setStepSize(double)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getLocalSearchSpecifier_StepSize()
	 * @model default="1" required="true"
	 * @generated
	 */
	double getStepSize();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.LocalSearchSpecifier#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' attribute.
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(double value);

} // LocalSearchSpecifier
