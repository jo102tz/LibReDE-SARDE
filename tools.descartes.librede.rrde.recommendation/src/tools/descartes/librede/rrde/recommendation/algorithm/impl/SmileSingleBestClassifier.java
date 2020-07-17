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
package tools.descartes.librede.rrde.recommendation.algorithm.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import tools.descartes.librede.rrde.model.recommendation.RecommendationAlgorithmSpecifier;

/**
 * A recommender predicting the estimator that was the most used during
 * training. Used for comparison mainly.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class SmileSingleBestClassifier extends AbstractSmileAlgorithm {

	/**
	 * The logger used for logging.
	 */
	private static final Logger log = Logger.getLogger(SmileSingleBestClassifier.class);

	@Override
	public boolean isSpecifierSupported(RecommendationAlgorithmSpecifier specifier) {
		// any specifier is fine
		return true;
	}

	@Override
	protected boolean train(double[][] features, int[] targets) {
		// counting the approach that occurs most often
		List<Integer> list = new ArrayList<Integer>();
		for( int k: targets ) {
			list.add(k);
		}
		int max = 0;
		int curr = 0;
		Integer currKey = null;
		Set<Integer> unique = new HashSet<Integer>(list);

		for (Integer key : unique) {
			curr = Collections.frequency(list, key);

			if (max < curr) {
				max = curr;
				currKey = key;
			}
		}
		
		// The number currKey  happens the most times (max)
		setClassifier(new DummyClasifier(currKey));
		return true;
	}

	@Override
	protected Logger getLog() {
		return log;
	}

}
