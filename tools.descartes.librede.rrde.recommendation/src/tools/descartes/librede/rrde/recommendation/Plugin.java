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
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.ValidationSpecification;
import tools.descartes.librede.rrde.optimization.Discovery;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.optimization.Wrapper;
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
	private static final Level loglevel = Level.DEBUG;

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(Plugin.class);

	/**
	 * The path to the default {@link OptimizationConfiguration}
	 */
	public final static String CONF_PATH = "resources" + File.separator
			+ "test" + File.separator + "src" + File.separator
			+ "My.recommendation";

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
		Logger.getLogger(
				tools.descartes.librede.rrde.optimization.Discovery.class
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
			loadAndTrainAlgorithm(conf);

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
	public IRecomendationAlgorithm loadAndTrainAlgorithm(
			RecommendationTrainingConfiguration conf) throws Exception {
		IRecomendationAlgorithm alg = loadAlgorithm(conf.getLearningAlgorithm());
		if (alg == null) {
			log.error("Algorithm could not be loaded. Failing...");
			return null;
		}
		IFeatureExtractor extractor = loadFeatureExtractor(conf
				.getFeatureAlgorithm());
		if (extractor == null) {
			log.error("Feature Extractor could not be loaded. Failing...");
			return null;
		}
		if (conf.getEstimators() == null || conf.getEstimators().isEmpty()) {
			log.error("Target configuration set is null or empty.");
			return null;
		}
		if (conf.getValidator() == null
				|| conf.getValidator().getValidators().isEmpty()) {
			log.error("Validator set is null or empty.");
			return null;
		}
		if (conf.getTrainingData() == null || conf.getTrainingData().isEmpty()) {
			log.error("Training data set is null or empty.");
			return null;
		}
		if (!trainAlgorithm(alg, extractor, conf.getEstimators(),
				conf.getValidator(), conf.getTrainingData())) {
			log.error("Training failed. Returning algorithm anyway...");
		}
		return alg;
	}

	/**
	 * Trains the given {@link IRecomendationAlgorithm} with the specified
	 * {@link EstimationSpecification}s validated by the specified
	 * {@link ValidationSpecification} on the specified list of
	 * {@link InputData}s using the specified {@link IFeatureExtractor}.
	 * 
	 * @param alg
	 *            The algorithm to train
	 * @param extractor
	 *            The {@link IFeatureExtractor} to extract features for the
	 *            inputs
	 * @param estimators
	 *            The estimators given as {@link EstimationSpecification}s
	 * @param validationSpecification
	 *            The validator to use in order to create the error values
	 * @param inputs
	 *            The training data given as {@link InputData}s
	 * @return True if the training was successful, false otherwise
	 */
	public boolean trainAlgorithm(IRecomendationAlgorithm alg,
			IFeatureExtractor extractor,
			EList<EstimationSpecification> estimators,
			ValidationSpecification validationSpecification,
			EList<InputData> inputs) {
		log.info("Start training of algorithm " + alg.getName() + "...");
		boolean res = true;
		Set<LibredeConfiguration> set = Discovery.createConfigurations(inputs,
				estimators.get(0), validationSpecification);
		log.info("Available Training-Configurations: " + set.size());
		for (LibredeConfiguration conf : set) {
			try {
				boolean result = trainOneConfiguration(alg, extractor,
						estimators, conf);
				if (!result) {
					log.warn("Training configuration " + conf
							+ " was not successful.");
				}
			} catch (Exception e) {
				log.warn("Training with configuration " + conf
						+ " threw an error.", e);
				res = false;
			}
		}
		log.info("Finished training of algorithm " + alg.getName() + "!");
		return res;
	}

	/**
	 * Executes one configuration with the estimators and adds the training set
	 * to the given {@link IRecomendationAlgorithm}.
	 * 
	 * @param alg
	 *            The {@link IRecomendationAlgorithm} to train
	 * @param extractor
	 *            The {@link IFeatureExtractor} to extract feature information
	 * @param estimators
	 *            The estimator set to use
	 * @param conf
	 *            The {@link LibredeConfiguration} to use as a basis for the
	 *            estimators
	 */
	private boolean trainOneConfiguration(IRecomendationAlgorithm alg,
			IFeatureExtractor extractor,
			EList<EstimationSpecification> estimators, LibredeConfiguration conf) {
		EMap<EstimationSpecification, Double> results = new BasicEMap<EstimationSpecification, Double>();
		for (EstimationSpecification spec : estimators) {
			// calculate error values for all estimators
			conf.setEstimation(EcoreUtil.copy(spec));
			results.put(spec,
					Util.getMeanValidationError(Wrapper.executeLibrede(conf)));
		}
		alg.trainSet(results, extractor.extractFeatures(conf));
		log.info("Inserted training set for configuration " + conf + ".");
		return true;
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
	public IFeatureExtractor loadFeatureExtractor(FeatureExtractorSpecifier spec)
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
			log.error("The feature extractor " + spec.getFeatureExtractor()
					+ " could not be loaded.", e);
			return null;
		}
	}
}