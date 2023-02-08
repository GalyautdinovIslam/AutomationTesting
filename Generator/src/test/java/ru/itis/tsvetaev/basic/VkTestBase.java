package ru.itis.tsvetaev.basic;

import org.junit.Before;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.models.UserData;

public class VkTestBase {
    protected static final UserData user = new UserData(
            "",
            "",
            ""
    );

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }
}
