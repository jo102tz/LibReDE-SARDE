/**
 */
package tools.descartes.librede.rrde.model.optimization.tests;

import junit.textui.TestRunner;
import tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Cluster Optimization Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClusterOptimizationSpecifierTest extends ConfigurationOptimizationAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ClusterOptimizationSpecifierTest.class);
	}

	/**
	 * Constructs a new Cluster Optimization Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusterOptimizationSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Cluster Optimization Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ClusterOptimizationSpecifier getFixture() {
		return (ClusterOptimizationSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OptimizationFactory.eINSTANCE.createClusterOptimizationSpecifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ClusterOptimizationSpecifierTest
