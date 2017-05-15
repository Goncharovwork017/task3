package service.impl;

import abstracts.AbstractService;
import dao.IRolesDAO;
import dao.impl.RolesDAOHibernate;
import entities.Roles;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import service.IRolesService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 14.05.2017.
 */
public class RolesServiceImpl  extends AbstractService<Roles> implements IRolesService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private IRolesDAO rolesDAO = new RolesDAOHibernate(Roles.class);

    @Override
    public List<Roles> getAll() {

        List<Roles> roles;

        Session session =  hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            roles = rolesDAO.getAll();

            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(roles);
        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }

        return roles;
    }



    @Override
    public Serializable save(Roles entity) {


        Serializable id;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            id = rolesDAO.save(entity);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(entity);

        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return id;
    }

    @Override
    public Roles getById(int id) {
        Roles roles;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            roles = rolesDAO.getById(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(roles);
        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }


        return roles;

    }

    @Override
    public void update(Roles entity) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            rolesDAO.update(entity);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(entity);
        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    public void delete(int id) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            rolesDAO.delete(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(id);
        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }

    }
}
