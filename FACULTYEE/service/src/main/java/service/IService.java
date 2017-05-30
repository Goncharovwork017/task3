package service;

import entities.AbstractEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 14.05.2017.
 */
public interface IService<T extends AbstractEntity> {
    List<T> getAll() ;
    int save(T entity);
    T getById(int id);
    T update(T entity);
    T delete(int id);
}
