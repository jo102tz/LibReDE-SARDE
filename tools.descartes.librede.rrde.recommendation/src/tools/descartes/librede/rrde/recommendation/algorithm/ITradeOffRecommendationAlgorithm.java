package tools.descartes.librede.rrde.recommendation.algorithm;

import java.sql.Time;

import org.eclipse.emf.common.util.EMap;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.recommendation.FeatureVector;

/**
 * 
 * Interface for machine learning algorithm, that recommends an estimation approach,
 * due to a trade off between quality / error and calculation time / time to result.
 * 
 * @author torsten
 *
 */
public interface ITradeOffRecommendationAlgorithm extends IRecomendationAlgorithm {

	/**
	 * Inserts one training example for each of the {@link ConfigurationResult}
	 * s. The given {@link EstimationSpecification}s contained in the
	 * {@link ConfigurationResult}s will be stored and can now be returned by
	 * {@link #recommendEstimation(FeatureVector)}.
	 * 
	 * @param errors
	 *            A mapping of {@link EstimationSpecification} to its
	 *            performance on the described feature set by an error value.
	 * @param times
	 *            A mapping of {@link EstimationSpecification} to its
	 *            performance on the described feature set by the time to result.
	 * @param features
	 *            The {@link FeatureVector} to the corresponding targetValue
	 * @return True if the example was successfully included, false otherwise.
	 * @throws IllegalStateException
	 *             If no training examples are accepted anymore, e.g. if the
	 *             training phase was completed by a call of
	 *             {@link #endTrainingPhase()}.
	 */
	public boolean trainSet(EMap<EstimationSpecification, Double> errors, EMap<EstimationSpecification, Double> times,
			FeatureVector features) throws IllegalStateException;
	
	/**
	 * Recommend a specific {@link EstimationSpecification} for the given
	 * {@link FeatureVector}.
	 * 
	 * @param features
	 *            The extracted features
	 * @param timeThreshold
	 *            The desired time threshold
	 * @param timeImportance
	 *            The importance of the time for high 1 to low 5
	 * @return The recommended {@link EstimationSpecification} to run or
	 *         <code>null</code> if the recommendation failed
	 */
	public EstimationSpecification recommendEstimation(FeatureVector features, Double timeThreshold, TimeImportance timeImportance);
	
	
	
}
