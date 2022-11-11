package ru.itis.tsvetaev;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itis.tsvetaev.basic.VkHelperBase;
import ru.itis.tsvetaev.helpers.LoginHelper;
import ru.itis.tsvetaev.helpers.NavigationHelper;
import ru.itis.tsvetaev.helpers.PostHelper;
import ru.itis.tsvetaev.utils.DestructorUtil;

import java.time.Duration;

public class ApplicationManager {
    public static final String BASE_URL = "https://vk.com/";
    public static final Duration TIMEOUT = Duration.ofSeconds(3);

    private static final Logger log = LoggerFactory.getLogger(ApplicationManager.class);
    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "C:\\chromedriver.exe";

    private final WebDriver driver;
    private final StringBuffer verificationErrors;
    private final JavascriptExecutor js;

    private final VkHelperBase helperBase;
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;
    private final PostHelper postHelper;

    private static final ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<>();

    private ApplicationManager() {
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        js = (JavascriptExecutor) driver;
        verificationErrors = new StringBuffer();

        helperBase = new VkHelperBase(this);
        navigationHelper = new NavigationHelper(this, BASE_URL);
        loginHelper = new LoginHelper(this);
        postHelper = new PostHelper(this);

        Thread destructorHook = DestructorUtil.addManagerDestructor(this);
        log.info("Destructor-thread-hook is a " + destructorHook);
    }

    public static ApplicationManager getInstance() {
        if (applicationManagerThreadLocal.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            applicationManagerThreadLocal.set(newInstance);
        }
        return applicationManagerThreadLocal.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
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
