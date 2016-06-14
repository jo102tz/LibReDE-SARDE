/**
 */
package optimization.provider;


import java.util.Collection;
import java.util.List;

import optimization.HillClimbingSettings;
import optimization.OptimizationPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link optimization.HillClimbingSettings} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class HillClimbingSettingsItemProvider extends SettingsItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HillClimbingSettingsItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_HillClimbingSettings_minimum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HillClimbingSettings_minimum_feature", "_UI_HillClimbingSettings_type"),
				 OptimizationPackage.Literals.HILL_CLIMBING_SETTINGS__MINIMUM,
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
				 getString("_UI_HillClimbingSettings_maximum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HillClimbingSettings_maximum_feature", "_UI_HillClimbingSettings_type"),
				 OptimizationPackage.Literals.HILL_CLIMBING_SETTINGS__MAXIMUM,
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
				 getString("_UI_HillClimbingSettings_tolerance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HillClimbingSettings_tolerance_feature", "_UI_HillClimbingSettings_type"),
				 OptimizationPackage.Literals.HILL_CLIMBING_SETTINGS__TOLERANCE,
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
				 getString("_UI_HillClimbingSettings_maximumNumberOfSteps_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HillClimbingSettings_maximumNumberOfSteps_feature", "_UI_HillClimbingSettings_type"),
				 OptimizationPackage.Literals.HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS,
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
				 getString("_UI_HillClimbingSettings_startValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HillClimbingSettings_startValue_feature", "_UI_HillClimbingSettings_type"),
				 OptimizationPackage.Literals.HILL_CLIMBING_SETTINGS__START_VALUE,
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
				 getString("_UI_HillClimbingSettings_stepSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HillClimbingSettings_stepSize_feature", "_UI_HillClimbingSettings_type"),
				 OptimizationPackage.Literals.HILL_CLIMBING_SETTINGS__STEP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns HillClimbingSettings.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/HillClimbingSettings"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		HillClimbingSettings hillClimbingSettings = (HillClimbingSettings)object;
		return getString("_UI_HillClimbingSettings_type") + " " + hillClimbingSettings.getTimeOut();
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

		switch (notification.getFeatureID(HillClimbingSettings.class)) {
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MINIMUM:
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM:
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__TOLERANCE:
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS:
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__START_VALUE:
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__STEP_SIZE:
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

}
