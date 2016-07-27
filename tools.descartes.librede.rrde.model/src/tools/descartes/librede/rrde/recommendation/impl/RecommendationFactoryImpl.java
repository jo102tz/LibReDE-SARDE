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
			case RecommendationPackage.IRECOMMENDATION_ALGORITHM_SPECIFIER: return createIRecommendationAlgorithmSpecifier();
			case RecommendationPackage.DATA_SET: return createDataSet();
			case RecommendationPackage.IFEATURE_EXTRACTOR_SPECIFIER: return createIFeatureExtractorSpecifier();
			case RecommendationPackage.FEATURE_VECTOR: return createFeatureVector();
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
	public IRecommendationAlgorithmSpecifier createIRecommendationAlgorithmSpecifier() {
		IRecommendationAlgorithmSpecifierImpl iRecommendationAlgorithmSpecifier = new IRecommendationAlgorithmSpecifierImpl();
		return iRecommendationAlgorithmSpecifier;
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
	public IFeatureExtractorSpecifier createIFeatureExtractorSpecifier() {
		IFeatureExtractorSpecifierImpl iFeatureExtractorSpecifier = new IFeatureExtractorSpecifierImpl();
		return iFeatureExtractorSpecifier;
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
