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
@Transactional
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
    public List<SheetList> findStudentWithEndedCourse(int courseId) {
        List<SheetList> sheetList;
        try{
            sheetList = sheetListDAO.findStudentWithEndedCourse(courseId);

        } catch (DAOUnException e) {
            logger.error(TRANSACTION_FAILED, e);

            throw new ServiceException(TRANSACTION_FAILED + e);
        }

        return sheetList;
    }

}

