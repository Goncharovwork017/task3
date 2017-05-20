package abstracts;


import dao.IDAO;
import entities.AbstractEntity;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.HibernateUtil;

import java.io.Serializable;
import java.util.List;



/**
 * Created by ivan on 03.05.2017.
 */

@SuppressWarnings("unchecked")
public abstract class AbstractDAO <T extends AbstractEntity> implements IDAO<T> {


    private static Logger logger = Logger.getLogger(AbstractDAO.class);


    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> persistentClass;

    public AbstractDAO(Class<T> persistentClass,SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
    }



    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> getAll() {
        List<T> results;

        try {
            Session session = getCurrentSession();
            Criteria criteria = session.createCriteria(persistentClass);
            results = criteria.list();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            logger.error("Error was thrown in DAO" + e);
            throw new DAOUnException();
        }
        return results;
    }

    @Override
    public Serializable save(T entity) {
        Serializable id;
        try {
            Session session = getCurrentSession();
            session.saveOrUpdate(entity);
            id = session.getIdentifier(entity);
        }
        catch(HibernateException e) {
            System.out.println(e.getMessage());
            logger.error("Error was thrown in DAO" + e);
            throw new DAOUnException();
        }
        return id;
    }

    @Override
    public T getById(int id) {
        T entity;
        try {
            Session session = getCurrentSession();
            entity = (T)session.get(persistentClass, id);
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            logger.error("Error was thrown in DAO" + e);
            throw new DAOUnException();
        }
        return entity;
    }

    @Override
    public void update(T entity) {
        try {
            Session session = getCurrentSession();
            session.update(entity);
        }
        catch(HibernateException e) {
            System.out.println(e.getMessage());
            logger.error("Error was thrown in DAO" + e);
            throw new DAOUnException();
        }
    }

    @Override
    public void delete(int id) {

        try {
            Session session = getCurrentSession();
            T entity = (T) session.get(persistentClass, id);
            session.delete(entity);
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            logger.error("Error was thrown in DAO" + e);
            throw new DAOUnException();
        }
    }





}
