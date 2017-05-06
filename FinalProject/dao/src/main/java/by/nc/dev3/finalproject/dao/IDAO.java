package by.nc.dev3.finalproject.dao;

import by.nc.dev3.finalproject.exceptions.DAOUncheckedException;
import by.nc.dev3.finalproject.entities.AbstractEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 03.05.2017.
 */
public interface IDAO <T extends AbstractEntity> {

    List<T> getAll();

    void save(T entity);

    T getById(int id);

    void update(T entity);

    void delete(int id);
}
