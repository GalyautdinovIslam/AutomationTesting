package ru.itis.tsvetaev;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import ru.itis.tsvetaev.basic.NotepadHelperBase;
import ru.itis.tsvetaev.config.Settings;
import ru.itis.tsvetaev.helpers.NotepadReaderHelper;
import ru.itis.tsvetaev.helpers.NotepadWriterHelper;
import ru.itis.tsvetaev.utils.DestructorUtil;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {
    private static final String NOTEPAD = Settings.getNotepad();
    private static final String LOCALHOST = Settings.getLocalhost();

    private final WiniumDriver driver;

    private final NotepadHelperBase helperBase;
    private final NotepadReaderHelper readerHelper;
    private final NotepadWriterHelper writerHelper;

    private static final ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<>();

    private ApplicationManager() throws MalformedURLException, InterruptedException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(NOTEPAD);
        driver = new WiniumDriver(new URL(LOCALHOST), options);
        Thread.sleep(5000);

        helperBase = new NotepadHelperBase(this);
        readerHelper = new NotepadReaderHelper(this);
        writerHelper = new NotepadWriterHelper(this);

        DestructorUtil.addManagerDestructor(this);
    }

    public static ApplicationManager getInstance() throws MalformedURLException, InterruptedException {
        if (applicationManagerThreadLocal.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            applicationManagerThreadLocal.set(newInstance);
        }
        return applicationManagerThreadLocal.get();
    }

    public WiniumDriver getDriver() {
        return driver;
    }

    public NotepadHelperBase getHelperBase() {
        return helperBase;
    }

    public NotepadReaderHelper getReaderHelper() {
        return readerHelper;
    }

    public NotepadWriterHelper getWriterHelper() {
        return writerHelper;
    }
}
