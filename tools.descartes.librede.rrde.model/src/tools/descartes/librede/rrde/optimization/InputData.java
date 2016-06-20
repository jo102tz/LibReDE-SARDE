/**
 */
package tools.descartes.librede.rrde.optimization;

import tools.descartes.librede.configuration.InputSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.InputData#getResultsFile <em>Results File</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData()
 * @model
 * @generated
 */
public interface InputData extends InputSpecification {
	/**
	 * Returns the value of the '<em><b>Results File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional path to a file containing the results of the data to be estimated in order to improve the performance of the algorithms.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Results File</em>' attribute.
	 * @see #setResultsFile(String)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData_ResultsFile()
	 * @model
	 * @generated
	 */
	String getResultsFile();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.InputData#getResultsFile <em>Results File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Results File</em>' attribute.
	 * @see #getResultsFile()
	 * @generated
	 */
	void setResultsFile(String value);

} // InputData
