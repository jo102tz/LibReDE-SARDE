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
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedSet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import tools.descartes.librede.data.harvester.io.input.DataStream;
import tools.descartes.librede.data.harvester.io.input.Folder;
import tools.descartes.librede.data.harvester.io.output.LogOutputStream;
import tools.descartes.librede.data.harvester.io.output.OutputPrinter;
import tools.descartes.librede.data.harvester.io.output.SystemInfo;
import tools.descartes.librede.data.harvester.objects.Cluster;
import tools.descartes.librede.data.harvester.objects.Machine;
import tools.descartes.librede.data.harvester.objects.Task;
import tools.descartes.librede.data.harvester.objects.TaskStatus;
import tools.descartes.librede.data.harvester.objects.WorkloadClass;
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

	public static final boolean IGNORE_UPDATED_MACHINES = true;

	public static final boolean USE_DISK_UTIL = false;

	private static String PATH = "C:/googledata/clusterdata-2011-2/";

	static Logger log = Logger.getLogger("tools.descartes.librede.data.harvester.Main");

	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);

		OutputStreamWriter logwriter = new OutputStreamWriter(new LogOutputStream(log, Level.INFO));
		OutputPrinter printer = new OutputPrinter();

		long start = System.currentTimeMillis();
		// Parsing machines
		Cluster cluster = new Cluster();
		MachineParser mparser = new MachineParser(cluster);
		parseFolder(mparser, "machine_events", "Machine Events", false);
		log.info("Parsing Machines complete!");
		log.info("-----------------------");
		try {
			printer.printClusterStatistics(logwriter, cluster);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		log.info("-----------------------");

		// Parsing tasks
		TaskEventsParser eventparser = new TaskEventsParser(cluster);
		parseFolder(eventparser, "task_events", "Task Events", false);
		eventparser.organizeWorkloadClasses(cluster);
		log.info("Parsing Task Events complete!");
		log.info("-----------------------");
		try {
			printer.printTaskStatistics(logwriter, cluster);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		log.info("-----------------------");

		// Parsing task usages
		TaskUsageParser tparser = new TaskUsageParser(cluster);
		parseFolder(tparser, "task_usage", "Task Usage", true);
		log.info("Parsing Task Usages complete!");

		log.info("Parsing complete!");
		long end = System.currentTimeMillis();
		log.info("Parsing took: " + (end - start) / 1000 + " s.");

		log.info("-----------------------");
		try {
			printer.printUtilStatistics(logwriter, cluster, tparser.getEarliestStart(), tparser.getLatestEnd());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		log.info("-----------------------");
		try {
			printer.printSystemInfo(logwriter);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		log.info("Now exporting:");

		try {
			printer.printTaskStatistics(logwriter, cluster);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			printer.printClusterToFiles(new File(PATH + File.separator + "csvs"), cluster, tparser,
					(end - start) / 1000);
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.info("Export finished.");
		log.info("Done!");
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

}
