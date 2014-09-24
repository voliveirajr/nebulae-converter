package com.xtrader.nebulae.converter.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.xtrader.nebulae.converter.commands.ConversionCmd;
import com.xtrader.nebulae.converter.commands.ConverterCommand;
import com.xtrader.nebulae.converter.commands.CotationCmd;
import com.xtrader.nebulae.converter.commands.DefinitionCmd;
import com.xtrader.nebulae.converter.commands.MaterialValueCmd;

public enum CommandTypes {
	
	DEFINE("(.{1,}) is (I|V|X|L|C|D|M)$", DefinitionCmd.class),
	COTATION("how many Credits is (.{1,}) (Silver|Gold|Iron) \\?$", CotationCmd.class),
	MATERIAL_VALUE("(.{1,}) (Silver|Gold|Iron) is \\d+ Credits$", MaterialValueCmd.class),
	CONVERSION("how much is (.{1,}) \\?$", ConversionCmd.class);
	
	private String pattern;
	private Class<ConverterCommand> clazz;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private CommandTypes(String pattern, Class clazz){
		this.pattern = pattern;
		this.clazz = clazz;
	}
	
	public String getPattern(){
		return pattern;
	}
	
	public ConverterCommand getInstance(String cmdStr) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Constructor<ConverterCommand> constructor = clazz.getConstructor(String.class);
		ConverterCommand cmd = constructor.newInstance(cmdStr);
		return cmd;
	}
}
