package by.nc.dev3.dao.impl;

import by.nc.dev3.dao.RolesDAO;
import by.nc.dev3.dao.utils.HibernateUtil;
import by.nc.dev3.entities.Roles;
import by.nc.dev3.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ivan on 03.05.2017.
 */
public class RolesDAOHibernate implements RolesDAO {

    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public void create(Roles roles) {
        getSession().save(roles);
    }

    public void delete(Roles roles) {
        getSession().delete(roles);
    }

    public void update(Roles roles) {
        getSession().update(roles);
    }

    public Roles find(int id) {
        return null;
    }

    public List<Roles> findAll() {
        List<Roles> rolesList = (List<Roles>) HibernateUtil.getHibernateUtil().getSession().createQuery("from Roles").list();
        return rolesList;
    }
}
