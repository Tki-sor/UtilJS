package com.tkisor.utiljs.wrapper.java;

public class BooleanW {
    private BooleanW() {}

    public static Boolean of(String s) {
        if (s.equals("1")) {
            return true;
        } else if (s.equals("0")) {
            return false;
        }
        return Boolean.valueOf(s);
    }
}
