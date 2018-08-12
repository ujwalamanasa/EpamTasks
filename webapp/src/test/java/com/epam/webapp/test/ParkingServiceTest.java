package com.epam.webapp.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.epam.webapp.service.ParkingService;

import junit.framework.TestCase;

/**
 * This class is used to test ParkingService class.
 * 
 * @author Manasa_Maddali
 *
 */
public class ParkingServiceTest extends TestCase {
	/**
	 * This method is used to test Parking method.
	 */
	public void test() {
		ParkingService park = new ParkingService();
		HashMap<String, Integer> vehicles = new HashMap<String, Integer>();
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		String vehicleNumber = "AP36GH3109";
		int slot = 1;
		final int number = 3;
		slotQueue.add(number);
		final int actualValue = 3;
		assertEquals(actualValue, park.parking(vehicles, slotQueue, vehicleNumber, slot));
	}

}
