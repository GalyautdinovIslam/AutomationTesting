package ru.itis.tsvetaev.basic;

import org.junit.Before;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.config.Settings;
import ru.itis.tsvetaev.models.UserData;

public class VkAuthBase extends VkTestBase {
    protected static final UserData user = new UserData(
            Settings.getLogin(),
            Settings.getPassword(),
            Settings.getPath()
    );

    @Before
    public void setUp() throws InterruptedException {
        applicationManager = ApplicationManager.getInstance();
        applicationManager.getNavigationHelper().openVkPage();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getHelperBase().sleep(3);
        applicationManager.getNavigationHelper().openProfilePage();
    }
}
