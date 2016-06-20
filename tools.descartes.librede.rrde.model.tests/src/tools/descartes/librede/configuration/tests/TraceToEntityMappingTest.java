/**
 */
package tools.descartes.librede.configuration.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.TraceToEntityMapping;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Trace To Entity Mapping</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceToEntityMappingTest extends ObservationToEntityMappingTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TraceToEntityMappingTest.class);
	}

	/**
	 * Constructs a new Trace To Entity Mapping test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceToEntityMappingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Trace To Entity Mapping test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TraceToEntityMapping getFixture() {
		return (TraceToEntityMapping)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationFactory.eINSTANCE.createTraceToEntityMapping());
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

} //TraceToEntityMappingTest
