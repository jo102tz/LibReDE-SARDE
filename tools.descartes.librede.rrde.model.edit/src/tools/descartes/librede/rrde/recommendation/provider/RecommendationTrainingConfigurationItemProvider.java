/**
 */
package tools.descartes.librede.rrde.recommendation.provider;


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
import tools.descartes.librede.rrde.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.optimization.provider.RrdeEditPlugin;
import tools.descartes.librede.rrde.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;

/**
 * This is the item provider adapter for a {@link tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RecommendationTrainingConfigurationItemProvider 
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
	public RecommendationTrainingConfigurationItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA);
			childrenFeatures.add(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM);
			childrenFeatures.add(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM);
			childrenFeatures.add(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS);
			childrenFeatures.add(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR);
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
	 * This returns RecommendationTrainingConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RecommendationTrainingConfiguration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_RecommendationTrainingConfiguration_type");
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

		switch (notification.getFeatureID(RecommendationTrainingConfiguration.class)) {
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS:
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
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
				(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA,
				 OptimizationFactory.eINSTANCE.createInputData()));

		newChildDescriptors.add
			(createChildParameter
				(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM,
				 RecommendationFactory.eINSTANCE.createRecommendationAlgorithmSpecifier()));

		newChildDescriptors.add
			(createChildParameter
				(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM,
				 RecommendationFactory.eINSTANCE.createFeatureExtractorSpecifier()));

		newChildDescriptors.add
			(createChildParameter
				(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS,
				 ConfigurationFactory.eINSTANCE.createEstimationSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR,
				 ConfigurationFactory.eINSTANCE.createValidationSpecification()));
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
