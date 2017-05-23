package dao.impl;


import abstracts.AbstractDAO;
import constants.Queries;
import dao.ICourseDAO;
import entities.Course;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ivan on 02.05.2017.
 */

@Repository
public class CourseDAOHibernate extends AbstractDAO<Course> implements ICourseDAO {

    private static final Logger logger = Logger.getLogger(CourseDAOHibernate.class);


    @Autowired
    public CourseDAOHibernate(SessionFactory sessionFactory) {
        super(Course.class,sessionFactory);
    }

    @Override
    public List<Course> findAvailableCourse(String login) {
        List<Course> courseList;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.FIND_CHECK_COURSE);
            query.setParameter("login", login);
            courseList = (List<Course>) query.uniqueResult();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Unable to return course." +e);
            throw new DAOUnException("Unable to return course." +e);
        }
        return courseList;
    }

    @Override
    public List<Course> findCurrentCoursesForStudents(String login) {
        List<Course> courseList;
        try {
        Session session = getCurrentSession();
        Query query = session.createQuery(Queries.FIND_CURRENT_COURSE);
        query.setParameter("login", login);
        courseList = (List<Course>) query.uniqueResult();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Unable to return course." +e);
            throw new DAOUnException("Unable to return course." +e);
        }
        return courseList;
    }

    @Override
    public List<Course> findCourseWithTeacher(int id) {
        List<Course> courseList;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.GET_ALL_COURSE_WITH_TEACHER);
            query.setParameter("userid", id);
            courseList = (List<Course>) query.uniqueResult();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Unable to return course." +e);
            throw new DAOUnException("Unable to return course." +e);
        }
        return courseList;
    }
}
