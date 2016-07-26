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

import java.util.HashMap;

import org.apache.log4j.Logger;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.bayesplusplus.BayesLibrary;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.datasource.IDataSource;
import tools.descartes.librede.ipopt.java.IpoptLibrary;
import tools.descartes.librede.nnls.NNLSLibrary;
import tools.descartes.librede.repository.IRepositoryCursor;

/**
 * This class provides some interface functionality and serves as a wrapper
 * around the standard LibReDE tool in order to make calls for the algorithms
 * implemented here.
 * 
 * @author JS
 *
 */
public class Wrapper {

	/**
	 * The logging tool to be used in this context.
	 */
	private static final Logger log = Logger.getLogger(Wrapper.class);

	private static HashMap<LibredeConfiguration, LibredeVariables> cache = new HashMap<LibredeConfiguration, LibredeVariables>();

	/**
	 * Initialize the connection and set up the target, in this case LibReDE
	 * along with its libraries.
	 */
	public static void init() {
		Librede.init();
		IpoptLibrary.init();
		NNLSLibrary.init();
		BayesLibrary.init();
		cache = new HashMap<LibredeConfiguration, LibredeVariables>();
	}

	/**
	 * Call LibReDE with the given configuration.
	 * 
	 * @param conf
	 *            The configuration settings
	 * @return The results returned by LibReDE
	 */
	public static LibredeResults executeLibrede(LibredeConfiguration conf) {

		// used to increase performance but leads to memory overflow
		// cache variables in order to avoid constant re-initialization and
		// overflows
		// LibredeVariables var = null;
		// if (cache.get(conf) == null) {
		// var = new LibredeVariables(conf);
		// Librede.initRepo(var);
		// cache.put(conf, var);
		// } else {
		// var = cache.get(conf);
		// for (IRepositoryCursor cursor : var.getCursors().values()) {
		// cursor.reset();
		// }
		// }

		try {
			LibredeVariables var = new LibredeVariables(conf);
			Librede.initRepo(var);
			return Librede.runEstimationWithCrossValidation(var);
		} catch (Exception e) {
			log.error("Error running estimation.", e);
			return null;
		}
	}

}