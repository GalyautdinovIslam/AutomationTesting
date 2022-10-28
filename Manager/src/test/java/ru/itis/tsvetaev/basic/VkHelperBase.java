package ru.itis.tsvetaev.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.itis.tsvetaev.ApplicationManager;

public class VkHelperBase {
    protected ApplicationManager applicationManager;
    protected WebDriver driver;
    protected boolean acceptNextAlert = true;

    public VkHelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    public void sleep(long seconds) throws InterruptedException {
        Thread.sleep(1000 * seconds);
    }

    protected void sendEscapeKey() {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException exception) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() throws NoAlertPresentException {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) alert.accept();
            else alert.dismiss();
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
