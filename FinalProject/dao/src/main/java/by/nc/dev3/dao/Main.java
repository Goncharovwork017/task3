package by.nc.dev3.dao;

import by.nc.dev3.dao.utils.HibernateUtil;
import by.nc.dev3.entities.Roles;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 03.05.2017.
 */
public class Main {
    public static void main(String args[]) throws SQLException {
      //  UserDAO userDAO = new UserDAO(User.class);
       // List<User> results6 = userDAO.findAll();
      //  results6.forEach(user -> System.out.println(user));

        RolesDAO roleDao = new RolesDAO() {
            @Override
            public void create(Roles roles) {

            }

            @Override
            public void delete(Roles roles) {

            }

            @Override
            public void update(Roles roles) {

            }

            @Override
            public Roles find(int id) {
                return null;
            }

            @Override
            public List<Roles> findAll() {
                List<Roles> rolesList = (List<Roles>) HibernateUtil.getHibernateUtil().getSession().createQuery("from Roles").list();
                return rolesList;
            }
        };
        List<Roles> results2 = roleDao.findAll();
        results2.forEach(role -> System.out.println(role));
        results2.stream().findFirst().get().getUserList().forEach(e -> System.out.println(e));

    }
}

