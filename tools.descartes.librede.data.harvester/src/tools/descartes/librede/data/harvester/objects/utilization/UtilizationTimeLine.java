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
package tools.descartes.librede.data.harvester.objects.utilization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import tools.descartes.librede.data.harvester.objects.TaskUsage;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class UtilizationTimeLine {

	private SortedSet<Point> graph = new TreeSet<Point>();

	static Logger log = Logger.getLogger(tools.descartes.librede.data.harvester.objects.utilization.UtilizationTimeLine.class);

	public UtilizationTimeLine(List<TaskUsage> tasks) {
		graph.add(new Point(0, 0));
		graph.add(new Point(Long.MAX_VALUE, 0));
		graph.add(new Point(Long.MAX_VALUE - 1, 0));
		for (TaskUsage t : tasks)
			addTask(t);
//		graph.remove(graph.first());
//		graph.remove(graph.last());
//		graph.remove(graph.last());
	}

	/**
	 * @return the graph
	 */
	public SortedSet<Point> getGraph() {
		return graph;
	}

	private void addTask(TaskUsage task) {
		ArrayList<Point> toAdd = new ArrayList<Point>(2);
		Iterator<Point> it = graph.iterator();
		Point p = it.next();
		while (p.getTime() < task.getStarttime()) {
			p = it.next();
		}
		// found first point which is influenced by task
		if (p.getTime() != task.getStarttime()) {
			// create new point, if new point in time is necessary
			p = new Point(task.getStarttime(), p.getValue());
			toAdd.add(p);
		}
		// increase all points until end with given meancpu
		Point lastpoint = null;
		while (p.getTime() <= task.getEndtime()) {
			p.setValue(p.getValue() + task.getMeanCPU());
			lastpoint = p;
			p = it.next();
		}
		if (lastpoint.getTime() != task.getEndtime()) {
			// create new point, if endpoint is not a known point yet
			p = new Point(task.getEndtime(), p.getValue());
			toAdd.add(p);
		}

		// add both created points
		graph.addAll(toAdd);
	}

}
