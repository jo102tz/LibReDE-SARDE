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
package tools.descartes.librede.rrde.util.extract;

import org.apache.log4j.Logger;

import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.ModelEntity;
import tools.descartes.librede.metrics.Aggregation;
import tools.descartes.librede.metrics.Metric;
import tools.descartes.librede.repository.IRepositoryCursor;
import tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.model.recommendation.FeatureVector;
import tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.model.recommendation.impl.StatisticalFeaturesImpl;
import tools.descartes.librede.units.Dimension;
import tools.descartes.librede.units.Unit;

/**
 * This class only provides minimal functionality for extracting
 * {@link FeatureVector}s.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class MinimalFeatureExtractor extends ReducedFeatureExtractor {

	/**
	 * The logger used for logging.
	 */
	private static final Logger log = Logger
			.getLogger(MinimalFeatureExtractor.class);

	@Override
	protected Logger getLog() {
		return log;
	}

	/**
	 * Standard constructor setting basic values for all constants.
	 */
	public MinimalFeatureExtractor(FeatureExtractorSpecifier specifier) {
		super(specifier);
	}

	@Override
	protected <D extends Dimension> StatisticalFeatures extractStatisticalFeatureVector(
			IRepositoryCursor cursor, ModelEntity entity, Metric<D> metric,
			Unit<D> unit, Aggregation aggregation) {
		// empty
		StatisticalFeatures vector = new StatisticalFeaturesImpl();

		return vector;
	}
	
	@Override
	protected void extractWorkloadDescription(FeatureVector vector,
			LibredeVariables var) {
		// empty
	}

}
