package dao.impl;


import abstracts.AbstractDAO;
import constants.Queries;
import dao.IUserDAO;
import exceptions.DAOUnException;
import entities.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * Created by ivan on 02.05.2017.
 */

@Component
public class UserDAOHibernate extends AbstractDAO<User> implements IUserDAO {

    private static final Logger logger = Logger.getLogger(UserDAOHibernate.class);

    @Autowired
    public UserDAOHibernate(SessionFactory sessionFactory) {
        super(User.class,sessionFactory);
    }

    @Override
    public User getByLogin(String login) {
        User user;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.GET_BY_LOGIN);
            query.setParameter("login", login);
            user  = (User) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Unable to return login." +e);
            throw new DAOUnException("Unable to return login." +e);
        }
        return user;
    }

    @Override
    public boolean isAuthorized(String login, String password) throws DAOUnException {
        boolean isLogIn = false;
        try{
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.CHECK_AUTHORIZATION);
            query.setParameter("login",login);
            query.setParameter("password",password);
            if (query.uniqueResult() != null) {
                isLogIn = true;
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            logger.error("Unable to check authorization. Error was thrown in DAO: " +e);
            throw new DAOUnException("Unable to check authorization. Error was thrown in DAO: " + e);
        }
        return isLogIn;
    }


}
