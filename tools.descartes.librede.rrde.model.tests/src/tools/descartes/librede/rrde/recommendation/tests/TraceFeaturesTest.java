/**
 */
package tools.descartes.librede.rrde.recommendation.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.recommendation.TraceFeatures;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Trace Features</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceFeaturesTest extends TestCase {

	/**
	 * The fixture for this Trace Features test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceFeatures fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TraceFeaturesTest.class);
	}

	/**
	 * Constructs a new Trace Features test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFeaturesTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Trace Features test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(TraceFeatures fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Trace Features test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceFeatures getFixture() {
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
		setFixture(RecommendationFactory.eINSTANCE.createTraceFeatures());
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

} //TraceFeaturesTest
