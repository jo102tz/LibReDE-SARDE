/**
 */
package tools.descartes.librede.rrde.optimization;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IConfiguration Optimization Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is a basic interface for configurations of algorithms optimizing LibReDE configurations of estimation approaches.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier#getTimeOut <em>Time Out</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier#getAlgorithmName <em>Algorithm Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIConfigurationOptimizationAlgorithmSpecifier()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IConfigurationOptimizationAlgorithmSpecifier extends EObject {
	/**
	 * Returns the value of the '<em><b>Time Out</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Out</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Out</em>' attribute.
	 * @see #setTimeOut(long)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIConfigurationOptimizationAlgorithmSpecifier_TimeOut()
	 * @model default="-1" required="true"
	 * @generated
	 */
	long getTimeOut();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier#getTimeOut <em>Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Out</em>' attribute.
	 * @see #getTimeOut()
	 * @generated
	 */
	void setTimeOut(long value);

	/**
	 * Returns the value of the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm Name</em>' attribute.
	 * @see #setAlgorithmName(String)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getIConfigurationOptimizationAlgorithmSpecifier_AlgorithmName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	String getAlgorithmName();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier#getAlgorithmName <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm Name</em>' attribute.
	 * @see #getAlgorithmName()
	 * @generated
	 */
	void setAlgorithmName(String value);

} // IConfigurationOptimizationAlgorithmSpecifier
