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

import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.Test;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.optimization.util.wrapper.Wrapper;
import tools.descartes.librede.rrde.recommendation.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class TestCombination extends AbstractTest {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestCombination.class);

	@Test
	public void test() {
		// do not initialize error values
		log.info("Initialized! Starting optimization...");
		// run optimization
		Collection<EstimationSpecification> estimations = new tools.descartes.librede.rrde.optimization.Plugin()
				.runConfigurationOptimization(librede, optimization, new Wrapper(), OUTPUT);
		log.info("Finished optimization! Starting training phase...");

		// delete the read estimators and replace them with the optimized
		// ones
		recommendation.getEstimators().clear();
		recommendation.getEstimators().addAll(estimations);

		// train algorithm
		IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
				.loadAndTrainAlgorithm(recommendation);
		IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
				.loadFeatureExtractor(recommendation.getFeatureAlgorithm());
		log.info("Finished training! Validating...");

		// wrap into Executor
		OptimizedLibredeExecutor exec = new OptimizedLibredeExecutor(extractor, algorithm);
		// print results
		vali.compareOptimized(exec);
		
		// THIS test just checks for functionality and makes sure no exceptions are thrown.
		// no values or accuracies are checked
		// this is done by the individual tests
	}

}
