package com.xtrader.nebulae.converter;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.log4j.Log4j;

import com.xtrader.nebulae.converter.commands.ConverterCommand;
import com.xtrader.nebulae.converter.enums.CommandTypes;

@Log4j
public class CommandFactory {
	
	public static ConverterCommand parseCommand(String str) throws Exception {
		for (CommandTypes commandType : CommandTypes.values()) {
			Pattern p = Pattern.compile(commandType.getPattern());
			Matcher m = p.matcher(str);
			if (m.matches()) {
				log.debug("["+str+"] is a command");
				try {
					return commandType.getInstance(str);
				} catch (InstantiationException | IllegalAccessException
						| NoSuchMethodException | SecurityException
						| IllegalArgumentException | InvocationTargetException e) {
					
					log.error("problems while parsing your command");
					throw new Exception("problems while parsing your command", e);
				}
			}									
		}
		log.debug("["+str+"] is not a command");
		return null;
	}
}
