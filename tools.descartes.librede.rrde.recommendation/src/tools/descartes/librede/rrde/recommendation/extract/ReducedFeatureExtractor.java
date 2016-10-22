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
package tools.descartes.librede.rrde.recommendation.extract;

import org.apache.log4j.Logger;

import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;

/**
 * This class reduces the features extracted into the {@link FeatureVector}s.
 * 
 * @author JS
 *
 */
public class ReducedFeatureExtractor extends BasicFeatureExtractor {

	/**
	 * The logger used for logging.
	 */
	private static final Logger log = Logger
			.getLogger(ReducedFeatureExtractor.class);

	@Override
	protected Logger getLog() {
		return log;
	}

	@Override
	protected void computeIsNormaldistributed(StatisticalFeatures vector,
			double mean, double standardDeviation, double[] values) {
		// empty
	}

	/**
	 * Standard constructor setting basic values for all constants.
	 */
	public ReducedFeatureExtractor(FeatureExtractorSpecifier specifier) {
		super(specifier);
	}

	@Override
	protected void extractCorrelationAndCovarianceInformation(
			FeatureVector vector, LibredeVariables var) {
		// empty
	}

	@Override
	protected void computeAutocorrelation(StatisticalFeatures vector,
			double[] values) {
		// empty

	}

	@Override
	protected void extractRegressionAnalyzisInformation(FeatureVector vector,
			LibredeVariables var) {
		// empty
	}
}
