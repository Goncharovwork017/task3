package by.nc.dev3.finalproject.dao.impl;

import by.nc.dev3.finalproject.abstracts.AbstractDAO;
import by.nc.dev3.finalproject.dao.UserDAO;
import by.nc.dev3.finalproject.exceptions.DAOUncheckedException;
import by.nc.dev3.finalproject.entities.User;
import org.hibernate.Session;

import javax.persistence.Query;

/**
 * Created by ivan on 02.05.2017.
 */
public class UserDAOHibernate extends AbstractDAO<User> implements UserDAO {


    public UserDAOHibernate(Class<User> persistentClass) {
        super(persistentClass);
    }

    @Override
    public User getByLogin(String login) throws DAOUncheckedException {
        try {
            Session session = hibernateUtil.getSession();
            Query query = session.createQuery("from User user where user.login = :login");
            query.setParameter("login", login);
            return (User) query.getSingleResult();
        } catch (Exception e) {
            throw new DAOUncheckedException("Unable to return login.");
        }
    }

    @Override
    public User isAuthorized(String login, String password) throws DAOUncheckedException {
        try{
            Session session = hibernateUtil.getSession();
            Query query = session.createQuery("from User user where  user.login = :login and user.password = :password");
            query.setParameter("login",login);
            query.setParameter("password",password);
            return (User) query.getSingleResult();
        } catch (Exception e){
            throw new DAOUncheckedException("Unable authorization");
        }
    }


}
