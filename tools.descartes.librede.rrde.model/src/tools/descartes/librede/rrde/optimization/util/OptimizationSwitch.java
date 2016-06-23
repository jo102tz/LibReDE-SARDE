/**
 */
package tools.descartes.librede.rrde.optimization.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
			case OptimizationPackage.ICONFIGURATION_OPTIMIZATION_ALGORITHM_SPECIFIER: {
				IConfigurationOptimizationAlgorithmSpecifier iConfigurationOptimizationAlgorithmSpecifier = (IConfigurationOptimizationAlgorithmSpecifier)theEObject;
				T result = caseIConfigurationOptimizationAlgorithmSpecifier(iConfigurationOptimizationAlgorithmSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER: {
				LocalSearchSpecifier localSearchSpecifier = (LocalSearchSpecifier)theEObject;
				T result = caseLocalSearchSpecifier(localSearchSpecifier);
				if (result == null) result = caseIConfigurationOptimizationAlgorithmSpecifier(localSearchSpecifier);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.OPTIMIZATION_SETTINGS: {
				OptimizationSettings optimizationSettings = (OptimizationSettings)theEObject;
				T result = caseOptimizationSettings(optimizationSettings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER: {
				IterativeParameterOptimizerSpecifier iterativeParameterOptimizerSpecifier = (IterativeParameterOptimizerSpecifier)theEObject;
				T result = caseIterativeParameterOptimizerSpecifier(iterativeParameterOptimizerSpecifier);
				if (result == null) result = caseIConfigurationOptimizationAlgorithmSpecifier(iterativeParameterOptimizerSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.IOPTIMIZABLE_PARAMETER: {
				IOptimizableParameter iOptimizableParameter = (IOptimizableParameter)theEObject;
				T result = caseIOptimizableParameter(iOptimizableParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.GENERIC_PARAMETER: {
				GenericParameter genericParameter = (GenericParameter)theEObject;
				T result = caseGenericParameter(genericParameter);
				if (result == null) result = caseIOptimizableParameter(genericParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.STEP_SIZE: {
				StepSize stepSize = (StepSize)theEObject;
				T result = caseStepSize(stepSize);
				if (result == null) result = caseIOptimizableParameter(stepSize);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OptimizationPackage.WINDOW_SIZE: {
				WindowSize windowSize = (WindowSize)theEObject;
				T result = caseWindowSize(windowSize);
				if (result == null) result = caseIOptimizableParameter(windowSize);
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
	 * Returns the result of interpreting the object as an instance of '<em>IConfiguration Optimization Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IConfiguration Optimization Algorithm Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIConfigurationOptimizationAlgorithmSpecifier(IConfigurationOptimizationAlgorithmSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Search Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Search Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalSearchSpecifier(LocalSearchSpecifier object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Iterative Parameter Optimizer Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterative Parameter Optimizer Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterativeParameterOptimizerSpecifier(IterativeParameterOptimizerSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IOptimizable Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IOptimizable Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIOptimizableParameter(IOptimizableParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericParameter(GenericParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step Size</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step Size</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStepSize(StepSize object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Window Size</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Window Size</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWindowSize(WindowSize object) {
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
