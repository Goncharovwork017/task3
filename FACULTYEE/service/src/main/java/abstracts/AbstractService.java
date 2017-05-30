package abstracts;

import dao.IDAO;
import entities.AbstractEntity;
import entities.User;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import service.IService;
import utils.HibernateUtil;

import java.io.Serializable;
import java.util.List;

import static constants.ServiceConstants.TRANSACTION_FAILED;
import static constants.ServiceConstants.TRANSACTION_SUCCEEDED;

/**
 * Created by ivan on 14.05.2017.
 */
@Transactional
public abstract class AbstractService<T extends AbstractEntity> implements IService<T> {


    private static Logger logger = Logger.getLogger(AbstractService.class);
    private IDAO<T> dao;

   protected AbstractService(IDAO<T> dao){this.dao = dao;}






    @Override
    @Transactional
    public List<T> getAll() {
        List<T> users = null;
        try {
            users = dao.getAll();
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
    public int save(T entity) {
        int id = 0;

        try {

            id = dao.save(entity);

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
    public T getById(int id) {
        T user = null;

        try {

            user = dao.getById(id);
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
    public T update(T entity) {

        try {
            dao.update(entity);

            return entity;

        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    @Transactional
    public T delete(int id) {

        try {
            T user = getById(id);
            dao.delete(id);
            return user;

        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }
}
