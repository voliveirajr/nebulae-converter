package com.xtrader.nebulae.converter;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.xtrader.nebulae.converter.commands.ConversionCmd;
import com.xtrader.nebulae.converter.commands.CotationCmd;
import com.xtrader.nebulae.converter.commands.DefinitionCmd;
import com.xtrader.nebulae.converter.commands.MaterialValueCmd;
import com.xtrader.nebulae.converter.enums.Material;
import com.xtrader.nebulae.converter.enums.RomanAlgarisms;

public class CommandFactoryTest {
	
	@Before
	public void cleanupValues(){
		ConverterValues.getInstance().setMaterialValue(new HashMap<Material, Float>(0));
		ConverterValues.getInstance().setAlienReference(new HashMap<String, RomanAlgarisms>(0));
	}
	
	@Test
	public void testCmdFactoryDefinition() throws Exception{
		String str = "pish is X";
		Assert.assertTrue(str+" is not a valid command",CommandFactory.parseCommand(str) instanceof DefinitionCmd);
	}
	
	@Test
	public void testCmdFactoryConversion() throws Exception{
		String str = "how much is pish glob ?";
		ConverterValues.getInstance().getAlienReference().put("pish", RomanAlgarisms.X);
		ConverterValues.getInstance().getAlienReference().put("glob", RomanAlgarisms.V);
		Assert.assertTrue(str+" is not a valid command",CommandFactory.parseCommand(str) instanceof ConversionCmd);
	}
	
	@Test
	public void testCmdFactoryCotation() throws Exception{
		String str = "how many Credits is glob prok Iron ?";
		ConverterValues.getInstance().getAlienReference().put("glob", RomanAlgarisms.X);
		ConverterValues.getInstance().getAlienReference().put("prok", RomanAlgarisms.V);
		Assert.assertTrue(str+" is not a valid command",CommandFactory.parseCommand(str) instanceof CotationCmd);
	}
	
	@Test
	public void testCmdFactoryMaterial() throws Exception{
		String str = "pish glob Gold is 57800 Credits";
		ConverterValues.getInstance().getAlienReference().put("pish", RomanAlgarisms.X);
		ConverterValues.getInstance().getAlienReference().put("glob", RomanAlgarisms.V);
		Assert.assertTrue(str+" is not a valid command",CommandFactory.parseCommand(str) instanceof MaterialValueCmd);
	}
	@Test
	public void testCmdFactoryInvalid() throws Exception{
		String str = "salsifufu";
		Assert.assertTrue(str+" is not a invalid command",null == CommandFactory.parseCommand(str));
	}

}
