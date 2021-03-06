package service;

import entities.Roles;
import entities.User;

/**
 * Created by ivan on 14.05.2017.
 */
public interface IUserService extends IService<User> {

    User getByLogin(String login);
    boolean isAuthorized(String login, String password);
    User findByLogin(String login);
    boolean isUserExist(User user);
    boolean hasSameLogin(String login);
    Roles getRoles(String userRoles);


}
