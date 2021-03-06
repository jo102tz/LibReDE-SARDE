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
package tools.descartes.librede.rrde.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.configuration.ConfigurationFactory;
import tools.descartes.librede.configuration.DataSourceConfiguration;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.FileTraceConfiguration;
import tools.descartes.librede.configuration.InputSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.Parameter;
import tools.descartes.librede.configuration.Resource;
import tools.descartes.librede.configuration.Service;
import tools.descartes.librede.configuration.TraceConfiguration;
import tools.descartes.librede.configuration.TraceToEntityMapping;
import tools.descartes.librede.configuration.ValidationSpecification;
import tools.descartes.librede.configuration.WorkloadDescription;
import tools.descartes.librede.datasource.IDataSource;
import tools.descartes.librede.datasource.csv.CsvDataSource;
import tools.descartes.librede.datasource.csv.CsvDataSourceOffline;
import tools.descartes.librede.registry.Instantiator;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.Unit;
import tools.descartes.librede.units.UnitsFactory;

/**
 * This helper class enables the configuration of different
 * {@link LibredeConfiguration} files based on a root directory as defined in
 * {@link InputData}. This class needs a total restructuring and overhaul
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class Discovery {

	private static final Logger log = Logger.getLogger(Discovery.class);

	/**
	 * This method creates a Map assigning a set of imput specifications to each
	 * workload descriptions containted by a set of {@link InputData}.
	 * 
	 * @param input A List of {@link InputData}, containing information about the
	 *              folders to be searched in
	 * @return A Map assigning {@link InputSpecification}s to
	 *         {@link WorkloadDescription}s
	 */
	public static Map<WorkloadDescription, Set<InputSpecification>> discoverInputs(EList<InputData> input) {
		HashMap<WorkloadDescription, Set<InputSpecification>> map = new HashMap<WorkloadDescription, Set<InputSpecification>>();
		for (InputData data : input) {
			map.put(data.getWorkloadDescription(), discoverOne(data));
		}
		return map;
	}

	/**
	 * Discovers and creates {@link LibredeConfiguration} files based on the given
	 * skeleton data and the {@link InputData} specifications. Based on the set of
	 * {@link InputData} specifications, different workload specifications might be
	 * contained.
	 * 
	 * 
	 * @param input      A list of several {@link InputData}s specifying the root
	 *                   folders to start the discovery and the
	 *                   {@link WorkloadDescription} as well as the
	 *                   {@link InputSpecification} to look for
	 * @param estimation The {@link EstimationSpecification} the new configurations
	 *                   should contain
	 * @param validator  The {@link ValidationSpecification} the new configurations
	 *                   should contain
	 * @return A set of found valid {@link LibredeConfiguration}s
	 */
	public static Set<LibredeConfiguration> createConfigurations(EList<InputData> input,
			EstimationSpecification estimation, ValidationSpecification validator) {
		Set<LibredeConfiguration> set = new HashSet<LibredeConfiguration>();

		// change important settings of base file
		LibredeConfiguration conf = createConfigFile(estimation, validator);

		// explore inputs and create as many configurations
		Map<WorkloadDescription, Set<InputSpecification>> map = discoverInputs(input);
		for (Entry<WorkloadDescription, Set<InputSpecification>> entry : map.entrySet()) {

			ArrayList<Resource> reslist = new ArrayList<Resource>();
			reslist.addAll(entry.getKey().getResources());

			ArrayList<Service> serlist = new ArrayList<Service>();
			serlist.addAll(entry.getKey().getServices());

			for (InputSpecification spec : entry.getValue()) {
				// for each inputSpecification create own LibredeFile
				LibredeConfiguration additional = EcoreUtil.copy(conf);

				// do not copy references
				additional.setWorkloadDescription(EcoreUtil.copy(entry.getKey()));

				additional.setInput(EcoreUtil.copy(spec));

				// edit output folder
				// additional
				// .getOutput()
				// .getExporters()
				// .get(0)
				// .getParameters()
				// .get(0)
				// .setValue(
				// new File(((FileTraceConfiguration) spec
				// .getObservations().get(0)).getFile())
				// .getParent());

				// adapt time stamps
				// fix mapping references
				if (fixTimeStamps(additional, null) && fixMapping(additional)) {
					set.add(additional);
				} else {
					log.warn("No valid configuration could be created.");
				}
			}
		}
		validateConfs(set);
		return set;
	}

	/**
	 * Validate all configurations and deletes the ones that do not suffice.
	 */
	private static void validateConfs(Set<LibredeConfiguration> confs) {
		HashSet<LibredeConfiguration> remove = new HashSet<LibredeConfiguration>();
		for (LibredeConfiguration single : confs) {
			if (single.getWorkloadDescription() == null || single.getEstimation() == null || single.getInput() == null
					|| single.getOutput() == null || single.getValidation() == null) {
				log.warn("Malformed Configuration. (Null-values) Ignoring " + single.toString() + ".");

			} else if (single.getWorkloadDescription().getResources().isEmpty()
					|| single.getWorkloadDescription().getServices().isEmpty()) {
				log.warn("Malformed Configuration. Resources or Services are empty. Ignoring " + single.toString()
						+ ".");
				remove.add(single);
			}
		}
		confs.removeAll(remove);
		deleteMultipleWorkloadConfs(confs);
		if (confs.isEmpty()) {
			log.error("There are no valid configurations as training data.");
		}
	}

	/**
	 * Checks the collection for identical configurations just varying in workload
	 * descriptions and just keeps the one with the biggest description. (Resources
	 * first, after that WCs)
	 * 
	 * @param confs The set to check
	 */
	private static void deleteMultipleWorkloadConfs(Set<LibredeConfiguration> confs) {
		HashSet<LibredeConfiguration> remove = new HashSet<>();
		// repeat until no conflicts are detected anymore
		do {
			confs.removeAll(remove);
			remove.clear();
			for (LibredeConfiguration original : confs) {
				if (!remove.isEmpty()) {
					break;
				}
				File parent = new File(
						((FileTraceConfiguration) original.getInput().getObservations().get(0)).getFile())
								.getParentFile();
				for (LibredeConfiguration second : confs) {
					if (!second.equals(original)) {
						File next = new File(
								((FileTraceConfiguration) second.getInput().getObservations().get(0)).getFile())
										.getParentFile();
						if (next.equals(parent)) {
							int orgResources = original.getWorkloadDescription().getResources().size();
							int orgServices = original.getWorkloadDescription().getServices().size();
							int secResources = second.getWorkloadDescription().getResources().size();
							int secServices = second.getWorkloadDescription().getServices().size();
							// the two configurations have the same parent
							// check first for resources, then for WCs
							if (orgResources == secResources) {
								if (orgServices == secServices) {
									// both have the same description -> delete
									// one
									log.info("Duplicate Configurations: " + original + " and " + second + ". Deleting "
											+ second);
									remove.add(second);
								} else if (orgServices > secServices) {
									// original has more WCs
									log.debug("Duplicate Configurations: " + original + " and " + second + " with "
											+ original + " having more WCs. Deleting " + second);
									remove.add(second);
								} else {
									log.debug("Duplicate Configurations: " + original + " and " + second + " with "
											+ second + " having more WCs. Deleting " + original);
									remove.add(original);
								}
							} else if (orgResources > secResources) {
								log.debug("Duplicate Configurations: " + original + " and " + second + " with "
										+ original + " having more resources. Deleting " + second);
								remove.add(second);

							} else {
								log.debug("Duplicate Configurations: " + original + " and " + second + " with " + second
										+ " having more resources. Deleting " + original);
								remove.add(original);
							}
							break;
						}
					}
				}
			}
		} while (!remove.isEmpty());
	}

	/**
	 * Fixes the mappings between traces and files for a given configuration.
	 * 
	 * @param additional The {@link LibredeConfiguration} to fix.
	 * @return true, if the operation was successful, false otherwise
	 */
	private static boolean fixMapping(LibredeConfiguration additional) {
		for (TraceConfiguration trace : additional.getInput().getObservations()) {
			for (TraceToEntityMapping mapping : trace.getMappings()) {
				for (Resource res : additional.getWorkloadDescription().getResources()) {
					if (mapping.getEntity().getName().equals(res.getName())) {
						mapping.setEntity(res);
					}
				}
				for (Service ser : additional.getWorkloadDescription().getServices()) {
					if (mapping.getEntity().getName().equals(ser.getName())) {
						mapping.setEntity(ser);
					}
				}
			}
		}
		return true;
	}

	/**
	 * Explores one {@link InputData} starting on the specified root folder.
	 * 
	 * @param input The specification for the discovery
	 * @return All {@link InputSpecification}s found
	 */
	private static Set<InputSpecification> discoverOne(InputData input) {
		HashSet<InputSpecification> set = new HashSet<InputSpecification>();
		File folder = new File(input.getRootFolder());
		if (!folder.exists()) {
			log.warn(folder.toString() + " could not be found.");
			return set;
		}
		if (!folder.isDirectory()) {
			log.warn(folder.toString() + " is not a directory.");
			return set;
		}
		iterateDirectories(folder.toPath(), input.getInput(), set, input.isMultiFolderStructures());
		return set;
	}

	/**
	 * Creates a {@link LibredeConfiguration} file with the given skeleton values.
	 * 
	 * @param estimation The {@link EstimationSpecification} the new configuration
	 *                   should contain
	 * @param validator  The {@link ValidationSpecification} the new configuration
	 *                   should contain
	 * @return An new {@link LibredeConfiguration}
	 */
	private static LibredeConfiguration createConfigFile(EstimationSpecification estimation,
			ValidationSpecification validator) {
		LibredeConfiguration copy = ConfigurationFactory.eINSTANCE.createLibredeConfiguration();

		// set values to the one of the runcall
		copy.setEstimation(EcoreUtil.copy(estimation));
		copy.setValidation(EcoreUtil.copy(validator));

		// set other fields to empty values
		copy.setInput(ConfigurationFactory.eINSTANCE.createInputSpecification());
		copy.setWorkloadDescription(ConfigurationFactory.eINSTANCE.createWorkloadDescription());

		// configure output
		copy.setOutput(ConfigurationFactory.eINSTANCE.createOutputSpecification());
		// copy.getOutput()
		// .getExporters()
		// .add(ConfigurationFactory.eINSTANCE
		// .createExporterConfiguration());
		// copy.getOutput().getExporters().get(0).setName("Default");
		// copy.getOutput().getExporters().get(0).setType("tools.descartes.librede.export.csv.CsvExporter");
		// copy.getOutput().getExporters().get(0).getParameters().add(ConfigurationFactory.eINSTANCE.createParameter());
		// copy.getOutput().getExporters().get(0).getParameters().add(ConfigurationFactory.eINSTANCE.createParameter());
		// copy.getOutput().getExporters().get(0).getParameters().get(0).setName("OutputDirectory");
		// copy.getOutput().getExporters().get(0).getParameters().get(1).setName("FileName");
		// copy.getOutput().getExporters().get(0).getParameters().get(1).setValue("estimates");

		// set these to false, since they are not required for optimization
		copy.getEstimation().setAutomaticApproachSelection(false);
		copy.getEstimation().setRecursive(false);

		return copy;
	}

	/**
	 * Iterate over all (sub)-directories of the given folder and search for valid
	 * {@link InputSpecification} using the
	 * {@link #checkThisFolder(Path, InputSpecification, Set)} method.
	 * 
	 * @param root The root directory to start from
	 * @param main The main {@link InputSpecification} to copy from
	 * @param set  The set to add the new {@link InputSpecification}
	 */
	private static void iterateDirectories(Path root, InputSpecification main, Set<InputSpecification> set,
			boolean multiFolderStructures) {
		if (root.toFile().isDirectory()) {
			DirectoryStream<Path> stream = null;
			try {
				stream = Files.newDirectoryStream(root);
			} catch (IOException e) {
				log.error("IOError occurred.", e);
			}
			Iterator<Path> iter = stream.iterator();
			// call recursively
			while (iter.hasNext()) {
				iterateDirectories(iter.next(), main, set, multiFolderStructures);
			}
			checkThisFolder(root, main, set, multiFolderStructures);
		} else if (!root.toFile().exists()) {
			// stop
			return;
		} else {
			// root is normal file
			// ignore, this case is handled elsewhere
			return;
		}
	}

	/**
	 * Checks if the specific folder contains a valid input
	 * {@link InputSpecification} and adds a copy of the given main specification to
	 * the given set if so.
	 * 
	 * @param root The folder to check
	 * @param main The main {@link InputSpecification} to copy from
	 * @param set  The set to add the new {@link InputSpecification}
	 */
	private static void checkThisFolder(Path root, InputSpecification main, Set<InputSpecification> set,
			boolean multiFolderStructures) {

		// first collect all possible paths and subpaths of this folder
		// this behaviour is quite inefficient (especially since all directories
		// are iterated anyway) and could be optimized
		Set<Path> allSubpaths = new HashSet<Path>();
		LinkedList<Path> toIterate = new LinkedList<Path>();
		toIterate.add(root);
		while (!toIterate.isEmpty()) {
			Path current = toIterate.remove();
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(current)) {
				Iterator<Path> iter = stream.iterator();
				while (iter.hasNext()) {
					Path filepath = iter.next();
					// add to list of paths
					allSubpaths.add(filepath);
					if (Files.isDirectory(filepath)) {
						// if this is a directory add to the list
						toIterate.addLast(filepath);
					}
				}
			} catch (IOException e) {
				log.error("IOError occurred.", e);
			}
		}

		// now check for every observation if there is one path matching it
		InputSpecification copy = EcoreUtil.copy(main);
		for (TraceConfiguration trace : copy.getObservations()) {
			boolean found = false;
			// try to find a file with the given name
			for (Path p : allSubpaths) {
				if (p.endsWith(new File(((FileTraceConfiguration) trace).getFile()).getName())) {
					// the filepath contains the file ending
					// -> set the file
					((FileTraceConfiguration) trace).setFile(p.toAbsolutePath().toString());
					found = true;
				}
			}
			if (!found) {
				// if no match was found for this observation -> abort
				log.debug("No valid configuration files found in " + root + " folder.");
				return;
			}
		}
		// if we reach here, all traces have been set
		if (!multiFolderStructures) {

			// if multi-folder strucutres are not allowed
			// we have to make sure all files are in the same folder
			Path folder = new File(((FileTraceConfiguration) copy.getObservations().get(0)).getFile()).toPath()
					.getParent();
			for (TraceConfiguration trace : copy.getObservations()) {
				FileTraceConfiguration filetrace = (FileTraceConfiguration) trace;
				Path parentpath = new File(filetrace.getFile()).toPath().getParent();
				if (parentpath != null && !parentpath.equals(folder)) {
					// this one is not in the same parent as the first one
					log.debug("Configuration of " + root
							+ " was excluded, because not all files were in the same folder.");
					return;
				}
			}
		}

		// if we reach here, no problems occurred and we are done
		set.add(copy);
		log.info("Found valid configuration in " + root + " folder.");
	}

	/**
	 * Fixes the time stamps of the given {@link LibredeConfiguration} to match the
	 * first and last available measurement.
	 * 
	 * @param conf the {@link LibredeConfiguration} to fix
	 * @param conf the end timestamp to set, if the trace should not be parsed from
	 *             front to end, but just from front to the end timestamp. (Might be
	 *             useful in offline/replay-scenarios.) If this feature is not
	 *             required, passing <code>null</code> will ignore the value.
	 * @return True, if the operation was successful, false otherwise
	 */
	public static boolean fixTimeStamps(LibredeConfiguration conf, Quantity<Time> endTimestamp) {
		Map<String, IDataSource> dataSources = new HashMap<String, IDataSource>();

		Quantity<Time> maxStart = UnitsFactory.eINSTANCE.createQuantity();
		maxStart.setUnit(Time.MILLISECONDS);
		maxStart.setValue(0);
		Quantity<Time> minEnd = UnitsFactory.eINSTANCE.createQuantity();
		minEnd.setUnit(Time.MILLISECONDS);
		minEnd.setValue(Double.POSITIVE_INFINITY);

		for (TraceConfiguration trace : conf.getInput().getObservations()) {
			if (trace instanceof FileTraceConfiguration) {
				FileTraceConfiguration fileTrace = (FileTraceConfiguration) trace;
				File inputFile = new File(fileTrace.getFile());
				if (inputFile.exists()) {
					DataSourceConfiguration dataSourceConf = fileTrace.getDataSource();
					if (dataSourceConf != null) {
						IDataSource ds = dataSources.get(dataSourceConf.getType());

						if (ds == null) {
							try {
								Class<?> cl = Registry.INSTANCE.getInstanceClass(dataSourceConf.getType());
								ds = (IDataSource) Instantiator.newInstance(cl, dataSourceConf.getParameters());
								dataSources.put(dataSourceConf.getType(), ds);
							} catch (Exception e) {
								e.printStackTrace();
								return false;
							}
						}

						// retrieve all important parameters
						if (ds instanceof CsvDataSource || ds instanceof CsvDataSourceOffline) {

							if (fileTrace.getMappings().size() >= 1) {
								try {
									// assume that the timestamp is always in
									// column 0, this should be changed?

									Quantity<Time> currStart = UnitsFactory.eINSTANCE.createQuantity();
									currStart.setUnit(parseTimeUnit(fileTrace.getDataSource()));
									currStart.setValue(
											loadFirst(inputFile, 0, getSeparators(fileTrace.getDataSource())));
									if (currStart.compareTo(maxStart) > 0) {
										// curr Start is bigger than maxStart ->
										// new maxStart
										maxStart = currStart;
									}

									Quantity<Time> currEnd = UnitsFactory.eINSTANCE.createQuantity();
									currEnd.setUnit(parseTimeUnit(fileTrace.getDataSource()));
									currEnd.setValue(loadLast(inputFile, 0, getSeparators(fileTrace.getDataSource())));
									if (currEnd.compareTo(minEnd) < 0) {
										// curr End is smaller than min End ->
										// new min End
										minEnd = currEnd;
									}

								} catch (Exception e) {
									log.error("Error occurred", e);
								}
							}
						} else {
							log.error("Other Datasources than csv are not supported yet...");
						}
					}
				}
			}
		}

		if (maxStart.compareTo(minEnd) > 0) {
			log.error("The time spans of the traces do not overlap.");
			return false;
		}

		conf.getEstimation().setStartTimestamp(maxStart);
		conf.getEstimation().setEndTimestamp(minEnd);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.trace("Startpoint of config " + conf.toString() + " set to "
				+ date.format(maxStart.getValue(Time.MILLISECONDS)));

		if (endTimestamp != null) {
			conf.getEstimation().setEndTimestamp(EcoreUtil.copy(endTimestamp));
			log.trace("Endpoint of config " + conf.toString() + " set to " + date
					.format(endTimestamp.getValue(Time.MILLISECONDS) + " as this was the pre-defined end-timestamp."));
		} else {
			log.trace("Endpoint of config " + conf.toString() + " set to "
					+ date.format(minEnd.getValue(Time.MILLISECONDS)));
		}
		return true;
	}

	/**
	 * Tries to recover the used separators from the given
	 * {@link DataSourceConfiguration}.
	 * 
	 * @param datasource The datasource to read
	 * @return The separator strings
	 */
	private static String getSeparators(DataSourceConfiguration dataSource) {
		for (Parameter p : dataSource.getParameters()) {
			if (p.getName().equals("Separators")) {
				return p.getValue();
			}
		}
		// default
		return ",";
	}

	/**
	 * Tries to recover the used {@link Time} from the given
	 * {@link DataSourceConfiguration}.
	 * 
	 * @param datasource The datasource to read
	 * @return The {@link Time} unit found
	 */
	@SuppressWarnings("unchecked")
	private static Unit<Time> parseTimeUnit(DataSourceConfiguration datasource) {
		String simpleDateFormat = null;
		for (Parameter p : datasource.getParameters()) {
			if (p.getName().equals("TimestampFormat")) {
				simpleDateFormat = p.getValue();
			}
		}

		if (simpleDateFormat == null) {
			// default
			return Time.MILLISECONDS;
		}

		// default
		Unit<Time> dateUnit = Time.MILLISECONDS;
		if (simpleDateFormat != null && !simpleDateFormat.isEmpty()) {
			if (simpleDateFormat.startsWith("[") && simpleDateFormat.endsWith("]")) {
				String unit = simpleDateFormat.substring(1, simpleDateFormat.length() - 1);
				for (Unit<?> u : Time.INSTANCE.getUnits()) {
					if (u.getSymbol().equalsIgnoreCase(unit)) {
						dateUnit = (Unit<Time>) u;
						break;
					}
				}
			} else {
				// default
				dateUnit = Time.MILLISECONDS;
			}
		}
		return dateUnit;
	}

	/**
	 * Helper method to find the last time stamp in the file.
	 * 
	 * @param inputFile The file to search through
	 * @param col       The column to search through in the file
	 * @param separator The separator between the columns
	 * @return the last time stamp found as a double
	 */
	private static double loadLast(File inputFile, int col, String separator) {
		double stamp = -1;
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

			String lastLine = null;
			String line = br.readLine();
			while (line != null) {
				lastLine = line;
				line = br.readLine();
			}

			try {
				if (lastLine != null && !lastLine.isEmpty()) {
					String[] split = lastLine.split(separator);
					stamp = Double.parseDouble(split[col]);
				}
			} catch (NumberFormatException e) {
				// line was probably an empty file with just an header
			}

		} catch (IOException e) {
			log.error("IOError occurred.", e);
		}
		if (stamp == -1) {
			log.warn("No readable Timestamp found.");
		}
		return stamp;
	}

	/**
	 * Helper method to find the first time stamp in the file.
	 * 
	 * @param inputFile The file to search through
	 * @param col       The column to search through in the file
	 * @param separator The separator between the columns
	 * @return the first time stamp found as a double
	 */
	private static double loadFirst(File inputFile, int col, String separator) {
		double stamp = -1;
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

			String line = br.readLine();
			try {
				if (line != null && !line.isEmpty()) {
					String[] split = line.split(separator);
					stamp = Double.parseDouble(split[col]);
				}
			} catch (NumberFormatException e) {
				// parse next line since first was obviously header
				line = br.readLine();
				if (line != null && !line.isEmpty()) {
					String[] split = line.split(separator);
					stamp = Double.parseDouble(split[col]);
				}
			}
		} catch (IOException e) {
			log.error("IOError occurred.", e);
		}
		if (stamp == -1) {
			log.warn("No readable Timestamp found.");
		}
		return stamp;
	}
}