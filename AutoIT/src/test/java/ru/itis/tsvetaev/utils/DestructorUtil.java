package ru.itis.tsvetaev.utils;

import ru.itis.tsvetaev.ApplicationManager;

public class DestructorUtil {
    public static void addDestructor(Runnable runnable) {
        Thread hook = new Thread(runnable);
        Runtime.getRuntime().addShutdownHook(hook);
    }

    public static void addManagerDestructor(ApplicationManager applicationManager) {
        addDestructor(() -> {
            try {
                applicationManager.getWriterHelper().clearAll();
                applicationManager.getDriver().close();
            } catch (Exception ignored) {
            }
        });
    }
}
