/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tools.descartes.librede.rrde.recommendation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecommendationFactoryImpl extends EFactoryImpl implements RecommendationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RecommendationFactory init() {
		try {
			RecommendationFactory theRecommendationFactory = (RecommendationFactory)EPackage.Registry.INSTANCE.getEFactory(RecommendationPackage.eNS_URI);
			if (theRecommendationFactory != null) {
				return theRecommendationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RecommendationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION: return createRecommendationTrainingConfiguration();
			case RecommendationPackage.RECOMMENDATION_ALGORITHM_SPECIFIER: return createRecommendationAlgorithmSpecifier();
			case RecommendationPackage.FEATURE_EXTRACTOR_SPECIFIER: return createFeatureExtractorSpecifier();
			case RecommendationPackage.DATA_SET: return createDataSet();
			case RecommendationPackage.FEATURE_VECTOR: return createFeatureVector();
			case RecommendationPackage.STATISTICAL_FEATURES: return createStatisticalFeatures();
			case RecommendationPackage.DECISION_TREE_ALGORITHM_SPECIFIER: return createDecisionTreeAlgorithmSpecifier();
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER: return createNeuralNetworkAlgorithmSpecifier();
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER: return createSVMAlgorithmSpecifier();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationTrainingConfiguration createRecommendationTrainingConfiguration() {
		RecommendationTrainingConfigurationImpl recommendationTrainingConfiguration = new RecommendationTrainingConfigurationImpl();
		return recommendationTrainingConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationAlgorithmSpecifier createRecommendationAlgorithmSpecifier() {
		RecommendationAlgorithmSpecifierImpl recommendationAlgorithmSpecifier = new RecommendationAlgorithmSpecifierImpl();
		return recommendationAlgorithmSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureExtractorSpecifier createFeatureExtractorSpecifier() {
		FeatureExtractorSpecifierImpl featureExtractorSpecifier = new FeatureExtractorSpecifierImpl();
		return featureExtractorSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSet createDataSet() {
		DataSetImpl dataSet = new DataSetImpl();
		return dataSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureVector createFeatureVector() {
		FeatureVectorImpl featureVector = new FeatureVectorImpl();
		return featureVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeatures createStatisticalFeatures() {
		StatisticalFeaturesImpl statisticalFeatures = new StatisticalFeaturesImpl();
		return statisticalFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionTreeAlgorithmSpecifier createDecisionTreeAlgorithmSpecifier() {
		DecisionTreeAlgorithmSpecifierImpl decisionTreeAlgorithmSpecifier = new DecisionTreeAlgorithmSpecifierImpl();
		return decisionTreeAlgorithmSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NeuralNetworkAlgorithmSpecifier createNeuralNetworkAlgorithmSpecifier() {
		NeuralNetworkAlgorithmSpecifierImpl neuralNetworkAlgorithmSpecifier = new NeuralNetworkAlgorithmSpecifierImpl();
		return neuralNetworkAlgorithmSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVMAlgorithmSpecifier createSVMAlgorithmSpecifier() {
		SVMAlgorithmSpecifierImpl svmAlgorithmSpecifier = new SVMAlgorithmSpecifierImpl();
		return svmAlgorithmSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationPackage getRecommendationPackage() {
		return (RecommendationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RecommendationPackage getPackage() {
		return RecommendationPackage.eINSTANCE;
	}

} //RecommendationFactoryImpl
