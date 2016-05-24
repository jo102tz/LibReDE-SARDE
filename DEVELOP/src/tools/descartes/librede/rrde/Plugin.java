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

import javax.security.auth.login.Configuration;

import org.apache.log4j.Logger;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.bayesplusplus.BayesLibrary;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.ipopt.java.IpoptLibrary;
import tools.descartes.librede.nnls.NNLSLibrary;
import tools.descartes.librede.rrde.configuration.implementations.MasterConfigurationOptimizer;
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
//			Librede.printSummary(Wrapper.executeLibrede(configuration));
		} catch (Exception e) {
			log.error("Error occurred", e);
		}
		log.info("DONE.");
		return null;
	}

	@Override
	public void stop() {

	}

	private void runConfigurationOptimization(LibredeConfiguration configuration) {
		ConfigurationOptimizationSettings settings = new ConfigurationOptimizationSettingsBuilder()
				.setTimeOut(10000).build();
		new MasterConfigurationOptimizer().optimizeConfiguration(configuration, settings);
	}
	
	public void initLogging(){
		Librede.initLogging();
	}

}
