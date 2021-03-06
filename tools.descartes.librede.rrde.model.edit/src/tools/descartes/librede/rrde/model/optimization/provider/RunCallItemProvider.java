/**
 */
package tools.descartes.librede.rrde.model.optimization.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.rrde.model.lifecycle.provider.RrdeEditPlugin;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.model.optimization.RunCall;

/**
 * This is the item provider adapter for a {@link tools.descartes.librede.rrde.model.optimization.RunCall} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RunCallItemProvider 
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
	public RunCallItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OptimizationPackage.Literals.RUN_CALL__ALGORITHM);
			childrenFeatures.add(OptimizationPackage.Literals.RUN_CALL__TRAINING_DATA);
			childrenFeatures.add(OptimizationPackage.Literals.RUN_CALL__SETTINGS);
			childrenFeatures.add(OptimizationPackage.Literals.RUN_CALL__ESTIMATION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns RunCall.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RunCall"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_RunCall_type");
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

		switch (notification.getFeatureID(RunCall.class)) {
			case OptimizationPackage.RUN_CALL__ALGORITHM:
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
			case OptimizationPackage.RUN_CALL__SETTINGS:
			case OptimizationPackage.RUN_CALL__ESTIMATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(OptimizationPackage.Literals.RUN_CALL__ALGORITHM,
				 OptimizationFactory.eINSTANCE.createConfigurationOptimizationAlgorithmSpecifier()));

		newChildDescriptors.add
			(createChildParameter
				(OptimizationPackage.Literals.RUN_CALL__ALGORITHM,
				 OptimizationFactory.eINSTANCE.createLocalSearchSpecifier()));

		newChildDescriptors.add
			(createChildParameter
				(OptimizationPackage.Literals.RUN_CALL__ALGORITHM,
				 OptimizationFactory.eINSTANCE.createIterativeParameterOptimizerSpecifier()));

		newChildDescriptors.add
			(createChildParameter
				(OptimizationPackage.Literals.RUN_CALL__ALGORITHM,
				 OptimizationFactory.eINSTANCE.createDataExportSpecifier()));

		newChildDescriptors.add
			(createChildParameter
				(OptimizationPackage.Literals.RUN_CALL__ALGORITHM,
				 OptimizationFactory.eINSTANCE.createClusterOptimizationSpecifier()));

		newChildDescriptors.add
			(createChildParameter
				(OptimizationPackage.Literals.RUN_CALL__TRAINING_DATA,
				 OptimizationFactory.eINSTANCE.createInputData()));

		newChildDescriptors.add
			(createChildParameter
				(OptimizationPackage.Literals.RUN_CALL__SETTINGS,
				 OptimizationFactory.eINSTANCE.createOptimizationSettings()));

		newChildDescriptors.add
			(createChildParameter
				(OptimizationPackage.Literals.RUN_CALL__ESTIMATION,
				 ConfigurationFactory.eINSTANCE.createEstimationSpecification()));
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
