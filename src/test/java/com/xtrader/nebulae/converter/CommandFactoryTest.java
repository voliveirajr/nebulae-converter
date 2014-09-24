package com.xtrader.nebulae.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.xtrader.nebulae.converter.commands.ConverterCommand;

public class CommandFactoryTest {
	
	@Test
	public void testCmdFactory() throws IOException, InstantiationException, IllegalAccessException{
		for (String str : getValidInputs()) {
			Assert.assertTrue(str+" is not a valid command",CommandFactory.parseCommand(str) instanceof ConverterCommand);
		}
	}
	
	private ArrayList<String> getValidInputs() throws IOException{
		ArrayList<String> validInputs = new ArrayList<String>();		
		InputStreamReader ir = new InputStreamReader(getClass().getResourceAsStream("/input.txt"));
		BufferedReader in = new BufferedReader(ir);
		String line;
		while ((line = in.readLine()) != null) {
			validInputs.add(line);
		}
		return validInputs;
	}
}
