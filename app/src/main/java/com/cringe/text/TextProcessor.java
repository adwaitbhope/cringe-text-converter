package com.cringe.text;

public class TextProcessor {

    public static String convertText(String originalText) {
        char[] split_conv = new char[originalText.length()];

        boolean isCap = false;
        for (int i = 0; i < originalText.length(); i++) {
            char currentChar = Character.toLowerCase(originalText.charAt(i));
            char replacedChar;

            switch (currentChar) {
                case 'i':
                    replacedChar = 'i';
                    break;
                case 'l':
                case 't':
                    replacedChar = Character.toUpperCase(currentChar);
                    break;
                default:
                    if (isCap) {
                        replacedChar = Character.toUpperCase(currentChar);
                        isCap = false;
                    }
                    else {
                        replacedChar = Character.toLowerCase(currentChar);
                        isCap = true;
                    }
            }
            split_conv[i] = replacedChar;
        }

        return new String(split_conv);
    }
}
