/**
 */
package tools.descartes.librede.rrde.recommendation.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tools.descartes.librede.rrde.optimization.provider.RrdeEditPlugin;

import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * This is the item provider adapter for a {@link tools.descartes.librede.rrde.recommendation.FeatureVector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureVectorItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureVectorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNumberOfRessourcesPropertyDescriptor(object);
			addNumberOfWorkloadClassesPropertyDescriptor(object);
			addVarianceInflationFactorPropertyDescriptor(object);
			addUtilizationStatisticsPropertyDescriptor(object);
			addResponseTimeStatisticsPropertyDescriptor(object);
			addArrivalRateStatisticsPropertyDescriptor(object);
			addResponseArrivalCorrelationPropertyDescriptor(object);
			addResponseArrivalCovariancePropertyDescriptor(object);
			addUtilizationResponseCorrelationPropertyDescriptor(object);
			addUtilizationResponseCovariancePropertyDescriptor(object);
			addUtilizationArrivalCorrelationPropertyDescriptor(object);
			addUtilizationArrivalCovariancePropertyDescriptor(object);
			addInterUtilizationCorrelationPropertyDescriptor(object);
			addInterUtilizationCovariancePropertyDescriptor(object);
			addInterResponseTimeCorrelationPropertyDescriptor(object);
			addInterResponseTimeCovariancePropertyDescriptor(object);
			addInterArrivalRateCorrelationPropertyDescriptor(object);
			addInterArrivalRateCovariancePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Number Of Ressources feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfRessourcesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_numberOfRessources_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_numberOfRessources_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__NUMBER_OF_RESSOURCES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number Of Workload Classes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfWorkloadClassesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_numberOfWorkloadClasses_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_numberOfWorkloadClasses_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Variance Inflation Factor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVarianceInflationFactorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_varianceInflationFactor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_varianceInflationFactor_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Utilization Statistics feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUtilizationStatisticsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_utilizationStatistics_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_utilizationStatistics_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__UTILIZATION_STATISTICS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Response Time Statistics feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResponseTimeStatisticsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_responseTimeStatistics_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_responseTimeStatistics_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Arrival Rate Statistics feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArrivalRateStatisticsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_arrivalRateStatistics_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_arrivalRateStatistics_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__ARRIVAL_RATE_STATISTICS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Response Arrival Correlation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResponseArrivalCorrelationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_responseArrivalCorrelation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_responseArrivalCorrelation_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Response Arrival Covariance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResponseArrivalCovariancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_responseArrivalCovariance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_responseArrivalCovariance_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Utilization Response Correlation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUtilizationResponseCorrelationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_utilizationResponseCorrelation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_utilizationResponseCorrelation_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Utilization Response Covariance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUtilizationResponseCovariancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_utilizationResponseCovariance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_utilizationResponseCovariance_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Utilization Arrival Correlation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUtilizationArrivalCorrelationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_utilizationArrivalCorrelation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_utilizationArrivalCorrelation_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Utilization Arrival Covariance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUtilizationArrivalCovariancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_utilizationArrivalCovariance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_utilizationArrivalCovariance_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inter Utilization Correlation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInterUtilizationCorrelationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_interUtilizationCorrelation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_interUtilizationCorrelation_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inter Utilization Covariance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInterUtilizationCovariancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_interUtilizationCovariance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_interUtilizationCovariance_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inter Response Time Correlation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInterResponseTimeCorrelationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_interResponseTimeCorrelation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_interResponseTimeCorrelation_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inter Response Time Covariance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInterResponseTimeCovariancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_interResponseTimeCovariance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_interResponseTimeCovariance_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inter Arrival Rate Correlation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInterArrivalRateCorrelationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_interArrivalRateCorrelation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_interArrivalRateCorrelation_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inter Arrival Rate Covariance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInterArrivalRateCovariancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureVector_interArrivalRateCovariance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureVector_interArrivalRateCovariance_feature", "_UI_FeatureVector_type"),
				 RecommendationPackage.Literals.FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns FeatureVector.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FeatureVector"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		FeatureVector featureVector = (FeatureVector)object;
		return getString("_UI_FeatureVector_type") + " " + featureVector.getNumberOfRessources();
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(FeatureVector.class)) {
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES:
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES:
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION:
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE:
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION:
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE:
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION:
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE:
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION:
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE:
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION:
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE:
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION:
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return RrdeEditPlugin.INSTANCE;
	}

}
