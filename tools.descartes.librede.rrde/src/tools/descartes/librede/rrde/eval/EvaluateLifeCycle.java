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
import tools.descartes.librede.rrde.lifecycle.LifeCycleController;
import tools.descartes.librede.rrde.model.lifecycle.LifeCycleConfiguration;
import tools.descartes.librede.rrde.model.lifecycle.impl.LifeCycleConfigurationImpl;
import tools.descartes.librede.rrde.model.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.optimization.RunCall;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.util.Util;

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
			+ File.separator + "lifecycle" + File.separator + "petstore";

	/**
	 * The path to the default {@link LibredeConfiguration}
	 */
	public final static String LIB_PATH = TESTPATH + File.separator + "petstore.librede";
	
	public final static String LIB_ALL_PATH = TESTPATH + File.separator + "petstore-allConf.librede";

	public final static String CONF_PATH = TESTPATH + File.separator + "petstore.lifecycle";

	public final static String OPT_PATH = TESTPATH + File.separator + "petstore.optimization";

	public final static String RECO_PATH = TESTPATH + File.separator + "petstore.recommendation";

	/**
	 * The path for training
	 */
	public static final String datafolder = DESKTOP + File.separator + "data-save-master" + File.separator
			+ "experiment1_1" + File.separator + "my_export";

	/**
	 * The output path, where all output files are stored.
	 */
	public final static String OUTPUT = TESTPATH + File.separator + "output";

	@Test
	public void test() {
		Plugin main = new Plugin();
		main.init();

		// load config files
		LibredeConfiguration librede = Librede.loadConfiguration(new File(LIB_PATH).toPath());
		LibredeConfiguration allConfLibrede = Librede.loadConfiguration(new File(LIB_ALL_PATH).toPath());
		ValidationSpecification validator = librede.getValidation();

		// create configuration
		// conf = Util.loadLifecycleConfiguration(new File(CONF_PATH).toPath());
		LifeCycleConfiguration conf = null;
		try {
			conf = LifeCycleConfigurationImpl.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e2) {
			e2.printStackTrace();
			fail();
		}
		OptimizationConfiguration opt = Util.loadOptimizationConfiguration(new File(OPT_PATH).toPath());
		RecommendationTrainingConfiguration reco = Util.loadRecommendationConfiguration(new File(RECO_PATH).toPath());
		conf.setOptimizationConfiguration(opt);
		conf.setRecommendationConfiguration(reco);
		conf.setEstimationLoopTime(70);
		conf.setSelectionLoopTime(310);
		conf.setRecommendationLoopTime(1700);
		conf.setOptimizationLoopTime(2100);

		// OPTIONAL
		// set input specification of optimization to be the same of the
		// standard estimation (this just saves time when creating the config
		// file, but could be done manually as well)
		// conf.getOptimizationConfiguration().getContainsOf().get(0).getTrainingData().get(0)
		// .setWorkloadDescription(EcoreUtil.copy(librede.getWorkloadDescription()));
		// conf.getOptimizationConfiguration().getContainsOf().get(0).getTrainingData().get(0)
		// .setInput(EcoreUtil.copy(librede.getInput()));
		// conf.getOptimizationConfiguration().getContainsOf().get(0).getTrainingData().get(0).setRootFolder(datafolder);
		// conf.getOptimizationConfiguration().getContainsOf().get(0).getTrainingData().get(0)
		// .setMultiFolderStructures(false);

		// adapt configurations to be similar
		for (InputData data : conf.getRecommendationConfiguration().getTrainingData()) {
			data.setRootFolder(datafolder + File.separator + "training");
		}
		// except the last one, it is in datafolder
		conf.getRecommendationConfiguration().getTrainingData()
				.get(conf.getRecommendationConfiguration().getTrainingData().size() - 1).setRootFolder(datafolder);
		conf.getRecommendationConfiguration().setValidator(EcoreUtil.copy(validator));

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
		for (TraceConfiguration e : librede.getInput().getObservations()) {
			FileTraceConfiguration ftrace = (FileTraceConfiguration) e;
			String filename = ftrace.getFile();
			ftrace.setFile(datafolder + File.separator + filename);
		}
		for (TraceConfiguration e : allConfLibrede.getInput().getObservations()) {
			FileTraceConfiguration ftrace = (FileTraceConfiguration) e;
			String filename = ftrace.getFile();
			ftrace.setFile(datafolder + File.separator + filename);
		}

		log.info("Finished initialization");

//		new OptimizationPlugin().runConfigurationOptimization(librede, conf.getOptimizationConfiguration(), new CachedWrapper(), OUTPUT);
//		fail();

		LifeCycleController lcc = new LifeCycleController();
		try {
			lcc.startLifeCycle(conf, librede, allConfLibrede, OUTPUT);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail();
		}

	}
}
