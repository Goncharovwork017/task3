package by.nc.dev3.dao;


import by.nc.dev3.entities.User;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public interface UserDAO {

    void create(User user);
    void delete(User user);
    void update(User user);
    User find(int id);
    List<User> findAll();

    User findByLogin(String login);


}
