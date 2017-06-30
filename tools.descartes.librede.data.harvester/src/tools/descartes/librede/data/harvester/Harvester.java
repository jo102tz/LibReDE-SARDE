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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import tools.descartes.librede.data.harvester.io.DataStream;
import tools.descartes.librede.data.harvester.io.Folder;
import tools.descartes.librede.data.harvester.objects.Cluster;
import tools.descartes.librede.data.harvester.objects.Machine;
import tools.descartes.librede.data.harvester.objects.Task;
import tools.descartes.librede.data.harvester.objects.utilization.Point;
import tools.descartes.librede.data.harvester.parser.MachineParser;
import tools.descartes.librede.data.harvester.parser.Parser;
import tools.descartes.librede.data.harvester.parser.TaskEventsParser;
import tools.descartes.librede.data.harvester.parser.TaskUsageParser;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class Harvester {

	public static final boolean IGNORE_UPDATED_MACHINES = false;

	public static final boolean USE_DISK_UTIL = false;

	private static String PATH = "D:/googledata/clusterdata-2011-2/";

	static Logger log = Logger.getLogger("tools.descartes.librede.data.harvester.Main");

	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);

		long start = System.currentTimeMillis();
		// Parsing machines
		Cluster cluster = new Cluster();
		MachineParser mparser = new MachineParser(cluster);
		parseFolder(mparser, "machine_events", "Machine Events", false);
		log.info("Parsing Machines complete!");
		log.info("-----------------------");
		printClusterStatistics(cluster);
		log.info("-----------------------");

		// Parsing tasks
		TaskEventsParser eventparser = new TaskEventsParser(cluster);
		parseFolder(eventparser, "task_events", "Task Events", false);
		cluster.organizeWorkloadClasses();
		log.info("Parsing Task Events complete!");
		log.info("-----------------------");
		printTaskStatistics(cluster);
		log.info("-----------------------");

		// Parsing task usages
		TaskUsageParser tparser = new TaskUsageParser(cluster);
		parseFolder(tparser, "task_usage", "Task Usage", true);
		log.info("Parsing Task Usages complete!");

		log.info("Parsing complete!");
		long end = System.currentTimeMillis();
		log.info("Parsing took: " + (end - start) / 1000 + " s.");

		log.info("-----------------------");
		printUtilStatistics(cluster, tparser.getEarliestStart(), tparser.getLatestEnd());
		log.info("-----------------------");
		printSystemInfo();
		log.info("Now exporting:");
		for (Machine m : cluster.getMachines().values()) {
			// if (m.isWasupdated() == false) {
			printUtilOfMachineToFile(m);
			// }
		}
		log.info("Export finished.");
		log.info("Done!");
	}

	/**
	 * @param cluster
	 */
	private static void printTaskStatistics(Cluster cluster) {
		log.info("Task Statistics:");
		log.info("Number of Machines in the cluster:" + cluster.getMachines().entrySet().size());
		long totaltasknr = 0;
		long excluded = 0;
		long taskswithouttimes = 0;
		long length = 0;
		for (Entry<Long, Machine> m : cluster.getMachines().entrySet()) {
			totaltasknr += m.getValue().getTasks().size();
			for (Task t : m.getValue().getTasks().values()) {
				if (t.isWasExcluded())
					excluded++;
				if (t.getEndtime() > 0 && t.getStarttime() > 0)
					length += (t.getEndtime() - t.getStarttime()) / 1000;
				else
					taskswithouttimes++;
			}
		}
		log.info("Total number of tasks: " + totaltasknr);
		log.info("Number of excluded tasks: " + excluded);
		log.info("Percentage of non-excluded tasks: " + (excluded * 100.0) / totaltasknr);
		log.info("Average number of different tasks per machine (incl. excluded): "
				+ totaltasknr / ((double) cluster.getMachines().entrySet().size()));
		log.info("Total number of tasks without correct times: " + taskswithouttimes);
		log.info("Average length of not excluded tasks: " + length / ((double) totaltasknr - taskswithouttimes) + "s");
	}

	/**
	 * @param m
	 */
	private static void printUtilOfMachineToFile(Machine m) {
		File f = new File(PATH + "csvs" + File.separatorChar + m.getId() + ".csv");
		try {
			f.createNewFile();
		} catch (IOException e) {
			log.warn("IOExcpetion occurred.", e);
		}
		try {
			BufferedWriter o = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
			printToFile(o, m.getUtilization(), ",");
			o.close();
		} catch (IOException e) {
			log.warn("IOExcpetion occurred.", e);
		}
	}

	/**
	 * @param o
	 * @param utilization
	 * @throws IOException
	 */
	private static void printToFile(BufferedWriter o, List<Point> utilization, String separator) throws IOException {
		for (Point point : utilization) {
			o.write(point.getTime() + separator + point.getValue());
			o.newLine();
		}
	}

	/**
	 * @param cluster
	 * @param earliestStart
	 * @param latestEnd
	 */
	private static void printUtilStatistics(Cluster cluster, long earliestStart, long latestEnd) {
		log.info("The earliest start is " + earliestStart + ".");
		log.info("The latest end is " + latestEnd + ".");
		long seconds = (latestEnd - earliestStart) / 1000;
		log.info("Measurement Period: " + seconds + " s or " + new SimpleDateFormat("HH:mm:ss").format(seconds));
		Machine testmachine;
		java.util.Iterator<Machine> it = cluster.getMachines().values().iterator();
		do {
			testmachine = it.next();
		} while (testmachine.isWasupdated());
		log.info("Printing Machine: " + testmachine.getId());

		List<Point> list = testmachine.getUtilization();
		for (Point point : list) {
			log.info(point.getTime() + "; " + point.getValue());
		}
	}

	private static void parseFolder(Parser parser, String filename, String name, boolean reversed) {
		Folder folder = new Folder(new File(PATH + filename), name, reversed);
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
		for (Entry<Long, Machine> m : cl.getMachines().entrySet()) {
			if (m.getValue().isWasupdated())
				updated++;
		}
		double noNonUpdatedMachines = noMachines - updated;
		log.info("Number of updated machines: " + updated);
		log.info("Percentage of non-updated machines: " + (noNonUpdatedMachines * 100) / noMachines);
	}

}
