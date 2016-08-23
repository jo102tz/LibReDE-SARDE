/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.EstimationSpecification;

import tools.descartes.librede.configuration.ValidationSpecification;
import tools.descartes.librede.rrde.optimization.InputData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Training Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getLearningAlgorithm <em>Learning Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getFeatureAlgorithm <em>Feature Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getValidator <em>Validator</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration()
 * @model
 * @generated
 */
public interface RecommendationTrainingConfiguration extends EObject {
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
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_TrainingData()
	 * @model required="true"
	 * @generated
	 */
	EList<InputData> getTrainingData();

	/**
	 * Returns the value of the '<em><b>Learning Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Learning Algorithm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Learning Algorithm</em>' reference.
	 * @see #setLearningAlgorithm(RecommendationAlgorithmSpecifier)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_LearningAlgorithm()
	 * @model required="true"
	 * @generated
	 */
	RecommendationAlgorithmSpecifier getLearningAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getLearningAlgorithm <em>Learning Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Learning Algorithm</em>' reference.
	 * @see #getLearningAlgorithm()
	 * @generated
	 */
	void setLearningAlgorithm(RecommendationAlgorithmSpecifier value);

	/**
	 * Returns the value of the '<em><b>Feature Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Algorithm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Algorithm</em>' reference.
	 * @see #setFeatureAlgorithm(FeatureExtractorSpecifier)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_FeatureAlgorithm()
	 * @model required="true"
	 * @generated
	 */
	FeatureExtractorSpecifier getFeatureAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getFeatureAlgorithm <em>Feature Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Algorithm</em>' reference.
	 * @see #getFeatureAlgorithm()
	 * @generated
	 */
	void setFeatureAlgorithm(FeatureExtractorSpecifier value);

	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.EstimationSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' reference list.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_Configurations()
	 * @model required="true"
	 * @generated
	 */
	EList<EstimationSpecification> getConfigurations();

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
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_Validator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ValidationSpecification getValidator();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getValidator <em>Validator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validator</em>' containment reference.
	 * @see #getValidator()
	 * @generated
	 */
	void setValidator(ValidationSpecification value);

} // RecommendationTrainingConfiguration
