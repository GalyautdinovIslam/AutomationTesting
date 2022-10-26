package ru.itis.tsvetaev;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.tsvetaev.basic.VkHelperBase;
import ru.itis.tsvetaev.helpers.LoginHelper;
import ru.itis.tsvetaev.helpers.NavigationHelper;
import ru.itis.tsvetaev.helpers.PostHelper;

import java.time.Duration;

public class ApplicationManager {
    public static final String BASE_URL = "https://vk.com/";
    public static final Duration TIMEOUT = Duration.ofSeconds(3);

    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "C:\\chromedriver.exe";

    private final WebDriver driver;
    private final StringBuffer verificationErrors;

    private final VkHelperBase helperBase;
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;
    private final PostHelper postHelper;

    public ApplicationManager() {
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        verificationErrors = new StringBuffer();

        helperBase = new VkHelperBase(this);
        navigationHelper = new NavigationHelper(this, BASE_URL);
        loginHelper = new LoginHelper(this);
        postHelper = new PostHelper(this);
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!verificationErrorString.equals("")) {
            Assert.fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public VkHelperBase getHelperBase() {
        return helperBase;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public PostHelper getPostHelper() {
        return postHelper;
    }
}
