package ru.itis.tsvetaev.basic;

import org.junit.After;
import org.junit.Before;
import ru.itis.tsvetaev.ApplicationManager;

public class VkTestBase {
    protected ApplicationManager applicationManager;

    /**
     * Инициализация WebDriver'а через ApplicationManager
     */
    @Before
    public void setUp() {
        applicationManager = new ApplicationManager();
    }

    /**
     * Закрытие WebDriver'а через ApplicationManager
     */
    @After
    public void tearDown() {
        applicationManager.stop();
    }
}
