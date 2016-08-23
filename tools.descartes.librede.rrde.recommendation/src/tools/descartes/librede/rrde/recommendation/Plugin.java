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
package tools.descartes.librede.rrde.recommendation;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import tools.descartes.librede.Librede;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.optimization.Wrapper;
import tools.descartes.librede.rrde.optimization.algorithm.IConfigurationOptimizer;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;

/**
 * The main class of this Plugin.
 * 
 * @author JS
 *
 */
public class Plugin implements IApplication {

	/**
	 * The logging level for all classes of this package
	 */
	private static final Level loglevel = Level.INFO;

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(Plugin.class);

	/**
	 * The path to the default {@link OptimizationConfiguration}
	 */
	public final static String CONF_PATH = "resources" + File.separator
			+ "test" + File.separator + "src" + File.separator
			+ "specj.optimization";

	/**
	 * The output path, where all output files are stored.
	 */
	public final static String OUTPUT = "output";

	/**
	 * Initializes the logging for better readability.
	 */
	public void initLogging() {
		Librede.initLogging();
		LogManager.getRootLogger().setLevel(loglevel);
		Logger.getLogger(
				tools.descartes.librede.Librede.class.getPackage().getName())
				.setLevel(Level.WARN);
		Logger.getLogger(this.getClass().getPackage().getName()).setLevel(
				loglevel);
		Logger.getLogger(
				tools.descartes.librede.rrde.rinterface.RBridge.class
						.getPackage().getName()).setLevel(loglevel);
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		initLogging();
		Wrapper.init();
		try {
			// load config files
			RecommendationTrainingConfiguration conf = Util
					.loadRecommendationConfiguration(new File(CONF_PATH)
							.toPath());

			// train algorithm
			IRecomendationAlgorithm alg = trainAlgorithm(conf);

		} catch (Exception e) {
			log.error("Error occurred", e);
		}
		log.info("Finished.");
		return null;
	}

	@Override
	public void stop() {
		// do nothing
	}

	/**
	 * Loads, trains and returns the given algorithm as specified by the
	 * {@link RecommendationTrainingConfiguration}.
	 * 
	 * @param conf
	 *            The configuration file
	 * @return The {@link IRecomendationAlgorithm}
	 */
	public IRecomendationAlgorithm trainAlgorithm(
			RecommendationTrainingConfiguration conf) throws Exception {
		IRecomendationAlgorithm alg = loadAlgorithm(conf.getLearningAlgorithm());
		if (alg == null) {
			return null;
		}
		return alg;
	}

	/**
	 * Loads a new instance of the algorithm specified by the
	 * {@link RecommendationAlgorithmSpecifier}
	 * 
	 * @param spec
	 *            The configuration
	 * @return A new instance of the algorithm as specified by the
	 *         {@link RecommendationAlgorithmSpecifier}
	 * @throws NullPointerException
	 *             If the specifications or any of the required fields are
	 *             <code>null</code>
	 */
	public IRecomendationAlgorithm loadAlgorithm(
			RecommendationAlgorithmSpecifier spec) throws NullPointerException {
		if (spec == null || spec.getAlgorithmName() == null) {
			throw new NullPointerException("Specifier is null.");
		}
		try {
			IRecomendationAlgorithm algo = (IRecomendationAlgorithm) Class
					.forName(spec.getAlgorithmName()).newInstance();
			return algo;
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			log.error("The algorithm " + spec.getAlgorithmName()
					+ " could not be loaded.", e);
			return null;
		}
	}

	/**
	 * Loads a new instance of the algorithm specified by the
	 * {@link FeatureExtractorSpecifier}
	 * 
	 * @param spec
	 *            The configuration
	 * @return A new instance of the algorithm as specified by the
	 *         {@link FeatureExtractorSpecifier}
	 * @throws NullPointerException
	 *             If the specifications or any of the required fields are
	 *             <code>null</code>
	 */
	public IFeatureExtractor loadAlgorithm(FeatureExtractorSpecifier spec)
			throws NullPointerException {
		if (spec == null || spec.getFeatureExtractor() == null) {
			throw new NullPointerException("Specifier is null.");
		}
		try {
			IFeatureExtractor algo = (IFeatureExtractor) Class.forName(
					spec.getFeatureExtractor()).newInstance();
			return algo;
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			log.error("The algorithm " + spec.getFeatureExtractor()
					+ " could not be loaded.", e);
			return null;
		}
	}
}
