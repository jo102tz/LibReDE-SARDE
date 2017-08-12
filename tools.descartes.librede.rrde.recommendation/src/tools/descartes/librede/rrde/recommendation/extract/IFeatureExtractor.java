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

import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.recommendation.FeatureVector;

/**
 * Interface that provides functionality to extract {@link FeatureVector}s for
 * given {@link LibredeConfiguration}s.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public interface IFeatureExtractor {

	/**
	 * Creates a new {@link FeatureVector} containing extracted features about
	 * the given {@link LibredeConfiguration}.
	 * 
	 * @param conf
	 *            The configuration to extract
	 * @return The extracted features.
	 */
	public FeatureVector extractFeatures(LibredeConfiguration conf);
	/**
	 * Creates a new {@link FeatureVector} containing extracted features about
	 * the given {@link LibredeVariables}.
	 * 
	 * @param conf
	 *            The var to extract
	 * @return The extracted features.
	 */
	public FeatureVector extractFeatures(LibredeVariables var);
}
