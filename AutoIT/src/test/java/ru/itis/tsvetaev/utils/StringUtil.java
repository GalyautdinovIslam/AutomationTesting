package ru.itis.tsvetaev.utils;

import ru.itis.tsvetaev.config.Settings;

public class StringUtil {
    public static String getRandomString(int minLength, int maxLength, char[] alphabet) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < Math.round(Math.random() * (maxLength - minLength)) + minLength; j++) {
            stringBuilder.append(alphabet[(int) Math.round(Math.random() * (alphabet.length - 1))]);
        }
        return stringBuilder.toString().trim();
    }

    public static String getRandomString(int minLength, int maxLength) {
        String alphabet = Settings.getAlphabet();
        char[] chars = alphabet.toCharArray();
        return getRandomString(minLength, maxLength, chars);
    }
}
