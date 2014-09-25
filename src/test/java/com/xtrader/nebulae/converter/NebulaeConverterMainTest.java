package com.xtrader.nebulae.converter;

import java.net.URL;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import com.xtrader.nebulae.converter.enums.Material;
import com.xtrader.nebulae.converter.enums.RomanAlgarisms;
public class NebulaeConverterMainTest {
	
	@Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	@Before
	public void cleanupValues(){
		ConverterValues.getInstance().setMaterialValue(new HashMap<Material, Float>(0));
		ConverterValues.getInstance().setAlienReference(new HashMap<String, RomanAlgarisms>(0));
	}
	
	@Test
	public void testMainValidInput(){
		URL url = getClass().getResource("/input.txt");		
		NebulaeConverterMain.main(new String[]{url.getFile()});		
	}
	
	@Test(expected=Exception.class)
	public void testMainInValidInput1(){
		exit.expectSystemExitWithStatus(1);
		URL url = getClass().getResource("/inputInvalid1.txt");		
		NebulaeConverterMain.main(new String[]{url.getFile()});		
	}	
	
}
