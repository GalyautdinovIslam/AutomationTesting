package ru.itis.tsvetaev.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.itis.tsvetaev.basic.NotepadTestBase;
import ru.itis.tsvetaev.generators.Generator;
import ru.itis.tsvetaev.models.Line;
import ru.itis.tsvetaev.models.jaxb.Lines;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Parameterized.class)
public class NotepadAddLineTest extends NotepadTestBase {

    @Parameterized.Parameter
    public Line line;

    @Parameterized.Parameters(name = "Line")
    public static List<Line> linesFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Lines.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Lines lines = (Lines) unmarshaller.unmarshal(new File(Generator.DIRECTORY + "/lines.xml"));
            return lines.getLines();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    public void addLineTest() {
        applicationManager.getWriterHelper().writeLine(line);
        Assert.assertEquals(line.getLine(), applicationManager.getReaderHelper().readLastLine().getLine());
    }
}
