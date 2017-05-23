package service.impl;

import abstracts.AbstractService;
import dao.*;
import dao.impl.CourseDAOHibernate;
import entities.Course;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.ICourseService;

import java.io.Serializable;
import java.util.List;

import static constants.ServiceConstants.TRANSACTION_FAILED;
import static constants.ServiceConstants.TRANSACTION_SUCCEEDED;

/**
 * Created by ivan on 14.05.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DAOUnException.class)
public class CourseServiceImpl  extends AbstractService<Course> implements ICourseService {

    private static Logger logger = Logger.getLogger(CourseServiceImpl.class);

    @Autowired
    private ICourseDAO courseDAO;
    @Autowired
    protected CourseServiceImpl(ICourseDAO courseDAO) {
        super(courseDAO);
        this.courseDAO = courseDAO;
    }




    @Override
    @Transactional
    public Serializable save(Course entity) {
        Serializable id;

        try {

            id = courseDAO.save(entity);


            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(entity);
        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return id;
    }

    @Override
    @Transactional
    public Course getById(int id) {

        Course course;

        try {

            course = courseDAO.getById(id);

        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }

        return course;
    }

    @Override
    @Transactional
    public Course update(Course entity) {

        try {
            courseDAO.update(entity);
            return entity;

        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    @Transactional
    public Course delete(int id) {

        try {
            Course course = getById(id);
            courseDAO.delete(id);
            return course;

        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    @Transactional
    public List<Course> getAll() {
        List<Course> courses;

        try {

            courses = courseDAO.getAll();


            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(courses);
        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return courses;
    }






    @Override
    @Transactional
    public List<Course> findAvailableCourse(String login) {
        List<Course> courses;
        try{
            courses = courseDAO.findAvailableCourse(login);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(courses);
        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return courses;
    }

    @Override
    @Transactional
    public List<Course> findCurrentCoursesForStudents(String login) {
        List<Course> courses;
        try{
            courses = courseDAO.findCurrentCoursesForStudents(login);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(courses);
        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return courses;
    }

    @Override
    @Transactional
    public List<Course> findCourseWithTeacher(int id) {
        List<Course> courses;
        try{
            courses = courseDAO.findCourseWithTeacher(id);
            logger.info(TRANSACTION_SUCCEEDED);
            logger.info(courses);
        }
        catch (DAOUnException e) {

            logger.error(TRANSACTION_FAILED,e);
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return courses;
    }
}
