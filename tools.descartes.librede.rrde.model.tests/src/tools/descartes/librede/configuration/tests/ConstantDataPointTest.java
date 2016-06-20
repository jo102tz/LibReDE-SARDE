/**
 */
package tools.descartes.librede.configuration.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.ConstantDataPoint;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Constant Data Point</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstantDataPointTest extends ObservationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConstantDataPointTest.class);
	}

	/**
	 * Constructs a new Constant Data Point test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantDataPointTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Constant Data Point test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ConstantDataPoint getFixture() {
		return (ConstantDataPoint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationFactory.eINSTANCE.createConstantDataPoint());
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

} //ConstantDataPointTest
