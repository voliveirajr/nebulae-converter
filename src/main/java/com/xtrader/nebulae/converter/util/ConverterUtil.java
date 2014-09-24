package com.xtrader.nebulae.converter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xtrader.nebulae.converter.ConverterValues;
import com.xtrader.nebulae.converter.enums.RomanAlgarisms;

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
	
	/**
	 * With an Array of alien strings finds the equivalent Roman value for that
	 * @param alienArray
	 * @return
	 * @throws Exception
	 */
	public static String toRoman(String[] alienArray) throws Exception{
		StringBuilder strBuilder = new StringBuilder();
		for (String alienStr : alienArray) {
			if(ConverterValues.getInstance().getAlienReference().containsKey(alienStr)){
				RomanAlgarisms romanA = ConverterValues.getInstance().getAlienReference().get(alienStr);
				strBuilder.append(romanA.name());
			}else{
				log.error("You are trying to evaluate an alien value without define your Roman");
				throw new Exception("You are trying to evaluate an alien value without define your Roman");
			}
		}
		if(!ConverterUtil.romanMatch(strBuilder.toString())){
			log.error("I'm sorry dude, it should be a venusian poem, not a valid number be a venusian poem, is not a valid number");
			throw new Exception("I'm sorry dude, it should be a venusian poem, not a valid number be a venusian poem, is not a valid number");
		}
		return strBuilder.toString();	
	}
	
	public static Integer romanToDecimal(String romanStr){
		String[] romanChars = romanStr.split("(?!^)");
		RomanAlgarisms roman = null;
		RomanAlgarisms romanPrev = null;
		Integer result = 0;
		
		for (String rChar : romanChars) {
			roman = RomanAlgarisms.valueOf(rChar);
			result += roman.getDecimal();
			if(romanPrev != null && romanPrev.getDecimal() < roman.getDecimal()){
				result -= (2*romanPrev.getDecimal());
			}
			romanPrev = roman;
		}
		log.debug(result+ " evaluated");
		return result;		
	}

}
