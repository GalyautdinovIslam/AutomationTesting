package ru.itis.tsvetaev.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;
import ru.itis.tsvetaev.ApplicationManager;

public class NotepadHelperBase {
    protected static final String EDITOR_ID = "15";

    protected ApplicationManager applicationManager;
    protected WiniumDriver driver;

    public NotepadHelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    public void clearAll() {
        driver.findElement(By.id(EDITOR_ID)).clear();
    }
}
