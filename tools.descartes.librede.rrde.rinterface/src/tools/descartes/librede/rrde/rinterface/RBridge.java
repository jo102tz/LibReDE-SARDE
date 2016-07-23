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
package tools.descartes.librede.rrde.rinterface;

import org.apache.log4j.Logger;
import org.rosuda.JRI.Rengine;

/**
 * A Bridge to manage calls from Java to R and vice versa.
 * 
 * @author JS
 *
 */
public class RBridge {

	/**
	 * The log used for logging.
	 */
	private static final Logger log = Logger.getLogger(RBridge.class);

	/**
	 * The engine to run R commands
	 */
	private Rengine re;

	public RBridge() {
		re = createRengine();
	}

	/**
	 * Method to generate a R thread inside the java application.
	 * 
	 * @return Generated R engine.
	 */
	private Rengine createRengine() {
		// ensure, that the right versions of R and Java are available
		if (!Rengine.versionCheck()) {
			log.error("** JRI R-Engine: Version mismatch - Java files don't match library version.");
			return null;
		}
		log.info("------------------------------");
		log.info("Creating JRI R-Engine");
		// arguments which should be passed to R
		String[] args = new String[3];
		args[0] = "--quiet"; // Don't print startup message
		args[1] = "--no-restore"; // Don't restore anything
		args[2] = "--no-save";// Don't save workspace at the end of the session
		// generate new R engine
		Rengine re = new Rengine(args, false, null);
		log.info("JRI R-Engine created, waiting for R...");
		// wait until thread to create R is ready
		if (!re.waitForR()) {
			log.error("Cannot load R");
			return null;
		}
		// print R engine arguments
		log.info("JRI R-Engine call: ");
		for (int i = 0; i < args.length; i++) {
			log.info(args[i] + " ");
		}
		log.info("...done!");
		log.info("------------------------------");
		// return the R engine
		return re;
	}

}
