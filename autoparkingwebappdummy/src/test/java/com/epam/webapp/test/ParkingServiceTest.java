package com.epam.webapp.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.epam.webapp.service.ParkingService;

public class ParkingServiceTest {
	@Test
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

