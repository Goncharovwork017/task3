//import dao.impl.UserDAOHibernate;
//import entities.User;
//import enums.RolesType;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.junit.*;
//import utils.EntityBuilder;
//import utils.HibernateUtil;
//
//import java.io.Serializable;
//
///**
// * Created by ivan on 09.05.2017.
// */
//public class UserServiceTEST {
//    private static UserDAOHibernate userDAOHibernate;
//    private static HibernateUtil util;
//    private static Session session;
//    private User expectedUser;
//    private User actualUser;
//    private Serializable userId;
//    private Transaction transaction;
//
//    @BeforeClass
//    public static void initTest(){
//        userDAOHibernate = new UserDAOHibernate(User.class);
//        util = HibernateUtil.getInstance();
//        session = util.getSession();
//    }
//
//    @Before
//    public void buildEntity() throws Exception {
//        expectedUser = EntityBuilder.buildUser("bahk", "1111", "Ivan", "Goncharov", EntityBuilder.buildRoles(RolesType.ADMIN));
//        transaction = session.beginTransaction();
//    }
//
//    @Test
//    public void testGetByLogin() throws Exception {
//        save();
//        expectedUser.setId((Integer) userId);
//        actualUser = userDAOHibernate.getByLogin(expectedUser.getLogin());
//        Assert.assertEquals("getByLogin() method failed: ", expectedUser, actualUser);
//        delete();
//    }
//
//    @Test
//    public void testIsAuthorized() throws Exception {
//        save();
//        expectedUser.setId((Integer) userId);
//        Boolean flag = userDAOHibernate.isAuthorized(expectedUser.getLogin(), expectedUser.getPassword());
//        System.out.println(flag);
//        Assert.assertTrue("IsAuthorized() method failed: ", flag);
//        delete();
//    }
//
//    @Test
//    public void testSave() throws Exception {
//        save();
//        actualUser = userDAOHibernate.getById((Integer) userId);
//        Assert.assertEquals("save() method failed: ", expectedUser, actualUser);
//        expectedUser.setId((Integer) userId);
//        delete();
//    }
//
//    @Test
//    public void testGetAll() throws Exception {
//        for(User user : userDAOHibernate.getAll())
//            System.out.println(user);
//    }
//
//    @Test
//    public void testGetById() throws Exception {
//        save();
//        expectedUser.setId((Integer) userId);
//        actualUser = userDAOHibernate.getById((Integer) userId);
//        Assert.assertEquals("getById() method failed: ", expectedUser, actualUser);
//        delete();
//    }
//
//
//    @Test
//    public void testUpdate() throws Exception {
//        save();
//        expectedUser.setId((Integer) userId);
//        expectedUser.setLogin("update");
//        userDAOHibernate.update(expectedUser);
//        actualUser = userDAOHibernate.getById((Integer) userId);
//        Assert.assertEquals("update() method failed: ", expectedUser, actualUser);
//        delete();
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        save();
//        delete();
//        actualUser = userDAOHibernate.getById((Integer) userId);
//        Assert.assertNull("delete() method failed: ", actualUser);
//    }
//
//    @After
//    public void commitReset() throws Exception{
//        transaction.commit();
//        expectedUser = null;
//        actualUser = null;
//        userId = null;
//        transaction = null;
//    }
//
//    private void save() throws Exception {
//        userId = userDAOHibernate.save(expectedUser);
//    }
//
//    private void delete() throws Exception {
//        userDAOHibernate.delete((Integer) userId);
//    }
//}
