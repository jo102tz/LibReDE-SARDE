/**
 */
package tools.descartes.librede.rrde.optimization;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.EstimationSpecification;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tries to change the given configuration in order to optimize the quality and the runtime of the algorithms in the given EstimationSpecification. 
	 * Different implementation support different parameters which can be configured with the configure method in order to influence the behavior.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	EstimationSpecification runOptimization(InputData input, OptimizationSettings settings, EstimationSpecification estimation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Configures the given parameter with the given value. Different subclasses might support different parameters. An Exception is thrown, if the given parameter is not supported by this specific implementation.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean configure(String parameter, EObject value);

} // IConfigurationOptimizationAlgorithmSpecifier
