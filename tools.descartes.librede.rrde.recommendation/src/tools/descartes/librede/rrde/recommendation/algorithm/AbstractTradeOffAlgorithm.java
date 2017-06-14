package tools.descartes.librede.rrde.recommendation.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;

import org.apache.commons.math3.util.Pair;

import tools.descartes.librede.configuration.EstimationSpecification;

public abstract class AbstractTradeOffAlgorithm implements ITradeOffAlgorithm {

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
	
	public int getMultiplyFactorTime() {
		int rc;
		switch (timeImportance) {
		case LOW:
			rc = 3;
			break;
		case LITTLE:
			rc = 2;
			break;
		case NORMAL:
			rc = 1;
			break;
		case MORE:
			rc = 1;
			break;
		case HIGH:
			rc = 1;
			break;

		default:
			rc = 1;
			break;
		}
		return rc;
	}

	public int getMultiplyFactorError() {
		int rc;
		switch (timeImportance) {
		case LOW:
			rc = 1;
			break;
		case LITTLE:
			rc = 1;
			break;
		case NORMAL:
			rc = 1;
			break;
		case MORE:
			rc = 2;
			break;
		case HIGH:
			rc = 3;
			break;

		default:
			rc = 1;
			break;
		}
		return rc;
	}

	public int getEstimationCount() {
		int count = 0;
		//transfer the time ranking into my ranking system
		Iterator<Pair<EstimationSpecification, Double>> iteratorTime = getSortedAlgorithmTimeMapping().iterator();
		while(iteratorTime.hasNext()){
			iteratorTime.next();
			//the ranking position value
			count++;
		}
		return count;
	}
	public Double getTimeRange(){
		Double min = sortedAlgorithmTimeMapping.first().getSecond();
		Double max = sortedAlgorithmTimeMapping.last().getSecond();
		return max-min;
	}
	public Double getErrorRange(){
		Double min = sortedAlgorithmErrorMapping.first().getSecond();
		Double max = sortedAlgorithmErrorMapping.last().getSecond();
		return max-min;
	}
}
