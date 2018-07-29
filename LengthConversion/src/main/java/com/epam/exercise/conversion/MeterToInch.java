package com.epam.exercise.conversion;
/**
 * This class converts value from meter to inch.
 * @author Manasa_Maddali
 *
 */
public class MeterToInch implements LengthConversions{
/**
 * 
 * @param value in meter.
 * @return value in inch.
 */
      public double conversion(final double value) {
        return value * 39.370 ;
        }

}
