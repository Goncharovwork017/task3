package utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by ivan on 02.05.2017.
 */
public class HibernateUtil {

    private static HibernateUtil hibernateUtil;
    private SessionFactory sessionFactory;
    private final ThreadLocal<Session> sessions = new ThreadLocal<>();

    private HibernateUtil() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("+++++++++++++++++++++++++++++++"+sessionFactory);
        } catch (Throwable e) {
            System.out.println("()");
            System.out.println(e.getMessage());

            System.out.println("()");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static HibernateUtil getInstance() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
        }
        return hibernateUtil;
    }

    public Session getSession() {
        Session session = sessions.get();
        if (session == null) {
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    public void releaseSession(Session session) {
        if (session != null) {
            try {
                session.close();
                sessions.remove();
            } catch (HibernateException e) {
            }
        }
    }
}