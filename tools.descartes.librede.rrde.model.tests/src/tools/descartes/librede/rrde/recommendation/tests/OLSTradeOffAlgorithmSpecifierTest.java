/**
 */
package tools.descartes.librede.rrde.recommendation.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.recommendation.OLSTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>OLS Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OLSTradeOffAlgorithmSpecifierTest extends RecommendationTradeOffAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OLSTradeOffAlgorithmSpecifierTest.class);
	}

	/**
	 * Constructs a new OLS Trade Off Algorithm Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OLSTradeOffAlgorithmSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this OLS Trade Off Algorithm Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OLSTradeOffAlgorithmSpecifier getFixture() {
		return (OLSTradeOffAlgorithmSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RecommendationFactory.eINSTANCE.createOLSTradeOffAlgorithmSpecifier());
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

} //OLSTradeOffAlgorithmSpecifierTest
