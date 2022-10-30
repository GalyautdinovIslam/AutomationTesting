package ru.itis.tsvetaev.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.tsvetaev.basic.VkAuthBase;
import ru.itis.tsvetaev.basic.VkTestBase;

public class VkPostDeletionTest extends VkAuthBase {

    @Test
    public void postDeletionTestCase() throws Exception {
        applicationManager.getPostHelper().deleteLastPost();
        applicationManager.getHelperBase().sleep(5);

        Assert.assertTrue(applicationManager.getPostHelper().isLastPostDeleted());
    }
}
