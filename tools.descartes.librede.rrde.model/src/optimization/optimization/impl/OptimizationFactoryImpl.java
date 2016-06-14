/**
 */
package optimization.optimization.impl;

import optimization.optimization.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OptimizationFactoryImpl extends EFactoryImpl implements OptimizationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OptimizationFactory init() {
		try {
			OptimizationFactory theOptimizationFactory = (OptimizationFactory)EPackage.Registry.INSTANCE.getEFactory(OptimizationPackage.eNS_URI);
			if (theOptimizationFactory != null) {
				return theOptimizationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OptimizationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationFactoryImpl() {
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
			case OptimizationPackage.OPTIMIZATION_CONFIGURATION: return createOptimizationConfiguration();
			case OptimizationPackage.HILL_CLIMBING_SETTINGS: return createHillClimbingSettings();
			case OptimizationPackage.RUN_CALL: return createRunCall();
			case OptimizationPackage.INPUT_DATA: return createInputData();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationConfiguration createOptimizationConfiguration() {
		OptimizationConfigurationImpl optimizationConfiguration = new OptimizationConfigurationImpl();
		return optimizationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HillClimbingSettings createHillClimbingSettings() {
		HillClimbingSettingsImpl hillClimbingSettings = new HillClimbingSettingsImpl();
		return hillClimbingSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunCall createRunCall() {
		RunCallImpl runCall = new RunCallImpl();
		return runCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputData createInputData() {
		InputDataImpl inputData = new InputDataImpl();
		return inputData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationPackage getOptimizationPackage() {
		return (OptimizationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OptimizationPackage getPackage() {
		return OptimizationPackage.eINSTANCE;
	}

} //OptimizationFactoryImpl
