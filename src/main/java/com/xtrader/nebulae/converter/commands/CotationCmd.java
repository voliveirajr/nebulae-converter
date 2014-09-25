package com.xtrader.nebulae.converter.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import com.xtrader.nebulae.converter.ConverterValues;
import com.xtrader.nebulae.converter.enums.Material;
import com.xtrader.nebulae.converter.util.ConverterUtil;
@Log4j
public class CotationCmd extends ConverterCommand{
	
	@Getter @Setter
	Material material;
	@Getter @Setter
	String romanValue;
	@Getter @Setter
	String alienValue;

	public CotationCmd(String commandStr) throws Exception {
		super(commandStr);
	}

	@Override
	public String execute() {
		
		Float unitValue = ConverterValues.getInstance().getMaterialValue().get(material);
		if(unitValue == null){
			String err = "At the moment we dont have defined yet the "+material+" value";
			log.error(err);
			return err;
		}
		int amount = ConverterUtil.romanToDecimal(romanValue);
		
		Float amountValue = amount*unitValue;
		
		return String.format("%s %s is %.2f Credits", alienValue, material.name(), amountValue);

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
		
		alienValue = commandStr.replace("how many Credits is ", "").split("(Silver|Gold|Iron)")[0];
		log.debug("Found alien value: "+alienValue);
		romanValue = ConverterUtil.toRoman(alienValue.split(" "));
		log.debug("Found roman value: "+romanValue);
		
	}
	

}
