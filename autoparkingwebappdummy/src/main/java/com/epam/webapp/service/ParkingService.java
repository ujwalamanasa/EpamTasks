package com.epam.webapp.service;

import java.util.HashMap;
import java.util.Queue;

public class ParkingService {
	public int parking(HashMap<String, Integer> vehicle, Queue<Integer> slotQueue, String vehicleNumber, Integer slot) {
		Integer allotedSlot;
		
		if (slotQueue.isEmpty()) {
			vehicle.put(vehicleNumber, slot);
			
			allotedSlot = slot;
		} else {
			vehicle.put(vehicleNumber, (Integer) slotQueue.peek());
		
			allotedSlot = (Integer) slotQueue.peek();
			slotQueue.remove();
		}

		
		return allotedSlot;
	}
}
