package com.epam.webapp.test;

import com.epam.webapp.service.VehicleNumberValidator;

import junit.framework.TestCase;

/**
 * This class is used to validate vehicle number.
 * 
 * @author Manasa_Maddali
 *
 */
public class ValidateTest extends TestCase {
	/**
	 * This method used to test whether vehicle number is validated or not.
	 */
	public void test() {
		VehicleNumberValidator valid = new VehicleNumberValidator();
		assertTrue(valid.validateNumber("AP12AP1234"));
		assertFalse(valid.validateNumber("asdfgh"));
		assertFalse(valid.validateNumber("12AP12AP12"));
	}

}
