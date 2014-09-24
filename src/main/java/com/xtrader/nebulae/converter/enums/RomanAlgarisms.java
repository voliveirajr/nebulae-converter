package com.xtrader.nebulae.converter.enums;

public enum RomanAlgarisms {
	
	I(1),
	V(5),
	X(10),
	L(50),
	C(100),
	D(500),
	M(1000);
	
	private int decimal;
	
	private RomanAlgarisms(int decimal){
		this.decimal = decimal;		
	}
	
	public int getDecimal(){
		return decimal;
	}
}
