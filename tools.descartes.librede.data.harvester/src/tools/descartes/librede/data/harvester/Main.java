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
package tools.descartes.librede.data.harvester;

import java.io.File;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import tools.descartes.librede.data.harvester.io.DataStream;
import tools.descartes.librede.data.harvester.io.Folder;
import tools.descartes.librede.data.harvester.objects.Cluster;
import tools.descartes.librede.data.harvester.objects.Machine;
import tools.descartes.librede.data.harvester.objects.TaskUsage;
import tools.descartes.librede.data.harvester.objects.utilization.Point;
import tools.descartes.librede.data.harvester.objects.utilization.UtilizationTimeLine;
import tools.descartes.librede.data.harvester.parser.MachineParser;
import tools.descartes.librede.data.harvester.parser.Parser;
import tools.descartes.librede.data.harvester.parser.TasksParser;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class Main {

	private static String PATH = "D:/googledata/clusterdata-2011-2/";

	private static final long INTERVALSIZE = 300000;

	static Logger log = Logger.getLogger("tools.descartes.librede.data.harvester.Main");

	public static void main(String[] args) {

		BasicConfigurator.configure();

		long start = System.currentTimeMillis();
		// Parsing machines
		Cluster cluster = new Cluster();
		MachineParser mparser = new MachineParser(cluster);
		parseFolder(mparser, "machine_events", "Machine Events");
		log.info("Parsing Machines complete!");

		// Parsing tasks
		TasksParser tparser = new TasksParser(cluster);
		parseFolder(tparser, "task_usage", "Task Usage");
		log.info("Parsing Tasks complete!");

		log.info("Parsing complete!");
		long end = System.currentTimeMillis();
		log.info("Parsing took: " + (end - start) / 1000 + " s.");
		log.info("-----------------------");
		printClusterStatistics(cluster);
		log.info("-----------------------");
		printUtilStatistics(cluster, tparser.getEarliestStart(), tparser.getLatestEnd());
		log.info("-----------------------");
		printSystemInfo();

	}

	/**
	 * @param cluster
	 * @param earliestStart
	 * @param latestEnd
	 */
	private static void printUtilStatistics(Cluster cluster, long earliestStart, long latestEnd) {
		log.info("The earliest start is " + earliestStart + ".");
		log.info("The latest end is " + latestEnd + ".");
		Machine testmachine;
		java.util.Iterator<Machine> it = cluster.getMachines().values().iterator();
		do {
			testmachine = it.next();
		} while (testmachine.isWasupdated());
		log.info("Printing Machine: " + testmachine.getId());
		UtilizationTimeLine tl = new UtilizationTimeLine(testmachine.getTasks());
		Point cur = tl.getStart();
		while (cur != null) {
			log.info(cur.getTime() + "; " + cur.getValue());
			cur = cur.getPost();
		}
	}

	private static void parseFolder(Parser parser, String filename, String name) {
		Folder folder = new Folder(new File(PATH + filename), name);
		DataStream ds = new DataStream(folder);

		String line = ds.getNextLine();
		while (line != null) {
			parser.parseLine(line);
			line = ds.getNextLine();
		}
	}

	/**
	 * 
	 */
	private static void printSystemInfo() {
		log.info("System Statistics:");
		log.info(new SystemInfo().info());
	}

	private static void printClusterStatistics(Cluster cl) {
		log.info("Cluster Statistics:");
		double noMachines = cl.getMachines().size();
		log.info("Number of Machines in the cluster:" + noMachines);
		int updated = 0;
		long totaltasknr = 0;
		for (Entry<Long, Machine> m : cl.getMachines().entrySet()) {
			if (m.getValue().isWasupdated())
				updated++;
			else {
				totaltasknr += m.getValue().getTasks().size();
			}
		}
		double noNonUpdatedMachines = noMachines - updated;
		log.info("Number of updated machines: " + updated);
		log.info("Percentage of non-updated machines: " + (noNonUpdatedMachines * 100) / noMachines);

		log.info("Average number of tasks per machine: " + totaltasknr / noNonUpdatedMachines);
	}

}
