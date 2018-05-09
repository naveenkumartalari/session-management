/**
 * 
 */
package com.orbc.session.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ntalari
 *
 */
public class DateUtil {
	
	public static boolean isTokenExpired(String tokenExpDate) {
		SimpleDateFormat format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

		Date date1 = null;
		Date date2 = null;
		try {
			date1 = new Date();
			date2 = format.parse(tokenExpDate);
		} catch (ParseException e) {
			throw new RuntimeException("date parsing exception",e);
		}
		return date1.compareTo(date2)<0;

	}

}
