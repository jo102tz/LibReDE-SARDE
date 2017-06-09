/**
 */
package tools.descartes.librede.rrde.recommendation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tools.descartes.librede.rrde.recommendation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage
 * @generated
 */
public class RecommendationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RecommendationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationSwitch() {
		if (modelPackage == null) {
			modelPackage = RecommendationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION: {
				RecommendationTrainingConfiguration recommendationTrainingConfiguration = (RecommendationTrainingConfiguration)theEObject;
				T result = caseRecommendationTrainingConfiguration(recommendationTrainingConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.RECOMMENDATION_ALGORITHM_SPECIFIER: {
				RecommendationAlgorithmSpecifier recommendationAlgorithmSpecifier = (RecommendationAlgorithmSpecifier)theEObject;
				T result = caseRecommendationAlgorithmSpecifier(recommendationAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER: {
				FeatureExtractorSpecifier featureExtractorSpecifier = (FeatureExtractorSpecifier)theEObject;
				T result = caseFeatureExtractorSpecifier(featureExtractorSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.DATA_SET: {
				DataSet dataSet = (DataSet)theEObject;
				T result = caseDataSet(dataSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.FEATURE_VECTOR: {
				FeatureVector featureVector = (FeatureVector)theEObject;
				T result = caseFeatureVector(featureVector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.STATISTICAL_FEATURES: {
				StatisticalFeatures statisticalFeatures = (StatisticalFeatures)theEObject;
				T result = caseStatisticalFeatures(statisticalFeatures);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.DECISION_TREE_ALGORITHM_SPECIFIER: {
				DecisionTreeAlgorithmSpecifier decisionTreeAlgorithmSpecifier = (DecisionTreeAlgorithmSpecifier)theEObject;
				T result = caseDecisionTreeAlgorithmSpecifier(decisionTreeAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(decisionTreeAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER: {
				NeuralNetworkAlgorithmSpecifier neuralNetworkAlgorithmSpecifier = (NeuralNetworkAlgorithmSpecifier)theEObject;
				T result = caseNeuralNetworkAlgorithmSpecifier(neuralNetworkAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(neuralNetworkAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER: {
				SVMAlgorithmSpecifier svmAlgorithmSpecifier = (SVMAlgorithmSpecifier)theEObject;
				T result = caseSVMAlgorithmSpecifier(svmAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(svmAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER: {
				RegressionTreeTradeOffAlgorithmSpecifier regressionTreeTradeOffAlgorithmSpecifier = (RegressionTreeTradeOffAlgorithmSpecifier)theEObject;
				T result = caseRegressionTreeTradeOffAlgorithmSpecifier(regressionTreeTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationTradeOffAlgorithmSpecifier(regressionTreeTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(regressionTreeTradeOffAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.OLS_TRADE_OFF_ALGORITHM_SPECIFIER: {
				OLSTradeOffAlgorithmSpecifier olsTradeOffAlgorithmSpecifier = (OLSTradeOffAlgorithmSpecifier)theEObject;
				T result = caseOLSTradeOffAlgorithmSpecifier(olsTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationTradeOffAlgorithmSpecifier(olsTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(olsTradeOffAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.RECOMMENDATION_TRADE_OFF_ALGORITHM_SPECIFIER: {
				RecommendationTradeOffAlgorithmSpecifier recommendationTradeOffAlgorithmSpecifier = (RecommendationTradeOffAlgorithmSpecifier)theEObject;
				T result = caseRecommendationTradeOffAlgorithmSpecifier(recommendationTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(recommendationTradeOffAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER: {
				RandomForestTradeOffAlgorithmSpecifier randomForestTradeOffAlgorithmSpecifier = (RandomForestTradeOffAlgorithmSpecifier)theEObject;
				T result = caseRandomForestTradeOffAlgorithmSpecifier(randomForestTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationTradeOffAlgorithmSpecifier(randomForestTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(randomForestTradeOffAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.LASSO_TRADE_OFF_ALGORITHM_SPECIFIER: {
				LASSOTradeOffAlgorithmSpecifier lassoTradeOffAlgorithmSpecifier = (LASSOTradeOffAlgorithmSpecifier)theEObject;
				T result = caseLASSOTradeOffAlgorithmSpecifier(lassoTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationTradeOffAlgorithmSpecifier(lassoTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(lassoTradeOffAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.GRADIENT_TREE_BOOST_TRADE_OFF_ALGORITHM_SPECIFIER: {
				GradientTreeBoostTradeOffAlgorithmSpecifier gradientTreeBoostTradeOffAlgorithmSpecifier = (GradientTreeBoostTradeOffAlgorithmSpecifier)theEObject;
				T result = caseGradientTreeBoostTradeOffAlgorithmSpecifier(gradientTreeBoostTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationTradeOffAlgorithmSpecifier(gradientTreeBoostTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(gradientTreeBoostTradeOffAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.GAUSSIAN_PROCESS_REGRESSION_TRADE_OFF_ALGORITHM_SPECIFIER: {
				GaussianProcessRegressionTradeOffAlgorithmSpecifier gaussianProcessRegressionTradeOffAlgorithmSpecifier = (GaussianProcessRegressionTradeOffAlgorithmSpecifier)theEObject;
				T result = caseGaussianProcessRegressionTradeOffAlgorithmSpecifier(gaussianProcessRegressionTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationTradeOffAlgorithmSpecifier(gaussianProcessRegressionTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(gaussianProcessRegressionTradeOffAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RecommendationPackage.RBF_NETWORK_TRADE_OFF_ALGORITHM_SPECIFIER: {
				RBFNetworkTradeOffAlgorithmSpecifier rbfNetworkTradeOffAlgorithmSpecifier = (RBFNetworkTradeOffAlgorithmSpecifier)theEObject;
				T result = caseRBFNetworkTradeOffAlgorithmSpecifier(rbfNetworkTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationTradeOffAlgorithmSpecifier(rbfNetworkTradeOffAlgorithmSpecifier);
				if (result == null) result = caseRecommendationAlgorithmSpecifier(rbfNetworkTradeOffAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Training Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Training Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecommendationTrainingConfiguration(RecommendationTrainingConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecommendationAlgorithmSpecifier(RecommendationAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Extractor Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Extractor Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureExtractorSpecifier(FeatureExtractorSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSet(DataSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Vector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Vector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureVector(FeatureVector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statistical Features</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statistical Features</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatisticalFeatures(StatisticalFeatures object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decision Tree Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decision Tree Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecisionTreeAlgorithmSpecifier(DecisionTreeAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Neural Network Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Neural Network Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNeuralNetworkAlgorithmSpecifier(NeuralNetworkAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SVM Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SVM Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSVMAlgorithmSpecifier(SVMAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regression Tree Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regression Tree Trade Off Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegressionTreeTradeOffAlgorithmSpecifier(RegressionTreeTradeOffAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OLS Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OLS Trade Off Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOLSTradeOffAlgorithmSpecifier(OLSTradeOffAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trade Off Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecommendationTradeOffAlgorithmSpecifier(RecommendationTradeOffAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Forest Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Forest Trade Off Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomForestTradeOffAlgorithmSpecifier(RandomForestTradeOffAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LASSO Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LASSO Trade Off Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLASSOTradeOffAlgorithmSpecifier(LASSOTradeOffAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gradient Tree Boost Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gradient Tree Boost Trade Off Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGradientTreeBoostTradeOffAlgorithmSpecifier(GradientTreeBoostTradeOffAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gaussian Process Regression Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gaussian Process Regression Trade Off Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaussianProcessRegressionTradeOffAlgorithmSpecifier(GaussianProcessRegressionTradeOffAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RBF Network Trade Off Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RBF Network Trade Off Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRBFNetworkTradeOffAlgorithmSpecifier(RBFNetworkTradeOffAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //RecommendationSwitch
