/**
 */
package tools.descartes.librede.rrde.model.optimization.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tools.descartes.librede.rrde.model.optimization.*;

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
			case OptimizationPackage.CONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER: return createConfigurationOptimizationAlgorithmSpecifier();
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER: return createLocalSearchSpecifier();
			case OptimizationPackage.RUN_CALL: return createRunCall();
			case OptimizationPackage.INPUT_DATA: return createInputData();
			case OptimizationPackage.OPTIMIZATION_SETTINGS: return createOptimizationSettings();
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER: return createIterativeParameterOptimizerSpecifier();
			case OptimizationPackage.GENERIC_PARAMETER: return createGenericParameter();
			case OptimizationPackage.STEP_SIZE: return createStepSize();
			case OptimizationPackage.WINDOW_SIZE: return createWindowSize();
			case OptimizationPackage.DATA_EXPORT_SPECIFIER: return createDataExportSpecifier();
			case OptimizationPackage.STEP_SIZE_REL_WINDOW: return createStepSizeRelWindow();
			case OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER: return createClusterOptimizationSpecifier();
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
	public ConfigurationOptimizationAlgorithmSpecifier createConfigurationOptimizationAlgorithmSpecifier() {
		ConfigurationOptimizationAlgorithmSpecifierImpl configurationOptimizationAlgorithmSpecifier = new ConfigurationOptimizationAlgorithmSpecifierImpl();
		return configurationOptimizationAlgorithmSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalSearchSpecifier createLocalSearchSpecifier() {
		LocalSearchSpecifierImpl localSearchSpecifier = new LocalSearchSpecifierImpl();
		return localSearchSpecifier;
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
	public OptimizationSettings createOptimizationSettings() {
		OptimizationSettingsImpl optimizationSettings = new OptimizationSettingsImpl();
		return optimizationSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterativeParameterOptimizerSpecifier createIterativeParameterOptimizerSpecifier() {
		IterativeParameterOptimizerSpecifierImpl iterativeParameterOptimizerSpecifier = new IterativeParameterOptimizerSpecifierImpl();
		return iterativeParameterOptimizerSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericParameter createGenericParameter() {
		GenericParameterImpl genericParameter = new GenericParameterImpl();
		return genericParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepSize createStepSize() {
		StepSizeImpl stepSize = new StepSizeImpl();
		return stepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindowSize createWindowSize() {
		WindowSizeImpl windowSize = new WindowSizeImpl();
		return windowSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataExportSpecifier createDataExportSpecifier() {
		DataExportSpecifierImpl dataExportSpecifier = new DataExportSpecifierImpl();
		return dataExportSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepSizeRelWindow createStepSizeRelWindow() {
		StepSizeRelWindowImpl stepSizeRelWindow = new StepSizeRelWindowImpl();
		return stepSizeRelWindow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusterOptimizationSpecifier createClusterOptimizationSpecifier() {
		ClusterOptimizationSpecifierImpl clusterOptimizationSpecifier = new ClusterOptimizationSpecifierImpl();
		return clusterOptimizationSpecifier;
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
