/**
 */
package tools.descartes.librede.rrde.model.recommendation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.RecommendationAlgorithmSpecifier#getAlgorithmName <em>Algorithm Name</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getRecommendationAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface RecommendationAlgorithmSpecifier extends EObject {
	/**
	 * Returns the value of the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm Name</em>' attribute.
	 * @see #setAlgorithmName(String)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getRecommendationAlgorithmSpecifier_AlgorithmName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	String getAlgorithmName();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.RecommendationAlgorithmSpecifier#getAlgorithmName <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm Name</em>' attribute.
	 * @see #getAlgorithmName()
	 * @generated
	 */
	void setAlgorithmName(String value);

} // RecommendationAlgorithmSpecifier
