package ru.itis.tsvetaev.helpers;

import org.openqa.selenium.By;
import ru.itis.tsvetaev.ApplicationManager;
import ru.itis.tsvetaev.basic.NotepadHelperBase;
import ru.itis.tsvetaev.models.Line;
import ru.itis.tsvetaev.models.jaxb.Lines;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class NotepadReaderHelper extends NotepadHelperBase {

    public NotepadReaderHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public String readAll() {
        return driver.findElement(By.id(EDITOR_ID)).getText().replaceAll("\r", "");
    }

    public Lines readLines() {
        Lines lines = new Lines();
        lines.setLines(Arrays.stream(readAll().split("\n"))
                .filter(Objects::nonNull)
                .filter(x -> x.length() > 0)
                .map(Line::new)
                .collect(Collectors.toList()));
        return lines;
    }

    public Line readLastLine() {
        return readLines().getLines().get(readLines().getLines().size() - 1);
    }

    public Line readLine(int index) {
        return readLines().getLines().get(index);
    }

    public int count() {
        return readLines().getLines().size();
    }
}
