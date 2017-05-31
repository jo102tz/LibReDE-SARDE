/**
 */
package tools.descartes.librede.rrde.model.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Neural Network Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.NeuralNetworkAlgorithmSpecifier#getNumberOfNeurons <em>Number Of Neurons</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.NeuralNetworkAlgorithmSpecifier#getEpochs <em>Epochs</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getNeuralNetworkAlgorithmSpecifier()
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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getNeuralNetworkAlgorithmSpecifier_NumberOfNeurons()
	 * @model default="100" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfNeurons();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.NeuralNetworkAlgorithmSpecifier#getNumberOfNeurons <em>Number Of Neurons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Neurons</em>' attribute.
	 * @see #getNumberOfNeurons()
	 * @generated
	 */
	void setNumberOfNeurons(int value);

	/**
	 * Returns the value of the '<em><b>Epochs</b></em>' attribute.
	 * The default value is <code>"5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Epochs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Epochs</em>' attribute.
	 * @see #setEpochs(int)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getNeuralNetworkAlgorithmSpecifier_Epochs()
	 * @model default="5" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getEpochs();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.NeuralNetworkAlgorithmSpecifier#getEpochs <em>Epochs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Epochs</em>' attribute.
	 * @see #getEpochs()
	 * @generated
	 */
	void setEpochs(int value);

} // NeuralNetworkAlgorithmSpecifier
