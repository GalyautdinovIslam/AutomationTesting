package ru.itis.tsvetaev.generators;

import ru.itis.tsvetaev.models.Line;
import ru.itis.tsvetaev.models.jaxb.Lines;
import ru.itis.tsvetaev.utils.StringUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Generator {
    public static final String DIRECTORY = "/C:/Users/galya/OneDrive/Рабочий стол/AutoIT/output";

    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        if (Objects.equals(type, "line")) GenerateForLines(count, filename, format);
        else throw new IllegalArgumentException("Unrecognized type of data: " + type);
    }

    private static void GenerateForLines(int count, String filename, String format) {
        List<Line> lines = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            lines.add(new Line(StringUtil.getRandomString(5, 18)));
        }
        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(DIRECTORY + "/" + filename + "." + format)) {
                writeLinesToXmlFile(lines, fileWriter);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    private static void writeLinesToXmlFile(List<Line> lineList, FileWriter fileWriter) {
        try {
            Lines lines = new Lines();
            lines.setLines(lineList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Lines.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(lines, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
