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

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.eval.TestSetValidator;
import tools.descartes.librede.rrde.optimization.Util;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.extract.IFeatureExtractor;

/**
 * @author JS
 *
 */
public class TestRecommendation extends AbstractTest {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestRecommendation.class);

	private static final String validationfolder = TESTPATH + File.separator
			+ "validation";

	@Test
	public void test() {
		log.info("Initialize test sets...");
		// load config files
		LibredeConfiguration librede = Librede.loadConfiguration(new File(
				LIB_PATH).toPath());

		RecommendationTrainingConfiguration recommendation = Util
				.loadRecommendationConfiguration(new File(REC_PATH).toPath());

		recommendation.getTrainingData().get(0)
				.setRootFolder(TESTPATH + File.separator + "training");
		
		TestSetValidator vali = new TestSetValidator();
		vali.calculateInitialErrors(validationfolder, librede);
		Assert.assertNotEquals(vali.getTestset().size(), 0);

		log.info("Initialized! Starting training phase...");

		// train algorithm
		long start = System.currentTimeMillis();
		IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
				.loadAndTrainAlgorithm(recommendation);
		IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
				.loadFeatureExtractor(recommendation.getFeatureAlgorithm());
		long reco = System.currentTimeMillis() - start;
		log.info("Finished training! Validating...");

		// wrap into Executor
		OptimizedLibredeExecutor exec = new OptimizedLibredeExecutor(extractor,
				algorithm);
		// print results
		vali.compareOptimized(exec);
		vali.printResults(null, 0, reco);

	}

}
