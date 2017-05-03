package by.nc.dev3.dao;

import by.nc.dev3.entities.Course;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public interface CourseDAO {

    void create(Course course) throws SQLException;
    void delete(Course course) throws SQLException;
    void update(Course course) throws SQLException;
    Course find(int id);
    List<Course> findAll() throws SQLException;
}
