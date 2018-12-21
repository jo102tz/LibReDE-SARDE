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
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.rrde.eval.StatisticsSummary;
import tools.descartes.librede.rrde.model.recommendation.DecisionTreeAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.SVMAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.impl.DecisionTreeAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.model.recommendation.impl.NeuralNetworkAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.model.recommendation.impl.SVMAlgorithmSpecifierImpl;
import tools.descartes.librede.rrde.recommendation.OptimizedLibredeExecutor;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;
import tools.descartes.librede.rrde.util.extract.IFeatureExtractor;
import tools.descartes.librede.rrde.util.wrapper.Wrapper;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class TestRecommendation extends AbstractTest {

	/**
	 * The logger used for logging
	 */
	private static final Logger log = Logger.getLogger(TestRecommendation.class);

	@Test
	public void test() {
		// get available estimation approaches
		Collection<EstimationApproachConfiguration> estimators = new HashSet<>();
		for (EstimationApproachConfiguration app : librede.getEstimation().getApproaches()) {
			estimators.add(EcoreUtil.copy(app));
		}
		vali.calculateInitialErrorsRecommendation(estimators, true);

		log.info("Initialized! Starting training phase with Decision Tree...");
		DecisionTreeAlgorithmSpecifier tree = new DecisionTreeAlgorithmSpecifierImpl();
		tree.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.SmileTree");
		tree.setMaximumNumberOfNodes(100);
		recommendation.setLearningAlgorithm(tree);

		// train algorithm
		long start = System.currentTimeMillis();
		IRecomendationAlgorithm algorithm = new tools.descartes.librede.rrde.recommendation.Plugin()
				.loadAndTrainAlgorithm(recommendation, new Wrapper());
		IFeatureExtractor extractor = tools.descartes.librede.rrde.recommendation.Plugin
				.loadFeatureExtractor(recommendation.getFeatureAlgorithm());
		long reco = System.currentTimeMillis() - start;
		log.info("Finished training with Decision Tree! Validating...");

		// wrap into Executor
		OptimizedLibredeExecutor exec = new OptimizedLibredeExecutor(extractor, algorithm);
		// print results
		vali.compareOptimized(exec);
		StatisticsSummary stat = vali.printResults(null, null, 0, reco, true, null);
		testStatValues(stat, 0.10701291948298311, 0.10701291948298311, 0, 0, 1, false, true);

		log.info("Initialized! Starting training phase with neural net...");
		NeuralNetworkAlgorithmSpecifierImpl nn = new NeuralNetworkAlgorithmSpecifierImpl();
		nn.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.SmileNN");
		nn.setNumberOfNeurons(100);
		recommendation.setLearningAlgorithm(nn);

		// train algorithm
		start = System.currentTimeMillis();
		algorithm = new tools.descartes.librede.rrde.recommendation.Plugin().loadAndTrainAlgorithm(recommendation,
				new Wrapper());
		reco = System.currentTimeMillis() - start;
		log.info("Finished training with Decision Tree! Validating...");

		// wrap into Executor
		exec = new OptimizedLibredeExecutor(extractor, algorithm);
		// print results
		vali.compareOptimized(exec);
		vali.printResults(null, null, 0, reco, true, null);
		testStatValues(stat, 0.10701291948298311, 0.10701291948298311, 0, 0, 1, false, true);

		log.info("Initialized! Starting training phase with SVM...");
		SVMAlgorithmSpecifier svm = new SVMAlgorithmSpecifierImpl();
		svm.setAlgorithmName("tools.descartes.librede.rrde.recommendation.algorithm.impl.SmileSVM");
		svm.setGaussianSigma(8.0);
		svm.setSoftMarginPenalty(5);
		recommendation.setLearningAlgorithm(svm);

		// train algorithm
		start = System.currentTimeMillis();
		algorithm = new tools.descartes.librede.rrde.recommendation.Plugin().loadAndTrainAlgorithm(recommendation,
				new Wrapper());
		reco = System.currentTimeMillis() - start;
		log.info("Finished training with Decision Tree! Validating...");

		// wrap into Executor
		exec = new OptimizedLibredeExecutor(extractor, algorithm);
		// print results
		vali.compareOptimized(exec);
		vali.printResults(null, null, 0, reco, true, null);
		testStatValues(stat, 0.10701291948298311, 0.10701291948298311, 0, 0, 1, false, true);

	}

}
