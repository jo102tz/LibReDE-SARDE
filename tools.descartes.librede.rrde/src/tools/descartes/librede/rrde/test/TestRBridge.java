package tools.descartes.librede.rrde.test;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.rinterface.ICallbackEvaluator;
import tools.descartes.librede.rrde.rinterface.RBridge;

/**
 * 
 * @author Johannes
 *
 */
public class TestRBridge extends AbstractTest {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestOptimization.class);

	@Test(timeout=5000)
	public void test() {
		RBridge bridge = RBridge.getInstance();
		try {
			bridge.runOptimization(null, null, 0, 0, 0);
		} catch (NullPointerException e) {
			// supposed to happen
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			fail("RBridge did not respont to null values.");
		}
		bridge.runOptimization(Collections.emptyList(), new ICallbackEvaluator() {

			@Override
			public double evaluate(Map<IOptimizableParameter, Double> params) {
				return 0;
			}
		}, 0, 0, 0);

	}

}
