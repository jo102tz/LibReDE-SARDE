/**
 */
package tools.descartes.librede.rrde.optimization.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.optimization.WindowSize;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Window Size</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WindowSizeTest extends TestCase {

	/**
	 * The fixture for this Window Size test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowSize fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(WindowSizeTest.class);
	}

	/**
	 * Constructs a new Window Size test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindowSizeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Window Size test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(WindowSize fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Window Size test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowSize getFixture() {
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
		setFixture(OptimizationFactory.eINSTANCE.createWindowSize());
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

} //WindowSizeTest
