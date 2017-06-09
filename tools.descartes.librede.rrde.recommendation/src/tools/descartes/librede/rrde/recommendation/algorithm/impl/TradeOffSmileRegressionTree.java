package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import smile.regression.Regression;
import smile.regression.RegressionTree;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier;

/**
 * 
 * This is an implementation of {@link ITradeOffRecomendationAlgorithm} using the Regression
 * Tree algorithm from the Smile library.
 * 
 * @author Torsten Krauß (torsten.krauss@stud-mail.uni-wuerzburg.de)
 *
 */
public class TradeOffSmileRegressionTree extends AbstractTradeOffSmileAlgorithm {

	/**
	 * The logger used for logging.
	 */
	private static final Logger log = Logger.getLogger(TradeOffSmileRegressionTree.class);
	
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
		if (specifier instanceof RegressionTreeTradeOffAlgorithmSpecifier)
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
						new RegressionTree(training, 
								entry.getValue(), 
								((RegressionTreeTradeOffAlgorithmSpecifier) getSpecifier()).getMaxTreeNodes(), 
								((RegressionTreeTradeOffAlgorithmSpecifier) getSpecifier()).getSplitThreshould()));
			}
			for(Entry<EstimationSpecification, double[]> entry  : targetTime.entrySet()){
				regressionsTime.put(entry.getKey(), 
						new RegressionTree(training, 
								entry.getValue(), 
								((RegressionTreeTradeOffAlgorithmSpecifier) getSpecifier()).getMaxTreeNodes(), 
								((RegressionTreeTradeOffAlgorithmSpecifier) getSpecifier()).getSplitThreshould()));
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
