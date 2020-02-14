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
package tools.descartes.librede.rrde.util.wrapper;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.bayesplusplus.BayesLibrary;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.ipopt.java.IpoptLibrary;
import tools.descartes.librede.nnls.NNLSLibrary;

/**
 * Standard implementation of the {@link IWrapper} interface.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class Wrapper implements IWrapper {

	/**
	 * The logging tool to be used in this context.
	 */
	private static final Logger log = Logger.getLogger(Wrapper.class);

	/**
	 * Initialize the connection and set up the target, in this case LibReDE
	 * along with its libraries.
	 */
	public static void init() {
		Librede.init();
		IpoptLibrary.init();
		NNLSLibrary.init();
		BayesLibrary.init();
	}

	@Override
	public LibredeResults executeLibrede(LibredeConfiguration conf) {

		try {
			LibredeVariables var = new LibredeVariables(conf);
			Librede.initRepo(var);
			var.getRepo().setCurrentTime(EcoreUtil.copy(conf.getEstimation().getEndTimestamp()));
			if (var.getConf().getValidation().getValidationFolds() <= 1) {
				return Librede.runEstimationWithValidation(var);
			} else {
				return Librede.runEstimationWithCrossValidation(var);
			}
		} catch (Exception e) {
			log.error("Error running estimation.", e);
			return null;
		}
	}

	@Override
	public IWrapper clone() {
		try {
			return (IWrapper) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			log.error("Cloning of Wrapper object failed.");
		}
		return null;
	}

}
