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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;

import smile.classification.Classifier;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.algorithm.AbstractRecommendationAlgorithm;

/**
 * Abstract class simplifying the usage of algorithms using the Smile interface.
 * 
 * @author JS
 *
 */
public abstract class AbstractSmileAlgorithm extends
		AbstractRecommendationAlgorithm {

	/**
	 * The collected feature values in the same order than the
	 * {@link #trainingfeatures}.
	 */
	private List<double[]> trainingfeatures;

	/**
	 * The corresponding target values in the same order than the
	 * {@link #trainingfeatures}.
	 */
	private List<Double> targetvalues;

	/**
	 * The map to store the results.
	 */
	private Map<EstimationSpecification, Double> algorithmIndexMapping;

	/**
	 * The classifier that is trained by sub-classes.
	 */
	private Classifier<double[]> classifier;

	/**
	 * @return the classifier
	 */
	public Classifier<double[]> getClassifier() {
		return classifier;
	}

	/**
	 * @param classifier
	 *            the classifier to set
	 */
	public void setClassifier(Classifier<double[]> classifier) {
		this.classifier = classifier;
	}

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
		super.initialize(specifier);
		algorithmIndexMapping = new HashMap<>();
		trainingfeatures = new ArrayList<>();
		targetvalues = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm
	 * #
	 * recommendEstimation(tools.descartes.librede.rrde.recommendation.FeatureVector
	 * )
	 */
	@Override
	public EstimationSpecification recommendEstimation(FeatureVector features) {
		if (classifier == null) {
			getLog().error("The classifier is null.");
			return null;
		}
		if (features.getNumberOfRessources() > getSupportedResources()) {
			getLog().warn(
					"The number of resources is higher than supported by the training set.");
		}
		if (features.getNumberOfWorkloadClasses() > getSupportedWorkloadClasses()) {
			getLog().warn(
					"The number of workload classes is higher than supported by the training set.");
		}
		double prediction = classifier.predict(parseToDoubles(features));
		return getSpecification(prediction);
	}

	/**
	 * Is called by {@link #flushTrainingExamples()}and adds a new training
	 * example to the training set.
	 * 
	 * @param errors
	 *            A mapping of {@link EstimationSpecification} to its
	 *            performance on the described feature set by an error value.
	 * @param features
	 *            The {@link FeatureVector} to the corresponding targetValue
	 * @return True if the example was successfully included, false otherwise.
	 * 
	 */
	protected boolean parseTrainingSet(
			EMap<EstimationSpecification, Double> errors, FeatureVector features) {
		EstimationSpecification spec = getBestEstimator(errors);
		if (spec == null) {
			getLog().warn("No best estimator could be calculated.");
			return false;
		}
		if (targetvalues.size() != trainingfeatures.size()) {
			getLog().error(
					"The number of training examples and target values does not match.");
			return false;
		}
		trainingfeatures.add(parseToDoubles(features));
		targetvalues.add(new Double(getIndex(spec)));
		return true;
	}

	/**
	 * Returns the {@link EstimationSpecification} with the smallest error
	 * function.
	 * 
	 * @param errors
	 *            A {@link EMap} of {@link EstimationSpecification} with their
	 *            corresponding errors as {@link Double}s.
	 * @return The {@link EstimationSpecification} with the smallest error.
	 */
	private EstimationSpecification getBestEstimator(
			EMap<EstimationSpecification, Double> errors) {
		EstimationSpecification currentBest = null;
		double currentMin = Double.MAX_VALUE;
		for (Entry<EstimationSpecification, Double> entry : errors) {
			if (entry.getValue().doubleValue() < currentMin) {
				currentBest = entry.getKey();
				currentMin = entry.getValue().doubleValue();
			}
		}
		return currentBest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.recommendation.algorithm.
	 * AbstractRecommendationAlgorithm#flushTrainingExamples()
	 */
	@Override
	protected boolean flushTrainingExamples() {
		// parse all training examples into double arrays
		for (Entry<FeatureVector, EMap<EstimationSpecification, Double>> entry : getTrainingMap()
				.entrySet()) {
			parseTrainingSet(entry.getValue(), entry.getKey());
		}

		if (trainingfeatures.size() == 0) {
			getLog().error("No training data available...");
			return false;
		}
		if (targetvalues.size() != trainingfeatures.size()) {
			getLog().error("The size of the arrays does not match.");
			return false;
		}
		double[][] training = trainingfeatures.toArray(new double[0][0]);
		int[] target = convertListInt(targetvalues.toArray(new Double[0]));
		if (training == null || target == null) {
			getLog().error("Training or target values are null.");
			return false;
		}
		// check if all train sets are the same target variable
		boolean allequal = true;
		for (int i = 0; i < target.length; i++) {
			if (target[i] != target[(i + 1) % target.length]) {
				allequal = false;
				break;
			}
		}
		if (allequal) {
			// catch case if all train sets are equal
			this.classifier = new DummyClasifier(target[0]);
			return true;
		}
		return train(training, target);
	}

	/**
	 * Trains the algorithm with the given examples.
	 * 
	 * @param features
	 *            The feature arrays
	 * @param targets
	 *            The target values
	 * @return True if the training was successful, false otherwise
	 */
	protected abstract boolean train(double[][] features, int[] targets);

	/**
	 * Retrieves the corresponding index number and adds the
	 * {@link EstimationSpecification} if it was not stored yet.
	 * 
	 * @param spec
	 *            The specification to map
	 * @return The index number of the given {@link EstimationSpecification}
	 */
	protected double getIndex(EstimationSpecification spec) {
		Double d = algorithmIndexMapping.get(spec);
		if (d == null) {
			// specification unknown
			d = new Double(algorithmIndexMapping.keySet().size());
			algorithmIndexMapping.put(spec, d);
		}
		return d.doubleValue();
	}

	/**
	 * Returns the {@link EstimationSpecification} corresponding to the given
	 * index;
	 * 
	 * @param index
	 *            The index, that is requested
	 * @return The {@link EstimationSpecification} corresponding to it.
	 */
	protected EstimationSpecification getSpecification(double index) {
		for (Entry<EstimationSpecification, Double> entry : algorithmIndexMapping
				.entrySet()) {
			if (entry.getValue().doubleValue() == index) {
				return entry.getKey();
			}
		}
		getLog().warn(
				"Index " + index + " not found in mapping. Size: "
						+ algorithmIndexMapping.entrySet().size());
		return null;
	}

}
