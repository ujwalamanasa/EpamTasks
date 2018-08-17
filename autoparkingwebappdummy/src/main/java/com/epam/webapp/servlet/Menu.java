package com.epam.webapp.servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.epam.webapp.filedao.HashMapUtility;
import com.epam.webapp.filedao.LoadTotalSlots;
import com.epam.webapp.service.VehicleNumberValidator;
import com.epam.webapp.utility.ParkingUtility;
import com.epam.webapp.utility.UnParkingUtility;

/**
 * Servlet implementation class Menu
 */

public class Menu extends HttpServlet {
	static int slot = 0;
	//HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
		
		
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		response.setContentType("text/html");
		String requirement = request.getParameter("menu");
		String vehicleNumber = request.getParameter("vehicleNumber");
	    //onsole.log(vehicleNumber);
		System.out.println(vehicleNumber);
		LoadTotalSlots exist = new LoadTotalSlots();
		int totalSlots = exist.checkFileExistance();
		if (totalSlots == -1) {
			FileWriter slotFileObject = new FileWriter("SlotFile.csv");

			slotFileObject.write("10");
			totalSlots = 10;
			slotFileObject.close();
		} else {

			HashMapUtility copyObject = new HashMapUtility();
			copyObject.copyFileToHashMap(vehicle);

			int maxValue = copyObject.findMaxValue(vehicle, slotQueue);

			slot = maxValue;
		}

		VehicleNumberValidator validate = new VehicleNumberValidator();
		boolean is_valid = validate.validateNumber(vehicleNumber);
		
		if (is_valid) {
			if ("parking".equalsIgnoreCase(requirement)) {
				parkingOperation(request, response, vehicle, slotQueue, vehicleNumber, totalSlots);
			} else if ("unparking".equalsIgnoreCase(requirement)) {
				unParkingOperation(request, response, vehicle, slotQueue, vehicleNumber);
			}
			 
		}
		
	}

	private void unParkingOperation(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, Integer> vehicle, Queue<Integer> slotQueue, String vehicleNumber)
			throws ServletException, IOException {
		UnParkingUtility unpark = new UnParkingUtility();
		int allotedSlot = unpark.unparkingUtility(vehicle, vehicleNumber, slotQueue);
		JOptionPane.showMessageDialog(null, "Vehicle parked at " + allotedSlot);
		response.sendRedirect("Menu.jsp");
	}

	private void parkingOperation(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, Integer> vehicle, Queue<Integer> slotQueue, String vehicleNumber, int totalSlots)
			throws ServletException, IOException {
		int allotedSlot;
		if (slot > totalSlots && slotQueue.isEmpty()) {
			// throw new slotfullexception.
		}
		if (slotQueue.isEmpty()) {
			slot++;
		}
		ParkingUtility park = new ParkingUtility();
		allotedSlot = park.parkingUtility(vehicle, slotQueue, vehicleNumber, slot);
		JOptionPane.showMessageDialog(null, "Vehicle parked at " + allotedSlot);
		response.sendRedirect("Menu.jsp");
	}
	


}
