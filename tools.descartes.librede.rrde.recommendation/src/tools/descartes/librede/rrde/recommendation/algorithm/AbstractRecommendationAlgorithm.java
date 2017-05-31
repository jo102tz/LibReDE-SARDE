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
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.model.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.util.Util;

/**
 * Abstract class providing simple functionality for the
 * {@link IRecomendationAlgorithm} interface.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
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

	/**
	 * The maximum number of supported workload classes. (Recommenders are
	 * training with that amount.)
	 */
	private int supportedWorkloadClasses;

	/**
	 * The maximum number of supported resources. (Recommenders are training
	 * with that amount.)
	 */
	private int supportedResources;

	/**
	 * The specifier for algorithm parameters.
	 */
	private RecommendationAlgorithmSpecifier specifier;

	/**
	 * A map to store all training examples.
	 */
	private Map<FeatureVector, EMap<EstimationSpecification, Double>> trainingMap;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm
	 * #initialize(tools.descartes.librede.rrde.recommendation.
	 * RecommendationAlgorithmSpecifier)
	 */
	@Override
	public void initialize(RecommendationAlgorithmSpecifier specifier) {
		if (!isSpecifierSupported(specifier))
			throw new IllegalArgumentException(
					"The given specifier does not apply for this algorithm.");
		this.specifier = specifier;
	}

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
		if (trainingMap == null) {
			trainingMap = new HashMap<FeatureVector, EMap<EstimationSpecification, Double>>();
		}
		trainingMap.put(features, errors);
		return true;
		// return addTrainingSet(errors, features);
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
		// calculate the number of supported resources and workload classes
		supportedResources = Integer.MIN_VALUE;
		supportedWorkloadClasses = Integer.MIN_VALUE;
		if (trainingMap == null || trainingMap.isEmpty()) {
			getLog().error("No training sets were inserted.");
			return false;
		}
		for (FeatureVector feature : trainingMap.keySet()) {
			supportedResources = Math.max(supportedResources,
					feature.getNumberOfRessources());
			supportedWorkloadClasses = Math.max(supportedWorkloadClasses,
					feature.getNumberOfWorkloadClasses());
		}
		getLog().info(
				getName() + " supports " + supportedResources
						+ " resources and " + supportedWorkloadClasses
						+ " workload classes.");
		boolean bool = flushTrainingExamples();
		// clear training map to free the space
		trainingMap.clear();
		return bool;
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
	 * @return the supportedWorkloadClasses
	 */
	public int getSupportedWorkloadClasses() {
		if (isInTrainingPhase()) {
			getLog().warn(
					"The number of supported workload classes can not be determined yet, since the training phase is not over yet.");
		}
		return supportedWorkloadClasses;
	}

	/**
	 * @return the supportedResources
	 */
	public int getSupportedResources() {
		if (isInTrainingPhase()) {
			getLog().warn(
					"The number of supported resources can not be determined yet, since the training phase is not over yet.");
		}
		return supportedResources;
	}

	/**
	 * @return the trainingMap
	 */
	public Map<FeatureVector, EMap<EstimationSpecification, Double>> getTrainingMap() {
		if (trainingMap == null) {
			getLog().warn("No training examples have been added yet.");
		}
		return trainingMap;
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
		list.add(new Double(features.getNumberOfWorkloadClasses()));

		// add correlation trace data

		// add statistical traces
		addStatisticals(list, features.getUtilizationStatistics(),
				getSupportedResources());
		addStatisticals(list, features.getResponseTimeStatistics(),
				getSupportedWorkloadClasses());
		addStatisticals(list, features.getArrivalRateStatistics(),
				getSupportedWorkloadClasses());

		// convert list to double[]
		Double[] array = list.toArray(new Double[1]);
		return Util.convertListDouble(array);
	}

	/**
	 * Unwraps the statistical features from a {@link StatisticalFeatures} list
	 * and writes it into the given list. The order of the elements in the list
	 * has to be the same all the time. If the number of elements is lower than
	 * the considered maximum zeros are added. If the number is higher than the
	 * maximum, they are ignored.
	 * 
	 * @param list
	 *            The list to add the features
	 * @param features
	 *            The {@link StatisticalFeatures} list to unwrap
	 * @param maximum
	 *            The maximum number of elements for this trace list
	 */
	private void addStatisticals(ArrayList<Double> list,
			EList<StatisticalFeatures> features, int maximum) {
		// the number of zeros to fill for a missing trace (update if new
		// features are added)
		int NUMBEROFZEROS = 12;
		for (int i = 0; i < maximum; i++) {
			try {
				StatisticalFeatures trace = features.get(i);
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

			} catch (IndexOutOfBoundsException e) {
				getLog().debug(
						"The feature list "
								+ features
								+ " did contain less than "
								+ maximum
								+ " elements and was therefore filled with zeros.");
				// fill with zeros
				for (int j = 0; j < NUMBEROFZEROS; j++) {
					list.add(new Double(0));
				}
			}
		}
	}

	/**
	 * @return the specifier
	 */
	public RecommendationAlgorithmSpecifier getSpecifier() {
		return specifier;
	}

	/**
	 * @param specifier
	 *            the specifier to set
	 */
	public void setSpecifier(RecommendationAlgorithmSpecifier specifier) {
		this.specifier = specifier;
	}

}
