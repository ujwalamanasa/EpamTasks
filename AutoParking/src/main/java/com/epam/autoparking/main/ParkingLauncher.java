package com.epam.autoparking.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.epam.autoparking.exception.SlotEmptyException;
import com.epam.autoparking.exception.VehicleNotFoundException;
import com.epam.autoparking.service.ParkingService;
import com.epam.autoparking.service.UnParkingService;
import com.epam.autoparking.service.Validate;
import com.epam.autoparking.service.WriteToFile;

/**
 * ParkingLauncher displays all the operations to be performed.
 * 
 * @author Manasa_Maddali
 *
 */
class ParkingLauncher {

	/**
	 *
	 * @param args are command line arguments.
	 * @param bw
	 * @param bw
	 * @param bw
	 */
	@SuppressWarnings("resource")
	public static void main(final String[] args) {
		HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		
		Admin a = new Admin();
		boolean login = a.credentials();

		if (login) {
			
		try {
				BufferedReader br;
				br = new BufferedReader(new FileReader("C:\\Users\\Manasa_Maddali\\Downloads\\EpamTasks-master\\EpamTasks-master\\AutoParking\\Transaction1.csv"));
				if (br.readLine() != null) {
				   
				ReadFromFile readFile = new ReadFromFile();
				vehicle = readFile.copyFileToHashMap();
				 System.out.println(vehicle);
				}
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}     
			
			System.out.printf("\nEnter number of slots: ");
			Integer totalSlots = sc.nextInt();
			int slot = 1;
			
			String vehicleNumber;
			boolean flag = true;
			
			Queue<Integer> slotQueue = new LinkedList<Integer>();
			while (flag) {
				System.out.printf("\n 1. Parking\n 2. UnParking\n 3. Exit");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					if (slot > totalSlots) {
						System.out.printf("\nParking slot is full");
						flag = false;
						break;
					}
					System.out.printf("\nenter vehicle number: ");
					vehicleNumber = sc.next();
					Validate v = new Validate();
					boolean value = v.validateNumber(vehicleNumber);
					while (!value) {
						System.out.println("Your vehicle number is invalid ");
						System.out.println("Enter Vehicle Number");
						vehicleNumber = sc.next();
						value = v.validateNumber(vehicleNumber);
					}
					ParkingService ps = new ParkingService();
					Integer slotNumber = ps.vehicleparking(vehicle, slotQueue, vehicleNumber, slot);
					WriteToFile wf1 = new WriteToFile();
					
					  
					   wf1.writeToTranscationFile(vehicle);
					
					System.out.printf("\nYour slotNumber: " + slotNumber);
					slot++;
					break;
				case 2:
					if (vehicle.size() > 0) {
						System.out.printf("\nenter vehicle number: ");
						vehicleNumber = sc.next();
						UnParkingService ups = new UnParkingService();
						slotNumber = ups.unparking(vehicle, vehicleNumber, slotQueue);
						
						if (slotNumber != -1) {
							WriteToFile wf = new WriteToFile();
							wf.writeToTranscationFile(vehicle);
							//wf.writeToLogFile(vehicle,ch);
							System.out.printf("\nYour slotNumber: " + slotNumber);
							System.out.printf("\nUnparking sucess");
						} else {
							try {
								throw new VehicleNotFoundException();
							} catch (VehicleNotFoundException e) {
								System.out.printf("\nYour vehicle is not parked here");
							}
						}
					} else {
						try {
							throw new SlotEmptyException();
						} catch (SlotEmptyException e) {
							System.out.printf("\nThere are no vehicles in the parking slot.");
						}
					}
					break;
				case 3:
					login = a.credentials();
					if (login) {
						System.out.println(vehicle);
						flag = false;
					}
					break;
				default:
					break;
				}
			}
		} else {
			System.out.printf("\nInvalid username or password");
		}
		sc.close();
	}

}
