/**
 */
package tools.descartes.librede.rrde.optimization.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tools.descartes.librede.configuration.InputSpecification;

import tools.descartes.librede.rrde.optimization.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage
 * @generated
 */
public class OptimizationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OptimizationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationSwitch() {
		if (modelPackage == null) {
			modelPackage = OptimizationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OptimizationPackage.OPTIMIZATION_CONFIGURATION: {
				OptimizationConfiguration optimizationConfiguration = (OptimizationConfiguration)theEObject;
				T result = caseOptimizationConfiguration(optimizationConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.ICONFIGURATION_OPTIMIZATION_ALGORITHM: {
				IConfigurationOptimizationAlgorithm iConfigurationOptimizationAlgorithm = (IConfigurationOptimizationAlgorithm)theEObject;
				T result = caseIConfigurationOptimizationAlgorithm(iConfigurationOptimizationAlgorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.ABSTRACT_LOCAL_SEARCH_OPTIMIZER: {
				AbstractLocalSearchOptimizer abstractLocalSearchOptimizer = (AbstractLocalSearchOptimizer)theEObject;
				T result = caseAbstractLocalSearchOptimizer(abstractLocalSearchOptimizer);
				if (result == null) result = caseIConfigurationOptimizationAlgorithm(abstractLocalSearchOptimizer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.RUN_CALL: {
				RunCall runCall = (RunCall)theEObject;
				T result = caseRunCall(runCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.INPUT_DATA: {
				InputData inputData = (InputData)theEObject;
				T result = caseInputData(inputData);
				if (result == null) result = caseInputSpecification(inputData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.OPTIMIZATION_SETTINGS: {
				OptimizationSettings optimizationSettings = (OptimizationSettings)theEObject;
				T result = caseOptimizationSettings(optimizationSettings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER: {
				AbstractIterativeParameterOptimizer abstractIterativeParameterOptimizer = (AbstractIterativeParameterOptimizer)theEObject;
				T result = caseAbstractIterativeParameterOptimizer(abstractIterativeParameterOptimizer);
				if (result == null) result = caseIConfigurationOptimizationAlgorithm(abstractIterativeParameterOptimizer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOptimizationConfiguration(OptimizationConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IConfiguration Optimization Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IConfiguration Optimization Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIConfigurationOptimizationAlgorithm(IConfigurationOptimizationAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Local Search Optimizer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Local Search Optimizer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractLocalSearchOptimizer(AbstractLocalSearchOptimizer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Run Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Run Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRunCall(RunCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputData(InputData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Settings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Settings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOptimizationSettings(OptimizationSettings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Iterative Parameter Optimizer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Iterative Parameter Optimizer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractIterativeParameterOptimizer(AbstractIterativeParameterOptimizer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputSpecification(InputSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //OptimizationSwitch
