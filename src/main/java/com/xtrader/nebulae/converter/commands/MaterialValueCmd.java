package com.xtrader.nebulae.converter.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.log4j.Log4j;

import org.apache.commons.lang3.NotImplementedException;

import com.xtrader.nebulae.converter.enums.Material;
import com.xtrader.nebulae.converter.util.ConverterUtil;
@Log4j
public class MaterialValueCmd extends ConverterCommand{

	public MaterialValueCmd(String commandStr) throws Exception {
		super(commandStr);
	}
	
	String romanValue;
	Integer credits;
	Material material;

	@Override
	public String execute() {
		throw new NotImplementedException("TODO");
	}

	@Override
	public void parse(String commandStr) throws Exception {
		//"(.{1,}) (Silver|Gold|Iron) is \\d+ Credits$"
		
		String[] values = commandStr.split(" (Silver|Gold|Iron) ");
		romanValue = ConverterUtil.toRoman(values[0].split(" "));
		log.debug("Found Roman value: "+romanValue);
		
		Pattern p = Pattern.compile("(Silver|Gold|Iron)");
		Matcher m = p.matcher(commandStr);
		if(m.find()){
			material = Material.valueOf(m.group().toUpperCase());
			log.debug("Found Material: "+material);
		}
		
		p = Pattern.compile("\\d+");
		m = p.matcher(commandStr);
		if(m.find()){
			credits = new Integer(m.group());
			log.debug("Found Credits: "+credits);
		}		
	}
}
