package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.common.util.EMap;

import smile.regression.Regression;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.rrde.optimization.util.Util;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.algorithm.AbstractTradeOffRecommendationAlgorithm;
import tools.descartes.librede.rrde.recommendation.algorithm.ITradeOffAlgorithm;
import tools.descartes.librede.rrde.recommendation.algorithm.TimeImportance;

/**
 * 
 * Abstract class simplifying the usage of algorithms using the Smile interface
 * for trade off recommendations.
 * 
 * @author Torsten Krauß (torsten.krauss@stud-mail.uni-wuerzburg.de)
 *
 */
public abstract class AbstractTradeOffSmileAlgorithm extends AbstractTradeOffRecommendationAlgorithm {

	/**
	 * The collected feature values in the same order than the
	 * {@link #trainingfeatures}.
	 * This is only needed one time for both trade off values.
	 */
	private List<double[]> trainingfeatures;

	/**
	 * The corresponding target error values per {@link EstimationSpecification}
	 *  in the same order than the
	 * {@link #trainingfeatures}.
	 */
	private Map<EstimationSpecification, List<Double>> targetvaluesError;
	
	/**
	 * The corresponding target time values per {@link EstimationSpecification}
	 * in the same order than the
	 * {@link #trainingfeatures}.
	 */
	private Map<EstimationSpecification, List<Double>> targetvaluesTime;

	/**
	 * The map to store the results for the error and can be sorted to a ranking.
	 */
	private Map<EstimationSpecification, Double> algorithmErrorMapping;

	/**
	 * The sorted set to store the results for the error.
	 */
    private SortedSet<Pair<EstimationSpecification, Double>> sortedAlgorithmErrorMapping;
	
    /**
	 * The sorted set to store the results for the time.
	 */
    private SortedSet<Pair<EstimationSpecification, Double>> sortedAlgorithmTimeMapping;
    
	/**
	 * The map to store the results for the time and can be sorted to a ranking.
	 */
	private Map<EstimationSpecification, Double> algorithmTimeMapping;

	
	/**
	 * The regression that is trained by sub-classes and calculates the error.
	 */
	private Map<EstimationSpecification, Regression<double[]>> regressionsError;

	/**
	 * The regression that is trained by sub-classes and calculates the time.
	 */
	private Map<EstimationSpecification, Regression<double[]>> regressionsTime;

	
	/**
	 * @return the regression
	 */
	public Map<EstimationSpecification, Regression<double[]>> getRegressionsError() {
		return regressionsError;
	}

	/**
	 * @return the regression
	 */
	public Map<EstimationSpecification, Regression<double[]>> getRegressionsTime() {
		return regressionsTime;
	}
	
	/**
	 * @param regressions for errors
	 *            the regressions to set
	 */
	public void setRegressionsError(Map<EstimationSpecification, Regression<double[]>> regressions) {
		this.regressionsError = regressions;
	}
	
	/**
	 * @param regressions for time
	 *            the regressions to set
	 */
	public void setRegressionssTime(Map<EstimationSpecification, Regression<double[]>> regressions) {
		this.regressionsTime = regressions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.ITradeOffRecomendationAlgorithm
	 * #initialize(tools.descartes.librede.rrde.recommendation.
	 * RecommendationAlgorithmSpecifier)
	 */
	@Override
	public void initialize(RecommendationAlgorithmSpecifier specifier) {
		super.initialize(specifier);
		algorithmErrorMapping = new HashMap<>();
		algorithmTimeMapping = new HashMap<>();
		trainingfeatures = new ArrayList<>();
		targetvaluesError = new HashMap<>();
		targetvaluesTime = new HashMap<>();
		regressionsError = new HashMap<>();
		regressionsTime = new HashMap<>();
		sortedAlgorithmErrorMapping = new TreeSet<>(new Comparator<Pair<EstimationSpecification, Double>>() {
		      @Override
		      public int compare(Pair<EstimationSpecification, Double> one, Pair<EstimationSpecification, Double> two) {
		        double errone = one.getSecond();
		        double errtwo = two.getSecond();
		        if (errone < errtwo) {
		          return -1;
		        } else if (errone == errtwo) {
		          return 0;
		        }
		        return 1;
		      }
		    });
		sortedAlgorithmTimeMapping = new TreeSet<>(new Comparator<Pair<EstimationSpecification, Double>>() {
		      @Override
		      public int compare(Pair<EstimationSpecification, Double> one, Pair<EstimationSpecification, Double> two) {
		        double errone = one.getSecond();
		        double errtwo = two.getSecond();
		        if (errone < errtwo) {
		          return -1;
		        } else if (errone == errtwo) {
		          return 0;
		        }
		        return 1;
		      }
		    });
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see tools.descartes.librede.rrde.recommendation.algorithm.
	 * AbstractTradeOffRecommendationAlgorithm#flushTrainingExamples()
	 */
	@Override
	protected boolean flushTrainingExamples() {
		boolean rcErrors = true;
		boolean rcTime = true;
		// parse all training examples into double arrays
		
		// for errors and features
		for (Entry<FeatureVector, EMap<EstimationSpecification, Double>> errorEntry : getTrainingMapError()
				.entrySet()) {
			rcErrors = parseTrainingSetErrorAndFeatures(errorEntry.getValue(), errorEntry.getKey());
		}
		
		// for time
		for (Entry<FeatureVector, EMap<EstimationSpecification, Double>> timeEntry : getTrainingMapTime()
				.entrySet()) {
			rcTime = parseTrainingSetTime(timeEntry.getValue(), timeEntry.getKey());
		}

		if(!rcErrors || !rcTime){
			getLog().error("Error forwarded...");
			return false;
		}
		//check size
		if (trainingfeatures.size() == 0) {
			getLog().error("No training data available...");
			return false;
		}
		//check if the size of all the lists match up.
		for(Entry<EstimationSpecification,List<Double>> entry :targetvaluesError.entrySet())
			if (entry.getValue().size() != trainingfeatures.size()) {
			getLog().error(
					"The number of training examples and target values does not match.");
			return false;
		}
		//check if the size of all the lists match up.
		for(Entry<EstimationSpecification,List<Double>> entry :targetvaluesTime.entrySet())
			if (entry.getValue().size() != trainingfeatures.size()) {
			getLog().error(
					"The number of training examples and target values does not match.");
			return false;
		}
				
				
		// Variables to convert the errors/time, which are the target values to an int array.
		Map<EstimationSpecification, double[]> targetError = new HashMap<EstimationSpecification, double[]>();
		Map<EstimationSpecification, double[]> targetTime = new HashMap<EstimationSpecification, double[]>();
		// for errors
		for (Entry<EstimationSpecification, List<Double>> errorEntry : targetvaluesError.entrySet()) {
			targetError.put(errorEntry.getKey(), Util.convertListDouble(errorEntry.getValue().toArray(new Double[0])));
		}
		
		// for time
		for (Entry<EstimationSpecification, List<Double>> timeEntry : targetvaluesTime.entrySet()) {
			targetTime.put(timeEntry.getKey(), Util.convertListDouble(timeEntry.getValue().toArray(new Double[0])));
		}
		// for features
		double[][] training = trainingfeatures.toArray(new double[0][0]);
		
		if (training == null || targetError == null || targetTime == null) {
			getLog().error("Training or target values are null.");
			return false;
		}
		// check if all train sets are the same target variable
		/*boolean allequal = true;
		for (int i = 0; i < targetError.length; i++) {
			if (targetError[i] != targetError[(i + 1) % targetError.length]) {
				allequal = false;
				break;
			}
		}
		if (allequal) {
			// catch case if all train sets are equal
			this.classifiersError = new DummyClasifier(target[0]);
			return true;
		}*/
		
		//start the training
		return train(training, targetError, targetTime);
	}

	/**
	 * 
	 * Trains the algorithm with the given examples.
	 * 
	 * @param training
	 * @param targetError
	 * @param targetTime
	 * @return
	 */
	public abstract boolean train(double[][] training, Map<EstimationSpecification, double[]> targetError,
			Map<EstimationSpecification, double[]> targetTime);

	/**
	 * Is called by {@link #flushTrainingExamples()}and adds a new training
	 * example to the training set for error regression and into the feature set.
	 * 
	 * @param errors
	 *            A mapping of {@link EstimationSpecification} to its
	 *            performance on the described feature set by an error value.
	 * @param features
	 *            The {@link FeatureVector} to the corresponding targetValue
	 * @return True if the example was successfully included, false otherwise.
	 * 
	 */
	protected boolean parseTrainingSetErrorAndFeatures(
			EMap<EstimationSpecification, Double> errors, FeatureVector features) {
		//traverse all the estimation approaches for this feature vecotr
		//and save them to the corresponding target value training set for the regression
		for (Entry<EstimationSpecification, Double> entry : errors) {
			//get the key
			EstimationSpecification estimationSpecification = entry.getKey();
			if (estimationSpecification == null) {
				getLog().warn("No EstimationSpecification!");
				return false;
			}
			//get the value
			Double error = entry.getValue().doubleValue();
			
			//create new map entry, if it is not there yet.
			if(!targetvaluesError.containsKey(estimationSpecification)){
				targetvaluesError.put(estimationSpecification, new ArrayList<Double>());
			}
			
			//get the error list of the corresponding EstimationSpecification / key
			List<Double> estimationSpecificationTargetList = 
					targetvaluesError.get(estimationSpecification);
			
			//add new value to the list
			estimationSpecificationTargetList.add(error);
		}
		//add the feature to the feature training set
		trainingfeatures.add(parseToDoubles(features));
		
		return true;
	}
	/**
	 * Is called by {@link #flushTrainingExamples()}and adds a new training
	 * example to the training set for time regression.
	 * 
	 * @param errors
	 *            A mapping of {@link EstimationSpecification} to its
	 *            performance on the described feature set by an error value.
	 * @param features
	 *            The {@link FeatureVector} to the corresponding targetValue
	 * @return True if the example was successfully included, false otherwise.
	 * 
	 */
	protected boolean parseTrainingSetTime(
			EMap<EstimationSpecification, Double> times, FeatureVector features) {
		//traverse all the estimation approaches for this feature vecotr
		//and save them to the corresponding target value training set for the regression
		for (Entry<EstimationSpecification, Double> entry : times) {
			//get the key
			EstimationSpecification estimationSpecification = entry.getKey();
			if (estimationSpecification == null) {
				getLog().warn("No EstimationSpecification!");
				return false;
			}
			//get the value
			Double time = entry.getValue().doubleValue();

			//create new map entry, if it is not there yet.
			if(!targetvaluesTime.containsKey(estimationSpecification)){
				targetvaluesTime.put(estimationSpecification, new ArrayList<Double>());
			}
			
			//get the time list of the corresponding EstimationSpecification / key
			List<Double> estimationSpecificationTargetList = 
					targetvaluesTime.get(estimationSpecification);
			
			//add the new time value
			estimationSpecificationTargetList.add(time);
		}
		//DO NOT add the feature to the feature training set here, because
		//it was done in parseTraingSetErrorAndFeatures(...) already
		
		return true;
	}

	/**
	 * Returns the number of different {@link EstimationSpecification}s used for
	 * training.
	 * 
	 * @return The size of the mapping between estimations and indexes
	 */
	protected int getNumberOfSupportedEstimators() {
		return targetvaluesError.size();
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tools.descartes.librede.rrde.recommendation.algorithm.ITradeOffRecomendationAlgorithm
	 * #
	 * recommendEstimation(tools.descartes.librede.rrde.recommendation.FeatureVector
	 * )
	 */
	@Override
	public EstimationSpecification recommendEstimation(FeatureVector features, Double timeThreshold, TimeImportance timeImportance) {
		//check if the classifiers are available
		for(Entry<EstimationSpecification, Regression<double[]>> entry :regressionsError.entrySet()){
			if (entry.getValue() == null) {
				getLog().error("One regression is null.");
				return null;
			}
		}
		for(Entry<EstimationSpecification, Regression<double[]>> entry :regressionsTime.entrySet()){
			if (entry.getValue() == null) {
				getLog().error("One regression is null.");
				return null;
			}
		}
		
		//get the number variables
		if (features.getNumberOfRessources() > getSupportedResources()) {
			getLog().warn(
					"The number of resources is higher than supported by the training set.");
		}
		if (features.getNumberOfWorkloadClasses() > getSupportedWorkloadClasses()) {
			getLog().warn(
					"The number of workload classes is higher than supported by the training set.");
		}
		
		//get the results of the regression
		for(Entry<EstimationSpecification, Regression<double[]>> entry :regressionsError.entrySet()){
			algorithmErrorMapping.put(entry.getKey(), entry.getValue().predict(parseToDoubles(features)));
			sortedAlgorithmErrorMapping.add(new Pair<EstimationSpecification, Double>(entry.getKey(), entry.getValue().predict(parseToDoubles(features))));
		}
		for(Entry<EstimationSpecification, Regression<double[]>> entry :regressionsTime.entrySet()){
			algorithmTimeMapping.put(entry.getKey(), entry.getValue().predict(parseToDoubles(features)));
			sortedAlgorithmTimeMapping.add(new Pair<EstimationSpecification, Double>(entry.getKey(), entry.getValue().predict(parseToDoubles(features))));
		}
		//here we have two lists with the result
		//Class.forName(spec.getFeatureExtractor())
		//.getDeclaredConstructor(spec.getClass().getInterfaces()[0]).newInstance(spec);
		
		ITradeOffAlgorithm tradeOffAlgorithm;
		EstimationSpecification estimationSpecification = null;
		try {
			tradeOffAlgorithm = (ITradeOffAlgorithm) Class.forName(((RecommendationTradeOffAlgorithmSpecifier) this.getSpecifier()).getTradeOffAlgorithmName())
					.getConstructor().newInstance();
					tradeOffAlgorithm.initialize(sortedAlgorithmErrorMapping, sortedAlgorithmTimeMapping,timeThreshold, timeImportance);
					estimationSpecification = tradeOffAlgorithm.getTradeOffEstimationSpecification();
		} catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | SecurityException | ClassNotFoundException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		//String al = ((RecommendationTradeOffAlgorithmSpecifier) this.getSpecifier()).getTradeOffAlgorithmName();
		//ThresholdTradeOffAlgorithm algor = this.getClass().getClassLoader().loadClass(al);
		//ITradeOffAlgorithm tradeOffAlgorithm = new ThresholdTradeOffAlgorithm();
		
		// return the right result.
		return estimationSpecification;
	}

	@Override
	public EstimationSpecification recommendEstimation(FeatureVector features) {
		getLog().error("unsupported Function recommendEstimation in this class.");
		return null;
	}
	
}
