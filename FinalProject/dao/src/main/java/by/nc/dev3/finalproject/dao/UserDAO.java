package by.nc.dev3.finalproject.dao;


import by.nc.dev3.finalproject.exceptions.DAOUncheckedException;
import by.nc.dev3.finalproject.entities.User;

/**
 * Created by ivan on 02.05.2017.
 */
public interface UserDAO extends IDAO<User> {

    User getByLogin(String login) throws DAOUncheckedException;
    User isAuthorized(String login, String password) throws DAOUncheckedException;


}
