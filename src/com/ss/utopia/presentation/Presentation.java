/**
 * 
 */
package com.ss.utopia.presentation;

import java.sql.SQLException;

/**
 * @author amanda
 *
 */
public abstract class Presentation {

	/**
	 * 
	 */
	public Presentation() {
		
	}

	abstract public void menu() throws SQLException, ClassNotFoundException;
}
