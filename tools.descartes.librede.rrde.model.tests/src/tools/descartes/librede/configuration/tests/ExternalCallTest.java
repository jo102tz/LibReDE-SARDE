/**
 */
package tools.descartes.librede.configuration.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ExternalCall;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>External Call</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalCallTest extends TaskTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExternalCallTest.class);
	}

	/**
	 * Constructs a new External Call test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this External Call test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ExternalCall getFixture() {
		return (ExternalCall)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationFactory.eINSTANCE.createExternalCall());
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

} //ExternalCallTest
