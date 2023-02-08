package ru.itis.tsvetaev.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Settings {
    public static String file = "C:/Users/galya/OneDrive/Рабочий стол/AutoIT/config/Settings.xml";

    private static final Properties properties;
    private static String notepad;
    private static String localhost;
    private static String alphabet;

    static {
        try (FileInputStream fis = new FileInputStream(file)) {
            properties = new Properties();
            properties.loadFromXML(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getNotepad() {
        if (notepad == null) {
            notepad = properties.getProperty("Notepad");
        }
        return notepad;
    }

    public static String getLocalhost() {
        if (localhost == null) {
            localhost = properties.getProperty("Localhost");
        }
        return localhost;
    }

    public static String getAlphabet() {
        if (alphabet == null) {
            alphabet = properties.getProperty("Alphabet");
        }
        return alphabet;
    }
}
