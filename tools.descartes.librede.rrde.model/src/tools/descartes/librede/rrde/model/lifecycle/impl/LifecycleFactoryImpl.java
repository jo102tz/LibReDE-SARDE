/**
 */
package tools.descartes.librede.rrde.model.lifecycle.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.LifecycleFactory;
import tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LifecycleFactoryImpl extends EFactoryImpl implements LifecycleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LifecycleFactory init() {
		try {
			LifecycleFactory theLifecycleFactory = (LifecycleFactory)EPackage.Registry.INSTANCE.getEFactory(LifecyclePackage.eNS_URI);
			if (theLifecycleFactory != null) {
				return theLifecycleFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LifecycleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifecycleFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LifecyclePackage.LIFE_CYCLE_CONFIGURATION: return createLifeCycleConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifeCycleConfiguration createLifeCycleConfiguration() {
		LifeCycleConfigurationImpl lifeCycleConfiguration = new LifeCycleConfigurationImpl();
		return lifeCycleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifecyclePackage getLifecyclePackage() {
		return (LifecyclePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LifecyclePackage getPackage() {
		return LifecyclePackage.eINSTANCE;
	}

} //LifecycleFactoryImpl
