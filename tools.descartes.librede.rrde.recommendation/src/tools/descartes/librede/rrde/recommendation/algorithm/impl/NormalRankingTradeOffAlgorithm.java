package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.util.Pair;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.algorithm.AbstractTradeOffAlgorithm;
import tools.descartes.librede.rrde.recommendation.algorithm.TimeImportance;

/**
 * This class mixes up the two rankings and returns the best approach due to the new
 * ranking. Here the positions in the old ranking are taken and weighted due to the
 * TimeImportance to create a new ranking. If two approaches in the new ranking have the
 * same ranking value, we take the one with the smaller time or error die to the
 * TimeImportance value.
 * @author torsten
 *
 */
public class NormalRankingTradeOffAlgorithm extends AbstractTradeOffAlgorithm {

	@Override
	public EstimationSpecification getTradeOffEstimationSpecification() {
		if(getSortedAlgorithmErrorMapping()==null || getSortedAlgorithmTimeMapping()==null){
			return null;
		}
		//get the number of estimation approaches
		int n = this.getEstimationCount();
		if(n == 0){
			return null;
		}
		if(n == 1){
			return getSortedAlgorithmErrorMapping().first().getFirst();
		}
		
		int multiplyfactorError = this.getMultiplyFactorError();
		int multifplyfactorTime = this.getMultiplyFactorTime();
		int position = 0;
		Map<EstimationSpecification, Integer> finalRanking = new HashMap<>();
		//transfer the time ranking into my ranking system
		Iterator<Pair<EstimationSpecification, Double>> iteratorTime = getSortedAlgorithmTimeMapping().iterator();
		while(iteratorTime.hasNext()){
			//get the next pair
			Pair<EstimationSpecification, Double> pair = iteratorTime.next();
			//the ranking position value
			position++;
			//add to the new map
			finalRanking.put(pair.getFirst(), position*multifplyfactorTime);
		}
		//add the error ranking into my ranking system
		position = 0;
		Iterator<Pair<EstimationSpecification, Double>> iteratorError = getSortedAlgorithmErrorMapping().iterator();
		while(iteratorError.hasNext()){
			//get the next pair
			Pair<EstimationSpecification, Double> pair = iteratorError.next();
			//the ranking position
			position++;
			if(finalRanking.containsKey(pair.getFirst())){
				//the key already exists - this should be the case for every entry
				
				//remember the actual ranking value
				int old = finalRanking.get(pair.getFirst()).intValue();
				//update the ranking value
				finalRanking.put(pair.getFirst(), old + (position*multiplyfactorError));
			}else{
				//normally never gets called
				finalRanking.put(pair.getFirst(), position*multiplyfactorError);
			}
			
		}
		//traverse the final ranking find the minimum
		//by two equal findings we take the smaller error for LOW,LITTLE and NORMAL
		//for HIGH and MORE we take the smaller time
		
		//minima
		EstimationSpecification minimumEstimationSpecification = null;
		Integer minimumRanking = Integer.MAX_VALUE;
		//flag, if we consider time or error values for fine grained decission
		//if two ranking values are equal
		boolean fineDecissionOnMinimumTime = this.getTimeImportance() == TimeImportance.HIGH || this.getTimeImportance() == TimeImportance.MORE;
		
		//traverse the new ranking and find the minimum
		for(Entry<EstimationSpecification, Integer> entry:finalRanking.entrySet()){
			//compare the ranking values
			if(entry.getValue()<minimumRanking){
				//found new minimum
				minimumRanking = entry.getValue();
				minimumEstimationSpecification = entry.getKey();
			} else if(entry.getValue() == minimumRanking){
				//found same minimum
				
				//check the real values to make a decission
				if(fineDecissionOnMinimumTime){
					//look at the time values
					iteratorTime = null;
					iteratorTime = this.getSortedAlgorithmTimeMapping().iterator();
					while(iteratorTime.hasNext()){
						Pair<EstimationSpecification, Double> pair = iteratorTime.next();
						if(pair.getKey().equals(entry.getKey())){
							//first found the entry value
							//make it a new minimum
							minimumRanking = entry.getValue();
							minimumEstimationSpecification = entry.getKey();
							break;
						} else if(pair.getKey().equals(minimumEstimationSpecification)){
							//first found the old minimum
							//change nothing
							break;
						} else{
							//none of both found --> continue searching
						}
					}
				} else{
					//look at the error values
					iteratorError = null;
					iteratorError = this.getSortedAlgorithmErrorMapping().iterator();
					while(iteratorError.hasNext()){
						Pair<EstimationSpecification, Double> pair = iteratorError.next();
						if(pair.getKey().equals(entry.getKey())){
							//first found the entry value
							//make it a new minimum
							minimumRanking = entry.getValue();
							minimumEstimationSpecification = entry.getKey();
							break;
						} else if(pair.getKey().equals(minimumEstimationSpecification)){
							//first found the old minimum
							//change nothing
							break;
						} else{
							//none of both found --> continue searching
						}
					}
				}
			} else{
				//no new minimum --> do nothing
			}
		}
		
		//safety check
		if(minimumEstimationSpecification==null){
			//set the smallest error, because all the approaches need too much time
			minimumEstimationSpecification = getSortedAlgorithmErrorMapping().first().getFirst();
		}
		
		//return the best approach
		return minimumEstimationSpecification;
	}

	

}
