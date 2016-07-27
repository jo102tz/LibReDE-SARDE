/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IFeature Extractor Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.IFeatureExtractorSpecifier#getFeatureExtractor <em>Feature Extractor</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getIFeatureExtractorSpecifier()
 * @model
 * @generated
 */
public interface IFeatureExtractorSpecifier extends EObject {
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
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getIFeatureExtractorSpecifier_FeatureExtractor()
	 * @model required="true"
	 * @generated
	 */
	String getFeatureExtractor();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.IFeatureExtractorSpecifier#getFeatureExtractor <em>Feature Extractor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Extractor</em>' attribute.
	 * @see #getFeatureExtractor()
	 * @generated
	 */
	void setFeatureExtractor(String value);

} // IFeatureExtractorSpecifier
