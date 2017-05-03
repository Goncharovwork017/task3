package by.nc.dev3.service.impl;

import by.nc.dev3.dao.CourseDAO;
import by.nc.dev3.entities.Course;
import by.nc.dev3.service.CourseService;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public class CourseServiceImpl implements CourseService<Course> {

    CourseDAO courseDAO;


    public void create(Course course) throws SQLException {
        courseDAO.create(course);
    }

    public void delete(Course course) throws SQLException {
        courseDAO.delete(course);
    }

    public void update(Course course) throws SQLException {
        courseDAO.update(course);
    }

    public Course find(int id) {
        return null;
    }

    public List<Course> findAll() throws SQLException {
        return courseDAO.findAll();
    }
}
