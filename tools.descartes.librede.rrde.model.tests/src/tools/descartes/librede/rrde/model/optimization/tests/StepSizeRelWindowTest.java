/**
 */
package tools.descartes.librede.rrde.model.optimization.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;
import tools.descartes.librede.rrde.model.optimization.StepSizeRelWindow;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Step Size Rel Window</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StepSizeRelWindowTest extends StepSizeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StepSizeRelWindowTest.class);
	}

	/**
	 * Constructs a new Step Size Rel Window test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepSizeRelWindowTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Step Size Rel Window test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StepSizeRelWindow getFixture() {
		return (StepSizeRelWindow)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OptimizationFactory.eINSTANCE.createStepSizeRelWindow());
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

} //StepSizeRelWindowTest
