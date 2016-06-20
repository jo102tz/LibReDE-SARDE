/**
 */
package tools.descartes.librede.configuration.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.FileTraceConfiguration;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>File Trace Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FileTraceConfigurationTest extends TraceConfigurationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FileTraceConfigurationTest.class);
	}

	/**
	 * Constructs a new File Trace Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileTraceConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this File Trace Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected FileTraceConfiguration getFixture() {
		return (FileTraceConfiguration)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationFactory.eINSTANCE.createFileTraceConfiguration());
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

} //FileTraceConfigurationTest
