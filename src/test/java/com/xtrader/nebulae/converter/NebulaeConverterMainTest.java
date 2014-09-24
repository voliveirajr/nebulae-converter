package com.xtrader.nebulae.converter;

import java.net.URL;

import org.junit.Test;

public class NebulaeConverterMainTest {
	
	@Test
	public void testMainValidInput(){
		URL url = getClass().getResource("/input.txt");		
		NebulaeConverterMain.main(new String[]{url.getFile()});		
	}
	
	@Test
	public void testMainInValidInput1(){
		URL url = getClass().getResource("/inputInvalid1.txt");		
		NebulaeConverterMain.main(new String[]{url.getFile()});		
	}
	
	@Test
	public void testMainInValidInput2(){
		URL url = getClass().getResource("/inputInvalid2.txt");		
		NebulaeConverterMain.main(new String[]{url.getFile()});		
	}
	
}
