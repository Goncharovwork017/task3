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
import java.util.Set;

import static constants.ServiceConstants.*;

/**
 * Created by ivan on 14.05.2017.
 */
@Service
@Transactional
public class RolesServiceImpl  extends AbstractService<Roles> implements IRolesService {

    private static Logger logger = Logger.getLogger(RolesServiceImpl.class);


    @Autowired
    private IRolesDAO rolesDAO;


    @Autowired
    protected RolesServiceImpl(IRolesDAO rolesDAO) {
        super(rolesDAO);
        this.rolesDAO = rolesDAO;
    }

    @Override
    public Set<Roles> getRolesById(int id) {
        Set<Roles> roles;
        try{
            roles = rolesDAO.getRolesById(id);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(roles);
        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return roles;
    }
}
