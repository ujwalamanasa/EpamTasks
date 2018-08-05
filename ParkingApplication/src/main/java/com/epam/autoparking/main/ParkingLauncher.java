package com.epam.autoparking.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.epam.autoparking.exception.*;
import com.epam.autoparking.service.*;

/**
 * ParkingLauncher displays all the operations to be performed.
 *
 * @author Manasa_Maddali
 *
 */
public class ParkingLauncher {
	static Scanner scannerObject = new Scanner(System.in);
	/**
	 * This is a main method.
	 * 
	 * @param args are command line arguments.
	 */
	@SuppressWarnings("resource")
	public static void main(final String[] args) {
		HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		
		int slot = 0;
		boolean is_credentialsValid = adminCredentials();
		
		if (is_credentialsValid) {
			Integer maxValue = null;
			File fileObject = new File("Transaction1.csv");
			if (fileObject.exists()) {
				try {

					BufferedReader br;
					br = new BufferedReader(new FileReader("Transaction1.csv"));
					if (br.readLine() != null) {
						FileToHashMap readFile = new FileToHashMap();
						vehicle = readFile.copyFileToHashMap();
						Utility utilityObject = new Utility();
						maxValue = utilityObject.findMaxValue(vehicle);
						  utilityObject.queueUtility(vehicle, slotQueue, maxValue);
						slot = maxValue;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			System.out.printf("\nEnter number of slots: ");
			Integer totalSlots = scannerObject.nextInt();
			Validate valid = new Validate();
			String vehicleNumber;
			boolean flag = true;
			Integer slotNumber = null;
			while (flag) {
				System.out.printf("\n 1. Parking\n 2. UnParking\n 3. Exit");
				int choice = scannerObject.nextInt();
				switch (choice) {
				case 1:
					if (slot >= totalSlots) {
						System.out.printf("\nParking slot is full");
						flag = false;
						break;
					}
					System.out.printf("\nenter vehicle number: ");
					vehicleNumber = scannerObject.next();
					boolean value = valid.validateNumber(vehicleNumber);
					if (value) {
						ParkingService park = new ParkingService();
						if (slotQueue.isEmpty()) {
							slot++;
						}
						slotNumber = park.vehicleparking(vehicle, slotQueue, vehicleNumber, slot);
					
					
					WriteToTransactionFile wf1 = new WriteToTransactionFile();
					wf1.writeToTranscationFile(vehicle);
					System.out.printf("\nYour slotNumber: " + slotNumber);
					}
					else {
						System.out.println("Enter valid vehicle number");
					}
					break;
				case 2:
					if (vehicle.size() > 0) {
						System.out.printf("\nenter vehicle number: ");
						vehicleNumber = scannerObject.next();
						value = valid.validateNumber(vehicleNumber);
						if (value) {
							UnParkingService unpark = new UnParkingService();
							slotNumber = unpark.unparking(vehicle, vehicleNumber, slotQueue);
						
						if (slotNumber != -1) {
							WriteToTransactionFile wf = new WriteToTransactionFile();
							wf.writeToTranscationFile(vehicle);
							System.out.printf("\nYour slotNumber: " + slotNumber);
							System.out.printf("\nUnparking sucess");
						} else {
							try {
								throw new VehicleNotFoundException();
							} catch (VehicleNotFoundException e) {
								System.out.printf("\nYour vehicle is not parked here");
							}
						
					}
						}	
					}else {
						try {
							throw new SlotEmptyException();
						} catch (SlotEmptyException e) {
							System.out.printf("\nThere are no vehicles in the parking slot.");
						}
					}
					break;
					
				case 3:
				
						flag = false;
					
					break;
				default:
					break;
				}
			}
		} else {
			System.out.printf("\nInvalid username or password");
		}
		
	}
public static boolean adminCredentials() {
	System.out.printf("\nEnter username: ");
	String userName = scannerObject.next();
	System.out.printf("\nEnter Password: ");
	String password = scannerObject.next();
	AdminValidation credentials = new AdminValidation();
	return  credentials.validateAdmin(userName, password);
	
}

}
