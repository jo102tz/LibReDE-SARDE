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

import org.eclipse.emf.common.util.EMap;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.FeatureVector;

/**
 * Interface for machine learning algorithms, that recommend an algorithm.
 * 
 * @author JS
 *
 */
public interface IRecomendationAlgorithm {

	/**
	 * Returns the name of the algorithm.
	 * 
	 * @return A human-readable name
	 */
	public String getName();

	/**
	 * Initializes the algorithm. If called twice, it resets the algorithm.
	 */
	public void initialize();

	/**
	 * Recommend a specific {@link EstimationSpecification} for the given
	 * {@link FeatureVector}.
	 * 
	 * @param features
	 *            The extracted features
	 * @return The recommended {@link EstimationSpecification} to run or
	 *         <code>null</code> if the recommendation failed
	 */
	public EstimationSpecification recommendEstimation(FeatureVector features);

	/**
	 * Inserts one training example for each of the {@link ConfigurationResult}
	 * s. The given {@link EstimationSpecification}s contained in the
	 * {@link ConfigurationResult}s will be stored and can now be returned by
	 * {@link #recommendEstimation(FeatureVector)}.
	 * 
	 * @param errors
	 *            A mapping of {@link EstimationSpecification} to its
	 *            performance on the described feature set by an error value.
	 * @param features
	 *            The {@link FeatureVector} to the corresponding targetValue
	 * @return True if the example was successfully included, false otherwise.
	 * @throws IllegalStateException
	 *             If no training examples are accepted anymore, e.g. if the
	 *             training phase was completed by a call of
	 *             {@link #endTrainingPhase()}.
	 */
	public boolean trainSet(EMap<EstimationSpecification, Double> errors,
			FeatureVector features) throws IllegalStateException;

	/**
	 * Must be called, when the training phase is over. <br>
	 * Before calling this method, implementations might not return confident
	 * results in {@link #recommendEstimation(FeatureVector)}. <br>
	 * Implementations might refuse further calls of
	 * {@link #train(EstimationSpecification, double, FeatureVector)} after this
	 * method was called, however.
	 * 
	 * @return True if the training was successfully finished, false if errors
	 *         occurred.
	 */
	public boolean endTrainingPhase();
}
