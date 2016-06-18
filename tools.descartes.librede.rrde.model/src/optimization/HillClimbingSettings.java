/**
 */
package optimization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hill Climbing Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link optimization.HillClimbingSettings#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link optimization.HillClimbingSettings#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link optimization.HillClimbingSettings#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link optimization.HillClimbingSettings#getMaximumNumberOfSteps <em>Maximum Number Of Steps</em>}</li>
 *   <li>{@link optimization.HillClimbingSettings#getStartValue <em>Start Value</em>}</li>
 *   <li>{@link optimization.HillClimbingSettings#getStepSize <em>Step Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see optimization.OptimizationPackage#getHillClimbingSettings()
 * @model
 * @generated
 */
public interface HillClimbingSettings extends ConfigurationSettings {
	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(double)
	 * @see optimization.OptimizationPackage#getHillClimbingSettings_Minimum()
	 * @model default="0"
	 * @generated
	 */
	double getMinimum();

	/**
	 * Sets the value of the '{@link optimization.HillClimbingSettings#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(double value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * The default value is <code>"200"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(double)
	 * @see optimization.OptimizationPackage#getHillClimbingSettings_Maximum()
	 * @model default="200"
	 * @generated
	 */
	double getMaximum();

	/**
	 * Sets the value of the '{@link optimization.HillClimbingSettings#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(double value);

	/**
	 * Returns the value of the '<em><b>Tolerance</b></em>' attribute.
	 * The default value is <code>"0.05"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tolerance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tolerance</em>' attribute.
	 * @see #setTolerance(double)
	 * @see optimization.OptimizationPackage#getHillClimbingSettings_Tolerance()
	 * @model default="0.05"
	 * @generated
	 */
	double getTolerance();

	/**
	 * Sets the value of the '{@link optimization.HillClimbingSettings#getTolerance <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tolerance</em>' attribute.
	 * @see #getTolerance()
	 * @generated
	 */
	void setTolerance(double value);

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Steps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Steps</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Steps</em>' attribute.
	 * @see #setMaximumNumberOfSteps(long)
	 * @see optimization.OptimizationPackage#getHillClimbingSettings_MaximumNumberOfSteps()
	 * @model
	 * @generated
	 */
	long getMaximumNumberOfSteps();

	/**
	 * Sets the value of the '{@link optimization.HillClimbingSettings#getMaximumNumberOfSteps <em>Maximum Number Of Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Steps</em>' attribute.
	 * @see #getMaximumNumberOfSteps()
	 * @generated
	 */
	void setMaximumNumberOfSteps(long value);

	/**
	 * Returns the value of the '<em><b>Start Value</b></em>' attribute.
	 * The default value is <code>"60"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Value</em>' attribute.
	 * @see #setStartValue(double)
	 * @see optimization.OptimizationPackage#getHillClimbingSettings_StartValue()
	 * @model default="60"
	 * @generated
	 */
	double getStartValue();

	/**
	 * Sets the value of the '{@link optimization.HillClimbingSettings#getStartValue <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Value</em>' attribute.
	 * @see #getStartValue()
	 * @generated
	 */
	void setStartValue(double value);

	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Size</em>' attribute.
	 * @see #setStepSize(double)
	 * @see optimization.OptimizationPackage#getHillClimbingSettings_StepSize()
	 * @model default="1"
	 * @generated
	 */
	double getStepSize();

	/**
	 * Sets the value of the '{@link optimization.HillClimbingSettings#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' attribute.
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(double value);

} // HillClimbingSettings
