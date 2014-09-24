package com.xtrader.nebulae.converter.commands;

import lombok.extern.log4j.Log4j;

import org.apache.commons.lang3.StringUtils;

import com.xtrader.nebulae.converter.ConverterValues;
import com.xtrader.nebulae.converter.enums.RomanAlgarisms;

@Log4j
public class DefinitionCmd extends ConverterCommand {
	
	public DefinitionCmd(String commandStr) throws Exception {
		super(commandStr);
	}

	String alien;
	RomanAlgarisms roman;

	@Override
	public String execute(){		
		if (roman != null && StringUtils.isNotEmpty(alien)) {
			ConverterValues.getInstance().getAlienReference().put(alien, roman);
			log.debug(alien + " defined as " + roman);
			return "";
		} else {
			String err = "you are executing a Define command without required values";
			log.error(err);
			return err;			
		}
	}

	@Override
	public void parse(String commandStr) throws Exception {
		// Glob is X
		String[] values = commandStr.split(" is ");

		try {
			RomanAlgarisms.valueOf(values[1]);
		} catch (IllegalArgumentException e) {
			log.error(values[1] + ": this is not a valid roman character");
			throw new Exception(values[1] + ": this is not a valid roman character");
		}
		alien  = values[0];
		roman = RomanAlgarisms.valueOf(values[1]);
		log.debug("["+commandStr+"] definition command parsed, waiting for execution");		
	}

}
