/**
 * ==============================================
 *  LibReDE : Library for Resource Demand Estimation
 * ==============================================
 *
 * (c) Copyright 2013-2014, by Simon Spinner and Contributors.
 *
 * Project Info:   http://www.descartes-research.net/
 *
 * All rights reserved. This software is made available under the terms of the
 * Eclipse Public License (EPL) v1.0 as published by the Eclipse Foundation
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * This software is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License (EPL)
 * for more details.
 *
 * You should have received a copy of the Eclipse Public License (EPL)
 * along with this software; if not visit http://www.eclipse.org or write to
 * Eclipse Foundation, Inc., 308 SW First Avenue, Suite 110, Portland, 97204 USA
 * Email: license (at) eclipse.org
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 */
package tools.descartes.librede.rrde.optimization;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import tools.descartes.librede.ApproachResult;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.algorithm.IEstimationAlgorithm;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.EstimationAlgorithmConfiguration;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.Parameter;
import tools.descartes.librede.linalg.Matrix;
import tools.descartes.librede.linalg.Vector;
import tools.descartes.librede.registry.ParameterDefinition;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;
import tools.descartes.librede.validation.IValidator;

/**
 * This class contains some useful utilities.
 * 
 * @author JS
 *
 */
public class Util {

	/**
	 * The logger of this class
	 */
	private static final Logger log = Logger.getLogger(Util.class);

	/**
	 * Set the value of the given Parameter in the given specification
	 * 
	 * @param librede
	 *            The LibReDE Configuration to modify
	 * @param value
	 *            The numeric value to set
	 * @param param
	 *            The {@link IOptimizableParameter} to set
	 */
	public static void setValue(EstimationSpecification librede, double value, IOptimizableParameter param) {
		String eClass = param.getClass().getInterfaces()[0].getName();
		if (eClass.equals(StepSize.class.getName())) {
			librede.getStepSize().setValue(value);
			log.trace("Set Stepsize to " + value);
		} else if (eClass.equals(WindowSize.class.getName())) {
			int integer = (int) Math.round(value);
			if (integer != value) {
				log.debug("The value " + value + " is not an Integer and had to be rounded to fit as window size.");
			}
			librede.setWindow(integer);
			log.trace("Set Windowsize to " + integer);
		} else if (eClass.equals(StepSizeRelWindow.class.getName())) {
			librede.getStepSize().setValue(value);
			log.trace("Set Stepsize to " + value);
			int integer = (int) Math.round(((StepSizeRelWindow) param).getProductMaxValue() / value);
			librede.setWindow(integer);
			log.trace("Adapt Windowsize to " + integer);
		} else if (eClass.equals(GenericParameter.class.getName())) {
			setGenericParameter(librede, (GenericParameter) param, Double.toString(value));
			log.trace("Set " + getParameterString(param) + " to " + value);
		} else {
			log.error("No handling adapter of setting Optimizable Parameter " + eClass);
		}
	}

	/**
	 * Sets the value of a {@link GenericParameter} in the given specification
	 * 
	 * @param librede
	 *            The LibReDE Configuration to modify
	 * @param value
	 *            The String value to set
	 * @param param
	 *            The {@link GenericParameter} to set
	 */
	public static void setGenericParameter(EstimationSpecification librede, GenericParameter param, String value) {
		// it is usually enough to find one parameter with the given name
		// multiple parameters will be set anyhow
		boolean oneSet = false;
		for (EstimationAlgorithmConfiguration alg : librede.getAlgorithms()) {
			// if this parameter is of this class
			if (containsParameter(alg, param)) {
				// if the list is null, we can just create a new one and create
				// the object
				if (alg.getParameters() == null) {
					EList<Parameter> newParams = new BasicEList<Parameter>();
					newParams.add(EcoreUtil.copy(param.getParameter()));
					oneSet = true;
				} else {
					// the list is not null
					boolean present = false;
					// if the parameter is present already
					for (Parameter par : alg.getParameters()) {
						if (par.getName().equals(param.getParameter().getName())) {
							par.setValue(value);
							present = true;
							oneSet = true;
						}
					}
					// if the param was not present
					if (!present) {
						alg.getParameters().add(EcoreUtil.copy(param.getParameter()));
						oneSet = true;
					}
				}
			}
		}
		if (oneSet != true) {
			log.warn("The generic parameter " + getParameterString(param) + " could not be set.");
		}
	}

	/**
	 * Checks if the fields with {@link Annotation} in all
	 * {@link IEstimationAlgorithm}s do support the given
	 * {@link GenericParameter}.
	 * 
	 * @param alg
	 *            The {@link EstimationAlgorithmConfiguration} to check
	 * @param param
	 *            The {@link GenericParameter} to check
	 * @return True, if the parameter is actually present, false if not
	 */
	private static boolean containsParameter(EstimationAlgorithmConfiguration alg, GenericParameter param) {
		// check if this class actually should support this parameter
		try {

			@SuppressWarnings("unchecked")
			Class<? extends IEstimationAlgorithm> c = (Class<? extends IEstimationAlgorithm>) Class
					.forName(alg.getType());

			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(tools.descartes.librede.registry.ParameterDefinition.class)) {
					ParameterDefinition anno = field
							.getAnnotation(tools.descartes.librede.registry.ParameterDefinition.class);
					if (anno.name().equals(param.getParameter().getName())) {
						return true;
					}
				}
			}

		} catch (ClassNotFoundException | ClassCastException e) {
			log.error("Could not find class " + alg.getType(), e);
		}
		return false;
	}

	/**
	 * Gets the value of a {@link GenericParameter} in the given specification
	 * 
	 * @param librede
	 *            The LibReDE Configuration to read
	 * @param param
	 *            The {@link GenericParameter} to get
	 * 
	 * @return The String value of the parameter
	 */
	public static String getGenericParameter(EstimationSpecification librede, GenericParameter param) {
		for (EstimationAlgorithmConfiguration alg : librede.getAlgorithms()) {
			for (Parameter par : alg.getParameters()) {
				if (par.getName().equals(param.getParameter().getName())) {
					return par.getValue();
				}
			}
		}
		log.warn("No key " + getParameterString(param) + "found.");
		return null;
	}

	/**
	 * Retrieves the value of the given Parameter in the given specification
	 * 
	 * @param librede
	 *            The LibReDE Configuration to read
	 * @param param
	 *            The Parameter to get
	 * 
	 * @return The double value of the parameter
	 */
	public static double getValue(EstimationSpecification librede, IOptimizableParameter param) {
		String eClass = param.getClass().getInterfaces()[0].getName();
		// Treat StepSize and StepSizeRelWindow equal
		if (eClass.equals(StepSize.class.getName()) || eClass.equals(StepSizeRelWindow.class.getName())) {
			return librede.getStepSize().getValue();
		} else if (eClass.equals(WindowSize.class.getName())) {
			return librede.getWindow();
		} else if (eClass.equals(GenericParameter.class.getName())) {
			try {
				return Double.parseDouble(getGenericParameter(librede, (GenericParameter) param));
			} catch (NumberFormatException e) {
				log.error("The generic parameter with key " + getParameterString(param) + " has value "
						+ getGenericParameter(librede, (GenericParameter) param) + " which is not numeric.");
				return -1;
			} catch (NullPointerException e) {
				log.warn("The generic parameter with key " + getParameterString(param)
						+ " has a null value. Returning 0 instead.");
				return 0;
			}
		} else {
			log.error("No handling adapter of setting Optimizable Parameter " + eClass);
		}
		return -1;
	}

	/**
	 * Calculates the mean Validation error, i.e. the target function value.
	 * 
	 * @param result
	 *            The result produced by LibReDE
	 * @return The mean validation error
	 * 
	 * @deprecated Prefer the use of
	 *             {@link #getValidationError(LibredeResults, IEstimationApproach, IValidator)}
	 *             instead.
	 */
	@Deprecated
	public static double getMeanValidationError(LibredeResults result) {
		if (result.getApproaches().size() > 1) {
			log.error("More than one approach is not supported. " + result);
			throw new InputMismatchException("More than one approach is not supported.");
		}
		// return getAverageOfMeanValidationErrors(result);
		// return getUtilizationError(result,
		// result.getApproaches().iterator().next());
		return getResponseTimeError(result, result.getApproaches().iterator().next());
	}

	/**
	 * Calculates the mean Validation error, i.e. the target function value.
	 * 
	 * @param result
	 *            The result produced by LibReDE
	 * @return The mean validation error
	 * 
	 */
	public static double getAverageOfMeanValidationErrors(LibredeResults result) {
		// equally averaging over all validators and all approaches
		SummaryStatistics values = new SummaryStatistics();
		if (result == null) {
			return Double.MAX_VALUE;
		}
		Map<Class<? extends IEstimationApproach>, Matrix> errorMap = result.getValidationErrors();
		for (Class<? extends IEstimationApproach> approach : result.getApproaches()) {
			Matrix appError = errorMap.get(approach);
			if ((int) appError.columns() != result.getNumberOfFolds()) {
				log.warn("Not enough fold validation results available: " + result.toString());
			}
			if (appError.rows() != result.getValidatedEntities().entrySet().size()) {
				log.warn("Not enough validators for results available: " + result.toString());
			}

			for (int i = 0; i < appError.columns(); i++)
				for (int j = 0; j < appError.rows(); j++)
					if (!Double.isNaN(appError.get(j, i))) {
						values.addValue(appError.get(j, i));
					} else {
						log.warn("Validator returned NaN.");
					}
			if (values.getN() < 1) {
				log.warn("No validation results for approach " + result.getApproaches().iterator().next());
				return Double.MAX_VALUE;
			}
		}
		if (Double.isNaN(values.getMean())) {
			return Double.MAX_VALUE;
		}
		return values.getMean();
	}

	/**
	 * Calculates the mean response time error for the given
	 * {@link LibredeResults}.
	 * 
	 * @param result
	 *            The result produced by LibReDE
	 * @param approach
	 *            The approach to validate
	 * 
	 * @return The mean response time error
	 */
	public static double getResponseTimeError(LibredeResults result, Class<? extends IEstimationApproach> approach) {
		ApproachResult approachResult = result.getApproachResults(approach);
		Map<Class<? extends IValidator>, Vector> errorMap = approachResult.getValidationErrors();
		Set<Class<? extends IValidator>> valis = approachResult.getResult()[0].getValidators();
		Vector respTimeError = null;
		for (Class<? extends IValidator> vali : valis) {
			if (vali.getName().equals("tools.descartes.librede.validation.ResponseTimeValidator")) {
				respTimeError = errorMap.get(vali);
			}
		}

		if (respTimeError != null) {
			double errorSum = 0.0;
			for (int i = 0; i < respTimeError.columns(); i++) {
				errorSum += respTimeError.get(i);
			}
			return errorSum / respTimeError.columns();
		}

		log.warn("The response time error for Approach " + approach.toString() + " was not found.");
		return Double.MAX_VALUE;
	}

	/**
	 * Calculates the mean utilization error for the given
	 * {@link LibredeResults}.
	 * 
	 * @param result
	 *            The result produced by LibReDE
	 * @param approach
	 *            The approach to validate
	 * 
	 * @return The mean utilization error
	 */
	public static double getUtilizationError(LibredeResults result, Class<? extends IEstimationApproach> approach) {
		ApproachResult approachResult = result.getApproachResults(approach);
		Map<Class<? extends IValidator>, Vector> errorMap = approachResult.getValidationErrors();
		Set<Class<? extends IValidator>> valis = approachResult.getResult()[0].getValidators();
		Vector utilError = null;
		for (Class<? extends IValidator> vali : valis) {
			if (vali.getName().equals("tools.descartes.librede.validation.UtilizationValidator")) {
				utilError = errorMap.get(vali);
			}
		}

		if (utilError != null) {
			double errorSum = 0.0;
			for (int i = 0; i < utilError.columns(); i++) {
				errorSum += utilError.get(i);
			}
			return errorSum / utilError.columns();
		}

		log.warn("The utilization error for Approach " + approach.toString() + " was not found.");
		return Double.MAX_VALUE;
	}

	/**
	 * Returns a readable String representation for the given parameter
	 * 
	 * @param param
	 *            The {@link IOptimizableParameter} to parse
	 * @return A String description of the paramter.
	 */
	public static String getParameterString(IOptimizableParameter param) {
		if (param instanceof GenericParameter) {
			return ((GenericParameter) param).getParameter().getName();
		}
		return param.toString();
	}

	/**
	 * Loads the given path as a {@link OptimizationConfiguration}
	 * configuration, if one is found.
	 * 
	 * @param path
	 *            The Path to the configuration file
	 * @return The specified {@link OptimizationConfiguration}
	 * @throws Exception
	 *             If something in the loading process fails
	 */
	public static OptimizationConfiguration loadOptimizationConfiguration(Path path) {
		ResourceSet resourceSet = Registry.INSTANCE.createResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("optimization",
				new XMIResourceFactoryImpl());
		File configFile = new File(path.toString());
		URI fileURI = URI.createFileURI(configFile.getAbsolutePath());
		org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(fileURI, true);
		EcoreUtil.resolveAll(resource);
		return (OptimizationConfiguration) resource.getContents().get(0);
	}

	/**
	 * Loads the given path as a {@link RecommendationTrainingConfiguration}
	 * configuration, if one is found.
	 * 
	 * @param path
	 *            The Path to the configuration file
	 * @return The specified {@link RecommendationTrainingConfiguration}
	 * @throws Exception
	 *             If something in the loading process fails
	 */
	public static RecommendationTrainingConfiguration loadRecommendationConfiguration(Path path) {
		ResourceSet resourceSet = Registry.INSTANCE.createResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("optimization",
				new XMIResourceFactoryImpl());
		File configFile = new File(path.toString());
		URI fileURI = URI.createFileURI(configFile.getAbsolutePath());
		org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(fileURI, true);
		EcoreUtil.resolveAll(resource);
		return (RecommendationTrainingConfiguration) resource.getContents().get(0);
	}

	/**
	 * Converts an array of {@link Double}s into an array of primitives.
	 * 
	 * @param list
	 *            The {@link Double} array
	 * @return The double[]
	 */
	public static double[] convertListDouble(Double[] array) {
		double[] result = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i].doubleValue();
		}
		return result;
	}

	/**
	 * Converts an array of {@link Double}s into an array of primitives.
	 * 
	 * @param list
	 *            The {@link Double} array
	 * @return The int[]
	 */
	public static int[] convertListInt(Double[] array) {
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i].intValue();
		}
		return result;
	}

	/**
	 * Returns the short name for a given approach.
	 * 
	 * @param approach
	 *            The {@link EstimationApproachConfiguration} describing the
	 *            approach.
	 * @return The short name.
	 */
	public static String getSimpleApproachName(EstimationApproachConfiguration approach) {
		String[] algorithmsplit = approach.getType().split("\\.");
		return algorithmsplit[algorithmsplit.length - 1];
	}

	private static final HashMap<String, String> acronyms;
	static {
		acronyms = new HashMap<String, String>();
		acronyms.put("ServiceDemandLawApproach", "SDL");
		acronyms.put("ResponseTimeRegressionApproach", "RR");
		acronyms.put("UtilizationRegressionApproach", "UR");
		acronyms.put("ResponseTimeApproximationApproach", "RTA");
		acronyms.put("WangKalmanFilterApproach", "WKF");
		acronyms.put("KumarKalmanFilterApproach", "KKF");
		acronyms.put("MenasceOptimizationApproach", "MO");
		acronyms.put("LiuOptimizationApproach", "LO");
	}

	/**
	 * Returns the acronym for the given approach.
	 * 
	 * @param approach
	 *            The approach name.
	 * @return The acronym for the approach or the input string, if no acronym
	 *         was found.
	 */
	public static String shortenApproachName(String approach) {
		if (acronyms.get(approach) != null) {
			return acronyms.get(approach);
		}
		return approach;
	}

}
