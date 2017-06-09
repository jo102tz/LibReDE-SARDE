/**
 */
package tools.descartes.librede.rrde.recommendation.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Random Forest Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomForestTradeOffAlgorithmSpecifierTest extends RecommendationTradeOffAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RandomForestTradeOffAlgorithmSpecifierTest.class);
	}

	/**
	 * Constructs a new Random Forest Trade Off Algorithm Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomForestTradeOffAlgorithmSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Random Forest Trade Off Algorithm Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RandomForestTradeOffAlgorithmSpecifier getFixture() {
		return (RandomForestTradeOffAlgorithmSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RecommendationFactory.eINSTANCE.createRandomForestTradeOffAlgorithmSpecifier());
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

} //RandomForestTradeOffAlgorithmSpecifierTest
