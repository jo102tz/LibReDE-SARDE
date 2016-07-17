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
package tools.descartes.librede.rrde;

import java.util.Map;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.EstimationAlgorithmConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.Parameter;
import tools.descartes.librede.linalg.Matrix;
import tools.descartes.librede.rrde.optimization.GenericParameter;
import tools.descartes.librede.rrde.optimization.IOptimizableParameter;
import tools.descartes.librede.rrde.optimization.StepSize;
import tools.descartes.librede.rrde.optimization.WindowSize;

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
	public static void setValue(EstimationSpecification librede, double value,
			IOptimizableParameter param) {
		String eClass = param.getClass().getInterfaces()[0].getName();
		if (eClass.equals(StepSize.class.getName())) {
			librede.getStepSize().setValue(value);
			log.trace("Set Stepsize to " + value);
		} else if (eClass.equals(WindowSize.class.getName())) {
			int integer = (int) Math.round(value);
			if (integer != value) {
				log.warn("The value "
						+ value
						+ " is not an Integer and had to be rounded to fit as window size.");
			}
			librede.setWindow(integer);
			log.trace("Set Windowsize to " + integer);
		} else if (eClass.equals(GenericParameter.class.getName())) {
			setGenericParameter(librede, (GenericParameter) param,
					Double.toString(value));
		} else {
			log.error("No handling adapter of setting Optimizable Parameter "
					+ eClass);
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
	public static void setGenericParameter(EstimationSpecification librede,
			GenericParameter param, String value) {
		for (EstimationAlgorithmConfiguration alg : librede.getAlgorithms()) {
			boolean set = false;
			for (Parameter par : alg.getParameters()) {
				if (par.getName().equals(param.getKey())) {
					// TODO 
					par.setValue(value);
					set = true;
				}
			}
			if(alg.getParameters()==null){
				for(Object obj : alg.eContents()){
					System.out.println(obj);
				}
			}
			if (set != true) {
				log.warn("The Algorithm specification " + alg.getType()
						+ " does not support a parameter with key "
						+ param.getKey() + ". Ignoring requested change to "
						+ value + ".");
			}
		}
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
	public static String getGenericParameter(EstimationSpecification librede,
			GenericParameter param) {
		for (EstimationAlgorithmConfiguration alg : librede.getAlgorithms()) {
			for (Parameter par : alg.getParameters()) {
				if (par.getName().equals(param.getKey())) {
					return par.getValue();
				}
			}
			log.warn("The Algorithm specification " + alg.getType()
					+ " does not support a parameter with key "
					+ param.getKey() + ".");
		}
		log.warn("No key " + param.getKey() + "found.");
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
	public static double getValue(EstimationSpecification librede,
			IOptimizableParameter param) {
		String eClass = param.getClass().getInterfaces()[0].getName();
		if (eClass.equals(StepSize.class.getName())) {
			return librede.getStepSize().getValue();
		} else if (eClass.equals(WindowSize.class.getName())) {
			return librede.getWindow();
		} else if (eClass.equals(GenericParameter.class.getName())) {
			try {
				return Double.parseDouble(getGenericParameter(librede,
						(GenericParameter) param));
			} catch (NumberFormatException e) {
				log.error("The generic parameter with key "
						+ ((GenericParameter) param).getKey()
						+ " has value "
						+ getGenericParameter(librede, (GenericParameter) param)
						+ " which is not numeric.");
				return -1;
			} catch (NullPointerException e) {
				log.warn("The generic parameter with key "
						+ ((GenericParameter) param).getKey()
						+ " has a null value. Returning 0 instead.");
				return 0;
			}
		} else {
			log.error("No handling adapter of setting Optimizable Parameter "
					+ eClass);
		}
		return -1;
	}

	/**
	 * Calculates the mean Validation error, i.e. the target function value.
	 * 
	 * @param result
	 *            The result produced by LibReDE
	 * @return The mean validation error
	 */
	public static double getMeanValidationError(LibredeResults result) {
		// equally averaging over all validators and all approaches
		DescriptiveStatistics values = new DescriptiveStatistics();
		Map<Class<? extends IEstimationApproach>, Matrix> errorMap = result
				.getValidationErrors();
		for (Class<? extends IEstimationApproach> approach : result
				.getApproaches()) {
			Matrix appError = errorMap.get(approach);
			if ((int) appError.columns() != result.getNumberOfFolds()) {
				log.warn("Not enough fold validation results available: "
						+ result.toString());
			}
			if (appError.rows() != result.getValidatedEntities().entrySet()
					.size()) {
				log.warn("Not enough validators for results available: "
						+ result.toString());
			}

			for (int i = 0; i < appError.columns(); i++)
				for (int j = 0; j < appError.rows(); j++)
					values.addValue(appError.get(j, i));

			if (values.getN() < 1) {
				log.warn("No validation results for approach "
						+ result.getApproaches().iterator().next());
				return 0;
			}
		}
		return values.getMean();
	}

}
