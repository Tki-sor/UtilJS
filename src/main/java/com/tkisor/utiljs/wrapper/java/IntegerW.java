package com.tkisor.utiljs.wrapper.java;

public class IntegerW {
    private IntegerW() {}

    public static Integer of(String s) {
        if (!s.matches("-?\\d+(\\.\\d+)?")) {
            throw new NumberFormatException("Invalid number format: " + s);
        }

        int dotIndex = s.indexOf('.');
        if (dotIndex != -1) {
            s = s.substring(0, dotIndex);
        }

        return Integer.valueOf(s);
    }
}
