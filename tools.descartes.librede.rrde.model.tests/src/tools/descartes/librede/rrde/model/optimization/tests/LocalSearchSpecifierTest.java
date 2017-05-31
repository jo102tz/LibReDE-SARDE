/**
 */
package tools.descartes.librede.rrde.model.optimization.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.model.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Local Search Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocalSearchSpecifierTest extends ConfigurationOptimizationAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LocalSearchSpecifierTest.class);
	}

	/**
	 * Constructs a new Local Search Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalSearchSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Local Search Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LocalSearchSpecifier getFixture() {
		return (LocalSearchSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OptimizationFactory.eINSTANCE.createLocalSearchSpecifier());
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

} //LocalSearchSpecifierTest
