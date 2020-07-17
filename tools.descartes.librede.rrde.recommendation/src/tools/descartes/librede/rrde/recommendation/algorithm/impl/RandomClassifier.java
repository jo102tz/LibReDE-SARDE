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

import java.util.Random;

import smile.classification.Classifier;

/**
 * A dummy classifier returning a random variable.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class RandomClassifier implements Classifier<double[]> {

	private int max;
	
	private Random r;

	/**
	 * Initializes this classifier.
	 * 
	 * @param seed The seed for the random engine.
	 * @param maxIndex The index up to which random numbers are chosen.
	 */
	public RandomClassifier(int seed, int maxIndex) {
		super();
		this.max = maxIndex;
		this.r = new Random(seed);
		System.out.println(maxIndex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smile.classification.Classifier#predict(java.lang.Object)
	 */
	@Override
	public int predict(double[] arg0) {
		return r.nextInt(this.max);
	}
}
