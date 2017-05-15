package dao.impl;


import abstracts.AbstractDAO;
import dao.ICourseDAO;
import entities.Course;


/**
 * Created by ivan on 02.05.2017.
 */


public class CourseDAOHibernate extends AbstractDAO<Course> implements ICourseDAO {

    public CourseDAOHibernate(Class<Course> persistentClass) {
        super(persistentClass);
    }
}
