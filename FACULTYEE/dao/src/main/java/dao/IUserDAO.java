package dao;


import entities.Roles;
import entities.User;
import exceptions.DAOUnException;

/**
 * Created by ivan on 02.05.2017.
 */
public interface IUserDAO extends IDAO<User> {

    User getByLogin(String login) throws DAOUnException;
    boolean isAuthorized(String login, String password) throws DAOUnException;
    boolean hasSameLogin(String login);
    Roles getRoles(String userRoles);

}
