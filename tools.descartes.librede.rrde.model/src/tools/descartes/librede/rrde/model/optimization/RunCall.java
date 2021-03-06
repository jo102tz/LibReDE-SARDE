/**
 */
package tools.descartes.librede.rrde.model.optimization;

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
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.RunCall#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.RunCall#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.RunCall#getSettings <em>Settings</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.RunCall#getEstimation <em>Estimation</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getRunCall()
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
	 * @see #setAlgorithm(ConfigurationOptimizationAlgorithmSpecifier)
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getRunCall_Algorithm()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConfigurationOptimizationAlgorithmSpecifier getAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.optimization.RunCall#getAlgorithm <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' containment reference.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(ConfigurationOptimizationAlgorithmSpecifier value);

	/**
	 * Returns the value of the '<em><b>Training Data</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.model.optimization.InputData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Training Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Data</em>' containment reference list.
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getRunCall_TrainingData()
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
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getRunCall_Settings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OptimizationSettings getSettings();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.optimization.RunCall#getSettings <em>Settings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' containment reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(OptimizationSettings value);

	/**
	 * Returns the value of the '<em><b>Estimation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimation</em>' containment reference.
	 * @see #setEstimation(EstimationSpecification)
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getRunCall_Estimation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EstimationSpecification getEstimation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.optimization.RunCall#getEstimation <em>Estimation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimation</em>' containment reference.
	 * @see #getEstimation()
	 * @generated
	 */
	void setEstimation(EstimationSpecification value);

} // RunCall
