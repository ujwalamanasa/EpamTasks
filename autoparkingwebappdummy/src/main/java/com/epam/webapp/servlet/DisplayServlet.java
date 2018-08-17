package com.epam.webapp.servlet;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		FileReader fin = new FileReader("Transaction.csv");
		@SuppressWarnings("resource")
		Scanner fileInput = new Scanner(fin);
		JsonArray parkingMap = new JsonArray();
		while (fileInput.hasNext()) {
			JsonObject jsonObject = new JsonObject();
			String[] words = new String[2];
			words = fileInput.next().split(",");
			jsonObject.addProperty("slotNumber", words[1]);
			jsonObject.addProperty("vehicleId", words[0]);
			parkingMap.add(jsonObject);
		}
		response.setContentType("application/json");
		out.println(parkingMap.toString());

	}

}
