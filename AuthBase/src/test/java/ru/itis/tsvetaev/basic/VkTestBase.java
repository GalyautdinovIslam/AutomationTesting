package ru.itis.tsvetaev.basic;

import org.junit.Before;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.models.PostData;
import ru.itis.tsvetaev.models.UserData;

public class VkTestBase {

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() throws InterruptedException {
        applicationManager = ApplicationManager.getInstance();
    }
}
