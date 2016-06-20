/**
 */
package tools.descartes.librede.rrde.optimization.provider;


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

import tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;

/**
 * This is the item provider adapter for a {@link tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractLocalSearchOptimizerItemProvider 
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
	public AbstractLocalSearchOptimizerItemProvider(AdapterFactory adapterFactory) {
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

			addTimeOutPropertyDescriptor(object);
			addMinimumPropertyDescriptor(object);
			addMaximumPropertyDescriptor(object);
			addTolerancePropertyDescriptor(object);
			addMaximumNumberOfStepsPropertyDescriptor(object);
			addStartValuePropertyDescriptor(object);
			addStepSizePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Time Out feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimeOutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IConfigurationOptimizationAlgorithm_timeOut_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IConfigurationOptimizationAlgorithm_timeOut_feature", "_UI_IConfigurationOptimizationAlgorithm_type"),
				 OptimizationPackage.Literals.ICONFIGURATION_OPTIMIZATION_ALGORITHM__TIME_OUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
				 getString("_UI_AbstractLocalSearchOptimizer_minimum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractLocalSearchOptimizer_minimum_feature", "_UI_AbstractLocalSearchOptimizer_type"),
				 OptimizationPackage.Literals.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MINIMUM,
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
				 getString("_UI_AbstractLocalSearchOptimizer_maximum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractLocalSearchOptimizer_maximum_feature", "_UI_AbstractLocalSearchOptimizer_type"),
				 OptimizationPackage.Literals.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tolerance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTolerancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractLocalSearchOptimizer_tolerance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractLocalSearchOptimizer_tolerance_feature", "_UI_AbstractLocalSearchOptimizer_type"),
				 OptimizationPackage.Literals.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__TOLERANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Number Of Steps feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumNumberOfStepsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractLocalSearchOptimizer_maximumNumberOfSteps_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractLocalSearchOptimizer_maximumNumberOfSteps_feature", "_UI_AbstractLocalSearchOptimizer_type"),
				 OptimizationPackage.Literals.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM_NUMBER_OF_STEPS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Start Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractLocalSearchOptimizer_startValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractLocalSearchOptimizer_startValue_feature", "_UI_AbstractLocalSearchOptimizer_type"),
				 OptimizationPackage.Literals.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__START_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Step Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStepSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractLocalSearchOptimizer_stepSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractLocalSearchOptimizer_stepSize_feature", "_UI_AbstractLocalSearchOptimizer_type"),
				 OptimizationPackage.Literals.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__STEP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns AbstractLocalSearchOptimizer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AbstractLocalSearchOptimizer"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		AbstractLocalSearchOptimizer abstractLocalSearchOptimizer = (AbstractLocalSearchOptimizer)object;
		return getString("_UI_AbstractLocalSearchOptimizer_type") + " " + abstractLocalSearchOptimizer.getTimeOut();
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

		switch (notification.getFeatureID(AbstractLocalSearchOptimizer.class)) {
			case OptimizationPackage.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__TIME_OUT:
			case OptimizationPackage.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MINIMUM:
			case OptimizationPackage.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM:
			case OptimizationPackage.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__TOLERANCE:
			case OptimizationPackage.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__MAXIMUM_NUMBER_OF_STEPS:
			case OptimizationPackage.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__START_VALUE:
			case OptimizationPackage.ABSTRACT_LOCAL_SEARCH_OPTIMIZER__STEP_SIZE:
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
