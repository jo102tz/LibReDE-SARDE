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
package tools.descartes.librede.rrde.optimization.util.wrapper;

import org.apache.log4j.Logger;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.bayesplusplus.BayesLibrary;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.ipopt.java.IpoptLibrary;
import tools.descartes.librede.nnls.NNLSLibrary;
import tools.descartes.librede.repository.IMonitoringRepository;

/**
 * Cached Implementation of the {@link IWrapper} interface. It tries to only
 * read the repository once and then keep it in memory to save time.
 * 
 * @author Johannes Grohmann (johannes.grohmann@uni-wuerzburg.de)
 *
 */
public class CachedWrapper extends Wrapper {

	/**
	 * The logging tool to be used in this context.
	 */
	private static final Logger log = Logger.getLogger(CachedWrapper.class);

	/**
	 * The repository loaded the first time.
	 */
	private IMonitoringRepository repo = null;

	/**
	 * The configuration used to create the cached repo. (Used for cloning).
	 */
	private LibredeConfiguration cachedConf = null;

	@Override
	public LibredeResults executeLibrede(LibredeConfiguration conf) {

		try {
			LibredeVariables var = new LibredeVariables(conf);
			if (repo == null) {
				long tic = System.currentTimeMillis();
				Librede.initRepo(var);
				repo = var.getRepo();
				long toc = System.currentTimeMillis();
				log.trace("Loaded and cached the repository in " + (toc - tic) + " ms.");
			} else {
				var.setRepo(repo);
				log.trace("Used cached repository for run with " + conf.toString());
			}
			if (var.getConf().getValidation().getValidationFolds() <= 1) {
				return Librede.runEstimationWithValidation(var);
			} else {
				return Librede.runEstimationWithCrossValidation(var);
			}
		} catch (Exception e) {
			log.error("Error running cached estimation.", e);
			return null;
		}
	}

	/**
	 * Clean all cache and reset this instance.
	 */
	public void cleanCache() {
		repo = null;
		cachedConf = null;
	}

	/**
	 * @return the repo
	 */
	public IMonitoringRepository getRepo() {
		return repo;
	}

	/**
	 * @param repo
	 *            the repo to set
	 */
	public void setRepo(IMonitoringRepository repo) {
		this.repo = repo;
	}

	@Override
	public IWrapper clone() {
		CachedWrapper copy = (CachedWrapper) super.clone();
		if (repo == null) {
			// no problem, we can return this instance as nothing was
			// initialized yet.
			return copy;
		} else {
			LibredeVariables var = new LibredeVariables(cachedConf);
			long tic = System.currentTimeMillis();
			Librede.initRepo(var);
			copy.setRepo(var.getRepo());
			long toc = System.currentTimeMillis();
			log.trace("Cloned the cached repository by reloading it from file. Took: " + (toc - tic) + " ms.");
		}
		return copy;
	}

}
