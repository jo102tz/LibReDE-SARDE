/**
 */
package tools.descartes.librede.rrde.model.recommendation.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.model.recommendation.RecommendationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Feature Vector</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureVectorTest extends TestCase {

	/**
	 * The fixture for this Feature Vector test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureVector fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FeatureVectorTest.class);
	}

	/**
	 * Constructs a new Feature Vector test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureVectorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Feature Vector test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(FeatureVector fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Feature Vector test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureVector getFixture() {
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
		setFixture(RecommendationFactory.eINSTANCE.createFeatureVector());
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

} //FeatureVectorTest
