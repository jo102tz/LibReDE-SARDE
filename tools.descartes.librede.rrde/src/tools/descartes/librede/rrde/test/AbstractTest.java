/**
 * ==============================================
 *  LibReDE : Library for Resource Demand Estimation
 * ==============================================
 *
 * (c) Copyright 2013-2014, by Simon Spinner and Contributors.
 *
 * Project Info:   http://www.descartes-research.net/
 *
 * All rights reserved. This software is made available under the terms of the
 * Eclipse Public License (EPL) v1.0 as published by the Eclipse Foundation
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * This software is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License (EPL)
 * for more details.
 *
 * You should have received a copy of the Eclipse Public License (EPL)
 * along with this software; if not visit http://www.eclipse.org or write to
 * Eclipse Foundation, Inc., 308 SW First Avenue, Suite 110, Portland, 97204 USA
 * Email: license (at) eclipse.org
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 */
package tools.descartes.librede.rrde.test;

import java.io.File;

import org.junit.BeforeClass;

import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.Plugin;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;

/**
 * @author JS
 *
 */
public class AbstractTest {

	/**
	 * The path linking to the test folder.
	 */
	public static final String TESTPATH = "resources" + File.separator + "test"
			+ File.separator + "junit";

	/**
	 * The path to the default {@link LibredeConfiguration}
	 */
	public final static String LIB_PATH = TESTPATH + File.separator
			+ "estimation.librede";

	/**
	 * The path to the default {@link OptimizationConfiguration}
	 */
	public final static String OPT_PATH = TESTPATH + File.separator
			+ "conf.optimization";

	/**
	 * The path to the default {@link RecommendationTrainingConfiguration}
	 */
	public final static String REC_PATH = TESTPATH + File.separator
			+ "conf.recommendation";
	/**
	 * The path for validation
	 */
	public static final String validationfolder = TESTPATH + File.separator
			+ "validation";
	
	/**
	 * The output path, where all output files are stored.
	 */
	public final static String OUTPUT = TESTPATH + File.separator + "output";

	static Plugin main;

	@BeforeClass
	public static void init() {
		main = new Plugin();
		main.init();
	}

}
