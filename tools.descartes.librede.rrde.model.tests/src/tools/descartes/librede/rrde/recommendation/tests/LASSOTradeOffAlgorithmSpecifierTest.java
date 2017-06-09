/**
 */
package tools.descartes.librede.rrde.recommendation.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.recommendation.LASSOTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>LASSO Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LASSOTradeOffAlgorithmSpecifierTest extends RecommendationTradeOffAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LASSOTradeOffAlgorithmSpecifierTest.class);
	}

	/**
	 * Constructs a new LASSO Trade Off Algorithm Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LASSOTradeOffAlgorithmSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this LASSO Trade Off Algorithm Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LASSOTradeOffAlgorithmSpecifier getFixture() {
		return (LASSOTradeOffAlgorithmSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RecommendationFactory.eINSTANCE.createLASSOTradeOffAlgorithmSpecifier());
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

} //LASSOTradeOffAlgorithmSpecifierTest
