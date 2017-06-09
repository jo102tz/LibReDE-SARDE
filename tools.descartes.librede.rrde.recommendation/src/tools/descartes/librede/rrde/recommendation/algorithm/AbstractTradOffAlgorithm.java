package tools.descartes.librede.rrde.recommendation.algorithm;

import java.util.SortedSet;

import org.apache.commons.math3.util.Pair;

import tools.descartes.librede.configuration.EstimationSpecification;

public abstract class AbstractTradOffAlgorithm implements ITradeOffAlgorithm {

	private SortedSet<Pair<EstimationSpecification, Double>> sortedAlgorithmErrorMapping;
	private SortedSet<Pair<EstimationSpecification, Double>> sortedAlgorithmTimeMapping;
	private Double timeThreshold;
	private TimeImportance timeImportance;
	
	public SortedSet<Pair<EstimationSpecification, Double>> getSortedAlgorithmErrorMapping(){
		return sortedAlgorithmErrorMapping;
	}
	
	public SortedSet<Pair<EstimationSpecification, Double>> getSortedAlgorithmTimeMapping(){
		return sortedAlgorithmTimeMapping;
	}
	
	public Double getTimeThreshold(){
		return timeThreshold;
	}
	
	public TimeImportance getTimeImportance() {
		return timeImportance;
	}
	
	@Override
	public void initialize(SortedSet<Pair<EstimationSpecification, Double>> sortedAlgorithmErrorMapping,
			SortedSet<Pair<EstimationSpecification, Double>> sortedAlgorithmTimeMapping,
			Double timeThreshold, TimeImportance timeImportance) {
		this.sortedAlgorithmErrorMapping =sortedAlgorithmErrorMapping ;
		this.sortedAlgorithmTimeMapping=sortedAlgorithmTimeMapping;
		this.timeThreshold = timeThreshold;
		this.timeImportance = timeImportance;
	}

}
