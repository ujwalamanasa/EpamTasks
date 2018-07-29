package com.epam.exercise.planet;
/**
 * Planet is a immutable class.
 * @author Manasa_Maddali
 *
 */
public final class Planet {
/**
 * name of the planet.
 */
private final String name;
/**
 * position of a planet in the solar system.
 */
private final int position;
/**
 * mass of the planet.
 */
private final double mass;
/**
 * diameter of the planet.
 */
private final long diameter;
/**
 * @param name1 is the  name of the planet.
 * @param position1 is the  position of the planet.
 * @param mass1 is the  mass of the planet.
 * @param diameter1 is the  diameter of the planet.
 *
 */
Planet(final String name1, final int position1,
       final double mass1, final long diameter1) {
    this.name = name1;
    this.mass = mass1;
    this.position = position1;
    this.diameter = diameter1;
}
/**
 *
 * @return name of the planet
 */
public String getName() {
    return name;
}
/**
 *
 * @return position of a planet in the solar system.
 */
public int getposition() {
   return position;
}
/**
 *
 * @return mass of the planet.
 */
public double getMass() {
    return mass;
}
/**
 *
 * @return  diameter of the planet.
 */
public long getDiameter() {
   return diameter;
}


}
