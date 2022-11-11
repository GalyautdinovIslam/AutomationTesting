package ru.itis.tsvetaev.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.tsvetaev.basic.VkTestBase;

public class VkAuthorizationTest extends VkTestBase {

    @Test
    public void authorizationTestCase() throws Exception {
        applicationManager.getNavigationHelper().openVkPage();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getHelperBase().sleep(3);

        Assert.assertTrue(applicationManager.getLoginHelper().isAuthorized());
        Assert.assertEquals(user.path(), applicationManager.getLoginHelper().getAuthorizedUserPath());
    }
}
