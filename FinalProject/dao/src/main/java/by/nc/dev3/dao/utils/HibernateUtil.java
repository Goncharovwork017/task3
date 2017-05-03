package by.nc.dev3.dao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Created by ivan on 02.05.2017.
 */
public class HibernateUtil {
    private volatile static HibernateUtil instance = null;
    private SessionFactory sessionFactory = null;
    private final ThreadLocal<Session> sessions = new ThreadLocal<Session>();

    private HibernateUtil() {
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    public static synchronized HibernateUtil getHibernateUtil() {
        if (instance == null) {
            synchronized (HibernateUtil.class) {
                if (instance == null) {
                    instance = new HibernateUtil();
                }
            }
        }
        return instance;
    }




    public Session getSession() {
        Session session = sessions.get();
        if (session == null) {
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    public void closeSession() {
        Session session = HibernateUtil.getHibernateUtil().getSession();
        if (session != null && session.isOpen()) {
            session.close();
            sessions.set(null);
        }
    }
}
