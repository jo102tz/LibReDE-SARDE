/**
 */
package tools.descartes.librede.rrde.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gaussian Process Regression Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.GaussianProcessRegressionTradeOffAlgorithmSpecifier#getShrinkFactor <em>Shrink Factor</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getGaussianProcessRegressionTradeOffAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface GaussianProcessRegressionTradeOffAlgorithmSpecifier extends RecommendationTradeOffAlgorithmSpecifier {

	/**
	 * Returns the value of the '<em><b>Shrink Factor</b></em>' attribute.
	 * The default value is <code>"0.5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shrink Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shrink Factor</em>' attribute.
	 * @see #setShrinkFactor(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getGaussianProcessRegressionTradeOffAlgorithmSpecifier_ShrinkFactor()
	 * @model default="0.5" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getShrinkFactor();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.GaussianProcessRegressionTradeOffAlgorithmSpecifier#getShrinkFactor <em>Shrink Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shrink Factor</em>' attribute.
	 * @see #getShrinkFactor()
	 * @generated
	 */
	void setShrinkFactor(double value);
} // GaussianProcessRegressionTradeOffAlgorithmSpecifier
