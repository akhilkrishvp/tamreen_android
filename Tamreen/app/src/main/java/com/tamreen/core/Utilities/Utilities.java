package com.tamreen.core.Utilities;

/**
 * Created by diyaa on 10/11/17.
 */

public class Utilities {
    public Utilities() {
    }
    public static String generateNumberSigns(int n) {

        String s = "";
        for (int i = 0; i < n; i++) {
            s += "0";
        }
        return s;
    }

    public static String toEnNumbers(String original) {
        return original.replaceAll("٠", "0")
                .replaceAll("١", "1")
                .replaceAll("٢", "2")
                .replaceAll("٣", "3")
                .replaceAll("٤", "4")
                .replaceAll("٥", "5")
                .replaceAll("٦", "6")
                .replaceAll("٧", "7")
                .replaceAll("٨", "8")
                .replaceAll("٩", "9")
                .replaceAll(",", ",");
    }
}
