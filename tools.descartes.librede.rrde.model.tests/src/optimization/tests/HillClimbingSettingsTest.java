/**
 */
package optimization.tests;

import junit.textui.TestRunner;

import optimization.HillClimbingSettings;
import optimization.OptimizationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Hill Climbing Settings</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HillClimbingSettingsTest extends ConfigurationSettingsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(HillClimbingSettingsTest.class);
	}

	/**
	 * Constructs a new Hill Climbing Settings test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HillClimbingSettingsTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Hill Climbing Settings test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected HillClimbingSettings getFixture() {
		return (HillClimbingSettings)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OptimizationFactory.eINSTANCE.createHillClimbingSettings());
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

} //HillClimbingSettingsTest
