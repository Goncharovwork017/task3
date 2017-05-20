package dao.impl;


import abstracts.AbstractDAO;
import dao.ISheetListDAO;
import entities.SheetList;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by ivan on 02.05.2017.
 */
@Repository
public class SheetListDAOHibernate extends AbstractDAO<SheetList> implements ISheetListDAO {

    @Autowired
    public SheetListDAOHibernate(SessionFactory sessionFactory) {
        super(SheetList.class,sessionFactory);
    }
}
