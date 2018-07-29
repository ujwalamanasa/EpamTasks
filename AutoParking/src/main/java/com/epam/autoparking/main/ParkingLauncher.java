package com.epam.autoparking.main;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.epam.autoparking.exception.SlotEmptyException;
import com.epam.autoparking.exception.VehicleNotFoundException;
import com.epam.autoparking.service.ParkingService;
import com.epam.autoparking.service.UnParkingService;
/**
 * ParkingLauncher displays all the operations to be performed.
 * @author Manasa_Maddali
 *
 */
public class ParkingLauncher {
/**
 * 	
 * @param args are command line arguments.
 */
    public static void main(final String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.printf("\nEnter username: ");
    String userName=sc.next();
    System.out.printf("\nEnter Password: ");
    String password=sc.next();
    if(userName.equalsIgnoreCase("manasa")&& password.equals("3313")) {
	System.out.printf("\nEnter number of slots: ");
	Integer totalSlots=sc.nextInt();
	int slot=1;
	String vehicleNumber;
	boolean flag=true;
	HashMap<String,Integer> vehicle=new HashMap<String,Integer>();
	Queue<Integer> slotQueue = new LinkedList<Integer>();
	while(flag) {
	System.out.printf("\n 1. Parking\n 2. UnParking\n 3. Exit");
	int choice = sc.nextInt();
	switch (choice) {
	case 1:
    if(slot > totalSlots) {
    System.out.printf("\nParking slot is full");
   	flag = false;	
   	break;
	}
    System.out.printf("\nenter vehicle number: ");
    vehicleNumber=sc.next();
	ParkingService ps = new ParkingService();
    int slotNumber = ps.vehicleparking(vehicle,slotQueue,vehicleNumber,slot);
    System.out.printf("\nYour slotNumber: " + slotNumber);
	slot++;
	break;
	case 2:
		if(vehicle.size()>0) {
		System.out.printf("\nenter vehicle number: ");
	  	vehicleNumber=sc.next();
   		UnParkingService ups=new UnParkingService();
		 slotNumber=ups.unparking(vehicle,vehicleNumber,slotQueue);
		 if(slotNumber != -1) {
			 System.out.printf("\nYour slotNumber: " + slotNumber);
     		 System.out.printf("\nUnparking sucess");
		 }
		 else {
			 try {
					throw new VehicleNotFoundException();
					}
					catch(VehicleNotFoundException e) {
						System.out.printf("\nYour vehicle is not parked here");
					}
		 }
		}
		else {
			try {
			throw new SlotEmptyException();
			}
			catch(SlotEmptyException e) {
				System.out.printf("\nThere are no vehicles in the parking slot.");
			}
		}
		 	 break;
	case 3:
		 System.out.printf("\nEnter username: ");
	      userName=sc.next();
	     System.out.printf("\nEnter Password: ");
	      password=sc.next();
	     if(userName.equalsIgnoreCase("manasa")&& password.equals("3313")) {
	    	 flag=false;
	     }
	     break;
		  
	default: break;
	}
	}
    }
    else {
    	System.out.printf("\nInvalid username or password");
    }
	sc.close();
	}
		
	}

