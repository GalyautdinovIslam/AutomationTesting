package ru.itis.tsvetaev.helpers;

import org.openqa.selenium.By;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.basic.VkHelperBase;
import ru.itis.tsvetaev.models.PostData;

public class PostHelper extends VkHelperBase {

    public PostHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    /**
     * Создание поста на открытой странице пользователя
     *
     * @param post Класс, хранящий в себе информацию для создания поста
     */
    public void createPost(PostData post) {
        driver.findElement(By.id("post_field")).click();
        driver.findElement(By.id("post_field")).clear();
        driver.findElement(By.id("post_field")).sendKeys(post.content());
        driver.findElement(By.xpath("//button[@id='send_post']")).click();
    }
}
