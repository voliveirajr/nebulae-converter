package com.xtrader.nebulae.converter.commands;

import lombok.extern.log4j.Log4j;

import org.apache.commons.lang3.NotImplementedException;

import com.xtrader.nebulae.converter.ConverterValues;
import com.xtrader.nebulae.converter.enums.RomanAlgarisms;
import com.xtrader.nebulae.converter.util.ConverterUtil;
@Log4j
public class ConversionCmd extends ConverterCommand {
	
	private StringBuilder romanString;

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
				
		romanString = new StringBuilder();
		for (String alienStr : splited) {
			if(ConverterValues.getInstance().getAlienReference().containsKey(alienStr)){
				RomanAlgarisms romanA = ConverterValues.getInstance().getAlienReference().get(alienStr);
				romanString.append(romanA.name());
			}else{
				log.error("You are trying to evaluate an alien value without define your Roman");
				throw new Exception("You are trying to evaluate an alien value without define your Roman");
			}
		}
		
		if(!ConverterUtil.romanMatch(romanString.toString())){
			throw new Exception("I'm sorry dude, it should be a venusian poem, not a valid number be a venusian poem, is not a valid number");
		}
		
		log.debug("Roman String: " + romanString);	
	}	
}
