package com.xtrader.nebulae.converter;

import java.util.HashMap;

import lombok.Getter;

import com.xtrader.nebulae.converter.enums.Material;
import com.xtrader.nebulae.converter.enums.RomanAlgarisms;

public class ConverterValues {
    private static ConverterValues instance = null;
    
    @Getter
    HashMap<Material, Float> materialValue;
    @Getter
    HashMap<String, RomanAlgarisms> alienReference; 
    
    public static synchronized ConverterValues getInstance() {
        if (instance == null) {
            instance = new ConverterValues();
        }
        return instance;
    }
}
