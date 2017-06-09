package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import java.util.SortedSet;

import org.apache.commons.math3.util.Pair;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.algorithm.AbstractTradOffAlgorithm;
import tools.descartes.librede.rrde.recommendation.algorithm.ITradeOffAlgorithm;

public class BestTimeTradeOffAlgorithm extends AbstractTradOffAlgorithm {

	@Override
	public EstimationSpecification getTradeOffEstimationSpecification() {
		if(getSortedAlgorithmErrorMapping() == null || getSortedAlgorithmTimeMapping() == null){
			return null;
		}
		return getSortedAlgorithmTimeMapping().first().getFirst();
	}

}
