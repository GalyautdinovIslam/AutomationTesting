package ru.itis.tsvetaev.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import ru.itis.tsvetaev.basic.VkTestBase;
import ru.itis.tsvetaev.generators.Generator;
import ru.itis.tsvetaev.models.UserData;
import ru.itis.tsvetaev.models.jaxb.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Theories.class)
public class VkValidAuthorizationTest extends VkTestBase {

    @DataPoints
    public static List<UserData> usersFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(Generator.DIRECTORY + "/valid_users.xml"));
            return users.getUsers();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    @Theory
    public void authorizationTestCase(UserData user) throws Exception {
        applicationManager.getNavigationHelper().openVkPage();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getHelperBase().sleep(3);

        Assert.assertTrue(applicationManager.getLoginHelper().isAuthorized());
        Assert.assertEquals(user.getPath(), applicationManager.getLoginHelper().getAuthorizedUserPath());

        applicationManager.getLoginHelper().logout();
    }
}
