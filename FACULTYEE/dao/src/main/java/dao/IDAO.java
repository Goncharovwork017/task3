package dao;



import entities.AbstractEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 03.05.2017.
 */
public interface IDAO <T extends AbstractEntity> {

    List<T> getAll();

    Serializable save(T entity);

    T getById(int id);

    void update(T entity);

    void delete(int id);
}
