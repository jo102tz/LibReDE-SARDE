/**
 */
package tools.descartes.librede.rrde.model.recommendation.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.model.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Statistical Features</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatisticalFeaturesTest extends TestCase {

	/**
	 * The fixture for this Statistical Features test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatisticalFeatures fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StatisticalFeaturesTest.class);
	}

	/**
	 * Constructs a new Statistical Features test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeaturesTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Statistical Features test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(StatisticalFeatures fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Statistical Features test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatisticalFeatures getFixture() {
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
		setFixture(RecommendationFactory.eINSTANCE.createStatisticalFeatures());
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

} //StatisticalFeaturesTest
