package ru.itis.tsvetaev.helpers;

import org.openqa.selenium.By;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.basic.VkHelperBase;

public class NavigationHelper extends VkHelperBase {
    private final String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openVkPage() throws InterruptedException {
        driver.get(baseUrl);
        sleep(3);
        sendEscapeKey();
    }

    public void openProfilePage() throws InterruptedException {
        openVkPage();
        driver.findElement(By.xpath("//li[@id='l_pr']/a")).click();
        sleep(3);
        sendEscapeKey();
    }
}
