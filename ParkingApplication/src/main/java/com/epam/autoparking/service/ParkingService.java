package com.epam.autoparking.service;

import java.util.HashMap;
import java.util.Queue;

/**
 * This class provides vehicle Parking Service information.
 * 
 * @author Manasa_Maddali
 *
 */
public class ParkingService {
	/**
	 * @param vehicle       is a HashMap.
	 * @param slotQueue     is a Queue.
	 * @param vehicleNumber is a String.
	 * @param slot          is a Integer.
	 * @return vehicle is a HashMap.
	 */
	public int vehicleparking(HashMap<String, Integer> vehicle, Queue<Integer> slotQueue, String vehicleNumber,
			Integer slot) {
		Integer slotNumber;
		char charFlag = 'p';
		if (slotQueue.isEmpty()) {
			vehicle.put(vehicleNumber, slot);
			slotNumber = slot;
		} else {
			vehicle.put(vehicleNumber, (Integer) slotQueue.peek());
			slotNumber = (Integer) slotQueue.peek();
			slotQueue.remove();
		}
		WriteToLogFile writeLog = new WriteToLogFile();
		writeLog.writeToLogFile(vehicleNumber, slotNumber, charFlag);
				return slotNumber;
	}
}
