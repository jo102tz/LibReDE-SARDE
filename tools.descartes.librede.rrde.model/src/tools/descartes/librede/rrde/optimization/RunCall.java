/**
 */
package tools.descartes.librede.rrde.optimization;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.EstimationSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Run Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * One iteration of optimization specified by input or training data, a set of OptimizationSettings, an EstimationSpecification to optimize and one instance of an IConfigurationOptimizationAlgorithmSpecifier
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.RunCall#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.RunCall#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.RunCall#getSettings <em>Settings</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.RunCall#getEstimationSpecification <em>Estimation Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall()
 * @model
 * @generated
 */
public interface RunCall extends EObject {
	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' containment reference.
	 * @see #setAlgorithm(IConfigurationOptimizationAlgorithmSpecifier)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall_Algorithm()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IConfigurationOptimizationAlgorithmSpecifier getAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.RunCall#getAlgorithm <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' containment reference.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(IConfigurationOptimizationAlgorithmSpecifier value);

	/**
	 * Returns the value of the '<em><b>Training Data</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.optimization.InputData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Training Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Data</em>' containment reference list.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall_TrainingData()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<InputData> getTrainingData();

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' containment reference.
	 * @see #setSettings(OptimizationSettings)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall_Settings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OptimizationSettings getSettings();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.RunCall#getSettings <em>Settings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' containment reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(OptimizationSettings value);

	/**
	 * Returns the value of the '<em><b>Estimation Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimation Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimation Specification</em>' containment reference.
	 * @see #setEstimationSpecification(EstimationSpecification)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall_EstimationSpecification()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EstimationSpecification getEstimationSpecification();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.RunCall#getEstimationSpecification <em>Estimation Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimation Specification</em>' containment reference.
	 * @see #getEstimationSpecification()
	 * @generated
	 */
	void setEstimationSpecification(EstimationSpecification value);

} // RunCall
