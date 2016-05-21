package tools.descartes.librede.rrde;

import java.io.File;

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
		Wrapper.init();
		try {
			Librede.printSummary(Wrapper.executeLibrede((Librede
					.loadConfiguration(new File(PATH).toPath()))));
		} catch (Exception e) {
			log.error("Error occurred", e);
		}
		log.info("DONE.");
		return null;
	}

	@Override
	public void stop() {

	}

}
