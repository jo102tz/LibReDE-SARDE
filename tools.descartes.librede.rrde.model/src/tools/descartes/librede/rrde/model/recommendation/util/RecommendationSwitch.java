/**
 */
package tools.descartes.librede.rrde.model.recommendation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tools.descartes.librede.rrde.model.recommendation.*;

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
 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage
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
