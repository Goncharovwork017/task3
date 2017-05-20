package service.impl;

import abstracts.AbstractService;
import dao.*;
import dao.impl.SheetListDAOHibernate;
import entities.SheetList;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.ISheetListService;

import java.io.Serializable;
import java.util.List;

import static constants.ServiceConstants.*;

/**
 * Created by ivan on 14.05.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DAOUnException.class)
public class SheetListServiceImpl extends AbstractService<SheetList> implements ISheetListService {
    private static Logger logger = Logger.getLogger(SheetListServiceImpl.class);


    @Autowired
    private ISheetListDAO sheetListDAO;


    @Autowired
    public SheetListServiceImpl(ISheetListDAO sheetListDAO) {
        super(sheetListDAO);
        this.sheetListDAO = sheetListDAO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<SheetList> getAll() {

        List<SheetList> sheetLists;

        try {
            sheetLists = sheetListDAO.getAll();

        } catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);

            throw new ServiceException(TRANSACTION_FAILED + e);
        }

        return sheetLists;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Serializable save(SheetList entity) {

        Serializable id;

        try {
            id = sheetListDAO.save(entity);
        } catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return id;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public SheetList getById(int id) {
        SheetList sheetList;

        try {

            sheetList = sheetListDAO.getById(id);

        } catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return sheetList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public SheetList update(SheetList entity) {
        try {
            sheetListDAO.update(entity);
            return entity;
        } catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public SheetList delete(int id) {
        try {
            SheetList list = getById(id);
            sheetListDAO.delete(id);
            return list;
        } catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }

    }
}

