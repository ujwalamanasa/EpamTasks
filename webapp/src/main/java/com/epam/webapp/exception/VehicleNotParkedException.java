package com.epam.webapp.exception;

public class VehicleNotParkedException extends RuntimeException {

	public String toString() {
		return "ur vehicle is not parked here";
	}

}
