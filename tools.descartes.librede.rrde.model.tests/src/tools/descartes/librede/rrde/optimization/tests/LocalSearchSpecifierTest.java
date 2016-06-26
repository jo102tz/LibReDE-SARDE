/**
 */
package tools.descartes.librede.rrde.optimization.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.optimization.OptimizationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Local Search Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocalSearchSpecifierTest extends TestCase {

	/**
	 * The fixture for this Local Search Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalSearchSpecifier fixture = null;

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
	 * Sets the fixture for this Local Search Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(LocalSearchSpecifier fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Local Search Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalSearchSpecifier getFixture() {
		return fixture;
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
