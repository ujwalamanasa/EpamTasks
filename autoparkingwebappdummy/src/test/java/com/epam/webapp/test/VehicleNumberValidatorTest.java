package com.epam.webapp.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.epam.webapp.service.VehicleNumberValidator;

public class VehicleNumberValidatorTest {
	@Test
	public void test() {
		VehicleNumberValidator valid = new VehicleNumberValidator();
		assertTrue(valid.validateNumber("AP12AP1234"));
		assertFalse(valid.validateNumber("asdfgh"));
		assertFalse(valid.validateNumber("12AP12AP12"));
	}
}
