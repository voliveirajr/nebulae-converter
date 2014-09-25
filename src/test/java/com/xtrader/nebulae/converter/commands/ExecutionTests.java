package com.xtrader.nebulae.converter.commands;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.xtrader.nebulae.converter.ConverterValues;
import com.xtrader.nebulae.converter.enums.Material;
import com.xtrader.nebulae.converter.enums.RomanAlgarisms;
import com.xtrader.nebulae.converter.util.ConverterUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ConverterUtil.class)
public class ExecutionTests {
	
	@Test
	public void definitionExecuteTest() throws Exception{
	    DefinitionCmd cmf = new DefinitionCmd("pish is X");
	    Assert.assertEquals("",cmf.execute());
	    
	    Assert.assertEquals(RomanAlgarisms.X, ConverterValues.getInstance().getAlienReference().get("pish"));
	}
	
	@Test
	public void materialsExecuteTest() throws Exception{
		PowerMockito.mockStatic(ConverterUtil.class);
	    Mockito.when(ConverterUtil.toRoman(new String[]{"glob"})).thenReturn("II");
	    Mockito.when(ConverterUtil.romanToDecimal("II")).thenReturn(2);
	    MaterialValueCmd cmf = new MaterialValueCmd("glob Silver is 10 Credits");
	    cmf.execute();
	    
	    Assert.assertEquals(5f, ConverterValues.getInstance().getMaterialValue().get(Material.SILVER),0);	    
	}
	
	@Test
	public void conversionExecuteTest() throws Exception{
		PowerMockito.mockStatic(ConverterUtil.class);
	    Mockito.when(ConverterUtil.toRoman(new String[]{"glob"})).thenReturn("II");
	    Mockito.when(ConverterUtil.romanToDecimal("II")).thenReturn(2);
	    ConversionCmd cmf = new ConversionCmd("how much is glob ?");
	    Assert.assertEquals("glob is 2", cmf.execute());
	}
	
	@Test
	public void cotationExecuteTest() throws Exception{
		PowerMockito.mockStatic(ConverterUtil.class);
	    Mockito.when(ConverterUtil.toRoman(new String[]{"glob"})).thenReturn("II");
	    Mockito.when(ConverterUtil.romanToDecimal("II")).thenReturn(2);
	    ConverterValues.getInstance().getMaterialValue().put(Material.SILVER, 2f);
	    CotationCmd cmf = new CotationCmd("how many Credits is glob prok Silver ?");
	    Assert.assertEquals("glob Silver is 4.00 Credits", cmf.execute());
	}

}
