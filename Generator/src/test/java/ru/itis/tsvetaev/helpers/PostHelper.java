package ru.itis.tsvetaev.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.basic.VkHelperBase;
import ru.itis.tsvetaev.models.PostData;

public class PostHelper extends VkHelperBase {

    public PostHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createPost(PostData post) {
        driver.findElement(By.id("post_field")).click();
        driver.findElement(By.id("post_field")).clear();
        driver.findElement(By.id("post_field")).sendKeys(post.content());
        driver.findElement(By.xpath("//button[@id='send_post']")).click();
        scrollToLastPost();
    }

    public PostData getLastPost() {
        WebElement postWebElement = driver.findElement(By.xpath("//div[@id='page_wall_posts']/div[1]"));
        long time = Long.parseLong(
                postWebElement.findElement(
                        By.xpath("//a[@class='post_link']/span")
                ).getAttribute("time")
        );
        String postContent = postWebElement.findElement(
                By.xpath("//div[@class='wall_text']/div/div")
        ).getText();
        return new PostData(postContent, time);
    }

    public void deleteLastPost() {
        WebElement postWebElement = driver.findElement(
                By.xpath("//div[@id='page_wall_posts']/div[1]")
        );
        scrollToWebElement(postWebElement);
        WebElement postActionsWebElement = postWebElement.findElement(
                By.xpath("//div[@class='PostHeaderActionsUiActionMenu']/div")
        );
        moveToWebElement(postActionsWebElement);
        postWebElement.findElement(By.linkText("Удалить запись")).click();
    }

    public boolean isLastPostDeleted() {
        try {
            driver.findElement(
                    By.xpath("//div[@id='page_wall_posts']/div[1]/div[2]/span[@class='dld_inner']")
            );
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    private void scrollToLastPost() {
        scrollToWebElement(driver.findElement(
                By.xpath("//div[@id='page_wall_posts']/div[1]")
        ));
    }
}
