	package tools.descartes.librede.rrde.optimization.cluster;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.NormalizedEuclideanDistance;
import net.sf.javaml.tools.data.FileHandler;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.model.optimization.impl.DataExportSpecifierImpl;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.optimization.cluster.impl.ClusterExportAlgorithm;

public abstract class AbstractClusterer implements IClusterer {
	
	private IOptimizableParameter parameter;
	private boolean finishedCalculation;
	
	protected LinkedHashMap<Instance, List<Double>> instanceToFeatureVector = new LinkedHashMap<>();
	protected LinkedHashMap<Instance, Integer> instanceToID = new LinkedHashMap<>();
	protected LinkedHashMap<Instance, Dataset> instanceToCluster = new LinkedHashMap<>();
	protected List<Double> headerValues = new ArrayList<Double>();
	protected HashMap<Instance,LibredeConfiguration> instanceToConf = new HashMap<>();
	
	private List<List<Double>> meanFeatures = new ArrayList<>();
	private List<Instance> means = new ArrayList<>();
	private int numberOfFeatures;
	protected List<Double> features;
	private double[] coefficients;
	private Dataset[] result;
	protected List<List<LibredeConfiguration>> resultMap = new ArrayList<>();
	
	private EstimationSpecification estimation;
	private EList<InputData> input;
	private OptimizationSettings settings;
	private ConfigurationOptimizationAlgorithmSpecifier specifier;
	
	protected Dataset data;

	public AbstractClusterer(EstimationSpecification estimation, EList<InputData> input,
			OptimizationSettings settings, ConfigurationOptimizationAlgorithmSpecifier specifier) {
		this.estimation = estimation;
		this.input = input;
		this.settings = settings;
		this.specifier = specifier;
		this.parameter = settings.getParametersToOptimize().get(0);
	}
	
	public boolean initExport() {
		finishedCalculation = false;
		ClusterExportAlgorithm export = new ClusterExportAlgorithm();
		DataExportSpecifierImpl sp = new DataExportSpecifierImpl();
//		export.setAlgorithm(new DataExportSpecifierImpl());
		boolean done = export.optimizeConfiguration(estimation, input, settings, sp);
		this.data = export.getData();
		for (Instance instance : data) {
			if (Double.isNaN(instance.value(0))) {
				System.out.println("Double is still NaN");
				instance.removeAttribute(0);
			}
		}
		this.instanceToConf = export.getInstanceToConf();
		this.instanceToFeatureVector = export.getInstanceToFeatureVector();
		this.result = cluster();
		finishedCalculation = done;
		return true;
	}

	@Override
	public List<List<LibredeConfiguration>> getConfResult() {
		return resultMap;
	}
	
	@Override
	public List<Instance> getMeans() {
		return means;
	}
	
	public void setMeans(List<Instance> newMeans) {
		this.means = newMeans;
	}

	@Override
	public List<List<Double>> getMeanFeatures() {
		return meanFeatures;
	}
	
	public void setMeanFeatures(List<List<Double>> newFeatures) {
		this.meanFeatures = newFeatures;
	}

	@Override
	public double[] getCoefficients() {
		return coefficients;
	}
	
	@Override
	public void setCoefficients(double[] coefficients) {
		this.coefficients = coefficients;
	}	
	
	protected LinkedHashMap<Instance, Dataset> mapInstanceToCluster(Dataset[] datasets) {
		LinkedHashMap<Instance,Dataset> tmpCluster = new LinkedHashMap<>();
		for (Dataset dataset : datasets) {
			for (Instance instance : dataset) {
				tmpCluster.put(instance, dataset);
			}
		}
		return tmpCluster;
	}

	protected LinkedHashMap<Instance,Integer> mapInstanceToID(Dataset dataset) {
		LinkedHashMap<Instance,Integer> tmpID = new LinkedHashMap<>();
		for (int i = 0; i < dataset.size(); i++) {
			tmpID.put(dataset.get(i), i);
		}
		return tmpID;
	}

	protected double[][] calculateDistances(Dataset dataset) {
		double[][] result = new double[dataset.size()][dataset.size()];
		for (int column = 0; column < dataset.size(); column++) {
			NormalizedEuclideanDistance dist = new NormalizedEuclideanDistance(dataset);
			for (int row = column; row < dataset.size(); row++) {
				result[column][row] = dist.calculateDistance(dataset.get(row), dataset.get(column));
				result[row][column] = result[column][row];
			}
		}
		return result;
	}
	
	protected List<Double> createFeatures(FeatureVector vector) {
		List<Double> result = new ArrayList<Double>();
		result.add((double)vector.getNumberOfRessources());
		result.add((double)vector.getNumberOfWorkloadClasses());
		result.add(vector.getVarianceInflationFactor());
		result.add(vector.getUtilizationStatistics().get(0).getArithmeticMean());
		return result;
	}

	
	protected double calculateSilhouette(Dataset[] datasets, double[][] distanceTable) {
		double result = 0;
		for (Map.Entry<Instance, Dataset> entry : instanceToCluster.entrySet()) {
			Dataset cluster = entry.getValue();
			Instance inst = entry.getKey();
			double a = calculateDistance(cluster, inst, instanceToID, distanceTable);
			double b = Double.POSITIVE_INFINITY;
			for (Dataset alienCluster : datasets) {
				if (!alienCluster.equals(cluster)) {
					double tmp = calculateDistance(alienCluster, inst, instanceToID, distanceTable);
					if (tmp < b) {
						b = tmp;
					}
				}
			}
			double silh;
			if (a == 0) {
				silh = 0;
			} else if (a > b) {
				silh = (b-a)/a;
			} else {
				silh = (b-a)/b;
			}
			result += silh;
		}
		return result/instanceToCluster.size();
	}

	private static double calculateDistance(Dataset cluster, Instance instance, LinkedHashMap<Instance, Integer> instanceToID, double[][] distanceTable) {
		double sum = 0;
		for (Instance newInst : cluster) {
			Set<Map.Entry<Instance, Integer>> entries = instanceToID.entrySet();
			int instID=0;
			int newInstID=0;
			for (Entry<Instance, Integer> entry : entries) {
				if (entry.getKey().equals(instance)) {
					instID = entry.getValue();
				}
				if (entry.getKey().equals(newInst)) {
					newInstID = entry.getValue();
				}
			}
			sum += distanceTable[instID][newInstID];
		}
		return sum/cluster.size();
	}

	protected Instance calculateMeanInstance(Dataset d) {
		double[] values = new double[d.get(0).noAttributes()];
		for (int i = 0; i < values.length; i++) {
			double sum = 0;
			for (Instance inst : d) {
				sum += inst.value(i);
			}
			sum = sum/d.size();
			values[i] = sum;
		}
		Instance result = new DenseInstance(values);
		return result;
	}
	
	protected List<Double> calculateMeanFeatures(Dataset d) {
		List<Double> result = new ArrayList<>();
		for (int i = 0; i < instanceToFeatureVector.get(d.get(0)).size(); i++) {
			double sum = 0;
			for (Instance instance : d) {
				double feature = instanceToFeatureVector.get(instance).get(i);
				sum += feature;
			}
			sum = sum/d.size();
			result.add(sum);
		}
		return result;
	}

	@SuppressWarnings("unused")
	private Dataset prepareData(String path) throws IOException {
		Dataset data = readIn(path);
		extractHeader(data);
		data.remove(0);
		for (Instance instance : data) {
			if (Double.isNaN(instance.value(0))) {
				instance.removeAttribute(0);
			}
		}
		data = extractFeatureVector(data);
		calculateDistances(data);
		return data;
	}
	
	private Dataset readIn(String path) throws IOException {
		System.out.println("reading new file...");
		Dataset data = FileHandler.loadDataset(new File(path), ";");
		return data;
	}
	
	private String extractHeader(Dataset data) {
		//extract header
		String header = "";
		for (double value : data.get(0)) {
			headerValues.add(value);
			header += value + ";";
		}
		header += System.lineSeparator();
		return header;
	}
	
	private Dataset extractFeatureVector(Dataset data) {
		for (Instance instance : data) {
			List<Double> featureVector = new ArrayList<>();
			int size = instance.noAttributes();
			int j = size - numberOfFeatures;
			for (int i = 0; i < numberOfFeatures; i++) {
				featureVector.add(instance.value(j));
				instance.removeAttribute(j);
			}
			instanceToFeatureVector.put(instance, featureVector);
		}
		return data;
	}
	
	protected Instance convertVectorToInstance(List<Double> newVector, double[] coefficients) {
		double[] values = new double[newVector.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = newVector.get(i)*coefficients[i];
		}
		Instance result = new DenseInstance(values);
		return result;
	}

	
	@Override
	public Dataset[] getResults() {
		return result;
	}
	
	@Override
	public List<Double> getHeader() {
		return headerValues;
	}

	@Override
	public EstimationSpecification getSpecification() {
		return estimation;
	}

	public void setSpecification(EstimationSpecification estimation) {
		this.estimation = estimation;
	}
	
	@Override
	public boolean isParameterSupported(IOptimizableParameter parameter) {
		return this.parameter.equals(parameter);
	}
	
	@Override
	public boolean finishedCalculation() {
		return finishedCalculation;
	}

	@Override
	public int getNumberOfFeatures() {
		return numberOfFeatures;
	}
	
	@Override
	public List<Double> getFeatures() {
		return features;
	}
	
	public EList<InputData> getInput() {
		return input;
	}
	
	public OptimizationSettings getSettings() {
		return settings;
	}
	
	public ConfigurationOptimizationAlgorithmSpecifier getSpecifier() {
		return specifier;
	}
	
	@Override
	public HashMap<Instance, LibredeConfiguration> getInstanceToConf() {
		return instanceToConf;
	}
}
