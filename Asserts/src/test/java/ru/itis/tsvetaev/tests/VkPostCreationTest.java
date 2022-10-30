package ru.itis.tsvetaev.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.tsvetaev.basic.VkTestBase;
import ru.itis.tsvetaev.models.PostData;

public class VkPostCreationTest extends VkTestBase {

    @Test
    public void postCreationTestCase() throws Exception {
        applicationManager.getLoginHelper().login(user);
        applicationManager.getNavigationHelper().openProfilePage();
        applicationManager.getPostHelper().createPost(post);
        applicationManager.getHelperBase().sleep(3);

        PostData createdPost = applicationManager.getPostHelper().getLastPost();
        Assert.assertEquals(post.content(), createdPost.content());
        Assert.assertTrue(System.currentTimeMillis() / 1000 - createdPost.time() < 10);

        applicationManager.getLoginHelper().logout();
    }
}
