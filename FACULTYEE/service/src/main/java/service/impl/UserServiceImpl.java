package service.impl;

import abstracts.AbstractService;
import dao.IUserDAO;
import entities.Roles;
import entities.User;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.IUserService;

import java.util.List;

import static constants.ServiceConstants.*;

/**
 * Created by ivan on 14.05.2017.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private IUserDAO userDAO;

    private static List<User> users;

    @Autowired
    public UserServiceImpl(IUserDAO userDAO) {
        super(userDAO);
        this.userDAO = userDAO;
    }


    // private UserDAOHibernate userDAOHibernate = new UserDAOHibernate(User.class);

    @Override
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
    public User findByLogin(String login) {
        for(User user : users){
            if(user.getLogin().equalsIgnoreCase(login)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean isUserExist(User user) {
        return findByLogin(user.getLogin())!=null;
    }






}
