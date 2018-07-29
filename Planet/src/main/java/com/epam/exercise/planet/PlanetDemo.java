package com.epam.exercise.planet;
/**
 *
 * @author Manasa_Maddali
 *
 */
public class PlanetDemo {
/**
 *
 * @param args are command line arguments.
 */
      public static void main(final String[] args) {
       Planet p = new Planet("earth", 3, 40000000, 597000000);
        System.out.println(p.getDiameter());
        System.out.println(p.getMass());
        System.out.println(p.getName());
        System.out.println(p.getposition());
      CheckImmutability ci=new CheckImmutability();
      ci.check();
}

}
