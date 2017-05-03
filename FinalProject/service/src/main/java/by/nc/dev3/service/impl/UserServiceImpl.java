package by.nc.dev3.service.impl;

import by.nc.dev3.dao.UserDAO;
import by.nc.dev3.entities.Roles;
import by.nc.dev3.entities.User;
import by.nc.dev3.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */

public class UserServiceImpl implements UserService<User> {

    private UserDAO userDAO;

    @Transactional
    public void create(User user) throws SQLException {
        userDAO.create(user);
    }
    @Transactional
    public void delete(User user) throws SQLException {
        userDAO.delete(user);
    }
    @Transactional
    public void update(User user) throws SQLException {
        userDAO.update(user);
    }
    @Transactional
    public User find(int id) {
        return null;
    }
    @Transactional
    public List<User> findAll() throws SQLException {
       return userDAO.findAll();
    }
}
