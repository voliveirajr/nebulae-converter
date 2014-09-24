package com.xtrader.nebulae.converter;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.xtrader.nebulae.converter.commands.ConversionCmd;
import com.xtrader.nebulae.converter.commands.CotationCmd;
import com.xtrader.nebulae.converter.commands.DefinitionCmd;
import com.xtrader.nebulae.converter.commands.MaterialValueCmd;

public class CommandFactoryTest {
	
	@Test
	public void testCmdFactoryConversion() throws IOException, InstantiationException, IllegalAccessException{
		String str = "how much is pish tegj glob glob ?";
		Assert.assertTrue(str+" is not a valid command",CommandFactory.parseCommand(str) instanceof ConversionCmd);
	}
	
	@Test
	public void testCmdFactoryCotation() throws IOException, InstantiationException, IllegalAccessException{
		String str = "how many Credits is glob prok Iron ?";
		Assert.assertTrue(str+" is not a valid command",CommandFactory.parseCommand(str) instanceof CotationCmd);
	}
	@Test
	public void testCmdFactoryDefinition() throws IOException, InstantiationException, IllegalAccessException{
		String str = "pish is X";
		Assert.assertTrue(str+" is not a valid command",CommandFactory.parseCommand(str) instanceof DefinitionCmd);
	}
	@Test
	public void testCmdFactoryMaterial() throws IOException, InstantiationException, IllegalAccessException{
		String str = "glob prok Gold is 57800 Credits";
		Assert.assertTrue(str+" is not a valid command",CommandFactory.parseCommand(str) instanceof MaterialValueCmd);
	}
	@Test
	public void testCmdFactoryInvalid() throws IOException, InstantiationException, IllegalAccessException{
		String str = "salsifufu";
		Assert.assertTrue(str+" is not a invalid command",null == CommandFactory.parseCommand(str));

	}

}
