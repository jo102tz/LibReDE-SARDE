/**
 */
package tools.descartes.librede.rrde.model.recommendation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.ValidationSpecification;

import tools.descartes.librede.rrde.model.optimization.InputData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Training Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration#getValidator <em>Validator</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration#getFeatureAlgorithm <em>Feature Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration#getLearningAlgorithm <em>Learning Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration#getEstimators <em>Estimators</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration()
 * @model
 * @generated
 */
public interface RecommendationTrainingConfiguration extends EObject {
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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_Validator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ValidationSpecification getValidator();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration#getValidator <em>Validator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validator</em>' containment reference.
	 * @see #getValidator()
	 * @generated
	 */
	void setValidator(ValidationSpecification value);

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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_TrainingData()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputData> getTrainingData();

	/**
	 * Returns the value of the '<em><b>Feature Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Algorithm</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Algorithm</em>' containment reference.
	 * @see #setFeatureAlgorithm(FeatureExtractorSpecifier)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_FeatureAlgorithm()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FeatureExtractorSpecifier getFeatureAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration#getFeatureAlgorithm <em>Feature Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Algorithm</em>' containment reference.
	 * @see #getFeatureAlgorithm()
	 * @generated
	 */
	void setFeatureAlgorithm(FeatureExtractorSpecifier value);

	/**
	 * Returns the value of the '<em><b>Learning Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Learning Algorithm</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Learning Algorithm</em>' containment reference.
	 * @see #setLearningAlgorithm(RecommendationAlgorithmSpecifier)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_LearningAlgorithm()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RecommendationAlgorithmSpecifier getLearningAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration#getLearningAlgorithm <em>Learning Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Learning Algorithm</em>' containment reference.
	 * @see #getLearningAlgorithm()
	 * @generated
	 */
	void setLearningAlgorithm(RecommendationAlgorithmSpecifier value);

	/**
	 * Returns the value of the '<em><b>Estimators</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.EstimationSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimators</em>' containment reference list.
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_Estimators()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EstimationSpecification> getEstimators();

} // RecommendationTrainingConfiguration
