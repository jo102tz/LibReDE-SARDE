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

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import tools.descartes.librede.data.harvester.objects.Machine;
import tools.descartes.librede.data.harvester.objects.TaskUsage;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class TestUtilTimeLine {

	@Before
	public void init() {
		BasicConfigurator.configure();
	}

	@Test
	public void test() {
		ArrayList<TaskUsage> list = new ArrayList<TaskUsage>();
		list.add(new TaskUsage(0l, 0l, 10l, 0.2f, 0.2f, 0.3f));
		list.add(new TaskUsage(0l, 1l, 11l, 0.2f, 0.2f, 0.3f));
		list.add(new TaskUsage(0l, 15l, 16l, 0.9f, 0.2f, 0.3f));
		list.add(new TaskUsage(0l, 16l, 20l, 0.9f, 0.2f, 0.3f));
		list.add(new TaskUsage(0l, 20l, 25l, 0.2f, 0.2f, 0.3f));
		list.add(new TaskUsage(0l, 20l, 25l, 0.2f, 0.2f, 0.3f));
		list.add(new TaskUsage(0l, 25l, 30l, 0.2f, 0.2f, 0.3f));

		for (int i = 0; i < 5; i++) {
			// test 5 five times with random order
			Collections.shuffle(list);
			Machine m = new Machine(0);
			for (TaskUsage taskUsage : list) {
				m.addTaskUsage(taskUsage);
			}

			// expected from above tasklist
			SortedSet<Point> expected = new TreeSet<Point>();
			expected.add(new Point(0, 0));
			expected.add(new Point(1, 0.2f));
			expected.add(new Point(10, 0.4f));
			expected.add(new Point(11, 0.2f));
			expected.add(new Point(15, 0));
			expected.add(new Point(16, 0.9f));
			expected.add(new Point(20, 0.9f));
			expected.add(new Point(25, 0.4f));
			expected.add(new Point(30, 0.2f));

			Iterator<Point> expIt = expected.iterator();

			for (Point point : m.getUtilization()) {
				Point expectedP = expIt.next();
				assertEquals(expectedP.getTime(), point.getTime());
				assertEquals(expectedP.getValue(), point.getValue(), 0);
			}

			if (expIt.hasNext())
				fail("Iterator has left elements.");
		}

	}

}
