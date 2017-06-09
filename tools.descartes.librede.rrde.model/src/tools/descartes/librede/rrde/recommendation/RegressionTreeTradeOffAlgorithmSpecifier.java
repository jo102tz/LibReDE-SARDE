/**
 */
package tools.descartes.librede.rrde.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regression Tree Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier#getMaxTreeNodes <em>Max Tree Nodes</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier#getSplitThreshould <em>Split Threshould</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRegressionTreeTradeOffAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface RegressionTreeTradeOffAlgorithmSpecifier extends RecommendationTradeOffAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Max Tree Nodes</b></em>' attribute.
	 * The default value is <code>"1000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Tree Nodes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Tree Nodes</em>' attribute.
	 * @see #setMaxTreeNodes(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRegressionTreeTradeOffAlgorithmSpecifier_MaxTreeNodes()
	 * @model default="1000" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getMaxTreeNodes();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier#getMaxTreeNodes <em>Max Tree Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Tree Nodes</em>' attribute.
	 * @see #getMaxTreeNodes()
	 * @generated
	 */
	void setMaxTreeNodes(int value);

	/**
	 * Returns the value of the '<em><b>Split Threshould</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Threshould</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Split Threshould</em>' attribute.
	 * @see #setSplitThreshould(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRegressionTreeTradeOffAlgorithmSpecifier_SplitThreshould()
	 * @model default="4" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getSplitThreshould();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier#getSplitThreshould <em>Split Threshould</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Split Threshould</em>' attribute.
	 * @see #getSplitThreshould()
	 * @generated
	 */
	void setSplitThreshould(int value);

} // RegressionTreeTradeOffAlgorithmSpecifier
