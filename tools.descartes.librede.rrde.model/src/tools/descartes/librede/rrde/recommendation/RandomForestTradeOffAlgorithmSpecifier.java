/**
 */
package tools.descartes.librede.rrde.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Forest Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier#getMaxTreeNodes <em>Max Tree Nodes</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier#getSplitThreshould <em>Split Threshould</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier#getTreeNumber <em>Tree Number</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRandomForestTradeOffAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface RandomForestTradeOffAlgorithmSpecifier extends RecommendationTradeOffAlgorithmSpecifier {

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
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRandomForestTradeOffAlgorithmSpecifier_MaxTreeNodes()
	 * @model default="1000" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getMaxTreeNodes();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier#getMaxTreeNodes <em>Max Tree Nodes</em>}' attribute.
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
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRandomForestTradeOffAlgorithmSpecifier_SplitThreshould()
	 * @model default="4" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getSplitThreshould();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier#getSplitThreshould <em>Split Threshould</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Split Threshould</em>' attribute.
	 * @see #getSplitThreshould()
	 * @generated
	 */
	void setSplitThreshould(int value);

	/**
	 * Returns the value of the '<em><b>Tree Number</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tree Number</em>' attribute.
	 * @see #setTreeNumber(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getRandomForestTradeOffAlgorithmSpecifier_TreeNumber()
	 * @model default="4" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getTreeNumber();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier#getTreeNumber <em>Tree Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tree Number</em>' attribute.
	 * @see #getTreeNumber()
	 * @generated
	 */
	void setTreeNumber(int value);
} // RandomForestTradeOffAlgorithmSpecifier
