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
package tools.descartes.librede.rrde;

import java.io.File;
import java.util.Collection;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.optimization.OptimizationPlugin;
import tools.descartes.librede.rrde.optimization.algorithm.impl.IterativeParameterOptimizationAlgorithm;
import tools.descartes.librede.rrde.recommendation.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.util.Util;
import tools.descartes.librede.rrde.util.extract.IFeatureExtractor;
import tools.descartes.librede.rrde.util.wrapper.Wrapper;

/**
 * The main class of this Plug-In. Here, the life-cycle of the plugin is
 * configured.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class Plugin implements IApplication {

	/**
	 * The logging level for all classes of this package
	 */
	private final Level loglevel = Level.INFO;

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(Plugin.class);

	/**
	 * The path to the default {@link LibredeConfiguration}
	 */
	public final static String LIB_PATH = "resources" + File.separator + "estimation.librede";

	/**
	 * The path to the default {@link OptimizationConfiguration}
	 */
	public final static String OPT_PATH = "resources" + File.separator + "test" + File.separator + "src"
			+ File.separator + "conf.optimization";

	/**
	 * The path to the default {@link RecommendationTrainingConfiguration}
	 */
	public final static String REC_PATH = "resources" + File.separator + "test" + File.separator + "src"
			+ File.separator + "My.recommendation";

	/**
	 * The output path, where all output files are stored.
	 */
	public final static String OUTPUT = "output";

	/**
	 * Initializes the logging for better readability.
	 *
	 * @param loglevel
	 *            The required logging level
	 */
	public void initLogging(Level loglevel) {
		LogManager.resetConfiguration();
		Librede.initLogging();
		LogManager.getRootLogger().setLevel(loglevel);
		Logger.getLogger(tools.descartes.librede.Librede.class.getPackage().getName()).setLevel(Level.WARN);
		Logger.getLogger(this.getClass().getPackage().getName()).setLevel(loglevel);
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		init();
		try {
			// load config files
			LibredeConfiguration librede = Librede.loadConfiguration(new File(LIB_PATH).toPath());
			OptimizationConfiguration optimization = Util.loadOptimizationConfiguration(new File(OPT_PATH).toPath());
			RecommendationTrainingConfiguration recommendation = Util
					.loadRecommendationConfiguration(new File(REC_PATH).toPath());

			// run optimization
			Collection<EstimationSpecification> estimations = new OptimizationPlugin()
					.runConfigurationOptimization(librede, optimization, new Wrapper(), OUTPUT);
			log.info("Finished optimization! Starting training phase...");

			// delete the read estimators and replace them with the optimized
			// ones
			recommendation.getEstimators().clear();
			recommendation.getEstimators().addAll(estimations);

			// train algorithm
			IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
					.loadAndTrainAlgorithm(recommendation, new Wrapper());
			IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
					.loadFeatureExtractor(recommendation.getFeatureAlgorithm());

			// wrap into Executor
			OptimizedLibredeExecutor exec = new OptimizedLibredeExecutor(extractor, algorithm);

			log.info("Finished training! Ready for predictions now.");
			log.info("Finished optimization and recommendation.");
			return exec;

		} catch (Exception e) {
			log.error("Error occurred. Returning null.", e);
			return null;
		}

	}

	@Override
	public void stop() {
		// do nothing
	}

	/**
	 * Initializes the plugin and all its sub-components.
	 */
	public void init() {
		initLogging(loglevel);
		Wrapper.init();
	}

}
