package ru.itis.tsvetaev.generators;

import ru.itis.tsvetaev.models.PostData;
import ru.itis.tsvetaev.models.jaxb.Posts;
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
    public static final String SOURCE = "/C:/Users/galya/OneDrive/Рабочий стол/Generator/data";

    public static void main(String[] args) {
        System.out.println(SOURCE);
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        if (Objects.equals(type, "post")) GenerateForGroups(count, filename, format);
        else throw new IllegalArgumentException("Unrecognized type of data: " + type);
    }

    private static void GenerateForGroups(int count, String filename, String format) {
        List<PostData> posts = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            posts.add(new PostData(
                    StringUtil.getRandomString(5, 18),
                    null
            ));
        }
        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(SOURCE + "/" + filename + "." + format)) {
                writePostsToXmlFile(posts, fileWriter);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    static void writePostsToXmlFile(List<PostData> postDataList, FileWriter fileWriter) {
        try {
            Posts posts = new Posts();
            posts.setPosts(postDataList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Posts.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(posts, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
