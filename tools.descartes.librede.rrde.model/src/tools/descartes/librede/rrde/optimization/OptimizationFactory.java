/**
 */
package tools.descartes.librede.rrde.optimization;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage
 * @generated
 */
public interface OptimizationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OptimizationFactory eINSTANCE = tools.descartes.librede.rrde.optimization.impl.OptimizationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	OptimizationConfiguration createOptimizationConfiguration();

	/**
	 * Returns a new object of class '<em>Configuration Optimization Algorithm Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration Optimization Algorithm Specifier</em>'.
	 * @generated
	 */
	ConfigurationOptimizationAlgorithmSpecifier createConfigurationOptimizationAlgorithmSpecifier();

	/**
	 * Returns a new object of class '<em>Local Search Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Search Specifier</em>'.
	 * @generated
	 */
	LocalSearchSpecifier createLocalSearchSpecifier();

	/**
	 * Returns a new object of class '<em>Run Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Run Call</em>'.
	 * @generated
	 */
	RunCall createRunCall();

	/**
	 * Returns a new object of class '<em>Input Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Data</em>'.
	 * @generated
	 */
	InputData createInputData();

	/**
	 * Returns a new object of class '<em>Settings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Settings</em>'.
	 * @generated
	 */
	OptimizationSettings createOptimizationSettings();

	/**
	 * Returns a new object of class '<em>Iterative Parameter Optimizer Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterative Parameter Optimizer Specifier</em>'.
	 * @generated
	 */
	IterativeParameterOptimizerSpecifier createIterativeParameterOptimizerSpecifier();

	/**
	 * Returns a new object of class '<em>Generic Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Parameter</em>'.
	 * @generated
	 */
	GenericParameter createGenericParameter();

	/**
	 * Returns a new object of class '<em>Step Size</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Step Size</em>'.
	 * @generated
	 */
	StepSize createStepSize();

	/**
	 * Returns a new object of class '<em>Window Size</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Window Size</em>'.
	 * @generated
	 */
	WindowSize createWindowSize();

	/**
	 * Returns a new object of class '<em>Data Export Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Export Specifier</em>'.
	 * @generated
	 */
	DataExportSpecifier createDataExportSpecifier();

	/**
	 * Returns a new object of class '<em>Step Size Rel Window</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Step Size Rel Window</em>'.
	 * @generated
	 */
	StepSizeRelWindow createStepSizeRelWindow();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OptimizationPackage getOptimizationPackage();

} //OptimizationFactory
