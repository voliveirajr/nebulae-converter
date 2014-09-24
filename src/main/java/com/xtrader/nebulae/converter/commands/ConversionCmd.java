package com.xtrader.nebulae.converter.commands;

import lombok.extern.log4j.Log4j;

import org.apache.commons.lang3.NotImplementedException;

import com.xtrader.nebulae.converter.util.ConverterUtil;
@Log4j
public class ConversionCmd extends ConverterCommand {
	
	private String romanString;

	public ConversionCmd(String commandStr) throws Exception {
		super(commandStr);
	}

	@Override
	public String execute() {
		throw new NotImplementedException("TODO");		
	}

	@Override
	public void parse(String commandStr) throws Exception {
		//"how much is pish tegj glob glob ?"
		
		//"pish tegj glob glob ?"
		commandStr = commandStr.replaceAll("how much is ", "");
		log.debug(commandStr);
		//"pish tegj glob glob"
		commandStr = commandStr.replaceAll(" \\?", "");
		log.debug(commandStr);
		//"[pish] [tegj] [glob] [glob]"
		String[] splited = commandStr.split(" ");
				
		romanString = ConverterUtil.toRoman(splited);		
		
		log.debug("Roman String: " + romanString);	
	}	
}
