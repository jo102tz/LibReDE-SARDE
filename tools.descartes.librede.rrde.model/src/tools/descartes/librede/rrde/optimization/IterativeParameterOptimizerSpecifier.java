/**
 */
package tools.descartes.librede.rrde.optimization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterative Parameter Optimizer Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.IterativeParameterOptimizerSpecifier#getNumberOfSplits <em>Number Of Splits</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.IterativeParameterOptimizerSpecifier#getNumberOfExplorations <em>Number Of Explorations</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIterativeParameterOptimizerSpecifier()
 * @model
 * @generated
 */
public interface IterativeParameterOptimizerSpecifier extends IConfigurationOptimizationAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Number Of Splits</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Splits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Splits</em>' attribute.
	 * @see #setNumberOfSplits(int)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIterativeParameterOptimizerSpecifier_NumberOfSplits()
	 * @model default="10" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfSplits();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.IterativeParameterOptimizerSpecifier#getNumberOfSplits <em>Number Of Splits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Splits</em>' attribute.
	 * @see #getNumberOfSplits()
	 * @generated
	 */
	void setNumberOfSplits(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Explorations</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Explorations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Explorations</em>' attribute.
	 * @see #setNumberOfExplorations(int)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIterativeParameterOptimizerSpecifier_NumberOfExplorations()
	 * @model default="50" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfExplorations();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.IterativeParameterOptimizerSpecifier#getNumberOfExplorations <em>Number Of Explorations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Explorations</em>' attribute.
	 * @see #getNumberOfExplorations()
	 * @generated
	 */
	void setNumberOfExplorations(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean stop();

} // IterativeParameterOptimizerSpecifier
