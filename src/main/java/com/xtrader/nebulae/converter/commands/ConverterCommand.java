package com.xtrader.nebulae.converter.commands;


public abstract class ConverterCommand{
	
	public ConverterCommand(String commandStr) throws Exception{
		parse(commandStr);
	}
	
	public abstract String execute();
	
	public abstract void parse(String commandStr) throws Exception;

}
