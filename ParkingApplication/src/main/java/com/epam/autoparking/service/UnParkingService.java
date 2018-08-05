package com.epam.autoparking.service;

import java.util.HashMap;
import java.util.Queue;

/**
 * This class provides UnParking information.
 * 
 * @author Manasa_Maddali
 *
 */
public class UnParkingService {
	/**
	 * @param vehicle       is a HashMap.
	 * @param slotQueue     is a Queue.
	 * @param vehicleNumber is a String.
	 * @param slot          is a Integer.
	 * @return slotQueue is a Queue.
	 */
	public int unparking(HashMap<String, Integer> vehicle, String vehicleNumber, Queue<Integer> slotQueue) {
		char charFlag = 'u';
		Integer slotNumber = vehicle.get(vehicleNumber);
		if (slotNumber != null) {
			WriteToLogFile writeLog = new WriteToLogFile();
			writeLog.writeToLogFile(vehicleNumber, slotNumber, charFlag);
			vehicle.remove(vehicleNumber);
			slotQueue.add(slotNumber);
		} else {
			slotNumber = -1;
		}
		return slotNumber;
	}
}
