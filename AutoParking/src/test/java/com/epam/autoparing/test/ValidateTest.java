package com.epam.autoparing.test;
import com.epam.autoparking.service.Validate;

import junit.framework.TestCase;

/**
 * This class is used to validate vehicle number.
 * @author Manasa_Maddali
 *
 */
public class ValidateTest extends TestCase {
/**
 * This method used to test whether vehicle number is validated or not.
 */
           public void test() {
            Validate v = new Validate();
            assertTrue(v.validateNumber("AP12AP1234"));
             assertFalse(v.validateNumber("asdfgh"));
             assertFalse(v.validateNumber("12AP12AP12"));
       }

 }


