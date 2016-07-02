/**
 */
package tools.descartes.librede.rrde.optimization.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import tools.descartes.librede.rrde.optimization.util.OptimizationAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OptimizationItemProviderAdapterFactory extends OptimizationAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.OptimizationConfiguration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimizationConfigurationItemProvider optimizationConfigurationItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.OptimizationConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOptimizationConfigurationAdapter() {
		if (optimizationConfigurationItemProvider == null) {
			optimizationConfigurationItemProvider = new OptimizationConfigurationItemProvider(this);
		}

		return optimizationConfigurationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.LocalSearchSpecifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalSearchSpecifierItemProvider localSearchSpecifierItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.LocalSearchSpecifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLocalSearchSpecifierAdapter() {
		if (localSearchSpecifierItemProvider == null) {
			localSearchSpecifierItemProvider = new LocalSearchSpecifierItemProvider(this);
		}

		return localSearchSpecifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.RunCall} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunCallItemProvider runCallItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.RunCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRunCallAdapter() {
		if (runCallItemProvider == null) {
			runCallItemProvider = new RunCallItemProvider(this);
		}

		return runCallItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.InputData} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputDataItemProvider inputDataItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.InputData}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInputDataAdapter() {
		if (inputDataItemProvider == null) {
			inputDataItemProvider = new InputDataItemProvider(this);
		}

		return inputDataItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.OptimizationSettings} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimizationSettingsItemProvider optimizationSettingsItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.OptimizationSettings}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOptimizationSettingsAdapter() {
		if (optimizationSettingsItemProvider == null) {
			optimizationSettingsItemProvider = new OptimizationSettingsItemProvider(this);
		}

		return optimizationSettingsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.IterativeParameterOptimizerSpecifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterativeParameterOptimizerSpecifierItemProvider iterativeParameterOptimizerSpecifierItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.IterativeParameterOptimizerSpecifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIterativeParameterOptimizerSpecifierAdapter() {
		if (iterativeParameterOptimizerSpecifierItemProvider == null) {
			iterativeParameterOptimizerSpecifierItemProvider = new IterativeParameterOptimizerSpecifierItemProvider(this);
		}

		return iterativeParameterOptimizerSpecifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.GenericParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericParameterItemProvider genericParameterItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.GenericParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGenericParameterAdapter() {
		if (genericParameterItemProvider == null) {
			genericParameterItemProvider = new GenericParameterItemProvider(this);
		}

		return genericParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.StepSize} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StepSizeItemProvider stepSizeItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.StepSize}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStepSizeAdapter() {
		if (stepSizeItemProvider == null) {
			stepSizeItemProvider = new StepSizeItemProvider(this);
		}

		return stepSizeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.WindowSize} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowSizeItemProvider windowSizeItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.WindowSize}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWindowSizeAdapter() {
		if (windowSizeItemProvider == null) {
			windowSizeItemProvider = new WindowSizeItemProvider(this);
		}

		return windowSizeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link tools.descartes.librede.rrde.optimization.DataExportSpecifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataExportSpecifierItemProvider dataExportSpecifierItemProvider;

	/**
	 * This creates an adapter for a {@link tools.descartes.librede.rrde.optimization.DataExportSpecifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataExportSpecifierAdapter() {
		if (dataExportSpecifierItemProvider == null) {
			dataExportSpecifierItemProvider = new DataExportSpecifierItemProvider(this);
		}

		return dataExportSpecifierItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (optimizationConfigurationItemProvider != null) optimizationConfigurationItemProvider.dispose();
		if (localSearchSpecifierItemProvider != null) localSearchSpecifierItemProvider.dispose();
		if (runCallItemProvider != null) runCallItemProvider.dispose();
		if (inputDataItemProvider != null) inputDataItemProvider.dispose();
		if (optimizationSettingsItemProvider != null) optimizationSettingsItemProvider.dispose();
		if (iterativeParameterOptimizerSpecifierItemProvider != null) iterativeParameterOptimizerSpecifierItemProvider.dispose();
		if (genericParameterItemProvider != null) genericParameterItemProvider.dispose();
		if (stepSizeItemProvider != null) stepSizeItemProvider.dispose();
		if (windowSizeItemProvider != null) windowSizeItemProvider.dispose();
		if (dataExportSpecifierItemProvider != null) dataExportSpecifierItemProvider.dispose();
	}

}
