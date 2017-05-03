package by.nc.dev3.dao;

import by.nc.dev3.entities.Roles;
import by.nc.dev3.entities.User;

import java.util.List;

/**
 * Created by ivan on 03.05.2017.
 */
public interface RolesDAO {


    void create(Roles roles);
    void delete(Roles roles);
    void update(Roles roles);
    Roles find(int id);
    List<Roles> findAll();


}
