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

import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;

/**
 * This is the item provider adapter for a {@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StatisticalFeaturesItemProvider 
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
	public StatisticalFeaturesItemProvider(AdapterFactory adapterFactory) {
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

			addNPropertyDescriptor(object);
			addArithmeticMeanPropertyDescriptor(object);
			addGeometricMeanPropertyDescriptor(object);
			addStandardDeviationPropertyDescriptor(object);
			addQuadraticMeanPropertyDescriptor(object);
			addMinimumPropertyDescriptor(object);
			addMaximumPropertyDescriptor(object);
			addKurtosisPropertyDescriptor(object);
			addSkewnessPropertyDescriptor(object);
			addTenthpercentilePropertyDescriptor(object);
			addNinetiethpercentilePropertyDescriptor(object);
			addPearsonCorrelationMatrixNormPropertyDescriptor(object);
			addSpearmanCorrelationMatrixNormPropertyDescriptor(object);
			addKendallCorrelationMatrixNormPropertyDescriptor(object);
			addCovarianceMatrixNormPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the N feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_N_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_N_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__N,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Arithmetic Mean feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArithmeticMeanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_arithmeticMean_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_arithmeticMean_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__ARITHMETIC_MEAN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Geometric Mean feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeometricMeanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_geometricMean_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_geometricMean_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__GEOMETRIC_MEAN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Standard Deviation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStandardDeviationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_standardDeviation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_standardDeviation_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__STANDARD_DEVIATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Quadratic Mean feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQuadraticMeanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_quadraticMean_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_quadraticMean_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__QUADRATIC_MEAN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Minimum feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinimumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_minimum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_minimum_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__MINIMUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_maximum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_maximum_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__MAXIMUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Kurtosis feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKurtosisPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_kurtosis_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_kurtosis_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__KURTOSIS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Skewness feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSkewnessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_skewness_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_skewness_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__SKEWNESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tenthpercentile feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTenthpercentilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_tenthpercentile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_tenthpercentile_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__TENTHPERCENTILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ninetiethpercentile feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNinetiethpercentilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_ninetiethpercentile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_ninetiethpercentile_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__NINETIETHPERCENTILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pearson Correlation Matrix Norm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPearsonCorrelationMatrixNormPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_pearsonCorrelationMatrixNorm_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_pearsonCorrelationMatrixNorm_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__PEARSON_CORRELATION_MATRIX_NORM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Spearman Correlation Matrix Norm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpearmanCorrelationMatrixNormPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_spearmanCorrelationMatrixNorm_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_spearmanCorrelationMatrixNorm_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__SPEARMAN_CORRELATION_MATRIX_NORM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Kendall Correlation Matrix Norm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKendallCorrelationMatrixNormPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_kendallCorrelationMatrixNorm_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_kendallCorrelationMatrixNorm_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__KENDALL_CORRELATION_MATRIX_NORM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Covariance Matrix Norm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCovarianceMatrixNormPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StatisticalFeatures_covarianceMatrixNorm_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StatisticalFeatures_covarianceMatrixNorm_feature", "_UI_StatisticalFeatures_type"),
				 RecommendationPackage.Literals.STATISTICAL_FEATURES__COVARIANCE_MATRIX_NORM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns StatisticalFeatures.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StatisticalFeatures"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		StatisticalFeatures statisticalFeatures = (StatisticalFeatures)object;
		return getString("_UI_StatisticalFeatures_type") + " " + statisticalFeatures.getN();
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

		switch (notification.getFeatureID(StatisticalFeatures.class)) {
			case RecommendationPackage.STATISTICAL_FEATURES__N:
			case RecommendationPackage.STATISTICAL_FEATURES__ARITHMETIC_MEAN:
			case RecommendationPackage.STATISTICAL_FEATURES__GEOMETRIC_MEAN:
			case RecommendationPackage.STATISTICAL_FEATURES__STANDARD_DEVIATION:
			case RecommendationPackage.STATISTICAL_FEATURES__QUADRATIC_MEAN:
			case RecommendationPackage.STATISTICAL_FEATURES__MINIMUM:
			case RecommendationPackage.STATISTICAL_FEATURES__MAXIMUM:
			case RecommendationPackage.STATISTICAL_FEATURES__KURTOSIS:
			case RecommendationPackage.STATISTICAL_FEATURES__SKEWNESS:
			case RecommendationPackage.STATISTICAL_FEATURES__TENTHPERCENTILE:
			case RecommendationPackage.STATISTICAL_FEATURES__NINETIETHPERCENTILE:
			case RecommendationPackage.STATISTICAL_FEATURES__PEARSON_CORRELATION_MATRIX_NORM:
			case RecommendationPackage.STATISTICAL_FEATURES__SPEARMAN_CORRELATION_MATRIX_NORM:
			case RecommendationPackage.STATISTICAL_FEATURES__KENDALL_CORRELATION_MATRIX_NORM:
			case RecommendationPackage.STATISTICAL_FEATURES__COVARIANCE_MATRIX_NORM:
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
