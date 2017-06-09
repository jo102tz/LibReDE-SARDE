/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage
 * @generated
 */
public interface RecommendationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RecommendationFactory eINSTANCE = tools.descartes.librede.rrde.recommendation.impl.RecommendationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Training Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Training Configuration</em>'.
	 * @generated
	 */
	RecommendationTrainingConfiguration createRecommendationTrainingConfiguration();

	/**
	 * Returns a new object of class '<em>Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Algorithm Specifier</em>'.
	 * @generated
	 */
	RecommendationAlgorithmSpecifier createRecommendationAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>Feature Extractor Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Extractor Specifier</em>'.
	 * @generated
	 */
	FeatureExtractorSpecifier createFeatureExtractorSpecifier();

	/**
	 * Returns a new object of class '<em>Data Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Set</em>'.
	 * @generated
	 */
	DataSet createDataSet();

	/**
	 * Returns a new object of class '<em>Feature Vector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Vector</em>'.
	 * @generated
	 */
	FeatureVector createFeatureVector();

	/**
	 * Returns a new object of class '<em>Statistical Features</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statistical Features</em>'.
	 * @generated
	 */
	StatisticalFeatures createStatisticalFeatures();

	/**
	 * Returns a new object of class '<em>Decision Tree Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decision Tree Algorithm Specifier</em>'.
	 * @generated
	 */
	DecisionTreeAlgorithmSpecifier createDecisionTreeAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>Neural Network Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Neural Network Algorithm Specifier</em>'.
	 * @generated
	 */
	NeuralNetworkAlgorithmSpecifier createNeuralNetworkAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>SVM Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SVM Algorithm Specifier</em>'.
	 * @generated
	 */
	SVMAlgorithmSpecifier createSVMAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>Regression Tree Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Regression Tree Trade Off Algorithm Specifier</em>'.
	 * @generated
	 */
	RegressionTreeTradeOffAlgorithmSpecifier createRegressionTreeTradeOffAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>OLS Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OLS Trade Off Algorithm Specifier</em>'.
	 * @generated
	 */
	OLSTradeOffAlgorithmSpecifier createOLSTradeOffAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trade Off Algorithm Specifier</em>'.
	 * @generated
	 */
	RecommendationTradeOffAlgorithmSpecifier createRecommendationTradeOffAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>Random Forest Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Forest Trade Off Algorithm Specifier</em>'.
	 * @generated
	 */
	RandomForestTradeOffAlgorithmSpecifier createRandomForestTradeOffAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>LASSO Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LASSO Trade Off Algorithm Specifier</em>'.
	 * @generated
	 */
	LASSOTradeOffAlgorithmSpecifier createLASSOTradeOffAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>Gradient Tree Boost Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gradient Tree Boost Trade Off Algorithm Specifier</em>'.
	 * @generated
	 */
	GradientTreeBoostTradeOffAlgorithmSpecifier createGradientTreeBoostTradeOffAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>Gaussian Process Regression Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gaussian Process Regression Trade Off Algorithm Specifier</em>'.
	 * @generated
	 */
	GaussianProcessRegressionTradeOffAlgorithmSpecifier createGaussianProcessRegressionTradeOffAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>RBF Network Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RBF Network Trade Off Algorithm Specifier</em>'.
	 * @generated
	 */
	RBFNetworkTradeOffAlgorithmSpecifier createRBFNetworkTradeOffAlgorithmSpecifier();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RecommendationPackage getRecommendationPackage();

} //RecommendationFactory
