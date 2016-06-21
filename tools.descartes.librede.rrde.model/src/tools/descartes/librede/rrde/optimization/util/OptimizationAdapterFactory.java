/**
 */
package tools.descartes.librede.rrde.optimization.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import tools.descartes.librede.rrde.optimization.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage
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
			public Adapter caseIConfigurationOptimizationAlgorithm(IConfigurationOptimizationAlgorithm object) {
				return createIConfigurationOptimizationAlgorithmAdapter();
			}
			@Override
			public Adapter caseAbstractLocalSearchOptimizer(AbstractLocalSearchOptimizer object) {
				return createAbstractLocalSearchOptimizerAdapter();
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
			public Adapter caseAbstractIterativeParameterOptimizer(AbstractIterativeParameterOptimizer object) {
				return createAbstractIterativeParameterOptimizerAdapter();
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
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.optimization.OptimizationConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationConfiguration
	 * @generated
	 */
	public Adapter createOptimizationConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm <em>IConfiguration Optimization Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm
	 * @generated
	 */
	public Adapter createIConfigurationOptimizationAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer <em>Abstract Local Search Optimizer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.optimization.AbstractLocalSearchOptimizer
	 * @generated
	 */
	public Adapter createAbstractLocalSearchOptimizerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.optimization.RunCall <em>Run Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.optimization.RunCall
	 * @generated
	 */
	public Adapter createRunCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.optimization.InputData <em>Input Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.optimization.InputData
	 * @generated
	 */
	public Adapter createInputDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.optimization.OptimizationSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.optimization.OptimizationSettings
	 * @generated
	 */
	public Adapter createOptimizationSettingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer <em>Abstract Iterative Parameter Optimizer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer
	 * @generated
	 */
	public Adapter createAbstractIterativeParameterOptimizerAdapter() {
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
