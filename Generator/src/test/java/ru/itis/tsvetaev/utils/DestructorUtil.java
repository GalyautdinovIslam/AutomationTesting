package ru.itis.tsvetaev.utils;

import org.junit.Assert;
import ru.itis.tsvetaev.ApplicationManager;

public final class DestructorUtil {
    public static Thread addDestructor(Runnable runnable) {
        Thread hook = new Thread(runnable);
        Runtime.getRuntime().addShutdownHook(hook);
        return hook;
    }

    public static Thread addManagerDestructor(ApplicationManager applicationManager) {
        return addDestructor(() -> {
            try {
                applicationManager.getDriver().quit();
            } catch (Exception ignored) {
            } finally {
                String verificationErrorString = applicationManager.getVerificationErrors().toString();
                if (!verificationErrorString.equals("")) {
                    Assert.fail(verificationErrorString);
                }
            }
        });
    }
}
