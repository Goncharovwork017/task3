package by.nc.dev3.dao.impl;

import by.nc.dev3.dao.UserDAO;
import by.nc.dev3.dao.exceptions.DAOUncheckedException;
import by.nc.dev3.dao.utils.HibernateUtil;
import by.nc.dev3.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public class UserDAOHibernate implements UserDAO {
    // Session session = HibernateUtil.getHibernateUtil().getSession();


    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public void create(User user)  {
        getSession().save(user);
    }

    public void delete(User user) {
        getSession().delete(user);
    }

    public void update(User user) {
        getSession().update(user);
    }

    public User find(int id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll()  {
        List<User> userList = (List<User>) getSession().createQuery("from User").list();
        return userList;
    }

    public User findByLogin(String login) {
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            Query query = session.createQuery("from User user where user.login = :login");
            query.setParameter("login", login);
            return (User) query.getSingleResult();
        } catch (Exception e) {
            throw new DAOUncheckedException(e);
        }
    }


}
