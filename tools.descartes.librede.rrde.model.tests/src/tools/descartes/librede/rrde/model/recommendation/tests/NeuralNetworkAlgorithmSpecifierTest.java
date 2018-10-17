/**
 */
package tools.descartes.librede.rrde.model.recommendation.tests;

import junit.textui.TestRunner;
import tools.descartes.librede.rrde.model.recommendation.NeuralNetworkAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.RecommendationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Neural Network Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NeuralNetworkAlgorithmSpecifierTest extends RecommendationAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NeuralNetworkAlgorithmSpecifierTest.class);
	}

	/**
	 * Constructs a new Neural Network Algorithm Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NeuralNetworkAlgorithmSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Neural Network Algorithm Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NeuralNetworkAlgorithmSpecifier getFixture() {
		return (NeuralNetworkAlgorithmSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RecommendationFactory.eINSTANCE.createNeuralNetworkAlgorithmSpecifier());
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

} //NeuralNetworkAlgorithmSpecifierTest
