package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import smile.regression.OLS;
import smile.regression.Regression;
import smile.regression.RegressionTree;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.OLSTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier;

public class TradeOffSmileOLS extends AbstractTradeOffSmileAlgorithm {

	/**
	 * The logger used for logging.
	 */
	private static final Logger log = Logger.getLogger(TradeOffSmileOLS.class);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.IRecomendationAlgorithm
	 * #isSpecifierSupported(tools.descartes.librede.rrde.recommendation.
	 * RecommendationAlgorithmSpecifier)
	 */
	@Override
	public boolean isSpecifierSupported(RecommendationAlgorithmSpecifier specifier) {
		if (specifier instanceof OLSTradeOffAlgorithmSpecifier)
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
		
		/*double[][] olstraining = new double[training[0].length][training.length];
		for(int i=0; i<training.length; ++i){
			for(int j=0; j<training[0].length;++j){
				olstraining[j][i] = training [i][j];
			}
		}*/
		
		try {

			Map<EstimationSpecification, Regression<double[]>> regressionsError = new HashMap<EstimationSpecification, Regression<double[]>>();
			Map<EstimationSpecification, Regression<double[]>> regressionsTime = new HashMap<EstimationSpecification, Regression<double[]>>();
			
			for(Entry<EstimationSpecification, double[]> entry  : targetError.entrySet()){
				regressionsError.put(entry.getKey(), 
						new OLS(training, 
								entry.getValue()));
			}
			for(Entry<EstimationSpecification, double[]> entry  : targetTime.entrySet()){
				regressionsTime.put(entry.getKey(), 
						new OLS(training, 
								entry.getValue()));
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
