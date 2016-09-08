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
package tools.descartes.librede.rrde.recommendation.algorithm;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EMap;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.FeatureVector;

/**
 * Abstract class providing simple functionality for the
 * {@link IRecomendationAlgorithm} interface.
 * 
 * @author JS
 *
 */
public abstract class AbstractRecommendationAlgorithm implements
		IRecomendationAlgorithm {

	private boolean isTrainingPhase = true;

	/**
	 * Returns the log instance, to provide proper visible logging.
	 * 
	 * @return the logger of the implementing class
	 */
	protected abstract Logger getLog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm
	 * #getName()
	 */
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm
	 * #trainSet(org.eclipse.emf.common.util.EMap,
	 * tools.descartes.librede.rrde.recommendation.FeatureVector)
	 */
	@Override
	public boolean trainSet(EMap<EstimationSpecification, Double> errors,
			FeatureVector features) throws IllegalStateException {
		if (!isInTrainingPhase()) {
			throw new IllegalStateException(
					"Training phase is already finished.");
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm
	 * #endTrainingPhase()
	 */
	@Override
	public boolean endTrainingPhase() {
		isTrainingPhase = false;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm
	 * #isInTrainingPhase()
	 */
	@Override
	public boolean isInTrainingPhase() {
		return isTrainingPhase;
	}

}
