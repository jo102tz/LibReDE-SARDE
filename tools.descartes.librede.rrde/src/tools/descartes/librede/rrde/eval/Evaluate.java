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

import java.io.File;
import java.util.Collection;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Assert;
import org.junit.Test;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.Plugin;
import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.Discovery;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.RunCall;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;

/**
 * @author JS
 *
 */
public class Evaluate {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(Evaluate.class);

	/**
	 * A link to the desktop.
	 */
	public static final String DESKTOP = "C:" + File.separator + "Users" + File.separator + "Johannes Grohmann"
			+ File.separator + "Desktop";

	/**
	 * The path linking to the test folder.
	 */
	public static final String TESTPATH = "resources" + File.separator + "test" + File.separator + "validation";

	/**
	 * The path to the default {@link LibredeConfiguration}
	 */
	public final static String LIB_PATH = TESTPATH + File.separator + "estimation.librede";

	/**
	 * The path to the default {@link OptimizationConfiguration}
	 */
	public final static String OPT_PATH = TESTPATH + File.separator + "conf.optimization";

	/**
	 * The path to the default {@link RecommendationTrainingConfiguration}
	 */
	public final static String REC_PATH = TESTPATH + File.separator + "conf.recommendation";
	/**
	 * The path for validation
	 */
	public static final String validationfolder = DESKTOP + File.separator + "training";

	/**
	 * The path for training
	 */
	public static final String trainingfolder = DESKTOP + File.separator + "training";

	/**
	 * The output path, where all output files are stored.
	 */
	// NO IDEA WHY THIS ISNT WORKING WITH DESKTOP
	public final static String OUTPUT = TESTPATH + File.separator + "output";

	/**
	 * The testset used for validation.
	 */
	static Set<LibredeConfiguration> configs;

	/**
	 * The configuration read.
	 */
	static LibredeConfiguration librede;

	/**
	 * The optimization configuration read.
	 */
	static OptimizationConfiguration optimization;

	/**
	 * The recommendation configuration read.
	 */
	static RecommendationTrainingConfiguration recommendation;

	/**
	 * The validator used.
	 */
	static TestSetValidator vali;

	/**
	 * A PLugin instance.
	 */
	static Plugin main;

	@Test
	public void test() {
		main = new Plugin();
		main.init();
		log.info("Starting initialization");
		// load config files
		librede = Librede.loadConfiguration(new File(LIB_PATH).toPath());
		optimization = Util.loadOptimizationConfiguration(new File(OPT_PATH).toPath());
		recommendation = Util.loadRecommendationConfiguration(new File(REC_PATH).toPath());

		// discover validation configurations
		for (InputData data : recommendation.getTrainingData()) {
			data.setRootFolder(validationfolder);
		}

		configs = Discovery.createConfigurations(recommendation.getTrainingData(), librede.getEstimation(),
				librede.getValidation());

		// adapt configurations to be similar
		for (InputData data : recommendation.getTrainingData()) {
			data.setRootFolder(trainingfolder);
		}
		recommendation.setValidator(EcoreUtil.copy(librede.getValidation()));

		// adapt optimization
		for (RunCall call : optimization.getContainsOf()) {
			for (InputData data : call.getTrainingData()) {
				data.setRootFolder(trainingfolder);
			}
			call.getSettings().setValidator(EcoreUtil.copy(librede.getValidation()));
			if (call.getAlgorithm() instanceof DataExportSpecifier) {
				((DataExportSpecifier) call.getAlgorithm()).setOutputDirectory(OUTPUT);
			}

		}

		vali = new TestSetValidator(configs);
		Assert.assertNotEquals(vali.getTestset().size(), 0);
		vali.calculateInitialErrors();
		log.info("Initialized! Starting optimization...");
		long start = System.currentTimeMillis();
		// run optimization
		Collection<EstimationSpecification> estimations = new tools.descartes.librede.rrde.optimization.Plugin()
				.runConfigurationOptimization(librede, optimization, OUTPUT);
		long opti = System.currentTimeMillis() - start;
		log.info("Finished optimization! Validating...");

		// print results
		vali.compareOptimized(estimations, true);
		vali.printResults(null, opti, 0);

	}

}
