/**
 */
package tools.descartes.librede.rrde.recommendation.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.RecommendationTradeOffAlgorithmSpecifier;

/**
 * This is the item provider adapter for a {@link tools.descartes.librede.rrde.recommendation.RecommendationTradeOffAlgorithmSpecifier} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RecommendationTradeOffAlgorithmSpecifierItemProvider extends RecommendationAlgorithmSpecifierItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationTradeOffAlgorithmSpecifierItemProvider(AdapterFactory adapterFactory) {
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

			addTradeOffAlgorithmNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Trade Off Algorithm Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTradeOffAlgorithmNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RecommendationTradeOffAlgorithmSpecifier_tradeOffAlgorithmName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RecommendationTradeOffAlgorithmSpecifier_tradeOffAlgorithmName_feature", "_UI_RecommendationTradeOffAlgorithmSpecifier_type"),
				 RecommendationPackage.Literals.RECOMMENDATION_TRADE_OFF_ALGORITHM_SPECIFIER__TRADE_OFF_ALGORITHM_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns RecommendationTradeOffAlgorithmSpecifier.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RecommendationTradeOffAlgorithmSpecifier"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((RecommendationTradeOffAlgorithmSpecifier)object).getAlgorithmName();
		return label == null || label.length() == 0 ?
			getString("_UI_RecommendationTradeOffAlgorithmSpecifier_type") :
			getString("_UI_RecommendationTradeOffAlgorithmSpecifier_type") + " " + label;
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

		switch (notification.getFeatureID(RecommendationTradeOffAlgorithmSpecifier.class)) {
			case RecommendationPackage.RECOMMENDATION_TRADE_OFF_ALGORITHM_SPECIFIER__TRADE_OFF_ALGORITHM_NAME:
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
