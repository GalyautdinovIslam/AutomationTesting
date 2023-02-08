package ru.itis.tsvetaev.helpers;

import org.openqa.selenium.By;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.basic.NotepadHelperBase;
import ru.itis.tsvetaev.models.Line;
import ru.itis.tsvetaev.models.jaxb.Lines;

public class NotepadWriterHelper extends NotepadHelperBase {

    private final NotepadReaderHelper readerHelper;

    public NotepadWriterHelper(ApplicationManager applicationManager) {
        super(applicationManager);
        readerHelper = applicationManager.getReaderHelper();
    }

    public void writeLine(Line line) {
        String before = readerHelper.readAll();
        driver.findElement(By.id(EDITOR_ID)).sendKeys(before + line.getLine() + "\n");
    }

    public void replace(int index, Line line) {
        Lines lines = readerHelper.readLines();
        clearAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lines.getLines().size(); i++) {
            if (i != index) stringBuilder.append(lines.getLines().get(i).getLine());
            else stringBuilder.append(line.getLine());
            stringBuilder.append("\n");
        }
        writeLine(new Line(stringBuilder.toString()));
    }

    public void delete(int index) {
        Lines lines = readerHelper.readLines();
        clearAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lines.getLines().size(); i++) {
            if (i != index) {
                stringBuilder.append(lines.getLines().get(i).getLine());
                stringBuilder.append("\n");
            }
        }
        writeLine(new Line(stringBuilder.toString()));
    }
}
