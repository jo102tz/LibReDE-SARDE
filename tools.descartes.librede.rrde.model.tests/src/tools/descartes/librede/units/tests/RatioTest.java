/**
 */
package tools.descartes.librede.units.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.units.Ratio;
import tools.descartes.librede.units.UnitsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ratio</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RatioTest extends DimensionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RatioTest.class);
	}

	/**
	 * Constructs a new Ratio test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RatioTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Ratio test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Ratio getFixture() {
		return (Ratio)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(UnitsFactory.eINSTANCE.createRatio());
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

} //RatioTest
