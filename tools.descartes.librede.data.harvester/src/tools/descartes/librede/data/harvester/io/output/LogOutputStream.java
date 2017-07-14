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
package tools.descartes.librede.data.harvester.io.output;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.OutputStream;

/**
 * This class logs all bytes written to it as output stream with a specified
 * logging level.
 *
 * @author <a href="mailto:cspannagel@web.de">Christian Spannagel</a>
 * @version 1.0
 */
public class LogOutputStream extends OutputStream {
	/** The logger where to log the written bytes. */
	private Logger logger;

	/** The level. */
	private Level level;

	/** The internal memory for the written bytes. */
	private String mem;

	/**
	 * Creates a new log output stream which logs bytes to the specified logger
	 * with the specified level.
	 *
	 * @param logger
	 *            the logger where to log the written bytes
	 * @param level
	 *            the level
	 */
	public LogOutputStream(Logger logger, Level level) {
		setLogger(logger);
		setLevel(level);
		mem = "";
	}

	/**
	 * Sets the logger where to log the bytes.
	 *
	 * @param logger
	 *            the logger
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * Returns the logger.
	 *
	 * @return DOCUMENT ME!
	 */
	public Logger getLogger() {
		return logger;
	}

	/**
	 * Sets the logging level.
	 *
	 * @param level
	 *            DOCUMENT ME!
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * Returns the logging level.
	 *
	 * @return DOCUMENT ME!
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Writes a byte to the output stream. This method flushes automatically at
	 * the end of a line.
	 *
	 * @param b
	 *            DOCUMENT ME!
	 */
	public void write(int b) {
		byte[] bytes = new byte[1];
		bytes[0] = (byte) (b & 0xff);
		mem = mem + new String(bytes);

		if (mem.endsWith("\n")) {
			mem = mem.substring(0, mem.length() - 1);
			flush();
		}
	}

	/**
	 * Flushes the output stream.
	 */
	public void flush() {
		logger.log(level, mem);
		mem = "";
	}

	public void write(byte[] s, int off, int len) {
		for (byte b : s) {
			write(b);
		}
	}
}