package dao.impl;


import abstracts.AbstractDAO;
import dao.IRolesDAO;
import entities.Roles;


/**
 * Created by ivan on 03.05.2017.
 */

public class RolesDAOHibernate extends AbstractDAO<Roles> implements IRolesDAO {


    public RolesDAOHibernate(Class<Roles> persistentClass) {
        super(persistentClass);
    }
}
