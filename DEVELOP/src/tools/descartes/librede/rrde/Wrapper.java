package tools.descartes.librede.rrde;

import org.apache.log4j.Logger;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.LibredeVariables;
import tools.descartes.librede.bayesplusplus.BayesLibrary;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.ipopt.java.IpoptLibrary;
import tools.descartes.librede.nnls.NNLSLibrary;

/**
 * This class provides some interface functionality and serves as a wrapper
 * around the standard LibReDE tool in order to make calls for the estimators
 * implemented here.
 * 
 * @author JS
 *
 */
public class Wrapper {

	/**
	 * The logging tool to be used in this context.
	 */
	private static final Logger log = Logger.getLogger(Plugin.class);

	/**
	 * Initialize the connection and set up the target, in this case LibReDE
	 * along with its libraries.
	 */
	public static void init() {
		Librede.initLogging();
		Librede.init();
		IpoptLibrary.init();
		NNLSLibrary.init();
		BayesLibrary.init();
	}

	/**
	 * Call LibReDE with the given configuration.
	 * 
	 * @param conf
	 *            The configuration settings
	 * @return The results returned by LibReDE
	 */
	public static LibredeResults executeLibrede(LibredeConfiguration conf) {
		Librede.initRepo(new LibredeVariables(conf));
		return Librede.execute(conf);
	}

}
