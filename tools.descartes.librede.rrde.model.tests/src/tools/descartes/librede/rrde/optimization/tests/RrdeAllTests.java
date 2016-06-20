/**
 */
package tools.descartes.librede.rrde.optimization.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

import tools.descartes.librede.configuration.tests.ConfigurationTests;

import tools.descartes.librede.metrics.tests.MetricsTests;

import tools.descartes.librede.units.tests.UnitsTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Rrde</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class RrdeAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new RrdeAllTests("Rrde Tests");
		suite.addTest(OptimizationTests.suite());
		suite.addTest(ConfigurationTests.suite());
		suite.addTest(UnitsTests.suite());
		suite.addTest(MetricsTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RrdeAllTests(String name) {
		super(name);
	}

} //RrdeAllTests
