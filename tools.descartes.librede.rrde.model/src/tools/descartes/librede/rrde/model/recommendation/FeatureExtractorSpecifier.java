/**
 */
package tools.descartes.librede.rrde.model.recommendation;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Extractor Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier#getFeatureExtractor <em>Feature Extractor</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier#getRateUnit <em>Rate Unit</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier#getAggregation <em>Aggregation</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getFeatureExtractorSpecifier()
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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getFeatureExtractorSpecifier_FeatureExtractor()
	 * @model required="true"
	 * @generated
	 */
	String getFeatureExtractor();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier#getFeatureExtractor <em>Feature Extractor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Extractor</em>' attribute.
	 * @see #getFeatureExtractor()
	 * @generated
	 */
	void setFeatureExtractor(String value);

	/**
	 * Returns the value of the '<em><b>Rate Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate Unit</em>' reference.
	 * @see #setRateUnit(Unit)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getFeatureExtractorSpecifier_RateUnit()
	 * @model required="true"
	 * @generated
	 */
	Unit<?> getRateUnit();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier#getRateUnit <em>Rate Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate Unit</em>' reference.
	 * @see #getRateUnit()
	 * @generated
	 */
	void setRateUnit(Unit<?> value);

	/**
	 * Returns the value of the '<em><b>Aggregation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation</em>' containment reference.
	 * @see #setAggregation(Quantity)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getFeatureExtractorSpecifier_Aggregation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Quantity<Time> getAggregation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier#getAggregation <em>Aggregation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation</em>' containment reference.
	 * @see #getAggregation()
	 * @generated
	 */
	void setAggregation(Quantity<Time> value);

} // FeatureExtractorSpecifier
