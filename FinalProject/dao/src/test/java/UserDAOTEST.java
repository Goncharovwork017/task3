import by.nc.dev3.dao.utils.HibernateUtil;
import by.nc.dev3.entities.Roles;
import by.nc.dev3.entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public class UserDAOTEST {



        @Test
        public void getUserListTEST(){
            Session session= HibernateUtil.getHibernateUtil().getSession();
            Criteria criteria = session.createCriteria(User.class);
            List list = criteria.list();
            List<User> allUser = new ArrayList<User>();
            allUser.addAll(list);
            System.out.println("Список получен");
            for(User user : allUser){
                System.out.println(user);
            }
            HibernateUtil.getHibernateUtil().closeSession();
        }

    @Test
    public void deleteUserTEST() {
        Session session = HibernateUtil.getHibernateUtil().getSession();
        session.beginTransaction();
        Criteria criteria=session.createCriteria(User.class);
        criteria.add(Restrictions.eq("UserID","3"));
        User user=(User)criteria.uniqueResult();
        System.out.println(user);
        session.delete(user);
        System.out.println("User удалён.");
        session.getTransaction().commit();
        HibernateUtil.getHibernateUtil().closeSession();

    }


    @Test
    public void getUserByIdTEST() {
        Session session = HibernateUtil.getHibernateUtil().getSession();
        Criteria criteria=session.createCriteria(User.class);
        criteria.add(Restrictions.eq("UserID","1"));
        User user=(User)criteria.uniqueResult();
        if (user==null){
            System.out.println("User не существует.");
            return;
        }
        System.out.println("User существует.");
        System.out.println(user);
        HibernateUtil.getHibernateUtil().closeSession();
    }




        @Test
        public void addTest () {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            session.beginTransaction();
            User user = null;
            user = new User("Goncharov", "Ivan", "qwerty", "qwerty", 1);
            session.save(user);
            session.getTransaction().commit();
            HibernateUtil.getHibernateUtil().closeSession();

        }

    }

