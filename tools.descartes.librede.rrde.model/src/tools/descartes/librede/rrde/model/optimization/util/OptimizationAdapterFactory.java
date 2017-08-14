/**
 */
package tools.descartes.librede.rrde.model.optimization.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.rrde.model.optimization.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage
 * @generated
 */
public class OptimizationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OptimizationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OptimizationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimizationSwitch<Adapter> modelSwitch =
		new OptimizationSwitch<Adapter>() {
			@Override
			public Adapter caseOptimizationConfiguration(OptimizationConfiguration object) {
				return createOptimizationConfigurationAdapter();
			}
			@Override
			public Adapter caseConfigurationOptimizationAlgorithmSpecifier(ConfigurationOptimizationAlgorithmSpecifier object) {
				return createConfigurationOptimizationAlgorithmSpecifierAdapter();
			}
			@Override
			public Adapter caseLocalSearchSpecifier(LocalSearchSpecifier object) {
				return createLocalSearchSpecifierAdapter();
			}
			@Override
			public Adapter caseRunCall(RunCall object) {
				return createRunCallAdapter();
			}
			@Override
			public Adapter caseInputData(InputData object) {
				return createInputDataAdapter();
			}
			@Override
			public Adapter caseOptimizationSettings(OptimizationSettings object) {
				return createOptimizationSettingsAdapter();
			}
			@Override
			public Adapter caseIterativeParameterOptimizerSpecifier(IterativeParameterOptimizerSpecifier object) {
				return createIterativeParameterOptimizerSpecifierAdapter();
			}
			@Override
			public Adapter caseIOptimizableParameter(IOptimizableParameter object) {
				return createIOptimizableParameterAdapter();
			}
			@Override
			public Adapter caseGenericParameter(GenericParameter object) {
				return createGenericParameterAdapter();
			}
			@Override
			public Adapter caseStepSize(StepSize object) {
				return createStepSizeAdapter();
			}
			@Override
			public Adapter caseWindowSize(WindowSize object) {
				return createWindowSizeAdapter();
			}
			@Override
			public Adapter caseDataExportSpecifier(DataExportSpecifier object) {
				return createDataExportSpecifierAdapter();
			}
			@Override
			public Adapter caseStepSizeRelWindow(StepSizeRelWindow object) {
				return createStepSizeRelWindowAdapter();
			}
			@Override
			public Adapter caseClusterOptimizationSpecifier(ClusterOptimizationSpecifier object) {
				return createClusterOptimizationSpecifierAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration
	 * @generated
	 */
	public Adapter createOptimizationConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier <em>Configuration Optimization Algorithm Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier
	 * @generated
	 */
	public Adapter createConfigurationOptimizationAlgorithmSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier <em>Local Search Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier
	 * @generated
	 */
	public Adapter createLocalSearchSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.RunCall <em>Run Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.RunCall
	 * @generated
	 */
	public Adapter createRunCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.InputData <em>Input Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.InputData
	 * @generated
	 */
	public Adapter createInputDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.OptimizationSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationSettings
	 * @generated
	 */
	public Adapter createOptimizationSettingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier <em>Iterative Parameter Optimizer Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier
	 * @generated
	 */
	public Adapter createIterativeParameterOptimizerSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.IOptimizableParameter <em>IOptimizable Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.IOptimizableParameter
	 * @generated
	 */
	public Adapter createIOptimizableParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.GenericParameter <em>Generic Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.GenericParameter
	 * @generated
	 */
	public Adapter createGenericParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.StepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.StepSize
	 * @generated
	 */
	public Adapter createStepSizeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.WindowSize <em>Window Size</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.WindowSize
	 * @generated
	 */
	public Adapter createWindowSizeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.DataExportSpecifier <em>Data Export Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.DataExportSpecifier
	 * @generated
	 */
	public Adapter createDataExportSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow <em>Step Size Rel Window</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow
	 * @generated
	 */
	public Adapter createStepSizeRelWindowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier <em>Cluster Optimization Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier
	 * @generated
	 */
	public Adapter createClusterOptimizationSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OptimizationAdapterFactory
