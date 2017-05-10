package by.nc.dev3.finalproject.dao.impl;

import by.nc.dev3.finalproject.abstracts.AbstractDAO;
import by.nc.dev3.finalproject.dao.CourseDAO;
import by.nc.dev3.finalproject.entities.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public class CourseDAOHibernate extends AbstractDAO<Course> implements CourseDAO {

    public CourseDAOHibernate(Class<Course> persistentClass) {
        super(persistentClass);
    }
}
