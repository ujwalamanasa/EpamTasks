package autoparkingwebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.webapp.service.VehicleNumberValidator;

/**
 * Servlet implementation class Menu
 */
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writerObject =response.getWriter(); 
         String requirement = request.getParameter("menu");
         String vehicleNumber = request.getParameter("vehicleNumber");
         VehicleNumberValidator validate = new VehicleNumberValidator(); 
         boolean is_valid = validate.validateNumber(vehicleNumber);
         if(is_valid) {
         if("parking".equalsIgnoreCase(requirement)){
        	
         }
         else if("unparking".equalsIgnoreCase(requirement)) {
        	 
         }
         }
        	 
         //writerObject.print(requirement);
         //writerObject.println(vehicleNumber);
	}

}
