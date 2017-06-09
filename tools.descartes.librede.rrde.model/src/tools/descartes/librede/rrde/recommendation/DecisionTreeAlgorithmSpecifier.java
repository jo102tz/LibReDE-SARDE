/**
 */
package tools.descartes.librede.rrde.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decision Tree Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier#getMaximumNumberOfNodes <em>Maximum Number Of Nodes</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getDecisionTreeAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface DecisionTreeAlgorithmSpecifier extends RecommendationAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Maximum Number Of Nodes</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Nodes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Nodes</em>' attribute.
	 * @see #setMaximumNumberOfNodes(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getDecisionTreeAlgorithmSpecifier_MaximumNumberOfNodes()
	 * @model default="100" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getMaximumNumberOfNodes();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier#getMaximumNumberOfNodes <em>Maximum Number Of Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Nodes</em>' attribute.
	 * @see #getMaximumNumberOfNodes()
	 * @generated
	 */
	void setMaximumNumberOfNodes(int value);

} // DecisionTreeAlgorithmSpecifier
