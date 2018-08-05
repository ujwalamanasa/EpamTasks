package com.epam.autoparking.main;

/**
 * This class is used to check credentials entered by the admin are valid or
 * not.
 *
 * @author Manasa_Maddali
 *
 */
public class AdminValidation {
	

	/**
	 * If the credentials are valid returns true else returns false.
	 * @param password 
	 * @param userName 
	 *
	 * @return login which is a boolean value.
	 */
	public boolean validateAdmin(String userName, String password) {
		
		boolean login = false;
		if ("manasa".equalsIgnoreCase(userName)
				&& "3313".equals(password)) {
			login = true;
		}
		return login;
	}
}
