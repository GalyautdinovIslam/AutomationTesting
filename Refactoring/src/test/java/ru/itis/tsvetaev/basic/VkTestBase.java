package ru.itis.tsvetaev.basic;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import ru.itis.tsvetaev.data.PostData;
import ru.itis.tsvetaev.data.UserData;

import java.time.Duration;

public class VkTestBase {
    public static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "C:\\chromedriver.exe";
    public static final Duration TIMEOUT = Duration.ofSeconds(3);

    protected WebDriver driver;
    protected JavascriptExecutor js;

    /**
     * Открывает WebDriver с заданными настройками, указывая возможность использовать JavaScript.
     * Данный метод вызывается перед каждым методом, помеченным аннотацией @Test.
     */
    @Before
    public void setUp() {
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        js = (JavascriptExecutor) driver;
    }

    /**
     * Закрывает WebDriver, закрывая все связанные с ним окна.
     * Данный метод вызывается после каждого метода, помеченного аннотацией @Test.
     */
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Ожидание загрузки окна
     *
     * @param seconds Длительность ожидания (в секундах)
     * @throws InterruptedException Если данный поток был прерван во время выполнения метода
     */
    protected void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    /**
     * Открытие сайта vk.com и нажатие клавиши Escape
     *
     * @throws InterruptedException Если данный поток был прерван во время ожидания загрузки vk.com
     */
    protected void openVkPage() throws InterruptedException {
        driver.get("https://vk.com/");
        sleep(3);
        sendEscapeKey();
    }

    /**
     * Открытие профиля авторизированного пользователя и нажатие клавиши Escape
     *
     * @throws InterruptedException Если данный поток был прерван во время ожидания загрузки страницы пользователя
     */
    protected void openProfilePage() throws InterruptedException {
        openVkPage();
        driver.findElement(By.xpath("//li[@id='l_pr']/a")).click();
        sleep(3);
        sendEscapeKey();
    }

    /**
     * Авторизация пользователя на сайте vk.com
     *
     * @param user Класс, хранящий в себе логин и пароль пользователя
     * @throws InterruptedException Если данный поток был прерван во время ожидания загрузки страниц ввода пароля или новостей
     */
    protected void login(UserData user) throws InterruptedException {
        driver.findElement(By.id("index_email")).click();
        driver.findElement(By.id("index_email")).clear();
        driver.findElement(By.id("index_email")).sendKeys(user.login());
        driver.findElement(By.xpath("//div[@id='index_login']/div/form/button")).click();

        sleep(3);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(user.password());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div/form/div[2]/button")).click();

        sleep(3);
    }

    /**
     * Создание записи на стене пользователя
     *
     * @param post Класс, хранящий в себе содержимое публикуемого поста
     */
    protected void createPost(PostData post) {
        driver.findElement(By.id("post_field")).click();
        driver.findElement(By.id("post_field")).clear();
        driver.findElement(By.id("post_field")).sendKeys(post.content());
        driver.findElement(By.xpath("//button[@id='send_post']")).click();
    }

    /**
     * Производит нажатие и отжатие клавиши Escape
     */
    private void sendEscapeKey() {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }
}
