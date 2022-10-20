package ru.itis.tsvetaev;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VkAuthorizationTest {
    private static final String VK_LOGIN = "";
    private static final String VK_PASSWORD = "";

    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void authorizationTestCase() throws Exception {
        // Открывает сайт vk.com
        driver.get("https://vk.com/");

        // Кликаем по полю ввода логина, отчищаем его, вводим свой логин и нажимаем на кнопку
        driver.findElement(By.id("index_email")).click();
        driver.findElement(By.id("index_email")).clear();
        driver.findElement(By.id("index_email")).sendKeys(VK_LOGIN);
        driver.findElement(By.xpath("//div[@id='index_login']/div/form/button")).click();

        // Ждём загрузки окна
        Thread.sleep(3000);

        // Отчищаем поле ввода пароля, вводим свой пароль и нажимаем на кнопку
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(VK_PASSWORD);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div/form/div[2]/button")).click();

        // Ждём завершения авторизации (для наглядной видимости)
        Thread.sleep(20000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
