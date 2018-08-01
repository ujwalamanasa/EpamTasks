package com.epam.autoparking.main;

import java.util.Scanner;

public class Admin {
Scanner sc = new Scanner(System.in);
	public boolean credentials() {
	System.out.printf("\nEnter username: ");
	String userName = sc.next();
	System.out.printf("\nEnter Password: ");
	String password = sc.next();
	boolean login=false;
	if(userName.equalsIgnoreCase("manasa") && password.equals("3313")) {
		login = true;
	}
	return login;
}

}
