/**
 */
package tools.descartes.librede.configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validation Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.ValidationSpecification#getValidators <em>Validators</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.ValidationSpecification#getValidationFolds <em>Validation Folds</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.ValidationSpecification#isValidateEstimates <em>Validate Estimates</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.configuration.ConfigurationPackage#getValidationSpecification()
 * @model
 * @generated
 */
public interface ValidationSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Validators</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.ValidatorConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validators</em>' containment reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getValidationSpecification_Validators()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValidatorConfiguration> getValidators();

	/**
	 * Returns the value of the '<em><b>Validation Folds</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Folds</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validation Folds</em>' attribute.
	 * @see #setValidationFolds(int)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getValidationSpecification_ValidationFolds()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getValidationFolds();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.ValidationSpecification#getValidationFolds <em>Validation Folds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Folds</em>' attribute.
	 * @see #getValidationFolds()
	 * @generated
	 */
	void setValidationFolds(int value);

	/**
	 * Returns the value of the '<em><b>Validate Estimates</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Estimates</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Estimates</em>' attribute.
	 * @see #setValidateEstimates(boolean)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getValidationSpecification_ValidateEstimates()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isValidateEstimates();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.ValidationSpecification#isValidateEstimates <em>Validate Estimates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Estimates</em>' attribute.
	 * @see #isValidateEstimates()
	 * @generated
	 */
	void setValidateEstimates(boolean value);

} // ValidationSpecification
