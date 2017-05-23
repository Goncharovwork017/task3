package dao.impl;


import abstracts.AbstractDAO;
import constants.Queries;
import dao.ISheetListDAO;
import entities.SheetList;
import exceptions.DAOUnException;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by ivan on 02.05.2017.
 */
@Repository
public class SheetListDAOHibernate extends AbstractDAO<SheetList> implements ISheetListDAO {

    private static final Logger logger = Logger.getLogger(SheetListDAOHibernate.class);


    @Autowired
    public SheetListDAOHibernate(SessionFactory sessionFactory) {
        super(SheetList.class,sessionFactory);
    }

    @Override
    public List<SheetList> findStudentWithEndedCourse(int courseId) {
        List<SheetList> sheetList;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.FIND_ALL_STUDENT_FOR_COURSE);
            query.setParameter("courseid", courseId);
            // courseList = (List<Course>) query.uniqueResult();
            sheetList = (List<SheetList>) query.uniqueResult();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Unable to return course." +e);
            throw new DAOUnException("Unable to return course." +e);
        }
        return sheetList;
    }
}
