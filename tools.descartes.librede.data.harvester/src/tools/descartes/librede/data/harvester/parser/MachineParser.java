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
package tools.descartes.librede.data.harvester.parser;

import tools.descartes.librede.data.harvester.objects.Cluster;
import tools.descartes.librede.data.harvester.objects.Machine;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class MachineParser extends Parser {

	private Cluster cluster;

	/**
	 * @param cluster
	 */
	public MachineParser(Cluster cluster) {
		super();
		this.cluster = cluster;
	}

	@Override
	public void processLine() {
		String[] split = getSplit();
		long id = Long.parseLong(split[1]);
		int action = Integer.parseInt(split[2]);
		switch (action) {
		case 0:// add
			Machine m = null;
			try {
				m = new Machine(id, Long.parseLong(split[0]), split[3], Float.parseFloat(split[4]),
						Float.parseFloat(split[5]));
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				m = new Machine(id, Long.parseLong(split[0]), split[3], -1, -1);
			}
			cluster.addMachine(m);
			break;
		case 1:// remove
			cluster.removeMachine(id, Long.parseLong(split[0]));
			break;
		case 2:
			cluster.updateMachine(id);
			break;
		}
	}
}
