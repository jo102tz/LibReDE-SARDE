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
package tools.descartes.librede.rrde;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.EstimationApproachConfiguration;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.configuration.implementations.MasterConfigurationOptimizer;
import tools.descartes.librede.rrde.configuration.implementations.SeparateStepSizeOptimizer;
import tools.descartes.librede.rrde.configuration.settings.ConfigurationOptimizationSettings;
import tools.descartes.librede.rrde.configuration.settings.ConfigurationOptimizationSettingsBuilder;

/**
 * The main class of this Plug-In.
 * 
 * @author JS
 *
 */
public class Plugin implements IApplication {

	private static final Logger log = Logger.getLogger(Plugin.class);

	public final static String PATH = "resources/estimation.librede";

	@Override
	public Object start(IApplicationContext context) throws Exception {
		initLogging();
		Wrapper.init();
		try {
			LibredeConfiguration configuration = Librede
					.loadConfiguration(new File(PATH).toPath());
			runConfigurationOptimization(configuration);
			// Librede.printSummary(Wrapper.executeLibrede(configuration));
		} catch (Exception e) {
			log.error("Error occurred", e);
		}
		log.info("DONE.");
		return null;
	}

	@Override
	public void stop() {

	}

	@SuppressWarnings("unchecked")
	private void runConfigurationOptimization(LibredeConfiguration configuration) {
		ConfigurationOptimizationSettings settings = new ConfigurationOptimizationSettingsBuilder()
				.setTimeOut(10000).build();
		// copy configuration and optimize approaches separately in order to be
		// able to configure parameters like step size and window size
		// independently of each other
		for (EstimationApproachConfiguration approach : configuration
				.getEstimation().getApproaches()) {
			LibredeConfiguration conf = Librede
					.loadConfiguration(new File(PATH).toPath());
			Class<? extends IEstimationApproach> approachclass = null;
			try {
				approachclass = (Class<? extends IEstimationApproach>) Class
						.forName(approach.getType());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			// remove all and add only the current approach
			ArrayList<EstimationApproachConfiguration> lastConf = new ArrayList<EstimationApproachConfiguration>();
			for (EstimationApproachConfiguration a : conf.getEstimation()
					.getApproaches()) {
				if (!a.getType().equals(approach.getType())) {
					lastConf.add(a);
				}
			}
			// delete all other approaches
			conf.getEstimation().getApproaches().removeAll(lastConf);
			new SeparateStepSizeOptimizer(approachclass).optimizeConfiguration(
					conf, settings);
			conf.getEstimation().getApproaches().addAll(lastConf);
			log.error("Found stepsize of "
					+ conf.getEstimation().getStepSize().getValue()
					+ " for approach " + approachclass.getCanonicalName());
		}
	}

	public void initLogging() {
		Librede.initLogging();
		LogManager.getRootLogger().setLevel(Level.ERROR);
	}

}
