package dao.impl;


import abstracts.AbstractDAO;
import dao.ICourseDAO;
import entities.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by ivan on 02.05.2017.
 */

@Repository
public class CourseDAOHibernate extends AbstractDAO<Course> implements ICourseDAO {

    @Autowired
    private CourseDAOHibernate(SessionFactory sessionFactory){
        super(Course.class, sessionFactory);
    }
}
