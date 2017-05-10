package by.nc.dev3.finalproject.abstracts;

import by.nc.dev3.finalproject.dao.IDAO;
import by.nc.dev3.finalproject.entities.AbstractEntity;
import by.nc.dev3.finalproject.exceptions.DAOUnException;
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
        Transaction transaction = null;
        try {
            Session session = hibernateUtil.getSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery criteria = builder.createQuery(persistentClass);
            criteria.select(criteria.from(persistentClass));
            Query q = session.createQuery(criteria);
            results = q.list();
        } catch (Exception e) {
            throw new DAOUnException("Error was thrown in DAO");
        }
        return results;
    }

    @Override
    public Serializable save(T entity) {
        Serializable id;
        Transaction transaction = null;
        try {
            Session session = hibernateUtil.getSession();

            transaction = session.beginTransaction();

            session.save(entity);
            id = session.getIdentifier(entity);
         //  transaction.commit();
        }
        catch(HibernateException e) {
            throw new DAOUnException(e + "Error was thrown in DAO");
        }
        return id;
    }

//    public Serializable save(User entity) throws ServiceException {
//        Serializable id;
//        Session session = hibernateUtil.getSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            id = userDAOHibernate.save(entity);
//            transaction.commit();
//            System.out.println(TRANSACTION_SUCCEEDED);
//        }
//        catch (DAOUnException e) {
//            transaction.rollback();
//            throw new ServiceException(TRANSACTION_FAILED + e);
//        }
//        return id;
//    }








    @Override
    public T getById(int id) {
        T entity;
        try {
            Session session = hibernateUtil.getSession();
            entity = (T)session.get(persistentClass, id);
        }
        catch(HibernateException e){
            throw new DAOUnException("Error was thrown in DAO");
        }
        return entity;
    }

    @Override
    public void update(T entity) {
       // Transaction transaction = null;
        try {
            Session session = hibernateUtil.getSession();
         //   transaction = session.beginTransaction();

            session.update(entity);
         //   transaction.commit();
        }
        catch(HibernateException e) {
            throw new DAOUnException("Error was thrown in DAO");
        }
    }

    @Override
    public void delete(int id) {
      //  Transaction transaction = null;
        try {
            Session session = hibernateUtil.getSession();
//            transaction = session.beginTransaction();
            T entity = (T) session.get(persistentClass, id);
            session.delete(entity);
         //   transaction.commit();
        }
        catch(HibernateException e){
            throw new DAOUnException("Error was thrown in DAO");
        }
    }




    public AbstractDAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        hibernateUtil = HibernateUtil.getInstance();
    }
}
