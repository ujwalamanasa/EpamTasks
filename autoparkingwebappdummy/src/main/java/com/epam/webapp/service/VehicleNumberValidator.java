package com.epam.webapp.service;

public class VehicleNumberValidator {
	public boolean validateNumber(final String vehicleNumber) {
		return vehicleNumber.matches("^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$");
	}
}
