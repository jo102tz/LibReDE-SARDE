/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.EstimationSpecification;

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
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getEstimation <em>Estimation</em>}</li>
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
	 * @see #setLearningAlgorithm(IRecommendationAlgorithmSpecifier)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_LearningAlgorithm()
	 * @model
	 * @generated
	 */
	IRecommendationAlgorithmSpecifier getLearningAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getLearningAlgorithm <em>Learning Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Learning Algorithm</em>' reference.
	 * @see #getLearningAlgorithm()
	 * @generated
	 */
	void setLearningAlgorithm(IRecommendationAlgorithmSpecifier value);

	/**
	 * Returns the value of the '<em><b>Feature Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Algorithm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Algorithm</em>' reference.
	 * @see #setFeatureAlgorithm(IFeatureExtractorSpecifier)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_FeatureAlgorithm()
	 * @model required="true"
	 * @generated
	 */
	IFeatureExtractorSpecifier getFeatureAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getFeatureAlgorithm <em>Feature Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Algorithm</em>' reference.
	 * @see #getFeatureAlgorithm()
	 * @generated
	 */
	void setFeatureAlgorithm(IFeatureExtractorSpecifier value);

	/**
	 * Returns the value of the '<em><b>Estimation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimation</em>' reference.
	 * @see #setEstimation(EstimationSpecification)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTrainingConfiguration_Estimation()
	 * @model required="true"
	 * @generated
	 */
	EstimationSpecification getEstimation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration#getEstimation <em>Estimation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimation</em>' reference.
	 * @see #getEstimation()
	 * @generated
	 */
	void setEstimation(EstimationSpecification value);

} // RecommendationTrainingConfiguration
