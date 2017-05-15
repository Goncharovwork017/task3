package service.impl;

import abstracts.AbstractService;
import dao.IUserDAO;
import dao.impl.UserDAOHibernate;
import entities.User;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import service.IUserService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 14.05.2017.
 */
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private IUserDAO userDAO = new UserDAOHibernate(User.class);
   // private UserDAOHibernate userDAOHibernate = new UserDAOHibernate(User.class);

    @Override
    public User getByLogin(String login) {
        User user;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            user = userDAO.getByLogin(login);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(login);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return user;
    }

    @Override
    public boolean isAuthorized(String login, String password) {
        boolean isAuthorized = false;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            isAuthorized = userDAO.isAuthorized(login, password);
            transaction.commit();
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(login + password);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return isAuthorized;
    }


    @Override
    public List<User> getAll() {
        List<User> users;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            users = userDAO.getAll();
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(users);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return users;
    }

    @Override
    public Serializable save(User entity) {
        Serializable id;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            id = userDAO.save(entity);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(entity);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return id;
    }

    @Override
    public User getById(int id) {
        User user;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            user = userDAO.getById(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(user);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return user;
    }

    @Override
    public void update(User entity) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            userDAO.update(entity);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(entity);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    public void delete(int id) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            userDAO.delete(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(id);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }
}
