package ru.itis.tsvetaev.utils;

public class StringUtil {
    public static String getRandomString(int minLength, int maxLength) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnmйцукенгшщзхъфывапролджэячсмитьбюё";
        alphabet = alphabet + alphabet.toUpperCase();
        char[] chars = alphabet.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < Math.round(Math.random() * (maxLength - minLength)) + minLength; j++) {
            stringBuilder.append(chars[(int) Math.round(Math.random() * (chars.length - 1))]);
        }
        return stringBuilder.toString().trim();
    }
}
