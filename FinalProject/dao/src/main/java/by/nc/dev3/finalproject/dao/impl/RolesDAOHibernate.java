package by.nc.dev3.finalproject.dao.impl;

import by.nc.dev3.finalproject.abstracts.AbstractDAO;
import by.nc.dev3.finalproject.dao.IDAO;
import by.nc.dev3.finalproject.dao.RolesDAO;
import by.nc.dev3.finalproject.utils.HibernateUtil;
import by.nc.dev3.finalproject.entities.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ivan on 03.05.2017.
 */
public class RolesDAOHibernate extends AbstractDAO<Roles> implements RolesDAO {


    public RolesDAOHibernate(Class<Roles> persistentClass) {
        super(persistentClass);
    }
}
