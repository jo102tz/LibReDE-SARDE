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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.junit.Test;

import tools.descartes.librede.Librede;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.Plugin;
import tools.descartes.librede.rrde.Wrapper;
import tools.descartes.librede.rrde.optimization.OptimizationConfiguration;

/**
 * @author JS
 *
 */
public class GenerateModelFileTest {

	public final static String LIBREDE_PATH = "resources/estimation.librede";
	public final static String CONFIG_PATH = "resources/conf.optimization";

	@Test
	public void loadModels() {
		Plugin p = new Plugin();
		p.initLogging();
		Wrapper.init();
		Librede.init();
		LibredeConfiguration configuration = Librede
				.loadConfiguration(new File(LIBREDE_PATH).toPath());
		OptimizationConfiguration optimization = Plugin
				.loadConfiguration(new File(CONFIG_PATH).toPath());
	}

}