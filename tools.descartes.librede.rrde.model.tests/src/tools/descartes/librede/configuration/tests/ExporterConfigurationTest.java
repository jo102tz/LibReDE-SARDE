/**
 */
package tools.descartes.librede.configuration.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ExporterConfiguration;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exporter Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExporterConfigurationTest extends TestCase {

	/**
	 * The fixture for this Exporter Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExporterConfiguration fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExporterConfigurationTest.class);
	}

	/**
	 * Constructs a new Exporter Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExporterConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Exporter Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ExporterConfiguration fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Exporter Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExporterConfiguration getFixture() {
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
		setFixture(ConfigurationFactory.eINSTANCE.createExporterConfiguration());
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

} //ExporterConfigurationTest
