/**
 */
package tools.descartes.librede.rrde.model.recommendation.tests;

import junit.textui.TestRunner;
import tools.descartes.librede.rrde.model.recommendation.DecisionTreeAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.RecommendationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Decision Tree Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DecisionTreeAlgorithmSpecifierTest extends RecommendationAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DecisionTreeAlgorithmSpecifierTest.class);
	}

	/**
	 * Constructs a new Decision Tree Algorithm Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionTreeAlgorithmSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Decision Tree Algorithm Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DecisionTreeAlgorithmSpecifier getFixture() {
		return (DecisionTreeAlgorithmSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RecommendationFactory.eINSTANCE.createDecisionTreeAlgorithmSpecifier());
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

} //DecisionTreeAlgorithmSpecifierTest
