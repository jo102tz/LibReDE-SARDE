/**
 */
package tools.descartes.librede.rrde.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RBF Network Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RBFNetworkTradeOffAlgorithmSpecifier#getK <em>K</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRBFNetworkTradeOffAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface RBFNetworkTradeOffAlgorithmSpecifier extends RecommendationTradeOffAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>K</b></em>' attribute.
	 * The default value is <code>"20"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>K</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>K</em>' attribute.
	 * @see #setK(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRBFNetworkTradeOffAlgorithmSpecifier_K()
	 * @model default="20" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getK();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RBFNetworkTradeOffAlgorithmSpecifier#getK <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K</em>' attribute.
	 * @see #getK()
	 * @generated
	 */
	void setK(int value);

} // RBFNetworkTradeOffAlgorithmSpecifier
