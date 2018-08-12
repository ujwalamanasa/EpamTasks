package com.epam.webapp.test;

import com.epam.webapp.service.AdminValidator;

import junit.framework.TestCase;

public class LoginTest extends TestCase {
	public void test() {
		AdminValidator adminValidator = new AdminValidator();
		assertTrue(adminValidator.credentials("manasa", "3313"));
		assertFalse(adminValidator.credentials("manasa", "dfghj"));
		assertFalse(adminValidator.credentials("sdfghj", "3313"));
	}
}