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
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.exceptions.EstimationException;
import tools.descartes.librede.rrde.util.Util;

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
	 * The librede variables to use
	 */
	private LibredeVariables variables = null;

	/**
	 * The configuration used to create the cached repo. (Used for cloning).
	 */
	private LibredeConfiguration cachedConf = null;

	@Override
	public LibredeResults executeLibrede(LibredeConfiguration conf) {
		try {
			loadRepo(conf);
			if (this.getVariables().getConf().getValidation().getValidationFolds() <= 1) {
				return Librede.runEstimationWithValidation(this.getVariables());
			} else {
				return Librede.runEstimationWithCrossValidation(this.getVariables());
			}
		} catch (EstimationException | NullPointerException | IllegalStateException e) {
			log.error("Estimation error occurred while running cached estimation. Keeping Cache for now...", e);
			return null;
		} catch (Exception e) {
			log.error("Unexpected error running cached estimation. Cleaning the cache.", e);
			cleanCache();
			return null;
		}
	}

	/**
	 * Ensures that the repository of the given {@link LibredeConfiguration} is
	 * loaded and returns the loaded {@link LibredeVariables}. If the given
	 * configuration is already cached, the cached version is returned. If not, the
	 * cache is updated, and a reference to the new cache is returned. In any case,
	 * the variables are reset.
	 * 
	 * @param conf The {@link LibredeConfiguration} to load from.
	 * @return A reference to the current {@link LibredeVariables} object stored in
	 *         the cache.
	 */
	public LibredeVariables loadRepo(LibredeConfiguration conf) {
		LibredeVariables var = null;
		if (variables == null) {
			log.trace("Start loading repo.");
			long tic = System.currentTimeMillis();
			var = new LibredeVariables(EcoreUtil.copy(conf));
			Librede.initRepo(var);
			cachedConf = EcoreUtil.copy(conf);
			setVariables(var);
			long toc = System.currentTimeMillis();
			log.info("Loaded and cached the repository in " + (toc - tic) + " ms.");
		} else {
			if (areReposEqual(cachedConf, conf)) {
				var = this.getVariables();
				cachedConf = EcoreUtil.copy(conf);
				log.debug("Using cached repository for estimation " + conf);
			} else {
				log.info(
						"Given configuration differs from cached configuration. Clearing cache and load different repo...");
				cleanCache();
				return loadRepo(conf);
			}
		}
		var.getRepo().setCurrentTime(EcoreUtil.copy(conf.getEstimation().getEndTimestamp()));
		// we usually want to replace the whole conf, but there is no .setConf() in LibredeVariables
		var.getConf().setEstimation(EcoreUtil.copy(conf.getEstimation()));
		var.reset();
		return getVariables();

	}

	/**
	 * @return the variables
	 */
	public LibredeVariables getVariables() {
		return variables;
	}

	/**
	 * @param variables the variables to set
	 */
	public void setVariables(LibredeVariables variables) {
		this.variables = variables;
	}

	/**
	 * Clean all cache and reset this instance.
	 */
	public void cleanCache() {
		variables = null;
		cachedConf = null;
	}

	@Override
	public IWrapper clone() {
		CachedWrapper copy = (CachedWrapper) super.clone();
		if (variables == null) {
			// no problem, we can return this instance as nothing was
			// initialized yet.
			return copy;
		} else {
			// the delivered copy has a clean cache and has to initialize itself
			copy.cleanCache();
		}
		return copy;
	}

	/**
	 * Checks if the two given configurations have the same repository.
	 * 
	 * @param one The first configuration
	 * @param two The second configuration
	 * @return True, if they are equal for workload description and input
	 *         definition, false otherwise.
	 */
	public boolean areReposEqual(LibredeConfiguration one, LibredeConfiguration two) {
		// check if workload description is equal
		if (!EcoreUtil.equals(one.getWorkloadDescription(), two.getWorkloadDescription())) {
			return false;
		}
		// check if input description is equal
		if (!EcoreUtil.equals(one.getInput(), two.getInput())) {
			return false;
		}
		return true;
	}

}
