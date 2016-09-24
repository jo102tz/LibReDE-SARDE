/**
 */
package tools.descartes.librede.rrde.recommendation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.rrde.recommendation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage
 * @generated
 */
public class RecommendationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RecommendationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RecommendationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecommendationSwitch<Adapter> modelSwitch =
		new RecommendationSwitch<Adapter>() {
			@Override
			public Adapter caseRecommendationTrainingConfiguration(RecommendationTrainingConfiguration object) {
				return createRecommendationTrainingConfigurationAdapter();
			}
			@Override
			public Adapter caseRecommendationAlgorithmSpecifier(RecommendationAlgorithmSpecifier object) {
				return createRecommendationAlgorithmSpecifierAdapter();
			}
			@Override
			public Adapter caseFeatureExtractorSpecifier(FeatureExtractorSpecifier object) {
				return createFeatureExtractorSpecifierAdapter();
			}
			@Override
			public Adapter caseDataSet(DataSet object) {
				return createDataSetAdapter();
			}
			@Override
			public Adapter caseFeatureVector(FeatureVector object) {
				return createFeatureVectorAdapter();
			}
			@Override
			public Adapter caseStatisticalFeatures(StatisticalFeatures object) {
				return createStatisticalFeaturesAdapter();
			}
			@Override
			public Adapter caseDecisionTreeAlgorithmSpecifier(DecisionTreeAlgorithmSpecifier object) {
				return createDecisionTreeAlgorithmSpecifierAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration <em>Training Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration
	 * @generated
	 */
	public Adapter createRecommendationTrainingConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier <em>Algorithm Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier
	 * @generated
	 */
	public Adapter createRecommendationAlgorithmSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier <em>Feature Extractor Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier
	 * @generated
	 */
	public Adapter createFeatureExtractorSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.recommendation.DataSet <em>Data Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.recommendation.DataSet
	 * @generated
	 */
	public Adapter createDataSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.recommendation.FeatureVector <em>Feature Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.recommendation.FeatureVector
	 * @generated
	 */
	public Adapter createFeatureVectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures <em>Statistical Features</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.recommendation.StatisticalFeatures
	 * @generated
	 */
	public Adapter createStatisticalFeaturesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier <em>Decision Tree Algorithm Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier
	 * @generated
	 */
	public Adapter createDecisionTreeAlgorithmSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RecommendationAdapterFactory
