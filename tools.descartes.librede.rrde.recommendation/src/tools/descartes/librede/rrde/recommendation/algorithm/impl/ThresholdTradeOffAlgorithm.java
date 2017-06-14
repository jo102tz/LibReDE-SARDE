package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;

import org.apache.commons.math3.util.Pair;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.algorithm.AbstractTradeOffAlgorithm;
import tools.descartes.librede.rrde.recommendation.algorithm.ITradeOffAlgorithm;

public class ThresholdTradeOffAlgorithm extends AbstractTradeOffAlgorithm {	
	
	
	@Override
	public EstimationSpecification getTradeOffEstimationSpecification() {
		if(getSortedAlgorithmErrorMapping()==null || getSortedAlgorithmTimeMapping()==null){
			return null;
		}
		//create a new set with all the estimation approaches,
		//that are faster than the time threshould
		Map<EstimationSpecification, Double> possibleTimeSet = new HashMap<>();
		Iterator<Pair<EstimationSpecification, Double>> iteratorTime = getSortedAlgorithmTimeMapping().iterator();
		while(iteratorTime.hasNext()){
			Pair<EstimationSpecification, Double> pair = iteratorTime.next();
			if(pair.getSecond()<=this.getTimeThreshold()){
				possibleTimeSet.put(pair.getFirst(), pair.getSecond());
			}
		}
		//minimum placeholder
		EstimationSpecification minimumErrorApproach = null;
		Double miniumumErrorValue = Double.MAX_VALUE;
		
		//traverse the new entry set
		for(Entry<EstimationSpecification,Double>entry:possibleTimeSet.entrySet()){
			//go through the time entry set and find the corresponding error value
			Iterator<Pair<EstimationSpecification, Double>> iteratorError = getSortedAlgorithmErrorMapping().iterator();
			while(iteratorError.hasNext()){
				Pair<EstimationSpecification, Double> pair = iteratorError.next();
				if(pair.getFirst().equals(entry.getKey())){
					//check for minimum and break the while loop
					if(pair.getSecond()<miniumumErrorValue){
						//remember minimum
						minimumErrorApproach = pair.getFirst();
						miniumumErrorValue = pair.getSecond();
						break;
					}
				}
			}
		}
		//if time entry set was empty. We found no solution until now
		if(minimumErrorApproach==null){
			//set the smallest error, because all the approaches need too much time
			minimumErrorApproach = getSortedAlgorithmErrorMapping().first().getFirst();
		}
		//return the best approach
		return minimumErrorApproach;
	}

}
