/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IRecommendation Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.IRecommendationAlgorithmSpecifier#getAlgorithmName <em>Algorithm Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getIRecommendationAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface IRecommendationAlgorithmSpecifier extends EObject {
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
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getIRecommendationAlgorithmSpecifier_AlgorithmName()
	 * @model required="true"
	 * @generated
	 */
	String getAlgorithmName();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.IRecommendationAlgorithmSpecifier#getAlgorithmName <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm Name</em>' attribute.
	 * @see #getAlgorithmName()
	 * @generated
	 */
	void setAlgorithmName(String value);

} // IRecommendationAlgorithmSpecifier
