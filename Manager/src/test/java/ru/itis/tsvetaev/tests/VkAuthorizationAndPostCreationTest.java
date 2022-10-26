package ru.itis.tsvetaev.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.itis.tsvetaev.basic.VkTestBase;
import ru.itis.tsvetaev.models.PostData;
import ru.itis.tsvetaev.models.UserData;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VkAuthorizationAndPostCreationTest extends VkTestBase {
    private static final UserData user = new UserData("", "");
    private static final PostData post = new PostData("Плюс 2 или минус 2?");

    @Test
    public void authorizationTestCase() throws Exception {
        applicationManager.getNavigationHelper().openVkPage();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getHelperBase().sleep(10);
    }

    @Test
    public void postCreationTestCase() throws Exception {
        applicationManager.getNavigationHelper().openVkPage();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getHelperBase().sleep(3);
        applicationManager.getNavigationHelper().openProfilePage();
        applicationManager.getPostHelper().createPost(post);
        applicationManager.getHelperBase().sleep(20);
    }
}
