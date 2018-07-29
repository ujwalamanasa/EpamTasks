package com.epam.autoparking.exception;
/**
 * If there are no vehicles in parking slot exception is raised.
 * @author Manasa_Maddali
 *
 */
public class SlotEmptyException extends RuntimeException {
     /**
	 * This is the default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

    /**
     * Overrides the toString method from the class Exception.
     * @return A string to be mentioned when this exception occurs
     */

     
public String toString() {
       return "PARKING SLOT IS EMPTY";
}
}
