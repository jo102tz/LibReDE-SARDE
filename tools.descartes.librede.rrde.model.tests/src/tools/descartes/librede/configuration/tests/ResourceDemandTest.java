/**
 */
package tools.descartes.librede.configuration.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ResourceDemand;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceDemandTest extends TaskTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResourceDemandTest.class);
	}

	/**
	 * Constructs a new Resource Demand test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Resource Demand test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ResourceDemand getFixture() {
		return (ResourceDemand)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationFactory.eINSTANCE.createResourceDemand());
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

} //ResourceDemandTest
