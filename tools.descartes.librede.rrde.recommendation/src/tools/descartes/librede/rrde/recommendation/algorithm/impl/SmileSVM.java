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
package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import org.apache.log4j.Logger;

import smile.classification.SVM;
import smile.classification.SVM.Multiclass;
import smile.math.kernel.GaussianKernel;
import tools.descartes.librede.rrde.model.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.SVMAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm;

/**
 * This is an implementation of {@link IRecomendationAlgorithm} using the SVM
 * algorithm from the Smile library.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class SmileSVM extends AbstractSmileAlgorithm {

	/**
	 * The logger used for logging.
	 */
	private static final Logger log = Logger.getLogger(SmileSVM.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.recommendation.algorithm.
	 * AbstractRecommendationAlgorithm#getLog()
	 */
	@Override
	protected Logger getLog() {
		return log;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.recommendation.algorithm.impl.
	 * AbstractSmileAlgorithm#train(double[][], int[])
	 */
	@Override
	protected boolean train(double[][] features, int[] targets) {
		try {
			SVM<double[]> svm = null;
			if (getNumberOfSupportedEstimators() == 2) {
				// only use binary SVM
				svm = new SVM<double[]>(
						new GaussianKernel(((SVMAlgorithmSpecifier) getSpecifier()).getGaussianSigma()),
						((SVMAlgorithmSpecifier) getSpecifier()).getSoftMarginPenalty(),
						((SVMAlgorithmSpecifier) getSpecifier()).getSoftMarginPenalty());
			} else {
				// else train multi-class SVM
				svm = new SVM<double[]>(
						new GaussianKernel(((SVMAlgorithmSpecifier) getSpecifier()).getGaussianSigma()),
						((SVMAlgorithmSpecifier) getSpecifier()).getSoftMarginPenalty(),
						getNumberOfSupportedEstimators(), Multiclass.ONE_VS_ALL);
			}
			svm.learn(features, targets);
			svm.finish();
			setClassifier(svm);
		} catch (Exception e) {
			log.error("The training of the SVM did not finish successfully.", e);
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.recommendation.algorithm.
	 * IRecomendationAlgorithm
	 * #isSpecifierSupported(tools.descartes.librede.rrde.recommendation.
	 * RecommendationAlgorithmSpecifier)
	 */
	@Override
	public boolean isSpecifierSupported(RecommendationAlgorithmSpecifier specifier) {
		if (specifier instanceof SVMAlgorithmSpecifier) {
			return true;
		}
		return false;
	}
}
