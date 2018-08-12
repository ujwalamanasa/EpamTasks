package com.epam.webapp.service;

import java.util.HashMap;
import java.util.Queue;

import com.epam.webapp.exception.VehicleNotParkedException;

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
	private Ups upsObject;
	public void setUps(Ups upsObject) {
		this.upsObject = upsObject;
	}
	public int unparking(HashMap<String, Integer> vehicle, String vehicleNumber, Queue<Integer> slotQueue) {
		Integer allotedSlot = vehicle.get(vehicleNumber);
		 
		if (allotedSlot != null) {
			
			vehicle.remove(vehicleNumber);
			slotQueue.add(allotedSlot);
		} else {
			throw new VehicleNotParkedException();
		}
		WriteToLogFile wf = new WriteToLogFile();
		wf.writeToLogFile(vehicleNumber, allotedSlot, "OutTime");
		return allotedSlot;
	}

}
