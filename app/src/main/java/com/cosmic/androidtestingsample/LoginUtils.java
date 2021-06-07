package com.cosmic.androidtestingsample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;

public class LoginUtils {

    /**
     * We want to determine is the passed string contains the '@' symbol.
     * This is method is called in our LogUnitTest and returns this value to it.
     * The result, if true, is that the email submitted to our LoginActivity edit text is likely
     * a valid email address
     * @param email
     * @return
     */
    public boolean isValidEmailAddress(String email){
        return email.contains("@");
    }

    /**
     * Does the passed email contain the '.' separating the domain from
     * the fully qualified domain portion, i.e., 'com' or 'org'
     * We are checking only for the '.' symbol
     * @param email
     * @return
     */
    public boolean isDotSomethingEmailAddress(String email){
        return email.contains(".");
    }


    /**
     * Here we want to check if this is one of the standard email domains such as .com, .org, .gov, .edu and so on
     * You could check for others such as .net or .biz, etc, but this is just a smale you could check.
     * Suppose you wanted only corporate emails or government emails to be used in the application. You could test
     * for it
     * @param email
     * @return
     */
    public boolean isCorrectDomain(String email){
        String[] split = email.split("\\.");
        String domain = split[1];
        if (domain.equals("com")){
            return true;
        }
        if (domain.equals("org")){
            return true;
        }
        if (domain.equals("gov")){
            return true;
        }
        if (domain.equals("edu")){
            return true;
        }
        return false;
    }

    /**
     * We want to be sure that the email submitted is non-null.
     * So we return email does not equal ""
     * If the user forgot to enter an email address this method will return false
     * @param email
     * @return
     */
    public boolean isEmailEmpty(String email){
        return !email.equals("");
    }


    /**
     * We want to check the length of a password a make sure that strong password policies are
     * enforced here. In this case, we want the password to be equal to or greater than
     * eight characters long
     * @param password
     * @return
     */
    public boolean isPasswordOfMinimumLength(String password){
        return password.length() >= 8;
    }

    /**
     * This is to determine if the password contains an uppercase character in the string
     * Create a new char variable 'c' and then loop through the length of the 'password' string
     * 'c' is then equal to the password character at the index of i. if there is an upper case character we return
     * true, else it is false if the loop is complete without finding an upper case letter
     */
    public boolean doesContainCapitalLetters(String password){
        char c;
        for (int i = 0; i < password.length(); i++){
            c = password.charAt(i);
            if (Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }


    /**
     * This is to determine if there is a lower case letter in the passed string
     * Similar to the previous method, we check each character in the password string
     * and check to see if it is lower case. If one is found, true is returned
     * If the loop completes and a lower case letter is not found, we return false
     */
    public boolean doesContainLowercaseLetters(String password){
        char c;
        for (int i = 0; i < password.length(); i++){
            c = password.charAt(i);
            if (Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }

    /**
     * Basically the same as our two previous methods
     * only we check to see if the char variable returns true on the isDigit() method call
     * @param password
     * @return
     */
    public boolean passwordContainsNumbers(String password){
        char c;
        for (int i = 0; i < password.length(); i++){
            c = password.charAt(i);
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    /**
     * This is simlar to our previous method but with a bit of a twist.
     * We are doing two things here. The first is the same as the previous methods. We assign
     * a value to char 'c' for each character in our passed string 'email.'
     *
     * We are then running a loop inside that loop and assigning a value to char 's'
     * which is equal to the character at each index of the 'special' string.
     *
     * We then check to see if at any point c is equal to s. If they are, that means the passed
     * email string contains a special character.
     *
     * In other words, we are looping through each character in the email string. One character at
     * a time in this email string we then loop through the entire length of the 'special' string
     * and compare the value of the two characters assigned for each index. If no match is found
     * the loop continues to the next character index of the 'email' string. If we have looped through
     * the entire length of the email string and did not find a 'special' character then we can return false
     *
     * The password did not contain a special character
     * @param password
     * @return
     */
    public boolean isSpecialCharacter(String password){
        char c;
        char s;
        String special = "!@#$%^&*()";
        for (int i = 0; i < password.length(); i++){
            c = password.charAt(i);
            for (int j = 0; j < special.length(); j++){
                s = special.charAt(j);
                if (c == s){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * And last but not least, we check to see if the password is not null
     * @param password
     * @return
     */
    public boolean isPasswordNull(String password){
        return !password.equals("");
    }

}
