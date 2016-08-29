/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Extractor Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getFeatureExtractor <em>Feature Extractor</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureExtractorSpecifier()
 * @model
 * @generated
 */
public interface FeatureExtractorSpecifier extends EObject {
	/**
	 * Returns the value of the '<em><b>Feature Extractor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Extractor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Extractor</em>' attribute.
	 * @see #setFeatureExtractor(String)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureExtractorSpecifier_FeatureExtractor()
	 * @model required="true"
	 * @generated
	 */
	String getFeatureExtractor();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getFeatureExtractor <em>Feature Extractor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Extractor</em>' attribute.
	 * @see #getFeatureExtractor()
	 * @generated
	 */
	void setFeatureExtractor(String value);

} // FeatureExtractorSpecifier
