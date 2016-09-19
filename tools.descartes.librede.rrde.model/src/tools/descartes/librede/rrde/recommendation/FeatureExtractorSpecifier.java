/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.ecore.EObject;
import tools.descartes.librede.units.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Extractor Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getFeatureExtractor <em>Feature Extractor</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getTimeUnit <em>Time Unit</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getAggregationInterval <em>Aggregation Interval</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getRateUnit <em>Rate Unit</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Time Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Unit</em>' reference.
	 * @see #setTimeUnit(Unit)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureExtractorSpecifier_TimeUnit()
	 * @model required="true"
	 * @generated
	 */
	Unit<?> getTimeUnit();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getTimeUnit <em>Time Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Unit</em>' reference.
	 * @see #getTimeUnit()
	 * @generated
	 */
	void setTimeUnit(Unit<?> value);

	/**
	 * Returns the value of the '<em><b>Aggregation Interval</b></em>' attribute.
	 * The default value is <code>"60000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Interval</em>' attribute.
	 * @see #setAggregationInterval(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureExtractorSpecifier_AggregationInterval()
	 * @model default="60000" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getAggregationInterval();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getAggregationInterval <em>Aggregation Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Interval</em>' attribute.
	 * @see #getAggregationInterval()
	 * @generated
	 */
	void setAggregationInterval(int value);

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
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureExtractorSpecifier_RateUnit()
	 * @model required="true"
	 * @generated
	 */
	Unit<?> getRateUnit();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier#getRateUnit <em>Rate Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate Unit</em>' reference.
	 * @see #getRateUnit()
	 * @generated
	 */
	void setRateUnit(Unit<?> value);

} // FeatureExtractorSpecifier
