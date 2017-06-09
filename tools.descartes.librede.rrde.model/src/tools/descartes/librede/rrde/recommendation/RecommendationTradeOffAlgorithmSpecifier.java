/**
 */
package tools.descartes.librede.rrde.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RecommendationTradeOffAlgorithmSpecifier#getTradeOffAlgorithmName <em>Trade Off Algorithm Name</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTradeOffAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface RecommendationTradeOffAlgorithmSpecifier extends RecommendationAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Trade Off Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trade Off Algorithm Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trade Off Algorithm Name</em>' attribute.
	 * @see #setTradeOffAlgorithmName(String)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRecommendationTradeOffAlgorithmSpecifier_TradeOffAlgorithmName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	String getTradeOffAlgorithmName();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RecommendationTradeOffAlgorithmSpecifier#getTradeOffAlgorithmName <em>Trade Off Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trade Off Algorithm Name</em>' attribute.
	 * @see #getTradeOffAlgorithmName()
	 * @generated
	 */
	void setTradeOffAlgorithmName(String value);

} // RecommendationTradeOffAlgorithmSpecifier
