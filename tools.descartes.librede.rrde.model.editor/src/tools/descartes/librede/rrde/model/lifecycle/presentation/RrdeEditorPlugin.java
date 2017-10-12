/**
 */
package tools.descartes.librede.rrde.model.lifecycle.presentation;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.ui.EclipseUIPlugin;

import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;

import tools.descartes.librede.Librede;
import tools.descartes.librede.bayesplusplus.BayesLibrary;
import tools.descartes.librede.configuration.provider.LibredeEditPlugin;
import tools.descartes.librede.ipopt.java.IpoptLibrary;
import tools.descartes.librede.nnls.NNLSLibrary;
import tools.descartes.librede.rrde.Plugin;
import tools.descartes.librede.rrde.model.optimization.presentation.OptimizationEditor;

/**
 * This is the central singleton for the Rrde editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class RrdeEditorPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final RrdeEditorPlugin INSTANCE = new RrdeEditorPlugin();
	
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RrdeEditorPlugin() {
		super
			(new ResourceLocator [] {
				LibredeEditPlugin.INSTANCE,
			});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
	
	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}
	
	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipseUIPlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();
	
			// Remember the static instance.
			//
			plugin = this;
		}
		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
			Librede.initLogging();
			Librede.init();
			NNLSLibrary.init();
			IpoptLibrary.init();
			BayesLibrary.init();
			Plugin.initRegistry();
			try {
				// This is only optional.
				// DmlLibrary.init();
			} catch(NoClassDefFoundError er) {
				// Ignore it.
			}
		}
	}
	
	

}
