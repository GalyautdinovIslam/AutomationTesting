package ru.itis.tsvetaev.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.itis.tsvetaev.basic.VkTestBase;
import ru.itis.tsvetaev.generators.Generator;
import ru.itis.tsvetaev.models.UserData;
import ru.itis.tsvetaev.models.jaxb.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Parameterized.class)
public class VkInvalidAuthorizationTest extends VkTestBase {

    @Parameterized.Parameter
    public UserData user;

    @Parameterized.Parameters(name = "User")
    public static List<UserData> usersFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(Generator.DIRECTORY + "/invalid_users.xml"));
            return users.getUsers();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    public void authorizationTestCase() throws Exception {
        applicationManager.getLoginHelper().login(user);
        applicationManager.getHelperBase().sleep(3);

        Assert.assertFalse(applicationManager.getLoginHelper().isAuthorized());
        Assert.assertTrue(applicationManager.getLoginHelper().isNotAuthorized());
    }
}
