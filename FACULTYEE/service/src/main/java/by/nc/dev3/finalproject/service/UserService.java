package by.nc.dev3.finalproject.service;

import by.nc.dev3.finalproject.entities.User;
import by.nc.dev3.finalproject.exceptions.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public interface UserService extends IDAOService<User>{

    User getByLogin(String login) throws ServiceException;
    boolean isAuthorized(String login, String password) throws ServiceException;





}
