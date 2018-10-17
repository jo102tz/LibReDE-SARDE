/**
 */
package tools.descartes.librede.rrde.model.optimization.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;

/**
 * This is the item provider adapter for a {@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IterativeParameterOptimizerSpecifierItemProvider extends ConfigurationOptimizationAlgorithmSpecifierItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterativeParameterOptimizerSpecifierItemProvider(AdapterFactory adapterFactory) {
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

			addNumberOfSplitsPropertyDescriptor(object);
			addNumberOfExplorationsPropertyDescriptor(object);
			addNumberOfIterationsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Number Of Splits feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfSplitsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterativeParameterOptimizerSpecifier_numberOfSplits_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterativeParameterOptimizerSpecifier_numberOfSplits_feature", "_UI_IterativeParameterOptimizerSpecifier_type"),
				 OptimizationPackage.Literals.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number Of Explorations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfExplorationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterativeParameterOptimizerSpecifier_numberOfExplorations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterativeParameterOptimizerSpecifier_numberOfExplorations_feature", "_UI_IterativeParameterOptimizerSpecifier_type"),
				 OptimizationPackage.Literals.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number Of Iterations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfIterationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterativeParameterOptimizerSpecifier_numberOfIterations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterativeParameterOptimizerSpecifier_numberOfIterations_feature", "_UI_IterativeParameterOptimizerSpecifier_type"),
				 OptimizationPackage.Literals.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns IterativeParameterOptimizerSpecifier.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IterativeParameterOptimizerSpecifier"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IterativeParameterOptimizerSpecifier)object).getAlgorithmName();
		return label == null || label.length() == 0 ?
			getString("_UI_IterativeParameterOptimizerSpecifier_type") :
			getString("_UI_IterativeParameterOptimizerSpecifier_type") + " " + label;
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

		switch (notification.getFeatureID(IterativeParameterOptimizerSpecifier.class)) {
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS:
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS:
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS:
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
