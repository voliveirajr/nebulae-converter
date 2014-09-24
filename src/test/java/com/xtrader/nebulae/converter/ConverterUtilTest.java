package com.xtrader.nebulae.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.xtrader.nebulae.converter.util.ConverterUtil;

public class ConverterUtilTest {
	
	@Test
	public void testValidRoman() throws IOException{
		
		for (String[] validValue : getRomans(true)) {
			Assert.assertTrue(validValue[1]+" dont match as valid roman", ConverterUtil.romanMatch(validValue[1]));
		}
				
	}
	
	@Test
	public void testInvalidRoman() throws IOException{
		
		for (String[] validValue : getRomans(false)) {
			Assert.assertFalse(validValue[1]+" match as valid roman", ConverterUtil.romanMatch(validValue[1]));
		}
				
	}
	
	private ArrayList<String[]> getRomans(boolean valid) throws IOException{
		ArrayList<String[]> validRomans = new ArrayList<String[]>();		
		String path = (valid)?"/valid_romans.txt":"/invalid_romans.txt";
		InputStreamReader ir = new InputStreamReader(getClass().getResourceAsStream(path));
		BufferedReader in = new BufferedReader(ir);
		String line;
		while ((line = in.readLine()) != null) {
			validRomans.add(line.split(" "));
		}
		return validRomans;
	}

}