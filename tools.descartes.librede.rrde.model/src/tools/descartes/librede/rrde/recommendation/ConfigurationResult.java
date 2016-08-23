/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.EstimationSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.ConfigurationResult#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.ConfigurationResult#getErrorValue <em>Error Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getConfigurationResult()
 * @model
 * @generated
 */
public interface ConfigurationResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' reference.
	 * @see #setConfiguration(EstimationSpecification)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getConfigurationResult_Configuration()
	 * @model required="true"
	 * @generated
	 */
	EstimationSpecification getConfiguration();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.ConfigurationResult#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(EstimationSpecification value);

	/**
	 * Returns the value of the '<em><b>Error Value</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Value</em>' attribute.
	 * @see #setErrorValue(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getConfigurationResult_ErrorValue()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getErrorValue();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.ConfigurationResult#getErrorValue <em>Error Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Value</em>' attribute.
	 * @see #getErrorValue()
	 * @generated
	 */
	void setErrorValue(double value);

} // ConfigurationResult
