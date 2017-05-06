package by.nc.dev3.finalproject.utils;

import by.nc.dev3.finalproject.entities.Roles;
import by.nc.dev3.finalproject.entities.User;

/**
 * Created by ivan on 03.05.2017.
 */
public class EntityBuilder {
    private EntityBuilder(){}


    public static User buildUser(String login, String pass, String name, String surname, Roles roles){
        User user = new User();
        user.setFirstName(name);
        user.setLastName(surname);
        user.setLogin(login);
        user.setPassword(pass);
        user.setRoles(roles);
        return user;
    }

    public static Roles buildRoles(String name){
        Roles roles = new Roles();
        roles.setRoles(name);
        return roles;
    }

}
