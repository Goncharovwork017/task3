package service.impl;

import abstracts.AbstractService;
import dao.IDAO;
import dao.IRolesDAO;
import dao.IUserDAO;
import dao.impl.UserDAOHibernate;
import entities.Roles;
import entities.User;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.IUserService;

import java.io.Serializable;
import java.util.List;

import static constants.ServiceConstants.*;

/**
 * Created by ivan on 14.05.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DAOUnException.class)
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDAO userDAO;

    private static List<User> users;

    @Autowired
    public UserServiceImpl(IUserDAO userDAO) {
        super(userDAO);
        this.userDAO = userDAO;
    }


    // private UserDAOHibernate userDAOHibernate = new UserDAOHibernate(User.class);

    @Override
    @Transactional
    public User getByLogin(String login) {
        User user;

        try {
            user = userDAO.getByLogin(login);

        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return user;
    }


    @Override
    @Transactional
    public boolean hasSameLogin(String login) {
         boolean hasSameLogin = false;
         try{
             hasSameLogin = userDAO.hasSameLogin(login);
         }
         catch (DAOUnException e){
             logger.error(TRANSACTION_FAILED, e);
             throw new ServiceException(TRANSACTION_FAILED + e);
         }
        return hasSameLogin;
    }

    @Override
    public Roles getRoles(String userRoles) {
        return userDAO.getRoles(userRoles);
    }


    @Override
    @Transactional
    public boolean isAuthorized(String login, String password) {
        boolean isAuthorized = false;

        try {

            isAuthorized = userDAO.isAuthorized(login, password);

        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return isAuthorized;
    }

    @Override
    @Transactional
    public User findByLogin(String login) {
        for(User user : users){
            if(user.getLogin().equalsIgnoreCase(login)){
                return user;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public boolean isUserExist(User user) {
        return findByLogin(user.getLogin())!=null;
    }




    @Override
    @Transactional
    public List<User> getAll() {
        List<User> users;
        try {
            users = userDAO.getAll();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(users);
        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return users;
    }


    @Override
    @Transactional
    public Serializable save(User entity) {
        Serializable id;

        try {

            id = userDAO.save(entity);

            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(entity);
        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return id;
    }

    @Override
    @Transactional
    public User getById(int id) {
        User user;

        try {

            user = userDAO.getById(id);
;
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(user);
        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return user;
    }

    @Override
    @Transactional
    public User update(User entity) {

        try {
            userDAO.update(entity);

            return entity;

        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    @Transactional
    public User delete(int id) {

        try {
            User user = getById(id);
            userDAO.delete(id);
            return user;

        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }
}
