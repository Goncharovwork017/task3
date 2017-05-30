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
import org.springframework.transaction.annotation.Transactional;
import utils.EntityBuilder;
import utils.HibernateUtil;

import java.io.Serializable;


/**
 * Created by ivan on 02.05.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-dao-context.xml")
@Transactional(transactionManager = "transactionManager")
public class UserDAOTEST {

    @Autowired
    private UserDAOHibernate userDAOHibernate;
    private User expectedUser;
    private User actualUser;
    private int id;





    @Before
    public void buildEntity() throws Exception
    {
        expectedUser = EntityBuilder.buildUser("BaHbk0","1111","Ivan","Goncharov", EntityBuilder.buildRoles(RolesType.STUDENT));
        save();
    }

    @Test
    public void testGetByLogin() throws Exception {
        expectedUser.setId(id);
        actualUser = userDAOHibernate.getByLogin(expectedUser.getLogin());
        Assert.assertEquals("getByLogin() method failed: ", expectedUser, actualUser);
        delete();
    }





    @Test
    public void testSave() throws Exception
    {
        actualUser = userDAOHibernate.getById(id);
        Assert.assertEquals("save() method failed: ", expectedUser, actualUser);
        expectedUser.setId(id);
        delete();

    }




    @Test
    public void testIsAuthorized() throws Exception {
        expectedUser.setId(id);
        Boolean flag = userDAOHibernate.isAuthorized(expectedUser.getLogin(), expectedUser.getPassword());
        System.out.println(flag);
        Assert.assertTrue("IsAuthorized() method failed: ", flag);
        delete();
    }

    @Test
    public void testGetAll() throws Exception {
        for(User user : userDAOHibernate.getAll())
            System.out.println(user);
    }

    @Test
    public void testGetById() throws Exception {
        save();
        expectedUser.setId(id);
        actualUser = userDAOHibernate.getById(id);
        Assert.assertEquals("getById() method failed: ", expectedUser, actualUser);

        delete();
    }

    @Test
    public void testUpdate() throws Exception {
        expectedUser.setId(id);
        expectedUser.setLogin("update");
        userDAOHibernate.update(expectedUser);
        actualUser = userDAOHibernate.getById(id);
        Assert.assertEquals("update() method failed: ", expectedUser, actualUser);
        delete();
    }

    @Test
    public void testDelete() throws Exception {
        delete();
        actualUser = userDAOHibernate.getById(id);
        Assert.assertNull("delete() method failed: ", actualUser);
    }

    @After
    public void commitReset() throws Exception{
        expectedUser = null;
        actualUser = null;
        id = 0;
    }



    private void save() throws Exception {
        id = userDAOHibernate.save(expectedUser);
    }

    private void delete() throws Exception {
        userDAOHibernate.delete(id);
    }
}


