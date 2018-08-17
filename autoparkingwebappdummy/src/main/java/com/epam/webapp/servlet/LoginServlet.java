package com.epam.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.epam.webapp.service.AdminValidator;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean is_valid = false;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writerObject = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		AdminValidator validate = new AdminValidator();
		is_valid = (validate).credentials(userName, password);
		
		if(is_valid) {
			response.sendRedirect("Menu.jsp");
		} else {
			
			response.sendRedirect("Login.jsp");
		}


	}

}
