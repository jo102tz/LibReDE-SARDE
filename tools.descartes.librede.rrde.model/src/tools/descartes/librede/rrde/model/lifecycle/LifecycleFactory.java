/**
 */
package tools.descartes.librede.rrde.model.lifecycle;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tools.descartes.librede.rrde.model.lifecycle.LifecyclePackage
 * @generated
 */
public interface LifecycleFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LifecycleFactory eINSTANCE = tools.descartes.librede.rrde.model.lifecycle.impl.LifecycleFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Life Cycle Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Life Cycle Configuration</em>'.
	 * @generated
	 */
	LifeCycleConfiguration createLifeCycleConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LifecyclePackage getLifecyclePackage();

} //LifecycleFactory
