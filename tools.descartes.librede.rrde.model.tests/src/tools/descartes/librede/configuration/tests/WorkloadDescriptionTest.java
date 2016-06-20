/**
 */
package tools.descartes.librede.configuration.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.WorkloadDescription;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Workload Description</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkloadDescriptionTest extends TestCase {

	/**
	 * The fixture for this Workload Description test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkloadDescription fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(WorkloadDescriptionTest.class);
	}

	/**
	 * Constructs a new Workload Description test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkloadDescriptionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Workload Description test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(WorkloadDescription fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Workload Description test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkloadDescription getFixture() {
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
		setFixture(ConfigurationFactory.eINSTANCE.createWorkloadDescription());
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

} //WorkloadDescriptionTest
