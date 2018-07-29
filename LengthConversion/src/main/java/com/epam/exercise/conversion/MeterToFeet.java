package com.epam.exercise.conversion;
/**
 * This class converts value from meter to feet.
 * @author Manasa_Maddali
 *
 */
public class MeterToFeet implements LengthConversions{
/**
 * 
 * @param value in meter
 * @return value in feet
 */
public double conversion(final double value) {
    return value * 3.280;
}
}