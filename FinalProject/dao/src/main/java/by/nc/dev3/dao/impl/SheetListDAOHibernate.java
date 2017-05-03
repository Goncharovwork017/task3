package by.nc.dev3.dao.impl;

import by.nc.dev3.dao.SheetListDAO;
import by.nc.dev3.entities.SheetList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public class SheetListDAOHibernate implements SheetListDAO {

    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public void create(SheetList sheetList) throws SQLException {
        getSession().save(sheetList);
    }

    public void delete(SheetList sheetList) throws SQLException {
        getSession().delete(sheetList);
    }

    public void update(SheetList sheetList) throws SQLException {
        getSession().update(sheetList);

    }

    public SheetList find(int id) {
        return null;
    }

    public List<SheetList> findAll() throws SQLException {
        List<SheetList> sheetLists =  (List<SheetList>) getSession().createQuery("from SheetList").list();
        return sheetLists;
    }
}
