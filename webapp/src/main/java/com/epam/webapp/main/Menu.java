package com.epam.webapp.main;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.webapp.filedao.*;
import com.epam.webapp.service.*;

public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int slot = 0;
		HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		PrintWriter writerObject = response.getWriter();
		LoadTotalSlots exist = new LoadTotalSlots();
		int totalSlots = exist.checkFileExistance();
		if (totalSlots == -1) {
			totalSlots = 5;

		} else {
			HashMapUtility copyObject = new HashMapUtility();
			copyObject.copyFileToHashMap();
			int maxValue = copyObject.findMaxValue(vehicle, slotQueue);
			slot = maxValue;
		}
		String requirement = request.getParameter("menu");
		String vehicleNumber = request.getParameter("vehicleNumber");
		VehicleNumberValidator validate = new VehicleNumberValidator();
		boolean is_valid = validate.validateNumber(vehicleNumber);
		if (is_valid) {
			if ("parking".equalsIgnoreCase(requirement)) {

				parkingUtility(slot, vehicle, slotQueue, writerObject, totalSlots, vehicleNumber);
				request.getRequestDispatcher("/menu.html").include(request, response);

			} else if ("unparking".equalsIgnoreCase(requirement)) {

				unParkingUtility(vehicle, slotQueue, vehicleNumber, writerObject);
				request.getRequestDispatcher("/menu.html").include(request, response);

			}
		} else {
			// throw new invalidvehiclenumberexception.
		}

	}

	private void unParkingUtility(HashMap<String, Integer> vehicle, Queue<Integer> slotQueue, String vehicleNumber,
			PrintWriter writerObject) {
		if (vehicle.size() > 0) {
			UnParkingService unpark = new UnParkingService();
			int allotedSlot = unpark.unparking(vehicle, vehicleNumber, slotQueue);
			writerObject.println(allotedSlot);
			WriteToTransactionFile wf = new WriteToTransactionFile();
			wf.writeToTranscationFile(vehicle);
		} else {
			// throw new slotemptyexception
		}
	}

	private void parkingUtility(int slot, HashMap<String, Integer> vehicle, Queue<Integer> slotQueue,
			PrintWriter writerObject, int totalSlots, String vehicleNumber) {
		int allotedSlot;
		if (slot > totalSlots && slotQueue.isEmpty()) {
			// throw new slotfullexception.
		}
		if (slotQueue.isEmpty()) {
			slot++;
		}
		ParkingService park = new ParkingService();
		allotedSlot = park.parking(vehicle, slotQueue, vehicleNumber, slot);
		writerObject.println(allotedSlot);
		WriteToTransactionFile wf1 = new WriteToTransactionFile();
		wf1.writeToTranscationFile(vehicle);
	}
}
