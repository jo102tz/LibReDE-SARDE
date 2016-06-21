/**
 */
package tools.descartes.librede.rrde.optimization;

import org.eclipse.emf.ecore.EObject;
import tools.descartes.librede.configuration.InputSpecification;
import tools.descartes.librede.configuration.WorkloadDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.InputData#getInputSpecification <em>Input Specification</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.InputData#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData()
 * @model
 * @generated
 */
public interface InputData extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Specification</em>' containment reference.
	 * @see #setInputSpecification(InputSpecification)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData_InputSpecification()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InputSpecification getInputSpecification();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.InputData#getInputSpecification <em>Input Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Specification</em>' containment reference.
	 * @see #getInputSpecification()
	 * @generated
	 */
	void setInputSpecification(InputSpecification value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference.
	 * @see #setDescription(WorkloadDescription)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData_Description()
	 * @model containment="true" required="true"
	 * @generated
	 */
	WorkloadDescription getDescription();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.InputData#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(WorkloadDescription value);

} // InputData
