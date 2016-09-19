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

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EMap;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;

/**
 * Abstract class providing simple functionality for the
 * {@link IRecomendationAlgorithm} interface.
 * 
 * @author JS
 *
 */
public abstract class AbstractRecommendationAlgorithm implements
		IRecomendationAlgorithm {

	/**
	 * Boolean indicating if adding examples is still possible.
	 */
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
		return addTrainingSet(errors, features);
	}

	/**
	 * Is called by
	 * {@link AbstractRecommendationAlgorithm#trainSet(EMap, FeatureVector)} and
	 * adds a new training example to the training set.
	 * 
	 * @param errors
	 *            A mapping of {@link EstimationSpecification} to its
	 *            performance on the described feature set by an error value.
	 * @param features
	 *            The {@link FeatureVector} to the corresponding targetValue
	 * @return True if the example was successfully included, false otherwise.
	 * 
	 * @see AbstractRecommendationAlgorithm#trainSet(EMap, FeatureVector)
	 */
	protected abstract boolean addTrainingSet(
			EMap<EstimationSpecification, Double> errors, FeatureVector features);

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
		return flushTrainingExamples();
	}

	/**
	 * Is called by {@link AbstractRecommendationAlgorithm#endTrainingPhase()}.
	 * Ends the training phase.
	 * 
	 * @return True if the training was successfully finished, false if errors
	 *         occurred.
	 * 
	 * @see AbstractRecommendationAlgorithm#endTrainingPhase()
	 */
	protected abstract boolean flushTrainingExamples();

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

	/**
	 * Parses and returns a double representation of the given
	 * {@link FeatureVector}
	 * 
	 * @param features
	 *            The features to parse
	 * @return The representation as double array
	 */
	public double[] parseToDoubles(FeatureVector features) {
		ArrayList<Double> list = new ArrayList<Double>();
		// add descriptive trace data
		list.add(new Double(features.getNumberOfRessources()));
		list.add(new Double(features.getNumberOfRessources()));

		// add statistical traces
//		addStatisticals(list, features.getUtilizationStatistics());
//		addStatisticals(list, features.getResponseTimeStatistics());
//		addStatisticals(list, features.getArrivalRateStatistics());

		// convert list to double[]
		Double[] array = list.toArray(new Double[1]);
		return convertListDouble(array);
	}

	/**
	 * Unwraps the statistical features from a {@link StatisticalFeatures}
	 * instance and writes it into the given list.
	 * 
	 * @param list
	 *            The list to add the features
	 * @param trace
	 *            The {@link StatisticalFeatures} instance to unwrap
	 */
	private void addStatisticals(ArrayList<Double> list,
			StatisticalFeatures trace) {
		list.add(new Double(trace.getArithmeticMean()));
		list.add(new Double(trace.getGeometricMean()));
		list.add(new Double(trace.getQuadraticMean()));
		list.add(new Double(trace.getStandardDeviation()));

		list.add(new Double(trace.getN()));
		list.add(new Double(trace.getMaximum()));
		list.add(new Double(trace.getMinimum()));

		list.add(new Double(trace.getSkewness()));
		list.add(new Double(trace.getKurtosis()));

		list.add(new Double(trace.getNinetiethpercentile()));
		list.add(new Double(trace.getTenthpercentile()));

		list.add(new Double(trace.getAutocorrelation()));
	}

	/**
	 * Converts an array of {@link Double}s into an array of primitives.
	 * 
	 * @param list
	 *            The {@link Double} array
	 * @return The double[]
	 */
	public static double[] convertListDouble(Double[] array) {
		double[] result = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i].doubleValue();
		}
		return result;
	}

	/**
	 * Converts an array of {@link Double}s into an array of primitives.
	 * 
	 * @param list
	 *            The {@link Double} array
	 * @return The int[]
	 */
	public static int[] convertListInt(Double[] array) {
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i].intValue();
		}
		return result;
	}
}
