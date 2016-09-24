/**
 */
package tools.descartes.librede.rrde.optimization;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.configuration.InputSpecification;
import tools.descartes.librede.configuration.WorkloadDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.InputData#getInput <em>Input</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.InputData#getWorkloadDescription <em>Workload Description</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.InputData#getRootFolder <em>Root Folder</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.InputData#isMultiFolderStructures <em>Multi Folder Structures</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData()
 * @model
 * @generated
 */
public interface InputData extends EObject {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference.
	 * @see #setInput(InputSpecification)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData_Input()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InputSpecification getInput();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.InputData#getInput <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' containment reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(InputSpecification value);

	/**
	 * Returns the value of the '<em><b>Workload Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workload Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workload Description</em>' containment reference.
	 * @see #setWorkloadDescription(WorkloadDescription)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData_WorkloadDescription()
	 * @model containment="true" required="true"
	 * @generated
	 */
	WorkloadDescription getWorkloadDescription();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.InputData#getWorkloadDescription <em>Workload Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workload Description</em>' containment reference.
	 * @see #getWorkloadDescription()
	 * @generated
	 */
	void setWorkloadDescription(WorkloadDescription value);

	/**
	 * Returns the value of the '<em><b>Root Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Folder</em>' attribute.
	 * @see #setRootFolder(String)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData_RootFolder()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	String getRootFolder();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.InputData#getRootFolder <em>Root Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Folder</em>' attribute.
	 * @see #getRootFolder()
	 * @generated
	 */
	void setRootFolder(String value);

	/**
	 * Returns the value of the '<em><b>Multi Folder Structures</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Folder Structures</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Folder Structures</em>' attribute.
	 * @see #setMultiFolderStructures(boolean)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getInputData_MultiFolderStructures()
	 * @model default="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 * @generated
	 */
	boolean isMultiFolderStructures();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.InputData#isMultiFolderStructures <em>Multi Folder Structures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Folder Structures</em>' attribute.
	 * @see #isMultiFolderStructures()
	 * @generated
	 */
	void setMultiFolderStructures(boolean value);

} // InputData
