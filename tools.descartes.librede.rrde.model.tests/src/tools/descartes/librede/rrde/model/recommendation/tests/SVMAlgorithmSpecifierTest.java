/**
 */
package tools.descartes.librede.rrde.model.recommendation.tests;

import junit.textui.TestRunner;
import tools.descartes.librede.rrde.model.recommendation.RecommendationFactory;
import tools.descartes.librede.rrde.model.recommendation.SVMAlgorithmSpecifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SVM Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SVMAlgorithmSpecifierTest extends RecommendationAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SVMAlgorithmSpecifierTest.class);
	}

	/**
	 * Constructs a new SVM Algorithm Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVMAlgorithmSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SVM Algorithm Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SVMAlgorithmSpecifier getFixture() {
		return (SVMAlgorithmSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RecommendationFactory.eINSTANCE.createSVMAlgorithmSpecifier());
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

} //SVMAlgorithmSpecifierTest
