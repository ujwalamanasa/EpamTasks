package com.epam.exercise.conversion;
/**
 * This class converts value from inch to feet.
 * @author Manasa_Maddali
 *
 */
public class InchToFeet implements LengthConversions {
/**
 * 
 * @param value in inch
 * @return value in feet
 */
public double conversion(final double value){
return value * 0.08334;
}



}
