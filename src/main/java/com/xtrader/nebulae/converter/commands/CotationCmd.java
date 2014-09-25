package com.xtrader.nebulae.converter.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.log4j.Log4j;

import org.apache.commons.lang3.NotImplementedException;

import com.xtrader.nebulae.converter.enums.Material;
@Log4j
public class CotationCmd extends ConverterCommand{
	
	Material material;
	Integer amount;

	public CotationCmd(String commandStr) throws Exception {
		super(commandStr);
	}

	@Override
	public String execute() {
		
		throw new NotImplementedException("TODO");
		
	}

	@Override
	public void parse(String commandStr) throws Exception{
		//"how many Credits is (.{1,}) (Silver|Gold|Iron) \\?$"
		
		Pattern p = Pattern.compile("(Silver|Gold|Iron)");
		Matcher m = p.matcher(commandStr);
		if(m.find()){
			material = Material.valueOf(m.group().toUpperCase());
			log.debug("Found Material: "+material);
		}
		
		p = Pattern.compile("\\d+");
		m = p.matcher(commandStr);
		if(m.find()){
			amount = new Integer(m.group());
			log.debug("Found Amount: "+amount);
		}
	}
	

}
