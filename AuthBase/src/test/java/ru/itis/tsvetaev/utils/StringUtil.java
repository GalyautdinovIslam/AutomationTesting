package ru.itis.tsvetaev.utils;

public class StringUtil {
    public static String getRandomString(int minWord, int maxWord, int minLength, int maxLength, char[] alphabet) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.round(Math.random() * (maxWord - minWord)) + minWord; i++) {
            for (int j = 0; j < Math.round(Math.random() * (maxLength - minLength)) + minLength; j++) {
                stringBuilder.append(alphabet[(int) Math.round(Math.random() * (alphabet.length - 1))]);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static String getRandomString(int minWord, int maxWord, int minLength, int maxLength) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnmйцукенгшщзхъфывапролджэячсмитьбюё";
        alphabet = alphabet + alphabet.toUpperCase();
        char[] chars = alphabet.toCharArray();
        return getRandomString(minWord, maxWord, minLength, maxLength, chars);
    }

    public static String getRandomPhoneNumber() {
        String alphabet = "0123456789";
        char[] chars = alphabet.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("37122");
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(chars[(int) Math.round(Math.random() * (chars.length - 1))]);
        }
        return stringBuilder.toString();
    }

    public static String getRandomPath() {
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        char[] chars = alphabet.toCharArray();
        return "/" + getRandomString(1, 1, 6, 20, chars);
    }
}
