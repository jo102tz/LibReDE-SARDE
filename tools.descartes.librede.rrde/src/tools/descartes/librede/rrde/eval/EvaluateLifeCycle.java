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
package tools.descartes.librede.rrde.eval;

import static org.junit.Assert.fail;

import java.io.File;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.FileTraceConfiguration;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.TraceConfiguration;
import tools.descartes.librede.configuration.ValidationSpecification;
import tools.descartes.librede.rrde.Plugin;
import tools.descartes.librede.rrde.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.lifecycle.LifeCycleController;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.util.Util;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class EvaluateLifeCycle {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(EvaluateLifeCycle.class);

	/**
	 * A link to the desktop.
	 */
	public static final String DESKTOP = "C:" + File.separator + "Users" + File.separator + "Johannes" + File.separator
			+ "Desktop";

	/**
	 * The path linking to the test folder.
	 */
	public static final String TESTPATH = "resources" + File.separator + "test" + File.separator + "validation"
			+ File.separator + "lifecycle" + File.separator + "persistence";

	/**
	 * The path to the default {@link LibredeConfiguration}
	 */
	public final static String LIB_PATH = TESTPATH + File.separator + "persistence-estimation.librede";

	public final static String CONF_PATH = TESTPATH + File.separator + "tstore.lifecycle";

	/**
	 * The path for training
	 */
	public static final String datafolder = DESKTOP + File.separator + "librede" + File.separator + "short traces";

	/**
	 * The output path, where all output files are stored.
	 */
	// NO IDEA WHY THIS ISNT WORKING WITH DESKTOP
	public final static String OUTPUT = TESTPATH + File.separator + "output";

	/**
	 * The configuration read.
	 */
	static LibredeConfiguration librede;

	/**
	 * The lifecycle configuration read.
	 */
	static LifeCycleConfiguration conf;

	/**
	 * The validator used.
	 */
	static TestSetValidator vali;

	/**
	 * A Plugin instance.
	 */
	static Plugin main;

	/**
	 * The {@link ValidationSpecification} to be used for calculating the error
	 * values.
	 */
	static ValidationSpecification validator;

	@Test
	public void test() {
		main = new Plugin();
		main.init();

		// load config files
		librede = Librede.loadConfiguration(new File(LIB_PATH).toPath());
		conf = Util.loadLifecycleConfiguration(new File(CONF_PATH).toPath());
		validator = librede.getValidation();

		// adapt configurations to be similar
//		for (InputData data : conf.getRecommendationConfiguration().getTrainingData()) {
//			data.setRootFolder(datafolder);
//		}
//		conf.getRecommendationConfiguration().setValidator(EcoreUtil.copy(validator));

		// adapt optimization
		for (RunCall call : conf.getOptimizationConfiguration().getContainsOf()) {
			for (InputData data : call.getTrainingData()) {
				data.setRootFolder(datafolder);
			}
			call.getSettings().setValidator(EcoreUtil.copy(validator));
			if (call.getAlgorithm() instanceof DataExportSpecifier) {
				((DataExportSpecifier) call.getAlgorithm()).setOutputDirectory(OUTPUT);
			}

		}

		// adapt librede files
		for (TraceConfiguration e : librede.getInput().getObservations()){
			FileTraceConfiguration ftrace = (FileTraceConfiguration) e;
			String filename = ftrace.getFile();
			ftrace.setFile(datafolder+File.separator+filename);
		}

		log.info("Finished initialization");

		LifeCycleController lcc = new LifeCycleController();
		try {
			lcc.startLifeCycle(conf, librede);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail();
		}

	}
}
