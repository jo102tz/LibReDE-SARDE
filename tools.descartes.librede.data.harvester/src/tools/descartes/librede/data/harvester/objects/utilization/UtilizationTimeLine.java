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

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import tools.descartes.librede.data.harvester.objects.TaskUsage;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class UtilizationTimeLine {

	private Point start;

	static Logger log = Logger
			.getLogger(tools.descartes.librede.data.harvester.objects.utilization.UtilizationTimeLine.class);

	public UtilizationTimeLine(List<TaskUsage> tasks) {
		// temporary helper points
		start = new Point(-1, 0);
		Point end = new Point(Long.MAX_VALUE, 0);
		start.setPost(end);
		end.setPre(start);

		for (TaskUsage t : tasks)
			addTask(t);

		// delete start points
		start.getPost().setPre(null);
		start = start.getPost();
		end.getPre().setPost(null);

	}

	/**
	 * @return the start
	 */
	public Point getStart() {
		return start;
	}

	private void addTask(TaskUsage task) {
		LinkedList<Point> affectedPoints = new LinkedList<Point>();
		Point cur = start;
		// ignore all Points before
		while (cur.getPost() != null && cur.getTime() <= task.getStarttime()) {
			cur = cur.getPost();
		}
		Point lastPointbefore = cur.getPre();
		// add all affected points
		while (cur.getPost() != null && cur.getTime() <= task.getEndtime()) {
			affectedPoints.addLast(cur);
			cur = cur.getPost();
		}
		Point firstPointafter = cur;
		// add point at endpoint if not already there
		if (firstPointafter.getPre().getTime() != task.getEndtime()) {
			Point p = new Point(task.getEndtime(), firstPointafter.getValue());
			addPointBetween(p, firstPointafter.getPre(), firstPointafter);
			affectedPoints.add(p);
		}
		if (lastPointbefore.getTime() != task.getStarttime()) {
			Point p = new Point(task.getStarttime(), lastPointbefore.getPost().getValue());
			addPointBetween(p, lastPointbefore, lastPointbefore.getPost());
		}
		// affected points is not sorted!!
		// increase all affected points
		for (Point point : affectedPoints) {
			point.setValue(point.getValue() + task.getMeanCPU());
		}

	}

	private void addPointBetween(Point p, Point pre, Point post) {
		p.setPost(post);
		p.setPre(pre);
		p.getPre().setPost(p);
		post.setPre(p);
	}

}
