package ru.itis.tsvetaev.helpers;

import org.openqa.selenium.By;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.basic.VkHelperBase;
import ru.itis.tsvetaev.models.UserData;


public class LoginHelper extends VkHelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    /**
     * Авторизация на сайте vk.com
     *
     * @param user Класс, хранящий в себе данные для авторизации
     * @throws InterruptedException Если поток выполнения был прерван во время ожидания загрузки окна
     */
    public void login(UserData user) throws InterruptedException {
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
}
