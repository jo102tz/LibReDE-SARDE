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
package tools.descartes.librede.rrde.optimization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
import tools.descartes.librede.configuration.TraceConfiguration;
import tools.descartes.librede.configuration.ValidationSpecification;
import tools.descartes.librede.configuration.WorkloadDescription;
import tools.descartes.librede.datasource.IDataSource;
import tools.descartes.librede.datasource.csv.CsvDataSource;
import tools.descartes.librede.registry.Instantiator;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;
import tools.descartes.librede.units.Unit;
import tools.descartes.librede.units.UnitsFactory;

/**
 * This helper class enables the configuration of different
 * {@link LibredeConfiguration} files based on a root directory as defined in
 * {@link InputData}.
 * 
 * @author JS
 *
 */
public class Discovery {

	private static final Logger log = Logger.getLogger(Discovery.class);

	
	/**
	 * TODO comments
	 * @param input
	 * @return
	 */
	public static Map<WorkloadDescription, Set<InputSpecification>> discoverInputs(EList<InputData> input) {
		HashMap<WorkloadDescription, Set<InputSpecification>> map = new HashMap<WorkloadDescription, Set<InputSpecification>>();
		for (InputData data : input) {
			map.put(data.getDescription(), discoverOne(data));
		}
		return map;
	}

	public static Set<LibredeConfiguration> createConfigurations(EstimationSpecification estimation,
			EList<InputData> input, ValidationSpecification validator) {
		HashSet<LibredeConfiguration> set = new HashSet<LibredeConfiguration>();

		// change important settings of base file
		LibredeConfiguration conf = createConfigFile(estimation, validator);

		// explore inputs and create as many configurations
		Map<WorkloadDescription, Set<InputSpecification>> map = discoverInputs(input);
		for (Entry<WorkloadDescription, Set<InputSpecification>> entry : map.entrySet()) {
			for (InputSpecification spec : entry.getValue()) {
				// for each inputSpecification create own LibredeFile
				LibredeConfiguration additional = EcoreUtil.copy(conf);
				if(entry.getKey()==null){
					System.out.println("alert");
				}
				additional.setWorkloadDescription(EcoreUtil.copy(entry.getKey()));
				additional.setInput(EcoreUtil.copy(spec));
				// adapt time stamps
				fixTimeStamp(additional);
				set.add(additional);
			}
		}
		return set;
	}

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
		iterateDirectories(folder.toPath(), input.getInputSpecification(), set);
		return set;
	}

	private static LibredeConfiguration createConfigFile(EstimationSpecification estimation,
			ValidationSpecification validator) {
		LibredeConfiguration copy = ConfigurationFactory.eINSTANCE.createLibredeConfiguration();

		// set values to the one of the runcall
		copy.setEstimation(EcoreUtil.copy(estimation));
		copy.setValidation(EcoreUtil.copy(validator));

		// set other fields to empty values
		copy.setInput(ConfigurationFactory.eINSTANCE.createInputSpecification());
		copy.setOutput(ConfigurationFactory.eINSTANCE.createOutputSpecification());
		copy.setWorkloadDescription(ConfigurationFactory.eINSTANCE.createWorkloadDescription());

		// set these to false, since they are not required for optimization
		copy.getEstimation().setAutomaticApproachSelection(false);
		copy.getEstimation().setRecursive(false);

		return copy;
	}

	private static void iterateDirectories(Path root, InputSpecification main, Set<InputSpecification> set) {
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
				iterateDirectories(iter.next(), main, set);
			}
			checkThisFolder(root, main, set);
		} else if (!root.toFile().exists()) {
			// stop
			return;
		} else {
			// root is normal file
			// ignore, this case is handled elsewhere
			return;
		}
	}

	private static void checkThisFolder(Path root, InputSpecification main, Set<InputSpecification> set) {
		DirectoryStream<Path> stream = null;
		try {
			stream = Files.newDirectoryStream(root);
		} catch (IOException e) {
			log.error("IOError occurred.", e);
		}
		Iterator<Path> iter = stream.iterator();
		// Specification is copied for every iteration check, this could maybe
		// be optimized
		InputSpecification copy = EcoreUtil.copy(main);
		while (iter.hasNext()) {
			Path filepath = iter.next();
			for (TraceConfiguration source : copy.getObservations()) {
				if (filepath.toString().contains(((FileTraceConfiguration) source).getFile())) {
					// the filepath contains the file ending
					((FileTraceConfiguration) source).setFile(filepath.toAbsolutePath().toString());
				}
			}
		}
		boolean equal = false;
		// check if all source files have been found and edited,i.e. if the new
		// specification is valid
		for (TraceConfiguration after : copy.getObservations()) {
			for (TraceConfiguration before : main.getObservations()) {
				// if any of the configuration is like the one in the main file
				// -> fail
				if (((FileTraceConfiguration) before).getFile().equals(((FileTraceConfiguration) after).getFile()))
					equal = true;

			}
		}
		// only if no equalities were found
		if (!equal) {
			set.add(copy);
			log.info("Found valid configuration in " + root + " folder.");
		} else {
			log.debug("No valid configuration files found in " + root + " folder.");
		}
	}

	private static void fixTimeStamp(LibredeConfiguration conf) {
		Map<String, IDataSource> dataSources = new HashMap<String, IDataSource>();

		double maxStart = Double.MIN_VALUE;
		double minEnd = Double.MAX_VALUE;

		Unit<Time> unit = Time.MILLISECONDS;

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
								return;
							}
						}

						// retrieve all important parameters
						if (ds instanceof CsvDataSource) {

							unit = parseTimeUnit(fileTrace.getDataSource());
							if (fileTrace.getMappings().size() >= 1) {
								try {
									// assume that the timestamp is always in
									// column
									// 0, this should be changed?
									maxStart = Math.max(
											loadFirst(inputFile, 0, getSeparators(fileTrace.getDataSource())),
											maxStart);
									minEnd = Math.min(loadLast(inputFile, 0, getSeparators(fileTrace.getDataSource())),
											minEnd);
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

		if (maxStart >= minEnd) {
			log.error("The time spans of the traces do not overlap.");
			return;
		}

		Quantity<Time> maxStartpoint = UnitsFactory.eINSTANCE.createQuantity();
		maxStartpoint.setValue(maxStart);
		maxStartpoint.setUnit(unit);
		Quantity<Time> minEndpoint = UnitsFactory.eINSTANCE.createQuantity();
		minEndpoint.setValue(minEnd);
		minEndpoint.setUnit(unit);

		conf.getEstimation().setStartTimestamp(maxStartpoint);
		conf.getEstimation().setEndTimestamp(minEndpoint);

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.debug("Startpoint of config " + conf.toString() + " set to "
				+ date.format(maxStartpoint.getValue(Time.MILLISECONDS)));
		log.debug("Endpoint of config " + conf.toString() + " set to "
				+ date.format(minEndpoint.getValue(Time.MILLISECONDS)));

	}

	private static String getSeparators(DataSourceConfiguration dataSource) {
		for (Parameter p : dataSource.getParameters()) {
			if (p.getName().equals("Separators")) {
				return p.getValue();
			}
		}
		// default
		return ",";
	}

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