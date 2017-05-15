package service.impl;

import abstracts.AbstractService;
import dao.ICourseDAO;
import dao.impl.CourseDAOHibernate;
import entities.Course;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import service.ICourseService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 14.05.2017.
 */
public class CourseServiceImpl  extends AbstractService<Course> implements ICourseService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private ICourseDAO courseDAO = new CourseDAOHibernate(Course.class);


    @Override
    public List<Course> getAll() {
        List<Course> courses;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            courses = courseDAO.getAll();
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(courses);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return courses;
    }

    @Override
    public Serializable save(Course entity) {
        Serializable id;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            id = courseDAO.save(entity);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(entity);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return id;
    }

    @Override
    public Course getById(int id) {

        Course course;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            course = courseDAO.getById(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(course);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }

        return course;
    }

    @Override
    public void update(Course entity) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            courseDAO.update(entity);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(entity);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    public void delete(int id) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            courseDAO.delete(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(id);
        }
        catch (DAOUnException e) {
            transaction.rollback();
            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }
}
