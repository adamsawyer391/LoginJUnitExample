package com.cosmic.androidtestingsample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * To run these tests, right click on the class name, in this case 'LoginUnitTest' to run all the test
 * methods in the class. Or you can right click on the method to check only that method
 *
 * In a real test you will probably only want to test one of these assert statements at a time.
 * If you have cloned this to test, delete or comment out additional assert statements to test them one at
 * a time.
 *
 * I have included multiple assert statements for demonstration purposes of various tests that will
 * both pass and fail
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginUnitTest {

    private LoginUtils loginUtils;

    @Before
    public void init(){
        loginUtils = new LoginUtils();
    }


    /**
     * This is verifying that the simulated passed email address 'myname@name.com
     * contains the character '@'
     * If it does, assertTrue() should return true
     * @throws Exception
     */
    @Test
    public void isValidEmailAddress() throws Exception{
        assertTrue(loginUtils.isValidEmailAddress("myname@name.com"));
    }

    @Test
    public void doesContainDotCharacter()throws Exception{
        assertTrue(loginUtils.isDotSomethingEmailAddress("someone@email.com")); //should return true and pass the test
        assertTrue(loginUtils.isDotSomethingEmailAddress("someone@failcom")); //should fail the test
        assertFalse(loginUtils.isDotSomethingEmailAddress("someone@fail.com")); //another way to write that failed test
    }

    @Test
    public void doesEmailHaveCorrectDomain(){
        assertTrue(loginUtils.isCorrectDomain("email@agency.gov")); //should pass
        assertTrue(loginUtils.isCorrectDomain("teacher@university.edu")); //should pass
        assertTrue(loginUtils.isCorrectDomain("ceo@business.biz")); //should fail (because we are not testing for .biz)
        assertTrue(loginUtils.isCorrectDomain("pilot01@airlines.flying")); //should also fail because this not likely a legit email domain
    }

    @Test
    public void emailIsNotNull(){
        assertTrue(loginUtils.isEmailEmpty("name@email.com")); //this test passed. the email was not null
        assertTrue(loginUtils.isEmailEmpty("")); //this should fail because the passed email string is empty
    }

    @Test
    public void doesPasswordMeetMinimumLengthRequirements(){
        assertTrue(loginUtils.isPasswordOfMinimumLength("hello_password")); //this passes the test because the length exceeds 8 characters
        assertTrue(loginUtils.isPasswordOfMinimumLength("1234")); //this fails because the length is less than 8 characters
    }

    @Test
    public void passwordContainsUppercaseLetter(){
        assertTrue(loginUtils.doesContainCapitalLetters("Password")); //this test passes
        assertTrue(loginUtils.doesContainCapitalLetters("password")); //this test fails
    }

    @Test
    public void passwordContainsLowercaseLetter(){
        assertTrue(loginUtils.doesContainLowercaseLetters("pASSWORD")); // this test passes
        assertTrue(loginUtils.doesContainLowercaseLetters("PASSWORD")); // this test fails
    }

    @Test
    public void passwordContainsNumbers(){
        assertTrue(loginUtils.passwordContainsNumbers("password123")); //passes the test
        assertTrue(loginUtils.passwordContainsNumbers("password")); //fails the test
    }

    @Test
    public void passwordContainsSpecialCharacters(){
        assertTrue(loginUtils.isSpecialCharacter("password!")); //passes the test
        assertTrue(loginUtils.isSpecialCharacter("%words")); //passes the test
        assertTrue(loginUtils.isSpecialCharacter("p@ssword")); //passes the test
        assertTrue(loginUtils.isSpecialCharacter("nospecial")); //fails the test
        assertTrue(loginUtils.isSpecialCharacter("1234")); //fails the test
    }

    @Test
    public void passwordIsNotNull(){
        assertTrue(loginUtils.isPasswordNull("password")); //passes the test
        assertTrue(loginUtils.isPasswordNull("")); //fails the test
    }

}