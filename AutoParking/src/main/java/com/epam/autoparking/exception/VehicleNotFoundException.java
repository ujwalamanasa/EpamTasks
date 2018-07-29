package com.epam.autoparking.exception;
/**
 * This class raises this exception when vehicle is not parked but still queried for unparking.
 * @author Manasa_Maddali
 *
 */
public class VehicleNotFoundException  extends RuntimeException{
	   /**
	   * This is the default serialVersionUID.
	   */
	  private static final long serialVersionUID = 1L;

	  /**
	   * Exception to be thrown when the entered vehicle number is not found.
	   * Overrides the toString method from the class Exception.
	   * @return A string to be mentioned when this exception occurs
	   */
	  public String toString() {
	    return "No Vehicle with the entered vehicle Number";
	  }
	}


