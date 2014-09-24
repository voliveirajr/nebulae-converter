package com.xtrader.nebulae.converter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.log4j.Log4j;

@Log4j
public class ConverterUtil {
	
	private final static String ROMAN_PATTERN = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";	
	
	/**
	 * Method that validates if is a valid Roman Value based on these rules:
	 * - Symbols are placed from left to right in order of value, starting with the largest.
	 * - A letter repeats its value that many times. A letter can only be repeated three times
	 * - The numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
	 * - X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
	 * - C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern
	 * 
	 * @param romanStr - String with the roman value to be validated
	 * @return boolean
	 */
	public static boolean romanMatch(String romanStr){
		Pattern p = Pattern.compile(ROMAN_PATTERN);
		Matcher m = p.matcher(romanStr);
		if(log.isDebugEnabled()){
			log.debug(romanStr +" is "+ m.matches());
		}
		return m.matches();		
	}

}
