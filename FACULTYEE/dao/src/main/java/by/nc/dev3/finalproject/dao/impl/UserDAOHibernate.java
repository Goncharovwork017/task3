package by.nc.dev3.finalproject.dao.impl;

import by.nc.dev3.finalproject.abstracts.AbstractDAO;
import by.nc.dev3.finalproject.dao.UserDAO;
import by.nc.dev3.finalproject.exceptions.DAOUnException;
import by.nc.dev3.finalproject.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Query;

/**
 * Created by ivan on 02.05.2017.
 */
public class UserDAOHibernate extends AbstractDAO<User> implements UserDAO {


    public UserDAOHibernate(Class<User> persistentClass) {
        super(persistentClass);
    }

    @Override
    public User getByLogin(String login) {
        User user;
        try {
            Session session = hibernateUtil.getSession();
            Query query = session.createQuery("from User  where login = :login");
            query.setParameter("login", login);
            user  = (User) query.getSingleResult();
        } catch (Exception e) {
            throw new DAOUnException("Unable to return login.");
        }
        return user;
    }

    @Override
    public boolean isAuthorized(String login, String password) throws DAOUnException {
        boolean isLogIn = false;
        try{
            Session session = hibernateUtil.getSession();
            Query query = session.createQuery("from User  where  login = :login and password = :password");
            query.setParameter("login",login);
            query.setParameter("password",password);
            if (query.uniqueResult() != null) {
                isLogIn = true;
            }
        } catch (HibernateException e) {
            throw new DAOUnException("Unable to check authorization. Error was thrown in DAO: ");
        }
        return isLogIn;
    }


}
