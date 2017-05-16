package dao.impl;


import abstracts.AbstractDAO;
import dao.IRolesDAO;
import entities.Roles;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by ivan on 03.05.2017.
 */


@Repository
public class RolesDAOHibernate extends AbstractDAO<Roles> implements IRolesDAO {


    @Autowired
    private RolesDAOHibernate(SessionFactory sessionFactory){
        super(Roles.class, sessionFactory);
    }
}
