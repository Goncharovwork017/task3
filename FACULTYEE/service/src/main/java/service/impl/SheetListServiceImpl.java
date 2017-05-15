package service.impl;

import abstracts.AbstractService;
import dao.ISheetListDAO;
import dao.impl.SheetListDAOHibernate;
import entities.SheetList;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import service.ISheetListService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 14.05.2017.
 */
public class SheetListServiceImpl extends AbstractService<SheetList> implements ISheetListService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private ISheetListDAO sheetListDAO = new SheetListDAOHibernate(SheetList.class);


    @Override
    public List<SheetList> getAll() {

        List<SheetList> sheetLists;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            sheetLists = sheetListDAO.getAll();
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(sheetLists);
        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            transaction.rollback();

            throw new ServiceException(TRANSACTION_FAILED + e);
        }

        return sheetLists;
    }

    @Override
    public Serializable save(SheetList entity) {

        Serializable id;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            id = sheetListDAO.save(entity);
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
    public SheetList getById(int id) {
        SheetList sheetList;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            sheetList = sheetListDAO.getById(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(sheetList);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return sheetList;
    }

    @Override
    public void update(SheetList entity) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            sheetListDAO.update(entity);
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
            sheetListDAO.delete(id);
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

