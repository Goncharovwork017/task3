package by.nc.dev3.finalproject.service.impl;

import by.nc.dev3.finalproject.abstracts.AbstractService;
import by.nc.dev3.finalproject.dao.CourseDAO;
import by.nc.dev3.finalproject.entities.Course;
import by.nc.dev3.finalproject.service.CourseService;
import by.nc.dev3.finalproject.service.IDAOService;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {


    public List<Course> getAll() {
        return null;
    }

    public Serializable save(Course entity) {
        return null;
    }

    public Course getById(int id) {
        return null;
    }

    public void update(Course entity) {

    }

    public void delete(int id) {

    }
}
