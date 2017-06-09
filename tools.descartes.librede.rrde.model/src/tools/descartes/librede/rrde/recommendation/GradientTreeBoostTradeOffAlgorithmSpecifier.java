/**
 */
package tools.descartes.librede.rrde.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gradient Tree Boost Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.GradientTreeBoostTradeOffAlgorithmSpecifier#getIterationNumber <em>Iteration Number</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getGradientTreeBoostTradeOffAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface GradientTreeBoostTradeOffAlgorithmSpecifier extends RecommendationTradeOffAlgorithmSpecifier {

	/**
	 * Returns the value of the '<em><b>Iteration Number</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Number</em>' attribute.
	 * @see #setIterationNumber(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getGradientTreeBoostTradeOffAlgorithmSpecifier_IterationNumber()
	 * @model default="100" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getIterationNumber();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.GradientTreeBoostTradeOffAlgorithmSpecifier#getIterationNumber <em>Iteration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration Number</em>' attribute.
	 * @see #getIterationNumber()
	 * @generated
	 */
	void setIterationNumber(int value);
} // GradientTreeBoostTradeOffAlgorithmSpecifier
