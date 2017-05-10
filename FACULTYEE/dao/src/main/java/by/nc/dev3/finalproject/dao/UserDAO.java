package by.nc.dev3.finalproject.dao;


import by.nc.dev3.finalproject.exceptions.DAOUnException;
import by.nc.dev3.finalproject.entities.User;

/**
 * Created by ivan on 02.05.2017.
 */
public interface UserDAO extends IDAO<User> {

    User getByLogin(String login) throws DAOUnException;
    boolean isAuthorized(String login, String password) throws DAOUnException;


}
