package com.thuss.fsa.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DoubleUtil {
    public static double double1bit(Double d){
        NumberFormat   nf=new  DecimalFormat( "0.0 "); 
        return Double.parseDouble(nf.format(d));
    }
}
