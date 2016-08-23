/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.LibredeConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.DataSet#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.DataSet#getFeatures <em>Features</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.DataSet#getConfigurationValues <em>Configuration Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getDataSet()
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
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getDataSet_Configuration()
	 * @model required="true"
	 * @generated
	 */
	LibredeConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.DataSet#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(LibredeConfiguration value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference.
	 * @see #setFeatures(FeatureVector)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getDataSet_Features()
	 * @model required="true"
	 * @generated
	 */
	FeatureVector getFeatures();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.DataSet#getFeatures <em>Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Features</em>' reference.
	 * @see #getFeatures()
	 * @generated
	 */
	void setFeatures(FeatureVector value);

	/**
	 * Returns the value of the '<em><b>Configuration Values</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.recommendation.ConfigurationResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Values</em>' reference list.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getDataSet_ConfigurationValues()
	 * @model required="true"
	 * @generated
	 */
	EList<ConfigurationResult> getConfigurationValues();

} // DataSet
