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
package tools.descartes.librede.rrde.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.junit.Test;

import tools.descartes.librede.Librede;
import tools.descartes.librede.rrde.Plugin;
import tools.descartes.librede.rrde.Wrapper;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;
import tools.descartes.librede.rrde.optimization.OptimizationFactory;

/**
 * @author JS
 *
 */
public class GenerateModelFileTest {

	public final static String LIBREDE_PATH = "resources/estimation.librede";
	public final static String CONFIG_PATH = "resources/conf.optimization";

	@Test
	public void loadModelsAndModify() {
//		Plugin p = new Plugin();
//		p.initLogging();
//		Wrapper.init();
//		Librede.init();
		// LibredeConfiguration configuration = Librede
		// .loadConfiguration(new File(LIBREDE_PATH).toPath());
		// OptimizationConfiguration optimization = Plugin
		// .loadConfiguration(new File(CONFIG_PATH).toPath());
		ResourceSet rs = new ResourceSetImpl();
		// Here the resource is created, with fileextensions "gast" and "xml"
		// (adapt this to use your own file extension).
		Resource resource = createAndAddResource(CONFIG_PATH, new String[] {
				"optimization", "xml" }, rs);
		// The root object is created by using (adapt this to create your own
		// root object)
		OptimizationConfiguration root = OptimizationFactory.eINSTANCE.createOptimizationConfiguration();
		resource.getContents().add(root);
		saveResource(resource);
	}

	@SuppressWarnings("unchecked")
	public static Resource createAndAddResource(String outputFile,
			String[] fileextensions, ResourceSet rs) {
		for (String fileext : fileextensions) {
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(fileext, new XMLResourceFactoryImpl());
		}
		URI uri = URI.createFileURI(outputFile);
		Resource resource = rs.createResource(uri);
		((ResourceImpl) resource).setIntrinsicIDToEObjectMap(new HashMap());
		return resource;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void saveResource(Resource resource) {
		Map saveOptions = ((XMLResource) resource).getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE,
				new ArrayList());
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
