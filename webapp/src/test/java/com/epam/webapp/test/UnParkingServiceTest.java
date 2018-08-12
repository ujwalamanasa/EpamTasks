package com.epam.webapp.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.epam.webapp.service.UnParkingService;

import junit.framework.TestCase;

/**
 * This class is used to test UnParkingService class.
 * 
 * @author Manasa_Maddali
 *
 */
public class UnParkingServiceTest extends TestCase {
	/**
	 * This method is used to check UnParking method.
	 */
	public void test() {
		UnParkingService unpark = new UnParkingService();
		HashMap<String, Integer> vehicles = new HashMap<String, Integer>();
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		vehicles.put("AP12AP1234", 1);
		vehicles.put("AP3HG3109", 2);
		int slotNumber = unpark.unparking(vehicles, "AP12AP1234", slotQueue);
		int slotNumber1 = unpark.unparking(vehicles, "AP12AH8234", slotQueue);
		assertEquals(1, slotNumber);
		assertEquals(-1, slotNumber1);
	}
}
