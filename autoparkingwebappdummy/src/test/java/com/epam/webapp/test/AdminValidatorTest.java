package com.epam.webapp.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.epam.webapp.service.AdminValidator;

public class AdminValidatorTest {
	@Test
	public void test() {
		AdminValidator validate = new AdminValidator();
		assertTrue( validate.credentials("manasa","3313"));
		assertFalse( validate.credentials("manasa","dfghj"));
		assertFalse( validate.credentials("sdfghj", "3313"));
		}
}
