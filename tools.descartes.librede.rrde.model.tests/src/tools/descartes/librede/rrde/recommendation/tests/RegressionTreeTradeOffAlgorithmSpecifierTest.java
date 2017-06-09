/**
 */
package tools.descartes.librede.rrde.recommendation.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Regression Tree Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RegressionTreeTradeOffAlgorithmSpecifierTest extends RecommendationTradeOffAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RegressionTreeTradeOffAlgorithmSpecifierTest.class);
	}

	/**
	 * Constructs a new Regression Tree Trade Off Algorithm Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegressionTreeTradeOffAlgorithmSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Regression Tree Trade Off Algorithm Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RegressionTreeTradeOffAlgorithmSpecifier getFixture() {
		return (RegressionTreeTradeOffAlgorithmSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RecommendationFactory.eINSTANCE.createRegressionTreeTradeOffAlgorithmSpecifier());
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

} //RegressionTreeTradeOffAlgorithmSpecifierTest
