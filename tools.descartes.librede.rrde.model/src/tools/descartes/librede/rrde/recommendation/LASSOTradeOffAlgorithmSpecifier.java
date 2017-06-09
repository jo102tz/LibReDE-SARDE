/**
 */
package tools.descartes.librede.rrde.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LASSO Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.LASSOTradeOffAlgorithmSpecifier#getLambda <em>Lambda</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getLASSOTradeOffAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface LASSOTradeOffAlgorithmSpecifier extends RecommendationTradeOffAlgorithmSpecifier {

	/**
	 * Returns the value of the '<em><b>Lambda</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lambda</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lambda</em>' attribute.
	 * @see #setLambda(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getLASSOTradeOffAlgorithmSpecifier_Lambda()
	 * @model default="1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getLambda();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.LASSOTradeOffAlgorithmSpecifier#getLambda <em>Lambda</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lambda</em>' attribute.
	 * @see #getLambda()
	 * @generated
	 */
	void setLambda(double value);
} // LASSOTradeOffAlgorithmSpecifier
