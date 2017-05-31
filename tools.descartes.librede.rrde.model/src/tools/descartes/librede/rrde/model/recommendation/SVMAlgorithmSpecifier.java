/**
 */
package tools.descartes.librede.rrde.model.recommendation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SVM Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.SVMAlgorithmSpecifier#getGaussianSigma <em>Gaussian Sigma</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.SVMAlgorithmSpecifier#getSoftMarginPenalty <em>Soft Margin Penalty</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getSVMAlgorithmSpecifier()
 * @model
 * @generated
 */
public interface SVMAlgorithmSpecifier extends RecommendationAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Gaussian Sigma</b></em>' attribute.
	 * The default value is <code>"8.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gaussian Sigma</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gaussian Sigma</em>' attribute.
	 * @see #setGaussianSigma(double)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getSVMAlgorithmSpecifier_GaussianSigma()
	 * @model default="8.0" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getGaussianSigma();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.SVMAlgorithmSpecifier#getGaussianSigma <em>Gaussian Sigma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gaussian Sigma</em>' attribute.
	 * @see #getGaussianSigma()
	 * @generated
	 */
	void setGaussianSigma(double value);

	/**
	 * Returns the value of the '<em><b>Soft Margin Penalty</b></em>' attribute.
	 * The default value is <code>"5.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soft Margin Penalty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soft Margin Penalty</em>' attribute.
	 * @see #setSoftMarginPenalty(double)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getSVMAlgorithmSpecifier_SoftMarginPenalty()
	 * @model default="5.0" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getSoftMarginPenalty();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.SVMAlgorithmSpecifier#getSoftMarginPenalty <em>Soft Margin Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soft Margin Penalty</em>' attribute.
	 * @see #getSoftMarginPenalty()
	 * @generated
	 */
	void setSoftMarginPenalty(double value);

} // SVMAlgorithmSpecifier
