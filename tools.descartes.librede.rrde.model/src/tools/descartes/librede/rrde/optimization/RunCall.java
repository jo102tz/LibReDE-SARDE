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
 * One iteration of optimization specified by input or training data, a set of OptimizationSettings, an EstimationSpecification to optimize and one instance of an IConfigurationOptimizationAlgorithm
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.RunCall#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.RunCall#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.RunCall#getEstimationSpecification <em>Estimation Specification</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.RunCall#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall()
 * @model
 * @generated
 */
public interface RunCall extends EObject {
	/**
	 * Returns the value of the '<em><b>Training Data</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.optimization.InputData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Training Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Data</em>' reference list.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall_TrainingData()
	 * @model required="true"
	 * @generated
	 */
	EList<InputData> getTrainingData();

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' reference.
	 * @see #setAlgorithm(IConfigurationOptimizationAlgorithm)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall_Algorithm()
	 * @model required="true"
	 * @generated
	 */
	IConfigurationOptimizationAlgorithm getAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.RunCall#getAlgorithm <em>Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' reference.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(IConfigurationOptimizationAlgorithm value);

	/**
	 * Returns the value of the '<em><b>Estimation Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimation Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimation Specification</em>' reference.
	 * @see #setEstimationSpecification(EstimationSpecification)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall_EstimationSpecification()
	 * @model required="true"
	 * @generated
	 */
	EstimationSpecification getEstimationSpecification();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.RunCall#getEstimationSpecification <em>Estimation Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimation Specification</em>' reference.
	 * @see #getEstimationSpecification()
	 * @generated
	 */
	void setEstimationSpecification(EstimationSpecification value);

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' reference.
	 * @see #setSettings(OptimizationSettings)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getRunCall_Settings()
	 * @model required="true"
	 * @generated
	 */
	OptimizationSettings getSettings();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.RunCall#getSettings <em>Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(OptimizationSettings value);

} // RunCall
