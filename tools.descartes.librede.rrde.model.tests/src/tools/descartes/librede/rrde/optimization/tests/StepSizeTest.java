/**
 */
package tools.descartes.librede.rrde.optimization.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.optimization.StepSize;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Step Size</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StepSizeTest extends TestCase {

	/**
	 * The fixture for this Step Size test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StepSize fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StepSizeTest.class);
	}

	/**
	 * Constructs a new Step Size test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepSizeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Step Size test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(StepSize fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Step Size test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StepSize getFixture() {
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
		setFixture(OptimizationFactory.eINSTANCE.createStepSize());
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

} //StepSizeTest
