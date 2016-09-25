/**
 */
package tools.descartes.librede.rrde.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Neural Network Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.NeuralNetworkAlgorithmSpecifier#getNumberOfNeurons <em>Number Of Neurons</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getNeuralNetworkAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface NeuralNetworkAlgorithmSpecifier extends RecommendationAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Number Of Neurons</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Neurons</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Neurons</em>' attribute.
	 * @see #setNumberOfNeurons(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getNeuralNetworkAlgorithmSpecifier_NumberOfNeurons()
	 * @model default="100" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfNeurons();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.NeuralNetworkAlgorithmSpecifier#getNumberOfNeurons <em>Number Of Neurons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Neurons</em>' attribute.
	 * @see #getNumberOfNeurons()
	 * @generated
	 */
	void setNumberOfNeurons(int value);

} // NeuralNetworkAlgorithmSpecifier
