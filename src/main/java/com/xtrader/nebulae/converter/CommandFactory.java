package com.xtrader.nebulae.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.log4j.Log4j;

import com.xtrader.nebulae.converter.commands.ConverterCommand;
import com.xtrader.nebulae.converter.enums.CommandTypes;

@Log4j
public class CommandFactory {
	
	public static ConverterCommand parseCommand(String str) throws InstantiationException, IllegalAccessException{
		for (CommandTypes commandType : CommandTypes.values()) {
			Pattern p = Pattern.compile(commandType.getPattern());
			Matcher m = p.matcher(str);
			if (m.matches()) {
				log.debug("["+str+"] is a command");
				return commandType.getInstance();
			}									
		}
		log.debug("["+str+"] is not a command");
		return null;
	}
}
