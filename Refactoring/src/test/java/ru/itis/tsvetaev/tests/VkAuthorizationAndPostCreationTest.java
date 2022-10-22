package ru.itis.tsvetaev.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.itis.tsvetaev.basic.VkTestBase;
import ru.itis.tsvetaev.data.PostData;
import ru.itis.tsvetaev.data.UserData;

// Аннотация необязательна, использую для удобного мне порядка тестов.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VkAuthorizationAndPostCreationTest extends VkTestBase {
    private static final UserData user = new UserData("", "");
    private static final PostData post = new PostData("Купил мужик шляпу, а она ему как раз!");

    @Test
    public void authorizationTestCase() throws Exception {
        openVkPage();
        login(user);
        sleep(10);
    }

    @Test
    public void postCreationTestCase() throws Exception {
        openVkPage();
        login(user);
        sleep(3);
        openProfilePage();
        createPost(post);
        sleep(20);
    }
}
