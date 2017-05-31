/**
 */
package tools.descartes.librede.rrde.model.optimization.tests;

import junit.textui.TestRunner;

import tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Iterative Parameter Optimizer Specifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IterativeParameterOptimizerSpecifierTest extends ConfigurationOptimizationAlgorithmSpecifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IterativeParameterOptimizerSpecifierTest.class);
	}

	/**
	 * Constructs a new Iterative Parameter Optimizer Specifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterativeParameterOptimizerSpecifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Iterative Parameter Optimizer Specifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IterativeParameterOptimizerSpecifier getFixture() {
		return (IterativeParameterOptimizerSpecifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OptimizationFactory.eINSTANCE.createIterativeParameterOptimizerSpecifier());
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

} //IterativeParameterOptimizerSpecifierTest
