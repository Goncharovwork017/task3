package by.nc.dev3.finalproject.dao.impl;

import by.nc.dev3.finalproject.abstracts.AbstractDAO;
import by.nc.dev3.finalproject.dao.SheetListDAO;
import by.nc.dev3.finalproject.entities.SheetList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public class SheetListDAOHibernate extends AbstractDAO<SheetList> implements SheetListDAO {


    public SheetListDAOHibernate(Class<SheetList> persistentClass) {
        super(persistentClass);
    }
}
