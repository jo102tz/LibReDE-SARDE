/**
 */
package tools.descartes.librede.rrde.model.recommendation;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.EstimationAlgorithmConfiguration;
import tools.descartes.librede.configuration.LibredeConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.DataSet#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.DataSet#getEstimationErrors <em>Estimation Errors</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.DataSet#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getDataSet()
 * @model
 * @generated
 */
public interface DataSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' reference.
	 * @see #setConfiguration(LibredeConfiguration)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getDataSet_Configuration()
	 * @model required="true"
	 * @generated
	 */
	LibredeConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.DataSet#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(LibredeConfiguration value);

	/**
	 * Returns the value of the '<em><b>Estimation Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimation Errors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimation Errors</em>' attribute.
	 * @see #setEstimationErrors(Map)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getDataSet_EstimationErrors()
	 * @model required="true" transient="true"
	 * @generated
	 */
	Map<EstimationAlgorithmConfiguration, Double> getEstimationErrors();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.DataSet#getEstimationErrors <em>Estimation Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimation Errors</em>' attribute.
	 * @see #getEstimationErrors()
	 * @generated
	 */
	void setEstimationErrors(Map<EstimationAlgorithmConfiguration, Double> value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference.
	 * @see #setFeatures(FeatureVector)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getDataSet_Features()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FeatureVector getFeatures();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.DataSet#getFeatures <em>Features</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Features</em>' containment reference.
	 * @see #getFeatures()
	 * @generated
	 */
	void setFeatures(FeatureVector value);

} // DataSet
