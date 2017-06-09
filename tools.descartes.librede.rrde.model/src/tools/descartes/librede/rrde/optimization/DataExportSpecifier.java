/**
 */
package tools.descartes.librede.rrde.optimization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Export Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.DataExportSpecifier#getOutputDirectory <em>Output Directory</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.DataExportSpecifier#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.DataExportSpecifier#isMultidimensional <em>Multidimensional</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.DataExportSpecifier#isSplitConfigurations <em>Split Configurations</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getDataExportSpecifier()
 * @model
 * @generated
 */
public interface DataExportSpecifier extends ConfigurationOptimizationAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Output Directory</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Directory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Directory</em>' attribute.
	 * @see #setOutputDirectory(String)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getDataExportSpecifier_OutputDirectory()
	 * @model default="\"\"" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	String getOutputDirectory();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.DataExportSpecifier#getOutputDirectory <em>Output Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Directory</em>' attribute.
	 * @see #getOutputDirectory()
	 * @generated
	 */
	void setOutputDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Size</em>' attribute.
	 * @see #setStepSize(double)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getDataExportSpecifier_StepSize()
	 * @model default="1.0" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getStepSize();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.DataExportSpecifier#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' attribute.
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(double value);

	/**
	 * Returns the value of the '<em><b>Multidimensional</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multidimensional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multidimensional</em>' attribute.
	 * @see #setMultidimensional(boolean)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getDataExportSpecifier_Multidimensional()
	 * @model default="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 * @generated
	 */
	boolean isMultidimensional();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.DataExportSpecifier#isMultidimensional <em>Multidimensional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multidimensional</em>' attribute.
	 * @see #isMultidimensional()
	 * @generated
	 */
	void setMultidimensional(boolean value);

	/**
	 * Returns the value of the '<em><b>Split Configurations</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Configurations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Split Configurations</em>' attribute.
	 * @see #setSplitConfigurations(boolean)
	 * @see tools.descartes.librede.rrde.optimization.OptimizationPackage#getDataExportSpecifier_SplitConfigurations()
	 * @model default="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 * @generated
	 */
	boolean isSplitConfigurations();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.optimization.DataExportSpecifier#isSplitConfigurations <em>Split Configurations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Split Configurations</em>' attribute.
	 * @see #isSplitConfigurations()
	 * @generated
	 */
	void setSplitConfigurations(boolean value);

} // DataExportSpecifier
