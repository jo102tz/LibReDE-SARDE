/**
 */
package tools.descartes.librede.rrde.model.optimization;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A configuration of algorithms optimizing LibReDE configurations of estimation approaches.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration#getContainsOf <em>Contains Of</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getOptimizationConfiguration()
 * @model
 * @generated
 */
public interface OptimizationConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Contains Of</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.model.optimization.RunCall}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains Of</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains Of</em>' containment reference list.
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getOptimizationConfiguration_ContainsOf()
	 * @model containment="true"
	 * @generated
	 */
	EList<RunCall> getContainsOf();

} // OptimizationConfiguration
