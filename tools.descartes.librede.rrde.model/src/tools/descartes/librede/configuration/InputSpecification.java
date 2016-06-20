/**
 */
package tools.descartes.librede.configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.InputSpecification#getDataSources <em>Data Sources</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.InputSpecification#getObservations <em>Observations</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.InputSpecification#getConstantDataPoints <em>Constant Data Points</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.configuration.ConfigurationPackage#getInputSpecification()
 * @model
 * @generated
 */
public interface InputSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Sources</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.DataSourceConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Sources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Sources</em>' containment reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getInputSpecification_DataSources()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DataSourceConfiguration> getDataSources();

	/**
	 * Returns the value of the '<em><b>Observations</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.TraceConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observations</em>' containment reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getInputSpecification_Observations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceConfiguration> getObservations();

	/**
	 * Returns the value of the '<em><b>Constant Data Points</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.configuration.ConstantDataPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Data Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Data Points</em>' containment reference list.
	 * @see tools.descartes.librede.configuration.ConfigurationPackage#getInputSpecification_ConstantDataPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstantDataPoint> getConstantDataPoints();

} // InputSpecification
