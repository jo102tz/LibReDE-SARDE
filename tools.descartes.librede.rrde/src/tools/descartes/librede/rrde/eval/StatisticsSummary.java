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
package tools.descartes.librede.rrde.eval;

import java.util.HashMap;
import java.util.Map;

import tools.descartes.librede.rrde.model.optimization.IOptimizableParameter;

/**
 * Objects of this class hold statistical information about a
 * optimization/recommendation run.
 * 
 * @author Johannes
 *
 */
public class StatisticsSummary {

	/**
	 * Standard constructor.
	 */
	public StatisticsSummary() {
		parameters = new HashMap<>();
	}

	/**
	 * The average execution time before optimization/recommendation.
	 */
	private double avgTimeBefore;
	/**
	 * The standard deviation of the execution time before
	 * optimization/recommendation.
	 */
	private double stdDevTimeBefore;
	/**
	 * The average execution time after optimization/recommendation.
	 */
	private double avgTimeAfter;
	/**
	 * The standard deviation of the execution time after
	 * optimization/recommendation.
	 */
	private double stdDevTimeAfter;

	/**
	 * The average estimation error before optimization/recommendation.
	 */
	private double avgErrorBefore;
	/**
	 * The standard deviation of the estimation error before
	 * optimization/recommendation.
	 */
	private double stdDevErrorBefore;
	/**
	 * The average estimation error after optimization/recommendation.
	 */
	private double avgErrorAfter;
	/**
	 * The standard deviation of the estimation error after
	 * optimization/recommendation.
	 */
	private double stdDevErrorAfter;

	/**
	 * The hitrate of the recommendation algorithm.
	 */
	private double hitrate;

	/**
	 * The time spent for recommendation.
	 */
	private long recommendationtime;
	/**
	 * The time spent for optimization.
	 */
	private long optimizationtime;

	/**
	 * The number of test cases ignored before optimization/recommendation.
	 */
	private int beforeignored;
	/**
	 * The number of test cases ignored after optimization/recommendation.
	 */
	private int afterignored;

	/**
	 * This map contains all optimized parameters and their corresponding value.
	 */
	private Map<IOptimizableParameter, Double> parameters;

	/**
	 * @return the avgTimeBefore
	 */
	public double getAvgTimeBefore() {
		return avgTimeBefore;
	}

	/**
	 * @param avgTimeBefore
	 *            the avgTimeBefore to set
	 */
	public void setAvgTimeBefore(double avgTimeBefore) {
		this.avgTimeBefore = avgTimeBefore;
	}

	/**
	 * @return the stdDevTimeBefore
	 */
	public double getStdDevTimeBefore() {
		return stdDevTimeBefore;
	}

	/**
	 * @param stdDevTimeBefore
	 *            the stdDevTimeBefore to set
	 */
	public void setStdDevTimeBefore(double stdDevTimeBefore) {
		this.stdDevTimeBefore = stdDevTimeBefore;
	}

	/**
	 * @return the avgTimeAfter
	 */
	public double getAvgTimeAfter() {
		return avgTimeAfter;
	}

	/**
	 * @param avgTimeAfter
	 *            the avgTimeAfter to set
	 */
	public void setAvgTimeAfter(double avgTimeAfter) {
		this.avgTimeAfter = avgTimeAfter;
	}

	/**
	 * @return the stdDevTimeAfter
	 */
	public double getStdDevTimeAfter() {
		return stdDevTimeAfter;
	}

	/**
	 * @param stdDevTimeAfter
	 *            the stdDevTimeAfter to set
	 */
	public void setStdDevTimeAfter(double stdDevTimeAfter) {
		this.stdDevTimeAfter = stdDevTimeAfter;
	}

	/**
	 * @return the avgErrorBefore
	 */
	public double getAvgErrorBefore() {
		return avgErrorBefore;
	}

	/**
	 * @param avgErrorBefore
	 *            the avgErrorBefore to set
	 */
	public void setAvgErrorBefore(double avgErrorBefore) {
		this.avgErrorBefore = avgErrorBefore;
	}

	/**
	 * @return the stdDevErrorBefore
	 */
	public double getStdDevErrorBefore() {
		return stdDevErrorBefore;
	}

	/**
	 * @param stdDevErrorBefore
	 *            the stdDevErrorBefore to set
	 */
	public void setStdDevErrorBefore(double stdDevErrorBefore) {
		this.stdDevErrorBefore = stdDevErrorBefore;
	}

	/**
	 * @return the avgErrorAfter
	 */
	public double getAvgErrorAfter() {
		return avgErrorAfter;
	}

	/**
	 * @param avgErrorAfter
	 *            the avgErrorAfter to set
	 */
	public void setAvgErrorAfter(double avgErrorAfter) {
		this.avgErrorAfter = avgErrorAfter;
	}

	/**
	 * @return the stdDevErrorAfter
	 */
	public double getStdDevErrorAfter() {
		return stdDevErrorAfter;
	}

	/**
	 * @param stdDevErrorAfter
	 *            the stdDevErrorAfter to set
	 */
	public void setStdDevErrorAfter(double stdDevErrorAfter) {
		this.stdDevErrorAfter = stdDevErrorAfter;
	}

	/**
	 * @return the hitrate
	 */
	public double getHitrate() {
		return hitrate;
	}

	/**
	 * @param hitrate
	 *            the hitrate to set
	 */
	public void setHitrate(double hitrate) {
		this.hitrate = hitrate;
	}

	/**
	 * @return the recommendationtime
	 */
	public long getRecommendationtime() {
		return recommendationtime;
	}

	/**
	 * @param recommendationtime
	 *            the recommendationtime to set
	 */
	public void setRecommendationtime(long recommendationtime) {
		this.recommendationtime = recommendationtime;
	}

	/**
	 * @return the optimizationtime
	 */
	public long getOptimizationtime() {
		return optimizationtime;
	}

	/**
	 * @param optimizationtime
	 *            the optimizationtime to set
	 */
	public void setOptimizationtime(long optimizationtime) {
		this.optimizationtime = optimizationtime;
	}

	/**
	 * @return the beforeignored
	 */
	public int getBeforeignored() {
		return beforeignored;
	}

	/**
	 * @param beforeignored
	 *            the beforeignored to set
	 */
	public void setBeforeignored(int beforeignored) {
		this.beforeignored = beforeignored;
	}

	/**
	 * @return the afterignored
	 */
	public int getAfterignored() {
		return afterignored;
	}

	/**
	 * @param afterignored
	 *            the afterignored to set
	 */
	public void setAfterignored(int afterignored) {
		this.afterignored = afterignored;
	}

	/**
	 * @return the parameters
	 */
	public Map<IOptimizableParameter, Double> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(Map<IOptimizableParameter, Double> parameters) {
		this.parameters = parameters;
	}

}
