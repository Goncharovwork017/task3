package by.nc.dev3.finalproject.abstracts;

import by.nc.dev3.finalproject.dao.IDAO;
import by.nc.dev3.finalproject.entities.AbstractEntity;
import by.nc.dev3.finalproject.exceptions.DAOUncheckedException;
import by.nc.dev3.finalproject.utils.HibernateUtil;
import org.hibernate.*;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;


/**
 * Created by ivan on 03.05.2017.
 */
public abstract class AbstractDAO <T extends AbstractEntity> implements IDAO<T> {

    protected HibernateUtil hibernateUtil;
    private Class<T> persistentClass;

    @Override
    public List<T> getAll() {
        List<T> results;
        try {
            Session session = hibernateUtil.getSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery criteria = builder.createQuery(persistentClass);
            criteria.select(criteria.from(persistentClass));
            Query q = session.createQuery(criteria);
            results = q.list();
        } catch (Exception e) {
            throw new DAOUncheckedException("Error was thrown in DAO");
        }
        return results;
    }

    @Override
    public void save(T entity) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
        catch(HibernateException e) {
            transaction.rollback();
            throw new DAOUncheckedException("Error was thrown in DAO");
        }
    }

    @Override
    public T getById(int id) {
        T entity;
        try {
            Session session = hibernateUtil.getSession();
            entity = (T)session.get(persistentClass, id);
        }
        catch(HibernateException e){
            throw new DAOUncheckedException("Error was thrown in DAO");
        }
        return entity;
    }

    @Override
    public void update(T entity) {
        try {
            Session session = hibernateUtil.getSession();
            session.update(entity);
        }
        catch(HibernateException e) {
            throw new DAOUncheckedException("Error was thrown in DAO");
        }
    }

    @Override
    public void delete(int id) {
        try {
            Session session = hibernateUtil.getSession();
            T entity = (T) session.get(persistentClass, id);
            session.delete(entity);
        }
        catch(HibernateException e){
            throw new DAOUncheckedException("Error was thrown in DAO");
        }
    }




    public AbstractDAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        hibernateUtil = HibernateUtil.getInstance();
    }
}
