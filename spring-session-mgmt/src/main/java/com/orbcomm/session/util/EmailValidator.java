/**
 * 
 */
package com.orbcomm.session.util;

/**
 * @author ntalari
 *
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	/*
	 * private static Pattern pattern; private static Matcher matcher;
	 * 
	 * private static final String EMAIL_PATTERN =
	 * "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
	 * "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 * 
	 * public EmailValidator() { pattern = Pattern.compile(EMAIL_PATTERN); }
	 * 
	 *//**
		 * Validate hex with regular expression
		 * 
		 * @param email
		 *            hex for validation
		 * @return true valid hex, false invalid hex
		 *//*
			 * public static boolean validate(final String email) {
			 * 
			 * matcher = pattern.matcher(email); return matcher.matches();
			 * 
			 * }
			 */

	// Email Regex java
	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

	// static Pattern object, since pattern is fixed
	private static Pattern pattern;

	// non-static Matcher object because it's created from the input String
	private Matcher matcher;

	public EmailValidator() {
		// initialize the Pattern object
		pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * This method validates the input email address with EMAIL_REGEX pattern
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean validate(String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
