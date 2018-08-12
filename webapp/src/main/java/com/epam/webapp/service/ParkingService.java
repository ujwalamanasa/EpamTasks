package com.epam.webapp.service;

import java.util.HashMap;
import java.util.Queue;

public class ParkingService {
	public int parking(HashMap<String, Integer> vehicle, Queue<Integer> slotQueue, String vehicleNumber, Integer slot) {
		Integer slotNumber;
		
		if (slotQueue.isEmpty()) {
			vehicle.put(vehicleNumber, slot);
			slotNumber = slot;
		} else {
			vehicle.put(vehicleNumber, (Integer) slotQueue.peek());
			slotNumber = (Integer) slotQueue.peek();
			slotQueue.remove();
		}
		WriteToLogFile writeLog = new WriteToLogFile();
		writeLog.writeToLogFile(vehicleNumber, slotNumber, "InTime");
		return slotNumber;
	}
}
