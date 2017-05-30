import dao.impl.UserDAOHibernate;
import entities.User;
import enums.RolesType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IUserService;
import utils.EntityBuilder;
import utils.HibernateUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 09.05.2017.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "test-services-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-services-context.xml")
public class UserServiceTEST {


    @Autowired
    private static IUserService userService;
    private User expectedUser;
    private User actualUser;
    private int id;



    @Before
    public void buildEntity() throws Exception {
        expectedUser = EntityBuilder.buildUser("bahk", "1111", "Ivan", "Goncharov", EntityBuilder.buildRoles(RolesType.ADMIN));
        save();
    }

    @Test
    public void testGetByLogin() throws Exception {
        expectedUser.setId(id);
        actualUser = userService.getByLogin(expectedUser.getLogin());
        Assert.assertEquals("getByLogin() method failed: ", expectedUser, actualUser);
        delete();
    }

    @Test
    public void testIsAuthorized() throws Exception {
        expectedUser.setId(id);
        Boolean flag = userService.isAuthorized(expectedUser.getLogin(), expectedUser.getPassword());
        Assert.assertTrue("IsAuthorized() method failed: ", flag);
        delete();
    }

    @Test
    public void testSave() throws Exception {
        actualUser = userService.getById(id);
        Assert.assertEquals("save() method failed: ", expectedUser, actualUser);
        expectedUser.setId(id);
        delete();
    }

    @Test
    public void testGetAll() throws Exception {
        expectedUser.setId(id);
        List<User> listUserActual = userService.getAll();
        List<User> listUserExpected = new ArrayList<User>();
        listUserExpected.add(expectedUser);
        Assert.assertFalse("getAll() method failed", listUserActual.contains(listUserExpected));
        delete();
    }

    @Test
    public void testGetById() throws Exception {
        expectedUser.setId(id);
        actualUser = userService.getById(id);
        Assert.assertEquals("getById() method failed: ", expectedUser, actualUser);
        delete();
    }


    @Test
    public void testUpdate() throws Exception {
        expectedUser.setId(id);
        expectedUser.setLogin("update");
        userService.update(expectedUser);
        actualUser = userService.getById(id);
        Assert.assertEquals("update() method failed: ", expectedUser, actualUser);
        delete();
    }

    @Test
    public void testDelete() throws Exception {
        delete();
        actualUser = userService.getById(id);
        Assert.assertNull("delete() method failed: ", actualUser);
    }

    @After
    public void commitReset() throws Exception{

        expectedUser = null;
        actualUser = null;
        id = 0;

    }

    private void save() throws Exception {
        id = userService.save(expectedUser);
    }

    private void delete() throws Exception {
        userService.delete(id);
    }
}
