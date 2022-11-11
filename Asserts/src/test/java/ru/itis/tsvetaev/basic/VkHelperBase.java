package ru.itis.tsvetaev.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.itis.tsvetaev.ApplicationManager;

public class VkHelperBase {
    protected static final int SLEEP_DURATION = 3;

    protected ApplicationManager applicationManager;
    protected WebDriver driver;
    protected JavascriptExecutor js;

    public VkHelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
        this.js = applicationManager.getJs();
    }

    public void sleep(long seconds) throws InterruptedException {
        Thread.sleep(1000 * seconds);
    }

    protected void sendEscapeKey() {
        new Actions(driver)
                .sendKeys(Keys.ESCAPE)
                .perform();
    }

    protected void moveToWebElement(WebElement webElement) {
        new Actions(driver).moveToElement(webElement).perform();
    }

    protected void scrollToWebElement(WebElement webElement) {
        new Actions(driver).scrollToElement(webElement).perform();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
