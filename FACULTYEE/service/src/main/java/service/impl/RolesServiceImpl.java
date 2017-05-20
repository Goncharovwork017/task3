package service.impl;

import abstracts.AbstractService;
import dao.*;
import dao.impl.RolesDAOHibernate;
import entities.Roles;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.IRolesService;

import java.io.Serializable;
import java.util.List;

import static constants.ServiceConstants.*;

/**
 * Created by ivan on 14.05.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DAOUnException.class)
public class RolesServiceImpl  extends AbstractService<Roles> implements IRolesService {

    //TODO - ну ты и корч
    private static Logger logger = Logger.getLogger(RolesServiceImpl.class);


    @Autowired
    private IRolesDAO rolesDAO;


    @Autowired
    protected RolesServiceImpl(IRolesDAO rolesDAO) {
        super(rolesDAO);
        this.rolesDAO = rolesDAO;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Roles> getAll() {

        List<Roles> roles;

        try {
            roles = rolesDAO.getAll();
        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);

            throw new ServiceException(TRANSACTION_FAILED + e);
        }

        return roles;
    }



    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Serializable save(Roles entity) {
        Serializable id;
        try {

            id = rolesDAO.save(entity);
        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return id;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Roles getById(int id) {
        Roles roles;

        try {
            roles = rolesDAO.getById(id);
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(roles);
        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }


        return roles;

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Roles update(Roles entity) {
        try {
            rolesDAO.update(entity);
            return entity;
        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Roles delete(int id) {
        try {
            Roles roles = getById(id);
            rolesDAO.delete(id);
            return roles;

        }
        catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }

    }
}
