package com.xtrader.nebulae.converter.enums;

import com.xtrader.nebulae.converter.commands.ConversionCmd;
import com.xtrader.nebulae.converter.commands.ConverterCommand;
import com.xtrader.nebulae.converter.commands.CotationCmd;
import com.xtrader.nebulae.converter.commands.DefinitionCmd;
import com.xtrader.nebulae.converter.commands.MaterialValueCmd;

public enum CommandTypes {
	
	DEFINE("(.{1,}) is (I|V|X|L|C|D|M)$", DefinitionCmd.class),
	COTATION("(.{1,}) (Silver|Gold|Iron) is \\d+ Credits$", CotationCmd.class),
	MATERIAL_VALUE("how many Credits is (.{1,}) (Silver|Gold|Iron) \\?$", MaterialValueCmd.class),
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
	
	public ConverterCommand getInstance() throws InstantiationException, IllegalAccessException{
		return clazz.newInstance();
	}
}
