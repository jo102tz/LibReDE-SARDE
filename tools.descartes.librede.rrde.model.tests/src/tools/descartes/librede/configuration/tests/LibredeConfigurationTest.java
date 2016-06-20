/**
 */
package tools.descartes.librede.configuration.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.LibredeConfiguration;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Librede Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LibredeConfigurationTest extends TestCase {

	/**
	 * The fixture for this Librede Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibredeConfiguration fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LibredeConfigurationTest.class);
	}

	/**
	 * Constructs a new Librede Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibredeConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Librede Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(LibredeConfiguration fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Librede Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibredeConfiguration getFixture() {
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
		setFixture(ConfigurationFactory.eINSTANCE.createLibredeConfiguration());
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

} //LibredeConfigurationTest
