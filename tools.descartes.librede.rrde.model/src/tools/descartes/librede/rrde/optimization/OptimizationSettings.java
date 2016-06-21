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
 *   <li>{@link tools.descartes.librede.rrde.optimization.OptimizationSettings#getIgnoreApproaches <em>Ignore Approaches</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.OptimizationSettings#getParametersToOptmize <em>Parameters To Optmize</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.OptimizationSettings#getValidator <em>Validator</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getOptimizationSettings()
 * @model
 * @generated
 */
public interface OptimizationSettings extends EObject {
	/**
	 * Returns the value of the '<em><b>Ignore Approaches</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Approaches that will not be optimized in this Run and that will be ignored by the algorithm.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ignore Approaches</em>' attribute list.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getOptimizationSettings_IgnoreApproaches()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	EList<String> getIgnoreApproaches();

	/**
	 * Returns the value of the '<em><b>Parameters To Optmize</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameters that will be optimized by the algorithms as far as supported.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters To Optmize</em>' attribute list.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getOptimizationSettings_ParametersToOptmize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	EList<String> getParametersToOptmize();

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

} // OptimizationSettings
