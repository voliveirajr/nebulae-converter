package com.xtrader.nebulae.converter.commands;

import org.apache.commons.lang3.NotImplementedException;

public class MaterialValueCmd extends ConverterCommand{

	public MaterialValueCmd(String commandStr) throws Exception {
		super(commandStr);
	}

	@Override
	public String execute() {
		throw new NotImplementedException("TODO");
	}

	@Override
	public void parse(String commandStr) {
		//"(.{1,}) (Silver|Gold|Iron) is \\d+ Credits$"
		// TODO Auto-generated method stub
		throw new NotImplementedException("TODO");
	}

}
