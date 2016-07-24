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

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.rosuda.JRI.RMainLoopCallbacks;
import org.rosuda.JRI.Rengine;

import tools.descartes.librede.rrde.optimization.IOptimizableParameter;

/**
 * A Bridge to manage calls from Java to R and vice versa.
 * 
 * @author JS
 *
 */
// TODO singleton
public class RBridge implements RMainLoopCallbacks {

	/**
	 * The log used for logging.
	 */
	private static final Logger log = Logger.getLogger(RBridge.class);

	/**
	 * The location of the script
	 */
	private static final String script = "tools.descartes.librede.rrde.rinterface/scripts/IPO.r";

	/**
	 * The engine to run R commands
	 */
	private Rengine re;

	public RBridge() {
		re = createRengine();
		loadScript();
	}

	/**
	 * Locates and loads the R script.
	 */
	public void loadScript() {
		// get absolute location
		String path = new File("").getAbsolutePath();
		// get parent directory
		File f = new File(path.substring(0, path.lastIndexOf("\\") + 1));
		// replace slashes
		path = f.getAbsolutePath().replace("\\", "/");
		log.debug("Script location to be executed: " + path + "/" + script);
		re.eval("source('" + path + "/" + script + "')");
	}

	/**
	 * Runs the script for the given parameters and uses the given
	 * {@link CallbackEvaluator} as evaluation.
	 * 
	 * @param params
	 *            The List of {@link IOptimizableParameter}s to optimize
	 * @param eval
	 *            The evaluator resolving evaluation calls
	 * @return A Mapping of an optimal value for each parameter
	 */
	public Map<IOptimizableParameter, Double> runOptimization(
			Collection<IOptimizableParameter> params, CallbackEvaluator eval) {
		// TODO
		return null;
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
		Rengine re = new Rengine(args, false, this);
		log.info("JRI R-Engine created, waiting for R...");
		// wait until thread to create R is ready
		if (!re.waitForR()) {
			log.error("Cannot load R");
			return null;
		}
		// print R engine arguments
		String s = "JRI R-Engine call: ";
		for (int i = 0; i < args.length; i++) {
			s += args[i] + " ";
		}
		s += "...done!";
		log.info(s);
		log.info("------------------------------");
		// return the R engine
		return re;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.rosuda.JRI.RMainLoopCallbacks#rBusy(org.rosuda.JRI.Rengine, int)
	 */
	@Override
	public void rBusy(Rengine arg0, int arg1) {
		if (arg1 == 1) {
			log.trace("R: calculating...");
		} else {
			log.trace("R: done.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rosuda.JRI.RMainLoopCallbacks#rChooseFile(org.rosuda.JRI.Rengine,
	 * int)
	 */
	@Override
	public String rChooseFile(Rengine arg0, int arg1) {
		log.error("Not prepared for file-choosing.");
		return script;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rosuda.JRI.RMainLoopCallbacks#rFlushConsole(org.rosuda.JRI.Rengine)
	 */
	@Override
	public void rFlushConsole(Rengine arg0) {
		// to nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rosuda.JRI.RMainLoopCallbacks#rLoadHistory(org.rosuda.JRI.Rengine,
	 * java.lang.String)
	 */
	@Override
	public void rLoadHistory(Rengine arg0, String arg1) {
		log.error("No history to load.");
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rosuda.JRI.RMainLoopCallbacks#rReadConsole(org.rosuda.JRI.Rengine,
	 * java.lang.String, int)
	 */
	@Override
	public String rReadConsole(Rengine arg0, String arg1, int arg2) {
		log.warn("R: " + arg1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			log.error("Error while waiting.", e);
		}
		return "null";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rosuda.JRI.RMainLoopCallbacks#rSaveHistory(org.rosuda.JRI.Rengine,
	 * java.lang.String)
	 */
	@Override
	public void rSaveHistory(Rengine arg0, String arg1) {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rosuda.JRI.RMainLoopCallbacks#rShowMessage(org.rosuda.JRI.Rengine,
	 * java.lang.String)
	 */
	@Override
	public void rShowMessage(Rengine arg0, String arg1) {
		log.warn("R: " + arg1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rosuda.JRI.RMainLoopCallbacks#rWriteConsole(org.rosuda.JRI.Rengine,
	 * java.lang.String, int)
	 */
	@Override
	public void rWriteConsole(Rengine arg0, String arg1, int arg2) {
		if (arg2 == 0) {
			// normal
			log.info(arg1);
		} else {
			// error
			log.warn(arg1);
		}
	}
}
