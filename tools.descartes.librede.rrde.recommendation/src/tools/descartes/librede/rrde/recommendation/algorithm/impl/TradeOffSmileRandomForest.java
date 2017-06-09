package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import smile.regression.RandomForest;
import smile.regression.Regression;
import smile.regression.RegressionTree;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier;

public class TradeOffSmileRandomForest extends AbstractTradeOffSmileAlgorithm {

	/**
	 * The logger used for logging.
	 */
	private static final Logger log = Logger.getLogger(TradeOffSmileRandomForest.class);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm
	 * #isSpecifierSupported(tools.descartes.librede.rrde.recommendation.
	 * RecommendationAlgorithmSpecifier)
	 */
	@Override
	public boolean isSpecifierSupported(
			RecommendationAlgorithmSpecifier specifier) {
		if (specifier instanceof RandomForestTradeOffAlgorithmSpecifier)
			return true;
		return false;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.recommendation.algorithm.
	 * AbstractTradeOffRecommendationAlgorithm#getLog()
	 */
	@Override
	protected Logger getLog() {
		return log;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.recommendation.algorithm.impl.
	 * AbstractTradeOffSmileAlgorithm#train(double[][],
	 * Map<EstimationSpecification, int[]>,
	 * Map<EstimationSpecification, int[]>)
	 */
	@Override
	public boolean train(double[][] training, Map<EstimationSpecification, double[]> targetError,
			Map<EstimationSpecification, double[]> targetTime) {
		try {

			Map<EstimationSpecification, Regression<double[]>> regressionsError = new HashMap<EstimationSpecification, Regression<double[]>>();
			Map<EstimationSpecification, Regression<double[]>> regressionsTime = new HashMap<EstimationSpecification, Regression<double[]>>();
			
			for(Entry<EstimationSpecification, double[]> entry  : targetError.entrySet()){
				regressionsError.put(entry.getKey(), 
						new RandomForest(training, 
								entry.getValue(), 
								((RandomForestTradeOffAlgorithmSpecifier) getSpecifier()).getTreeNumber(), 
								((RandomForestTradeOffAlgorithmSpecifier) getSpecifier()).getSplitThreshould(), 
								((RandomForestTradeOffAlgorithmSpecifier) getSpecifier()).getMaxTreeNodes(), training[0].length/3));
			}
			for(Entry<EstimationSpecification, double[]> entry  : targetTime.entrySet()){
				regressionsTime.put(entry.getKey(), 
						new RandomForest(training, 
								entry.getValue(), 
								((RandomForestTradeOffAlgorithmSpecifier) getSpecifier()).getTreeNumber(), 
								((RandomForestTradeOffAlgorithmSpecifier) getSpecifier()).getSplitThreshould(), 
								((RandomForestTradeOffAlgorithmSpecifier) getSpecifier()).getMaxTreeNodes(), training[0].length/3));
			}
			setRegressionsError(regressionsError);
			setRegressionssTime(regressionsTime);
			return true;
		} catch (Exception e) {
			log.error(
					"The training of the neural network did not finish successfully.",
					e);
			return false;
		}
	}

}
