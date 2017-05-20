import dao.impl.UserDAOHibernate;
import entities.User;
import enums.RolesType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.*;
import utils.EntityBuilder;
import utils.HibernateUtil;

import java.io.Serializable;


/**
 * Created by ivan on 02.05.2017.
 */
public class UserDAOTEST {
    private static UserDAOHibernate userDAOHibernate;
    private static HibernateUtil util;
    private static Session session;
    private User expectedUser;
    private User actualUser;
    private Serializable UserID;
    private Transaction transaction;

    @BeforeClass
    public static void initTest(){
     //   userDAOHibernate = new UserDAOHibernate(User.class);
        util = HibernateUtil.getInstance();
        session = util.getSession();
    }


    @Before
    public void buildEntity() throws Exception
    {
        expectedUser = EntityBuilder.buildUser("BaHbk0","1111","Ivan","Goncharov", EntityBuilder.buildRoles(RolesType.STUDENT));
        transaction = session.beginTransaction();

    }

    @Test
    public void testSave() throws Exception
    {
        save();
        actualUser = userDAOHibernate.getById((int) UserID);
        Assert.assertEquals("save() method failed: ", expectedUser, actualUser);
        expectedUser.setId((int) UserID);
        delete();

    }

    @Test
    public void testGetByLogin() throws Exception {
        save();
        expectedUser.setId((int) UserID);
        actualUser = userDAOHibernate.getByLogin(expectedUser.getLogin());
        Assert.assertEquals("getByLogin() method failed: ", expectedUser, actualUser);
        delete();
    }


    @Test
    public void testIsAuthorized() throws Exception {
        save();
        expectedUser.setId((int) UserID);
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
        expectedUser.setId((int) UserID);
        actualUser = userDAOHibernate.getById((int) UserID);
        Assert.assertEquals("getById() method failed: ", expectedUser, actualUser);

        delete();
    }

    @Test
    public void testUpdate() throws Exception {
        save();
        expectedUser.setId((int) UserID);
        expectedUser.setLogin("update");
        userDAOHibernate.update(expectedUser);
        actualUser = userDAOHibernate.getById((int) UserID);
        Assert.assertEquals("update() method failed: ", expectedUser, actualUser);
        delete();
    }

    @Test
    public void testDelete() throws Exception {
        save();
        delete();
        actualUser = userDAOHibernate.getById((int) UserID);
        Assert.assertNull("delete() method failed: ", actualUser);
    }

    @After
    public void commitReset() throws Exception{
        transaction.commit();
        expectedUser = null;
        actualUser = null;
        UserID = null;
        transaction = null;
    }



    private void save() throws Exception {
        UserID = userDAOHibernate.save(expectedUser);
    }

    private void delete() throws Exception {
        userDAOHibernate.delete((int) UserID);
    }
}


