/**
 */
package tools.descartes.librede.rrde.model.optimization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterative Parameter Optimizer Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfSplits <em>Number Of Splits</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfExplorations <em>Number Of Explorations</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfIterations <em>Number Of Iterations</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getIterativeParameterOptimizerSpecifier()
 * @model
 * @generated
 */
public interface IterativeParameterOptimizerSpecifier extends ConfigurationOptimizationAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Number Of Splits</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Splits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Splits</em>' attribute.
	 * @see #setNumberOfSplits(int)
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getIterativeParameterOptimizerSpecifier_NumberOfSplits()
	 * @model default="3" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfSplits();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfSplits <em>Number Of Splits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Splits</em>' attribute.
	 * @see #getNumberOfSplits()
	 * @generated
	 */
	void setNumberOfSplits(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Explorations</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Explorations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Explorations</em>' attribute.
	 * @see #setNumberOfExplorations(int)
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getIterativeParameterOptimizerSpecifier_NumberOfExplorations()
	 * @model default="3" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfExplorations();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfExplorations <em>Number Of Explorations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Explorations</em>' attribute.
	 * @see #getNumberOfExplorations()
	 * @generated
	 */
	void setNumberOfExplorations(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Iterations</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Iterations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Iterations</em>' attribute.
	 * @see #setNumberOfIterations(int)
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getIterativeParameterOptimizerSpecifier_NumberOfIterations()
	 * @model default="3" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfIterations();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier#getNumberOfIterations <em>Number Of Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Iterations</em>' attribute.
	 * @see #getNumberOfIterations()
	 * @generated
	 */
	void setNumberOfIterations(int value);

} // IterativeParameterOptimizerSpecifier
