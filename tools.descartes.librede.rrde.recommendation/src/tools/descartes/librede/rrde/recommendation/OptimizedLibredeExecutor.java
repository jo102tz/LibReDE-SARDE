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

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.util.Discovery;
import tools.descartes.librede.rrde.util.extract.IFeatureExtractor;
import tools.descartes.librede.rrde.util.wrapper.Wrapper;

/**
 * This class accepts an {@link IRecomendationAlgorithm} and wraps all calls to
 * be optimized.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class OptimizedLibredeExecutor {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(OptimizedLibredeExecutor.class);

	private IFeatureExtractor extractor;

	private IRecomendationAlgorithm algo;

	/**
	 * Constructor specifying the {@link IFeatureExtractor} to use with a
	 * trained {@link IRecomendationAlgorithm}.
	 * 
	 * @param extractor
	 *            {@link IFeatureExtractor} that was used to train the algorithm
	 * @param algo
	 *            {@link IRecomendationAlgorithm} to use for predictions.
	 * @throws IllegalArgumentException
	 *             If {@link IRecomendationAlgorithm#isInTrainingPhase()}
	 *             returns true
	 */
	public OptimizedLibredeExecutor(IFeatureExtractor extractor, IRecomendationAlgorithm algo) {
		super();
		this.extractor = extractor;
		this.algo = algo;
		if (algo.isInTrainingPhase()) {
			throw new IllegalArgumentException("The recommendation algorithm is not yet fully trained.");
		}
	}

	/**
	 * @return the algo
	 */
	public IRecomendationAlgorithm getAlgo() {
		return algo;
	}

	/**
	 * @param algo
	 *            the algo to set
	 */
	public void setAlgo(IRecomendationAlgorithm algo) {
		this.algo = algo;
	}

	/**
	 * @return the extractor
	 */
	public IFeatureExtractor getExtractor() {
		return extractor;
	}

	/**
	 * @param extractor
	 *            the extractor to set
	 */
	public void setExtractor(IFeatureExtractor extractor) {
		this.extractor = extractor;
	}

	/**
	 * Tries to analyze the given {@link LibredeConfiguration} and uses its
	 * configured {@link IRecomendationAlgorithm} to search for the best
	 * {@link EstimationSpecification}. If that fails, the unmodified
	 * configuration is executed.
	 * 
	 * @param conf
	 *            The {@link LibredeConfiguration} to be run.
	 * @return The {@link LibredeResults} as returned by the standard
	 *         {@link Librede}.
	 */
	public LibredeResults executeLibrede(LibredeConfiguration conf) {
		try {
			LibredeVariables vars = new LibredeVariables(conf);
			Librede.initRepo(vars);
			FeatureVector features = extractor.extractFeatures(conf, vars);
			EstimationSpecification est = algo.recommendEstimation(features);
			if (est != null) {
				conf.setEstimation(EcoreUtil.copy(est));
			} else {
				log.warn("Recommendation failed. Returning standard result.");
			}
		} catch (Exception e) {
			log.error("There was an unexpected Exception with recommending.", e);
			throw new RuntimeException(e);
		}
		Discovery.fixTimeStamps(conf);
		return new Wrapper().executeLibrede(conf);
	}
}
