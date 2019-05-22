package com.zhcw.pay.utils.CommUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumUtils {
    public static String number(String num) {
        DecimalFormat format = new DecimalFormat("0.00");
        String a = format.format(new BigDecimal(num));
        return a ;
    }

}
