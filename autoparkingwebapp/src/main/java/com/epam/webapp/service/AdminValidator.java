package com.epam.webapp.service;

public class AdminValidator {
	

	public boolean credentials(String userName, String password) {
		
		boolean login = false;
		if ("manasa".equalsIgnoreCase(userName) && "3313".equals(password)) {
			login = true;
		}
		return login;
	}
}
