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
package tools.descartes.librede.rrde;

import java.util.Collection;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.rrde.optimization.GenericParameter;
import tools.descartes.librede.rrde.optimization.StepSize;
import tools.descartes.librede.rrde.optimization.WindowSize;

/**
 * This class contains some useful utilities.
 * 
 * @author JS
 *
 */
public class Util {

	private static final Logger log = Logger.getLogger(Util.class);

	public static void setValue(LibredeConfiguration librede, double value,
			String eClass) {
		if (eClass.equals(StepSize.class.getName())) {
			librede.getEstimation().getStepSize().setValue(value);
			log.trace("Set Stepsize to " + value);
		} else if (eClass.equals(WindowSize.class.getName())) {
			int integer = (int) Math.round(value);
			if (integer != value) {
				log.warn("The value "
						+ value
						+ " is not an Integer and had to be rounded to fit as window size.");
			}
			librede.getEstimation().setWindow(integer);
			log.trace("Set Windowsize to " + integer);
		} else if (eClass.equals(GenericParameter.class.getName())) {
			log.warn("The setting of GenericParameter is not supported and will be ignored.");
		} else {
			log.error("No handling adapter of setting Optimizable Parameter "
					+ eClass);
		}
	}

	public static double getValue(LibredeConfiguration librede, String eClass) {
		if (eClass.equals(StepSize.class.getName())) {
			return librede.getEstimation().getStepSize().getValue();
		} else if (eClass.equals(WindowSize.class.getName())) {
			return librede.getEstimation().getWindow();
		} else if (eClass.equals(GenericParameter.class.getName())) {
			log.warn("The setting of GenericParameter is not supported and will be ignored.");
		} else {
			log.error("No handling adapter of setting Optimizable Parameter "
					+ eClass);
		}
		return -1;
	}

}
