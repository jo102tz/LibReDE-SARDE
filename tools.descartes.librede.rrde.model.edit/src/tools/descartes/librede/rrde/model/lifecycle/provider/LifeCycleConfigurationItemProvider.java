/**
 */
package tools.descartes.librede.rrde.model.lifecycle.provider;


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

import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage;

/**
 * This is the item provider adapter for a {@link tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LifeCycleConfigurationItemProvider 
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
	public LifeCycleConfigurationItemProvider(AdapterFactory adapterFactory) {
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

			addRecommendationLoopTimePropertyDescriptor(object);
			addOptimizationLoopTimePropertyDescriptor(object);
			addSelectionLoopTimePropertyDescriptor(object);
			addRecommendationConfigurationPropertyDescriptor(object);
			addOptimizationConfigurationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Recommendation Loop Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRecommendationLoopTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LifeCycleConfiguration_recommendationLoopTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LifeCycleConfiguration_recommendationLoopTime_feature", "_UI_LifeCycleConfiguration_type"),
				 LifecyclePackage.Literals.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Optimization Loop Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOptimizationLoopTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LifeCycleConfiguration_optimizationLoopTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LifeCycleConfiguration_optimizationLoopTime_feature", "_UI_LifeCycleConfiguration_type"),
				 LifecyclePackage.Literals.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Selection Loop Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectionLoopTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LifeCycleConfiguration_selectionLoopTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LifeCycleConfiguration_selectionLoopTime_feature", "_UI_LifeCycleConfiguration_type"),
				 LifecyclePackage.Literals.LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Recommendation Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRecommendationConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LifeCycleConfiguration_recommendationConfiguration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LifeCycleConfiguration_recommendationConfiguration_feature", "_UI_LifeCycleConfiguration_type"),
				 LifecyclePackage.Literals.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_CONFIGURATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Optimization Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOptimizationConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LifeCycleConfiguration_optimizationConfiguration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LifeCycleConfiguration_optimizationConfiguration_feature", "_UI_LifeCycleConfiguration_type"),
				 LifecyclePackage.Literals.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_CONFIGURATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns LifeCycleConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LifeCycleConfiguration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		LifeCycleConfiguration lifeCycleConfiguration = (LifeCycleConfiguration)object;
		return getString("_UI_LifeCycleConfiguration_type") + " " + lifeCycleConfiguration.getRecommendationLoopTime();
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

		switch (notification.getFeatureID(LifeCycleConfiguration.class)) {
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__RECOMMENDATION_LOOP_TIME:
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__OPTIMIZATION_LOOP_TIME:
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION__SELECTION_LOOP_TIME:
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
