/**
 */
package tools.descartes.librede.configuration.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ObservationToEntityMapping;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Observation To Entity Mapping</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObservationToEntityMappingTest extends TestCase {

	/**
	 * The fixture for this Observation To Entity Mapping test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObservationToEntityMapping fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ObservationToEntityMappingTest.class);
	}

	/**
	 * Constructs a new Observation To Entity Mapping test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObservationToEntityMappingTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Observation To Entity Mapping test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ObservationToEntityMapping fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Observation To Entity Mapping test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObservationToEntityMapping getFixture() {
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
		setFixture(ConfigurationFactory.eINSTANCE.createObservationToEntityMapping());
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

} //ObservationToEntityMappingTest
