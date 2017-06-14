package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import java.util.SortedSet;

import org.apache.commons.math3.util.Pair;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.algorithm.AbstractTradeOffAlgorithm;
import tools.descartes.librede.rrde.recommendation.algorithm.ITradeOffAlgorithm;

public class BestErrorTradeOffAlgorithm extends AbstractTradeOffAlgorithm {


	@Override
	public EstimationSpecification getTradeOffEstimationSpecification() {
		// Auto-generated method stub
		if(getSortedAlgorithmErrorMapping() == null || getSortedAlgorithmTimeMapping() == null){
			return null;
		}
		return getSortedAlgorithmErrorMapping().first().getFirst();
	}


}
