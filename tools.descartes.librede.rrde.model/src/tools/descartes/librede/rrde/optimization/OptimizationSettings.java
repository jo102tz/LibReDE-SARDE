/**
 */
package tools.descartes.librede.rrde.optimization;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.ValidationSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A settings file containing several general parameters configuring the executing algorithm.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.OptimizationSettings#getValidator <em>Validator</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.OptimizationSettings#getParametersToOptimize <em>Parameters To Optimize</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getOptimizationSettings()
 * @model
 * @generated
 */
public interface OptimizationSettings extends EObject {
	/**
	 * Returns the value of the '<em><b>Validator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validator</em>' containment reference.
	 * @see #setValidator(ValidationSpecification)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getOptimizationSettings_Validator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ValidationSpecification getValidator();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.OptimizationSettings#getValidator <em>Validator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validator</em>' containment reference.
	 * @see #getValidator()
	 * @generated
	 */
	void setValidator(ValidationSpecification value);

	/**
	 * Returns the value of the '<em><b>Parameters To Optimize</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.optimization.IOptimizableParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters To Optimize</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters To Optimize</em>' containment reference list.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getOptimizationSettings_ParametersToOptimize()
	 * @model containment="true"
	 * @generated
	 */
	EList<IOptimizableParameter> getParametersToOptimize();

} // OptimizationSettings
