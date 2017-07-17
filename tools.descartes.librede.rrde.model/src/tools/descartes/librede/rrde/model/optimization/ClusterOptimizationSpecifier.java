/**
 */
package tools.descartes.librede.rrde.model.optimization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cluster Optimization Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier#getClusterAlgorithm <em>Cluster Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier#getSubAlgorithm <em>Sub Algorithm</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getClusterOptimizationSpecifier()
 * @model
 * @generated
 */
public interface ClusterOptimizationSpecifier extends ConfigurationOptimizationAlgorithmSpecifier {
	/**
	 * Returns the value of the '<em><b>Cluster Algorithm</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster Algorithm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster Algorithm</em>' attribute.
	 * @see #setClusterAlgorithm(String)
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getClusterOptimizationSpecifier_ClusterAlgorithm()
	 * @model default="" dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getClusterAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier#getClusterAlgorithm <em>Cluster Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster Algorithm</em>' attribute.
	 * @see #getClusterAlgorithm()
	 * @generated
	 */
	void setClusterAlgorithm(String value);

	/**
	 * Returns the value of the '<em><b>Sub Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Algorithm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Algorithm</em>' reference.
	 * @see #setSubAlgorithm(ConfigurationOptimizationAlgorithmSpecifier)
	 * @see tools.descartes.librede.rrde.model.optimization.OptimizationPackage#getClusterOptimizationSpecifier_SubAlgorithm()
	 * @model required="true"
	 * @generated
	 */
	ConfigurationOptimizationAlgorithmSpecifier getSubAlgorithm();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier#getSubAlgorithm <em>Sub Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Algorithm</em>' reference.
	 * @see #getSubAlgorithm()
	 * @generated
	 */
	void setSubAlgorithm(ConfigurationOptimizationAlgorithmSpecifier value);
	
	boolean featureCluster();

} // ClusterOptimizationSpecifier
