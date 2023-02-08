package ru.itis.tsvetaev.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.itis.tsvetaev.basic.VkAuthBase;
import ru.itis.tsvetaev.generators.Generator;
import ru.itis.tsvetaev.models.PostData;
import ru.itis.tsvetaev.models.jaxb.Posts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Parameterized.class)
public class VkPostCreationTest extends VkAuthBase {

    @Parameterized.Parameter
    public PostData post;


    @Parameterized.Parameters(name = "Post")
    public static List<PostData> postsFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Posts.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Posts posts = (Posts) unmarshaller.unmarshal(new File(Generator.DIRECTORY + "/posts.xml"));
            return posts.getPosts();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    public void postCreationTestCase() throws Exception {
        applicationManager.getPostHelper().createPost(post);
        applicationManager.getHelperBase().sleep(3);

        PostData createdPost = applicationManager.getPostHelper().getLastPost();
        Assert.assertEquals(post.getContent(), createdPost.getContent());
        Assert.assertTrue(System.currentTimeMillis() / 1000 - createdPost.getTime() < 10);
    }
}
