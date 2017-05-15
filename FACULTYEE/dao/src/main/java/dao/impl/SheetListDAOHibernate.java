package dao.impl;


import abstracts.AbstractDAO;
import dao.ISheetListDAO;
import entities.SheetList;


/**
 * Created by ivan on 02.05.2017.
 */
public class SheetListDAOHibernate extends AbstractDAO<SheetList> implements ISheetListDAO {


    public SheetListDAOHibernate(Class<SheetList> persistentClass) {
        super(persistentClass);
    }
}
