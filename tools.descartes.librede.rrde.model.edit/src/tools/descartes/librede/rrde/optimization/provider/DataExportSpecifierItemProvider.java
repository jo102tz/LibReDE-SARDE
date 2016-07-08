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

import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;

/**
 * This is the item provider adapter for a {@link tools.descartes.librede.rrde.optimization.DataExportSpecifier} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataExportSpecifierItemProvider 
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
	public DataExportSpecifierItemProvider(AdapterFactory adapterFactory) {
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
			addAlgorithmNamePropertyDescriptor(object);
			addOutputDirectoryPropertyDescriptor(object);
			addMultidimensionalPropertyDescriptor(object);
			addSplitConfigurationsPropertyDescriptor(object);
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
				 getString("_UI_IConfigurationOptimizationAlgorithmSpecifier_timeOut_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IConfigurationOptimizationAlgorithmSpecifier_timeOut_feature", "_UI_IConfigurationOptimizationAlgorithmSpecifier_type"),
				 OptimizationPackage.Literals.ICONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__TIME_OUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Algorithm Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlgorithmNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IConfigurationOptimizationAlgorithmSpecifier_algorithmName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IConfigurationOptimizationAlgorithmSpecifier_algorithmName_feature", "_UI_IConfigurationOptimizationAlgorithmSpecifier_type"),
				 OptimizationPackage.Literals.ICONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER__ALGORITHM_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Directory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputDirectoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataExportSpecifier_OutputDirectory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataExportSpecifier_OutputDirectory_feature", "_UI_DataExportSpecifier_type"),
				 OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Multidimensional feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMultidimensionalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataExportSpecifier_multidimensional_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataExportSpecifier_multidimensional_feature", "_UI_DataExportSpecifier_type"),
				 OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Split Configurations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSplitConfigurationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataExportSpecifier_splitConfigurations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataExportSpecifier_splitConfigurations_feature", "_UI_DataExportSpecifier_type"),
				 OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_DataExportSpecifier_stepSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataExportSpecifier_stepSize_feature", "_UI_DataExportSpecifier_type"),
				 OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER__STEP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns DataExportSpecifier.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DataExportSpecifier"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DataExportSpecifier)object).getAlgorithmName();
		return label == null || label.length() == 0 ?
			getString("_UI_DataExportSpecifier_type") :
			getString("_UI_DataExportSpecifier_type") + " " + label;
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

		switch (notification.getFeatureID(DataExportSpecifier.class)) {
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__TIME_OUT:
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__ALGORITHM_NAME:
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY:
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL:
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS:
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__STEP_SIZE:
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
