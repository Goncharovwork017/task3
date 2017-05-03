package by.nc.dev3.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public interface CourseService <E extends Serializable> {

    void create(E entity) throws SQLException;
    void delete(E entity) throws SQLException;
    void update(E entity) throws SQLException;
    E find(int id);
    List<E> findAll() throws SQLException;
}
