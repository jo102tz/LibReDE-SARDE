/**
 */
package tools.descartes.librede.rrde.model.recommendation.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.model.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Training Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecommendationTrainingConfigurationTest extends TestCase {

	/**
	 * The fixture for this Training Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecommendationTrainingConfiguration fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RecommendationTrainingConfigurationTest.class);
	}

	/**
	 * Constructs a new Training Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationTrainingConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Training Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RecommendationTrainingConfiguration fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Training Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecommendationTrainingConfiguration getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RecommendationFactory.eINSTANCE.createRecommendationTrainingConfiguration());
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

} //RecommendationTrainingConfigurationTest
