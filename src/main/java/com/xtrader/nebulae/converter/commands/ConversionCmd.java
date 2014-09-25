package com.xtrader.nebulae.converter.commands;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import com.xtrader.nebulae.converter.util.ConverterUtil;
@Log4j
public class ConversionCmd extends ConverterCommand {
	
	@Getter @Setter
	private String romanString;
	@Getter @Setter
	private String alienString;

	public ConversionCmd(String commandStr) throws Exception {
		super(commandStr);
	}

	@Override
	public String execute() {
		return String.format("%s is %d", alienString, ConverterUtil.romanToDecimal(romanString));
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
		alienString = commandStr;
		
		//"[pish] [tegj] [glob] [glob]"
		String[] splited = commandStr.split(" ");
				
		romanString = ConverterUtil.toRoman(splited);		
		log.debug("Roman String: " + romanString);	
	}	
}
