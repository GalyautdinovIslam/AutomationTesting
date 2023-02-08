package ru.itis.tsvetaev.basic;

import org.junit.Before;
import ru.itis.tsvetaev.ApplicationManager;

import java.net.MalformedURLException;

public class NotepadTestBase {

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        applicationManager = ApplicationManager.getInstance();
    }
}
