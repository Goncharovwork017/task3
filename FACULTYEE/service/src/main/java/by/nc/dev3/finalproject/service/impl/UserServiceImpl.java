package by.nc.dev3.finalproject.service.impl;

import by.nc.dev3.finalproject.abstracts.AbstractService;
import by.nc.dev3.finalproject.dao.impl.UserDAOHibernate;
import by.nc.dev3.finalproject.entities.User;
import by.nc.dev3.finalproject.exceptions.DAOUnException;
import by.nc.dev3.finalproject.exceptions.ServiceException;
import by.nc.dev3.finalproject.service.UserService;

import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */

public class UserServiceImpl extends AbstractService<User> implements UserService{

    private UserDAOHibernate userDAOHibernate = new UserDAOHibernate(User.class);


    public List<User> getAll() throws ServiceException {
        List<User> users;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            users = userDAOHibernate.getAll();
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return users;
    }

    public Serializable save(User entity) throws ServiceException {
        Serializable id;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            id = userDAOHibernate.save(entity);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return id;
    }

    public User getById(int id) throws ServiceException {
        User user;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            user = userDAOHibernate.getById(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return user;
    }

    public void update(User entity) throws ServiceException {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            userDAOHibernate.update(entity);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    public void delete(int id) throws ServiceException {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            userDAOHibernate.delete(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    public User getByLogin(String login) throws ServiceException {
        User user;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            user = userDAOHibernate.getByLogin(login);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return user;
    }

    public boolean isAuthorized(String login, String password) throws ServiceException {
        boolean isAuthorized = false;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            isAuthorized = userDAOHibernate.isAuthorized(login, password);
            transaction.commit();
        }
         catch (DAOUnException e) {
                transaction.rollback();
                throw new ServiceException(TRANSACTION_FAILED + e);
            }
            return isAuthorized;
        }
}
