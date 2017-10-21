package com.lgx.test.common;

/**
 * Created by Harry on 2017/8/8.
 */

public class CommonUtils {
    public static double getRate(int position){
        double value = 4.9f;
        switch (position) {
            case 0:
                value = value * 0.7;
                return value;
            case 1:
                value = value * 0.75;
                return value;
            case 2:
                value = value * 0.8;
                return value;
            case 3:
                value = value * 0.85;
                return value;
            case 4:
                value = value * 0.9;
                return value;
            case 5:
                value = value * 0.95;
                return value;
            case 6:
                value = value * 1;
                return value;
            case 7:
                value = value * 1.1;
                return value;
            case 8:
                value = value * 1.2;
                return value;
            case 9:
                value = value * 1.3;
                return value;
            default:
                return value;
        }
    }
}
