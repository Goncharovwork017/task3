package by.nc.dev3.finalproject.service;

import by.nc.dev3.finalproject.entities.AbstractEntity;
import by.nc.dev3.finalproject.exceptions.ServiceException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 08.05.2017.
 */
public interface IDAOService<T extends AbstractEntity> {
    List<T> getAll() throws ServiceException;
    Serializable save(T entity) throws ServiceException;
    T getById(int id) throws ServiceException;
    void update(T entity) throws ServiceException;
    void delete(int id) throws ServiceException;
}
