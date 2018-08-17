package com.epam.webapp.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.epam.webapp.service.UnParkingService;



public class UnParkingServiceTest {
	@Test
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
