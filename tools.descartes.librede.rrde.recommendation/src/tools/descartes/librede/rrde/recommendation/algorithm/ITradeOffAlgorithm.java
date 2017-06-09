package tools.descartes.librede.rrde.recommendation.algorithm;

import java.util.SortedSet;

import org.apache.commons.math3.util.Pair;

import tools.descartes.librede.configuration.EstimationSpecification;

public interface ITradeOffAlgorithm {

	/**
	 * This method returns the {@link #EstimationSpecification} with the highest score in 
	 * the trade off calculations.
	 * @param sortedAlgorithmErrorMapping - the sorted map with the error values
	 * @param sortedAlgorithmTimeMapping - the sorted map with the time values.
	 * @return
	 */
	public EstimationSpecification getTradeOffEstimationSpecification();
	
	public void initialize(
			SortedSet<Pair<EstimationSpecification, Double>> sortedAlgorithmErrorMapping,
			SortedSet<Pair<EstimationSpecification, Double>> sortedAlgorithmTimeMapping,
			Double timeThreshold, TimeImportance timeImportance);
}
