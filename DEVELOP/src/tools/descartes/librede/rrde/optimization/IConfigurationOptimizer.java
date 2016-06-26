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

import java.util.InputMismatchException;

import org.eclipse.emf.common.util.EList;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationSettings;

/**
 * Basic interface for algorithms optimizing LibReDE configuration files.
 * 
 * @author JS
 *
 */
public interface IConfigurationOptimizer {

	/**
	 * Tries to change the given {@link EstimationSpecification} in order to
	 * optimize the quality and the runtime of the activated algorithms in a
	 * corresponding {@link LibredeConfiguration}. Different parameters can be
	 * changed through {@link OptimizationSettings} and an instance of the
	 * interface {@link IConfigurationOptimizationAlgorithmSpecifier}.
	 * 
	 * @param estimation
	 *            The {@link EstimationSpecification} to be optimized
	 * @param input
	 *            An {@link EList} of {@link InputData} specifying the training
	 *            data
	 * @param settings
	 *            An instance of {@link OptimizationSettings} to specify general
	 *            setting for the algorithm, like the parameters to optimize or
	 *            the validation to be used
	 * @param specifier
	 *            An instance implementing
	 *            {@link IConfigurationOptimizationAlgorithmSpecifier} defining
	 *            specific parameters of the concretely used algorithm.
	 * 
	 * @return True, if the executed finished successfully, false if the
	 *         execution was interrupted or otherwise not finish as planned.
	 * @throws IllegalArgumentException
	 *             If the instance of
	 *             {@link IConfigurationOptimizationAlgorithmSpecifier} is not
	 *             supported by the implementing type as returned by
	 *             {@link #isSpecifierSupported(IConfigurationOptimizationAlgorithmSpecifier)}
	 */
	public boolean optimizeConfiguration(EstimationSpecification estimation,
			EList<InputData> input, OptimizationSettings settings,
			IConfigurationOptimizationAlgorithmSpecifier specifier)
			throws IllegalArgumentException;

	/**
	 * Returns the result of the optimization. The call of this method is
	 * optional, since the {@link EstimationSpecification} in
	 * {@link #optimizeConfiguration(EstimationSpecification, EList, OptimizationSettings, IConfigurationOptimizationAlgorithmSpecifier)}
	 * should be optimized via call-by-reference and therefore already be the
	 * required result. Throws an {@link IllegalStateException} if the result is
	 * not yet final.
	 * 
	 * @return The resulting specification after optimization
	 * 
	 * @throws IllegalStateException
	 *             If the computation is still ongoing and no result is
	 *             available
	 */
	public EstimationSpecification getResult() throws IllegalStateException;

	/**
	 * Returns the name of the algorithm.
	 * 
	 * @return The short name.
	 */
	public String getSimpleName();

	/**
	 * Checks if the given instance of an
	 * {@link IConfigurationOptimizationAlgorithmSpecifier} is supported by the
	 * implementing type, i.e. if the contained settings can be interpreted by
	 * the underlying algorithm.
	 * 
	 * @param specifier
	 *            An instance of
	 *            {@link IConfigurationOptimizationAlgorithmSpecifier}
	 * @return True, if the implementing type supports the instance, false
	 *         otherwise.
	 */
	public boolean isSpecifierSupported(
			IConfigurationOptimizationAlgorithmSpecifier specifier);
}
