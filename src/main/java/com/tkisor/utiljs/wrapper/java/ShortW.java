package com.tkisor.utiljs.wrapper.java;

public class ShortW {
    private ShortW() {}

    public static Short of(String s) {
        if (!s.matches("-?\\d+(\\.\\d+)?")) {
            throw new NumberFormatException("Invalid number format: " + s);
        }

        int dotIndex = s.indexOf('.');
        if (dotIndex != -1) {
            s = s.substring(0, dotIndex);
        }

        return Short.valueOf(s);
    }
}
