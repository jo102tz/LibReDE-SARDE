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
package tools.descartes.librede.data.harvester.io.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedSet;

import org.apache.log4j.Logger;

import tools.descartes.librede.data.harvester.Harvester;
import tools.descartes.librede.data.harvester.objects.Cluster;
import tools.descartes.librede.data.harvester.objects.Machine;
import tools.descartes.librede.data.harvester.objects.Task;
import tools.descartes.librede.data.harvester.objects.TaskStatus;
import tools.descartes.librede.data.harvester.objects.WorkloadClass;
import tools.descartes.librede.data.harvester.objects.utilization.Point;
import tools.descartes.librede.data.harvester.parser.TaskUsageParser;

/**
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class OutputPrinter {

	Logger log = Logger.getLogger(this.getClass());

	public static final String SEPARATOR = ",";

	public void printClusterToFiles(File root, Cluster cluster, TaskUsageParser tparser, long parsingTime)
			throws IOException {
		if (!root.exists()) {
			root.mkdirs();
		}
		printSummaryFile(root, cluster, tparser, parsingTime);
		for (Machine m : cluster.getMachines().values()) {
			if (!(Harvester.IGNORE_UPDATED_MACHINES && m.isWasupdated())) {
				File f = new File(root.getAbsolutePath() + File.separator + m.getId());
				printMachine(f, m);
			}
		}

	}

	/**
	 * @param root
	 * @param cluster
	 * @throws IOException
	 */
	private void printSummaryFile(File root, Cluster cluster, TaskUsageParser tparser, long parsingTime)
			throws IOException {
		File newfile = new File(root.getAbsolutePath() + File.separatorChar + "summary.txt");
		newfile.createNewFile();
		OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(newfile));
		printClusterStatistics(o, cluster);
		o.write("-----------------------\n");
		printTaskStatistics(o, cluster);
		o.write("-----------------------\n");
		printUtilStatistics(o, cluster, tparser.getEarliestStart(), tparser.getLatestEnd());
		o.write("-----------------------\n");
		printSystemInfo(o);
		o.write("-----------------------\n");
		o.write("Parsing the cluster took " + parsingTime + " seconds.\n");
		o.flush();
		o.close();
	}

	/**
	 * @param f
	 * @param cluster
	 * @throws IOException
	 */
	private void printMachine(File f, Machine m) throws IOException {
		if (!f.exists()) {
			f.mkdirs();
		}
		printUtilOfMachineToFile(f, m);
		for (Entry<WorkloadClass, SortedSet<Task>> list : m.getTasks().entrySet())
			printWCs(f, list);
	}

	/**
	 * @param m
	 * @throws IOException
	 */
	private void printUtilOfMachineToFile(File f, Machine m) throws IOException {
		File newfile = new File(f.getAbsolutePath() + File.separatorChar + "utilization.csv");
		newfile.createNewFile();
		BufferedWriter o = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile)));
		print(o, m.getUtilization());
		o.close();
	}

	/**
	 * @param o
	 * @param utilization
	 * @throws IOException
	 */
	public void print(BufferedWriter o, List<Point> utilization) throws IOException {
		for (Point point : utilization) {
			o.write(point.getTime() + SEPARATOR + point.getValue());
			o.write("\n");
		}
	}

	/**
	 * @param f
	 * @param m
	 * @throws IOException
	 */
	private void printWCs(File f, Entry<WorkloadClass, SortedSet<Task>> list) throws IOException {
		File newfile = new File(f.getAbsolutePath() + File.separatorChar + "WC" + list.getKey().getId() + ".csv");
		newfile.createNewFile();
		OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(newfile));
		printTasks(o, list.getValue());
		o.close();
	}

	/**
	 * @param o
	 * @param value
	 * @param separator
	 * @throws IOException
	 */
	public void printTasks(OutputStreamWriter o, SortedSet<Task> tasks) throws IOException {
		for (Task task : tasks) {
			if (task.getStatus() == TaskStatus.SUCCESSFUL || task.getStatus() == TaskStatus.SPLIT
					|| task.getStatus() == TaskStatus.SUCCESSFULLY_SPLITTED) {
				if (task.getEndtime() == 0) {
					log.warn("No endtime detected...");
				} else if (!task.isWasExcluded()) {
					o.write(task.getStarttime() + SEPARATOR + (task.getEndtime() - task.getStarttime()));
					o.write("\n");
				}
			}
		}
	}

	/**
	 * @param cluster
	 * @throws IOException
	 */
	public void printTaskStatistics(OutputStreamWriter o, Cluster cluster) throws IOException {
		o.write("Task Statistics:");
		o.write("Number of Machines in the cluster:" + cluster.getMachines().entrySet().size() + "\n");
		long totaltasknr = 0;
		long excluded = 0;
		long taskswithouttimes = 0;
		long length = 0;
		for (Entry<Long, Machine> m : cluster.getMachines().entrySet()) {
			totaltasknr += m.getValue().getTasks().size();
			for (Collection<Task> list : m.getValue().getTasks().values()) {
				for (Task t : list) {
					if (t.isWasExcluded())
						excluded++;
					if (t.getEndtime() > 0 && t.getStarttime() > 0)
						length += ((t.getEndtime() - t.getStarttime()) / 1000);
					else
						taskswithouttimes++;
				}
			}
		}
		o.write("Total number of tasks: " + totaltasknr + "\n");
		o.write("Number of excluded tasks: " + excluded + "\n");
		o.write("Percentage of non-excluded tasks: " + (excluded * 100.0) / totaltasknr + "\n");
		o.write("Average number of different tasks per machine (incl. excluded): "
				+ totaltasknr / ((double) cluster.getMachines().entrySet().size()) + "\n");
		o.write("Total number of tasks without correct times: " + taskswithouttimes + "\n");
		o.write("Average length of not excluded tasks: " + length / ((double) totaltasknr - taskswithouttimes) + "s\n");
		o.write("Total number of different workload classes " + cluster.getNumberOfWCs() + "\n");
		o.flush();
	}

	/**
	 * @param cluster
	 * @param earliestStart
	 * @param latestEnd
	 * @throws IOException
	 */
	public void printUtilStatistics(OutputStreamWriter o, Cluster cluster, long earliestStart, long latestEnd)
			throws IOException {
		o.write("The earliest start is " + earliestStart + ".\n");
		o.write("The latest end is " + latestEnd + ".\n");
		long seconds = (latestEnd - earliestStart) / 1000;
		o.write("Measurement Period: " + seconds + " s or " + new SimpleDateFormat("HH:mm:ss").format(seconds) + "\n");
		// Machine testmachine;
		// java.util.Iterator<Machine> it =
		// cluster.getMachines().values().iterator();
		// do {
		// testmachine = it.next();
		// } while (testmachine.isWasupdated());
		// log.info("Printing Machine: " + testmachine.getId());
		//
		// List<Point> list = testmachine.getUtilization();
		// for (Point point : list) {
		// log.info(point.getTime() + "; " + point.getValue());
		// }
		o.flush();
	}

	/**
	 * @throws IOException
	 * 
	 */
	public void printSystemInfo(OutputStreamWriter o) throws IOException {
		o.write("System Statistics:\n");
		o.write(new SystemInfo().info());
		o.flush();
	}

	public void printClusterStatistics(OutputStreamWriter o, Cluster cl) throws IOException {
		o.write("Cluster Statistics:\n");
		double noMachines = cl.getMachines().size();
		o.write("Number of Machines in the cluster:" + noMachines + "\n");
		int updated = 0;
		for (Entry<Long, Machine> m : cl.getMachines().entrySet()) {
			if (m.getValue().isWasupdated())
				updated++;
		}
		double noNonUpdatedMachines = noMachines - updated;
		o.write("Number of updated machines: " + updated + "\n");
		o.write("Percentage of non-updated machines: " + (noNonUpdatedMachines * 100) / noMachines + "\n");
		o.flush();
	}

}
