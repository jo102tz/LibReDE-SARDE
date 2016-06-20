/**
 */
package tools.descartes.librede.configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Estimation Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.EstimationSpecification#getApproaches <em>Approaches</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.EstimationSpecification#isRecursive <em>Recursive</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.EstimationSpecification#getWindow <em>Window</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.EstimationSpecification#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.EstimationSpecification#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.EstimationSpecification#getStartTimestamp <em>Start Timestamp</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.EstimationSpecification#getEndTimestamp <em>End Timestamp</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.EstimationSpecification#isAutomaticApproachSelection <em>Automatic Approach Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.configuration.ConfigurationPackage#getEstimationSpecification()
 * @model
 * @generated
 */
public interface EstimationSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Approaches</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.EstimationApproachConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approaches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approaches</em>' containment reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getEstimationSpecification_Approaches()
	 * @model containment="true"
	 * @generated
	 */
	EList<EstimationApproachConfiguration> getApproaches();

	/**
	 * Returns the value of the '<em><b>Recursive</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recursive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recursive</em>' attribute.
	 * @see #setRecursive(boolean)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getEstimationSpecification_Recursive()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isRecursive();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.EstimationSpecification#isRecursive <em>Recursive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recursive</em>' attribute.
	 * @see #isRecursive()
	 * @generated
	 */
	void setRecursive(boolean value);

	/**
	 * Returns the value of the '<em><b>Window</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Window</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Window</em>' attribute.
	 * @see #setWindow(int)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getEstimationSpecification_Window()
	 * @model required="true"
	 * @generated
	 */
	int getWindow();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.EstimationSpecification#getWindow <em>Window</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Window</em>' attribute.
	 * @see #getWindow()
	 * @generated
	 */
	void setWindow(int value);

	/**
	 * Returns the value of the '<em><b>Algorithms</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.EstimationAlgorithmConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithms</em>' containment reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getEstimationSpecification_Algorithms()
	 * @model containment="true"
	 * @generated
	 */
	EList<EstimationAlgorithmConfiguration> getAlgorithms();

	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Size</em>' containment reference.
	 * @see #setStepSize(Quantity)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getEstimationSpecification_StepSize()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Quantity<Time> getStepSize();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.EstimationSpecification#getStepSize <em>Step Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' containment reference.
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(Quantity<Time> value);

	/**
	 * Returns the value of the '<em><b>Start Timestamp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Timestamp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Timestamp</em>' containment reference.
	 * @see #setStartTimestamp(Quantity)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getEstimationSpecification_StartTimestamp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Quantity<Time> getStartTimestamp();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.EstimationSpecification#getStartTimestamp <em>Start Timestamp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Timestamp</em>' containment reference.
	 * @see #getStartTimestamp()
	 * @generated
	 */
	void setStartTimestamp(Quantity<Time> value);

	/**
	 * Returns the value of the '<em><b>End Timestamp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Timestamp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Timestamp</em>' containment reference.
	 * @see #setEndTimestamp(Quantity)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getEstimationSpecification_EndTimestamp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Quantity<Time> getEndTimestamp();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.EstimationSpecification#getEndTimestamp <em>End Timestamp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Timestamp</em>' containment reference.
	 * @see #getEndTimestamp()
	 * @generated
	 */
	void setEndTimestamp(Quantity<Time> value);

	/**
	 * Returns the value of the '<em><b>Automatic Approach Selection</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Automatic Approach Selection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automatic Approach Selection</em>' attribute.
	 * @see #setAutomaticApproachSelection(boolean)
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getEstimationSpecification_AutomaticApproachSelection()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAutomaticApproachSelection();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.configuration.EstimationSpecification#isAutomaticApproachSelection <em>Automatic Approach Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Automatic Approach Selection</em>' attribute.
	 * @see #isAutomaticApproachSelection()
	 * @generated
	 */
	void setAutomaticApproachSelection(boolean value);

} // EstimationSpecification
