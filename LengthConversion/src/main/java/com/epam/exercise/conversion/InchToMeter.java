package com.epam.exercise.conversion;
/**
 * 
 * @author Manasa_Maddali
 *
 */
public class InchToMeter implements LengthConversions {
/**
 * 
 * @param value in inch
 * @return value in meter
 */
public double conversion(final double value){
return value * 0.254;
}
}
