package com.company;

public class MainLogic {

    public static String encryptText(String str, int shift) {
        char[] text = str.toUpperCase().toCharArray();
        for (int i = 0; i < text.length; i++) {
            if (text[i] != ' ') {
                if (text[i] < 91 - shift) {
                    text[i] += shift;
                } else {
                    text[i] = (char) (text[i] - 25 + shift - 1);
                }
            }
        }
        return String.valueOf(text);
    }

    public static String decryptText(String str, int shift) {
        char[] text = str.toUpperCase().toCharArray();
        for (int i = 0; i < text.length; i++) {
            if (text[i] != ' ') {
                if (text[i] > 64 + shift && text[i] != ' ') {
                    text[i] -= shift;
                } else {
                    text[i] = (char) (text[i] + 25 - shift + 1);
                }
            }
        }
        return String.valueOf(text);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
