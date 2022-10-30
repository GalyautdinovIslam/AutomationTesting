package ru.itis.tsvetaev.helpers;

import org.openqa.selenium.By;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.basic.VkHelperBase;
import ru.itis.tsvetaev.models.UserData;

public class LoginHelper extends VkHelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(UserData user) throws InterruptedException {
        driver.findElement(By.id("index_email")).click();
        driver.findElement(By.id("index_email")).clear();
        driver.findElement(By.id("index_email")).sendKeys(user.login());
        driver.findElement(By.xpath("//div[@id='index_login']/div/form/button")).click();

        sleep(3);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(user.password());
        driver.findElement(By.xpath(
                "//*[@id='root']/div/div/div/div/div/div/div/div/form/div[2]/button"
        )).click();

        sleep(3);
    }

    public void logout() throws InterruptedException {
        driver.findElement(By.id("top_profile_link")).click();
        driver.findElement(By.xpath("//a[@id='top_logout_link']")).click();
        sleep(3);
    }

    public boolean isAuthorized() {
        return isElementPresent(By.xpath("//li[@id='l_pr']/a"));
    }

    public String getAuthorizedUserPath() {
        if (!isAuthorized()) return null;

        String path = driver.findElement(By.xpath("//li[@id='l_pr']/a")).getAttribute("href");
        path = path.substring(path.lastIndexOf('/'));

        return path;
    }
}
