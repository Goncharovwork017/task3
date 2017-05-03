package by.nc.dev3.dao.impl;

import by.nc.dev3.dao.CourseDAO;
import by.nc.dev3.entities.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public class CourseDAOHibernate implements CourseDAO {

    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public void create(Course course) throws SQLException {
        getSession().saveOrUpdate(course);
    }

    public void delete(Course course) throws SQLException {
        getSession().delete(course);
    }

    public void update(Course course) throws SQLException {
        getSession().saveOrUpdate(course);

    }

    public Course find(int id) {
        return null;
    }

    public List<Course> findAll() throws SQLException {
        List<Course> courseList = (List<Course>) getSession().createQuery("from Course");
        return courseList;
    }
}
