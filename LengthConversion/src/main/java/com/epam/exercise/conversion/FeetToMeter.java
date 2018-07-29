package com.epam.exercise.conversion;
/**
 * This class converts value from feet to meter.
 * @author Manasa_Maddali
 *
 */
public class FeetToMeter implements LengthConversions {
/**
 * 
 * @param value in feet
 * @return value in meter
 */ 
public double conversion(final double value){
return value * 0.3048; 
}
}
