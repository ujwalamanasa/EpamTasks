package com.epam.autoparing.test;

import com.epam.autoparking.main.AdminValidation;

import junit.framework.TestCase;

public class LoginTest extends TestCase {
	public void test() {
AdminValidation admin = new AdminValidation();
assertTrue(admin.credentials("manasa","3313"));
assertFalse(admin.credentials("manasa","dfghj"));
assertFalse(admin.credentials("sdfghj", "3313"));
}
}