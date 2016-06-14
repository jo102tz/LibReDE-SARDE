/**
 */
package optimization;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Run Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link optimization.RunCall#getExecutes <em>Executes</em>}</li>
 *   <li>{@link optimization.RunCall#getExecutesOn <em>Executes On</em>}</li>
 *   <li>{@link optimization.RunCall#getSpecifiedBy <em>Specified By</em>}</li>
 * </ul>
 * </p>
 *
 * @see optimization.OptimizationPackage#getRunCall()
 * @model
 * @generated
 */
public interface RunCall extends EObject {
	/**
	 * Returns the value of the '<em><b>Executes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executes</em>' reference.
	 * @see #setExecutes(IAlgorithm)
	 * @see optimization.OptimizationPackage#getRunCall_Executes()
	 * @model required="true"
	 * @generated
	 */
	IAlgorithm getExecutes();

	/**
	 * Sets the value of the '{@link optimization.RunCall#getExecutes <em>Executes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executes</em>' reference.
	 * @see #getExecutes()
	 * @generated
	 */
	void setExecutes(IAlgorithm value);

	/**
	 * Returns the value of the '<em><b>Executes On</b></em>' reference list.
	 * The list contents are of type {@link optimization.InputData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executes On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executes On</em>' reference list.
	 * @see optimization.OptimizationPackage#getRunCall_ExecutesOn()
	 * @model required="true"
	 * @generated
	 */
	EList<InputData> getExecutesOn();

	/**
	 * Returns the value of the '<em><b>Specified By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified By</em>' reference.
	 * @see #setSpecifiedBy(Settings)
	 * @see optimization.OptimizationPackage#getRunCall_SpecifiedBy()
	 * @model required="true"
	 * @generated
	 */
	Settings getSpecifiedBy();

	/**
	 * Sets the value of the '{@link optimization.RunCall#getSpecifiedBy <em>Specified By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specified By</em>' reference.
	 * @see #getSpecifiedBy()
	 * @generated
	 */
	void setSpecifiedBy(Settings value);

} // RunCall
