package com.epam.exercise.conversion;

import java.util.Scanner;

/**
 * Main class to convert values between different metrics. 
 * @author Manasa_Maddali
 *
 */
public class Conversion{
/**
 * Main method
 * @param args are command line arguments.
 */
	public static void main(String[] args) {
		while(true) {
    System.out.println("Select your Requirement");
    System.out.println("1. convert from Meter to Inch");
    System.out.println("2. convert from Meter to Feet");
    System.out.println("3. convert from Inch to Meter");
    System.out.println("4. convert from Inch to Feet");
    System.out.println("5. convert from Feet to Inch");
    System.out.println("6. convert from Feet to Meter");
    Scanner sc = new Scanner(System.in);
    int requirement = sc.nextInt();
    double valueInMeter;
    double valueInInch;
    double valueInFeet;
    switch(requirement) {
     case 1:
        System.out.println("Enter your value in Meter");
        valueInMeter = sc.nextDouble();
        MeterToInch mi = new MeterToInch();
        System.out.println("Value in Inch: " + mi.conversion(valueInMeter));
         break;
     case 2:
         System.out.println("Eneter your value in Meter");
         valueInMeter = sc.nextDouble();
         MeterToFeet mf = new MeterToFeet();
         System.out.println("Value in Feet: " + mf.conversion(valueInMeter));
         break;
     case 3:
         System.out.println("Eneter your value in Inch");
         valueInInch = sc.nextDouble();
         InchToMeter im = new InchToMeter();
         System.out.println("Value in Meter: " + im.conversion(valueInInch));
         break;
     case 4:
         System.out.println("Eneter your value in Inch");
         valueInInch = sc.nextDouble();
         InchToFeet itf=new InchToFeet();
         System.out.println("Value in Feet: " + itf.conversion(valueInInch));
         break;
     case 5:
        System.out.println("Enter your value in Feet");
        valueInFeet = sc.nextDouble();
        FeetToInch fi = new FeetToInch();
        System.out.println("Value in Inch: " + fi.conversion(valueInFeet));
         break;
      case 6:
         System.out.println("Eneter your value in Feet");
         valueInFeet = sc.nextDouble();
         FeetToMeter fm = new FeetToMeter();
         System.out.println("Value in Meter: " + fm.conversion(valueInFeet));
         break;

	default:
		break;
     }
   
	}
	}
}
