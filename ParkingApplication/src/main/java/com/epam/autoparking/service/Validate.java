package com.epam.autoparking.service;

/**
 * This class is used to validate the vehicle number.
 * 
 * @author Manasa_Maddali
 *
 */
public class Validate {
	/**
	 *
	 * @param vehicleNumber is a String.
	 * @return boolean value.
	 */
	public boolean validateNumber(final String vehicleNumber) {
		return vehicleNumber.matches("^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$");
	}
}
