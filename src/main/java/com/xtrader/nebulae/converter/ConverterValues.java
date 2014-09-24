package com.xtrader.nebulae.converter;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

import com.xtrader.nebulae.converter.enums.Material;
import com.xtrader.nebulae.converter.enums.RomanAlgarisms;

public class ConverterValues {
    private static ConverterValues instance = null;
    
    @Getter @Setter
    private HashMap<Material, Float> materialValue = new HashMap<Material, Float>(0);
    @Getter @Setter
    private HashMap<String, RomanAlgarisms> alienReference = new HashMap<String, RomanAlgarisms>(0);
    
    public static synchronized ConverterValues getInstance() {
        if (instance == null) {
            instance = new ConverterValues();
        }
        return instance;
    }
}
